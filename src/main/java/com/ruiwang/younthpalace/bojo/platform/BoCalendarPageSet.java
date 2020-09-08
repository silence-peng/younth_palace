package com.ruiwang.younthpalace.bojo.platform;

public class BoCalendarPageSet {
    private Integer showWeather;
    private Integer showPlan;
    private Integer showErrorNum;

    public Integer getShowWeather() {
        return showWeather;
    }

    public void setShowWeather(Integer showWeather) {
        this.showWeather = showWeather;
    }

    public Integer getShowPlan() {
        return showPlan;
    }

    public void setShowPlan(Integer showPlan) {
        this.showPlan = showPlan;
    }

    public Integer getShowErrorNum() {
        return showErrorNum;
    }

    public void setShowErrorNum(Integer showErrorNum) {
        this.showErrorNum = showErrorNum;
    }

    @Override
    public String toString() {
        return "BoCalendarPageSet{" +
                "showWeather=" + showWeather +
                ", showPlan=" + showPlan +
                ", showErrorNum=" + showErrorNum +
                '}';
    }
}
