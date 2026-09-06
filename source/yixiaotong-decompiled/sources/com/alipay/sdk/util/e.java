package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.AlipayResultActivity;
import com.stub.StubApp;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1657a = "failed";
    public static final String b = "scheme_failed";
    private Activity c;
    private IAlixPay d;
    private boolean f;
    private a g;
    private final Object e = IAlixPay.class;
    private ServiceConnection h = new f(this);
    private String i = null;
    private IRemoteServiceCallback j = new h(this);

    public interface a {
        void a();

        void b();
    }

    public void a() {
        this.c = null;
    }

    public e(Activity activity, a aVar) {
        this.c = activity;
        this.g = aVar;
    }

    public String a(String str) {
        String strA = "";
        int i = 0;
        try {
            List<com.alipay.sdk.data.a.C0082a> listF = com.alipay.sdk.data.a.g().f();
            if (!com.alipay.sdk.data.a.g().q || listF == null) {
                listF = com.alipay.sdk.app.i.f1624a;
            }
            n.a aVarA = n.a(this.c, listF);
            if (aVarA == null || aVarA.a() || aVarA.b() || n.a(aVarA.f1667a)) {
                return f1657a;
            }
            if (aVarA.f1667a == null || com.hihonor.adsdk.base.c.q.hnadsb.equals(aVarA.f1667a.packageName)) {
                strA = n.a();
            } else {
                strA = aVarA.f1667a.packageName;
            }
            i = aVarA.f1667a != null ? aVarA.f1667a.versionCode : 0;
            a(aVarA);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.F, th);
        }
        return a(str, strA, i);
    }

    private void a(n.a aVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (aVar == null || (packageInfo = aVar.f1667a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.c.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.J, th);
        }
        Thread.sleep(200L);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private String a(String str, String str2, int i) {
        String strReplace;
        String str3;
        String str4;
        String strSubstring;
        String strSubstring2;
        JSONObject jSONObject;
        String strA = a(str, str2);
        boolean zB = com.alipay.sdk.data.a.g().b();
        if (f1657a.equals(strA) && com.hihonor.adsdk.base.c.q.hnadsb.equals(str2) && i > 125 && !zB) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPNotStartByConfig", "");
        }
        if (!f1657a.equals(strA) || !com.hihonor.adsdk.base.c.q.hnadsb.equals(str2) || i <= 125 || !zB) {
            return strA;
        }
        Activity activity = this.c;
        if (activity == null || !a(str2, activity)) {
            return b;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String strA2 = n.a(32);
        com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPStart", strA2);
        AlipayResultActivity.f1608a.put(strA2, new g(this, countDownLatch));
        try {
            try {
                String[] strArrSplit = str.split("&", -1);
                int length = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        str4 = null;
                        strSubstring = "";
                        strSubstring2 = strSubstring;
                        jSONObject = null;
                        break;
                    }
                    str4 = strArrSplit[i2];
                    if (str4.startsWith(com.alipay.sdk.sys.a.d)) {
                        String strSubstring3 = str4.substring(str4.indexOf("{"), str4.lastIndexOf(i.d) + 1);
                        int iIndexOf = str4.indexOf(strSubstring3);
                        strSubstring2 = str4.substring(0, iIndexOf);
                        strSubstring = str4.substring(iIndexOf + strSubstring3.length());
                        jSONObject = new JSONObject(strSubstring3);
                        if (jSONObject.optString("sc").equals("h5tonative")) {
                            jSONObject.put("sc", "h5tonative_scheme");
                            break;
                        }
                        jSONObject.put("sc", "h5tonative_sdkscheme");
                        break;
                    }
                    i2++;
                }
                if (TextUtils.isEmpty(str4)) {
                    throw new RuntimeException("empty ctx_args");
                }
                if (str.indexOf(str4) != str.lastIndexOf(str4)) {
                    throw new RuntimeException("multi ctx_args");
                }
                strReplace = str.replace(str4, strSubstring2 + jSONObject.toString() + strSubstring);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sourcePid", Binder.getCallingPid());
                jSONObject2.put(com.alipay.sdk.cons.b.d, strReplace);
                jSONObject2.put(com.hihonor.adsdk.base.c.r1.hnadse, this.c.getPackageName());
                jSONObject2.put(com.umeng.analytics.pro.d.aw, strA2);
                String str5 = "alipays://platformapi/startapp?appId=20000125&mqpSchemePay=" + Uri.encode(Base64.encodeToString(jSONObject2.toString().getBytes("UTF-8"), 2));
                Intent intent = new Intent();
                intent.setPackage(str2);
                intent.addFlags(268435456);
                intent.setData(Uri.parse(str5));
                this.c.startActivity(intent);
                com.alipay.sdk.data.a.g().a(StubApp.getOrigApplicationContext(this.c.getApplicationContext()));
                countDownLatch.await();
                String str6 = this.i;
                try {
                    str3 = l.a(str6).get(l.f1664a);
                    if (str3 == null) {
                        str3 = "null";
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPStatEx", th);
                    str3 = "unknown";
                }
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPDone-" + str3, "");
                if (!TextUtils.isEmpty(str6)) {
                    return str6;
                }
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPEmpty", "");
                return b;
            } catch (Exception e) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPSCReplaceEx", e, Base64.encodeToString(str.getBytes(), 2));
                strReplace = str;
            }
        } catch (InterruptedException e2) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPWaiting", e2);
            return com.alipay.sdk.app.j.a(com.alipay.sdk.app.k.PAY_WAITTING.a(), com.alipay.sdk.app.k.PAY_WAITTING.b(), "");
        } catch (Throwable th2) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPEx", th2);
            return b;
        }
    }

    private static boolean a(String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPDetectFail", "");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, "BSPDetectFail", th);
            return false;
        }
    }

    private String a(String str, String str2) {
        Activity activity;
        String strC;
        Activity activity2;
        Activity activity3;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(n.a(str2));
        String strA = n.a(this.c, str2);
        try {
            if (!StubApp.getOrigApplicationContext(this.c.getApplicationContext()).bindService(intent, this.h, 1)) {
                throw new Throwable("bindService fail");
            }
            synchronized (this.e) {
                if (this.d == null) {
                    try {
                        this.e.wait(com.alipay.sdk.data.a.g().a());
                    } catch (InterruptedException e) {
                        com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.D, e);
                    }
                }
            }
            try {
                if (this.d == null) {
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.x, strA + "|" + n.a(this.c, str2));
                    try {
                        this.d.unregisterCallback(this.j);
                    } catch (Throwable th) {
                        c.a(th);
                    }
                    try {
                        StubApp.getOrigApplicationContext(this.c.getApplicationContext()).unbindService(this.h);
                    } catch (Throwable th2) {
                        c.a(th2);
                    }
                    this.g = null;
                    this.j = null;
                    this.h = null;
                    this.d = null;
                    if (this.f && (activity3 = this.c) != null) {
                        activity3.setRequestedOrientation(0);
                        this.f = false;
                    }
                    return f1657a;
                }
                a aVar = this.g;
                if (aVar != null) {
                    aVar.a();
                }
                if (this.c.getRequestedOrientation() == 0) {
                    this.c.setRequestedOrientation(1);
                    this.f = true;
                }
                this.d.registerCallback(this.j);
                strC = this.d.Pay(str);
                try {
                    this.d.unregisterCallback(this.j);
                } catch (Throwable th3) {
                    c.a(th3);
                }
                try {
                    StubApp.getOrigApplicationContext(this.c.getApplicationContext()).unbindService(this.h);
                } catch (Throwable th4) {
                    c.a(th4);
                }
                this.g = null;
                this.j = null;
                this.h = null;
                this.d = null;
                if (this.f && (activity2 = this.c) != null) {
                    activity2.setRequestedOrientation(0);
                }
                return strC;
            } catch (Throwable th5) {
                try {
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.A, th5);
                    strC = com.alipay.sdk.app.j.c();
                    try {
                        this.d.unregisterCallback(this.j);
                    } catch (Throwable th6) {
                        c.a(th6);
                    }
                    try {
                        StubApp.getOrigApplicationContext(this.c.getApplicationContext()).unbindService(this.h);
                    } catch (Throwable th7) {
                        c.a(th7);
                    }
                    this.g = null;
                    this.j = null;
                    this.h = null;
                    this.d = null;
                    if (this.f && activity != null) {
                    }
                } finally {
                    try {
                        this.d.unregisterCallback(this.j);
                    } catch (Throwable th8) {
                        c.a(th8);
                    }
                    try {
                        StubApp.getOrigApplicationContext(this.c.getApplicationContext()).unbindService(this.h);
                    } catch (Throwable th9) {
                        c.a(th9);
                    }
                    this.g = null;
                    this.j = null;
                    this.h = null;
                    this.d = null;
                    if (this.f && (activity = this.c) != null) {
                        activity.setRequestedOrientation(0);
                        this.f = false;
                    }
                }
            }
        } catch (Throwable th10) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.C, th10);
            return f1657a;
        }
    }
}
