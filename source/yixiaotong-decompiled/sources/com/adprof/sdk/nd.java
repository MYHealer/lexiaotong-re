package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adprof.sdk.base.x.X;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class nd extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ td f1323a;

    public nd(td tdVar) {
        this.f1323a = tdVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        ResolveInfo resolveInfoResolveActivity;
        try {
            if (pk.f594a) {
                pk.d("shouldOverrideUrlLoading  = " + str);
            }
            Context context = webView.getContext();
            String scheme = Uri.parse(str).getScheme();
            if (td.a(this.f1323a, str)) {
                try {
                    d dVar = this.f1323a.f744a;
                    if (dVar != null) {
                        n8.a(str, dVar);
                        pk.d("LandPageViewController downloadApk = " + str);
                        return true;
                    }
                } catch (Throwable th) {
                    pk.a(th);
                    oh.b(th);
                }
                pk.b("set webview client error: ", th);
                return false;
            }
            if (TextUtils.isEmpty(scheme) || scheme.equals("http") || scheme.equals("https")) {
                if (pk.f594a) {
                    pk.c("load Url: " + str);
                }
                return false;
            }
            if (pk.f594a) {
                pk.d("shouldOverrideUrlLoading  scheme = " + scheme);
            }
            try {
                Activity activityA = q1.a();
                d dVar2 = this.f1323a.f744a;
                if (dVar2 != null && activityA != null && vl.b(dVar2)) {
                    try {
                        PackageManager packageManager = activityA.getPackageManager();
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        intent.addFlags(32768);
                        intent.addFlags(268435456);
                        resolveInfoResolveActivity = Build.VERSION.SDK_INT >= 33 ? packageManager.resolveActivity(intent, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.resolveActivity(intent, 0);
                    } catch (Throwable th2) {
                        pk.a(th2);
                        oh.b(th2);
                        resolveInfoResolveActivity = null;
                    }
                    if (resolveInfoResolveActivity != null) {
                        ul ulVarA = vl.a(this.f1323a.f744a);
                        if (ulVarA != null && "1".equals(ulVarA.r) && X.f1088a) {
                            pk.d("land page direct jump dp ");
                            X.x(activityA, str);
                        } else {
                            pk.d("land page show dp dialog ");
                            ic.a(context, Uri.parse(str));
                        }
                    }
                }
            } catch (Throwable th3) {
                pk.a(th3);
                oh.b(th3);
            }
            return true;
        } catch (Throwable th4) {
            pk.b("set webview client error: ", th4);
            return false;
        }
    }
}
