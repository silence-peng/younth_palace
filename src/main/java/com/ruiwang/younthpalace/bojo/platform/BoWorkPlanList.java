package com.ruiwang.younthpalace.bojo.platform;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoWorkPlanList {
    private Integer allNum;
    private ArrayList<BoWorkPlan> boWorkPlans;

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public ArrayList<BoWorkPlan> getBoWorkPlans() {
        return boWorkPlans;
    }

    public void setBoWorkPlans(ArrayList<BoWorkPlan> boWorkPlans) {
        this.boWorkPlans = boWorkPlans;
    }

    @Override
    public String toString() {
        return "BoWorkPlanList{" +
                "allNum=" + allNum +
                ", boWorkPlans=" + boWorkPlans +
                '}';
    }
}
