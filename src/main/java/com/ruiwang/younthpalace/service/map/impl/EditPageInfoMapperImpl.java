package com.ruiwang.younthpalace.service.map.impl;

import com.ruiwang.younthpalace.entity.map.SysEditPageInfo;
import com.ruiwang.younthpalace.mapper.map.EditPageInfoMapper;
import com.ruiwang.younthpalace.service.map.IEditPageInfoService;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EditPageInfoMapperImpl implements IEditPageInfoService {
    @Autowired
    private EditPageInfoMapper editPageInfoMapper;

    @Override
    @Transactional
    public ResultMap updateEditPageInf(String content) {
        int code=editPageInfoMapper.updateEditPageInf(content)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap updateIconInf(String content) {
        int code=editPageInfoMapper.updateIconInf(content)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<List<SysEditPageInfo>> allEditPageInf() {
        return new ResultMap<>(200,"",editPageInfoMapper.allEditPageInf());
    }

    @Override
    public ResultMap<SysEditPageInfo> selectEditPageInf(Integer id) {
        return new ResultMap<SysEditPageInfo>(200,"",editPageInfoMapper.selectEditPageInf(id));
    }
}
