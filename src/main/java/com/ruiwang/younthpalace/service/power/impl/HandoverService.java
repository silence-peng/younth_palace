package com.ruiwang.younthpalace.service.power.impl;

import com.ruiwang.younthpalace.bojo.power.*;
import com.ruiwang.younthpalace.entity.power.SysOrder;
import com.ruiwang.younthpalace.entity.power.SysShiftmanagement;
import com.ruiwang.younthpalace.mapper.power.DepartmentMapper;
import com.ruiwang.younthpalace.mapper.power.HandoverMapper;
import com.ruiwang.younthpalace.service.power.IHandoverService;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class HandoverService implements IHandoverService {
    @Autowired
    HandoverMapper handoverMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    BoOrderForReady boOrderForReady;

    @Autowired
    BoShiftManagement boShiftManagement;

    @Override
    @Transactional
    public ResultMap<BoOrderForReady> selectBoUserForReady(OrderLimit orderLimit) {
        orderLimit.setPageNum(orderLimit.getPageNum()-1);
        orderLimit.setPageSize(orderLimit.getPageSize()-1);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time=orderLimit.getTimeHour();
        if(time!=""&&time!=null){
            time=time.replace("T"," ")+":00";
            LocalDateTime parse=LocalDateTime.parse(time,dtf);
            Long timestamp=LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            Long startt=timestamp-18000000;
            Long endt=timestamp+18000000;
            String startime=dtf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(startt),ZoneId.systemDefault()));
            String endtime=dtf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(endt),ZoneId.systemDefault()));
            orderLimit.setStartTimeHour(startime);
            orderLimit.setEndTimeHour(endtime);
            System.out.println(orderLimit.toString());
        }
        boOrderForReady.setSysDepartments(departmentMapper.selectDepartmentAll());
        boOrderForReady.setBoOrders(handoverMapper.selectBoOrderList(orderLimit));
        boOrderForReady.setAllNum(handoverMapper.selectBoOrderListAll(orderLimit));
        return new ResultMap<>(200,"",boOrderForReady);
    }

    @Override
    public ResultMap<Integer> addOrder(SysOrder sysOrder) {
        if(sysOrder.getGetTime()==""){
            sysOrder.setGetTime(null);
        }
        if(sysOrder.getCreateTime()==""){
            sysOrder.setCreateTime(null);
        }
        if(sysOrder.getSendTime()==""){
            sysOrder.setSendTime(null);
        }
        int code=handoverMapper.insertIntoOrder(sysOrder)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<SysOrder> getOrderById(int id) {
        return new ResultMap<>(200,"",handoverMapper.selectSysOrderById(id));
    }

    @Override
    @Transactional
    public ResultMap<Integer> editOrder(SysOrder sysOrder) {
//        System.out.println(sysOrder.toString());
//        handoverMapper.deleteSysOrderById(sysOrder.getId());
        if(sysOrder.getGetTime()==""){
            sysOrder.setGetTime(null);
        }
        if(sysOrder.getCreateTime()==""){
            sysOrder.setCreateTime(null);
        }
        if(sysOrder.getSendTime()==""){
            sysOrder.setSendTime(null);
        }
        int code=handoverMapper.updateSysOrderById(sysOrder)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<Integer> deleteOrder(int id) {
        int code=handoverMapper.deleteSysOrderById(id)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<Integer> shiftmanagementAdd(SysShiftmanagement sysShiftmanagement) {
        int code=handoverMapper.shiftmanagementAdd(sysShiftmanagement)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    @Transactional
    public ResultMap<BoShiftManagement> shiftmanagementList(ShiftManagementLimit shiftManagementLimit) {
        shiftManagementLimit.setPageNum(shiftManagementLimit.getPageNum() * 10);
        boShiftManagement.setAllNum(handoverMapper.selectshiftManagementAll(shiftManagementLimit));
        boShiftManagement.setBoShiftManagementInfs(handoverMapper.selectshiftManagementList(shiftManagementLimit));
        return new ResultMap<>(200,"",boShiftManagement);
    }

    @Override
    public ResultMap<BoShiftManagementInf> getSysShiftmanagement(Integer id) {
        return new ResultMap<>(200,"",handoverMapper.getSysShiftmanagement(id));
    }

    @Override
    public ResultMap<Integer> updateSysShiftmanagement(SysShiftmanagement sysShiftmanagement, Integer id) {
        int code=handoverMapper.updateSysShiftmanagement(sysShiftmanagement,id)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<Integer> deleteShift(Integer id) {
        int code=handoverMapper.deleteShift(id)>0?200:201;
        return new ResultMap<>(code,"",null);
    }


}
