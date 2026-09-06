package com.ubix.ssp.ad.e.x;

import android.os.Build;
import android.text.TextUtils;
import com.ubix.ssp.ad.e.a0.n;
import com.ubix.ssp.ad.e.a0.v;
import com.ubix.ssp.open.UBiXInitManger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {
    private static String a() {
        try {
            String strD = v.d(com.ubix.ssp.ad.e.a0.c.e(), "ubix_sp_tower1", "init_server_replace_url");
            System.out.println("------sNetEnvironment: " + UBiXInitManger.b);
            if (UBiXInitManger.b == UBiXInitManger.a.ONLINE) {
                return TextUtils.isEmpty(strD) ? "https://adx-cfg-u1.ubixioe.com" : strD;
            }
            return TextUtils.isEmpty(strD) ? new String(n.a().a("aHR0cDovL2VudHJ5LXRlc3QudWJpeGlvZS5jb20=")) : strD;
        } catch (Exception unused) {
            return "https://adx-cfg-u1.ubixioe.com";
        }
    }

    public static String a(String str) {
        return d() + "?sv=2.10.2.11&aid=" + str + "&dt=1&os=android&br=" + Build.MANUFACTURER + "&ov=" + Build.VERSION.RELEASE;
    }

    private static String b() {
        try {
            String strD = v.d(com.ubix.ssp.ad.e.a0.c.e(), "ubix_sp_tower1", "request_server_replace_url");
            System.out.println("------sNetEnvironment: " + UBiXInitManger.b);
            if (UBiXInitManger.b == UBiXInitManger.a.ONLINE) {
                return TextUtils.isEmpty(strD) ? "https://entry-su1.ubixioe.com" : strD;
            }
            return TextUtils.isEmpty(strD) ? new String(n.a().a("aHR0cDovL2VudHJ5LXRlc3QudWJpeGlvZS5jb20=")) : strD;
        } catch (Exception unused) {
            return "https://entry-su1.ubixioe.com";
        }
    }

    private static String c() {
        try {
            String strD = v.d(com.ubix.ssp.ad.e.a0.c.e(), "ubix_sp_tower1", "collection_server_url");
            if (UBiXInitManger.b == UBiXInitManger.a.ONLINE) {
                return TextUtils.isEmpty(strD) ? "https://adx-data-u1.ubixioe.com" : strD;
            }
            return new String(n.a().a("aHR0cDovL3R4LWRhdGEtdTEtdGVzdC51Yml4aW9lLmNvbQ=="));
        } catch (Exception unused) {
            return "https://adx-data-u1.ubixioe.com";
        }
    }

    public static String d() {
        return a() + "/mob/sdk/v3/init";
    }

    public static String e() {
        return b() + "/mob/sdk/v2/endpoint";
    }

    public static String f() {
        return c() + "/tx";
    }
}
