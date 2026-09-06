package com.opos.cmn.g.b.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.af;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6164a = "com." + com.opos.cmn.an.b.a.c + ".market";

    private static boolean a(Activity activity, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "marketUrl is empty";
        } else {
            if (activity != null) {
                try {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    String str3 = f6164a;
                    if (b(origApplicationContext, str3)) {
                        intent.setPackage(str3);
                    } else {
                        if (!b(origApplicationContext, af.e)) {
                            com.opos.cmn.an.f.a.d("MarketDLTool", "not find market app");
                            return false;
                        }
                        intent.setPackage(af.e);
                    }
                    activity.startActivityForResult(intent, 100);
                    return true;
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("MarketDLTool", "launchDownloadPageForActivity", e);
                    return true;
                }
            }
            str2 = "activity is null";
        }
        com.opos.cmn.an.f.a.d("MarketDLTool", str2);
        return false;
    }

    public static boolean a(Context context, String str) {
        String str2;
        if (context == null) {
            str2 = "context is null";
        } else {
            if (!TextUtils.isEmpty(str)) {
                com.opos.cmn.an.f.a.b("MarketDLTool", "market url:" + str);
                try {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    if (!b(origApplicationContext, f6164a) && !b(origApplicationContext, af.e)) {
                        com.opos.cmn.an.f.a.d("MarketDLTool", "not find market app");
                        return false;
                    }
                    if (context instanceof Activity) {
                        a((Activity) context, str);
                        return true;
                    }
                    com.opos.cmn.an.transactivity.api.a.a(context, new com.opos.cmn.g.b.a.a(str));
                    return true;
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("MarketDLTool", "launchDownloadPage", e);
                    return true;
                }
            }
            str2 = "marketUrl is empty";
        }
        com.opos.cmn.an.f.a.d("MarketDLTool", str2);
        return false;
    }

    private static boolean b(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return (packageInfo == null || packageInfo.applicationInfo == null || !packageInfo.applicationInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
