package com.hihonor.adsdk.base.widget.download.d;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    public static a hnadsa(BaseAd baseAd, HnDownloadButton hnDownloadButton) {
        if (com.hihonor.adsdk.base.widget.download.c.hnadsb(baseAd)) {
            return new d(hnDownloadButton);
        }
        return com.hihonor.adsdk.base.widget.download.c.hnadsc(baseAd) ? new e(hnDownloadButton, com.hihonor.adsdk.base.widget.download.c.hnadsa(baseAd)) : new b(hnDownloadButton);
    }
}
