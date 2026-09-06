package com.hihonor.adsdk.base.widget.download;

import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.download.p;
import com.hihonor.adsdk.common.f.b0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b implements p {
    private static final String hnadsb = "HnDownloadButtonStateChangeListener";
    WeakReference<HnDownloadButton> hnadsa;

    public b(HnDownloadButton hnDownloadButton) {
        this.hnadsa = new WeakReference<>(hnDownloadButton);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsb(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "StateChangeCallback onStartDownloadFail: " + i + ", " + str, new Object[0]);
        b0.hnadsb(R.string.ads_download_fail);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsc(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "onPauseFail: " + i + ", " + str, new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsd(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "onGetAppStatusFail: " + i + ", " + str, new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadse(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "onCancelFail: " + i + ", " + str, new Object[0]);
    }

    private HnDownloadButton hnadsa() {
        WeakReference<HnDownloadButton> weakReference = this.hnadsa;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsa(int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "StateChangeCallback onStartInstallFail: " + i + ", " + str, new Object[0]);
        b0.hnadsb(R.string.ads_install_fail);
    }

    @Override // com.hihonor.adsdk.base.download.p
    public void hnadsa(g gVar) {
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "onStatusChange: adDIInfo is null", new Object[0]);
            return;
        }
        HnDownloadButton hnDownloadButtonHnadsa = hnadsa();
        if (hnDownloadButtonHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "onStatusChange: downloadButton is null", new Object[0]);
            return;
        }
        int iE = gVar.e();
        int iK = gVar.k();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "adDIInfo status: %s, progress: %s, AppPackage: %s", Integer.valueOf(iK), Integer.valueOf(iE), gVar.hnadsd());
        if (iK != -1) {
            if (iK != 2100) {
                switch (iK) {
                    case 2003:
                        hnDownloadButtonHnadsa.onStartOrContinueDownLoad();
                        break;
                    case 2004:
                        hnDownloadButtonHnadsa.onDownloading(iE);
                        break;
                    case 2005:
                        hnDownloadButtonHnadsa.onDownloadSuccess();
                        hnDownloadButtonHnadsa.onInstalling();
                        break;
                    case 2006:
                        hnDownloadButtonHnadsa.onDownloadFail(gVar);
                        break;
                    case 2007:
                        hnDownloadButtonHnadsa.onDownloadPaused(iE);
                        break;
                    case 2008:
                        break;
                    case 2009:
                        hnDownloadButtonHnadsa.onDownloadWait(iE);
                        break;
                    default:
                        switch (iK) {
                            case 2011:
                                hnDownloadButtonHnadsa.onInstalling();
                                break;
                            case 2013:
                                hnDownloadButtonHnadsa.onInstallFail();
                                break;
                        }
                        break;
                }
                return;
            }
            hnDownloadButtonHnadsa.onInstallSuccess();
            return;
        }
        hnDownloadButtonHnadsa.onStatusNone();
    }
}
