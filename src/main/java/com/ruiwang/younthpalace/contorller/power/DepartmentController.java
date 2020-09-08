package com.ruiwang.younthpalace.contorller.power;

import com.ruiwang.younthpalace.bojo.power.BoDepartment;
import com.ruiwang.younthpalace.bojo.power.DepartmentLimit;
import com.ruiwang.younthpalace.entity.power.SysDepartment;
import com.ruiwang.younthpalace.service.power.impl.DepartmentService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Api(description = "部门接口")
@Controller
@RequestMapping("/power")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
//    @CrossOrigin
//    @RequestMapping("/departmentManage")
//    public String departmentManage(){
//        return "power/departmentManage";
//    }

    /**
     * 查询部门列表
     * @param departmentLimit
     * @return
     */
    @ApiOperation(value = "按照限制条件查询部门列表接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/departmentList")
    public ResultMap<BoDepartment> departmentList(DepartmentLimit departmentLimit){
        return departmentService.selectDepartmentList(departmentLimit);
    }

    /**
     * 添加部门
     * @param departmentName
     * @return
     */
    @ApiOperation(value = "添加部门接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/addDepartment")
    public ResultMap<Integer> addDepartment(@RequestBody String departmentName){
        return departmentService.addDepartment(departmentName);
    }

    /**
     * 删除部门
     * @param departmentId
     * @return
     */
    @ApiOperation(value = "根据部门id删除部门")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/deleteDepartment")
    public ResultMap<Integer> deleteDepartment(@RequestBody String departmentId){
        return departmentService.deleteDepartment(departmentId);
    }

    /**
     * 编辑部门列表
     * @param editInf
     * @return
     */
    @ApiOperation(value = "编辑部门信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/editDepartment")
    public ResultMap<Integer> deitDepartment(@RequestBody String editInf){
        return departmentService.updateDepartment(editInf);
    }
    /**
     * 查询所有部门
     * @return 部门列表
     */
    @ApiOperation(value = "加载部门信息列表")
    @CrossOrigin
    @ResponseBody
    @GetMapping("/allDepartment")
    public ResultMap<ArrayList<SysDepartment>> allDepartment(){
        return departmentService.selectDepartmentAll();
    }
}
