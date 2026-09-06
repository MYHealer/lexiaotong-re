package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import client.android.yixiaotong.util.TimeUtils;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.security.mobile.module.http.model.c;
import com.alipay.security.mobile.module.http.model.d;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1592a;
    private com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    private int c = 4;

    public a(Context context) {
        this.f1592a = context;
    }

    public static String a(Context context) {
        String strB = b(context);
        return com.alipay.security.mobile.module.a.a.a(strB) ? h.f(context) : strB;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String strA = i.a(str);
            if (!com.alipay.security.mobile.module.a.a.a(strA)) {
                return strA;
            }
            String strA2 = g.a(context, str);
            i.a(str, strA2);
            return !com.alipay.security.mobile.module.a.a.a(strA2) ? strA2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtils.FORMATDATETIME);
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int iRandom = (int) (Math.random() * 24.0d * 60.0d * 60.0d);
        for (int i = 0; i < 3; i++) {
            try {
                String[] strArrSplit = strArr[i].split(PPSLabelView.Code);
                if (strArrSplit != null && strArrSplit.length == 2) {
                    Date date = new Date();
                    Date date2 = simpleDateFormat.parse(strArrSplit[0] + " 00:00:00");
                    Date date3 = simpleDateFormat.parse(strArrSplit[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(13, iRandom);
                    Date time = calendar.getTime();
                    if (date.after(date2) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b bVarB;
        b bVarC;
        String str4 = "";
        try {
            Context context = this.f1592a;
            d dVar = new d();
            String strA = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
            String strA2 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", "");
            String strA3 = com.alipay.security.mobile.module.a.a.a(map, "rpcVersion", "");
            String strA4 = a(context, strA);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String strD = h.d(context);
            if (com.alipay.security.mobile.module.a.a.b(strA2)) {
                dVar.c = strA2;
            } else {
                dVar.c = strA4;
            }
            dVar.d = securityToken;
            dVar.e = strD;
            dVar.f1703a = "android";
            com.alipay.apmobilesecuritysdk.e.c cVarC = com.alipay.apmobilesecuritysdk.e.d.c(context);
            if (cVarC != null) {
                str2 = cVarC.f1596a;
                str = cVarC.c;
            } else {
                str = "";
                str2 = str;
            }
            if (com.alipay.security.mobile.module.a.a.a(str2) && (bVarC = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = bVarC.f1595a;
                str = bVarC.c;
            }
            com.alipay.apmobilesecuritysdk.e.c cVarB = com.alipay.apmobilesecuritysdk.e.d.b();
            if (cVarB != null) {
                str4 = cVarB.f1596a;
                str3 = cVarB.c;
            } else {
                str3 = "";
            }
            if (com.alipay.security.mobile.module.a.a.a(str4) && (bVarB = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = bVarB.f1595a;
                str3 = bVarB.c;
            }
            dVar.h = str2;
            dVar.g = str4;
            dVar.j = strA3;
            if (com.alipay.security.mobile.module.a.a.a(str2)) {
                dVar.b = str4;
                dVar.i = str3;
            } else {
                dVar.b = str2;
                dVar.i = str;
            }
            dVar.f = e.a(context, map);
            return com.alipay.security.mobile.module.http.d.b(this.f1592a, this.b.c()).a(dVar);
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    private static String b(Context context) {
        try {
            String strB = i.b();
            if (!com.alipay.security.mobile.module.a.a.a(strB)) {
                return strB;
            }
            com.alipay.apmobilesecuritysdk.e.c cVarB = com.alipay.apmobilesecuritysdk.e.d.b(context);
            if (cVarB != null) {
                i.a(cVarB);
                String str = cVarB.f1596a;
                if (com.alipay.security.mobile.module.a.a.b(str)) {
                    return str;
                }
            }
            b bVarB = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (bVarB == null) {
                return "";
            }
            i.a(bVarB);
            String str2 = bVarB.f1595a;
            return com.alipay.security.mobile.module.a.a.b(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i = 0; i < 5; i++) {
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/" + strArr[i]);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00bd  */
    public final int a(Map<String, String> map) {
        boolean z;
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.f1592a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.g, ""), a(this.f1592a));
            String strA = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
            b();
            b(this.f1592a);
            a(this.f1592a, strA);
            i.a();
            int i = 0;
            if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.f1592a)) {
                e.a();
                if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.f1592a, map), i.c()))) {
                    String strA2 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                    String strA3 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.g, "");
                    if ((!com.alipay.security.mobile.module.a.a.b(strA2) || com.alipay.security.mobile.module.a.a.a(strA2, i.d())) && ((!com.alipay.security.mobile.module.a.a.b(strA3) || com.alipay.security.mobile.module.a.a.a(strA3, i.e())) && i.a(this.f1592a, strA) && !com.alipay.security.mobile.module.a.a.a(a(this.f1592a, strA)) && !com.alipay.security.mobile.module.a.a.a(b(this.f1592a)))) {
                        z = false;
                    }
                }
                z = true;
            } else if (com.alipay.security.mobile.module.a.a.a(a(this.f1592a, strA)) || com.alipay.security.mobile.module.a.a.a(b(this.f1592a))) {
                z = true;
            } else {
                z = false;
            }
            Context context = this.f1592a;
            com.alipay.security.mobile.module.b.b.a();
            h.b(context, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
            if (z) {
                new com.alipay.apmobilesecuritysdk.c.b();
                UmidSdkWrapper.startUmidTaskSync(this.f1592a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                c cVarB = b(map);
                int iA = cVarB != null ? cVarB.a() : 2;
                if (iA == 1) {
                    h.a(this.f1592a, cVarB.b());
                    h.d(this.f1592a, cVarB.c());
                    h.e(this.f1592a, cVarB.l);
                    h.a(this.f1592a, cVarB.m);
                    h.f(this.f1592a, cVarB.n);
                    h.g(this.f1592a, cVarB.p);
                    i.c(e.b(this.f1592a, map));
                    i.a(strA, cVarB.i);
                    i.b(cVarB.h);
                    i.d(cVarB.o);
                    String strA4 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                    if (!com.alipay.security.mobile.module.a.a.b(strA4) || com.alipay.security.mobile.module.a.a.a(strA4, i.d())) {
                        strA4 = i.d();
                    } else {
                        i.e(strA4);
                    }
                    i.e(strA4);
                    String strA5 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.g, "");
                    if (!com.alipay.security.mobile.module.a.a.b(strA5) || com.alipay.security.mobile.module.a.a.a(strA5, i.e())) {
                        strA5 = i.e();
                    } else {
                        i.f(strA5);
                    }
                    i.f(strA5);
                    i.a();
                    com.alipay.apmobilesecuritysdk.e.d.a(this.f1592a, i.g());
                    com.alipay.apmobilesecuritysdk.e.d.a();
                    com.alipay.apmobilesecuritysdk.e.a.a(this.f1592a, new b(i.b(), i.c(), i.f()));
                    com.alipay.apmobilesecuritysdk.e.a.a();
                    g.a(this.f1592a, strA, i.a(strA));
                    g.a();
                    h.a(this.f1592a, strA, System.currentTimeMillis());
                } else if (iA != 3) {
                    com.alipay.apmobilesecuritysdk.c.a.a(cVarB != null ? "Server error, result:" + cVarB.b : "Server error, returned null");
                    if (com.alipay.security.mobile.module.a.a.a(a(this.f1592a, strA))) {
                        i = 4;
                    }
                } else {
                    i = 1;
                }
            }
            this.c = i;
            com.alipay.security.mobile.module.http.v2.a aVarB = com.alipay.security.mobile.module.http.d.b(this.f1592a, this.b.c());
            Context context2 = this.f1592a;
            ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1 && h.c(context2)) {
                new com.alipay.security.mobile.module.d.b(context2.getFilesDir().getAbsolutePath() + "/log/ap", aVarB).a();
            }
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        return this.c;
    }
}
