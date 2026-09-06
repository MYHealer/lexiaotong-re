package com.hihonor.adsdk.picturetextad;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.widget.base.BaseAdView;
import com.hihonor.adsdk.picturetextad.g.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class PictureTextAdView extends BaseAdView<BaseAd> {
    public PictureTextAdView(Context context) {
        this(context, null);
    }

    private boolean a(int i) {
        return i == 4 || i == 5 || i == 6 || i == 12 || i == 11 || i == 10;
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    protected void initView() {
    }

    void setAd(BaseAd baseAd) throws IllegalArgumentException {
        int subType = baseAd.getSubType();
        if (!a(subType)) {
            com.hihonor.adsdk.common.b.b.hnadsc("PictureTextAdView", "setAd but subType goto default : " + subType, new Object[0]);
            new s0(ErrorCode.AD_SUB_TYPE_DEFAULT, ErrorCode.REPORT_AD_SUB_TYPE_DEFAULT, baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).hnadse();
        }
        bindAd(baseAd);
        if (subType == 4) {
            setAdapter(new com.hihonor.adsdk.picturetextad.g.c(baseAd));
            return;
        }
        if (subType == 5) {
            setAdapter(new com.hihonor.adsdk.picturetextad.g.e(baseAd));
            return;
        }
        if (subType == 6) {
            setAdapter(new com.hihonor.adsdk.picturetextad.g.f(baseAd));
            return;
        }
        switch (subType) {
            case 10:
                setAdapter(new com.hihonor.adsdk.picturetextad.g.a(baseAd));
                break;
            case 11:
                setAdapter(new com.hihonor.adsdk.picturetextad.g.d(baseAd));
                break;
            case 12:
                setAdapter(new g(baseAd));
                break;
        }
    }

    public PictureTextAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureTextAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBackgroundResource(R.color.honor_ads_magic_card_bg);
    }
}
