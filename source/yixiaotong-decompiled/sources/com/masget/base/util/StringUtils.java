package com.masget.base.util;

import client.android.yixiaotong.util.TimeUtils;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.bg;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class StringUtils {
    private static final Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    private static final Pattern IMG_URL = Pattern.compile(".*?(gif|jpeg|png|jpg|bmp)");
    private static final Pattern URL = Pattern.compile("^(https|http)://.*?$(net|com|.com.cn|org|me|)");
    private static final ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() { // from class: com.masget.base.util.StringUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(TimeUtils.FORMATDATETIME);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() { // from class: com.masget.base.util.StringUtils.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static String getString(String str) {
        return str == null ? "" : str;
    }

    public static Date toDate(String str) {
        return toDate(str, dateFormater.get());
    }

    public static Date toDate(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static String getDateString(Date date) {
        return dateFormater.get().format(date);
    }

    public static String friendly_time(String str) {
        Date dateTransformTime;
        if (TimeZoneUtil.isInEasternEightZones()) {
            dateTransformTime = toDate(str);
        } else {
            dateTransformTime = TimeZoneUtil.transformTime(toDate(str), TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault());
        }
        if (dateTransformTime == null) {
            return "Unknown";
        }
        Calendar calendar = Calendar.getInstance();
        ThreadLocal<SimpleDateFormat> threadLocal = dateFormater2;
        if (threadLocal.get().format(calendar.getTime()).equals(threadLocal.get().format(dateTransformTime))) {
            int timeInMillis = (int) ((calendar.getTimeInMillis() - dateTransformTime.getTime()) / bg.s);
            if (timeInMillis == 0) {
                return Math.max((calendar.getTimeInMillis() - dateTransformTime.getTime()) / 60000, 1L) + "分钟前";
            }
            return timeInMillis + "小时前";
        }
        int timeInMillis2 = (int) ((calendar.getTimeInMillis() / 86400000) - (dateTransformTime.getTime() / 86400000));
        if (timeInMillis2 == 0) {
            int timeInMillis3 = (int) ((calendar.getTimeInMillis() - dateTransformTime.getTime()) / bg.s);
            if (timeInMillis3 == 0) {
                return Math.max((calendar.getTimeInMillis() - dateTransformTime.getTime()) / 60000, 1L) + "分钟前";
            }
            return timeInMillis3 + "小时前";
        }
        if (timeInMillis2 == 1) {
            return "昨天";
        }
        if (timeInMillis2 == 2) {
            return "前天 ";
        }
        if (timeInMillis2 > 2 && timeInMillis2 < 31) {
            return timeInMillis2 + "天前";
        }
        if (timeInMillis2 >= 31 && timeInMillis2 <= 62) {
            return "一个月前";
        }
        if (timeInMillis2 <= 62 || timeInMillis2 > 93) {
            return (timeInMillis2 <= 93 || timeInMillis2 > 124) ? threadLocal.get().format(dateTransformTime) : "3个月前";
        }
        return "2个月前";
    }

    public static String friendly_time2(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String dataTime = getDataTime("MM-dd");
        int i = toInt(dataTime.substring(3));
        int i2 = toInt(dataTime.substring(0, 2));
        int i3 = toInt(str.substring(5, 7));
        int i4 = toInt(str.substring(8, 10));
        Date date = new Date(toInt(str.substring(0, 4)), i3 - 1, i4 - 1);
        if (i4 == i && i3 == i2) {
            return "今天 / " + strArr[getWeekOfDate(new Date())];
        }
        if (i4 == i + 1 && i3 == i2) {
            return "昨天 / " + strArr[(getWeekOfDate(new Date()) + 6) % 7];
        }
        String str2 = (i3 < 10 ? "0" : "") + i3 + "/";
        if (i4 < 10) {
            str2 = str2 + "0";
        }
        return str2 + i4 + " / " + strArr[getWeekOfDate(date)];
    }

    public static int getWeekOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7) - 1;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public static boolean isToday(String str) {
        Date date = toDate(str);
        Date date2 = new Date();
        if (date != null) {
            ThreadLocal<SimpleDateFormat> threadLocal = dateFormater2;
            if (threadLocal.get().format(date2).equals(threadLocal.get().format(date))) {
                return true;
            }
        }
        return false;
    }

    public static long getToday() {
        return Long.parseLong(dateFormater2.get().format(Calendar.getInstance().getTime()).replace(x.A, ""));
    }

    public static String getCurTimeStr() {
        return dateFormater.get().format(Calendar.getInstance().getTime());
    }

    public static long calDateDifferent(String str, String str2) {
        long time;
        try {
            ThreadLocal<SimpleDateFormat> threadLocal = dateFormater;
            time = threadLocal.get().parse(str2).getTime() - threadLocal.get().parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            time = 0;
        }
        return time / 1000;
    }

    public static boolean isEmpty(String str) {
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmail(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        return emailer.matcher(str).matches();
    }

    public static boolean isImgUrl(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        return IMG_URL.matcher(str).matches();
    }

    public static boolean isUrl(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        return URL.matcher(str).matches();
    }

    public static int toInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int toInt(Object obj) {
        if (obj == null) {
            return 0;
        }
        return toInt(obj.toString(), 0);
    }

    public static long toLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean toBool(String str) {
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static String toConvertString(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            try {
                try {
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        stringBuffer.append(line + "<br>");
                    }
                    inputStreamReader.close();
                    inputStreamReader.close();
                    bufferedReader.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    inputStreamReader.close();
                    inputStreamReader.close();
                    bufferedReader.close();
                    if (inputStream != null) {
                    }
                }
            } catch (IOException unused) {
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            try {
                inputStreamReader.close();
                inputStreamReader.close();
                bufferedReader.close();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    public static String getSubString(int i, int i2, String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (i < 0) {
            i = 0;
        }
        if (i > length) {
            i = length;
        }
        if (i2 < 0) {
            i2 = 1;
        }
        int i3 = i2 + i;
        if (i3 <= length) {
            length = i3;
        }
        return str.substring(i, length);
    }

    public static int getWeekOfYear() {
        return getWeekOfYear(new Date());
    }

    public static int getWeekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        calendar.setTime(date);
        int i = calendar.get(3) - 1;
        if (i == 0) {
            i = 52;
        }
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public static int[] getCurrentDate() {
        int[] iArr = new int[3];
        String[] strArrSplit = getDataTime("yyyy-MM-dd").split(x.A);
        for (int i = 0; i < 3; i++) {
            try {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            } catch (Exception unused) {
                iArr[i] = 0;
            }
        }
        return iArr;
    }

    public static String getDataTime(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }
}
