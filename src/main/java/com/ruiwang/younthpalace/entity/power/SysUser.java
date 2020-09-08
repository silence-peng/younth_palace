package com.ruiwang.younthpalace.entity.power;

import com.ruiwang.younthpalace.bojo.power.UserMapping;
import com.ruiwang.younthpalace.util.MD5Util;

import java.io.Serializable;

public class SysUser implements Serializable {
    private Integer id;

    private String userName;

    private String userPassword;

    private String userNameCn;

    private Integer gender;

    private String entryDate;

    private String phone;

    private Integer state;

    private String post;

    private String email;

    private String createtime;

    private Integer departmentId;

    private Integer roleId;


    public SysUser() {
    }

    public SysUser(UserMapping userMapping) {
        this.userName=userMapping.getUserName();
        this.userPassword=userMapping.getUserPassword();
        this.userNameCn=userMapping.getUserNameCn();
        this.gender=userMapping.getGender().equals("男")?1:0;
        this.entryDate=userMapping.getEntryDate();
        this.phone=userMapping.getPhone();
        this.state=userMapping.getState().equals("已激活")?0:(userMapping.getState().equals("注销")?1:(userMapping.getState().equals("冻结")?2:(userMapping.getState().equals("未激活")?3:4)));
        this.userPassword=userMapping.getUserPassword();

    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = MD5Util.convertMD5(userPassword);
    }
    public String getUserNameCn() {
        return userNameCn;
    }

    public void setUserNameCn(String userNameCn) {
        this.userNameCn = userNameCn;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNameCn='" + userNameCn + '\'' +
                ", gender=" + gender +
                ", entryDate='" + entryDate + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", post='" + post + '\'' +
                ", email='" + email + '\'' +
                ", createtime='" + createtime + '\'' +
                ", departmentId=" + departmentId +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
