package com.ruiwang.younthpalace.service.map;

import com.ruiwang.younthpalace.entity.map.SysEditPageInfo;
import com.ruiwang.younthpalace.util.ResultMap;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface IEditPageInfoService {
    ResultMap<Integer> updateEditPageInf(@Param("content") String content);
    ResultMap<Integer> updateIconInf( String content);
    ResultMap<List<SysEditPageInfo>> allEditPageInf();

    ResultMap<SysEditPageInfo> selectEditPageInf(Integer id);
}
