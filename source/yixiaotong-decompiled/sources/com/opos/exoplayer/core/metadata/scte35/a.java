package com.opos.exoplayer.core.metadata.scte35;

import com.opos.exoplayer.core.i.o;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.w;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements com.opos.exoplayer.core.metadata.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f6544a = new p();
    private final o b = new o();
    private w c;

    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        Metadata.Entry spliceNullCommand;
        w wVar = this.c;
        if (wVar == null || dVar.d != wVar.c()) {
            w wVar2 = new w(dVar.c);
            this.c = wVar2;
            wVar2.e(dVar.c - dVar.d);
        }
        ByteBuffer byteBuffer = dVar.b;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f6544a.a(bArrArray, iLimit);
        this.b.a(bArrArray, iLimit);
        this.b.b(39);
        long jC = (((long) this.b.c(1)) << 32) | ((long) this.b.c(32));
        this.b.b(20);
        int iC = this.b.c(12);
        int iC2 = this.b.c(8);
        this.f6544a.d(14);
        if (iC2 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (iC2 == 255) {
            spliceNullCommand = PrivateCommand.a(this.f6544a, iC, jC);
        } else if (iC2 == 4) {
            spliceNullCommand = SpliceScheduleCommand.a(this.f6544a);
        } else if (iC2 != 5) {
            spliceNullCommand = iC2 != 6 ? null : TimeSignalCommand.a(this.f6544a, jC, this.c);
        } else {
            spliceNullCommand = SpliceInsertCommand.a(this.f6544a, jC, this.c);
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
