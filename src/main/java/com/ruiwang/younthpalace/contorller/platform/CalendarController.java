package com.ruiwang.younthpalace.contorller.platform;

import com.ruiwang.younthpalace.bojo.platform.BoCalendarPageSet;
import com.ruiwang.younthpalace.entity.platform.SysCalendar;
import com.ruiwang.younthpalace.service.platform.ICalendarService;
import com.ruiwang.younthpalace.util.JSONex;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(description = "日历接口")
@Controller
@RequestMapping("/platform")
public class CalendarController {
    @Autowired
    ICalendarService calendarService;
    @Autowired
    JSONex jsoNex;

    @ApiOperation(value="获取页面设置", notes="获取页面设置")
    @CrossOrigin
    @ResponseBody
    @GetMapping("/getPageSet")
    public ResultMap<BoCalendarPageSet> getPageSet(){
        return calendarService.getPageSet();
    }

    @ApiOperation(value="更新页面设置", notes="更新页面设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "weatherchoose", value = "天气选择", paramType = "Boolean", required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "planchoose", value = "计划选择", paramType = "Boolean", required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "errchoose", value = "异常选择", paramType = "Boolean", required = true, dataType = "Boolean"),
    })
    @CrossOrigin
    @ResponseBody
    @PostMapping("/updatePageSet")
    public ResultMap<Integer> updatePageSet(Boolean weatherchoose,Boolean planchoose,Boolean errchoose){
        return calendarService.updatePageSet(weatherchoose==true?1:0,planchoose==true?1:0,errchoose==true?1:0);
    }

    @ApiOperation(value="获取日历信息接口", notes="获取日历信息接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "dateArr", value = "日期数组", paramType = "String", required = true, dataType = "String")})
    @CrossOrigin(origins = "*",maxAge = 3600)
    @ResponseBody
    @PostMapping("/getCalendarInf")
    public ResultMap<ArrayList<SysCalendar>> getCalendarInf(@RequestBody String dateArr){
        return calendarService.getShowSyscalendar(dateArr);
    }


    @ApiOperation(value="设置每日计划接口", notes="设置每日计划接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "plan", value = "计划数据", paramType = "String", required = true, dataType = "String"),
            @ApiImplicitParam(name = "id", value = "日期数据", paramType = "String", required = true, dataType = "String")})
    @CrossOrigin
    @ResponseBody
    @PostMapping("/setPlan")
    public ResultMap<Integer> setPlan(String plan,String id){
        return calendarService.setPlan(plan,id);
    }

    @ApiOperation(value="获取计划接口", notes="获取计划接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "日期数据", paramType = "String", required = true, dataType = "String")})
    @CrossOrigin
    @ResponseBody
    @PostMapping("/getPlan")
    public ResultMap<SysCalendar> getPlan(@RequestParam String id){
        return calendarService.getPlan(id);
    }

}
