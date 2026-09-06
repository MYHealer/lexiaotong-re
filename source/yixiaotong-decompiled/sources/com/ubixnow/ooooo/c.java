package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    public static final String OooO00o = "yyyy-MM-dd";
    private static final String OooO0O0 = "yyyy-MM-dd HH:mm:ss.SSS";
    private static Map<String, ThreadLocal<SimpleDateFormat>> OooO0OO = new HashMap();

    public class OooO00o extends ThreadLocal<SimpleDateFormat> {
        public final /* synthetic */ Locale OooO00o;
        public final /* synthetic */ String OooO0O0;

        public OooO00o(Locale locale, String str) {
            this.OooO00o = locale;
            this.OooO0O0 = str;
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            try {
                return this.OooO00o == null ? new SimpleDateFormat(this.OooO0O0, Locale.getDefault()) : new SimpleDateFormat(this.OooO0O0, this.OooO00o);
            } catch (Exception e) {
                oOO0O0O.OooO00o(e);
                return null;
            }
        }
    }

    public static double OooO00o(long j, long j2) {
        long j3 = j2 - j;
        if (j3 >= 0 && j3 <= 86400000) {
            try {
                return Double.parseDouble(String.format(Locale.CHINA, "%.3f", Float.valueOf(j3 / 1000.0f)));
            } catch (Exception e) {
                oOO0O0O.OooO00o(e);
            }
        }
        return 0.0d;
    }

    public static Integer OooO00o() {
        try {
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            return Integer.valueOf((-(calendar.get(15) + calendar.get(16))) / 60000);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return null;
        }
    }

    public static String OooO00o(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            str = OooO0O0;
        }
        SimpleDateFormat simpleDateFormatOooO00o = OooO00o(str, Locale.getDefault());
        if (simpleDateFormatOooO00o == null) {
            return "";
        }
        try {
            return simpleDateFormatOooO00o.format(Long.valueOf(j));
        } catch (IllegalArgumentException e) {
            oOO0O0O.OooO00o(e);
            return "";
        }
    }

    public static String OooO00o(Date date) {
        return OooO00o(date, OooO0O0);
    }

    public static String OooO00o(Date date, String str) {
        return OooO00o(date, str, Locale.getDefault());
    }

    public static String OooO00o(Date date, String str, Locale locale) {
        if (TextUtils.isEmpty(str)) {
            str = OooO0O0;
        }
        SimpleDateFormat simpleDateFormatOooO00o = OooO00o(str, locale);
        if (simpleDateFormatOooO00o == null) {
            return "";
        }
        try {
            return simpleDateFormatOooO00o.format(date);
        } catch (IllegalArgumentException e) {
            oOO0O0O.OooO00o(e);
            return "";
        }
    }

    public static String OooO00o(Date date, Locale locale) {
        return OooO00o(date, OooO0O0, locale);
    }

    private static synchronized SimpleDateFormat OooO00o(String str, Locale locale) {
        ThreadLocal<SimpleDateFormat> oooO00o;
        oooO00o = OooO0OO.get(str);
        if (oooO00o == null) {
            oooO00o = new OooO00o(locale, str);
            if (oooO00o.get() != null) {
                OooO0OO.put(str, oooO00o);
            }
        }
        return oooO00o.get();
    }

    public static JSONObject OooO00o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof Date) {
                    jSONObject.put(next, OooO00o((Date) obj, Locale.CHINA));
                }
            }
        } catch (JSONException e) {
            oOO0O0O.OooO00o(e);
        }
        return jSONObject;
    }

    public static boolean OooO00o(long j) {
        try {
            Date date = OooO00o(OooO0O0, Locale.getDefault()).parse("2015-05-15 10:24:00.000");
            return date != null && date.getTime() < j;
        } catch (ParseException e) {
            oOO0O0O.OooO00o(e);
            return false;
        }
    }

    public static boolean OooO0O0(Date date) {
        try {
            return date.after(OooO00o(OooO0O0, Locale.getDefault()).parse("2015-05-15 10:24:00.000"));
        } catch (ParseException e) {
            oOO0O0O.OooO00o(e);
            return false;
        }
    }
}
