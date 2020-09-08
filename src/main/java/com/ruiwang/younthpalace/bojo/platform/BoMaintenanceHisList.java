package com.ruiwang.younthpalace.bojo.platform;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoMaintenanceHisList {
    private ArrayList<BoMaintenanceHisInf> boMaintenanceHisInfs;
    private Integer allNum;

    public ArrayList<BoMaintenanceHisInf> getBoMaintenanceHisInfs() {
        return boMaintenanceHisInfs;
    }

    public void setBoMaintenanceHisInfs(ArrayList<BoMaintenanceHisInf> boMaintenanceHisInfs) {
        this.boMaintenanceHisInfs = boMaintenanceHisInfs;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    @Override
    public String toString() {
        return "BoMaintenanceHisList{" +
                "boMaintenanceHisInfs=" + boMaintenanceHisInfs +
                ", allNum=" + allNum +
                '}';
    }
}
