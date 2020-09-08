package com.ruiwang.younthpalace.bojo;

import org.springframework.stereotype.Component;

@Component
public class UrlInf {
    private String[] urlInf={
        "power/userManage",
        "power/roleManage",
        "power/departmentManage",
        "power/handover",
        "power/roleManage",
        "power/roleManage",
        "platform/equipmentInf",
        "platform/maintenancePage",
        "platform/maintenanceDoPage",
        "platform/maintenanceHisPage",
        "platform/calendar",
        "platform/workPlan",
        "platform/addMenu",
        "power/shiftmanagement"
    };
    public String[] getUrlInf() {
        return urlInf;
    }
}