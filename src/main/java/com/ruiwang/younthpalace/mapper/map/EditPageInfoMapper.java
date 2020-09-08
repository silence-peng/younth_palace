package com.ruiwang.younthpalace.mapper.map;

import com.ruiwang.younthpalace.entity.map.SysEditPageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditPageInfoMapper {
    Integer updateEditPageInf(@Param("content") String content);
    Integer updateIconInf(@Param("content") String content);
    List<SysEditPageInfo> allEditPageInf();

    SysEditPageInfo selectEditPageInf(@Param("id") Integer id);
}
