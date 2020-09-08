package com.ruiwang.younthpalace.service.file;

import com.ruiwang.younthpalace.entity.file.SysImgInfo;

import com.ruiwang.younthpalace.util.PageLimitResult;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IImgInfoService {

    ResultMap<List<SysImgInfo>> selectImgInf(SysImgInfo sysImgInfo);
    ResultMap<Integer> deleteImgInf( String ids);

     ResultMap<String> addBackImg(MultipartFile file,Integer type,String descName);
     ResultMap<String> addIconImg(MultipartFile file,Integer type,String groupTypr,String descName);
}
