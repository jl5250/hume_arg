package cn.edu.cqu.cht.model;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:47
 */
public class Courier {//快递员
    //id
    private Integer courierId;

    //姓名
    private String courierName;

    //电话
    private String courierPhone;

    //省
    private String province;

    //市
    private String city;

    //区
    private String area;

    //相片
    private String picture;

    //快递站id
    private Integer stationId;


    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }
}
