package com.ruiwang.younthpalace.bojo.platform;

public class BoWorkPlan {
    private Integer id;
    private String OrderNum;
    private String equipmentCode;
    private String equipmentType;
    private String createTime;
    private String reason;
    private String createUserName;
    private String doUserName;
    private String createUserNameId;
    private String doUserNameId;
    private Integer state;
    private String startTime;
    private Integer equipment_position_id;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(String orderNum) {
        OrderNum = orderNum;
    }



    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getDoUserName() {
        return doUserName;
    }

    public void setDoUserName(String doUserName) {
        this.doUserName = doUserName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getEquipment_position_id() {
        return equipment_position_id;
    }

    public void setEquipment_position_id(Integer equipment_position_id) {
        this.equipment_position_id = equipment_position_id;
    }



    public String getCreateUserNameId() {
        return createUserNameId;
    }

    public void setCreateUserNameId(String createUserNameId) {
        this.createUserNameId = createUserNameId;
    }

    public String getDoUserNameId() {
        return doUserNameId;
    }

    public void setDoUserNameId(String doUserNameId) {
        this.doUserNameId = doUserNameId;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    @Override
    public String toString() {
        return "BoWorkPlan{" +
                "id=" + id +
                ", OrderNum='" + OrderNum + '\'' +
                ", equipmentCode='" + equipmentCode + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", createTime='" + createTime + '\'' +
                ", reason='" + reason + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", doUserName='" + doUserName + '\'' +
                ", createUserNameId='" + createUserNameId + '\'' +
                ", doUserNameId='" + doUserNameId + '\'' +
                ", state=" + state +
                ", startTime='" + startTime + '\'' +
                ", equipment_position_id=" + equipment_position_id +
                '}';
    }
}
