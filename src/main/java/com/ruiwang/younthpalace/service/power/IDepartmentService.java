package com.ruiwang.younthpalace.service.power;

import com.ruiwang.younthpalace.bojo.power.BoDepartment;
import com.ruiwang.younthpalace.bojo.power.DepartmentLimit;
import com.ruiwang.younthpalace.entity.power.SysDepartment;
import com.ruiwang.younthpalace.util.ResultMap;


import java.util.ArrayList;

public interface IDepartmentService  {
        //查询部门列表按照限制条件
    ResultMap<BoDepartment> selectDepartmentList(DepartmentLimit departmentLimit);

    //添加部门
    ResultMap<Integer> addDepartment(String departmentName);

    //删除部门
    ResultMap<Integer> deleteDepartment(String departmentId);

    //修改部门
    ResultMap<Integer> updateDepartment(String editInf);

    ResultMap<ArrayList<SysDepartment>>  selectDepartmentAll();
}
