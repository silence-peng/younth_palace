package com.ruiwang.younthpalace.bojo.platform;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoMaintenanceList {
    private ArrayList<BoMaintenanceInf> boMaintenanceInfs;
    private Integer allNum;

    public ArrayList<BoMaintenanceInf> getBoMaintenanceInfs() {
        return boMaintenanceInfs;
    }

    public void setBoMaintenanceInfs(ArrayList<BoMaintenanceInf> boMaintenanceInfs) {
        this.boMaintenanceInfs = boMaintenanceInfs;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    @Override
    public String toString() {
        return "BoMaintenanceList{" +
                "boMaintenanceInfs=" + boMaintenanceInfs +
                ", allNum=" + allNum +
                '}';
    }
}
