package com.opos.exoplayer.core.c.e;

import com.google.android.exoplayer2.extractor.ogg.OggPageHeader;
import com.opos.exoplayer.core.i.p;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f6326a = new f();
    private final p b = new p(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private int c = -1;
    private int d;
    private boolean e;

    e() {
    }

    private int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            f fVar = this.f6326a;
            if (i5 >= fVar.d) {
                break;
            }
            int[] iArr = fVar.g;
            this.d = i4 + 1;
            i2 = iArr[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public void a() {
        this.f6326a.a();
        this.b.a();
        this.c = -1;
        this.e = false;
    }

    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        int i;
        com.opos.exoplayer.core.i.a.b(fVar != null);
        if (this.e) {
            this.e = false;
            this.b.a();
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.f6326a.a(fVar, true)) {
                    return false;
                }
                f fVar2 = this.f6326a;
                int iA = fVar2.e;
                if ((fVar2.b & 1) == 1 && this.b.c() == 0) {
                    iA += a(0);
                    i = this.d;
                } else {
                    i = 0;
                }
                fVar.b(iA);
                this.c = i;
            }
            int iA2 = a(this.c);
            int i2 = this.c + this.d;
            if (iA2 > 0) {
                if (this.b.e() < this.b.c() + iA2) {
                    p pVar = this.b;
                    pVar.f6510a = Arrays.copyOf(pVar.f6510a, pVar.c() + iA2);
                }
                p pVar2 = this.b;
                fVar.b(pVar2.f6510a, pVar2.c(), iA2);
                p pVar3 = this.b;
                pVar3.b(pVar3.c() + iA2);
                this.e = this.f6326a.g[i2 + (-1)] != 255;
            }
            if (i2 == this.f6326a.d) {
                i2 = -1;
            }
            this.c = i2;
        }
        return true;
    }

    public f b() {
        return this.f6326a;
    }

    public p c() {
        return this.b;
    }

    public void d() {
        p pVar = this.b;
        byte[] bArr = pVar.f6510a;
        if (bArr.length == 65025) {
            return;
        }
        pVar.f6510a = Arrays.copyOf(bArr, Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, pVar.c()));
    }
}
