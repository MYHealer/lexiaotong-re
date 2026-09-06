package com.kwad.components.core.e.c;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d extends com.kwad.sdk.mvp.a {
    public b Qv;
    public b.C0660b Qw;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.d mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.clear();
        }
    }
}
