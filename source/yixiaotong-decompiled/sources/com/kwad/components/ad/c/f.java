package com.kwad.components.ad.c;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f extends com.kwad.components.core.widget.a.c {
    public f(View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.c, com.kwad.components.core.widget.a.a
    public final boolean ah() {
        com.kwad.sdk.core.c.b.LW();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.LW();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ah();
        }
        return super.ah();
    }
}
