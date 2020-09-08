package com.ruiwang.younthpalace.service.platform;

import com.ruiwang.younthpalace.bojo.platform.BoWorkPlan;
import com.ruiwang.younthpalace.bojo.platform.BoWorkPlanLimit;
import com.ruiwang.younthpalace.bojo.platform.BoWorkPlanList;
import com.ruiwang.younthpalace.entity.platform.SysWorkPlan;
import com.ruiwang.younthpalace.util.ResultMap;

import javax.servlet.http.HttpServletRequest;

public interface IWorkPlanService {
    ResultMap<Integer> addWorkPlan(SysWorkPlan sysWorkPlan, HttpServletRequest hsr);
    ResultMap<BoWorkPlanList> getBoWorkPlanList(BoWorkPlanLimit boWorkPlanLimit);
    ResultMap<BoWorkPlan> getworkPlan(Integer id);
    ResultMap<Integer> editWorkPlan(SysWorkPlan sysWorkPlan, HttpServletRequest hsr);
    ResultMap<Integer> deleteWorkPlan(Integer id);
    ResultMap<Integer> doWorkPlan(Integer id);
}
