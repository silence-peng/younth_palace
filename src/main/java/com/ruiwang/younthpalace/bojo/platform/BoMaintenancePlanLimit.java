package com.ruiwang.younthpalace.bojo.platform;

public class BoMaintenancePlanLimit {
    private String equipment_num;
    private Integer equipment_type;
    private Integer building;
    private String start_time;
    private String end_time;
    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private Integer floor;
    private Integer userId;
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEquipment_num() {
        return equipment_num;
    }

    public void setEquipment_num(String equipment_num) {
        this.equipment_num = equipment_num;
    }

    public Integer getEquipment_type() {
        return equipment_type;
    }

    public void setEquipment_type(Integer equipment_type) {
        this.equipment_type = equipment_type;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "BoMaintenancePlanLimit{" +
                "equipment_num='" + equipment_num + '\'' +
                ", equipment_type=" + equipment_type +
                ", building=" + building +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", floor=" + floor +
                ", userId=" + userId +
                ", state=" + state +
                '}';
    }
}
