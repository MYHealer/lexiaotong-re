package com.meishu.sdk.platform.ms.banner;

import android.text.TextUtils;
import android.view.View;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.platform.ms.d;

/* JADX INFO: compiled from: BannerAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements com.meishu.sdk.meishu_ad.banner.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.core.ad.banner.b f5161a;
    public b b;
    public volatile boolean c;
    public View d;

    /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.banner.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BannerAdListenerAdapter.java */
    public class C0847a extends l {
        public C0847a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            u0.a(((com.meishu.sdk.meishu_ad.banner.a) a.this.b.f5177a).getPosId(), 3);
            String[] monitorUrl = ((com.meishu.sdk.meishu_ad.banner.a) a.this.b.f5177a).getMonitorUrl();
            h0.a(monitorUrl, a.this.d, (View) null);
            if (monitorUrl != null) {
                LogUtil.d("BannerAdListenerAdapter", "send onAdExposure");
                for (String str : monitorUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        int act_type = ((com.meishu.sdk.meishu_ad.banner.a) a.this.b.f5177a).getAct_type();
                        if ((act_type & 2) == 2) {
                            act_type = (act_type - 2) | 1;
                        }
                        com.meishu.sdk.core.loader.a.a(a.this.b.getContext(), h0.a(h0.a(h0.a(str, act_type, AdType.BANNER), a.this.d.getWidth(), a.this.d.getHeight())));
                    }
                }
            }
            a.this.f5161a.onAdExposure();
            a.this.c = true;
        }
    }

    public a(b bVar, com.meishu.sdk.core.ad.banner.b bVar2) {
        this.b = bVar;
        this.f5161a = bVar2;
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADLoaded(c cVar) {
        c cVar2 = cVar;
        this.d = cVar2.getAdView();
        TouchAdContainer touchAdContainer = new TouchAdContainer(this.d.getContext());
        touchAdContainer.setTouchPositionListener(new TouchPositionListener(cVar2));
        touchAdContainer.addView(this.d);
        this.d = touchAdContainer;
        cVar2.setAdView(touchAdContainer);
        this.f5161a.onAdReady(cVar2);
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onAdRenderFail(String str, int i) {
        if (((com.meishu.sdk.meishu_ad.banner.a) this.b.f5177a).getErrorUrl() != null) {
            z.a(((com.meishu.sdk.meishu_ad.banner.a) this.b.f5177a).getErrorUrl()[0], Integer.valueOf(i), str);
        }
        com.meishu.sdk.core.ad.banner.b bVar = this.f5161a;
        if (bVar != null) {
            bVar.onAdPlatformError(new d(str, Integer.valueOf(i)));
            this.f5161a.onAdRenderFail(str, i);
        }
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADExposure() {
        View view;
        if (this.c || (view = this.d) == null) {
            return;
        }
        view.post(new C0847a());
    }
}
