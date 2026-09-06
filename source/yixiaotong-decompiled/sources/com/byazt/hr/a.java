package com.byazt.hr;

import client.android.yixiaotong.util.TimeUtils;
import com.kuaishou.weapon.p0.bg;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 34})
public class a {
    public static long c(long j) {
        Date date;
        Date date2 = new Date();
        int minutes = date2.getMinutes();
        if (j >= bg.s || minutes <= 30) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 30, 0);
        }
        return c(date.getTime(), j);
    }

    private static long c(long j, long j2) {
        Date date = new Date(j2 + j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtils.FORMATDATETIME);
        long time = date.getTime();
        com.byazt.eu.tt.c("TTMediationSDK_IntervalEffectiveTime", "old time " + j + " new time = " + simpleDateFormat.format(date) + " 毫秒 = " + time);
        return time;
    }

    public static String tt(long j) {
        return new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date(j));
    }
}
