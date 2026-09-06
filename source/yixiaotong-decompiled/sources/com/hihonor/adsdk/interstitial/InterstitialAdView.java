package com.hihonor.adsdk.interstitial;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.widget.base.BaseAdView;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class InterstitialAdView extends BaseAdView<BaseAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3524a = "InterstitialAdView";

    public InterstitialAdView(Context context) {
        this(context, null);
    }

    public void a(int i) {
        setTag(R.id.ad_common_click_type_tag, Integer.valueOf(i));
        triggerClick(this, 0);
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    protected void initView() {
    }

    void setAd(BaseAd baseAd) throws IllegalArgumentException {
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3524a, "setAd ad is null", new Object[0]);
            return;
        }
        int subType = baseAd.getSubType();
        if (e.a(subType)) {
            bindAd(baseAd);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(f3524a, "setAd but subType goto default : " + subType, new Object[0]);
        new s0(ErrorCode.AD_SUB_TYPE_DEFAULT, ErrorCode.REPORT_AD_SUB_TYPE_DEFAULT, baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).hnadse();
    }

    public InterstitialAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
