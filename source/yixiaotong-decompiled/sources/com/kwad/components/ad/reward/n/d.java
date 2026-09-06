package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class d {
    protected void a(r rVar) {
    }

    protected void ad(boolean z) {
    }

    public abstract ViewGroup ib();

    public void onUnbind() {
    }

    public final void b(r rVar) {
        a(rVar);
        ib().getContext();
        ad(as.VM());
    }
}
