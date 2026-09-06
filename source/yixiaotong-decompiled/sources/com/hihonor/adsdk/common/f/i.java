package com.hihonor.adsdk.common.f;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {
    private static final String hnadsa = "DateUtil";

    public static boolean hnadsa(long j) {
        return hnadsa(new Date(j));
    }

    public static boolean hnadsa(Date date) {
        try {
            return hnadsa(date, new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isToday, Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static boolean hnadsa(Date date, Date date2) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isSameDate, Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }
}
