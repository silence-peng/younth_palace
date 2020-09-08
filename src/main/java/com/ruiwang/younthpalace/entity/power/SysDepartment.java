package com.ruiwang.younthpalace.entity.power;

import com.ruiwang.younthpalace.entity.BaseModel;


public class SysDepartment extends BaseModel {

    private Integer id;
    private String departmentName;
    private String departmentDate;

    public String getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(String departmentDate) {
        this.departmentDate = departmentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "SysDepartment{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
