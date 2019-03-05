package cn.umr.mapper;

import cn.umr.po.Items;
import cn.umr.po.ItemsCustom;
import cn.umr.po.ItemsExample;
import cn.umr.po.ItemsQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemsMapperCustom {
    /**
     * 商品查询列表
     * @param itemsQueryVo
     * @return
     * @throws Exception
     */
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}