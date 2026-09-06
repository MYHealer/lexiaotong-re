package com.opos.exoplayer.core.c.e;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.m;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class d extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.exoplayer.core.i.i f6324a;
    private a b;

    private class a implements g, l {
        private long[] b;
        private long[] c;
        private long d = -1;
        private long e = -1;

        public a() {
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(long j) {
            long jB = d.this.b(j);
            this.e = this.b[y.a(this.b, jB, true, true)];
            return jB;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(com.opos.exoplayer.core.c.f fVar) {
            long j = this.e;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.e = -1L;
            return j2;
        }

        public void a(p pVar) {
            pVar.d(1);
            int iK = pVar.k() / 18;
            this.b = new long[iK];
            this.c = new long[iK];
            for (int i = 0; i < iK; i++) {
                this.b[i] = pVar.q();
                this.c[i] = pVar.q();
                pVar.d(2);
            }
        }

        @Override // com.opos.exoplayer.core.c.l
        public boolean a() {
            return true;
        }

        @Override // com.opos.exoplayer.core.c.l
        public long b() {
            return d.this.f6324a.b();
        }

        @Override // com.opos.exoplayer.core.c.l
        public l.a b(long j) {
            int iA = y.a(this.b, d.this.b(j), true, true);
            long jA = d.this.a(this.b[iA]);
            m mVar = new m(jA, this.d + this.c[iA]);
            if (jA < j) {
                long[] jArr = this.b;
                if (iA != jArr.length - 1) {
                    int i = iA + 1;
                    return new l.a(mVar, new m(d.this.a(jArr[i]), this.d + this.c[i]));
                }
            }
            return new l.a(mVar);
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public l c() {
            return this;
        }

        public void c(long j) {
            this.d = j;
        }
    }

    d() {
    }

    public static boolean a(p pVar) {
        return pVar.b() >= 5 && pVar.g() == 127 && pVar.m() == 1179402563;
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    private int c(p pVar) {
        int i;
        int i2;
        int i3 = (pVar.f6510a[2] & 255) >> 4;
        switch (i3) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                i = i3 - 2;
                i2 = 576;
                break;
            case 6:
            case 7:
                pVar.d(4);
                pVar.A();
                int iG = i3 == 6 ? pVar.g() : pVar.h();
                pVar.c(0);
                return iG + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i = i3 - 8;
                i2 = 256;
                break;
            default:
                return -1;
        }
        return i2 << i;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected void a(boolean z) {
        super.a(z);
        if (z) {
            this.f6324a = null;
            this.b = null;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(p pVar, long j, i.b bVar) {
        byte[] bArr = pVar.f6510a;
        if (this.f6324a == null) {
            this.f6324a = new com.opos.exoplayer.core.i.i(bArr, 17);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 9, pVar.c());
            bArrCopyOfRange[4] = -128;
            List listSingletonList = Collections.singletonList(bArrCopyOfRange);
            int iA = this.f6324a.a();
            com.opos.exoplayer.core.i.i iVar = this.f6324a;
            bVar.f6330a = Format.a(null, MimeTypes.AUDIO_FLAC, null, -1, iA, iVar.f, iVar.e, listSingletonList, null, 0, null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            a aVar = new a();
            this.b = aVar;
            aVar.a(pVar);
            return true;
        }
        if (!a(bArr)) {
            return true;
        }
        a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.c(j);
            bVar.b = this.b;
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(p pVar) {
        if (a(pVar.f6510a)) {
            return c(pVar);
        }
        return -1L;
    }
}
