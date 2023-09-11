package com.project.apt.realestate.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateUtil {

    /**
     * 오늘 날짜를 구한다.
     * @return 오늘 날짜
     * @author 정동욱
     */
    public static String getYesterday() {
        LocalDateTime now = LocalDateTime.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return formatter.format(now);
    }


    /**
     * 현재 시간을 밀리세컨드까지 구한다.
     * @return 현재 시간
     * @author 정동욱
     */
    public static String generateCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        return formatter.format(now);
    }

}
