package com.kwad.components.core.t;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class i implements View.OnClickListener {
    private j aly;

    public i() {
        this(false);
    }

    private i(boolean z) {
        this.aly = new j(false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.aly.a(view, this);
    }
}
