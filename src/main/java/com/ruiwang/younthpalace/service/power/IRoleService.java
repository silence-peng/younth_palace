package com.ruiwang.younthpalace.service.power;


import com.ruiwang.younthpalace.bojo.power.BoRoleForReady;
import com.ruiwang.younthpalace.bojo.power.RoleLimit;
import com.ruiwang.younthpalace.entity.power.SysRole;
import com.ruiwang.younthpalace.util.ResultMap;

import java.util.ArrayList;

public interface IRoleService {
    ResultMap<ArrayList<SysRole>> selectRoleAll();
    ResultMap<BoRoleForReady> selectRoleList(RoleLimit roleLimit);
    ResultMap<Integer> addRole(String roleInf);
    ResultMap<Integer> deleteRole(String roleId);
    ResultMap<Integer> editRole(String roleInd);
}
