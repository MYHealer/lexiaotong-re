package com.byazt.bt;

import android.text.TextUtils;
import com.byazt.dna.eo;
import com.byazt.nr.m;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.ubixnow.ooooo.oOOOoo00;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 71})
public class x {
    public static volatile String c;
    public static volatile String tt;

    public static String c() {
        return "sp_exec_getad_config";
    }

    public static com.byazt.it.ve c(String str, com.byazt.dna.c cVar) {
        return ((eo) com.byazt.ut.uj.getService("storage_service")).getGlobalStorage(cVar, str);
    }

    public static void c(String str, String str2, com.byazt.dna.c cVar) {
        try {
            c(c(), cVar).put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static String tt(String str, String str2, com.byazt.dna.c cVar) {
        try {
            return c(c(), cVar).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void c(String str, String str2, com.byazt.dna.c cVar, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(oOOOoo00.OooOo0o, str2);
            jSONObject.put(CrashHianalyticsData.TIME, System.currentTimeMillis());
            jSONObject.put("p_version", i);
            c(str, jSONObject.toString(), cVar);
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public static String c(String str, long j, com.byazt.dna.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strTt = tt(str, "", cVar);
            if (TextUtils.isEmpty(strTt)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strTt);
            if (System.currentTimeMillis() - jSONObject.getLong(CrashHianalyticsData.TIME) <= j) {
                return jSONObject.getString(oOOOoo00.OooOo0o);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String tt(String str, long j, com.byazt.dna.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strTt = tt(str, "", cVar);
            if (TextUtils.isEmpty(strTt)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strTt);
            if (System.currentTimeMillis() - jSONObject.getLong(CrashHianalyticsData.TIME) <= j) {
                return jSONObject.getString(oOOOoo00.OooOo0o);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String c(com.byazt.dna.c cVar) {
        if (c == null) {
            c = tt("dev13", (String) null, cVar);
        }
        return c;
    }

    public static String tt(com.byazt.dna.c cVar) {
        if (tt == null) {
            tt = tt("dev15", (String) null, cVar);
        }
        return tt;
    }

    public static void c(String str, com.byazt.dna.c cVar, int i) {
        if (str == null || str.equals(c)) {
            return;
        }
        c = str;
        c("dev13", str, cVar, i);
    }

    public static void tt(String str, com.byazt.dna.c cVar, int i) {
        if (str == null || str.equals(tt)) {
            return;
        }
        tt = str;
        c("dev15", str, cVar, i);
    }
}
