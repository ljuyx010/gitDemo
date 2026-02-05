package net.dpwl.hellospringboot.entity;

/**
 * Orders实体类
 * 订单信息实体
 */
public class Orders {
    private Integer id;
    private String orderNumber;
    private String customerName;
    private Double amount;
    private String status;
    private String createTime;

    // 无参构造方法
    public Orders() {
    }

    // 带参构造方法
    public Orders(Integer id, String orderNumber, String customerName, Double amount, String status, String createTime) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
        this.createTime = createTime;
    }

    // Getter和Setter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}