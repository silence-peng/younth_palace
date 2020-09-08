package com.ruiwang.younthpalace.bojo.platform;

import org.springframework.stereotype.Component;

@Component
public class BoMaintenanceInf {
    private Integer id;
    private String equipment_code;
    private String equipment_type;
    private Integer equipment_position_id;
    private String start_time;
    private String end_time;
    private Integer maintenance_cycle;
    private String user_name;
    private Integer executor;
    private String role_name;
    private String phone;
    private String state;
    private Integer hisId;

    public Integer getHisId() {
        return hisId;
    }

    public void setHisId(Integer hisId) {
        this.hisId = hisId;
    }

    public Integer getExecutor() {
        return executor;
    }

    public void setExecutor(Integer executor) {
        this.executor = executor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipment_code() {
        return equipment_code;
    }

    public void setEquipment_code(String equipment_code) {
        this.equipment_code = equipment_code;
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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Integer getMaintenance_cycle() {
        return maintenance_cycle;
    }

    public void setMaintenance_cycle(Integer maintenance_cycle) {
        this.maintenance_cycle = maintenance_cycle;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    @Override
    public String toString() {
        return "BoMaintenanceInf{" +
                "id=" + id +
                ", equipment_num='" + equipment_code + '\'' +
                ", equipment_type='" + equipment_type + '\'' +
                ", equipment_position_id=" + equipment_position_id +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", maintenance_cycle=" + maintenance_cycle +
                ", user_name='" + user_name + '\'' +
                ", role_name='" + role_name + '\'' +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +

                '}';
    }
}
