package com.ruiwang.younthpalace.entity.platform;

public class SysEquipmentSys {
    private Integer id;
    private String esysName;
    private String easyDesc;
    private String easyCode;

    public String getEasyCode() {
        return easyCode;
    }

    public void setEasyCode(String easyCode) {
        this.easyCode = easyCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEsysName() {
        return esysName;
    }

    public void setEsysName(String esysName) {
        this.esysName = esysName;
    }

    public String getEasyDesc() {
        return easyDesc;
    }

    public void setEasyDesc(String easyDesc) {
        this.easyDesc = easyDesc;
    }

    @Override
    public String toString() {
        return "SysEquipmentSys{" +
                "id=" + id +
                ", esysName='" + esysName + '\'' +
                ", easyDesc='" + easyDesc + '\'' +
                ", easyCode='" + easyCode + '\'' +
                '}';
    }
}
