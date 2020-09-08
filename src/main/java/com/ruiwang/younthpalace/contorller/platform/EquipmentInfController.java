package com.ruiwang.younthpalace.contorller.platform;

import com.ruiwang.younthpalace.bojo.platform.BoEquipmentInfAdd;
import com.ruiwang.younthpalace.bojo.platform.BoEquipmentInfLimit;
import com.ruiwang.younthpalace.bojo.platform.BoEquipmentInfList;
import com.ruiwang.younthpalace.bojo.platform.BoEquipmentInfReady;

import com.ruiwang.younthpalace.entity.platform.SysEquipmentInfo;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentPosition;
import com.ruiwang.younthpalace.service.platform.IEquipmentInfService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Map;

@Api(description = "设备接口")
@Controller
@RequestMapping("/platform")
public class EquipmentInfController {
    @Autowired
    IEquipmentInfService equipmentInfService;
    @Autowired
    BoEquipmentInfAdd boEquipmentInfAdd;



    @ApiOperation(value="获取设备页面初始化数据", notes="数据初始化接口")
    @CrossOrigin
    @ResponseBody
    @GetMapping("/loadInf")
    public ResultMap<BoEquipmentInfReady> loadInf(){
        return equipmentInfService.getEquipmentInf();
    }

//    @ApiOperation(value="获取设备台账位置信息", notes="获取设备位置信息接口")
//    @ApiImplicitParam(name = "id",value = "")
//    @CrossOrigin
//    @ResponseBody
//    @PostMapping("/loadFloor")
//    public ResultMap<ArrayList<SysEquipmentPosition>> loadFloor(Integer id){
//        return equipmentInfService.getSysEquipmentPosition(id);
//    }


//    @ApiOperation(value="批量添加设备台账信息", notes="Excel批量导入")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "file", value = "设备台账信息文件", paramType = "MultipartFile",  dataType = "MultipartFile")
//    })
//    @CrossOrigin
//    @ResponseBody
//    @PostMapping("/addequipmentInfall")
//    public ResultMap<Integer> addequipmentInfall( @RequestPart(value = "file",required = false) MultipartFile file){
//        return  equipmentInfService.addequipmentInfAll();
//    }


    @ApiOperation(value="获取设备台账列表信息", notes="获取设备台账列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boEquipmentInfLimit", value = "设备分类封装类",required = true, paramType = "BoEquipmentInfLimit",  dataType = "BoEquipmentInfLimit")
    })
    @CrossOrigin
    @ResponseBody
    @PostMapping("/equipmentInfList")
    public ResultMap<BoEquipmentInfList> equipmentInfList(BoEquipmentInfLimit boEquipmentInfLimit){
        return  equipmentInfService.selectEquipmentList(boEquipmentInfLimit);

    }
    @ApiOperation(value="检查设备编号是否重复" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "equipmentCode", value = "设备编号",required = true, paramType = "String",  dataType = "String")
    })
    @CrossOrigin
    @ResponseBody
    @PostMapping("/checkEquipmentCode")
    public ResultMap<Integer> checkEquipmentCode(@RequestBody String equipmentCode){
        return  equipmentInfService.checkEquipmentCode(equipmentCode);
    }

    @ApiOperation(value="获取单个设备台账信息接口", notes="获取单个设备信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "设备编码", required = true,paramType = "String",  dataType = "String")
    })
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getequipmentInf")
    public ResultMap<SysEquipmentInfo> getequipmentInf(@RequestBody String id){
       return  equipmentInfService.getSysEquipmentInfById(Integer.parseInt(id.split("=")[1]));
    }
    @ApiOperation(value="添加设备台账信息")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/addequipmentInf")
    public ResultMap<Integer> addequipmentInf(BoEquipmentInfAdd boEquipmentInfAdd){
        System.out.println(boEquipmentInfAdd);
        return equipmentInfService.addequipmentInf(boEquipmentInfAdd);
    }
    @ApiOperation(value="编辑单个设备台账的信息接口", notes="编辑单个设备台账的信息")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/editequipmentInfsub")
    public ResultMap<Integer> editequipmentInfsub(
           BoEquipmentInfAdd boEquipmentInfAdd
    ){
            return equipmentInfService.editequipmentInf(boEquipmentInfAdd);
    }
//    @ApiOperation(value = "根据台账id获取位置中文信息",notes = "根据台账id获取位置中文信息接口")
//    @ApiImplicitParam(name = "id", value = "台账id", required = true,paramType = "String", dataType = "String")
//    @CrossOrigin
//    @ResponseBody
//    @PostMapping("/getPosition")
//    public ResultMap<String> editequipmentInfsub(String id){
//        return equipmentInfService.getPositonById(Integer.parseInt(id));
//    }
    @ApiOperation(value = "根据台账id删除接口",notes = "根据台账id删除接口")
    @ApiImplicitParam(name = "id", value = "台账id", required = true,paramType = "String", dataType = "String")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/deleteequipmentInf")
    public ResultMap<Integer> deleteequipmentInf(@RequestBody String id){
        return equipmentInfService.deleteequipmentInf(Integer.parseInt(id.split("=")[1]));
    }

}
