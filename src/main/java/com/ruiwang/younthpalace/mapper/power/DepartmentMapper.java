package com.ruiwang.younthpalace.mapper.power;

import com.ruiwang.younthpalace.bojo.power.DepartmentLimit;
import com.ruiwang.younthpalace.entity.power.SysDepartment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DepartmentMapper {
    //获取全部部门
    ArrayList<SysDepartment> selectDepartmentAll();
    //按条件查询部门列表
    ArrayList<SysDepartment> selectDepartmentList(@Param("departmentLimit") DepartmentLimit departmentLimit);
    //符合条件的总数
    int selectDepartmentListNum(@Param("departmentLimit") DepartmentLimit departmentLimit);
    //根据部门名称查询
    int selectDepartmentByName(@Param("departmentName") String departmentName);
    //插入部门名称
    int insertDepartment(@Param("departmentName") String departmentName, @Param("time") String time);
    //删除部门
    int deleteDepartmentById(@Param("departmentId") int departmentId);
    //更新部门
    int updateDepartment(@Param("departmentId") int id, @Param("departmentName") String departmentName);

}
