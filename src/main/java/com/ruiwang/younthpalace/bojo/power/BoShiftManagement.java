package com.ruiwang.younthpalace.bojo.power;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoShiftManagement {
    private ArrayList<BoShiftManagementInf> boShiftManagementInfs;
    private Integer allNum;

    public ArrayList<BoShiftManagementInf> getBoShiftManagementInfs() {
        return boShiftManagementInfs;
    }

    public void setBoShiftManagementInfs(ArrayList<BoShiftManagementInf> boShiftManagementInfs) {
        this.boShiftManagementInfs = boShiftManagementInfs;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    @Override
    public String toString() {
        return "BoShiftManagement{" +
                "boShiftManagementInfs=" + boShiftManagementInfs +
                ", allNum=" + allNum +
                '}';
    }
}
