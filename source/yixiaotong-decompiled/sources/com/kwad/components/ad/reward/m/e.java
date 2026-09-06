package com.kwad.components.ad.reward.m;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.m;
import com.kwad.sdk.utils.j;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e {
    private com.kwad.components.ad.reward.f.a CK;
    private d CL;
    private b CM;
    private com.kwad.components.ad.k.a CN;
    private g uj;
    private int CJ = 0;
    private int CO = 0;
    private List<m> CP = new CopyOnWriteArrayList();

    private com.kwad.components.ad.k.a lr() {
        return this.CN;
    }

    public final boolean ls() {
        return this.CK != null;
    }

    public final com.kwad.components.ad.reward.f.a lt() {
        return this.CK;
    }

    public final b lu() {
        return this.CM;
    }

    public e(g gVar) {
        this.uj = gVar;
        this.CN = new a(gVar.mAdTemplate);
    }

    public final void a(int i, com.kwad.components.ad.k.a aVar) {
        this.CJ = i;
        if (i == 1) {
            this.CL = (d) aVar;
        } else if (i == 2) {
            this.CK = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i == 3) {
            this.CM = (b) aVar;
        }
        this.CN = aVar;
        Iterator<m> it = this.CP.iterator();
        while (it.hasNext()) {
            this.CN.b(it.next());
        }
        this.CP.clear();
    }

    public final void a(m mVar) {
        if (lr().ln()) {
            this.CP.add(mVar);
        } else {
            lr().b(mVar);
        }
    }

    public final void b(m mVar) {
        lr().a(mVar);
        if (mVar != null) {
            this.CP.remove(mVar);
        }
    }

    public final void lp() {
        d dVar = this.CL;
        if (dVar != null) {
            dVar.lp();
        }
    }

    public final void a(j.a aVar) {
        d dVar = this.CL;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public final void b(j.a aVar) {
        d dVar = this.CL;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final void lo() {
        d dVar = this.CL;
        if (dVar != null) {
            dVar.lo();
        } else {
            b bVar = this.CM;
            if (bVar != null) {
                bVar.lo();
            }
        }
        this.uj.gT();
    }

    public final long getPlayDuration() {
        return lr().getPlayDuration();
    }

    public final void skipToEnd() {
        lr().skipToEnd();
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.CO = z ? 2 : 1;
        lr().setAudioEnabled(z, z2);
    }

    public final void resume() {
        int i;
        lr().resume();
        com.kwad.components.ad.reward.f.a aVar = this.CK;
        if (aVar == null || (i = this.CO) <= 0) {
            return;
        }
        aVar.setAudioEnabled(i == 2, false);
    }

    public final void pause() {
        lr().pause();
    }

    public final void release() {
        lr().release();
    }
}
