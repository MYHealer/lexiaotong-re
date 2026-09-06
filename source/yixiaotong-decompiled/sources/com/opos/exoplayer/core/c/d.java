package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.i.p;
import java.io.EOFException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d implements n {
    @Override // com.opos.exoplayer.core.c.n
    public int a(f fVar, int i, boolean z) throws EOFException {
        int iA = fVar.a(i);
        if (iA != -1) {
            return iA;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(long j, int i, int i2, int i3, n.a aVar) {
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(Format format) {
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(p pVar, int i) {
        pVar.d(i);
    }
}
