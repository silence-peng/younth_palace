package com.ruiwang.younthpalace.bojo.power;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class UserMapping {
    private Integer id;
    @Excel(name = "用户名")
    private String userName;
    @Excel(name = "登录密码")
    private String userPassword;
    @Excel(name="真实姓名")
    private String userNameCn;
    @Excel(name = "性别")
    private String gender;
    @Excel(name = "入职日期")
    private String entryDate;
    @Excel(name = "手机号码")
    private String phone;
    @Excel(name = "账户状态")
    private String state;
    @Excel(name = "职位")
    private String post;
    @Excel(name = "邮箱")
    private String email;
    @Excel(name = "录入时间")
    private String createtime;
    @Excel(name = "部门")
    private String departmentId;
    @Excel(name = "角色")
    private String roleId;

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
        this.userPassword = userPassword;
    }

    public String getUserNameCn() {
        return userNameCn;
    }

    public void setUserNameCn(String userNameCn) {
        this.userNameCn = userNameCn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserMapping{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNameCn='" + userNameCn + '\'' +
                ", gender=" + gender +
                ", entryDate='" + entryDate + '\'' +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +
                ", post='" + post + '\'' +
                ", email='" + email + '\'' +
                ", createtime='" + createtime + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
