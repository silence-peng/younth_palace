package com.ruiwang.younthpalace.service.power.impl;

import com.ruiwang.younthpalace.entity.power.SysMenu;
import com.ruiwang.younthpalace.entity.power.SysPosition;
import com.ruiwang.younthpalace.mapper.power.MenuMapper;
import com.ruiwang.younthpalace.service.power.IMenuService;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
public class MenuService implements IMenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public ResultMap<Integer> addMenu(SysMenu sysMenu) {
        int code= menuMapper.insertIntoMenu(sysMenu)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<ArrayList<SysMenu>> getMenuList() {
        return new ResultMap<>(200,"",menuMapper.selectSysMenu());
    }

    @Override
    public ResultMap<ArrayList<SysMenu>> getUserMenu(Integer id) {
        return new ResultMap<>(200,"",menuMapper.getUserMenu(id));
    }

    @Override
    @Transactional
    public ResultMap<Integer> setUserMenu(Integer[] menuId, Integer id) {
        int code=0;
        //删除用户相关的权限
        menuMapper.deleteUserMenu(id);
        //重新录入新版
        for(Integer mId : menuId){
            System.out.println(mId);
            code=menuMapper.insertIntoUserMenu(id,mId)>0?200:201;
        }
        //更新当前session中的用户权限
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<ArrayList<SysPosition>> getPosList() {
        return new ResultMap<>(200,"",menuMapper.selectPosList());
    }

    @Override
    public ResultMap<ArrayList<SysPosition>> getUserPos(Integer id) {
        return new ResultMap<>(200,"",menuMapper.getUserPos(id));
    }

    @Override
    @Transactional
    public ResultMap<Integer> setUserPos(Integer[] posid, Integer id, HttpServletRequest httpServletRequest) {
        int code=0;
        //删除用户相关的权限
        menuMapper.deleteUserPos(id);
        //重新录入新版
        for(Integer pId : posid){
            code=menuMapper.insertIntoUserPos(id,pId)>0?200:201;
        }
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<ArrayList<SysMenu>> getRoleMenu(Integer id) {
        return new ResultMap<>(200,"",menuMapper.getRoleMenu(id));
    }

    @Override
    @Transactional
    public ResultMap<Integer> setRoleMenu(Integer[] menuId, Integer id) {
        //删除用户相关的权限
        int code=0;
        menuMapper.deleteRoleMenu(id);
        //重新录入新版
        for(Integer mId : menuId){
            code=menuMapper.insertIntoRoleMenu(id,mId)>0?200:201;
        }
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<ArrayList<SysPosition>> getRolePos(Integer id) {
        return new ResultMap<>(200,"",menuMapper.getRolePos(id));
    }

    @Override
    @Transactional
    public ResultMap<Integer> setRolePos(Integer[] posid, Integer id) {
        int code=0;
        //删除用户相关的权限
        menuMapper.deleteRolePos(id);
        //重新录入新版
        for(Integer pId : posid){
            code=menuMapper.insertIntoRolePos(id,pId)>0?200:201;
        }
        return new ResultMap<>(code,"",null);
    }


}
