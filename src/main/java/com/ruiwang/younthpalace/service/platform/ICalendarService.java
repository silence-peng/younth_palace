package com.ruiwang.younthpalace.service.platform;

import com.ruiwang.younthpalace.bojo.platform.BoCalendarPageSet;
import com.ruiwang.younthpalace.entity.platform.SysCalendar;
import com.ruiwang.younthpalace.util.ResultMap;

import java.util.ArrayList;

public interface ICalendarService  {
    ResultMap<BoCalendarPageSet> getPageSet();
    ResultMap<Integer> updatePageSet(Integer weatherchoose, Integer planchoose, Integer errchoose);
    ResultMap<ArrayList<SysCalendar>> getShowSyscalendar(String dateArr);
    ResultMap<String> getFuture();
    ResultMap<Integer> setPlan(String plan, String time);
    ResultMap<SysCalendar> getPlan(String date);
}
