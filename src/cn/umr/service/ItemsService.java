package cn.umr.service;

import cn.umr.po.ItemsCustom;
import cn.umr.po.ItemsQueryVo;

import java.util.List;

/**
 * 商品的业务层接口
 * @author UMR丶晨哥
 */
public interface ItemsService {
    /**
     * 商品查询列表
     * @param itemsQueryVo
     * @return
     * @throws Exception
     */
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

    /**
     *根据商品id查询商品
     * @param id 商品id
     * @return
     * @throws Exception
     */
    ItemsCustom findItemsById(Integer id) throws Exception;

    /**
     * 更新商品信息
     * @param id 商品id
     * @param itemsCustom 修改的商品信息
     */
    void updateItems(Integer id,ItemsCustom itemsCustom);
}
