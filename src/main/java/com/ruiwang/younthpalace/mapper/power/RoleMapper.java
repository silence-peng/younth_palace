package com.ruiwang.younthpalace.mapper.power;

import com.ruiwang.younthpalace.bojo.power.BoRole;
import com.ruiwang.younthpalace.bojo.power.RoleLimit;
import com.ruiwang.younthpalace.entity.power.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RoleMapper {
    //查询全部角色
    ArrayList<SysRole> selectRoleAll();
    //按条件查询角色列表
     ArrayList<BoRole> selectRoleList(@Param("roleLimit") RoleLimit roleLimit);
    //按条件查询角色数量
    int selectRoleListNum(@Param("roleLimit") RoleLimit roleLimit);
    //查询是否存在此角色
    int selectRoleByroleName(@Param("roleName") String roleName);
    //插入新用户
    int insertIntoRole(@Param("roleName") String roleName, @Param("roleNote") String roleNote);
    //删除用户
    int deleteRoleById(@Param("roleId") int roleId);
    //更新用户
    int updateRole(@Param("id") int id, @Param("roleName") String roleName, @Param("roleNote") String roleNote);
}
