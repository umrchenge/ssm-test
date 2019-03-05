package cn.umr.controller;

import cn.umr.controller.validation.ValidGroup1;
import cn.umr.po.Items;
import cn.umr.po.ItemsCustom;
import cn.umr.po.ItemsQueryVo;
import cn.umr.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 商品的Controller类
 * @author UMR丶晨哥
 */

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    /**
     * 商品分类
     * @return
     */
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemTypes(){

        Map<String, String> itemTypes = new HashMap<String,String>();
        itemTypes.put("101", "数码");
        itemTypes.put("102", "母婴");

        return itemTypes;
    }


    //商品查询列表
    //@RequestMapping实现对queryItems()方法和url进行映射，一个方法对应一个ur1
    //一般建议将url和方法写成一样
    @RequestMapping(value = "/queryItems",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {

        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        //创建modelAndView准备填充数据、设置视图
        ModelAndView modelAndView = new ModelAndView();
        //填充数据,相当于request的setAttribut，在jsp页面中通过itemsList来取数据
        modelAndView.addObject("itemsList",itemsList);
        //指定视图
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }

    @RequestMapping(value = "/editItemsQuery")
    public ModelAndView editItemsQuery(ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        //创建modelAndView准备填充数据、设置视图
        ModelAndView modelAndView = new ModelAndView();
        //填充数据,相当于request的setAttribut，在jsp页面中通过itemsList来取数据
        modelAndView.addObject("itemsList", itemsList);
        //指定视图
        modelAndView.setViewName("items/editItemsQuery");
        return modelAndView;
    }
//    /**
//     * 商品信息更新页面显示
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
//    public ModelAndView editItems()throws Exception {
//
//        //使用itemsService获得itemsCustom
//        ItemsCustom itemsCustom = itemsService.findItemsById(1);
//
//        //创建视图
//        ModelAndView modelAndView = new ModelAndView();
//        //设置显示页面
//        modelAndView.setViewName("items/editItems");
//        modelAndView.addObject("itemsCustom",itemsCustom);
//        //返回视图
//        return modelAndView;
//    }

    /**
     * 商品信息更新页面显示
     * @RequestParam(value = "id",required = true,defaultValue = "1"）value=要接受的参数名称，required=是否必须传参，就是value指定的 defaultValue=参数默认值
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
    public String editItems(Model model,@RequestParam(value = "id",required = true,defaultValue = "1") Integer items_id)throws Exception {
        //使用itemsService获得itemsCustom
        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);


        //通过形参中的model将mode1数据传到页面
        //相当于modelAndView.addObject方法
        model.addAttribute("itemsCustom",itemsCustom);
        return "items/editItems";
    }

    /**
     * 商品信息更新提交
     * @param model
     * @param id
     * @param items_pic 接收商品图片信息
     * @param request
     * @param itemsCustom
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editItemsSubmit",method = {RequestMethod.POST})
    public String  editItemsSubmit(Model model ,
                                   Integer id,
                                    MultipartFile items_pic,
                                   HttpServletRequest request,
                                   @ModelAttribute("itemsCustom")@Validated({ValidGroup1.class}) ItemsCustom itemsCustom,
                                   BindingResult bindingResult)throws Exception{
        //有错误信息时执行
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            //将错误信息传到页面
            model.addAttribute("allErrors",allErrors);
            //报错重新到修改页面
            return"items/editItems";
        }

        if (items_pic != null){
            //获取原始文件名
            String originalFilename = items_pic.getOriginalFilename();
            //判断文件名不为空，并且长度大于0才能上传成功
            if (originalFilename!=null && originalFilename.length()>0){
                //图片保存路径
                String realPath = "D:\\学习\\JAVA工作学习路径\\spring整合springMvc和mybatis\\web\\upload\\items";

                request.getServletContext().getRealPath("/upload/items");
                //新的图片名称
                String newFileName =  UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
                //新的图片
                File newFile = new File(realPath,newFileName);
                //将内存中的图片数据写入磁盘
                items_pic.transferTo(newFile);

                //将新图片名称写入ItemsCustom中
                itemsCustom.setPic(newFileName);
            }


        }

        itemsService.updateItems(id,itemsCustom);
        return "success";
    }
    /**
     * 测试void Handler
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("狒狒吔屎");
    }

    /**
     * 批量删除商品
     * @return
     */
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id)throws Exception{
        return "success";
    }

    /**
     * 批量修改
     * @param itemsQueryVo
     * @return
     */
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo){

        return "success";
    }

    /**
     * 查询商品信息，输出json
     * itemsView{id}里边的{id}表示将这个位置的参数传到@PathVariable指定名称中。
     * @param id
     * @return
     */
    @RequestMapping("/itemsView/{id}")
    public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id)throws Exception{
        ItemsCustom itemsCustom = itemsService.findItemsById(id);

        return itemsCustom;

    }
}
