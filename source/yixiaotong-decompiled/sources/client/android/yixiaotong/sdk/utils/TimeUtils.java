package client.android.yixiaotong.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class TimeUtils {
    public static final String FORMAT = "yyyy.MM.dd";

    private TimeUtils() {
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String formatTime(long j) {
        return dateToString(new Date(j), "yyyy.MM.dd");
    }

    public static String dateToString(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }
}
