package com.ruiwang.younthpalace.contorller.files;

import com.ruiwang.younthpalace.entity.file.SysImgInfo;
import com.ruiwang.younthpalace.service.file.IImgInfoService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
@Api(description = "图片文件API接口")
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private IImgInfoService imgInfoService;

    /**
     * 背景图上传接口
     * @return
     */
    @ApiOperation(value="背景图上传接口", notes="背景图上传接口")
    @ApiImplicitParams
    ({
            @ApiImplicitParam(name = "descName",value = "背景图描述",required = false,dataType = "String")})
    @PostMapping("/addBackInf")
    @CrossOrigin
    public ResultMap<String> addBackInf(@RequestParam(value = "file",required = true)MultipartFile file,  String descName){

        return imgInfoService.addBackImg(file,1,descName);
    }

    /**
     * 图标上传接口
     * @return
     */
    @ApiOperation(value="图标上传接口", notes="图标上传接口")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "groupType",value = "icon分组类型",required = true,dataType = "String"),
                    @ApiImplicitParam(name = "descName",value = "图标描述",required = true,dataType = "String")})
    @PostMapping("/addIconInf")
    @CrossOrigin
    public ResultMap<String> addIconInf(@RequestParam(value = "file",required = true)MultipartFile file, String groupType, String descName){

        return imgInfoService.addIconImg(file,0,groupType,descName);
    }

    /**
     * 条件查询
     * @param sysImgInfo
     * @return
     */
    @ApiOperation(value="查询图片信息", notes="查询图片信息接口")
    @ApiImplicitParam(name = "sysImgInfo", value = "图片对象实体", paramType = "entity", required = false, dataType = "entity")
    @PostMapping("/selectImgInf")
    @CrossOrigin
    @ResponseBody
    public ResultMap<List<SysImgInfo>> selectImgInf( SysImgInfo sysImgInfo){

        return imgInfoService.selectImgInf(sysImgInfo);
    }
    /**
     * 根据图片名称删除
//     * @param imgList 图片名称列表
     * @return
     */
    @ApiOperation(value="删除图片信息", notes="删除图片信息接口")
    @ApiImplicitParam(name = "ids", value = "由，分隔开的id列表", paramType = "String", required = true, dataType = "String")
    @PostMapping("/deleteImgInf")
    @CrossOrigin
    @ResponseBody
    public Object deleteImgInf(String ids){

        return imgInfoService.deleteImgInf(ids);
    }

}
