package com.ruiwang.younthpalace.entity.power;

public class SysPosition {
    private Integer id;
    private String describe;
    private String belongsto;

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

    public String getBelongsto() {
        return belongsto;
    }

    public void setBelongsto(String belongsto) {
        this.belongsto = belongsto;
    }

    @Override
    public String toString() {
        return "SysPosition{" +
                "id=" + id +
                ", describe='" + describe + '\'' +
                ", belongsto='" + belongsto + '\'' +
                '}';
    }
}
