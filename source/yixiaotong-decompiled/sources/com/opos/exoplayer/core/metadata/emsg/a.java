package com.opos.exoplayer.core.metadata.emsg;

import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements com.opos.exoplayer.core.metadata.a {
    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.b;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        p pVar = new p(bArrArray, iLimit);
        String strY = pVar.y();
        String strY2 = pVar.y();
        long jM = pVar.m();
        return new Metadata(new EventMessage(strY, strY2, y.d(pVar.m(), 1000L, jM), pVar.m(), Arrays.copyOfRange(bArrArray, pVar.d(), iLimit), y.d(pVar.m(), 1000000L, jM)));
    }
}
