package com.ruiwang.younthpalace.service.power;

import com.ruiwang.younthpalace.bojo.power.*;
import com.ruiwang.younthpalace.entity.power.SysOrder;
import com.ruiwang.younthpalace.entity.power.SysShiftmanagement;
import com.ruiwang.younthpalace.util.ResultMap;

public interface IHandoverService {
    ResultMap<BoOrderForReady> selectBoUserForReady(OrderLimit orderLimit);
    ResultMap<Integer> addOrder(SysOrder sysOrder) ;
    ResultMap<SysOrder> getOrderById(int id);
    ResultMap<Integer> editOrder(SysOrder sysOrder);
    ResultMap<Integer> deleteOrder(int id);
    ResultMap<Integer> shiftmanagementAdd(SysShiftmanagement sysShiftmanagement);
    ResultMap<BoShiftManagement> shiftmanagementList(ShiftManagementLimit shiftManagementLimit);
    ResultMap<BoShiftManagementInf> getSysShiftmanagement(Integer id);
    ResultMap<Integer> updateSysShiftmanagement(SysShiftmanagement sysShiftmanagement, Integer id);
    ResultMap<Integer> deleteShift(Integer id);
}
