package com.ruiwang.younthpalace.entity.platform;

public class SysEquipmentType {
    private Integer id;
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "SysEquipmentType{" +
                "id=" + id +
                ", describe='" + describe + '\'' +
                '}';
    }
}
