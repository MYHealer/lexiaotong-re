package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: HeaderHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f9274a;
    private String b;
    private String c;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.internal.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: HeaderHelper.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    private a() {
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeaderHelper.java */
    private static class C1153a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f9275a = new a(null);

        private C1153a() {
        }
    }

    public static a a(Context context) {
        if (f9274a == null && context != null) {
            f9274a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C1153a.f9275a;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(am.aD);
    }

    public void d(String str) {
        String strSubstring = str.substring(0, str.indexOf(95));
        f(strSubstring);
        e(strSubstring);
    }

    private void e(String str) {
        try {
            String strReplaceAll = str.replaceAll("&=", PPSLabelView.Code).replaceAll("&&", PPSLabelView.Code).replaceAll("==", "/");
            StringBuilder sb = new StringBuilder();
            sb.append(strReplaceAll).append("/Android/").append(Build.DISPLAY).append("/").append(Build.MODEL).append("/").append(Build.VERSION.RELEASE).append(PPSLabelView.Code).append(HelperUtils.getUmengMD5(UMUtils.getAppkey(f9274a)));
            this.b = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f9274a, th);
        }
    }

    private void f(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] strArrSplit = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(am.aP);
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    String strSubstring = str3.substring(0, 2);
                    if (strSubstring.endsWith("=")) {
                        strSubstring = strSubstring.replace("=", "");
                    }
                    sb.append(strSubstring);
                }
            }
            this.c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f9274a, th);
        }
    }
}
