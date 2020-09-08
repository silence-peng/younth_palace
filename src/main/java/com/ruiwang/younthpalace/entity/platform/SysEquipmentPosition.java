package com.ruiwang.younthpalace.entity.platform;

public class SysEquipmentPosition {
    private Integer id;
    private String describe;
    private Integer belongsTo;

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

    public Integer getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Integer belongsTo) {
        this.belongsTo = belongsTo;
    }

    @Override
    public String toString() {
        return "EquipmentPosition{" +
                "id=" + id +
                ", describe='" + describe + '\'' +
                ", belongsTo=" + belongsTo +
                '}';
    }
}
