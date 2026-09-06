package client.android.yixiaotong.util;

import android.text.format.Time;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TimeUtils {
    public static final String FORMAT = "yyyy.MM.dd";
    public static final String FORMATDATE = "yyyy-MM-dd";
    public static final String FORMATDATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATDATETIME1 = "yyyyMMddHHmmssSSS";
    public static final String FORMATDATE_YEAR_MONTH = "yyyy-MM";
    public static final String FORMATIME = "HH:mm:ss";

    public static long getOneDayMillis() {
        return 86400000L;
    }

    private TimeUtils() {
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String formatTime(long j) {
        return dateToString(new Date(j), "yyyy.MM.dd");
    }

    public static String formatDate(long j) {
        return dateToString(new Date(j), "yyyy-MM-dd");
    }

    public static String formatDate_YEARMONTH(long j) {
        return dateToString(new Date(j), FORMATDATE_YEAR_MONTH);
    }

    public static String formatTime1(long j) {
        return dateToString(new Date(j), FORMATIME);
    }

    public static String formatDateTime(long j) {
        return dateToString(new Date(j), FORMATDATETIME);
    }

    public static String formatDateTimeOrderId(long j) {
        return dateToString(new Date(j), FORMATDATETIME1);
    }

    public static String dateToString(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String formatDateTime6Hex(long j) {
        String strReplace = formatDateTime(j).substring(2).replace(x.A, "").replace(x.bQ, "").replace(PPSLabelView.Code, "");
        StringBuilder sb = new StringBuilder();
        if (strReplace.length() == 12) {
            for (int i = 0; i < strReplace.length() / 2; i++) {
                int i2 = i * 2;
                String hexString = Integer.toHexString(Integer.parseInt(strReplace.substring(i2, i2 + 2)));
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
        }
        return sb.toString().toUpperCase();
    }

    public static long strTimeToSec(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return 0L;
        }
        try {
            return new SimpleDateFormat(FORMATDATETIME).parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long strTimeToSec1(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return 0L;
        }
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long strYMDeToSec(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return 0L;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static int getYear() {
        return Calendar.getInstance().get(1);
    }

    public static int getMonth() {
        return Calendar.getInstance().get(2) + 1;
    }

    public static int getDay() {
        return Calendar.getInstance().get(5);
    }

    public static int getHour() {
        return Calendar.getInstance().get(10);
    }

    public static int getMinute() {
        return Calendar.getInstance().get(12);
    }

    public static boolean isCurrentInTimeScope(int i, int i2, int i3, int i4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Time time = new Time();
        time.set(jCurrentTimeMillis);
        Time time2 = new Time();
        time2.set(jCurrentTimeMillis);
        time2.hour = i;
        time2.minute = i2;
        Time time3 = new Time();
        time3.set(jCurrentTimeMillis);
        time3.hour = i3;
        time3.minute = i4;
        boolean z = false;
        if (!time2.before(time3)) {
            time2.set(time2.toMillis(true) - 86400000);
            if (!time.before(time2) && !time.after(time3)) {
                z = true;
            }
            Time time4 = new Time();
            time4.set(time2.toMillis(true) + 86400000);
            if (!time.before(time4)) {
                return true;
            }
        } else if (!time.before(time2) && !time.after(time3)) {
            z = true;
        }
        return z;
    }
}
