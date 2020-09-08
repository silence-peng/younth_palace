package com.ruiwang.younthpalace.bojo.platform;

import org.springframework.stereotype.Component;

@Component
public class BoMaintenanceEquipmentInf {
    private Integer id;
    private String equipment_type;
    private String equipment_position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipment_type() {
        return equipment_type;
    }

    public void setEquipment_type(String equipment_type) {
        this.equipment_type = equipment_type;
    }

    public String getEquipment_position() {
        return equipment_position;
    }

    public void setEquipment_position(String equipment_position) {
        this.equipment_position = equipment_position;
    }
}
