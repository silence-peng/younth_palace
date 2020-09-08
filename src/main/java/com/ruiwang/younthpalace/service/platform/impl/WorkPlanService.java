package com.ruiwang.younthpalace.service.platform.impl;

import com.ruiwang.younthpalace.bojo.LoginInf;
import com.ruiwang.younthpalace.bojo.platform.BoWorkPlan;
import com.ruiwang.younthpalace.bojo.platform.BoWorkPlanLimit;
import com.ruiwang.younthpalace.bojo.platform.BoWorkPlanList;
import com.ruiwang.younthpalace.entity.platform.SysWorkPlan;
import com.ruiwang.younthpalace.mapper.platform.EquipmentInfMapper;
import com.ruiwang.younthpalace.mapper.platform.WorkPlanMapper;
import com.ruiwang.younthpalace.service.platform.IWorkPlanService;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WorkPlanService implements IWorkPlanService {
    @Autowired
    WorkPlanMapper workPlanMapper;
    @Autowired
    BoWorkPlanList boWorkPlanList;
    @Autowired
    EquipmentInfMapper equipmentInfMapper;
    @Override
    public ResultMap<Integer> addWorkPlan(SysWorkPlan sysWorkPlan, HttpServletRequest hsr) {
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") ;
        String time=dtf.format(LocalDateTime.now());
        sysWorkPlan.setCreate_time(time);
        LoginInf logininf=( LoginInf )hsr.getSession().getAttribute("loginInf");
        sysWorkPlan.setCreate_userId(logininf.getUserId());
        sysWorkPlan.setStart_time(sysWorkPlan.getStart_time()==""?null:sysWorkPlan.getStart_time());
        int code=workPlanMapper.insertIntoWorkPlan(sysWorkPlan)>0?200:201;
        return new ResultMap<>(code,"",null);
    }
    @Override
    @Transactional
    public ResultMap<BoWorkPlanList> getBoWorkPlanList(BoWorkPlanLimit boWorkPlanLimit) {
        boWorkPlanLimit.setPageNum(boWorkPlanLimit.getPageNum()-1);
        boWorkPlanLimit.setPageSize(boWorkPlanLimit.getPageSize()-1);
        boWorkPlanList.setBoWorkPlans(workPlanMapper.selectBoWorkPlanList(boWorkPlanLimit));
        boWorkPlanList.setAllNum(workPlanMapper.selectBoWorkPlanListAllNum(boWorkPlanLimit));

        return new ResultMap<>(200,"",boWorkPlanList);
    }

    @Override
    public ResultMap<BoWorkPlan> getworkPlan(Integer id) {
        return new ResultMap<>(200,"",workPlanMapper.selectworkPlan(id));
    }

    @Override
    @Transactional
    public ResultMap<Integer> editWorkPlan(SysWorkPlan sysWorkPlan, HttpServletRequest hsr) {
        int code =workPlanMapper.updateWorkPlan(sysWorkPlan)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<Integer> deleteWorkPlan(Integer id) {
        int code=workPlanMapper.deleteWorkPlan(id)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<Integer> doWorkPlan(Integer id) {
        int code=workPlanMapper.doWorkPlan(id)>0?200:201;
        return new ResultMap<>(code,"",null);
    }
}
