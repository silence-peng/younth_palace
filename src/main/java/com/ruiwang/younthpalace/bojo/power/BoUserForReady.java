package com.ruiwang.younthpalace.bojo.power;

import com.ruiwang.younthpalace.entity.power.SysDepartment;
import com.ruiwang.younthpalace.entity.power.SysRole;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoUserForReady {
    private ArrayList<SysDepartment> sysDepartments;
    private ArrayList<SysRole> sysRoles;
    private ArrayList<BoUser> boUser;
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

    public ArrayList<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(ArrayList<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public ArrayList<BoUser> getBoUser() {
        return boUser;
    }

    public void setBoUser(ArrayList<BoUser> boUser) {
        this.boUser = boUser;
    }
}
