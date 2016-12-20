package com.代码优化.查询条件对象;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/19 0019.
 * 如果查询条件多变，可以创建一个查询条件对象
 */
public class ProductQuery{

    /*******查询数量********/
//    private boolean ;

    /*******条件*******/
    private String      name;
    private boolean     nameLike;
    private Integer     storeId;
    private String      categoryLayer;
    private boolean     categoryLayerLike;
    private Double      startPrice;
    private Double      endPrice;
    private Integer     state;

    /*******order by******/
    public class FieldOrder{
        private String field;
        private String order;

        public FieldOrder(String field, String order) {
            this.field = field;
            this.order = order;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    // order集合
    private List<FieldOrder> fieldOrders = new ArrayList<FieldOrder>();

    public void orderById(boolean isAsc){
        fieldOrders.add(new FieldOrder("id",isAsc==true?"asc":"desc"));
    }

    public void orderBySellCount(boolean isAsc){
        fieldOrders.add(new FieldOrder("sell_count",isAsc==true?"asc":"desc"));
    }

    public void orderBySellPrice(boolean isAsc){
        fieldOrders.add(new FieldOrder("sell_price",isAsc==true?"asc":"desc"));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Double endPrice) {
        this.endPrice = endPrice;
    }

    public boolean isNameLike() {
        return nameLike;
    }

    public void setNameLike(boolean nameLike) {
        this.nameLike = nameLike;
    }

    public List<FieldOrder> getFieldOrders() {
        return fieldOrders;
    }

    public void setFieldOrders(List<FieldOrder> fieldOrders) {
        this.fieldOrders = fieldOrders;
    }

    public String getCategoryLayer() {
        return categoryLayer;
    }

    public void setCategoryLayer(String categoryLayer) {
        this.categoryLayer = categoryLayer;
    }

    public boolean isCategoryLayerLike() {
        return categoryLayerLike;
    }

    public void setCategoryLayerLike(boolean categoryLayerLike) {
        this.categoryLayerLike = categoryLayerLike;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
