package com.ruiwang.younthpalace.bojo.platform;

public class BoEquipmentInf {
    private Integer id;
    private String equipment_sys_code;
    private String equipment_sys_Name;
    private String equipment_sys_desc;
    private String equipment_name;
    private Integer equipment_position_id;
    private String equipment_position_des;

    public String getEquipment_sys_desc() {
        return equipment_sys_desc;
    }

    public void setEquipment_sys_desc(String equipment_sys_desc) {
        this.equipment_sys_desc = equipment_sys_desc;
    }

    public String getEquipment_sys_code() {
        return equipment_sys_code;
    }

    public void setEquipment_sys_code(String equipment_sys_code) {
        this.equipment_sys_code = equipment_sys_code;
    }

    public String getEquipment_sys_Name() {
        return equipment_sys_Name;
    }

    public void setEquipment_sys_Name(String equipment_sys_Name) {
        this.equipment_sys_Name = equipment_sys_Name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }


    public String getEquipment_position_des() {
        return equipment_position_des;
    }

    public void setEquipment_position_des(String equipment_position_des) {
        this.equipment_position_des = equipment_position_des;
    }

    @Override
    public String toString() {
        return "BoEquipmentInf{" +
                "id=" + id +
                ", equipment_name='" + equipment_name + '\'' +
                ", equipment_position_id=" + equipment_position_id +
                ", equipment_position_des='" + equipment_position_des + '\'' +
                '}';
    }

    public Integer getEquipment_position_id() {
        return equipment_position_id;
    }

    public void setEquipment_position_id(Integer equipment_position_id) {
        this.equipment_position_id = equipment_position_id;
    }
}
