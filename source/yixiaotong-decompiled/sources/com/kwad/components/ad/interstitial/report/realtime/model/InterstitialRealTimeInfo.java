package com.kwad.components.ad.interstitial.report.realtime.model;

import com.kwad.sdk.commercial.c.a;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class InterstitialRealTimeInfo extends a implements Serializable {
    public String materialUrl;
    public long monitorIndex;
    public long renderType;

    public void setMaterialUrl(String str) {
        this.materialUrl = str;
    }

    public void setRenderType(long j) {
        this.renderType = j;
    }
}
