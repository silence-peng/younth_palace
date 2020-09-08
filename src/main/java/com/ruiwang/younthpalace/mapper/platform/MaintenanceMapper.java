package com.ruiwang.younthpalace.mapper.platform;


import com.ruiwang.younthpalace.bojo.platform.BoMaintenanceHisInf;
import com.ruiwang.younthpalace.bojo.platform.BoMaintenanceInf;
import com.ruiwang.younthpalace.bojo.platform.BoMaintenancePlanLimit;
import com.ruiwang.younthpalace.entity.platform.SysMaintenance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MaintenanceMapper {
    Integer selectMaintenance_planByEquipmentInfId(@Param("eid") Integer equipmentInfId);
    Integer insertIntoMaintenance_plan(@Param("Inf") SysMaintenance addInf);
    Integer selectLastid();
    Integer insertIntoMaintenance_his(@Param("Inf") SysMaintenance addInf, @Param("id") Integer id);
    ArrayList<Integer> selectChangePlanHis(@Param("time") String time);
    ArrayList<Integer> selecthas(@Param("idList") ArrayList<Integer> id);
    ArrayList<SysMaintenance> selectNeedAddPlanById(@Param("idList") ArrayList<Integer> id);
    ArrayList<BoMaintenanceInf> selectBomainTenanceInfs(@Param("boMaintenancePlanLimit") BoMaintenancePlanLimit boMaintenancePlanLimit);
    Integer selectBomainTenanceInfsNum(@Param("boMaintenancePlanLimit") BoMaintenancePlanLimit boMaintenancePlanLimit);
    Integer selectMaintenanceStateByPlanId(@Param("planId") Integer planId);
    Integer deleteMaintenance_his_doing(@Param("plan_id") Integer id);
    Integer deleteMaintenance(@Param("id") Integer id);
    BoMaintenanceInf selectMaintanceInfById(@Param("id") Integer id);
    BoMaintenanceInf selectMaintanceInfhisById(@Param("id") Integer id);
    Integer updateMaintenance(@Param("Inf") SysMaintenance editInf);
    ArrayList<BoMaintenanceHisInf> selectBoMaintenanceHisInf (@Param("boMaintenancePlanLimit") BoMaintenancePlanLimit boMaintenancePlanLimit);
    Integer selectBoMaintenanceHisInfNum(@Param("boMaintenancePlanLimit") BoMaintenancePlanLimit boMaintenancePlanLimit);
    Integer updatemaintenanceHis(@Param("file") String fName, @Param("des") String maintenance_do_des, @Param("dotime") String time, @Param("id") Integer hisId);
    Integer updatemaintenancePlan(@Param("dotime") String time, @Param("id") Integer planId);
}
