package com.ruiwang.younthpalace.service.power;

import com.ruiwang.younthpalace.bojo.LoginInf;
import com.ruiwang.younthpalace.bojo.power.BoUser;
import com.ruiwang.younthpalace.bojo.power.BoUserForReady;
import com.ruiwang.younthpalace.bojo.power.UserLimit;
import com.ruiwang.younthpalace.entity.power.SysUser;
import com.ruiwang.younthpalace.pojo.power.PoUserDepartment;
import com.ruiwang.younthpalace.pojo.power.PoUserRole;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.web.multipart.MultipartFile;


public interface IUserService {
    ResultMap<Integer> exportUserListFile(MultipartFile file);
    ResultMap<SysUser> selectByName(String userName);
    ResultMap<BoUserForReady> selectBoUserForReady(UserLimit userLimit);
    ResultMap<Integer> insertIntoUser(BoUser boUser);
    ResultMap<Integer> deleteUser(int userId);
    ResultMap<BoUser> selectByUserId(int userId);
    ResultMap<Integer> updateUser(BoUser boUser);
    ResultMap<Integer> updateUserState(int userId, int state);
    LoginInf loginReady(String userName);
    ResultMap<PoUserDepartment> getPoUserDepartment(String userName);
    ResultMap<PoUserRole> getPoUserRole(String userName);
}
