package com.ubix.ssp.open.nativee.express;

import android.view.View;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface NativeExpressAd {
    void destroy();

    @Deprecated
    int getAdType();

    int getCreativeType();

    View getNativeExpressView();

    ParamsReview getParamsReview();

    long getPrice();

    long getVideoDuration();

    boolean isValid();

    boolean isVideoAd();

    void lossNotice(UBiXAdLossInfo uBiXAdLossInfo);

    void renderExpressNativeAd(UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener);

    void setNativeExpressVideoListener(UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener);

    void winNotice(long j);
}
