package com.hihonor.adsdk.base.widget.download;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsk = "HnAppearanceText";
    private CharSequence hnadsa;
    private CharSequence hnadsb;
    private CharSequence hnadsc;
    private CharSequence hnadsd;
    private CharSequence hnadse;
    private CharSequence hnadsf;
    private CharSequence hnadsg;
    private CharSequence hnadsh;
    private CharSequence hnadsi;
    private int hnadsj;

    public a(HnDownloadButton hnDownloadButton, Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HnDownloadButton, i, 0);
        this.hnadse = hnadsa(context, typedArrayObtainStyledAttributes, R.styleable.HnDownloadButton_hn_ads_text_view, R.string.ads_click_view);
        this.hnadsf = hnadsa(context, typedArrayObtainStyledAttributes, R.styleable.HnDownloadButton_hn_ads_text_recover, R.string.ads_download_button_recover);
        this.hnadsg = hnadsa(context, typedArrayObtainStyledAttributes, R.styleable.HnDownloadButton_hn_ads_text_try_again, R.string.ads_try_again);
        this.hnadsh = hnadsa(context, typedArrayObtainStyledAttributes, R.styleable.HnDownloadButton_hn_ads_text_wait, R.string.ads_wait);
        this.hnadsi = hnadsa(context, typedArrayObtainStyledAttributes, R.styleable.HnDownloadButton_hn_ads_text_reserve, R.string.ads_reserve);
        this.hnadsj = hnadsa(typedArrayObtainStyledAttributes, R.styleable.HnDownloadButton_hn_ad_download_type, 0);
        typedArrayObtainStyledAttributes.recycle();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsk, "initData viewText=%s,recoverText=%s,tryAgainText=%s,waitText=%s", this.hnadse, this.hnadsf, this.hnadsg, this.hnadsh);
        hnadsb(hnDownloadButton);
    }

    private void hnadsb(HnDownloadButton hnDownloadButton) {
        this.hnadsa = hnDownloadButton.getIdleText();
        this.hnadsb = hnDownloadButton.getPauseText();
        this.hnadsc = hnDownloadButton.getInstallText();
        this.hnadsd = hnDownloadButton.getDoneText();
    }

    public int hnadsa() {
        return this.hnadsj;
    }

    public void hnadsa(int i) {
        this.hnadsj = i;
    }

    public String toString() {
        return "HnAppearanceText{mIdleText=" + ((Object) this.hnadsa) + ", mPauseText=" + ((Object) this.hnadsb) + ", mInstallText=" + ((Object) this.hnadsc) + ", mDoneText=" + ((Object) this.hnadsd) + ", mViewText=" + ((Object) this.hnadse) + ", mRecoverText=" + ((Object) this.hnadsf) + ", mTryAgainText=" + ((Object) this.hnadsg) + ", mWaitText=" + ((Object) this.hnadsh) + '}';
    }

    private int hnadsa(TypedArray typedArray, int i, int i2) {
        try {
            return typedArray.getInt(i, i2);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsk, "Resource not found in initialize." + e.getMessage(), new Object[0]);
            return i2;
        }
    }

    private CharSequence hnadsa(Context context, TypedArray typedArray, int i, int i2) {
        String string;
        try {
            string = typedArray.getString(i);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsk, "Resource not found in initialize." + e.getMessage(), new Object[0]);
            string = null;
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return context.getResources().getString(i2);
        } catch (Resources.NotFoundException e2) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsk, "default resource not found in initialize." + e2.getMessage(), new Object[0]);
            return string;
        }
    }

    public void hnadsa(HnDownloadButton hnDownloadButton) {
        hnDownloadButton.setIdleText(this.hnadsa);
        hnDownloadButton.setPauseText(this.hnadsb);
        hnDownloadButton.setInstallText(this.hnadsc);
        hnDownloadButton.setDoneText(this.hnadsd);
        hnDownloadButton.setViewText(this.hnadse);
        hnDownloadButton.setRecoverText(this.hnadsf);
        hnDownloadButton.setReserveText(this.hnadsi);
        hnDownloadButton.setTryAgainText(this.hnadsg);
        hnDownloadButton.setWaitText(this.hnadsh);
    }
}
