package com.ruiwang.younthpalace.entity.platform;

public class SysEquipmentInfo {
    private Integer id;
    private String equipmentName;
    private Integer equipmentTypeId;
    private String equipmentCode;
    private Integer equipmentPositionId;
    private String installationDate;
    private Integer life;
    private String supplier;
    private String maintenanceProvider;
    private Integer belongTo;
    private Integer equipmentSysId;

    public Integer getEquipmentSysId() {
        return equipmentSysId;
    }

    public void setEquipmentSysId(Integer equipmentSysId) {
        this.equipmentSysId = equipmentSysId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Integer getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Integer equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public Integer getEquipmentPositionId() {
        return equipmentPositionId;
    }

    public void setEquipmentPositionId(Integer equipmentPositionId) {
        this.equipmentPositionId = equipmentPositionId;
    }

    public String getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(String installationDate) {
        this.installationDate = installationDate;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getMaintenanceProvider() {
        return maintenanceProvider;
    }

    public void setMaintenanceProvider(String maintenanceProvider) {
        this.maintenanceProvider = maintenanceProvider;
    }

    public Integer getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(Integer belongTo) {
        this.belongTo = belongTo;
    }

    @Override
    public String toString() {
        return "SysEquipmentInfo{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentTypeId=" + equipmentTypeId +
                ", equipmentCode='" + equipmentCode + '\'' +
                ", equipmentPositionId=" + equipmentPositionId +
                ", installationDate='" + installationDate + '\'' +
                ", life=" + life +
                ", supplier='" + supplier + '\'' +
                ", maintenanceProvider='" + maintenanceProvider + '\'' +
                ", belongTo=" + belongTo +
                '}';
    }
}
