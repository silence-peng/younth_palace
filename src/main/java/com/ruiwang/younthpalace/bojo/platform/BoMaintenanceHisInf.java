package com.ruiwang.younthpalace.bojo.platform;

public class BoMaintenanceHisInf {
    private Integer id;
    private String equipment_code;
    private String equipment_type;
    private Integer equipment_position_id;
    private Integer maintenance_cycle;
    private Integer planId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }



    public String getEquipment_type() {
        return equipment_type;
    }

    public void setEquipment_type(String equipment_type) {
        this.equipment_type = equipment_type;
    }

    public Integer getEquipment_position_id() {
        return equipment_position_id;
    }

    public void setEquipment_position_id(Integer equipment_position_id) {
        this.equipment_position_id = equipment_position_id;
    }

    public Integer getMaintenance_cycle() {
        return maintenance_cycle;
    }

    public void setMaintenance_cycle(Integer maintenance_cycle) {
        this.maintenance_cycle = maintenance_cycle;
    }


    @Override
    public String toString() {
        return "BoMaintenanceHisInf{" +
                "id=" + id +
                ", equipment_code='" + equipment_code + '\'' +
                ", equipment_type='" + equipment_type + '\'' +
                ", equipment_position_id=" + equipment_position_id +
                ", maintenance_cycle=" + maintenance_cycle +
                ", planId=" + planId +
                '}';
    }

    public String getEquipment_code() {
        return equipment_code;
    }

    public void setEquipment_code(String equipment_code) {
        this.equipment_code = equipment_code;
    }
}
