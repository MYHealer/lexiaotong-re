package com.kwad.components.core.webview.jsPublicBridge.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.n;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "ksadUnionGetPlatformInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        cVar.b(C0694a.yq());
    }

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jsPublicBridge.a.a$a, reason: collision with other inner class name */
    public static final class C0694a extends com.kwad.sdk.core.response.a.a {
        public int apb;
        public int apc;
        public int apd;
        public String ape;
        public String apf;
        public String apg;
        public String appVersion;
        public int netType;

        public static C0694a yq() {
            C0694a c0694a = new C0694a();
            c0694a.apb = 6;
            c0694a.apc = 2;
            c0694a.apd = 2;
            c0694a.appVersion = n.cZ(((f) ServiceProvider.get(f.class)).getContext());
            c0694a.netType = ym();
            c0694a.ape = e.KZ();
            c0694a.apf = "KSAdChinaMobile.ksadGetPhoneNumber";
            c0694a.apg = "KSAdChinaMobile.ksadGetOperJudge";
            return c0694a;
        }

        private static int ym() {
            if (!SystemUtil.b(ServiceProvider.getContext(), g.b)) {
                return -1;
            }
            try {
                Context context = ServiceProvider.getContext();
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (connectivityManager == null) {
                    return -1;
                }
                boolean zIsDataEnabled = telephonyManager.isDataEnabled();
                boolean zIsWifiConnected = aq.isWifiConnected(context);
                if (zIsDataEnabled && zIsWifiConnected) {
                    return 3;
                }
                if (zIsDataEnabled) {
                    return 1;
                }
                return zIsWifiConnected ? 2 : -1;
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                return -1;
            }
        }
    }
}
