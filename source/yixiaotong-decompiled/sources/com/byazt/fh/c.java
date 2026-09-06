package com.byazt.fh;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.aas.z;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.stub.StubApp;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 505, 20})
public class c {
    public static volatile String c;
    public static volatile String tt;
    public static String ve;

    public static String c() {
        return "open_news";
    }

    public static String tt() {
        return "1371";
    }

    public static String ve() {
        return "7.6.1.1";
    }

    public static String uj() {
        return p.n;
    }

    public static String n() {
        return nb.da();
    }

    public static String a() {
        return x.m().qy();
    }

    public static String sp() {
        return rh.sp(gt.getContext());
    }

    public static String x() {
        return z.c();
    }

    public static String i() {
        try {
            if (c != null) {
                return c;
            }
            Context context = gt.getContext();
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && bundle.keySet() != null) {
                for (String str : bundle.keySet()) {
                    if (str != null && str.toLowerCase().contains("channel")) {
                        Object obj = bundle.get(str);
                        jSONObject.putOpt(str, obj != null ? obj.toString() : "");
                    }
                }
            }
            c = jSONObject.toString();
            return c;
        } catch (Throwable th) {
            m.tt("getApplicationName:", th);
        }
    }

    public static String da() {
        if (tt != null) {
            return tt;
        }
        Context context = gt.getContext();
        try {
            PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
            tt = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Exception unused) {
        }
        return tt;
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            m.c(e);
            return 0;
        }
    }

    @HungeonFlag
    public static String sl() {
        try {
            if (!TextUtils.isEmpty(ve)) {
                return ve;
            }
            String strVe = com.byazt.by.uj.c().ve("app_sha1", 2592000000L);
            ve = strVe;
            if (!TextUtils.isEmpty(strVe)) {
                return ve;
            }
            String strC = com.byazt.nr.ve.c(gt.getContext());
            ve = strC;
            if (c(strC)) {
                ve = ve.toUpperCase(Locale.getDefault());
                com.byazt.by.uj.c().ve("app_sha1", ve);
                return ve;
            }
            return "";
        } catch (Exception unused) {
        }
    }

    private static boolean c(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split(com.huawei.openalliance.ad.constant.x.bQ)) == null || strArrSplit.length < 20) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
