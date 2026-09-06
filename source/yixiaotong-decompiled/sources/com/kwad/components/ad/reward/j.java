package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.kwad.components.core.playable.PlayableSource;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class j extends com.kwad.components.ad.l.b {
    private com.kwad.components.ad.reward.c.d tZ;
    private WeakReference<g> ua;

    public final void a(com.kwad.components.ad.reward.c.d dVar) {
        this.tZ = dVar;
    }

    public j(g gVar, JSONObject jSONObject, String str) {
        super(jSONObject, null);
        this.ua = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.ad.l.b
    public final void gH() {
        WeakReference<g> weakReference = this.ua;
        com.kwad.components.ad.reward.monitor.d.a(this.mAdTemplate, (weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void gI() {
        WeakReference<g> weakReference = this.ua;
        com.kwad.components.ad.reward.monitor.d.a(this.mAdTemplate, (weakReference != null ? weakReference.get() : null) != null, "end_card", O(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gJ() {
        WeakReference<g> weakReference = this.ua;
        com.kwad.components.ad.reward.monitor.d.a(this.mAdTemplate, (weakReference != null ? weakReference.get() : null) != null, "end_card", O(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.i.b(this.ff.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar) {
                if (j.this.tZ != null) {
                    j.this.tZ.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.j(new com.kwad.components.core.webview.jshandler.p() { // from class: com.kwad.components.ad.reward.j.2
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    jVar.a(com.kwad.components.ad.reward.c.a.ih().ii());
                }
            }
        }));
        WeakReference<g> weakReference = this.ua;
        aVar.b(new com.kwad.components.ad.reward.k.p(weakReference != null ? weakReference.get() : null, "native_id", -1L, this.fi));
    }
}
