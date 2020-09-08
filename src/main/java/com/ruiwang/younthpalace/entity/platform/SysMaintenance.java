package com.ruiwang.younthpalace.entity.platform;

public class SysMaintenance {
    private Integer id;
    private Integer equipmentInf_id;
    private String start_time;
    private String end_time;
    private Double maintenance_cycle;
    private Integer executor;
    private String last_scan_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentInf_id() {
        return equipmentInf_id;
    }

    public void setEquipmentInf_id(Integer equipmentInf_id) {
        this.equipmentInf_id = equipmentInf_id;
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

    public Double getMaintenance_cycle() {
        return maintenance_cycle;
    }

    public void setMaintenance_cycle(Double maintenance_cycle) {
        this.maintenance_cycle = maintenance_cycle;
    }

    public Integer getExecutor() {
        return executor;
    }

    public void setExecutor(Integer executor) {
        this.executor = executor;
    }

    public String getLast_scan_time() {
        return last_scan_time;
    }

    public void setLast_scan_time(String last_scan_time) {
        this.last_scan_time = last_scan_time;
    }

    @Override
    public String toString() {
        return "SysMaintenance{" +
                "id=" + id +
                ", equipmentInf_id=" + equipmentInf_id +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", maintenance_cycle=" + maintenance_cycle +
                ", executor=" + executor +
                ", last_scan_time='" + last_scan_time + '\'' +
                '}';
    }
}
