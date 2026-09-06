package com.kwad.sdk.core.webview.d;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.n;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        cVar.b(C0752a.PL());
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    public static final class C0752a extends com.kwad.sdk.core.response.a.a {
        public String Nq;
        public String SDKVersion;
        public int SDKVersionCode;
        public int Sp;
        public int Sq;
        public String Un;
        public String aQZ;
        public String aRa;
        public String aWY;
        public String aWn;
        public String aXa;
        public String aXb;
        public String aXo;
        public String appId;
        public String appName;
        public String appVersion;
        public int aqA;
        public int aqB;
        public String aqu;
        public String aqv;
        public int aqw;
        public String aqx;
        public int aqy;
        public String aqz;
        public String bda;
        public String bdb;
        public boolean bdc;
        public String bdd;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static C0752a PL() {
            C0752a c0752a = new C0752a();
            c0752a.SDKVersion = BuildConfig.VERSION_NAME;
            c0752a.SDKVersionCode = BuildConfig.VERSION_CODE;
            c0752a.aWn = "6.2.3";
            c0752a.bdd = "1.3";
            c0752a.sdkApiVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0752a.sdkApiVersionCode = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0752a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0752a.appVersion = n.cZ(context);
            c0752a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0752a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0752a.bda = "";
            c0752a.aXb = ai.getEGid();
            h hVar = (h) d.f(h.class);
            if (hVar != null) {
                c0752a.aXa = hVar.qQ();
            }
            c0752a.aqu = String.valueOf(aq.dB(context));
            c0752a.aqv = bt.WU();
            c0752a.model = bt.WK();
            c0752a.Nq = bt.WM();
            c0752a.aqw = 1;
            c0752a.aqx = bt.getOsVersion();
            c0752a.aqy = bt.WX();
            c0752a.aqz = bt.getLanguage();
            c0752a.Un = bt.getLocale();
            c0752a.bdc = ((f) ServiceProvider.get(f.class)).Fu();
            c0752a.bdb = bf.getDeviceId();
            c0752a.Sq = bt.getScreenWidth(context);
            c0752a.Sp = bt.getScreenHeight(context);
            c0752a.aQZ = bf.dO(context);
            c0752a.aRa = bf.getOaid();
            c0752a.aWY = bf.dP(context);
            c0752a.aXo = bf.dQ(context);
            c0752a.aqA = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0752a.aqB = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0752a;
        }
    }
}
