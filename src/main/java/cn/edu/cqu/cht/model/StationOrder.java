package cn.edu.cqu.cht.model;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 21:17
 */
public class StationOrder {
    //快递站id
    private Integer stationId;

    //订单id
    private String orderId;

    //工资
    private Double salary;
    private Short orderState;

    //时间
    private String time;

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
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
