package com.ruiwang.younthpalace.contorller.power;

import com.ruiwang.younthpalace.bojo.power.BoUser;
import com.ruiwang.younthpalace.bojo.power.BoUserForReady;
import com.ruiwang.younthpalace.bojo.power.UserLimit;
import com.ruiwang.younthpalace.entity.power.SysUser;
import com.ruiwang.younthpalace.pojo.power.PoUserDepartment;
import com.ruiwang.younthpalace.pojo.power.PoUserRole;
import com.ruiwang.younthpalace.service.power.impl.UserService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Api(description = "用户管理接口")
@Controller
@RequestMapping("/power")
public class UserController {
    @Autowired
    UserService userService;

//    @CrossOrigin
//    @RequestMapping("/userManage")
////    @MAspect("91")
//    public String userManage(){
//        return "power/userManage";
//    }
    @ApiOperation(value = "用户查询接口",notes = "用户查询接口-分页")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/userList")
//    @MAspect("127")
    public ResultMap<BoUserForReady> userList(UserLimit userLimit){
        return userService.selectBoUserForReady(userLimit);
    }

    @ApiOperation(value = "用户添加接口",notes = "用户添加")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/addUser")
//    @MAspect("246")//用户添加
    public ResultMap<Integer> addUser(BoUser boUser){
        return userService.insertIntoUser(boUser);
    }
    @ApiOperation(value = "根据name查询用户",notes = "根据name查询用户")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/hasUser")
    public ResultMap<SysUser> hasUser(BoUser boUser){
        return userService.selectByName(boUser.getUserName());
    }

    @ApiOperation(value = "根据name查询用户",notes = "根据name查询用户")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/deleteUser")
//    @MAspect("251")//用户删除
    public ResultMap<Integer> deleteUser( int userId){
        return userService.deleteUser(userId);
    }

    @ApiOperation(value = "根据用户id查询用户信息接口",notes = "根据用户id查询用户信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getUserInf")
    public ResultMap<BoUser> getUserInf(@RequestBody String userId){
        return userService.selectByUserId(Integer.parseInt(userId.split("=")[1]));
    }

    @ApiOperation(value = "编辑用户信息接口",notes = "编辑用户接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/editUser")
//    @MAspect("252")//编辑用户
    public ResultMap<Integer> editUser(BoUser boUser){

        return userService.updateUser(boUser);
    }

    @ApiOperation(value = "更新用户状态接口",notes = "更新用户状态")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/updateUserState")
//    @MAspect("248")
    public ResultMap<Integer> updateUserState(int userId, int state){

        return userService.updateUserState(userId, state);
    }

    @ApiOperation(value = "获取用户相关预防性维护计划信息接口",notes = "获取用户相关预防性维护计划信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getMaintenanceUserInf")
    public ResultMap<PoUserRole> getMaintenanceUserInf(String userName){
        return userService.getPoUserRole(userName);
    }

    @ApiOperation(value = "获取用户相关预防性维护计划信息、部门接口",notes = "获取用户相关预防性维护计划信息、部门接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getMaintenanceUserInfdepart")
    public ResultMap<PoUserDepartment> getMaintenanceUserInfdepart(String userName){
        return userService.getPoUserDepartment(userName);
    }
    @ApiOperation(value = "通过文件导入用户信息接口",notes = "通过文件导入用户信息接口")
    @CrossOrigin
    @ResponseBody
    @PostMapping("/exportUserFile")
    public ResultMap<Integer> exportUserFile(MultipartFile file){
        return userService.exportUserListFile(file);
    }


}
