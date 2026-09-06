package com.jd.ad.sdk.splash;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADSplashListener {
    void onClick();

    void onClose();

    void onExposure();

    void onLoadFailure(int i, String str);

    void onLoadSuccess();

    void onRenderFailure(int i, String str);

    void onRenderSuccess(View view);
}
