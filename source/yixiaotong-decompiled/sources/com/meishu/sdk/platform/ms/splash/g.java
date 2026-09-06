package com.meishu.sdk.platform.ms.splash;

import android.text.TextUtils;
import android.view.View;
import com.google.gson.Gson;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.meishu_ad.v;
import com.meishu.sdk.meishu_ad.y;
import com.qq.e.comm.pi.IReward;
import java.util.HashMap;

/* JADX INFO: compiled from: SplashAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g implements com.meishu.sdk.meishu_ad.splash.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f5245a;
    public com.meishu.sdk.core.ad.splash.d b;
    public com.meishu.sdk.platform.ms.splash.a c;
    public com.meishu.sdk.platform.ms.splash.b d;
    public volatile boolean e;
    public boolean f;
    public final v g;
    public boolean h;
    public View i;
    public boolean j;
    public d k;

    /* JADX INFO: compiled from: SplashAdListenerAdapter.java */
    public class a extends l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                g gVar = g.this;
                com.meishu.sdk.platform.ms.splash.a aVar = gVar.c;
                if (aVar == null) {
                    try {
                        o1.b(gVar.f5245a, ErrorCodeUtil.RENDER_AD_INTERRUPTED, "adWrapper 为空");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                u0.a(((com.meishu.sdk.meishu_ad.splash.d) aVar.f5177a).getPosId(), 3);
                String[] monitorUrl = ((com.meishu.sdk.meishu_ad.splash.d) g.this.c.f5177a).getMonitorUrl();
                v vVar = g.this.g;
                if (vVar != null) {
                    h0.b(monitorUrl, vVar.a());
                }
                try {
                    if (g.a(g.this) == AdType.SPLASH.value()) {
                        h0.a(monitorUrl, g.this.i, (View) null);
                    } else {
                        h0.a(monitorUrl, g.this.i.findViewById(R.id.activity_sdk_splash_mediaContainer), g.this.i);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (monitorUrl == null) {
                    try {
                        o1.b(g.this.f5245a, ErrorCodeUtil.RENDER_AD_INTERRUPTED, "monitorUrls 为空");
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                try {
                    LogUtil.d("SplashAdListenerAdapter", "send onADExposure");
                    for (String str : monitorUrl) {
                        if (!TextUtils.isEmpty(str)) {
                            z.a(g.this.c.getContext(), h0.a(h0.a(h0.a(str, ((com.meishu.sdk.meishu_ad.splash.d) g.this.c.f5177a).getAct_type(), AdType.SPLASH), g.this.i.getWidth(), g.this.i.getHeight())), new com.meishu.sdk.core.utils.i());
                        }
                    }
                    g gVar2 = g.this;
                    com.meishu.sdk.core.ad.splash.d dVar = gVar2.b;
                    if (dVar != null) {
                        dVar.onAdPresent(gVar2.d);
                        g.this.b.onAdExposure();
                    }
                    com.meishu.sdk.platform.ms.splash.b bVar = g.this.d;
                    if (bVar != null && bVar.getInteractionListener() != null) {
                        g.this.d.getInteractionListener().onAdExposure();
                    }
                    d dVar2 = g.this.k;
                    if (dVar2 != null) {
                        ((y) dVar2).a();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            } catch (Throwable th2) {
                o1.b(g.this.f5245a, ErrorCodeUtil.RENDER_AD_INTERRUPTED, "adWrapper 为空");
                th2.printStackTrace();
            }
            try {
                o1.b(g.this.f5245a, ErrorCodeUtil.RENDER_AD_INTERRUPTED, "adWrapper 为空");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            th2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SplashAdListenerAdapter.java */
    public class b extends l {
        public b() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                com.meishu.sdk.core.ad.splash.d dVar = g.this.b;
                if (dVar != null) {
                    dVar.onAdClosed();
                }
                com.meishu.sdk.platform.ms.splash.b bVar = g.this.d;
                if (bVar == null || bVar.getInteractionListener() == null) {
                    return;
                }
                g.this.d.getInteractionListener().onAdClosed();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SplashAdListenerAdapter.java */
    public class c extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5248a;
        public final /* synthetic */ int b;

        public c(String str, int i) {
            this.f5248a = str;
            this.b = i;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                com.meishu.sdk.core.ad.splash.d dVar = g.this.b;
                if (dVar != null) {
                    dVar.onAdRenderFail(this.f5248a, this.b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SplashAdListenerAdapter.java */
    public interface d {
    }

    public g(com.meishu.sdk.platform.ms.splash.a aVar, com.meishu.sdk.core.ad.splash.d dVar, boolean z, v vVar) {
        this.c = aVar;
        this.b = dVar;
        this.f = z;
        this.g = vVar;
        try {
            this.f5245a = aVar.a().getEventUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        com.meishu.sdk.platform.ms.splash.a aVar;
        ShakeUtil.getInstance().a();
        if (!this.h && (aVar = this.c) != null) {
            try {
                String[] closeUrl = ((com.meishu.sdk.meishu_ad.splash.d) aVar.f5177a).getCloseUrl();
                if (closeUrl != null) {
                    for (String str : closeUrl) {
                        if (!TextUtils.isEmpty(str)) {
                            z.a(this.c.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        SdkHandler.getInstance().runOnUiThread(new b());
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public synchronized void onADExposure() {
        try {
            try {
                Gson gson = new Gson();
                HashMap map = new HashMap();
                map.put("stepNum", 6);
                map.put("msg", "start exposure");
                Integer numA = a();
                if (numA != null) {
                    map.put("creativeType", numA);
                }
                if (this.i != null) {
                    map.put(IReward.AD_VIEW, 1);
                } else {
                    map.put(IReward.AD_VIEW, 0);
                }
                if (this.e) {
                    map.put("hasExposed", 1);
                } else {
                    map.put("hasExposed", 0);
                }
                if (this.c != null) {
                    map.put("adWrapper", 1);
                } else {
                    map.put("adWrapper", 0);
                }
                o1.a(this.f5245a, gson.toJson(map));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.e) {
                if (this.i != null) {
                    this.e = true;
                    this.i.post(new a());
                } else {
                    try {
                        o1.b(this.f5245a, ErrorCodeUtil.RENDER_AD_INTERRUPTED, "adView 为空");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            try {
                o1.b(this.f5245a, ErrorCodeUtil.RENDER_AD_INTERRUPTED, "adWrapper 为空");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADLoaded(com.meishu.sdk.meishu_ad.splash.b bVar) {
        com.meishu.sdk.meishu_ad.splash.b bVar2 = bVar;
        com.meishu.sdk.platform.ms.splash.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        com.meishu.sdk.platform.ms.splash.b bVar3 = new com.meishu.sdk.platform.ms.splash.b(bVar2, aVar, this, this.f);
        this.d = bVar3;
        try {
            com.meishu.sdk.core.ad.splash.d dVar = this.b;
            if (dVar != null) {
                dVar.onAdReady(bVar3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onAdRenderFail(String str, int i) {
        SdkHandler.getInstance().runOnUiThread(new c(str, i));
    }

    public final Integer a() {
        T t;
        com.meishu.sdk.platform.ms.splash.a aVar = this.c;
        if (aVar == null || (t = aVar.f5177a) == 0) {
            return null;
        }
        return Integer.valueOf(((com.meishu.sdk.meishu_ad.splash.d) t).getAdPatternType());
    }

    public static int a(g gVar) {
        T t;
        com.meishu.sdk.platform.ms.splash.a aVar = gVar.c;
        if (aVar != null && (t = aVar.f5177a) != 0) {
            int ad_type = ((com.meishu.sdk.meishu_ad.splash.d) t).getAd_type();
            return ad_type != 0 ? ad_type : AdType.SPLASH.value();
        }
        return AdType.SPLASH.value();
    }
}
