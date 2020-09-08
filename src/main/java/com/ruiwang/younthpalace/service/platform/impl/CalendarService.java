package com.ruiwang.younthpalace.service.platform.impl;

import com.ruiwang.younthpalace.bojo.platform.BoCalendarPageSet;
import com.ruiwang.younthpalace.entity.platform.SysCalendar;
import com.ruiwang.younthpalace.mapper.platform.CalendarMapper;
import com.ruiwang.younthpalace.service.platform.ICalendarService;
import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalendarService implements ICalendarService {
//    @Autowired
//    DataMapper<SysCalendar> dataMapper;
    @Autowired
    CalendarMapper calendarMapper;
    @Override
    public ResultMap<BoCalendarPageSet> getPageSet() {
        return new  ResultMap<BoCalendarPageSet>(200,"",calendarMapper.selectPageSet());
    }

    @Override
    public  ResultMap<Integer> updatePageSet(Integer weatherchoose, Integer planchoose, Integer errchoose) {
        return new  ResultMap<Integer>(calendarMapper.updatePageSet(weatherchoose,planchoose,errchoose)>0?200:201,"",null);
    }

    @Override
    public ResultMap<ArrayList<SysCalendar>> getShowSyscalendar(String dateArr) {
        dateArr=dateArr.replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\\"","");
        String [] dateA=dateArr.split(",");
        return new ResultMap<ArrayList<SysCalendar>>(200,"",calendarMapper.selectSyscalendar(dateA));
    }

    @Override
    public ResultMap<String> getFuture() {
        return new ResultMap<String>(200,"",calendarMapper.selectFuture());
    }

    @Override
    public ResultMap<Integer> setPlan(String plan, String date) {
        //如果存在时间就更新否则就insert
        if(calendarMapper.selectDayInf(date)>0){
            if(calendarMapper.updateCalendarPlan(plan,date)>0)
                return new ResultMap<Integer>(200,"",null);
        }else{
            if(calendarMapper.insertCalendarPlan(plan,date)>0)
                return new ResultMap<Integer>(200,"",null);
        }
        return new ResultMap<Integer>(201,"",null);
    }

    @Override
    public ResultMap<SysCalendar> getPlan(String date) {
        return new ResultMap<SysCalendar>(200,"",calendarMapper.selectCalendarInfByDate(date));
    }

}
