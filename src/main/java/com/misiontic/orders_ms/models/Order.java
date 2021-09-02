package com.misiontic.orders_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Order {
    @Id
    private String id;
    private String idUser;
    private List<ProductOrder> products;
    private Integer total;
    private Date dateOrder;


    public Order(String id, String idUser, List<ProductOrder> products, Integer total, Date dateOrder) {
        this.id = id;
        this.idUser = idUser;
        this.products = products;
        this.total = total;
        this.dateOrder = dateOrder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> products) {
        this.products = products;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }
}