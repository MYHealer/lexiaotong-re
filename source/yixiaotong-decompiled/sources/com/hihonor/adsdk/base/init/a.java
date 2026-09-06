package com.hihonor.adsdk.base.init;

import android.content.Context;
import android.view.View;
import com.hihonor.adsdk.base.callback.AppDownloadListener;
import com.hihonor.adsdk.base.j.n.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements HnAdManager {
    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void dismissInstallNotify() {
        com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsf();
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public int getAdCacheCount(String str) {
        return com.hihonor.adsdk.base.d.a.hnadsb().hnadsa(str);
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public String getSDKVersion() {
        return "1.0.24.300";
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void onAppBackground() {
        com.hihonor.adsdk.base.dialog.a.hnadsc().hnadse();
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void onAppForeground(View view) {
        com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsa(view);
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void registerNotifyListener(AppDownloadListener appDownloadListener) {
        com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsa(appDownloadListener);
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void requestPermissions(Context context) {
        com.hihonor.adsdk.base.permission.a.hnadsa().hnadsb(context);
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void setAppActivateStrategy(ActivateStyle activateStyle, int i) {
        com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsa(activateStyle, i);
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void startLocation() {
        j.hnadsb().hnadsf();
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void stopLocation(long j) {
        j.hnadsb().hnadsa(j);
    }

    @Override // com.hihonor.adsdk.base.init.HnAdManager
    public void unregisterNotifyListener(AppDownloadListener appDownloadListener) {
        com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsb(appDownloadListener);
    }
}
