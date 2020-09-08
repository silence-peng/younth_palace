package com.ruiwang.younthpalace.mapper.file;

import com.ruiwang.younthpalace.entity.file.SysImgInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgInfoMapper {
    /**
     * 添加图片
     * @param sysImgInfo 图片对象信息
     * @return 结果行数
     */
    Integer addImgInf(@Param("sysImgInfo") SysImgInfo sysImgInfo);


    /**
     *  条件查询 如果传递id 就直接根据id查询  如果id为null  就根据其他属性查询
     * @param sysImgInfo
     * @return 图片信息列表
     */
    List<SysImgInfo> selectImgInf(@Param("sysImgInfo")SysImgInfo sysImgInfo);
    /**
     *  查询全部
     * @return 图片信息列表
     */
    List<SysImgInfo> allImgInf();

    /**
     *  根据图片Id删除，同时删除多条数据
     * @param list  图片名列表
     * @return 结果行数
     */
    Integer deleteImgInf(@Param("list") List<String> list);

    /**
     * 根据id查询图片 采用in查询
     * @return
     */
    List<SysImgInfo> selectImgInfByIds(@Param("ids") List<String> ids);

    /**
     * 检索图片名是否存在
     * @param imgUrl
     * @return
     */
    Integer selectImgInfByName(@Param("imgUrl") String imgUrl);
}
