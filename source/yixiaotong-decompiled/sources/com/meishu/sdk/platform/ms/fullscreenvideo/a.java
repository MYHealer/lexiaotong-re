package com.meishu.sdk.platform.ms.fullscreenvideo;

import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.c;
import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.meishu_ad.v;
import com.meishu.sdk.platform.ms.g;

/* JADX INFO: compiled from: MeishuFullScreenVideoAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends g<f, FullScreenVideoAdLoader, c> {
    public v b;

    /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.fullscreenvideo.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MeishuFullScreenVideoAdWrapper.java */
    public class C0849a extends com.meishu.sdk.platform.ms.reward.a {
        public C0849a(a aVar, g gVar, IAdLoadListener iAdLoadListener, f fVar) {
            super(gVar, iAdLoadListener, fVar);
        }
    }

    public a(FullScreenVideoAdLoader fullScreenVideoAdLoader, f fVar) {
        super(fullScreenVideoAdLoader, fVar);
        this.b = new v(fullScreenVideoAdLoader.getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.meishu.sdk.core.loader.IAdLoadListener] */
    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        if (getLoaderListener() != 0) {
            ((c) getLoaderListener()).onAdLoaded(null);
        }
        ?? loaderListener = getLoaderListener();
        f fVar = (f) this.f5177a;
        C0849a c0849a = new C0849a(this, this, loaderListener, fVar);
        v vVar = this.b;
        FullScreenVideoAdLoader fullScreenVideoAdLoader = (FullScreenVideoAdLoader) getAdLoader();
        vVar.getClass();
        try {
            vVar.d = fVar.getEventUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        vVar.a(fVar, c0849a, fullScreenVideoAdLoader);
    }
}
