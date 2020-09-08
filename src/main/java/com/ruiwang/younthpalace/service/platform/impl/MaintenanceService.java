package com.ruiwang.younthpalace.service.platform.impl;

import com.ruiwang.younthpalace.bojo.LoginInf;
import com.ruiwang.younthpalace.bojo.platform.*;
import com.ruiwang.younthpalace.entity.platform.SysMaintenance;
import com.ruiwang.younthpalace.mapper.platform.EquipmentInfMapper;
import com.ruiwang.younthpalace.mapper.platform.MaintenanceMapper;
import com.ruiwang.younthpalace.service.platform.IMaintenanceService;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class MaintenanceService implements IMaintenanceService {
    @Autowired
    MaintenanceMapper maintenanceMapper;
    @Autowired
    BoMaintenanceList boMaintenanceList;
    @Autowired
    EquipmentInfMapper equipmentInfMapper;
    @Autowired
    BoMaintenanceInf boMaintenanceInf;
    @Autowired
    BoMaintenanceHisList boMaintenanceHisList;
    @Override
    @Transactional
    public ResultMap<Integer> addMaintenanceService(SysMaintenance addInf) {
        System.out.println(addInf.toString());
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        addInf.setLast_scan_time(LocalDate.now().format(dtf));
        if(addInf.getStart_time()==""){
            addInf.setStart_time(null);
        }
        if(addInf.getEnd_time()==""){
            addInf.setEnd_time(null);
        }
        Integer num=maintenanceMapper.selectMaintenance_planByEquipmentInfId(addInf.getEquipmentInf_id());
        if(num==0){
            maintenanceMapper.insertIntoMaintenance_plan(addInf);
            //获取更新的时间
            Integer id=maintenanceMapper.selectLastid();
            System.out.println(id);
            int code=maintenanceMapper.insertIntoMaintenance_his(addInf,id)>0?200:201;
            return new ResultMap<>(code,"",null);
        }else{
            return new ResultMap<>(201,"",null);
        }
    }

    @Override
    @Transactional
    public ResultMap<Integer> scheduleOfScan() {
        //获取当前日期
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String time =LocalDate.now().format(dtf);
        //查询end_time大于当前日期且（最后处理时间+周期时间）>=今天的表获取对应的id；开始时间要小于当前日期，结束时间要大于当前日期；如果未设置开始结束时间则不计入条件
        ArrayList<Integer> inths=maintenanceMapper.selectChangePlanHis(time);
        //获取到id后扫描全表获取信息如果his表中状态不存在或者存在状态为1则新插入一条信息
        //首先获取id表示存在且状态为0
        ArrayList<Integer> inthsHas=maintenanceMapper.selecthas(inths);
        int allLength=inths.size();
        for(int j:inthsHas){
            for(int i=inths.size()-1;i>=0;i--){
                if(inths.get(i)==j){
                    inths.remove(i);
                }
            }
        }
        //查询所有相关的id对应信息
        ArrayList<SysMaintenance> sysMaintenances=maintenanceMapper.selectNeedAddPlanById(inths);
        //按照idinsert数据
        int code=0;
        for(SysMaintenance sysMaintenance:sysMaintenances){
            code=maintenanceMapper.insertIntoMaintenance_his(sysMaintenance,sysMaintenance.getId())>0?200:201;

        }
        return new ResultMap<>(code,"",null);
    }

    @Override
    @Transactional
    public ResultMap<BoMaintenanceList> selectEquipmentList(BoMaintenancePlanLimit boMaintenancePlanLimit) {
        boMaintenancePlanLimit.setPageSize(boMaintenancePlanLimit.getPageSize()-1);
        boMaintenancePlanLimit.setPageNum(boMaintenancePlanLimit.getPageNum()-1);
        if(boMaintenancePlanLimit.getStart_time()=="")
            boMaintenancePlanLimit.setStart_time(null);
        if(boMaintenancePlanLimit.getEnd_time()=="")
            boMaintenancePlanLimit.setEnd_time(null);

        boMaintenanceList.setBoMaintenanceInfs(maintenanceMapper.selectBomainTenanceInfs(boMaintenancePlanLimit));
        boMaintenanceList.setAllNum(maintenanceMapper.selectBomainTenanceInfsNum(boMaintenancePlanLimit));

        for(BoMaintenanceInf boMaintenanceInf:boMaintenanceList.getBoMaintenanceInfs()){
            Integer state=maintenanceMapper.selectMaintenanceStateByPlanId(boMaintenanceInf.getId());
            if(state==null){
                boMaintenanceInf.setState("周期外");
            }else if(state==0){
                boMaintenanceInf.setState("待处理");
            }else{
                boMaintenanceInf.setState("已处理");
            }

        }

        return new ResultMap<>(200,"",boMaintenanceList);
    }

    @Override
    @Transactional
    public ResultMap<Integer> deleteMaintenance(Integer id) {
        System.out.println(id);
        int code=maintenanceMapper.deleteMaintenance(id)+maintenanceMapper.deleteMaintenance_his_doing(id)>=1?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    @Transactional
    public ResultMap<BoMaintenanceInf>  selectBoMaintenanceInf(Integer id) {
        boMaintenanceInf=maintenanceMapper.selectMaintanceInfById(id);

        return new ResultMap<>(200,"",boMaintenanceInf);
    }

    @Override
    public ResultMap<BoMaintenanceInf>  selectBoMaintenanceInfhis(Integer id) {
        boMaintenanceInf=maintenanceMapper.selectMaintanceInfhisById(id);

        return new ResultMap<>(200,"",boMaintenanceInf);
    }

    @Override
    @Transactional
    public ResultMap<Integer>  editMaintenance(SysMaintenance editInf) {
        if(editInf.getStart_time()==""){
            editInf.setStart_time(null);
        }
        if(editInf.getEnd_time()==""){
            editInf.setEnd_time(null);
        }
        if(maintenanceMapper.updateMaintenance(editInf)>0){
            scheduleOfScan();
            return new ResultMap<>(200,"",null);
        }
        return new ResultMap<>(201,"",null);
    }

    @Override
    @Transactional
    public ResultMap<BoMaintenanceHisList> selectBoMaintenanceHisList(BoMaintenancePlanLimit boMaintenancePlanLimit, LoginInf loginInf) {
        boMaintenancePlanLimit.setPageNum(boMaintenancePlanLimit.getPageNum()*10);
        boMaintenancePlanLimit.setUserId(loginInf.getUserId());
        if(boMaintenancePlanLimit.getStart_time()=="")
            boMaintenancePlanLimit.setStart_time(null);
        if(boMaintenancePlanLimit.getEnd_time()=="")
            boMaintenancePlanLimit.setEnd_time(null);
        boMaintenanceHisList.setBoMaintenanceHisInfs(maintenanceMapper.selectBoMaintenanceHisInf(boMaintenancePlanLimit));
        boMaintenanceHisList.setAllNum(maintenanceMapper.selectBoMaintenanceHisInfNum(boMaintenancePlanLimit));
//        System.out.println(boMaintenanceHisList.toString());

        return new ResultMap<>(200,null,boMaintenanceHisList);
    }

    @Override
    @Transactional
    public ResultMap<Integer>  updatemaintenanceHis(MultipartFile file, String maintenance_do_des, Integer HisId,Integer planId) {
        String time= LocalDateTime.now().toString();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dotime=dtf.format(LocalDateTime.now());
        String fName=null;
        String filePath="";
        if(file!=null&&!file.isEmpty()){
            fName=file.getOriginalFilename();
            //生产环境路径
            //filePath="D:\\java\\test\\uploads\\"+time.substring(0,10);
            //工程环境路径
            filePath="src\\main\\resources\\static\\uploads\\"+time.substring(0,10);
            try {
                File filemkdir=new File(filePath);
                if(!filemkdir.exists()) {//如果文件夹不存在
                    filemkdir.mkdir();//创建文件夹
                }
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath+"\\"+fName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new ResultMap<>(201,"",null);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResultMap<>(201,"",null);
            }
        }
        if(maintenanceMapper.updatemaintenanceHis(fName,maintenance_do_des,dotime,HisId)>0) {
            if(maintenanceMapper.updatemaintenancePlan(time,planId)>0)
                return new ResultMap<>(200,"",null);
        }
        return new ResultMap<>(201,"",null);
    }


}
