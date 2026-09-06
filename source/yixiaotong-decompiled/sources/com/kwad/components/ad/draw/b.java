package com.kwad.components.ad.draw;

import android.view.View;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.cb;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends com.kwad.components.core.widget.a.c {
    private View mRootView;

    public b(View view) {
        super(view, aL());
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.c, com.kwad.components.core.widget.a.a
    public final boolean ah() {
        return cb.a(this.mRootView, aL(), true);
    }

    private static int aL() {
        try {
            int iKe = ((int) e.Ke()) * 100;
            if (iKe < 0 || iKe > 100) {
                return 70;
            }
            return iKe;
        } catch (Throwable unused) {
        }
    }
}
