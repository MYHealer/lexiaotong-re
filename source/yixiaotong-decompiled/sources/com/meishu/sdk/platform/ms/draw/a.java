package com.meishu.sdk.platform.ms.draw;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.draw.DrawAd;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import java.util.Map;

/* JADX INFO: compiled from: MeishuDrawAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends DrawAd implements com.meishu.sdk.platform.ms.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdSlot f5163a;
    public View b;
    public ViewGroup c;

    public a(AdSlot adSlot, View view) {
        super(null, "MS");
        this.f5163a = adSlot;
        this.b = view;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public AdSlot a() {
        return this.f5163a;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void destroy() {
        View view = this.b;
        if (view == null || !(view instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) view).d();
    }

    @Override // com.meishu.sdk.platform.ms.c
    public AdType getAdType() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        AdSlot adSlot = this.f5163a;
        if (adSlot instanceof com.meishu.sdk.meishu_ad.nativ.f) {
            resultBean.setCid(((com.meishu.sdk.meishu_ad.nativ.f) adSlot).getCid());
            resultBean.setCat(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getCat());
            resultBean.setAderId(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getAder_id());
            resultBean.setFromId(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getFromId());
            resultBean.setDrawing(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getDrawing());
            resultBean.setPid(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getPosId());
            resultBean.setReqId(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getReq_id());
            resultBean.setPrice(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getEcpm());
            resultBean.setEcpm(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getEcpm() + "");
            resultBean.setS_code(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getS_code());
            resultBean.setS_ext(((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getS_ext());
            resultBean.setSdkName("MS");
            resultBean.setAdInfo(com.meishu.sdk.core.utils.a.a((BaseAdSlot) this.f5163a));
        }
        return resultBean;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public int getDrawType() {
        return 2;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public int getInteractionType() {
        return this.f5163a.getInteractionType();
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = ((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getExpire_timestamp();
            return SystemClock.uptimeMillis() - ((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void pause() {
        super.pause();
        View view = this.b;
        if (view == null || !(view instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) view).pause();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void resume() {
        super.resume();
        View view = this.b;
        if (view != null && (view instanceof NormalMediaView) && view.getVisibility() == 0) {
            ((NormalMediaView) this.b).resume();
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        z.a(getContext(), ((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getLossUrl(), (Map<String, Object>) map);
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        z.b(getContext(), ((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getWinUrl(), map);
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void setVideoMute(boolean z) {
        View view = this.b;
        if (view == null || !(view instanceof NormalMediaView)) {
            return;
        }
        if (z) {
            ((NormalMediaView) view).g();
        } else {
            ((NormalMediaView) view).j();
        }
    }

    @Override // com.meishu.sdk.platform.ms.c
    public Context getContext() {
        ViewGroup viewGroup = this.c;
        return viewGroup != null ? viewGroup.getContext() : this.b.getContext();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        this.c = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            viewGroup.addView(adView);
        }
        View view = this.b;
        if (view != null && (view instanceof NormalMediaView)) {
            ((NormalMediaView) view).start();
        }
        super.showAd(activity, viewGroup);
        o1.a(viewGroup, ((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getPosId(), ((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getLoadedTime());
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(ViewGroup viewGroup) {
        this.c = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            viewGroup.addView(adView);
        }
        View view = this.b;
        if (view != null && (view instanceof NormalMediaView)) {
            ((NormalMediaView) view).start();
        }
        AdSlot adSlot = this.f5163a;
        if (adSlot instanceof BaseAdSlot) {
            o1.b(((BaseAdSlot) adSlot).getEventUrl());
        }
        o1.a(viewGroup, ((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getPosId(), ((com.meishu.sdk.meishu_ad.nativ.f) this.f5163a).getLoadedTime());
    }
}
