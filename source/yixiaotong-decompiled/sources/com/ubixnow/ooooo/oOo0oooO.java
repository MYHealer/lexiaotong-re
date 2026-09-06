package com.ubixnow.ooooo;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOo0oooO {
    public static int OooO00o(long j) {
        Calendar calendar = Calendar.getInstance();
        if (j > 0) {
            calendar.setTime(new Date(j));
        }
        Calendar calendar2 = Calendar.getInstance();
        int i = 0;
        while (calendar.before(calendar2) && calendar.get(5) != calendar2.get(5)) {
            calendar.add(5, 1);
            i++;
        }
        return i;
    }
}
