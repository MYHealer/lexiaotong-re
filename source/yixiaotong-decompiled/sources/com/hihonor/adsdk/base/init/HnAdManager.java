package com.hihonor.adsdk.base.init;

import android.content.Context;
import android.view.View;
import com.hihonor.adsdk.base.callback.AppDownloadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface HnAdManager {
    void dismissInstallNotify();

    int getAdCacheCount(String str);

    String getSDKVersion();

    void onAppBackground();

    void onAppForeground(View view);

    void registerNotifyListener(AppDownloadListener appDownloadListener);

    void requestPermissions(Context context);

    void setAppActivateStrategy(ActivateStyle activateStyle, int i);

    void startLocation();

    void stopLocation(long j);

    void unregisterNotifyListener(AppDownloadListener appDownloadListener);
}
