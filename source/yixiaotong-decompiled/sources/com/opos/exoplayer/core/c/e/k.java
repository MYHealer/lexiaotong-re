package com.opos.exoplayer.core.c.e;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.o;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class k extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6332a;
    private int b;
    private boolean c;
    private b.d d;
    private b.C0912b e;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.d f6333a;
        public final byte[] b;
        public final b.c[] c;
        public final int d;

        public a(b.d dVar, b.C0912b c0912b, byte[] bArr, b.c[] cVarArr, int i) {
            this.f6333a = dVar;
            this.b = bArr;
            this.c = cVarArr;
            this.d = i;
        }
    }

    k() {
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    private static int a(byte b, a aVar) {
        return !aVar.c[a(b, aVar.d, 1)].f6320a ? aVar.f6333a.g : aVar.f6333a.h;
    }

    static void a(p pVar, long j) {
        pVar.b(pVar.c() + 4);
        pVar.f6510a[pVar.c() - 4] = (byte) (j & 255);
        pVar.f6510a[pVar.c() - 3] = (byte) ((j >>> 8) & 255);
        pVar.f6510a[pVar.c() - 2] = (byte) ((j >>> 16) & 255);
        pVar.f6510a[pVar.c() - 1] = (byte) ((j >>> 24) & 255);
    }

    public static boolean a(p pVar) {
        try {
            return b.a(1, pVar, true);
        } catch (o unused) {
            return false;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected void a(boolean z) {
        super.a(z);
        if (z) {
            this.f6332a = null;
            this.d = null;
            this.e = null;
        }
        this.b = 0;
        this.c = false;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(p pVar, long j, i.b bVar) throws o {
        if (this.f6332a != null) {
            return false;
        }
        a aVarC = c(pVar);
        this.f6332a = aVarC;
        if (aVarC == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6332a.f6333a.j);
        arrayList.add(this.f6332a.b);
        b.d dVar = this.f6332a.f6333a;
        bVar.f6330a = Format.a(null, MimeTypes.AUDIO_VORBIS, null, dVar.e, -1, dVar.b, (int) dVar.c, arrayList, null, 0, null);
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(p pVar) {
        byte b = pVar.f6510a[0];
        if ((b & 1) == 1) {
            return -1L;
        }
        int iA = a(b, this.f6332a);
        long j = this.c ? (this.b + iA) / 4 : 0;
        a(pVar, j);
        this.c = true;
        this.b = iA;
        return j;
    }

    a c(p pVar) throws o {
        if (this.d == null) {
            this.d = b.a(pVar);
            return null;
        }
        if (this.e == null) {
            this.e = b.b(pVar);
            return null;
        }
        byte[] bArr = new byte[pVar.c()];
        System.arraycopy(pVar.f6510a, 0, bArr, 0, pVar.c());
        b.c[] cVarArrA = b.a(pVar, this.d.b);
        return new a(this.d, this.e, bArr, cVarArrA, b.a(cVarArrA.length - 1));
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected void c(long j) {
        super.c(j);
        this.c = j != 0;
        b.d dVar = this.d;
        this.b = dVar != null ? dVar.g : 0;
    }
}
