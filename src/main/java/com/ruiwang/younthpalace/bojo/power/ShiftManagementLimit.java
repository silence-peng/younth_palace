package com.ruiwang.younthpalace.bojo.power;

public class ShiftManagementLimit {
    private  String date;
    private String user_name;
    private Integer department_id;
    private Integer pageNum;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "ShiftManagementLimit{" +
                "date='" + date + '\'' +
                ", user_name='" + user_name + '\'' +
                ", department_id=" + department_id +
                ", pageNum=" + pageNum +
                '}';
    }
}
