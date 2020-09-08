package com.ruiwang.younthpalace.bojo.power;

import org.springframework.stereotype.Component;

import java.security.PrivateKey;

@Component
public class DepartmentLimit {
    private Integer pageNum;
    private String date;
    private String departmentName;
    private String dateStart;
    private String dateEnd;
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "DepartmentLimit{" +
                "pageNum=" + pageNum +
                ", date='" + date + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }
}
