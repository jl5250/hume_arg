package cn.edu.cqu.cht.model;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:48
 */
public class PlacePrice {
    private Integer id;

    //地域
    private String province;
    private String city;
    private String area;

    private Integer pLevel;
    private Integer cLevel;
    private Integer aLevel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getpLevel() {
        return pLevel;
    }

    public void setpLevel(Integer pLevel) {
        this.pLevel = pLevel;
    }

    public Integer getcLevel() {
        return cLevel;
    }

    public void setcLevel(Integer cLevel) {
        this.cLevel = cLevel;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getaLevel() {
        return aLevel;
    }

    public void setaLevel(Integer aLevel) {
        this.aLevel = aLevel;
    }


}
