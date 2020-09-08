package com.ruiwang.younthpalace.entity.platform;

public class SysWorkPlan {
    private Integer id;
    private Integer equipmentInf_id;
    private String create_time;
    private String start_time;
    private String reason;
    private Integer create_userId;
    private Integer executor;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentInf_id() {
        return equipmentInf_id;
    }

    public void setEquipmentInf_id(Integer equipmentInf_id) {
        this.equipmentInf_id = equipmentInf_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Integer getExecutor() {
        return executor;
    }

    public void setExecutor(Integer executor) {
        this.executor = executor;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getCreate_userId() {
        return create_userId;
    }

    public void setCreate_userId(Integer create_userId) {
        this.create_userId = create_userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SysWorkPlan{" +
                "id=" + id +
                ", equipmentInf_id=" + equipmentInf_id +
                ", create_time='" + create_time + '\'' +
                ", start_time='" + start_time + '\'' +
                ", reason='" + reason + '\'' +
                ", create_userId=" + create_userId +
                ", executor=" + executor +
                ", state=" + state +
                '}';
    }
}
