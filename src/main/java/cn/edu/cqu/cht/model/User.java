package cn.edu.cqu.cht.model;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 21:17
 */
public class User {//会员
    //id
    private Integer userId;

    //用户名
    private String userName;

    //真实姓名
    private String userRealName;

    //电话号码
    private String phoneNum;

    //邮箱
    private String email;

    //照片
    private String picture;

    //详细地址
    private String addr1;
    private String addr2;
    private String addr3;
    private String historyAddr;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public String getHistoryAddr() {
        return historyAddr;
    }

    public void setHistoryAddr(String historyAddr) {
        this.historyAddr = historyAddr;
    }


}
