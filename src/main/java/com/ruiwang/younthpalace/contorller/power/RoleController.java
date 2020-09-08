package com.ruiwang.younthpalace.contorller.power;


import com.ruiwang.younthpalace.bojo.power.BoRoleForReady;
import com.ruiwang.younthpalace.bojo.power.RoleLimit;
import com.ruiwang.younthpalace.entity.power.SysRole;
import com.ruiwang.younthpalace.service.power.impl.RoleService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Api(description = "角色管理接口")
@Controller
@RequestMapping("/power")
public class RoleController {
    @Autowired
    RoleService roleService;


//    @CrossOrigin
//    @RequestMapping("/roleManage")
//    public String roleManage(){
//        return "power/roleManage";
//    }
    @ApiOperation(value = "分页查询角色列表")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/roleList")
    public ResultMap<BoRoleForReady> roleList(RoleLimit roleLimit){
        return roleService.selectRoleList(roleLimit);
    }
    @ApiOperation(value = "添加角色信息")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/addRole")
    public ResultMap<Integer> addRole(@RequestBody String roleInf){
        return roleService.addRole(roleInf);
    }
    @ApiOperation(value = "根据id删除角色信息")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/deleteRole")
    public ResultMap<Integer> deleteDepartment(@RequestBody String roleId){
        return roleService.deleteRole(roleId);
    }

    @ApiOperation(value = "编辑角色信息")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/editRole")
    public ResultMap<Integer> editRole(@RequestBody String editInf){
        return roleService.editRole(editInf);
    }
    @ApiOperation(value = "加载角色信息列表")
    /**
     * 查询所有角色
     * @return 角色列表
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping("/allRole")
    public ResultMap<ArrayList<SysRole>> allRoles(){
        return roleService.selectRoleAll();
    }

}
