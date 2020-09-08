package com.ruiwang.younthpalace.bojo.platform;

public class BoWorkPlanLimit {
    private String createTime;
    private Integer building;
    private String equipmentNum;
    private Integer floor;
    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public String getEquipmentNum() {
        return equipmentNum;
    }

    public void setEquipmentNum(String equipmentNum) {
        this.equipmentNum = equipmentNum;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "BoWorkPlanLimit{" +
                "createTime='" + createTime + '\'' +
                ", building=" + building +
                ", equipmentNum='" + equipmentNum + '\'' +
                ", floor=" + floor +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
