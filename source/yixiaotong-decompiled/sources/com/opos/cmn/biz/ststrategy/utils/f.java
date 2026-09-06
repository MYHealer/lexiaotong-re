package com.opos.cmn.biz.ststrategy.utils;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.envdev.api.EnvDevConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6030a = "f";

    public static String a(Context context) {
        String sTConfigUrl = "";
        if (context == null) {
            return "";
        }
        try {
            sTConfigUrl = EnvDevConfig.getSTConfigUrl(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(sTConfigUrl)) {
            return "https://stg-data.ads.heytapmobi.com/proxy/strategy/";
        }
        com.opos.cmn.an.f.a.b(f6030a, "getSTConfigUrl pub=https://stg-data.ads.heytapmobi.com/proxy/strategy/");
        return sTConfigUrl;
    }

    public static boolean a(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean b(Context context) {
        boolean z = false;
        if (context != null) {
            try {
                if (com.opos.cmn.biz.a.d.a(context).equalsIgnoreCase(d.b(context))) {
                    z = true;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(f6030a, "", e);
            }
        }
        com.opos.cmn.an.f.a.b(f6030a, "isLastRegion=" + z);
        return z;
    }
}
