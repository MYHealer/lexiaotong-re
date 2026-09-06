package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    protected com.kwad.sdk.core.webview.c.c atX;
    protected CopyOnWriteArrayList<com.kwad.sdk.core.b> atY = new CopyOnWriteArrayList<>();

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.atX = null;
    }

    public void a(final com.kwad.sdk.core.b bVar) {
        if (this.atX != null) {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.b.w.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (w.this.atX != null) {
                        w.this.atX.b(bVar);
                    }
                }
            });
        } else {
            this.atY.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.atX = cVar;
        if (this.atY.size() > 0) {
            for (com.kwad.sdk.core.b bVar : this.atY) {
                a(bVar);
                this.atY.remove(bVar);
            }
        }
    }
}
