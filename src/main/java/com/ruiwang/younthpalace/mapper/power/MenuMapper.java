package com.ruiwang.younthpalace.mapper.power;

import com.ruiwang.younthpalace.entity.power.SysMenu;
import com.ruiwang.younthpalace.entity.power.SysPosition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MenuMapper {
    Integer insertIntoMenu(@Param("sysMenu") SysMenu sysMenu);
    ArrayList<SysMenu> selectSysMenu();
    ArrayList<SysMenu> selectMenuchild(@Param("id") Integer id);
    ArrayList<SysMenu> getUserMenu(@Param("userId") Integer id);
    Integer deleteUserMenu(@Param("userId") Integer id);
    Integer insertIntoUserMenu(@Param("userId") Integer id, @Param("menuId") Integer menuId);
    ArrayList<SysPosition> selectPosList();
    ArrayList<SysPosition> getUserPos(@Param("userId") Integer id);
    Integer deleteUserPos(@Param("userId") Integer id);
    Integer insertIntoUserPos(@Param("userId") Integer id, @Param("positionId") Integer positionId);

    ArrayList<SysMenu> getRoleMenu(@Param("roleId") Integer id);
    Integer deleteRoleMenu(@Param("roleId") Integer id);
    Integer insertIntoRoleMenu(@Param("roleId") Integer id, @Param("menuId") Integer menuId);
    ArrayList<SysPosition> getRolePos(@Param("roleId") Integer id);
    Integer deleteRolePos(@Param("roleId") Integer id);
    Integer insertIntoRolePos(@Param("roleId") Integer id, @Param("positionId") Integer positionId);

}
