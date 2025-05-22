package kr.ac.kopo.petshop.model;

public class Detail {
    private Long detailId;
    private String memberId;
    private Long ordersId; 
    private int amount;
    private Long productId;
    
    public Long getDetailId() {
        return detailId;
    }
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public Long getOrdersId() {
        return ordersId;  
    }
    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;  
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
