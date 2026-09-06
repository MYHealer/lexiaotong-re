package com.hihonor.adsdk.base.widget.b;

import android.text.TextUtils;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements c {
    private static final String hnadsb = "ReserveStateChangeListener";
    private final WeakReference<HnDownloadButton> hnadsa;

    public a(HnDownloadButton hnDownloadButton) {
        this.hnadsa = new WeakReference<>(hnDownloadButton);
    }

    private HnDownloadButton hnadsa() {
        return this.hnadsa.get();
    }

    @Override // com.hihonor.adsdk.base.widget.b.c
    public void hnadsa(int i, String str) {
        HnDownloadButton hnDownloadButtonHnadsa = hnadsa();
        if (hnDownloadButtonHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "onStatusChange: downloadButton is null", new Object[0]);
            return;
        }
        String appPackageName = hnDownloadButtonHnadsa.getAppPackageName();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "onStatusChange#status: " + i + ",appPackageName: " + str + ",appPackage: " + appPackageName, new Object[0]);
        if (TextUtils.equals(appPackageName, str)) {
            if (i == 5) {
                hnDownloadButtonHnadsa.onReserveSuccess();
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "status: " + i, new Object[0]);
            }
        }
    }
}
