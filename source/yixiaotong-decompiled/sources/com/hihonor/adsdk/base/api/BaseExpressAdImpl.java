package com.hihonor.adsdk.base.api;

import android.view.View;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.callback.DislikeItemClickListener;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.k.c.c0;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.base.widget.base.BaseAdView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BaseExpressAdImpl extends BaseAdImpl implements BaseExpressAd {
    private static final String TAG = "BaseExpressAdImpl";
    protected BaseAdView hnadsg;
    protected int hnadsh;
    protected String hnadsi;
    protected long hnadsj;
    protected DislikeItemClickListener hnadsk;
    protected int hnadsl;

    public BaseExpressAdImpl(BaseAdView baseAdView, BaseAdInfo baseAdInfo) {
        super(baseAdInfo);
        this.hnadsl = -1;
        this.hnadsg = baseAdView;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public String getAdnId() {
        return this.hnadsi;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public String getAdnType() {
        return "0";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public long getEcpm() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getPrice();
        }
        return 0L;
    }

    public View getExpressAdView() {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "getExpressAdView", new Object[0]);
        BaseAdView baseAdView = this.hnadsg;
        if (baseAdView != null) {
            baseAdView.setDislikeItemClickListener(this.hnadsk);
        }
        return this.hnadsg;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public List<Integer> getIncentivePoints() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getIncentivePoints();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAdImpl, com.hihonor.adsdk.base.api.BaseAd
    public int getItemPosition() {
        return this.hnadsf;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public int getLevel() {
        return this.hnadsh;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public long getUseTime() {
        return this.hnadsj;
    }

    protected boolean hnadsb() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null && baseAdInfo.getIncentiveFlag() == 1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public boolean isDownload() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAdImpl, com.hihonor.adsdk.base.api.BaseAd
    public boolean isMediaUseCustomVideo() {
        return false;
    }

    public void release() {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "--------------------- release", new Object[0]);
        BaseAdView baseAdView = this.hnadsg;
        if (baseAdView != null) {
            baseAdView.release();
        }
        if (this.hnadse != null) {
            this.hnadse = null;
        }
        if (this.hnadsk != null) {
            this.hnadsk = null;
        }
        if (getPromotionPurpose() == 0) {
            com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsb(getAppPackage(), getRequestId());
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void sendLossNotification(long j, int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsa(TAG, (Object) ("sendLossNotification price：" + j + "  reason:" + i + " adnId:" + str));
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo == null || baseAdInfo.getTrackUrl() == null || this.hnadsd.getTrackUrl().getComparePrices() == null) {
            return;
        }
        new c0(j, 0).hnadsc(this.hnadsd.getAdId(), this.hnadsd.getAdUnitId(), this.hnadsd.getAdRequestId(), this.hnadsd.getTrackUrl().getComparePrices());
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void sendWinNotification(long j) {
        com.hihonor.adsdk.common.b.b.hnadsa(TAG, (Object) "sendWinNotification");
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo == null || baseAdInfo.getTrackUrl() == null || this.hnadsd.getTrackUrl().getComparePrices() == null) {
            return;
        }
        new c0(j, 1).hnadsc(this.hnadsd.getAdId(), this.hnadsd.getAdUnitId(), this.hnadsd.getAdRequestId(), this.hnadsd.getTrackUrl().getComparePrices());
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setAdnId(String str) {
        this.hnadsi = str;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAdImpl, com.hihonor.adsdk.base.api.BaseExpressAd
    public void setItemPosition(int i) {
        super.setItemPosition(i);
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setLevel(int i) {
        this.hnadsh = i;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setRenderType(int i) {
        if (this.hnadsl == -1) {
            this.hnadsl = i;
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setUseTime(long j) {
        this.hnadsj = j;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void unUseAd(int i, String str) {
        String str2 = String.format("reasonCode=%s, unUse  Ad reason=%s", Integer.valueOf(i), str);
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "call unUseNativeAd errorMsg is %s", str2);
        new t(ErrorCode.MEDIA_UN_USE_AD, str2).hnadsa(this, getTrackUrl().getCommons());
        new s0(ErrorCode.MEDIA_UN_USE_AD, str2, getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this)).hnadsa("code", String.valueOf(i)).hnadse();
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setDislikeClickListener(DislikeItemClickListener dislikeItemClickListener) {
        this.hnadsk = dislikeItemClickListener;
        BaseAdView baseAdView = this.hnadsg;
        if (baseAdView != null) {
            baseAdView.setDislikeItemClickListener(dislikeItemClickListener);
        }
    }
}
