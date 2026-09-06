package com.ubix.ssp.open.banner;

import android.content.Context;
import android.view.View;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXBannerManager extends Serializable {
    void destroy();

    View getBannerView();

    ParamsReview getParamsReview();

    long getPrice();

    boolean isValid();

    void loadAd();

    @Deprecated
    void loadAd(int i);

    void loadBannerAd(Context context, String str, AdSize adSize, UBiXBannerAdListener uBiXBannerAdListener);

    void loadBannerAd(Context context, String str, UBiXBannerAdListener uBiXBannerAdListener);

    void lossNotice(UBiXAdLossInfo uBiXAdLossInfo);

    void winNotice(long j);
}
