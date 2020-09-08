package com.ruiwang.younthpalace.bojo.power;

import com.ruiwang.younthpalace.entity.power.SysRole;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoRoleForReady {
    private ArrayList<BoRole> sysRoles;
    private int allNum;

    public ArrayList<BoRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(ArrayList<BoRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    @Override
    public String toString() {
        return "BoRole{" +
                "sysRoles=" + sysRoles +
                ", allNum=" + allNum +
                '}';
    }
}
