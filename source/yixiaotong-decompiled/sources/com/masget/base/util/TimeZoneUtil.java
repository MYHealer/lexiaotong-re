package com.masget.base.util;

import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TimeZoneUtil {
    public static boolean isInEasternEightZones() {
        return TimeZone.getDefault() == TimeZone.getTimeZone("GMT+08");
    }

    public static Date transformTime(Date date, TimeZone timeZone, TimeZone timeZone2) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime() - ((long) (timeZone.getOffset(date.getTime()) - timeZone2.getOffset(date.getTime()))));
    }
}
