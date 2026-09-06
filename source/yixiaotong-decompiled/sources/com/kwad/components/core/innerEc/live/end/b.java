package com.kwad.components.core.innerEc.live.end;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b implements a {
    private final List<c> WZ = new CopyOnWriteArrayList();
    private boolean Xa;

    @Override // com.kwad.components.core.innerEc.live.end.a
    public final boolean sD() {
        return this.Xa;
    }

    @Override // com.kwad.components.core.innerEc.live.end.a
    public final void a(c cVar) {
        this.WZ.add(cVar);
    }

    @Override // com.kwad.components.core.innerEc.live.end.a
    public final void b(c cVar) {
        this.WZ.remove(cVar);
    }

    @Override // com.kwad.components.core.innerEc.live.end.a
    public final void a(LiveAudienceEndReason liveAudienceEndReason) {
        this.Xa = true;
        Iterator<c> it = this.WZ.iterator();
        while (it.hasNext()) {
            it.next().sg();
        }
    }
}
