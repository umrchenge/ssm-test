package cn.umr.controller;

import cn.umr.po.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Json测试类
 * @author UMR丶晨哥
 * @version 1.0
 * @date 2018/12/11 17:06
 */
@Controller
@RequestMapping("jsonTest")
public class JsonTest {

    /**
     * 请求Json输出Json
     * 请求j son串（商品信息），输出json（商品信息）
     * RequestBody将请求的商品信息的json串转成itemsCustom对象
     * ResponseBody将itemsCustom转成json输出
     */
    @RequestMapping("/requestJson")
    public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
        return itemsCustom;
    }
    /**
     * 请求Key/value输出Json
     * 请求json串（商品信息），输出json（商品信息）
     * RequestBody将请求的商品信息的json串转成itemsCustom对象
     * ResponseBody将itemsCustom转成json输出
     */
    @RequestMapping("/responseJson")
    public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){

        return itemsCustom;
    }
}
