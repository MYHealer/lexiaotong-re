package com.opos.exoplayer.core.c.f;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Format> f6363a;
    private final com.opos.exoplayer.core.c.n[] b;

    public w(List<Format> list) {
        this.f6363a = list;
        this.b = new com.opos.exoplayer.core.c.n[list.size()];
    }

    public void a(long j, com.opos.exoplayer.core.i.p pVar) {
        com.opos.exoplayer.core.f.a.c.a(j, pVar, this.b);
    }

    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            com.opos.exoplayer.core.c.n nVarA = gVar.a(dVar.b(), 3);
            Format format = this.f6363a.get(i);
            String str = format.f;
            com.opos.exoplayer.core.i.a.a(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            String strC = format.f6232a;
            if (strC == null) {
                strC = dVar.c();
            }
            nVarA.a(Format.a(strC, str, (String) null, -1, format.x, format.y, format.z, (DrmInitData) null));
            this.b[i] = nVarA;
        }
    }
}
