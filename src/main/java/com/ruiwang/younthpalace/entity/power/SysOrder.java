package com.ruiwang.younthpalace.entity.power;

public class SysOrder {
    private Integer id;
    private Integer departmentId;
    private String doUser;
    private String contentList;
    private String content;
    private String toUser;
    private String sendTime;
    private String getTime;
    private String createTime;
    private String orderUser;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDoUser() {
        return doUser;
    }

    public void setDoUser(String doUser) {
        this.doUser = doUser;
    }

    public String getContentList() {
        return contentList;
    }

    public void setContentList(String contentList) {
        this.contentList = contentList;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public String getCreateTime() {
        return createTime;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    @Override
    public String toString() {
        return "SysOrder{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", doUser='" + doUser + '\'' +
                ", contentList='" + contentList + '\'' +
                ", content='" + content + '\'' +
                ", toUser='" + toUser + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", getTime='" + getTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", orderUser='" + orderUser + '\'' +
                '}';
    }
}
