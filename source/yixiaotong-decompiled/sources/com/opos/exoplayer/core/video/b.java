package com.opos.exoplayer.core.video;

import com.opos.exoplayer.core.i.n;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.o;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f6552a;
    public final int b;

    private b(List<byte[]> list, int i) {
        this.f6552a = list;
        this.b = i;
    }

    public static b a(p pVar) throws o {
        try {
            pVar.d(21);
            int iG = pVar.g() & 3;
            int iG2 = pVar.g();
            int iD = pVar.d();
            int i = 0;
            for (int i2 = 0; i2 < iG2; i2++) {
                pVar.d(1);
                int iH = pVar.h();
                for (int i3 = 0; i3 < iH; i3++) {
                    int iH2 = pVar.h();
                    i += iH2 + 4;
                    pVar.d(iH2);
                }
            }
            pVar.c(iD);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < iG2; i5++) {
                pVar.d(1);
                int iH3 = pVar.h();
                for (int i6 = 0; i6 < iH3; i6++) {
                    int iH4 = pVar.h();
                    System.arraycopy(n.f6506a, 0, bArr, i4, n.f6506a.length);
                    int length = i4 + n.f6506a.length;
                    System.arraycopy(pVar.f6510a, pVar.d(), bArr, length, iH4);
                    i4 = length + iH4;
                    pVar.d(iH4);
                }
            }
            return new b(i == 0 ? null : Collections.singletonList(bArr), iG + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new o("Error parsing HEVC config", e);
        }
    }
}
