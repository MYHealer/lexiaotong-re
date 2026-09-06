package com.kwad.components.ad.interstitial.g;

import android.view.View;
import com.kwad.sdk.utils.cb;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends com.kwad.components.core.widget.a.a {
    private View mRootView;

    public b(View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean ah() {
        return cb.r(this.mRootView, 100);
    }
}
