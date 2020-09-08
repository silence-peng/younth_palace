package com.ruiwang.younthpalace.service.platform;

import com.ruiwang.younthpalace.bojo.LoginInf;
import com.ruiwang.younthpalace.bojo.platform.BoMaintenanceHisList;
import com.ruiwang.younthpalace.bojo.platform.BoMaintenanceInf;
import com.ruiwang.younthpalace.bojo.platform.BoMaintenanceList;
import com.ruiwang.younthpalace.bojo.platform.BoMaintenancePlanLimit;
import com.ruiwang.younthpalace.entity.platform.SysMaintenance;
import com.ruiwang.younthpalace.util.ResultMap;
import org.omg.CORBA.INTERNAL;
import org.springframework.web.multipart.MultipartFile;

public interface IMaintenanceService {
    ResultMap<Integer> addMaintenanceService(SysMaintenance addInf);

    ResultMap<Integer> scheduleOfScan();

    ResultMap<BoMaintenanceList> selectEquipmentList(BoMaintenancePlanLimit boMaintenancePlanLimit);

    ResultMap<Integer> deleteMaintenance(Integer id);

    ResultMap<BoMaintenanceInf> selectBoMaintenanceInf(Integer id);

    ResultMap<BoMaintenanceInf> selectBoMaintenanceInfhis(Integer id);


    ResultMap<Integer> editMaintenance(SysMaintenance addInf);

    ResultMap<BoMaintenanceHisList> selectBoMaintenanceHisList(BoMaintenancePlanLimit boMaintenancePlanLimit, LoginInf loginInf);

    ResultMap<Integer> updatemaintenanceHis(MultipartFile file, String maintenance_do_des, Integer HisId, Integer planId);

}
