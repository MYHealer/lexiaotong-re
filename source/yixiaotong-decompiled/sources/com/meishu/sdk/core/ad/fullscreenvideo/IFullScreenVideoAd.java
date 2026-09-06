package com.meishu.sdk.core.ad.fullscreenvideo;

import android.app.Activity;
import com.meishu.sdk.core.ad.IAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IFullScreenVideoAd extends IAd {
    void setMediaListener(IFullScreenMediaListener iFullScreenMediaListener);

    void showAd();

    void showAd(Activity activity);
}
