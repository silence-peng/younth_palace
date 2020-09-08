package com.ruiwang.younthpalace.entity.platform;

import com.ruiwang.younthpalace.entity.BaseModel;


public class SysCalendar extends BaseModel {

    private Integer id;
    private String weather;
    private String plan;
    private String date;
    private Integer errNum;

    public Integer getErrNum() {
        return errNum;
    }

    public void setErrNum(Integer errNum) {
        this.errNum = errNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SysCalendar{" +
                "id=" + id +
                ", weather='" + weather + '\'' +
                ", plan='" + plan + '\'' +
                ", date='" + date + '\'' +
                ", errNum=" + errNum +
                '}';
    }
}
