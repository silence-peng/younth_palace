package com.ruiwang.younthpalace.contorller.platform;

import com.ruiwang.younthpalace.bojo.platform.BoWorkPlan;
import com.ruiwang.younthpalace.bojo.platform.BoWorkPlanLimit;
import com.ruiwang.younthpalace.bojo.platform.BoWorkPlanList;
import com.ruiwang.younthpalace.entity.platform.SysWorkPlan;
import com.ruiwang.younthpalace.service.platform.IWorkPlanService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@Api(description = "工作计划接口")
@Controller
@RequestMapping("/platform")
public class WorkPlanController {
    @Autowired
    IWorkPlanService workPlanService;

//    @CrossOrigin
//    @RequestMapping("/workPlan")
//    public String workPlan(){
//        return "platform/workPlan";
//    }


    @ApiOperation(value = "加载工作计划列表接口",notes = "加载工作计划列表接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getworkPlanList")
    public ResultMap<BoWorkPlanList> getworkPlanList(BoWorkPlanLimit boWorkPlanLimit){
        return workPlanService.getBoWorkPlanList(boWorkPlanLimit);
    }
    @ApiOperation(value = "根据id获取工作计划信息接口",notes = "根据id获取工作计划信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getworkPlan")
    public ResultMap<BoWorkPlan> getworkPlan(Integer id){
        System.out.println(id);
        System.out.println("------------------");
        return workPlanService.getworkPlan(id);
    }
    @ApiOperation(value = "添加工作计划接口",notes = "添加工作计划")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/addWorkPlan")
    public ResultMap<Integer> addWorkPlan(SysWorkPlan sysWorkPlan, HttpServletRequest httpServletRequest){
        return workPlanService.addWorkPlan(sysWorkPlan,httpServletRequest);
    }
    @ApiOperation(value = "编辑工作计划接口",notes = "编辑工作计划接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/editWorkPlan")
    public ResultMap<Integer> editWorkPlan(SysWorkPlan sysWorkPlan, HttpServletRequest httpServletRequest){
        return workPlanService.editWorkPlan(sysWorkPlan,httpServletRequest);
    }
    @ApiOperation(value = "根据id删除工作计划接口",notes = "根据id删除工作计划接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/deleteWorkPlan")
    public ResultMap<Integer> deleteWorkPlan(Integer id){
        return workPlanService.deleteWorkPlan(id);
    }
    @ApiOperation(value = "执行工作计划接口",notes = "执行工作计划接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/doWorkPlan")
    public ResultMap<Integer> doWorkPlan(Integer id){
        return workPlanService.doWorkPlan(id);
    }

}
