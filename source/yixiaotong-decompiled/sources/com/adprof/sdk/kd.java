package com.adprof.sdk;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class kd {
    public static boolean a() {
        String strOptString;
        try {
            JSONObject jSONObject = d1.f1121a.a().f210a;
            String str = "";
            if (jSONObject != null && (strOptString = jSONObject.optString("ipv6", "")) != null) {
                str = strOptString;
            }
            pk.d(" server ipv6_report = " + str);
            return !TextUtils.isEmpty(str) && Integer.parseInt(str.trim()) == 1;
        } catch (Throwable th) {
            pk.c("Ipv6ReportUtil shouldReportIpv6 parse error: ", th);
        }
        return false;
    }
}
