package com.ruiwang.younthpalace.contorller.power;

import com.ruiwang.younthpalace.entity.power.SysMenu;
import com.ruiwang.younthpalace.entity.power.SysPosition;
import com.ruiwang.younthpalace.service.power.IMenuService;
import com.ruiwang.younthpalace.service.power.IUserService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
@Api(description = "权限菜单接口")
@Controller
@RequestMapping("/power")
public class MenuController {
    @Autowired
    IMenuService menuService;
    IUserService userService;

//    @CrossOrigin
//    @RequestMapping("/addMenu")
//    public String addMenu(){
//        return "platform/addMenu";
//    }
    @ApiOperation(value = "添加权限菜单")
    @CrossOrigin
    @PostMapping("/addMenuInf")
    @ResponseBody
    public  ResultMap<Integer> addMenuInf(SysMenu sysMenu){
        System.out.println(sysMenu.toString());
        System.out.println("-----");
        return menuService.addMenu(sysMenu);
    }
    @ApiOperation(value = "获取权限菜单列表")
    @CrossOrigin
    @GetMapping("/getMenuList")
    @ResponseBody
    public  ResultMap<ArrayList<SysMenu>> getMenuList(){
        return menuService.getMenuList();
    }

    @ApiOperation(value = "获取设备台账空间列表")
    @CrossOrigin
    @GetMapping("/getPosList")
    @ResponseBody
    public  ResultMap<ArrayList<SysPosition> >getPosList(){
        return menuService.getPosList();
    }

    @ApiOperation(value = "获取用户权限菜单列表")
    @CrossOrigin
    @PostMapping("/getUserMenu")
    @ResponseBody
    public  ResultMap<ArrayList<SysMenu>> getUserMenu(Integer id){
        return menuService.getUserMenu(id);
    }

    @ApiOperation(value = "获取角色权限菜单列表")
    @CrossOrigin
    @PostMapping("/getRoleMenu")
    @ResponseBody
    public  ResultMap<ArrayList<SysMenu>> getRoleMenu(Integer id){
        return menuService.getRoleMenu(id);
    }

    @ApiOperation(value = "设置用户菜单权限")
    @CrossOrigin
    @PostMapping("/setUserMenu")
    @ResponseBody
    public  ResultMap<Integer> setUserMenu(@RequestParam(value = "menuId[]")Integer[] menuId, Integer id){
        return menuService.setUserMenu(menuId,id);
    }

    @ApiOperation(value = "设置角色菜单权限")
    @CrossOrigin
    @PostMapping("/setRoleMenu")
    @ResponseBody
    public  ResultMap<Integer> setRoleMenu(@RequestParam(value = "menuId[]")Integer[] menuId, Integer id){
        return menuService.setRoleMenu(menuId,id);
    }

    @ApiOperation(value = "获取用户空间权限列表")
    @CrossOrigin
    @PostMapping("/getUserPos")
    @ResponseBody
    public ResultMap<ArrayList<SysPosition>> getUserPos(Integer id){
        return menuService.getUserPos(id);
    }

    @ApiOperation(value = "获取角色空间权限列表")
    @CrossOrigin
    @PostMapping("/getRolePos")
    @ResponseBody
    public ResultMap<ArrayList<SysPosition>> getRolePos(Integer id){
        return menuService.getRolePos(id);
    }

    @ApiOperation(value = "设置用户空间权限")
    @CrossOrigin
    @PostMapping("/setUserPos")
    @ResponseBody
    public ResultMap<Integer> setUserPos(@RequestParam(value = "posid[]")Integer[] posid, Integer id, HttpServletRequest httpServletRequest){
        return menuService.setUserPos(posid,id,httpServletRequest);
    }
    @ApiOperation(value = "设置角色间权限")
    @CrossOrigin
    @PostMapping("/setRolePos")
    @ResponseBody
    public ResultMap<Integer> setRolePos(@RequestParam(value = "posid[]")Integer[] posid, Integer id){
        return menuService.setRolePos(posid,id);
    }

}
