package com.ruiwang.younthpalace.mapper.power;

import com.ruiwang.younthpalace.bojo.power.BoUser;
import com.ruiwang.younthpalace.bojo.power.UserLimit;
import com.ruiwang.younthpalace.entity.power.SysUser;
import com.ruiwang.younthpalace.pojo.power.PoUserDepartment;
import com.ruiwang.younthpalace.pojo.power.PoUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {
    //根据名字，查询人员信息
    SysUser selectByUserName(@Param("userName") String userName);
    //根据要求查询人员列表
    ArrayList<BoUser> selectBoUserList(@Param("userLimit") UserLimit userLimit);
    //查询总人数
    Integer selectBoUserListAll(@Param("userLimit") UserLimit userLimit);
    //添加用户
    Integer insertIntoUser(@Param("boUser") BoUser boUser);
    //获取最新添加的用户信息
    Integer selectNearInf();
    //添加用户与部门关联
    Integer insertIntoUserDepartment(@Param("userId") int userId, @Param("departmentId") int departmentId);
    //添加用户与角色关联
    Integer insertIntoUserRole(@Param("userId") int userId, @Param("roleId") int roleId);
    //删除用户
    Integer deleteUserByUserId(@Param("userId") int userId);
    //获取用户信息
    BoUser selectBoUserById(@Param("userId") int userId);
    //更新用户信息
    Integer updateUser(@Param("boUser") BoUser boUser);
    //更新相关的用户部门表
    Integer updateUserDepartment(@Param("userId") int userId, @Param("departmentId") int departmentId);
    Integer deleteUserDepartment(@Param("userId") int userId);
    //更新相关的角色关联表
    Integer updateUserRole(@Param("userId") int userId, @Param("roleId") Integer roleId);
    Integer deleteUserRole(@Param("userId") int userId);
    //更新用户状态
    Integer updateUserState(@Param("userId") int userId, @Param("state") int state);
    //查询用户状态
    Integer selectStateByUserId(@Param("userId") int userId);
    //查询用户相关的menu
    ArrayList<String> getUserMenu(@Param("userId") int userId);
    //查询用户相关的poosition
    ArrayList<String> getUserPosition(@Param("userId") int userId);

    PoUserDepartment selectPoUserDepartment(@Param("userName") String userName);
    PoUserRole selectPoUserRole(@Param("userName") String userName);
}
