package com.ruiwang.younthpalace.entity.power;

public class SysShiftmanagement {
    private Integer id;
    private Integer user_id;
    private String do_time;
    private String date;

    @Override
    public String toString() {
        return "SysShiftmanagement{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", do_time='" + do_time + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDo_time() {
        return do_time;
    }

    public void setDo_time(String do_time) {
        this.do_time = do_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
