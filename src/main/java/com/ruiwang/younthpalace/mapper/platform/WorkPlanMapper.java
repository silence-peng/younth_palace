package com.ruiwang.younthpalace.mapper.platform;

import com.ruiwang.younthpalace.bojo.platform.BoWorkPlan;
import com.ruiwang.younthpalace.bojo.platform.BoWorkPlanLimit;
import com.ruiwang.younthpalace.entity.platform.SysWorkPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WorkPlanMapper {
    Integer insertIntoWorkPlan(@Param("sysWorkPlan") SysWorkPlan sysWorkPlan);
    ArrayList<BoWorkPlan> selectBoWorkPlanList(@Param("boWorkPlanLimit") BoWorkPlanLimit boWorkPlanLimit);
    Integer selectBoWorkPlanListAllNum(@Param("boWorkPlanLimit") BoWorkPlanLimit boWorkPlanLimit);
    BoWorkPlan selectworkPlan(@Param("id") Integer id);
    Integer updateWorkPlan(@Param("sysWorkPlan") SysWorkPlan sysWorkPlan);
    Integer deleteWorkPlan(@Param("id") Integer id);
    Integer doWorkPlan(@Param("id") Integer id);
}
