package com.meishu.sdk.platform.ms.paster;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.paster.PasterAdLoader;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.m;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.meishu_ad.v;
import com.meishu.sdk.platform.ms.g;
import java.util.List;

/* JADX INFO: compiled from: MeishuPasterAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends g<f, PasterAdLoader, com.meishu.sdk.core.ad.paster.b> {
    public v b;
    public ViewGroup c;
    public boolean d;
    public boolean e;
    public com.meishu.sdk.core.ad.paster.a f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public com.meishu.sdk.meishu_ad.nativ.a l;

    /* JADX INFO: compiled from: MeishuPasterAdWrapper.java */
    public class a implements com.meishu.sdk.meishu_ad.nativ.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerAdMediaListener f5182a = new C0850a();

        /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.paster.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MeishuPasterAdWrapper.java */
        public class C0850a implements RecyclerAdMediaListener {
            public C0850a() {
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
            public void onProgressUpdate(long j, long j2) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
            public void onVideoCompleted() {
                d.this.c.setOnClickListener(null);
                if (((PasterAdLoader) d.this.getAdLoader()).getLoaderListener() != null) {
                    ((PasterAdLoader) d.this.getAdLoader()).getLoaderListener().onVideoComplete();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
            public void onVideoError() {
                d.this.c.setOnClickListener(null);
                if (((PasterAdLoader) d.this.getAdLoader()).getLoaderListener() != null) {
                    ((PasterAdLoader) d.this.getAdLoader()).getLoaderListener().onVideoError();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
            public void onVideoLoaded() {
                d dVar = d.this;
                if (dVar.e) {
                    return;
                }
                dVar.e = true;
                if (d.this.getLoaderListener() != 0) {
                    ((com.meishu.sdk.core.ad.paster.b) d.this.getLoaderListener()).onVideoLoaded();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
            public void onVideoPause() {
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
            public void onVideoResume() {
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
            public void onVideoStart() {
            }
        }

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.meishu_ad.m0
        public void onADLoaded(List<com.meishu.sdk.meishu_ad.nativ.b> list) {
            List<com.meishu.sdk.meishu_ad.nativ.b> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                if (((PasterAdLoader) d.this.getAdLoader()).getLoaderListener() != null) {
                    ((PasterAdLoader) d.this.getAdLoader()).getLoaderListener().onAdError();
                    return;
                }
                return;
            }
            com.meishu.sdk.meishu_ad.nativ.b bVar = list2.get(0);
            if (!(bVar.getMediaView() instanceof NormalMediaView)) {
                if (((PasterAdLoader) d.this.getAdLoader()).getLoaderListener() != null) {
                    ((PasterAdLoader) d.this.getAdLoader()).getLoaderListener().onAdError();
                    return;
                }
                return;
            }
            T t = d.this.f5177a;
            if (t == 0 || TextUtils.isEmpty(((f) t).g)) {
                if (((PasterAdLoader) d.this.getAdLoader()).getLoaderListener() != null) {
                    ((PasterAdLoader) d.this.getAdLoader()).getLoaderListener().onAdError();
                    return;
                }
                return;
            }
            ((NormalMediaView) bVar.getMediaView()).setAutoStart(false);
            d dVar = d.this;
            dVar.f = new com.meishu.sdk.core.ad.paster.a((f) dVar.f5177a);
            d.this.f.getClass();
            d.this.f.setAdView(bVar.getAdView());
            d.this.c.setOnClickListener(new com.meishu.sdk.platform.ms.paster.a(this, bVar));
            TouchAdContainer touchAdContainer = new TouchAdContainer(d.this.getContext());
            touchAdContainer.setTouchPositionListener(new TouchPositionListener(bVar));
            touchAdContainer.setOnTouchListener(new b(this));
            d.this.getContext();
            bVar.a(touchAdContainer, null, new com.meishu.sdk.platform.ms.recycler.b((f) d.this.f5177a, this.f5182a));
            touchAdContainer.setOnClickListener(new c(this, bVar));
            d.this.c.removeAllViews();
            d.this.c.addView(touchAdContainer);
            if (d.this.getLoaderListener() != 0) {
                ((com.meishu.sdk.core.ad.paster.b) d.this.getLoaderListener()).onAdLoaded(d.this.f);
                ((com.meishu.sdk.core.ad.paster.b) d.this.getLoaderListener()).onAdReady(d.this.f);
            }
        }

        @Override // com.meishu.sdk.meishu_ad.m0
        public void onADExposure() {
            d dVar = d.this;
            if (dVar.d) {
                return;
            }
            u0.a(((f) dVar.f5177a).getPosId(), 3);
            String[] monitorUrl = ((f) d.this.f5177a).getMonitorUrl();
            h0.a(monitorUrl, d.this.f.getAdView(), (View) null);
            if (monitorUrl != null) {
                LogUtil.d("MeishuPasterAdWrapper", "send onADExposure");
                for (String str : monitorUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        com.meishu.sdk.core.loader.a.a(d.this.getContext(), h0.a(h0.a(str, ((f) d.this.f5177a).getAct_type(), AdType.PASTER)));
                    }
                }
            }
            if (d.this.getLoaderListener() != 0) {
                ((com.meishu.sdk.core.ad.paster.b) d.this.getLoaderListener()).onAdExposure();
            }
            com.meishu.sdk.core.ad.paster.a aVar = d.this.f;
            if (aVar != null && aVar.getInteractionListener() != null) {
                d.this.f.getInteractionListener().onAdExposure();
            }
            d.this.d = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.meishu_ad.m0
        public void onAdRenderFail(String str, int i) {
            if (((f) d.this.f5177a).getErrorUrl() != null) {
                z.a(((f) d.this.f5177a).getErrorUrl()[0], Integer.valueOf(i), str);
            }
            if (((PasterAdLoader) d.this.getAdLoader()).getLoaderListener() != null) {
                ((com.meishu.sdk.core.ad.paster.b) d.this.getLoaderListener()).onAdPlatformError(new com.meishu.sdk.platform.ms.d(str, Integer.valueOf(i)));
                ((com.meishu.sdk.core.ad.paster.b) d.this.getLoaderListener()).onAdRenderFail(str, i);
            }
        }
    }

    public d(PasterAdLoader pasterAdLoader, f fVar, ViewGroup viewGroup) {
        super(pasterAdLoader, fVar);
        this.d = false;
        this.e = false;
        this.l = new a();
        this.b = new v(pasterAdLoader.getContext());
        this.c = viewGroup;
    }

    @Override // com.meishu.sdk.platform.ms.g, com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        LogUtil.e("MeishuPasterAdWrapper", "MeishuPasterAdWrapper.destroy");
        this.c.setOnClickListener(null);
        this.c.removeAllViews();
        this.c = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        this.b.a((f) this.f5177a, this.l, false, false, false, m.b(getContext(), ((PasterAdLoader) getAdLoader()).getAccept_ad_width().intValue()), m.b(getContext(), ((PasterAdLoader) getAdLoader()).getAccept_ad_height().intValue()));
    }
}
