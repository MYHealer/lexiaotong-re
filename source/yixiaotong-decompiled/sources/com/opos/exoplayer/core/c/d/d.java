package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.p;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UUID f6302a;
        private final int b;
        private final byte[] c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.f6302a = uuid;
            this.b = i;
            this.c = bArr;
        }
    }

    public static UUID a(byte[] bArr) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return null;
        }
        return aVarB.f6302a;
    }

    private static a b(byte[] bArr) {
        p pVar = new p(bArr);
        if (pVar.c() < 32) {
            return null;
        }
        pVar.c(0);
        if (pVar.o() != pVar.b() + 4 || pVar.o() != g.U) {
            return null;
        }
        int iA = g.a(pVar.o());
        if (iA > 1) {
            com.opos.cmn.an.f.a.c("PsshAtomUtil", "Unsupported pssh version: " + iA);
            return null;
        }
        UUID uuid = new UUID(pVar.q(), pVar.q());
        if (iA == 1) {
            pVar.d(pVar.u() * 16);
        }
        int iU = pVar.u();
        if (iU != pVar.b()) {
            return null;
        }
        byte[] bArr2 = new byte[iU];
        pVar.a(bArr2, 0, iU);
        return new a(uuid, iA, bArr2);
    }
}
