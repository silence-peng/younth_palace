package com.ruiwang.younthpalace.bojo.power;

import org.springframework.stereotype.Component;

@Component
public class BoShiftManagementInf {
    private Integer id;
    private String date;
    private String department_id;
    private String department_name;
    private String user_name;
    private String do_time;
    private Integer user_id;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getDo_time() {
        return do_time;
    }

    public void setDo_time(String do_time) {
        this.do_time = do_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "BoShiftManagementInf{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", department_id='" + department_id + '\'' +
                ", department_name='" + department_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", do_time='" + do_time + '\'' +
                ", user_id=" + user_id +
                ", phone='" + phone + '\'' +
                '}';
    }
}
