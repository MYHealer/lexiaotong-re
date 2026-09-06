package com.meishu.sdk.core.ad.splash;

import android.view.ViewGroup;
import com.meishu.sdk.core.ad.IAd;
import com.meishu.sdk.core.loader.InteractionListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ISplashAd<T extends InteractionListener> extends IAd<T> {
    void setDownloadDialogListener(a aVar);

    void setSplashFinishingTouchListener(b bVar);

    void showAd(ViewGroup viewGroup);

    void splashAnimationFinish();
}
