package com.meishu.sdk.core.ad.banner;

import android.app.Activity;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.IAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IBannerAd extends IAd {
    void setCloseButtonVisible(boolean z);

    void setWidthAndHeight(int i, int i2);

    void showAd(Activity activity, ViewGroup viewGroup);

    void showAd(ViewGroup viewGroup);
}
