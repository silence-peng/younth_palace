package com.ruiwang.younthpalace.contorller.platform;

import com.ruiwang.younthpalace.bojo.LoginInf;
import com.ruiwang.younthpalace.bojo.platform.*;
import com.ruiwang.younthpalace.entity.platform.SysMaintenance;
import com.ruiwang.younthpalace.service.platform.IEquipmentInfService;
import com.ruiwang.younthpalace.service.platform.IMaintenanceService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
@Api(description = "预防性维护计划接口")
@Controller
@RequestMapping("/platform")
public class MaintenanceController {
    @Autowired
    IEquipmentInfService equipmentInfService;
    @Autowired
    IMaintenanceService maintenanceService;
//    @CrossOrigin
//    @RequestMapping("/maintenancePage")
//    public String maintenancePage(){
//        return "platform/maintenancePage";
//    }
//    @CrossOrigin
//    @RequestMapping("/maintenanceDoPage")
//    public String maintenanceDoPage(){
//        return "platform/maintenanceDoPage";
//    }
//    @CrossOrigin
//    @RequestMapping("/maintenanceHisPage")
//    public String maintenanceHisPage(){
//        return "platform/maintenanceHisPage";
//    }


    @CrossOrigin
    @ResponseBody
    @PostMapping("/getMaintenanceReady")
    public ResultMap<BoMaintenanceEquipmentInf> getMaintenanceReady(String inf){
        return equipmentInfService.selectBoMaintenanceEquipmentInfByNum(inf);
    }
    @ApiOperation(value = "添加预防性维护计划接口",notes = "添加预防性维护计划接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/addMaintenance")
    public ResultMap<Integer> addMaintenance(SysMaintenance addInf){
        return maintenanceService.addMaintenanceService(addInf);
    }
    @ApiOperation(value = "加载预防性维护计划列表接口",notes = "加载预防性维护计划列表接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/maintenanceList")
    public ResultMap<BoMaintenanceList> maintenanceList(BoMaintenancePlanLimit boMaintenancePlanLimit){
        return maintenanceService.selectEquipmentList(boMaintenancePlanLimit);
    }
    @ApiOperation(value = "根据id删除预防性维护计划列表接口",notes = "根据id删除预防性维护计划列表接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/deleteMaintenance")
    public ResultMap<Integer> deleteMaintenance(Integer id){
        return maintenanceService.deleteMaintenance(id);
    }

    @ApiOperation(value = "根据id获取预防性维护计划信息接口",notes = "根据id获取预防性维护计划信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getMaintenance")
    public ResultMap<BoMaintenanceInf> getMaintenance(Integer id){
        return maintenanceService.selectBoMaintenanceInf(id);
    }

    @ApiOperation(value = "根据id获取历史预防性维护计划信息接口",notes = "根据id获取历史预防性维护计划信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getMaintenancehis")
    public ResultMap<BoMaintenanceInf> getMaintenancehis(Integer id){
        return maintenanceService.selectBoMaintenanceInfhis(id);
    }

    @ApiOperation(value = "编辑预防性维护计划信息接口",notes = "编辑预防性维护计划信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/editMaintenance")
    public ResultMap<Integer> editMaintenance(SysMaintenance addInf){
        return maintenanceService.editMaintenance(addInf);
    }

    @ApiOperation(value = "加载历史预防性维护计划信息列表接口",notes = "加载历史预防性维护计划信息列表接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/maintenanceHisList")
    public ResultMap<BoMaintenanceHisList> maintenanceHisList(BoMaintenancePlanLimit boMaintenancePlanLimit, HttpServletRequest httpServletRequest){

        return maintenanceService.selectBoMaintenanceHisList(boMaintenancePlanLimit,(LoginInf)httpServletRequest.getSession().getAttribute("loginInf"));
    }

    @ApiOperation(value = "修改历史预防性维护计划信息接口",notes = "修改历史预防性维护计划信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/updatemaintenanceHis")
    public ResultMap<Integer> updatemaintenanceHis(@RequestPart(value = "file",required = false)MultipartFile file,String maintenance_do_des,Integer hisId,Integer planId){
        return maintenanceService.updatemaintenanceHis(file,maintenance_do_des,hisId,planId);
    }

}
