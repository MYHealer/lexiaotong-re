package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class u1 {
    public static JSONObject a(Context context) {
        String strB = b(context);
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "UNKNOWN";
        }
        String str2 = Build.VERSION.RELEASE;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        String strB2 = b("ro.product.CustCVersion", "");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_sys_language", strB);
            jSONObject.put("_cust_version", strB2);
            jSONObject.put("_manufacturer", str);
            jSONObject.put("_os", "android");
            jSONObject.put("_os_ver", str2);
            jSONObject.put("_screen_height", i);
            jSONObject.put("_screen_width", i2);
            return jSONObject;
        } catch (JSONException unused) {
            j2.g("HianalyticsSDK", "getDeviceInfo() json Exc,A parameter error!");
            return null;
        }
    }

    public static JSONObject a(Context context, String str, String str2) {
        String str3;
        JSONObject jSONObjectA = a(context);
        if (jSONObjectA != null) {
            try {
                jSONObjectA.put("_start_type", str);
                jSONObjectA.put("_start_cmd", str2);
                return jSONObjectA;
            } catch (JSONException unused) {
                str3 = "startType or startCMD error";
            }
        } else {
            str3 = "getInfoJson is null";
        }
        j2.g("HianalyticsSDK", str3);
        return null;
    }

    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_old_app_version", str2);
            jSONObject.put("_current_app_version", str);
            return jSONObject;
        } catch (JSONException unused) {
            j2.g("HianalyticsSDK", "Json Exc : app ver error");
            return null;
        }
    }

    public static String b(Context context) {
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        return (configuration == null || (locale = configuration.locale) == null) ? "" : locale.toString();
    }

    public static String b(String str, String str2) {
        return com.hihonor.hianalytics.util.j.b(str, str2);
    }
}
