package com.ruiwang.younthpalace.util;

import com.ruiwang.younthpalace.mapper.platform.CalendarMapper;
import com.ruiwang.younthpalace.service.platform.impl.CalendarService;
import com.ruiwang.younthpalace.service.platform.impl.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class Schedule {
    @Value("${weatherFuture}")
    private String weatherfuture;

    @Value("${weatherInf}")
    private String weather;
    @Autowired
    MaintenanceService maintenanceService;
    @Autowired
    CalendarService calendarService;
    CalendarMapper calendarMapper;
    @Autowired
    JSONex jsoNex;
    @Scheduled(cron="0 30 * * * ?")
    public void scanPlan(){
        maintenanceService.scheduleOfScan();
        System.out.println("凌晨1点执行扫描");
    }

    //将凌晨4点30分0秒开始查询15日的未来天气数据存入数据库
    @Scheduled(cron="0 30 * * * ?")
    @Transactional
    public void getweatherFuture(){
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuffer result = new StringBuffer();
        try {
            //创建连接
            URL url = new URL(this.weatherfuture);
            connection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            //设置连接超时时间
            connection.setReadTimeout(15000);
            //开始连接
            connection.connect();
            //获取响应数据
            if (connection.getResponseCode() == 200) {
                //获取返回的数据
                is = connection.getInputStream();
                if (null != is) {
                    br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String temp = null;
                    while (null != (temp = br.readLine())) {
                        result.append(temp);
                    }
                }
            }
//            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭远程连接
            connection.disconnect();
        }
//        String test="{\"message\":\"success感谢又拍云(upyun.com)提供CDN赞助\",\"status\":200,\"date\":\"20200731\",\"time\":\"2020-07-31 13:13:19\",\"cityInfo\":{\"city\":\"南京市\",\"citykey\":\"101190101\",\"parent\":\"江苏\",\"updateTime\":\"09:16\"},\"data\":{\"shidu\":\"89%\",\"pm25\":20.0,\"pm10\":27.0,\"quality\":\"优\",\"wendu\":\"33\",\"ganmao\":\"各类人群可自由活动\",\"forecast\":[{\"date\":\"31\",\"high\":\"高温 32℃\",\"low\":\"低温 27℃\",\"ymd\":\"2020-07-31\",\"week\":\"星期五\",\"sunrise\":\"05:20\",\"sunset\":\"19:03\",\"aqi\":21,\"fx\":\"东南风\",\"fl\":\"2级\",\"type\":\"多云\",\"notice\":\"阴晴之间，谨防紫外线侵扰\"},{\"date\":\"01\",\"high\":\"高温 33℃\",\"low\":\"低温 26℃\",\"ymd\":\"2020-08-01\",\"week\":\"星期六\",\"sunrise\":\"05:20\",\"sunset\":\"19:02\",\"aqi\":35,\"fx\":\"南风\",\"fl\":\"2级\",\"type\":\"多云\",\"notice\":\"阴晴之间，谨防紫外线侵扰\"},{\"date\":\"02\",\"high\":\"高温 34℃\",\"low\":\"低温 27℃\",\"ymd\":\"2020-08-02\",\"week\":\"星期日\",\"sunrise\":\"05:21\",\"sunset\":\"19:01\",\"aqi\":40,\"fx\":\"南风\",\"fl\":\"2级\",\"type\":\"多云\",\"notice\":\"阴晴之间，谨防紫外线侵扰\"},{\"date\":\"03\",\"high\":\"高温 32℃\",\"low\":\"低温 26℃\",\"ymd\":\"2020-08-03\",\"week\":\"星期一\",\"sunrise\":\"05:22\",\"sunset\":\"19:00\",\"aqi\":42,\"fx\":\"东南风\",\"fl\":\"2级\",\"type\":\"多云\",\"notice\":\"阴晴之间，谨防紫外线侵扰\"},{\"date\":\"04\",\"high\":\"高温 32℃\",\"low\":\"低温 25℃\",\"ymd\":\"2020-08-04\",\"week\":\"星期二\",\"sunrise\":\"05:22\",\"sunset\":\"19:00\",\"aqi\":47,\"fx\":\"南风\",\"fl\":\"2级\",\"type\":\"小雨\",\"notice\":\"雨虽小，注意保暖别感冒\"},{\"date\":\"05\",\"high\":\"高温 30℃\",\"low\":\"低温 28℃\",\"ymd\":\"2020-08-05\",\"week\":\"星期三\",\"sunrise\":\"05:23\",\"sunset\":\"18:59\",\"aqi\":40,\"fx\":\"南风\",\"fl\":\"2级\",\"type\":\"多云\",\"notice\":\"阴晴之间，谨防紫外线侵扰\"},{\"date\":\"06\",\"high\":\"高温 29℃\",\"low\":\"低温 27℃\",\"ymd\":\"2020-08-06\",\"week\":\"星期四\",\"sunrise\":\"05:24\",\"sunset\":\"18:58\",\"aqi\":40,\"fx\":\"西南风\",\"fl\":\"2级\",\"type\":\"阴\",\"notice\":\"不要被阴云遮挡住好心情\"},{\"date\":\"07\",\"high\":\"高温 34℃\",\"low\":\"低温 25℃\",\"ymd\":\"2020-08-07\",\"week\":\"星期五\",\"sunrise\":\"05:24\",\"sunset\":\"18:57\",\"aqi\":32,\"fx\":\"西南风\",\"fl\":\"3级\",\"type\":\"阴\",\"notice\":\"不要被阴云遮挡住好心情\"},{\"date\":\"08\",\"high\":\"高温 34℃\",\"low\":\"低温 25℃\",\"ymd\":\"2020-08-08\",\"week\":\"星期六\",\"sunrise\":\"05:25\",\"sunset\":\"18:56\",\"aqi\":29,\"fx\":\"南风\",\"fl\":\"3级\",\"type\":\"小雨\",\"notice\":\"雨虽小，注意保暖别感冒\"},{\"date\":\"09\",\"high\":\"高温 34℃\",\"low\":\"低温 25℃\",\"ymd\":\"2020-08-09\",\"week\":\"星期日\",\"sunrise\":\"05:26\",\"sunset\":\"18:55\",\"aqi\":32,\"fx\":\"南风\",\"fl\":\"3级\",\"type\":\"多云\",\"notice\":\"阴晴之间，谨防紫外线侵扰\"},{\"date\":\"10\",\"high\":\"高温 34℃\",\"low\":\"低温 24℃\",\"ymd\":\"2020-08-10\",\"week\":\"星期一\",\"sunrise\":\"05:26\",\"sunset\":\"18:54\",\"aqi\":29,\"fx\":\"南风\",\"fl\":\"3级\",\"type\":\"阴\",\"notice\":\"不要被阴云遮挡住好心情\"},{\"date\":\"11\",\"high\":\"高温 36℃\",\"low\":\"低温 24℃\",\"ymd\":\"2020-08-11\",\"week\":\"星期二\",\"sunrise\":\"05:27\",\"sunset\":\"18:53\",\"aqi\":31,\"fx\":\"南风\",\"fl\":\"3级\",\"type\":\"阴\",\"notice\":\"不要被阴云遮挡住好心情\"},{\"date\":\"12\",\"high\":\"高温 35℃\",\"low\":\"低温 23℃\",\"ymd\":\"2020-08-12\",\"week\":\"星期三\",\"sunrise\":\"05:28\",\"sunset\":\"18:52\",\"aqi\":36,\"fx\":\"南风\",\"fl\":\"2级\",\"type\":\"阴\",\"notice\":\"不要被阴云遮挡住好心情\"},{\"date\":\"13\",\"high\":\"高温 35℃\",\"low\":\"低温 23℃\",\"ymd\":\"2020-08-13\",\"week\":\"星期四\",\"sunrise\":\"05:28\",\"sunset\":\"18:51\",\"aqi\":32,\"fx\":\"西南风\",\"fl\":\"3级\",\"type\":\"阴\",\"notice\":\"不要被阴云遮挡住好心情\"},{\"date\":\"14\",\"high\":\"高温 35℃\",\"low\":\"低温 22℃\",\"ymd\":\"2020-08-14\",\"week\":\"星期五\",\"sunrise\":\"05:29\",\"sunset\":\"18:50\",\"aqi\":56,\"fx\":\"西南风\",\"fl\":\"2级\",\"type\":\"小雨\",\"notice\":\"雨虽小，注意保暖别感冒\"}],\"yesterday\":{\"date\":\"30\",\"high\":\"高温 30℃\",\"low\":\"低温 25℃\",\"ymd\":\"2020-07-30\",\"week\":\"星期四\",\"sunrise\":\"05:19\",\"sunset\":\"19:04\",\"aqi\":71,\"fx\":\"东风\",\"fl\":\"3级\",\"type\":\"中雨\",\"notice\":\"记得随身携带雨伞哦\"}}}";

        String maps=jsoNex.parseJSON2Map(jsoNex.parseJSON2Map(result.toString()).get("data").toString()).get("forecast").toString().replaceAll("\\]","").replaceAll("\\[","").replaceAll("}, \\{","}|{");
//        System.out.println(maps);
        System.out.println("天气查询执行");
        for(String map : maps.split("\\|")){

            String time=map.split(", ymd=")[1].split(", high=")[0];
            String high=map.split(", high=")[1].split(", sunrise=")[0];
            String low=map.split(", low=")[1].split(", fl=")[0];
            String type=map.split(", type=")[1].split(", notice=")[0];
            //        首先查询是否有当天数据库行没有
            if(calendarMapper.selectDayInf(time)>0){
                calendarMapper.updateCalendarInf(high+","+low+","+type,time);
            }else{
                System.out.println("插入");
                calendarMapper.insertCalendarInf(high+","+low+","+type,time);
            }
        }

    }
}
