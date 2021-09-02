package com.misiontic.orders_ms.models;

public class ProductOrder {

    private String idProduct;
    private Integer count;

    public ProductOrder(String idProduct, Integer count) {
        this.idProduct = idProduct;
        this.count = count;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


}
