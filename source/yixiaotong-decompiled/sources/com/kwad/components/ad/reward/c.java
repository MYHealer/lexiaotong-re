package com.kwad.components.ad.reward;

import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> sc;

    static class a {
        private static final c sf = new c(0);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.sc = new HashSet();
    }

    public static c gz() {
        return a.sf;
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.sc.add(mVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.sc.remove(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (this.sc.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> it = this.sc.iterator();
        while (it.hasNext()) {
            it.next().a(rVar);
        }
    }

    public final void c(final r rVar) {
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                c.this.b(rVar);
            }
        });
    }
}
