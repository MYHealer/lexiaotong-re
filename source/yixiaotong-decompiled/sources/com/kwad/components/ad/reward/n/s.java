package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class s extends d {
    protected ViewGroup wT;

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup ib() {
        return this.wT;
    }

    public final void a(ViewGroup viewGroup, int i, int i2) {
        if (this.wT != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.wT = (ViewGroup) viewStub.inflate();
        } else {
            this.wT = (ViewGroup) viewGroup.findViewById(i2);
        }
    }
}
