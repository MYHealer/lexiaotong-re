package client.android.yixiaotong.zksoundwave.b;

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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f975a = "";
    public static final SimpleDateFormat b = new SimpleDateFormat("HH:mm");
    private static final String c = "yyyy-MM-dd";
    private static final String d = "yyyy-MM-dd hh:mm:ss";
    private static final String e = "yyyy-MM-dd-HH-mm-ss";
    private static final double f = 1024.0d;
    private static final double g = 1048576.0d;
    private static final double h = 1.073741824E9d;

    public static char a(String str, int i) {
        if (str == null || str.length() <= 0) {
            return ' ';
        }
        return str.charAt(i);
    }

    public static float a(String str, float f2) {
        if (b(str)) {
            return 0.0f;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f2);
        return textPaint.measureText(str.trim()) + ((int) (((double) f2) * 0.1d));
    }

    public static String a() {
        return b.format(Calendar.getInstance().getTime());
    }

    public static String a(int i) {
        return String.format("%02d:%02d", Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60));
    }

    public static String a(long j) {
        return a(new Date(j), "yyyy-MM-dd");
    }

    public static String a(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String a(String str) {
        return a(Calendar.getInstance(TimeZone.getTimeZone(str)).getTimeInMillis());
    }

    public static String a(String str, String str2, String str3) {
        int length = str2.length();
        int iIndexOf = b(str2) ? 0 : str.indexOf(str2);
        if (iIndexOf <= -1) {
            return "";
        }
        int iIndexOf2 = b(str3) ? -1 : str.indexOf(str3, length + iIndexOf);
        return iIndexOf2 > -1 ? str.substring(iIndexOf + str2.length(), iIndexOf2) : "";
    }

    public static String a(String str, String str2, String str3, String str4) {
        int length = str2.length();
        int iIndexOf = b(str2) ? 0 : str.indexOf(str2);
        if (iIndexOf <= -1) {
            return str4;
        }
        int iIndexOf2 = b(str3) ? -1 : str.indexOf(str3, length + iIndexOf);
        int length2 = iIndexOf + str2.length();
        return iIndexOf2 > -1 ? str.substring(length2, iIndexOf2) : str.substring(length2);
    }

    public static String a(ArrayList arrayList, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuffer.append((String) it.next());
                stringBuffer.append(str);
            }
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        return stringBuffer.toString();
    }

    public static String a(Date date) {
        return a(date, "yyyy-MM-dd");
    }

    public static String a(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String a(Iterator it, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (it != null) {
            while (it.hasNext()) {
                stringBuffer.append((String) it.next());
                stringBuffer.append(str);
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            }
        }
        return stringBuffer.toString();
    }

    public static String a(String... strArr) {
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

    public static String b() {
        return a(new Date(), "yyyy-MM-dd");
    }

    public static String b(long j) {
        return a(new Date(j), d);
    }

    public static String b(String str, int i) {
        if (!c(str) || str.length() >= i) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < i - str.length(); i2++) {
            str2 = str2 + "0";
        }
        return str2 + str;
    }

    public static String b(String str, String str2, String str3) {
        return a(str, str2, str3, "");
    }

    public static String b(Date date) {
        return a(date, d);
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0 || str.equalsIgnoreCase("null");
    }

    public static String c() {
        return new SimpleDateFormat(e).format(new Date(System.currentTimeMillis()));
    }

    public static String c(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        return i4 > 0 ? String.format("%02d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)) : String.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static String c(String str, int i) {
        if (!c(str) || i <= 0) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < i; i2++) {
            str2 = str2 + "0";
        }
        return str + str2;
    }

    public static boolean c(String str) {
        return !b(str);
    }

    public static String d() {
        return a(new Date(), d);
    }

    public static String d(long j) {
        StringBuilder sbAppend;
        String str;
        double d2 = j;
        if (d2 < f) {
            sbAppend = new StringBuilder().append(j);
            str = "B";
        } else if (d2 < g) {
            sbAppend = new StringBuilder().append(String.format("%.1f", Double.valueOf(d2 / f)));
            str = "KB";
        } else if (d2 < h) {
            sbAppend = new StringBuilder().append(String.format("%.1f", Double.valueOf(d2 / g)));
            str = "MB";
        } else {
            sbAppend = new StringBuilder().append(String.format("%.1f", Double.valueOf(d2 / h)));
            str = "GB";
        }
        return sbAppend.append(str).toString();
    }

    public static boolean d(String str) {
        return b(e(str));
    }

    public static String e(String str) {
        return str == null ? "" : str.trim();
    }

    public static boolean f(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String g(String str) {
        return str == null ? "" : str;
    }

    public static String h(String str) {
        String str2;
        String lowerCase = str.trim().toLowerCase();
        String[] strArrSplit = lowerCase.split("[?]");
        return (lowerCase.length() <= 0 || strArrSplit.length <= 1 || (str2 = strArrSplit[0]) == null) ? "" : str2;
    }

    public static Map i(String str) {
        HashMap map = new HashMap();
        String strM = m(str);
        if (strM == null) {
            return map;
        }
        for (String str2 : strM.split("[&]")) {
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

    public static String j(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i != charArray.length - 1) {
                stringBuffer.append((int) charArray[i]).append(",");
            } else {
                stringBuffer.append((int) charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

    public static String k(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : str.split(",")) {
            stringBuffer.append((char) Integer.parseInt(str2));
        }
        return stringBuffer.toString();
    }

    public static boolean l(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static String m(String str) {
        String str2;
        String lowerCase = str.trim().toLowerCase();
        String[] strArrSplit = lowerCase.split("[?]");
        if (lowerCase.length() <= 1 || strArrSplit.length <= 1 || (str2 = strArrSplit[1]) == null) {
            return null;
        }
        return str2;
    }
}
