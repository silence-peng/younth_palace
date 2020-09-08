package com.ruiwang.younthpalace.pojo.platform;

import org.springframework.stereotype.Controller;

@Controller
public class PoEquipmentInfMainyenance {
    private Integer id;
    private String equipment_des;
    private Integer equipment_position_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipment_des() {
        return equipment_des;
    }

    public void setEquipment_des(String equipment_des) {
        this.equipment_des = equipment_des;
    }

    public Integer getEquipment_position_id() {
        return equipment_position_id;
    }

    public void setEquipment_position_id(Integer equipment_position_id) {
        this.equipment_position_id = equipment_position_id;
    }
}
