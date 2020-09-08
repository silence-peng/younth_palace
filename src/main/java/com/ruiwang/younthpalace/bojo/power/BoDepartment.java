package com.ruiwang.younthpalace.bojo.power;

import com.ruiwang.younthpalace.entity.power.SysDepartment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoDepartment {
    private ArrayList<SysDepartment> sysDepartments;

    public ArrayList<SysDepartment> getSysDepartments() {
        return sysDepartments;
    }

    public void setSysDepartments(ArrayList<SysDepartment> sysDepartments) {
        this.sysDepartments = sysDepartments;
    }

    private Integer allNum;

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    @Override
    public String toString() {
        return "BoDepartment{" +
                "sysDepartments=" + sysDepartments +
                ", allNum=" + allNum +
                '}';
    }
}
