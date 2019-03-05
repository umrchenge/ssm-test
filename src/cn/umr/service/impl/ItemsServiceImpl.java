package cn.umr.service.impl;

import cn.umr.exception.CustomException;
import cn.umr.mapper.ItemsMapper;
import cn.umr.mapper.ItemsMapperCustom;
import cn.umr.po.Items;
import cn.umr.po.ItemsCustom;
import cn.umr.po.ItemsQueryVo;
import cn.umr.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 商品的业务层接口实现类
 * @author UMR丶晨哥
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    /**
     * 注入自定义mapper
     */
    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    /**
     * 注入逆向工程生成的mapper
     */
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom findItemsById(Integer id)throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        //对商品进行业务处理
        ItemsCustom itemsCustom = null;

        //将商品的属性值copy到商品扩展类中
        if (items!=null){
            itemsCustom =new ItemsCustom();
            BeanUtils.copyProperties(items,itemsCustom);
        }else {
            //判断商品是否为空，根据id没有查询到商品，抛出异常，提示用户商品信息不存在

                throw new CustomException("修改的商品信息不存在!");

        }

        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) {
    //添加业务校验，通常在service接口对关键参数进行校验
    //校验id是否为空，如果为空抛出异常

    //更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括大文本类型字段
    //updateByPrimaryKeyWithBLOBs要求必须转入id
        itemsCustom.setId(id);

        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);

    }


}
