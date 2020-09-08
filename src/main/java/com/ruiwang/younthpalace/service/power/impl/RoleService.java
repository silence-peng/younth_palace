package com.ruiwang.younthpalace.service.power.impl;


import com.ruiwang.younthpalace.bojo.power.BoRoleForReady;
import com.ruiwang.younthpalace.bojo.power.RoleLimit;
import com.ruiwang.younthpalace.entity.power.SysRole;
import com.ruiwang.younthpalace.mapper.power.RoleMapper;
import com.ruiwang.younthpalace.service.power.IRoleService;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    BoRoleForReady boRole;

    @Override
    public ResultMap<ArrayList<SysRole>> selectRoleAll() {
        return new ResultMap<>(200,"",roleMapper.selectRoleAll());
    }

    @Override
    @Transactional
    public ResultMap<BoRoleForReady> selectRoleList(RoleLimit roleLimit) {
        roleLimit.setPageNum(roleLimit.getPageNum()-1);
        roleLimit.setPageSize(roleLimit.getPageNum() -1);
        boRole.setSysRoles(roleMapper.selectRoleList(roleLimit));
        boRole.setAllNum(roleMapper.selectRoleListNum(roleLimit));
        return new ResultMap<>(200,"",boRole);
    }

    @Override
    @Transactional
    public ResultMap<Integer> addRole(String roleInf) {

        try {
            roleInf=java.net.URLDecoder.decode(roleInf,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String roleName=roleInf.split("&")[0].split("=").length>1?roleInf.split("&")[0].split("=")[1]:"";
        String roleNote=roleInf.split("&")[1].split("=").length>1?roleInf.split("&")[1].split("=")[1]:"";
        //查询是否存在此角色
        if(roleMapper.selectRoleByroleName(roleName)>0){
            return new ResultMap<>(200,"",null);
        }else{
            int code=roleMapper.insertIntoRole(roleName,roleNote)>0?200:201;
            return new ResultMap<>(code,"",null);
        }
    }

    @Override
    public ResultMap<Integer> deleteRole(String roleId) {

        if (roleMapper.deleteRoleById(Integer.parseInt(roleId.split("=")[1])) > 0) {
            return new ResultMap<>(200,"",null);
        } else {
            return new ResultMap<>(201,"",null);
        }
    }

    @Override
    public ResultMap<Integer> editRole(String editInf) {
        try {
            editInf=java.net.URLDecoder.decode(editInf,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int id=Integer.parseInt(editInf.split("&")[0].split("=")[1]);
        String roleName=editInf.split("&")[1].split("=")[1];
        String roleNote=editInf.split("&")[2].split("=").length>1?editInf.split("&")[1].split("=")[1]:"";
        if(roleMapper.updateRole(id,roleName,roleNote)>0){
            return new ResultMap<>(200,"",null);
        }
        return new ResultMap<>(201,"",null);
    }
}
