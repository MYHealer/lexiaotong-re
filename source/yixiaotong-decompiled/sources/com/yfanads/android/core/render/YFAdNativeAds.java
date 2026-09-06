package com.yfanads.android.core.render;

import android.app.Activity;
import android.content.Context;
import com.yfanads.android.core.i;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.model.YFAdType;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdNativeAds extends i implements YFNativeSetting {
    private static final int MAX_NUMBER = 5;
    private int adsNumbers;
    private YFNativeListener listener;

    public YFAdNativeAds(Context context, YFNativeListener yFNativeListener) {
        super(context, yFNativeListener);
        this.adsNumbers = 1;
        setAdType(YFAdType.CUSTOM);
        this.listener = yFNativeListener;
    }

    @Override // com.yfanads.android.core.i, com.yfanads.android.callback.AdCoreAction
    public void destroy() {
        super.destroy();
        if (this.listener != null) {
            this.listener = null;
        }
    }

    @Override // com.yfanads.android.core.i
    public int getAType() {
        return 2;
    }

    @Override // com.yfanads.android.core.render.YFNativeSetting
    public int getAdsNumbers() {
        return Math.min(this.adsNumbers, 5);
    }

    public void setAdsNumbers(int i) {
        this.adsNumbers = i;
    }

    @Override // com.yfanads.android.core.i
    public void showAds(Activity activity) {
        super.showAds(activity);
    }

    @Override // com.yfanads.android.core.render.YFNativeSetting
    public void onAdSuccess(List<YFNativeAd> list) {
        YFNativeListener yFNativeListener = this.listener;
        if (yFNativeListener != null) {
            yFNativeListener.onAdSuccess(list);
        }
    }
}
