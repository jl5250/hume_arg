package cn.edu.cqu.cht.model;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:47
 */
public class CourierOrder {
    //id
    private Integer courierId;

    //订单号
    private String orderId;

    //工资
    private Double salary;

    //
    private Short orderState;

    //时间
    private String time;


    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Short getOrderState() {
        return orderState;
    }

    public void setOrderState(Short orderState) {
        this.orderState = orderState;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
