package com.kwad.components.core.widget.a;

import android.view.View;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b extends a {
    private final AtomicBoolean awA;
    private KsFragment awF;
    private String awG;

    public b(KsFragment ksFragment, View view, int i) {
        super(view, 70);
        this.awA = new AtomicBoolean(false);
        this.awF = ksFragment;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean ah() {
        KsFragment ksFragment = this.awF;
        if (ksFragment == null) {
            return false;
        }
        if (a(ksFragment)) {
            this.awG = "message fragment";
            return false;
        }
        this.awG = "message view";
        return Ac();
    }

    private static boolean a(KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    @Override // com.kwad.components.core.widget.a.a, com.kwad.sdk.core.j.a
    public final void release() {
        super.release();
        this.awF = null;
    }
}
