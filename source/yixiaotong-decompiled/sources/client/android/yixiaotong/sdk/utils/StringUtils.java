package client.android.yixiaotong.sdk.utils;

import android.text.TextPaint;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public abstract class StringUtils {
    public static final SimpleDateFormat DATE_FORMAT_PART = new SimpleDateFormat("HH:mm");
    private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd hh:mm:ss";
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private static final String DEFAULT_FILE_PATTERN = "yyyy-MM-dd-HH-mm-ss";
    public static final String EMPTY = "";
    private static final double GB = 1.073741824E9d;
    private static final double KB = 1024.0d;
    private static final double MB = 1048576.0d;

    public static String makeSafe(String str) {
        return str == null ? "" : str;
    }

    public static String currentTimeString() {
        return DATE_FORMAT_PART.format(Calendar.getInstance().getTime());
    }

    public static char chatAt(String str, int i) {
        if (str == null || str.length() <= 0) {
            return ' ';
        }
        return str.charAt(i);
    }

    public static float getTextWidth(String str, float f) {
        if (isEmpty(str)) {
            return 0.0f;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        return textPaint.measureText(str.trim()) + ((int) (((double) f) * 0.1d));
    }

    public static String formatDate(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String formatDate(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    public static String formatDate(long j) {
        return formatDate(new Date(j), "yyyy-MM-dd");
    }

    public static String getDate() {
        return formatDate(new Date(), "yyyy-MM-dd");
    }

    public static String createFileName() {
        return new SimpleDateFormat(DEFAULT_FILE_PATTERN).format(new Date(System.currentTimeMillis()));
    }

    public static String getDateTime() {
        return formatDate(new Date(), DEFAULT_DATETIME_PATTERN);
    }

    public static String formatDateTime(Date date) {
        return formatDate(date, DEFAULT_DATETIME_PATTERN);
    }

    public static String formatDateTime(long j) {
        return formatDate(new Date(j), DEFAULT_DATETIME_PATTERN);
    }

    public static String formatGMTDate(String str) {
        return formatDate(Calendar.getInstance(TimeZone.getTimeZone(str)).getTimeInMillis());
    }

    public static String join(ArrayList<String> arrayList, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(str);
            }
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        return stringBuffer.toString();
    }

    public static String join(Iterator<String> it, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (it != null) {
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(str);
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            }
        }
        return stringBuffer.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.equalsIgnoreCase("null");
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isTrimEmpty(String str) {
        return isEmpty(trim(str));
    }

    public static String trim(String str) {
        return str == null ? "" : str.trim();
    }

    public static String generateTime(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        if (i4 > 0) {
            return String.format("%02d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        return String.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static boolean isBlank(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String gennerTime(int i) {
        return String.format("%02d:%02d", Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60));
    }

    public static String generateFileSize(long j) {
        double d = j;
        if (d < KB) {
            return j + "B";
        }
        if (d < MB) {
            return String.format("%.1f", Double.valueOf(d / KB)) + "KB";
        }
        if (d < GB) {
            return String.format("%.1f", Double.valueOf(d / MB)) + "MB";
        }
        return String.format("%.1f", Double.valueOf(d / GB)) + "GB";
    }

    public static String findString(String str, String str2, String str3) {
        int length = str2.length();
        int iIndexOf = isEmpty(str2) ? 0 : str.indexOf(str2);
        if (iIndexOf <= -1) {
            return "";
        }
        int iIndexOf2 = isEmpty(str3) ? -1 : str.indexOf(str3, length + iIndexOf);
        return iIndexOf2 > -1 ? str.substring(iIndexOf + str2.length(), iIndexOf2) : "";
    }

    public static String substring(String str, String str2, String str3, String str4) {
        int length = str2.length();
        int iIndexOf = isEmpty(str2) ? 0 : str.indexOf(str2);
        if (iIndexOf <= -1) {
            return str4;
        }
        int iIndexOf2 = isEmpty(str3) ? -1 : str.indexOf(str3, length + iIndexOf);
        if (iIndexOf2 > -1) {
            return str.substring(iIndexOf + str2.length(), iIndexOf2);
        }
        return str.substring(iIndexOf + str2.length());
    }

    public static String substring(String str, String str2, String str3) {
        return substring(str, str2, str3, "");
    }

    public static String concat(String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null) {
                    stringBuffer.append(str);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String UrlPage(String str) {
        String str2;
        String lowerCase = str.trim().toLowerCase();
        String[] strArrSplit = lowerCase.split("[?]");
        return (lowerCase.length() <= 0 || strArrSplit.length <= 1 || (str2 = strArrSplit[0]) == null) ? "" : str2;
    }

    private static String TruncateUrlPage(String str) {
        String str2;
        String lowerCase = str.trim().toLowerCase();
        String[] strArrSplit = lowerCase.split("[?]");
        if (lowerCase.length() <= 1 || strArrSplit.length <= 1 || (str2 = strArrSplit[1]) == null) {
            return null;
        }
        return str2;
    }

    public static Map<String, String> URLRequest(String str) {
        HashMap map = new HashMap();
        String strTruncateUrlPage = TruncateUrlPage(str);
        if (strTruncateUrlPage == null) {
            return map;
        }
        for (String str2 : strTruncateUrlPage.split("[&]")) {
            String[] strArrSplit = str2.split("[=]");
            if (strArrSplit.length > 1) {
                map.put(strArrSplit[0], strArrSplit[1]);
            } else {
                String str3 = strArrSplit[0];
                if (str3 != "") {
                    map.put(str3, "");
                }
            }
        }
        return map;
    }
}
