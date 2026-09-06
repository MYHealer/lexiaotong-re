package com.meishu.sdk.platform.gdt.banner;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.banner.a;
import com.meishu.sdk.core.utils.o1;
import com.qq.e.ads.banner2.UnifiedBannerView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTBannerAd extends a {
    private static final String TAG = "GDTBannerAd";
    private GDTViewWrapper adWrapper;
    private UnifiedBannerView gdtBannerView;

    public GDTBannerAd(GDTViewWrapper gDTViewWrapper, UnifiedBannerView unifiedBannerView) {
        super(gDTViewWrapper, MSAdConfig.PLATFORM_GDT);
        this.adWrapper = gDTViewWrapper;
        this.gdtBannerView = unifiedBannerView;
    }

    @Override // com.meishu.sdk.core.ad.a
    public Object getSdkAd() {
        return this.gdtBannerView;
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        try {
            View view = this.adView;
            if (view == null) {
                return;
            }
            if (view.getParent() != null && (this.adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.adView.getParent()).removeView(this.adView);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.adView, new ViewGroup.LayoutParams(-1, Math.round(this.adView.getContext().getResources().getDisplayMetrics().widthPixels / 6.4f)));
                o1.a(viewGroup, this.adWrapper.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd(viewGroup);
    }

    @Override // com.meishu.sdk.core.ad.banner.a, com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        try {
            View view = this.adView;
            if (view == null) {
                return;
            }
            if (view.getParent() != null && (this.adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.adView.getParent()).removeView(this.adView);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.adView, new ViewGroup.LayoutParams(-1, Math.round(this.adView.getContext().getResources().getDisplayMetrics().widthPixels / 6.4f)));
                o1.a(viewGroup, this.adWrapper.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
            }
            super.showAd(viewGroup);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
