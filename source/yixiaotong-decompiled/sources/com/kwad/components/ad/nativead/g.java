package com.kwad.components.ad.nativead;

import android.view.View;
import com.kwad.sdk.utils.cb;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g extends com.kwad.components.core.widget.a.c {
    private final View mRootView;

    public g(View view) {
        this(view, fD());
    }

    private g(View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    private static int fD() {
        try {
            int iKd = ((int) com.kwad.sdk.core.config.e.Kd()) * 100;
            if (iKd < 0 || iKd > 100) {
                return 30;
            }
            return iKd;
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.widget.a.c, com.kwad.components.core.widget.a.a
    public final boolean ah() {
        return cb.a(this.mRootView, fD(), true);
    }
}
