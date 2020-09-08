package com.ruiwang.younthpalace.contorller.power;

import com.ruiwang.younthpalace.bojo.power.*;
import com.ruiwang.younthpalace.entity.power.SysOrder;
import com.ruiwang.younthpalace.entity.power.SysShiftmanagement;
import com.ruiwang.younthpalace.service.power.IHandoverService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(description = "值班管理接口")
@Controller
@RequestMapping("/power")
public class HandoverController {
    @Autowired
    IHandoverService handoverService;
//
//    @RequestMapping("/handover")
//    public String handover(){
//        return "power/handover";
//    }





    @ApiOperation(value = "分页查询交接班列表信息接口")
    @CrossOrigin
    @PostMapping("/orderlistready")
    @ResponseBody
    public ResultMap<BoOrderForReady> orderlistready(OrderLimit orderLimit){
        System.out.println(orderLimit.toString());
        return handoverService.selectBoUserForReady(orderLimit);
    }

    @ApiOperation(value = "添加交接班信息接口")
    @CrossOrigin
    @PostMapping("/addOrder")
    @ResponseBody
    public ResultMap<Integer> addOrder(SysOrder sysOrder){
        return handoverService.addOrder(sysOrder);
    }

    @ApiOperation(value = "根据id查询交接班信息")
    @CrossOrigin
    @PostMapping("/getOrder")
    @ResponseBody
    public ResultMap<SysOrder> getOrder(@RequestBody String id){
        return handoverService.getOrderById(Integer.parseInt(id.split("=")[1]));
    }
    @ApiOperation(value = "编辑交接班信息")
    @CrossOrigin
    @PostMapping("/editOrder")
    @ResponseBody
    public ResultMap<Integer> editOrder(SysOrder sysOrder){
        return handoverService.editOrder(sysOrder);
    }

    @ApiOperation(value = "根据id删除交接班信息")
    @CrossOrigin
    @PostMapping("/deleteOrder")
    @ResponseBody
    public ResultMap<Integer> deleteOrder(@RequestBody String id){
        return handoverService.deleteOrder(Integer.parseInt(id.split("=")[1]));
    }


//    @RequestMapping("/shiftmanagement")
//    public ResultMap<String> shiftmanagement(){
//        return "power/shiftmanagement";
//    }
    @ApiOperation(value = "添加班次信息")
    @CrossOrigin
    @PostMapping("/shiftmanagementAdd")
    @ResponseBody
    public ResultMap<Integer> shiftmanagementAdd(SysShiftmanagement sysShiftmanagement){
//        System.out.println(sysShiftmanagement.toString());
        return handoverService.shiftmanagementAdd(sysShiftmanagement);
    }
    @ApiOperation(value = "分页查询班次列表信息")
    @CrossOrigin
    @PostMapping("/shiftmanagementList")
    @ResponseBody
    public ResultMap<BoShiftManagement> shiftmanagementList(ShiftManagementLimit sysShiftmanagement){
        return handoverService.shiftmanagementList(sysShiftmanagement);
//        return handoverService.shiftmanagementAdd(sysShiftmanagement);
    }
    @ApiOperation(value = "根据id查询班次信息")
    @CrossOrigin
    @PostMapping("/getshiftscan")
    @ResponseBody
    public ResultMap<BoShiftManagementInf> getshiftscan(Integer id){
        return handoverService.getSysShiftmanagement(id);
    }
    @ApiOperation(value = "编辑班次信息")
    @CrossOrigin
    @PostMapping("/shiftmanagementEdit")
    @ResponseBody
    public ResultMap<Integer> shiftmanagementEdit(SysShiftmanagement shiftmanagementEdit){
        if(shiftmanagementEdit.getDate()==""){
            shiftmanagementEdit.setDate(null);
        }
        return handoverService.updateSysShiftmanagement(shiftmanagementEdit,shiftmanagementEdit.getId());
    }
    @ApiOperation(value = "根据删除班次信息")
    @CrossOrigin
    @PostMapping("/deleteShift")
    @ResponseBody
    public ResultMap<Integer> deleteShift(Integer id){
        return handoverService.deleteShift(id);
    }

}
