package com.oplus.log;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.oplus.log.d.k;
import com.oplus.log.env.oversea.AreaEnv;
import com.oplus.log.env.test.TestAreaEnv;
import java.net.URLEncoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5830a = "com.oplus.log.g";
    private static String b = "";
    private static String c = "222%23";
    private static String d;

    private static String a() {
        String hostTest;
        try {
            hostTest = TestAreaEnv.getHostTest();
        } catch (Throwable unused) {
            hostTest = "";
        }
        try {
            if (b.c()) {
                return hostTest;
            }
            if (com.oplus.log.d.b.b()) {
                return com.oplus.log.d.b.c() ? AreaEnv.getIndiaHost() : AreaEnv.getSingaporeHost();
            }
            return com.oplus.log.e.a.a.a();
        } catch (Throwable th) {
            if (b.c()) {
                Log.e("NearX-HLog", "makeUploadUrl-->".concat(String.valueOf(th)));
                th.printStackTrace();
            } else {
                Log.e("NearX-HLog", "makeUploadUrl--> Don't find AreaEnv class");
            }
            return "";
        }
    }

    private static String a(c.a aVar) {
        return aVar == null ? "" : aVar.a();
    }

    private static String a(c.b bVar) {
        if (bVar == null) {
            return "";
        }
        return (bVar.a() == null ? "" : bVar.a()) + "/" + (bVar.b() == null ? "" : bVar.b()) + "/" + (bVar.c() != null ? bVar.c() : "");
    }

    private static String a(String str) {
        try {
            if (TextUtils.isEmpty(d)) {
                d = c + com.oplus.log.d.a.a("puwQbwBb9CMen91BMLD+UA==", str);
            }
            return (TextUtils.isEmpty(d) || c.equals(d)) ? str : d;
        } catch (Exception e) {
            if (!b.c()) {
                return str;
            }
            e.printStackTrace();
            return str;
        }
    }

    public static String a(String str, String str2, c.a aVar, c.b bVar, String str3) {
        StringBuilder sb = new StringBuilder((a() + "/usertrace/log/business/config").replace("business", str));
        sb.append("?subType=").append(str2).append("&imei=").append(b(a(aVar))).append("&openId=").append(a(a(bVar))).append("&tracePkg=").append(str3);
        return sb.toString().replaceAll(PPSLabelView.Code, "_");
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5, c.a aVar, c.b bVar, String str6) {
        StringBuilder sb = new StringBuilder((a() + "/usertrace/log/business/upload").replace("business", str));
        sb.append("?traceId=").append(str2).append("&businessVersion=").append(com.oplus.log.d.b.c(com.oplus.log.d.b.a())).append("&protocolVersion=3&errorCode=").append(i).append("&subType=").append(str5).append("&brand=").append(com.oplus.log.d.f.b()).append("&model=").append(Build.MODEL).append("&osVersion=").append(com.oplus.log.d.f.c()).append("&romVersion=").append(com.oplus.log.d.f.a()).append("&androidVersion=").append(Build.VERSION.RELEASE).append("&imei=").append(b(a(aVar))).append("&openId=").append(a(a(bVar))).append("&tracePkg=").append(str6);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&fileName=").append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&errorMsg=").append(str4);
        }
        return sb.toString().replaceAll(PPSLabelView.Code, "_");
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5, c.a aVar, c.b bVar, String str6, String str7, String str8, long j, String str9, String str10, a aVar2) {
        String strReplace = (a() + "/usertrace/log/business/report").replace("business", str);
        String strB = b(a(aVar));
        String strA = a(a(bVar));
        String strA2 = k.a(str2, str8, j, i, str5, strB, strA, str6, str7, str3, str4, str9, str10, aVar2);
        StringBuilder sb = new StringBuilder(strReplace);
        sb.append("?specificId=").append(str2).append("&reportReason=").append(URLEncoder.encode(str8)).append("&program=").append(str7).append("&ts=").append(j).append("&sign=").append(strA2).append("&businessVersion=").append(com.oplus.log.d.b.c(com.oplus.log.d.b.a())).append("&protocolVersion=3&errorCode=").append(i).append("&subType=").append(str5).append("&brand=").append(com.oplus.log.d.f.b()).append("&model=").append(Build.MODEL).append("&osVersion=").append(com.oplus.log.d.f.c()).append("&romVersion=").append(com.oplus.log.d.f.a()).append("&androidVersion=").append(Build.VERSION.RELEASE).append("&imei=").append(strB).append("&openId=").append(strA).append("&tracePkg=").append(str6);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&fileName=").append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&errorMsg=").append(str4);
        }
        String string = sb.toString();
        aVar2.a("NearX-HLog", "签名后请求空格替换前参数: data: ".concat(String.valueOf(string)));
        String strReplaceAll = string.replaceAll(PPSLabelView.Code, "_");
        aVar2.a("NearX-HLog", "签名后请求空格替换后参数: data: ".concat(String.valueOf(strReplaceAll)));
        return strReplaceAll;
    }

    private static String b(String str) {
        try {
            if (TextUtils.isEmpty(b)) {
                b = c + com.oplus.log.d.a.a("puwQbwBb9CMen91BMLD+UA==", str);
            }
            return (TextUtils.isEmpty(b) || c.equals(b)) ? str : b;
        } catch (Exception e) {
            if (!b.c()) {
                return str;
            }
            e.printStackTrace();
            return str;
        }
    }
}
