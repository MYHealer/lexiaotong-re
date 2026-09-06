package com.meishu.sdk.platform.ms.splash;

import android.view.View;
import com.google.gson.Gson;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.meishu_ad.v;
import java.util.HashMap;

/* JADX INFO: compiled from: MeishuAdNativeWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends com.meishu.sdk.platform.ms.g<com.meishu.sdk.meishu_ad.splash.d, SplashAdLoader, com.meishu.sdk.core.ad.splash.d> {
    public v b;
    public com.meishu.sdk.meishu_ad.splash.a c;

    /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.splash.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MeishuAdNativeWrapper.java */
    public class C0853a extends l {
        public C0853a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                a.this.b = new v(((SplashAdLoader) a.this.adLoader).getContext());
                View view = null;
                ((com.meishu.sdk.core.ad.splash.d) a.this.getLoaderListener()).onAdLoaded(null);
                boolean zBooleanValue = ((Boolean) a.this.localParams.get(SplashAdLoader.KEY_AUTO_SHOW)).booleanValue();
                a aVar = a.this;
                aVar.c = new g(aVar, (com.meishu.sdk.core.ad.splash.d) aVar.getLoaderListener(), zBooleanValue, a.this.b);
                if (zBooleanValue && ((SplashAdLoader) a.this.getAdLoader()).getAdContainer() == null) {
                    ((g) a.this.c).onAdRenderFail("未指定广告容器", -1);
                    return;
                }
                Object obj = a.this.localParams.get(SplashAdLoader.KEY_SKIP_BUTTON);
                if (obj != null && (obj instanceof View)) {
                    view = (View) obj;
                    view.setVisibility(4);
                }
                a aVar2 = a.this;
                aVar2.b.a((com.meishu.sdk.meishu_ad.splash.d) aVar2.f5177a, aVar2.c, aVar2, view, zBooleanValue);
            } catch (Throwable th) {
                com.meishu.sdk.meishu_ad.splash.a aVar3 = a.this.c;
                if (aVar3 != null) {
                    ((g) aVar3).onAdRenderFail("加载异常", -1);
                }
                th.printStackTrace();
            }
        }
    }

    public a(SplashAdLoader splashAdLoader, com.meishu.sdk.meishu_ad.splash.d dVar) {
        super(splashAdLoader, dVar);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        SdkHandler.runOnMainThread(new C0853a());
    }

    @Override // com.meishu.sdk.platform.ms.g, com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        this.b = null;
        com.meishu.sdk.meishu_ad.splash.a aVar = this.c;
        if (aVar != null) {
            g gVar = (g) aVar;
            gVar.getClass();
            try {
                Gson gson = new Gson();
                HashMap map = new HashMap();
                map.put("stepNum", -1);
                map.put("msg", "destroy invoke");
                Integer numA = gVar.a();
                if (numA != null) {
                    map.put("creativeType", numA);
                }
                o1.a(gVar.f5245a, gson.toJson(map));
            } catch (Exception e) {
                e.printStackTrace();
            }
            gVar.c = null;
            gVar.i = null;
            gVar.b = null;
            this.c = null;
        }
    }
}
