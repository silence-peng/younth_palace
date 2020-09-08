package com.ruiwang.younthpalace.bojo.power;

public class OrderLimit {
    private Integer departmentId;
    private String createTime;
    private String orderUser;
    private String timeHour;
    private String startTimeHour;
    private String endTimeHour;
    private Integer pageNum;
    private Integer pageSize;
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }



    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTimeHour() {
        return timeHour;
    }

    public void setTimeHour(String timeHour) {
        this.timeHour = timeHour;
    }

    public String getStartTimeHour() {
        return startTimeHour;
    }

    public void setStartTimeHour(String startTimeHour) {
        this.startTimeHour = startTimeHour;
    }

    public String getEndTimeHour() {
        return endTimeHour;
    }

    public void setEndTimeHour(String endTimeHour) {
        this.endTimeHour = endTimeHour;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "OrderLimit{" +
                "departmentId=" + departmentId +
                ", createTime='" + createTime + '\'' +
                ", orderUser='" + orderUser + '\'' +
                ", timeHour='" + timeHour + '\'' +
                ", startTimeHour='" + startTimeHour + '\'' +
                ", endTimeHour='" + endTimeHour + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
