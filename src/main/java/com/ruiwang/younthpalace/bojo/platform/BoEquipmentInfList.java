package com.ruiwang.younthpalace.bojo.platform;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoEquipmentInfList {
    ArrayList<BoEquipmentInf> boEquipmentInfs;
    Integer allNum;

    public ArrayList<BoEquipmentInf> getBoEquipmentInfs() {
        return boEquipmentInfs;
    }

    public void setBoEquipmentInfs(ArrayList<BoEquipmentInf> boEquipmentInfs) {
        this.boEquipmentInfs = boEquipmentInfs;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }
}
