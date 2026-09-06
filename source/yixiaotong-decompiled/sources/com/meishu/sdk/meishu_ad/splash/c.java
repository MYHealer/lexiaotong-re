package com.meishu.sdk.meishu_ad.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.p;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.qq.e.comm.pi.IReward;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SplashAdImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends com.meishu.sdk.core.ad.splash.c implements com.meishu.sdk.meishu_ad.splash.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.platform.ms.splash.a f5082a;
    public d b;
    public SplashSkipView c;
    public NormalMediaView d;
    public MeishuSplashRootView e;
    public boolean f;
    public boolean g;
    public boolean h;
    public List<b> i;

    /* JADX INFO: compiled from: SplashAdImpl.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            SplashSkipView splashSkipView = c.this.c;
            if (splashSkipView != null) {
                splashSkipView.c();
            }
        }
    }

    /* JADX INFO: compiled from: SplashAdImpl.java */
    public interface b {
        void a(ViewGroup viewGroup);
    }

    public c(d dVar, com.meishu.sdk.platform.ms.splash.a aVar, boolean z) {
        super(null, "MS");
        this.i = new ArrayList();
        this.b = dVar;
        this.f5082a = aVar;
    }

    @Override // com.meishu.sdk.meishu_ad.splash.b, com.meishu.sdk.platform.ms.c
    public AdSlot a() {
        return this.b;
    }

    public void b() {
        if (this.adContainer == null) {
            SdkHandler.getInstance().runOnUiThread(new p(this.b.getErrorUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "开屏容器为空"));
        }
        if (this.f || this.adContainer == null) {
            try {
                o1.b(this.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_INTERRUPTED, "广告重复展示");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        View view = this.adView;
        if (view != null && view.getParent() != null && (this.adView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.adView.getParent()).removeView(this.adView);
        }
        this.adContainer.addView(this.adView);
        this.e.setVisibility(0);
        try {
            Gson gson = new Gson();
            HashMap map = new HashMap();
            map.put("stepNum", 5);
            map.put("msg", "attach to the container");
            map.put("creativeType", Integer.valueOf(this.b.getAdPatternType()));
            if (this.adView != null) {
                map.put(IReward.AD_VIEW, 1);
            } else {
                map.put(IReward.AD_VIEW, 0);
            }
            o1.a(this.b.getErrorUrl(), gson.toJson(map));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.e.post(new a());
        this.f = true;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public AdType getAdType() {
        return AdType.SPLASH;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public Context getContext() {
        return this.adView.getContext();
    }

    @Override // com.meishu.sdk.platform.ms.c
    public int getInteractionType() {
        return this.b.getInteractionType();
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public void setAdView(View view) {
        this.adView = view;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        setAdContainer(viewGroup);
        LogUtil.d("c", "开屏容器 width=" + viewGroup.getWidth() + ",开屏容器 height=" + viewGroup.getHeight());
        List<b> list = this.i;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<b> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().a(viewGroup);
        }
        this.i.clear();
    }
}
