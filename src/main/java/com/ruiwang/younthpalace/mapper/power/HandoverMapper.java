package com.ruiwang.younthpalace.mapper.power;

import com.ruiwang.younthpalace.bojo.power.BoOrder;
import com.ruiwang.younthpalace.bojo.power.BoShiftManagementInf;
import com.ruiwang.younthpalace.bojo.power.OrderLimit;
import com.ruiwang.younthpalace.bojo.power.ShiftManagementLimit;
import com.ruiwang.younthpalace.entity.power.SysOrder;
import com.ruiwang.younthpalace.entity.power.SysShiftmanagement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HandoverMapper {
    ArrayList<BoOrder> selectBoOrderList(@Param("orderLimit") OrderLimit orderLimit);
    Integer selectBoOrderListAll(@Param("orderLimit") OrderLimit orderLimit);
    Integer insertIntoOrder(@Param("sysOrder") SysOrder sysOrder);
    SysOrder selectSysOrderById(@Param("id") int id);
    Integer deleteSysOrderById(@Param("id") int id);
    Integer updateSysOrderById(@Param("sysOrder") SysOrder sysOrder);
    Integer shiftmanagementAdd(@Param("sysShiftmanagement") SysShiftmanagement sysShiftmanagement);
    Integer selectshiftManagementAll(@Param("shiftManagementLimit") ShiftManagementLimit shiftManagementLimit);
    ArrayList <BoShiftManagementInf> selectshiftManagementList(@Param("shiftManagementLimit") ShiftManagementLimit shiftManagementLimit);
    BoShiftManagementInf getSysShiftmanagement(@Param("id") Integer id);
    Integer updateSysShiftmanagement(@Param("sysShiftmanagement") SysShiftmanagement sysShiftmanagement, @Param("id") Integer id);
    Integer deleteShift(@Param("id") Integer id);
}
