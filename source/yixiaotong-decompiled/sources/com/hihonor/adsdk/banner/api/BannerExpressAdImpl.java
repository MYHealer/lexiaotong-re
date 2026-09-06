package com.hihonor.adsdk.banner.api;

import android.view.View;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseExpressAdImpl;
import com.hihonor.adsdk.base.api.banner.BannerExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.widget.base.BaseAdView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BannerExpressAdImpl extends BaseExpressAdImpl implements BannerExpressAd {
    private static final String LOG_TAG = "BannerExpressAdImpl";
    private static final long MAX_INTERVAL_TIME = 120000;
    private static final long MIN_INTERVAL_TIME = 30000;
    private int mHeight;
    private long mIntervalTime;
    private int mWidth;

    public BannerExpressAdImpl(BaseAdInfo baseAdInfo) {
        this(null, baseAdInfo);
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAdImpl, com.hihonor.adsdk.base.api.BaseExpressAd
    public View getExpressAdView() {
        if (this.hnadsg == null && this.hnadsl == 0) {
            BannerView bannerView = new BannerView(HnAds.get().getContext());
            bannerView.a(this.mWidth, this.mHeight);
            bannerView.bindAd(this);
            bannerView.setIntervalTime(this.mIntervalTime);
            this.hnadsg = bannerView;
        }
        return super.getExpressAdView();
    }

    @Override // com.hihonor.adsdk.base.api.banner.BannerExpressAd
    public void refresh() {
        BaseAdView baseAdView = this.hnadsg;
        if (baseAdView instanceof BannerView) {
            ((BannerView) baseAdView).bindAd(this);
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAdImpl, com.hihonor.adsdk.base.api.BaseExpressAd
    public void release() {
        super.release();
        c.a().b(getAdUnitId(), this);
    }

    @Override // com.hihonor.adsdk.base.api.banner.BannerExpressAd
    public void setBaseAdInfo(BaseAdInfo baseAdInfo) {
        this.hnadsd = baseAdInfo;
    }

    @Override // com.hihonor.adsdk.base.api.banner.BannerExpressAd
    public void setHeight(int i) {
        this.mHeight = i;
    }

    @Override // com.hihonor.adsdk.base.api.banner.BannerExpressAd
    public void setWidth(int i) {
        this.mWidth = i;
    }

    public BannerExpressAdImpl(BaseAdView baseAdView, BaseAdInfo baseAdInfo) {
        super(baseAdView, baseAdInfo);
    }

    @Override // com.hihonor.adsdk.base.api.banner.BannerExpressAd
    public void setIntervalTime(long j) {
        if (j <= 0) {
            this.mIntervalTime = 0L;
        } else {
            this.mIntervalTime = Math.min(Math.max(j, MIN_INTERVAL_TIME), MAX_INTERVAL_TIME);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "intervalTime:" + j + ";mIntervalTime:" + this.mIntervalTime, new Object[0]);
        BaseAdView baseAdView = this.hnadsg;
        if (baseAdView instanceof BannerView) {
            ((BannerView) baseAdView).setIntervalTime(this.mIntervalTime);
        }
    }
}
