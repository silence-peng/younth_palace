package com.ruiwang.younthpalace.service.power.impl;

import com.ruiwang.younthpalace.bojo.LoginInf;
import com.ruiwang.younthpalace.bojo.power.BoUser;
import com.ruiwang.younthpalace.bojo.power.BoUserForReady;
import com.ruiwang.younthpalace.bojo.power.UserLimit;
import com.ruiwang.younthpalace.entity.power.SysDepartment;
import com.ruiwang.younthpalace.entity.power.SysMenu;
import com.ruiwang.younthpalace.entity.power.SysPosition;
import com.ruiwang.younthpalace.entity.power.SysUser;
import com.ruiwang.younthpalace.mapper.power.DepartmentMapper;
import com.ruiwang.younthpalace.mapper.power.MenuMapper;
import com.ruiwang.younthpalace.mapper.power.RoleMapper;
import com.ruiwang.younthpalace.mapper.power.UserMapper;
import com.ruiwang.younthpalace.pojo.power.PoUserDepartment;
import com.ruiwang.younthpalace.pojo.power.PoUserRole;
import com.ruiwang.younthpalace.service.power.IUserService;
import com.ruiwang.younthpalace.util.ResultMap;
import com.ruiwang.younthpalace.util.XlsxImporTexportTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BoUserForReady boUserForReady;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    LoginInf loginInf;

    @Override
    public ResultMap<Integer> exportUserListFile(MultipartFile file) {
//        String fileName=file.getOriginalFilename();
//        String path=ImgInfoServiceImpl.getUploadPath()+File.separator +fileName;
//        File uploadFile=new File(path);
//        if (!uploadFile.exists()){
//            uploadFile.mkdirs();
//        }else {
//            uploadFile.delete();
//        }
//        try {
//            file.transferTo(uploadFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        List<SysDepartment> list= XlsxImporTexportTemplate.importData(file,1,SysDepartment.class);
        System.out.println(list);
        try{
            if (null!=list){
                for (SysDepartment de: list) {

                }
            }
        }finally {

        }


        return null;
    }

    @Override
    public ResultMap<SysUser> selectByName(String userName) {
        return new ResultMap(200,"",userMapper.selectByUserName(userName));
    }

    @Override
    @Transactional
    public ResultMap<BoUserForReady> selectBoUserForReady(UserLimit userLimit) {
        if (userLimit.getDate() != "") {
            userLimit.setDateStart(userLimit.getDate() + " 00:00:00");
            userLimit.setDateEnd(userLimit.getDate() + " 23:59:59");
        }
        userLimit.setPageNum(userLimit.getPageNum() -1);
        userLimit.setPageSize(userLimit.getPageSize() -1);
        //查询部门列表
        boUserForReady.setSysDepartments(departmentMapper.selectDepartmentAll());
        boUserForReady.setSysRoles(roleMapper.selectRoleAll());
        boUserForReady.setBoUser(userMapper.selectBoUserList(userLimit));
        boUserForReady.setAllNum(userMapper.selectBoUserListAll(userLimit));
        return new ResultMap<>(200,"",boUserForReady);
    }

    @Override
    @Transactional
    public ResultMap<Integer> insertIntoUser(BoUser boUser) {
        //首先查询是否存在此用户存在则更新用户信息
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        boUser.setCreatetime(LocalDateTime.now().format(dtf));
        if(boUser.getEntryDate()==""){
            boUser.setEntryDate(null);
        }
        userMapper.insertIntoUser(boUser);
//------------------------------------------------
        int insertUserId=boUser.getId();
        if(boUser.getDepartmentId()!=-1) {
            userMapper.insertIntoUserDepartment(insertUserId, boUser.getDepartmentId());
        }
//----------------------------------------------
        if(boUser.getRoleId()!=-1){
            //删除权限
            menuMapper.deleteUserMenu(insertUserId);
            menuMapper.deleteUserPos(insertUserId);
            //查询role权限
            ArrayList<SysMenu> sysMenus=menuMapper.getRoleMenu(boUser.getRoleId());
            ArrayList<SysPosition> sysPositions=menuMapper.getRolePos(boUser.getRoleId());
            //插入role对应的权限
            for(SysMenu sysMenu :sysMenus){
                menuMapper.insertIntoUserMenu(insertUserId,sysMenu.getId());
            }
            for(SysPosition sysPosition :sysPositions){
                menuMapper.insertIntoUserPos(insertUserId,sysPosition.getId());
            }
            //更新userRole
            userMapper.insertIntoUserRole(insertUserId,boUser.getRoleId());
        }
        int code= insertUserId>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<Integer> deleteUser(int userId) {
        int code= userMapper.deleteUserByUserId(userId)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<BoUser> selectByUserId(int userId) {
        return new ResultMap<>(200,"",userMapper.selectBoUserById(userId));
    }

    @Override
    @Transactional
    public ResultMap<Integer> updateUser(BoUser boUser) {

        int result=0;
        if(boUser.getEntryDate()==""){
            boUser.setEntryDate(null);
        }
        userMapper.updateUser(boUser);
        if(boUser.getDepartmentId()!=-1){
            userMapper.updateUserDepartment(boUser.getId(),boUser.getDepartmentId());
        }else{
            userMapper.deleteUserDepartment(boUser.getId());
        }
        if(boUser.getRoleId()!=-1){
            userMapper.updateUserRole(boUser.getId(),boUser.getRoleId());
            menuMapper.deleteUserMenu(boUser.getId());
            menuMapper.deleteUserPos(boUser.getId());
            ArrayList<SysMenu> sysMenus=menuMapper.getRoleMenu(boUser.getRoleId());
            ArrayList<SysPosition> sysPositions=menuMapper.getRolePos(boUser.getRoleId());
            for(SysMenu sysMenu :sysMenus){
                menuMapper.insertIntoUserMenu(boUser.getId(),sysMenu.getId());
            }
            for(SysPosition sysPosition :sysPositions){
                menuMapper.insertIntoUserPos(boUser.getId(),sysPosition.getId());
            }
        }else{
            result=userMapper.updateUserRole(boUser.getId(),null)+
            menuMapper.deleteUserMenu(boUser.getId())>0?200:201+
            menuMapper.deleteUserPos(boUser.getId());
        }int code=result==3?200:201;
        return new ResultMap<>(200,"",null);
    }

    @Override
    public ResultMap<Integer> updateUserState(int userId, int state) {
        if(userMapper.selectStateByUserId(userId)==null||userMapper.selectStateByUserId(userId)!=-1){
            int code=userMapper.updateUserState(userId,state)>0?200:201;
            return new ResultMap<>(code,"",null);
        }
        return new ResultMap<>(201,"",null);
    }

    @Override
    @Transactional
    public LoginInf loginReady(String userName) {
        SysUser sysUser=userMapper.selectByUserName(userName);
        loginInf.setUserId(sysUser.getId());
        loginInf.setUserName(sysUser.getUserName());
        loginInf.setMenuList(userMapper.getUserMenu(sysUser.getId()));
        loginInf.setPositionList(userMapper.getUserPosition(sysUser.getId()));
        return loginInf;
    }

    @Override
    public ResultMap<PoUserDepartment> getPoUserDepartment(String userName) {
        return new ResultMap<>(200,"",userMapper.selectPoUserDepartment(userName));
    }

    @Override
    public ResultMap<PoUserRole> getPoUserRole(String userName) {
        return new ResultMap<>(200,"",userMapper.selectPoUserRole(userName));
    }


}
