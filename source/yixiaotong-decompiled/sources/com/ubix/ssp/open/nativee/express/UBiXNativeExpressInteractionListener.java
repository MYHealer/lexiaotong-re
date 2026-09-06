package com.ubix.ssp.open.nativee.express;

import android.view.View;
import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXNativeExpressInteractionListener {
    void onAdClicked(View view);

    void onAdClosed();

    void onAdExposeFailed(AdError adError);

    void onAdExposed();

    void onAdRenderFailed(AdError adError);

    void onAdRenderSucceed(View view);
}
