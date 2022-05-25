package com.rocketcharger.utils

import java.text.SimpleDateFormat

class FormatDateUtils{
    
    public static Date toDate(String date, String pattern) {
        SimpleDateFormat formatDate = new SimpleDateFormat(pattern)
        return formatDate.parse(date)
    }

    public static Calendar getDateWithoutTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar
    }

    public static Date getYesterdayDate() {
        Calendar yesterdayDate = Calendar.getInstance()
        yesterdayDate.add(Calendar.DAY_OF_MONTH, -1)
        yesterdayDate = getDateWithoutTime(yesterdayDate)
        return yesterdayDate.getTime()
    }
}