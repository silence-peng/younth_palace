package com.ruiwang.younthpalace.bojo.power;

import com.ruiwang.younthpalace.entity.power.SysDepartment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//import javax.swing.border.Border;

@Component
public class BoOrderForReady {
    private ArrayList<SysDepartment> sysDepartments;
    private ArrayList<BoOrder> boOrders;
    private Integer allNum;

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public ArrayList<SysDepartment> getSysDepartments() {
        return sysDepartments;
    }

    public void setSysDepartments(ArrayList<SysDepartment> sysDepartments) {
        this.sysDepartments = sysDepartments;
    }

    public ArrayList<BoOrder> getBoOrders() {
        return boOrders;
    }

    public void setBoOrders(ArrayList<BoOrder> boOrders) {
        this.boOrders = boOrders;
    }

    @Override
    public String toString() {
        return "BoOrderForReady{" +
                "sysDepartments=" + sysDepartments +
                ", boOrders=" + boOrders +
                '}';
    }
}
