package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.adprof.sdk.base.activity.AdActivity;
import com.adprof.sdk.base.activity.AdxActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class r4 {
    public static void a(d dVar) {
        boolean zM709a;
        int iDecrementAndGet;
        if (dVar == null) {
            pk.e("BannerClickHandler handleBannerClickAction - adUnit is null");
            return;
        }
        int i = dVar.c;
        pk.a("BannerClickHandler handleBannerClickAction - interactionType: " + i);
        if (i == 1) {
            a(dVar, "banner_click");
            return;
        }
        if (i != 2) {
            if (i != 3) {
                pk.e("BannerClickHandler handleBannerClickAction - unknown interactionType: " + i);
                return;
            }
            if (dVar.m590a() == null) {
                pk.e("BannerClickHandler openDownload - AdConfig is null");
                return;
            }
            if (q1.a() == null) {
                pk.e("BannerClickHandler openDownload - cannot get current activity, fallback to direct download");
                dVar.m590a().m694a();
                return;
            }
            try {
                dVar.m590a().m695a();
                pk.a("BannerClickHandler openDownload - dialog shown: true");
                return;
            } catch (Throwable th) {
                pk.b("BannerClickHandler openDownload - show dialog error, fallback to direct download", th);
                return;
            }
        }
        if (TextUtils.isEmpty(dVar.f())) {
            pk.e("BannerClickHandler openDeeplink - adUnit is null or deeplink is empty");
            return;
        }
        a2 a2Var = new a2();
        a2Var.a(dVar);
        a2Var.a(dVar, "open_deeplink_start", null);
        String str = "";
        try {
            str = dVar.f188a.f641a.c;
        } catch (Exception unused) {
        }
        try {
            q0 q0Var = dVar.f188a;
            zM709a = q0Var != null ? q0Var.m709a() : false;
        } catch (Exception unused2) {
        }
        eh ehVar = eh.f1150a;
        String strA = ehVar.a(dVar.f(), str);
        Context context = AdprofSdk.getInstance().getContext();
        String strF = dVar.f();
        q4 q4Var = new q4(a2Var, dVar);
        try {
            if (!TextUtils.isEmpty(strF) && context != null) {
                g3 g3Var = g3.f300a;
                o7 o7Var = new o7(q4Var);
                synchronized (g3Var) {
                    iDecrementAndGet = g3.f301a.decrementAndGet();
                    g3.b.put(iDecrementAndGet, o7Var);
                }
                String strA2 = ehVar.a(strF, strA);
                Intent intent = new Intent(context, (Class<?>) AdxActivity.class);
                intent.putExtra("dp_url", strF);
                intent.putExtra("get_info_key", iDecrementAndGet);
                intent.putExtra("caller_pkg_name", strA2);
                intent.putExtra("ddp", zM709a);
                intent.addFlags(268435456);
                context.startActivity(intent);
                return;
            }
            pk.b("DeeplinkUtils", "deeplink is empty or context is null");
            q4Var.a(false, 1000);
        } catch (Throwable th2) {
            pk.a("DeeplinkUtils", "openDeeplink error", th2);
            q4Var.a(false, 1001);
        }
    }

    public static void a(d dVar, String str) {
        try {
            if (TextUtils.isEmpty(dVar.n)) {
                pk.e("BannerClickHandler openBrowser - landing_url is empty, cannot jump");
            } else {
                dVar.n = dVar.n;
                j5.a(AdprofSdk.getInstance().getContext(), AdActivity.class, dVar, "");
                pk.a("BannerClickHandler openBrowser - portal: " + str + " land_url: " + dVar.n);
            }
        } catch (Throwable th) {
            pk.b("BannerClickHandler openBrowser error", th);
        }
    }
}
