package cn.umr.po;

import java.util.List;

/**
 * 商品包装类
 * @author UMR丶晨哥
 */
public class ItemsQueryVo {

    /**
    商品信息
     */
    private Items items;
    /**
     为了系统可扩展性，对原生态po进行扩展
     */
    private ItemsCustom itemsCustom;
    /**
     * 批量商品信息
     */
    private List<Items> itemsList;

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }
}
