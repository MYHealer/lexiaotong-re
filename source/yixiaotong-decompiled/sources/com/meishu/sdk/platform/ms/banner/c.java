package com.meishu.sdk.platform.ms.banner;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.banner.IBannerAd;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.z;
import java.util.Map;

/* JADX INFO: compiled from: MsBannerAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends com.meishu.sdk.platform.ms.b implements IBannerAd {
    public com.meishu.sdk.meishu_ad.banner.a b;
    public Activity c;
    public ViewGroup d;

    public c(com.meishu.sdk.meishu_ad.banner.a aVar) {
        super(aVar);
        this.b = aVar;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public AdType getAdType() {
        return AdType.BANNER;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCid(this.b.getCid());
        resultBean.setCat(this.b.getCat());
        resultBean.setAderId(this.b.getAder_id());
        resultBean.setFromId(this.b.getFromId());
        resultBean.setDrawing(this.b.getDrawing());
        resultBean.setPid(this.b.getPosId());
        resultBean.setReqId(this.b.getReq_id());
        resultBean.setPrice(this.b.getEcpm());
        resultBean.setEcpm(String.valueOf(this.b.getEcpm()));
        resultBean.setS_code(this.b.getS_code());
        resultBean.setS_ext(this.b.getS_ext());
        resultBean.setSdkName("MS");
        resultBean.setAdInfo(com.meishu.sdk.core.utils.a.a((BaseAdSlot) this.b));
        return resultBean;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = this.b.getExpire_timestamp();
            return SystemClock.uptimeMillis() - this.b.getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        z.a(getContext(), this.b.getLossUrl(), (Map<String, Object>) map);
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        z.b(getContext(), this.b.getWinUrl(), map);
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void setCloseButtonVisible(boolean z) {
        this.adView.findViewById(R.id.ms_banner_close_button).setVisibility(z ? 0 : 4);
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        super.setInteractionListener(interactionListener);
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void setWidthAndHeight(int i, int i2) {
        if (i2 == 0) {
            return;
        }
        ImageView imageView = (ImageView) this.adView.findViewById(R.id.ms_banner_image);
        imageView.getLayoutParams().width = i;
        imageView.getLayoutParams().height = i2;
        imageView.getParent().requestLayout();
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        View view = this.adView;
        if (view == null) {
            return;
        }
        this.d = viewGroup;
        if (viewGroup == null || view.getParent() != null) {
            return;
        }
        viewGroup.addView(this.adView);
        o1.a(viewGroup, this.b.getPosId(), this.b.getLoadedTime());
        o1.b(this.b.getEventUrl());
    }

    @Override // com.meishu.sdk.platform.ms.c
    public Context getContext() {
        Activity activity = this.c;
        if (activity != null) {
            return activity;
        }
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            return viewGroup.getContext();
        }
        return this.adView.getContext();
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        View view = this.adView;
        if (view == null) {
            return;
        }
        this.c = activity;
        this.d = viewGroup;
        if (viewGroup == null || view.getParent() != null) {
            return;
        }
        viewGroup.addView(this.adView);
        o1.a(viewGroup, this.b.getPosId(), this.b.getLoadedTime());
        o1.b(this.b.getEventUrl());
    }
}
