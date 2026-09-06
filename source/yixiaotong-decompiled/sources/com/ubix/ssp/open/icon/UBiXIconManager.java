package com.ubix.ssp.open.icon;

import android.content.Context;
import android.view.View;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXIconManager {
    void destroy();

    String getBiddingToken();

    View getIconView();

    ParamsReview getParamsReview();

    long getPrice();

    boolean isValid();

    void loadAd();

    void loadBiddingAd(String str);

    void loadIconAd(Context context, String str, AdSize adSize, UBiXIconAdListener uBiXIconAdListener);

    void lossNotice(UBiXAdLossInfo uBiXAdLossInfo);

    void winNotice(long j);
}
