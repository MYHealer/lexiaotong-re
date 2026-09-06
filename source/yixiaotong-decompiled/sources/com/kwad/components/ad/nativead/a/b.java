package com.kwad.components.ad.nativead.a;

import com.kwad.components.core.e.d.d;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public d mApkDownloadHelper;
    public com.kwad.components.ad.nativead.d.a pD;
    public AdBasePvFrameLayout pR;
    public com.kwad.components.ad.nativead.d.a pX;
    public KsNativeAd.VideoPlayListener pv;
    public boolean qc = false;
    public boolean qd = false;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.clear();
        }
        this.pX.release();
    }
}
