package com.hihonor.adsdk.base.download;

import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.f.b0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class o implements p {
    private static final String hnadsa = "SimpleStateChangeListener";

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsa(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "onStartInstallFail: " + i + ", " + str, new Object[0]);
        b0.hnadsb(R.string.ads_install_fail);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsb(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "onStartDownloadFail: " + i + ", " + str, new Object[0]);
        b0.hnadsb(R.string.ads_download_fail);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsc(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "onPauseFail: " + i + ", " + str, new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsd(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "onGetAppStatusFail: " + i + ", " + str, new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadse(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "onCancelFail: " + i + ", " + str, new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsa(g gVar) {
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "onStatusChange: adDIInfo is null", new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "status: %s, progress: %s, AppPackage: %s", Integer.valueOf(gVar.k()), Integer.valueOf(gVar.e()), gVar.hnadsd());
        }
    }
}
