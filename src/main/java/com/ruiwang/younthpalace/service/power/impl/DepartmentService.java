package com.ruiwang.younthpalace.service.power.impl;

import com.github.pagehelper.PageInfo;
import com.ruiwang.younthpalace.bojo.power.BoDepartment;
import com.ruiwang.younthpalace.bojo.power.DepartmentLimit;
import com.ruiwang.younthpalace.entity.BaseModel;
import com.ruiwang.younthpalace.entity.power.SysDepartment;

import com.ruiwang.younthpalace.mapper.power.DepartmentMapper;
import com.ruiwang.younthpalace.service.power.IDepartmentService;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService  implements IDepartmentService{
    @Autowired
    DepartmentMapper departmentMapper;
//    @Autowired
//    BaseMapper<SysDepartment> mapper;
    @Autowired
    BoDepartment boDepartment;

    @Override
    @Transactional
    public ResultMap<BoDepartment> selectDepartmentList(DepartmentLimit departmentLimit) {
        System.out.println(departmentLimit);
        if (departmentLimit.getDate() != null && departmentLimit.getDate() != "") {
            departmentLimit.setDateStart(departmentLimit.getDate() + " 00:00:00");
            departmentLimit.setDateEnd(departmentLimit.getDate() + " 23:59:59");
        }
        departmentLimit.setPageNum(departmentLimit.getPageNum()-1);
        departmentLimit.setPageSize(departmentLimit.getPageSize()-1);
        boDepartment.setAllNum(departmentMapper.selectDepartmentListNum(departmentLimit));
        boDepartment.setSysDepartments(departmentMapper.selectDepartmentList(departmentLimit));
        return new ResultMap<>(200,"",boDepartment);
    }

    @Override
    @Transactional
    public ResultMap<Integer> addDepartment(String departmentName) {
        try {
            departmentName=java.net.URLDecoder.decode(departmentName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        departmentName = departmentName.split("=")[1];
        //查询是否存在此用户
        if (departmentMapper.selectDepartmentByName(departmentName) > 0) {
            return new ResultMap<>(201,"",null);
        } else {
            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time=LocalDateTime.now().format(dtf);
            int code=departmentMapper.insertDepartment(departmentName, time)>0?200:201;
            return new ResultMap<>(code,"",null);
        }
    }

    @Override
    public ResultMap<Integer> deleteDepartment(String departmentId) {
        if (departmentMapper.deleteDepartmentById(Integer.parseInt(departmentId.split("=")[1])) > 0) {
            return new ResultMap<>(200,"",null);
        } else {
            return new ResultMap<>(201,"",null);
        }
    }

    @Override
    public ResultMap<Integer> updateDepartment(String editInf) {
        try {
            editInf=java.net.URLDecoder.decode(editInf,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int id=Integer.parseInt(editInf.split("&")[0].split("=")[1]);
        String departmentName=editInf.split("&")[1].split("=")[1];
        if(departmentMapper.updateDepartment(id,departmentName)>0){
            return new ResultMap<>(200,"",null);
        }
        return new ResultMap<>(201,"",null);
    }

    @Override
    public ResultMap<ArrayList<SysDepartment>> selectDepartmentAll() {
        return new ResultMap<>(200,"",departmentMapper.selectDepartmentAll());
    }


}