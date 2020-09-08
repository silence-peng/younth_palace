package com.ruiwang.younthpalace.mapper.platform;

import com.ruiwang.younthpalace.bojo.platform.BoCalendarPageSet;
import com.ruiwang.younthpalace.entity.platform.SysCalendar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CalendarMapper {
    BoCalendarPageSet selectPageSet();
    Integer updatePageSet(@Param("weatherchoose") Integer weatherchoose, @Param("planchoose") Integer planchoose, @Param("errchoose") Integer errchoose);
    Integer updateweatherFuture(@Param("inf") String inf);
    Integer selectDayInf(@Param("date") String date);
    Integer updateCalendarInf(@Param("weather") String weather, @Param("date") String date);
    Integer insertCalendarInf(@Param("weather") String weather, @Param("date") String date);
    ArrayList<SysCalendar> selectSyscalendar(@Param("dateA") String[] dateA);
    String selectFuture();
    Integer insertCalendarPlan(@Param("plan") String plan, @Param("date") String date);
    Integer updateCalendarPlan(@Param("plan") String plan, @Param("date") String date);
    SysCalendar selectCalendarInfByDate(@Param("date") String date);
}
