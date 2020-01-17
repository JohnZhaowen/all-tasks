package com.john.alltasks.common.utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.*;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * Created by zongwei.yang on 2016/12/8.
 */
@Slf4j
public class DateUtil {
    @Getter
    public enum DatePattern {
        /** yyyy-MM */
        MONTH("yyyy-MM"),
        /** yyyy-ww */
        WEEK("yyyy-ww"),
        /** yyyy-MM-dd */
        DAY("yyyy-MM-dd"),
        /** yyyy/MM/dd */
        DAY_2("yyyy/MM/dd"),
        /** yyyyMMdd */
        DAY_INT("yyyyMMdd"),
        /** yyyy-MM-dd HH */
        HOUR("yyyy-MM-dd HH"),
        /** yyyy-MM-dd HH:mm */
        MINUTE("yyyy-MM-dd HH:mm"),
        /** yyyy-MM-dd HH:mm:ss */
        SECOND("yyyy-MM-dd HH:mm:ss"),
        /** yyyyMMddHHmmss */
        ANNOUNCEMENT_TIME("yyyyMMddHHmmss"),
        /** yyyy-MM-dd'T'HH:mm:ssZZ */
        TIME_WITH_ZONE("yyyy-MM-dd'T'HH:mm:ssZZ"),
        /** yyyy/M/d */
        DAY_WITHOUT_ZERO("yyyy/M/d"),
        /** HH:mm:ss */
        TIME("HH:mm:ss");
        
        DatePattern(String value) {
            this.value = value;
            this.formatter = DateTimeFormatter.ofPattern(value);
        }
        
        private String value;
        private DateTimeFormatter formatter;
    }
    
    public static final String DATE_LOCAL = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
    public static final String DATE_ISO = "^[1-9]\\d{3}/([1-9]|0[1-9]|1[0-2])/([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";
    public static final String DATE_NUMBER = "^[1-9]\\d{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";
    
    public static Date toDate(LocalDate date) {
        if (null == date) {
            return null;
        }
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    public static LocalDate toLocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    /**
     * exp: 2016-12-08 12:23:44 => 2016-12-08 00:00:00
     *
     * @param date
     * @return
     */
    public static LocalDate toLocalDate(LocalDateTime date) {
        if (null == date) {
            return null;
        }
        return date.toLocalDate();
    }
    
    public static LocalDateTime toLocalDateTime(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    /**
     * 获取"yyyyMMdd"格式的日期字符串
     *
     * @param date 需要转换成"yyyyMMdd"的日期类
     * @return the string 转换后的字符串
     */
    public static String toNumericString(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DatePattern.DAY_INT.getFormatter());
    }
    
    /**
     * 只用指定格式转成日期字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String toFormatString(LocalDate date, DatePattern pattern) {
        return toFormatString(date,pattern.getFormatter());
    }
    
    public static String toFormatString(LocalDate date, DateTimeFormatter formatter) {
        if (date == null) {
            return null;
        }
        return date.format(formatter);
    }
    
    public static String toFormatString(LocalDate date, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return toFormatString(date,formatter);
        } catch (IllegalArgumentException e) {
            log.error("Invalid toFormatString {}",format);
        }
        return null;
    }
    
    /**
     * 获取"yyyy-MM-dd"格式的日期字符串
     *
     * @param date 需要转换成"yyyy-MM-dd"的日期类
     * @return the string 转换后的字符串
     */
    public static String toString(LocalDate date) {
        return date == null ? null : date.toString();
    }
    
    
    /**
     * 字符串，不指定格式的转换成日期.
     *
     * @param strDate 日期的字符串
     * @return the date 日期类，如：yyyy/MM/dd yyyy-MM-dd yyyyMMdd
     */
    public static LocalDate fromString(String strDate) {
        if (strDate.matches(DATE_LOCAL)) {
            return LocalDate.parse(strDate);
        } else if (strDate.matches(DATE_NUMBER)) {
            return fromNumericString(strDate);
        } else if (strDate.matches(DATE_ISO)) {
            return LocalDate.parse(strDate, DatePattern.DAY_WITHOUT_ZERO.getFormatter());
        } else if(strDate.indexOf(".") > -1){
            return LocalDate.parse(strDate,DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        }
        log.error("parse {} to Local Date failed!",strDate);
        return null;
    }
    
    public static LocalDate fromNumericString(String numericString){
        return fromDatePattern(numericString, DatePattern.DAY_INT);
    }
    
    public static LocalDate fromISOString(String strDate) {
        if (strDate == null || strDate.trim().length() <= 0) {
            return null;
        }
        return LocalDate.parse(strDate);
    }
    
    public static LocalDate fromDatePattern(String strDate,DatePattern pattern) {
        if (strDate == null || strDate.trim().length() <= 0) {
            return null;
        }
        return LocalDate.parse(strDate,pattern.getFormatter());
    }
    
    public static LocalDateTime fromTimeStamp(long timeStamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStamp), ZoneId.systemDefault());
    }
    
    public static LocalDateTime fromString(String time, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return fromString(time,formatter);
        } catch (IllegalArgumentException e) {
            log.error("Invalid toFormatString {}",format);
        }
        return null;
    }
    
    public static LocalDateTime fromString(String time, DatePattern pattern) {
        return fromString(time,pattern.getFormatter());
    }
    
    public static LocalDateTime fromString(String time, DateTimeFormatter formatter) {
        if (time == null || time.trim().length() <= 0) {
            return null;
        }
        return LocalDateTime.parse(time, formatter);
    }
    
    public static String toDateTimeString(LocalDateTime createdTime) {
        return toFormatString(createdTime, DatePattern.SECOND);
    }
    
    public static String toFormatString(LocalDateTime createdTime, DatePattern pattern) {
        return createdTime == null ? null : createdTime.format(pattern.getFormatter());
    }
    
    public static String toFormatString(LocalDateTime createdTime, String pattern) {
        return createdTime == null ? null : createdTime.format(DateTimeFormatter.ofPattern(pattern));
    }
    
    
    /**
     * exp: 2016-12-08 12:23:44 => 2016-12-08 23:59:59
     *
     * @param date
     * @return
     */
    public static LocalDateTime getEndOfDate(LocalDateTime date) {
        if (null == date) {
            return null;
        }
        return LocalDateTime.of(date.toLocalDate(),LocalTime.MAX);
    }
    
    public static LocalDate moveDays(LocalDate date, int days) {
        return date.plusDays(days);
    }
    
    public static LocalDate getFirstDayOfYear() {
        return LocalDate.now().with(firstDayOfYear());
    }
    
    public static LocalDate getLastDayOfYear(LocalDate now) {
        return now.with(lastDayOfYear());
    }
    
    public static LocalDate moveToEndOfMonth(LocalDate date) {
        return date.with(lastDayOfMonth());
    }
    
    public static int differ(LocalDate d1, LocalDate d2) {
        return (int) Math.abs(d1.toEpochDay() - d2.toEpochDay());
    }
    
    public static long getMilliSecond(LocalDateTime dateTime){
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    
    public static LocalDate getToday() {
        return LocalDate.now();
    }
    
    public static Date getMaxDate(Date... dates) {
        return Arrays.stream(dates).filter(Objects::nonNull).max(Comparator.naturalOrder()).orElse(null);
    }
    
    public static LocalDate getMaxDate(LocalDate... dates) {
        return Arrays.stream(dates).filter(Objects::nonNull).max(Comparator.naturalOrder()).orElse(null);
    }
    
    public static String getYearSeason(LocalDate date) {
        int year = date.getYear();
        return year + "-"+date.getDayOfMonth()/3 +1;
    }
    
    
    public static boolean isEndOfMonth(LocalDate date) {
        return date.getDayOfMonth() == date.lengthOfMonth();
    }
    
    public static LocalDate getEndOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }
    
    public static boolean isEndOf(LocalDate date, String frequency) {
        if (isEndOfMonth(date)) {
            switch (frequency) {
                case "season":
                    if (date.getMonthValue() % 3 == 0) {
                        return true;
                    }
                case "semi":
                    if (date.getMonthValue() % 6 == 0) {
                        return true;
                    }
                case "year":
                    if (date.getMonth() == Month.DECEMBER) {
                        return true;
                    }
            }
        }
        return false;
    }
    
    public static LocalDate getLastEndOf(LocalDate date, String frequency) {
        int k;
        switch (frequency) {
            case "season":
                k = 3;
                break;
            case "semi":
                k = 6;
                break;
            case "year":
                k = 12;
                break;
            default:
                throw new IllegalArgumentException("frequency " + frequency + " is not supported");
        }
        
        int offset = date.getMonthValue() % k;
        if (offset == 0) {
            offset = k;
        }
        
        return getEndOfMonth(date.minusMonths(offset));
    }
    
    public static LocalDate moveDateBy(LocalDate date, String frequency) {
        switch (frequency) {
            case "season":
                return getEndOfMonth(date.minusMonths(3));
            case "semi":
                return getEndOfMonth(date.minusMonths(6));
            case "year":
                return getEndOfMonth(date.minusYears(1));
        }
        throw new IllegalArgumentException("frequency " + frequency + " is not supported");
    }
    
    /**
     * 得到date所在周的周日（第一天）.
     *
     * @param date the date
     * @return
     */
    @SuppressWarnings("static-access")
    public static LocalDate getSunday(LocalDate date) {
        int dayOfWeek = date.get(WeekFields.SUNDAY_START.dayOfWeek());
        return date.minusDays(dayOfWeek - 1);
    }
    
    /**
     * * 得到date所在周，周六（最后一天）.
     *
     * @param date the date
     * @return
     */
    @SuppressWarnings("static-access")
    public static LocalDate getSaturday(LocalDate date) {
        int dayOfWeek = date.get(WeekFields.SUNDAY_START.dayOfWeek());
        return date.plusDays(7 - dayOfWeek);
    }
    
    /**
     * 获取2个时间间隔的日期列表
     *
     * @param start LocalDate
     * @param end   LocalDate
     * @return 日期列表
     */
    public static List<LocalDate> getDateList(LocalDate start, LocalDate end) {
        List<LocalDate> localDateList = new LinkedList<>();
        long between = end.toEpochDay() - start.toEpochDay();
        for (long i = 0; i < between; i++) {
            LocalDate localDate = start.plusDays(i);
            localDateList.add(localDate);
        }
        return localDateList;
    }
    
    /**
     * 获取日期间隔，保留小数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static int differByYear(LocalDate d1, LocalDate d2) {
        int year = d2.getYear() - d1.getYear();
        int month = d2.getMonthValue() - d1.getMonthValue();
        return year + month / 12;
    }
    
    public static LocalDate getLastDayOfLastYear() {
        return LocalDate.now().minusYears(1L).with(TemporalAdjusters.lastDayOfYear());
    }
    
    public static LocalDate moveToEndOfNextWeek(LocalDate date) {
        return date.with(next(DayOfWeek.MONDAY)).with(next(DayOfWeek.SUNDAY));
    }
    
    public static LocalDate moveToEndOfThisWeek(LocalDate date) {
        return date.with(nextOrSame(DayOfWeek.SUNDAY));
    }
    
    public static LocalDate moveToEndOfLastWeek(LocalDate date) {
        return date.with(previous(DayOfWeek.SUNDAY));
    }
    
    public static LocalDate moveToEndOfNextMonth(LocalDate date) {
        return date.with(firstDayOfNextMonth()).with(lastDayOfMonth());
    }
    
    public static LocalDate moveToEndOfThisMonth(LocalDate date) {
        return date.with(lastDayOfMonth());
    }
    
    public static LocalDate moveToEndOfLastMonth(LocalDate date) {
        return date.minusMonths(1).with(lastDayOfMonth());
    }
    
    public static LocalDate moveToEndOfNextSeason(LocalDate date) {
        LocalDate lastDay = date.plusMonths(3);
        Month month = lastDay.getMonth();
        while (month != Month.MARCH && month != Month.JUNE && month != Month.SEPTEMBER && month != Month.DECEMBER) {
            lastDay = lastDay.plusMonths(1);
            month = lastDay.getMonth();
        }
        return lastDay.with(lastDayOfMonth());
    }
    
    public static LocalDate moveToEndOfThisSeason(LocalDate date) {
        LocalDate lastDay = date;
        Month month = lastDay.getMonth();
        while (month != Month.MARCH && month != Month.JUNE && month != Month.SEPTEMBER && month != Month.DECEMBER) {
            lastDay = lastDay.plusMonths(1);
            month = lastDay.getMonth();
        }
        return lastDay.with(lastDayOfMonth());
    }
    
    public static LocalDate moveToEndOfLastSeason(LocalDate date) {
        LocalDate lastDay = date.minusMonths(3);
        Month month = lastDay.getMonth();
        while (month != Month.MARCH && month != Month.JUNE && month != Month.SEPTEMBER && month != Month.DECEMBER) {
            lastDay = lastDay.plusMonths(1);
            month = lastDay.getMonth();
        }
        return lastDay.with(lastDayOfMonth());
    }
    
    public static LocalDate moveToEndOfNextSemi(LocalDate date) {
        LocalDate lastDay = date;
        if (lastDay.getMonthValue() <= 6) {
            lastDay = lastDay.with(lastDayOfYear());
        } else {
            lastDay = lastDay.plusYears(1).withMonth(6).with(lastDayOfMonth());
        }
        return lastDay;
    }
    
    public static LocalDate moveToEndOfThisSemi(LocalDate date) {
        LocalDate lastDay = date;
        if (lastDay.getMonthValue() <= 6) {
            lastDay = lastDay.withMonth(6).with(lastDayOfMonth());
        } else {
            lastDay = lastDay.withMonth(12).with(lastDayOfMonth());
        }
        return lastDay;
    }
    
    public static LocalDate moveToEndOfLastSemi(LocalDate date) {
        LocalDate lastDay = date;
        if (lastDay.getMonthValue() <= 6) {
            lastDay = lastDay.minusYears(1).with(lastDayOfYear());
        } else {
            lastDay = lastDay.withMonth(6).with(lastDayOfMonth());
        }
        return lastDay;
    }
    
    public static int getMonthDis(LocalDate start, LocalDate end) {
        int diffYear = start.getYear() - end.getYear();
        return diffYear * 12 + start.getMonth().getValue() - end.getMonth().getValue();
    }
    
    public static LocalDate getBeginningOfNextMonth(LocalDate date) {
        return date.plusMonths(1).withDayOfMonth(1);
    }
    
    public static LocalDate getEndOfLastMonth(LocalDate date) {
        LocalDate lastMonth = date.minusMonths(1);
        return lastMonth.withDayOfMonth(lastMonth.lengthOfMonth());
    }
    
}
