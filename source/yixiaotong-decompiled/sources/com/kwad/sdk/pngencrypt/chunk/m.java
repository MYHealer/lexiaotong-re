package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class m extends p {
    private int bmb;
    private int[] bmc;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.bmb = 0;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        fC(dVar.len / 3);
        int i = 0;
        for (int i2 = 0; i2 < this.bmb; i2++) {
            int i3 = dVar.data[i] & 255;
            int i4 = i + 2;
            int i5 = dVar.data[i + 1] & 255;
            i += 3;
            c(i2, i3, i5, dVar.data[i4] & 255);
        }
    }

    private void fC(int i) {
        this.bmb = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.bmb);
        }
        int[] iArr = this.bmc;
        if (iArr == null || iArr.length != i) {
            this.bmc = new int[i];
        }
    }

    private void c(int i, int i2, int i3, int i4) {
        this.bmc[i] = (i2 << 16) | (i3 << 8) | i4;
    }
}
