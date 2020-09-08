package com.ruiwang.younthpalace.service.power;

import com.ruiwang.younthpalace.entity.power.SysMenu;
import com.ruiwang.younthpalace.entity.power.SysPosition;
import com.ruiwang.younthpalace.util.ResultMap;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public interface IMenuService {
    ResultMap<Integer> addMenu(SysMenu sysMenu);
    ResultMap<ArrayList<SysMenu>> getMenuList();
    ResultMap<ArrayList<SysMenu>> getUserMenu(Integer id);
    ResultMap<Integer> setUserMenu(Integer[] menuId, Integer id);
    ResultMap<ArrayList<SysPosition>> getPosList();
    ResultMap<ArrayList<SysPosition>> getUserPos(Integer id);
    ResultMap<Integer> setUserPos(Integer[] posid, Integer id, HttpServletRequest httpServletRequest);

    ResultMap<ArrayList<SysMenu>> getRoleMenu(Integer id);
    ResultMap<Integer> setRoleMenu(Integer[] menuId, Integer id);
    ResultMap<ArrayList<SysPosition>> getRolePos(Integer id);
    ResultMap<Integer> setRolePos(Integer[] posid, Integer id);
}
