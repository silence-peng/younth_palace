package com.ruiwang.younthpalace.contorller.map;

import com.ruiwang.younthpalace.entity.map.SysEditPageInfo;
import com.ruiwang.younthpalace.service.map.IEditPageInfoService;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(description = "地图编辑页接口")
@RestController
@RequestMapping("/map")
public class EditPageInfoController {
    @Autowired
    private IEditPageInfoService IEditPageInfoService;

    /**
     * 更新
     * @param content
     * @return
     */
    @ApiOperation(value="更新地图编辑页", notes="更新地图编辑页接口")
    @ApiImplicitParam(name = "content", value = "地图树数据", paramType = "String", required = true, dataType = "String")
    @CrossOrigin
    @PostMapping("/updateEditPageInf")
    public Object updateEditPageInf(String content){

        return IEditPageInfoService.updateEditPageInf(content);
    }

    @ApiOperation(value="更新Icon地图列表", notes="更新Icon地图列表")
    @ApiImplicitParam(name = "content", value = "icon树数据", paramType = "String", required = true, dataType = "String")
    @CrossOrigin
    @PostMapping("/updateIcon")
    public Object updateIcon(String content){

        return IEditPageInfoService.updateIconInf(content);
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @ApiOperation(value="查询地图编辑页数据接口", notes="查询地图编辑页数据接口")
    @ApiImplicitParam(name = "id", value = "地图树数据id", paramType = "Integer", required = true, dataType = "Integer")
    @CrossOrigin
    @PostMapping("/selectEditPageInf")
    public ResultMap<SysEditPageInfo> selectEditPageInf(Integer id){

        return IEditPageInfoService.selectEditPageInf(id);
    }

    /**
     * 查询所有
     * @return
     */
    @ApiOperation(value="查询所有地图编辑页数据接口", notes="查询所有地图编辑页数据接口")
    @CrossOrigin
    @GetMapping("/allEditPageInf")
    public ResultMap<List<SysEditPageInfo>> allEditPageInf(){
        return IEditPageInfoService.allEditPageInf();
    }
}
