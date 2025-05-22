package kr.ac.kopo.petshop.model;

import java.sql.Date;
import java.util.List;

public class Orders {
    
    private Long ordersId;  
    private String memberId;
    private Long designerId;
    private Long dog;
    private Date orderDate;
    private String shop;
    
    private List<Detail> details;
    
    public Long getOrdersId() {
        return ordersId;
    }
    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public Long getDesignerId() {
        return designerId;
    }
    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }
    public Long getDog() {
        return dog;
    }
    public void setDog(Long dog) {
        this.dog = dog;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getShop() {
        return shop;
    }
    public void setShop(String shop) {
        this.shop = shop;
    }
    
    public List<Detail> getDetails() {
        return details;
    }
    
    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
