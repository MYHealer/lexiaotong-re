package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class n extends k {
    private String bmd;
    private int bme;
    private int[] bmf;

    public final String Tz() {
        return this.bmd;
    }

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int iF;
        int iF2;
        int iF3;
        int iF4;
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= dVar.data.length) {
                i2 = -1;
                break;
            } else if (dVar.data[i2] == 0) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 <= 0 || i2 > dVar.data.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.bmd = b.c(dVar.data, 0, i2);
        this.bme = com.kwad.sdk.pngencrypt.n.e(dVar.data, i2 + 1);
        int i3 = i2 + 2;
        int length = (dVar.data.length - i3) / (this.bme == 8 ? 6 : 10);
        this.bmf = new int[length * 5];
        int i4 = i3;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (this.bme == 8) {
                iF = com.kwad.sdk.pngencrypt.n.e(dVar.data, i4);
                iF2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i4 + 1);
                int i7 = i4 + 3;
                iF3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i4 + 2);
                i = i4 + 4;
                iF4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i7);
            } else {
                iF = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4);
                iF2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4 + 2);
                iF3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4 + 4);
                iF4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i4 + 6);
                i = i4 + 8;
            }
            int iF5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i);
            i4 = i + 2;
            int[] iArr = this.bmf;
            iArr[i5] = iF;
            iArr[i5 + 1] = iF2;
            iArr[i5 + 2] = iF3;
            int i8 = i5 + 4;
            iArr[i5 + 3] = iF4;
            i5 += 5;
            iArr[i8] = iF5;
        }
    }
}
