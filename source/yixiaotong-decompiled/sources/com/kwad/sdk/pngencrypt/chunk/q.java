package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        String strC;
        int i = 0;
        while (i < dVar.data.length && dVar.data[i] != 0) {
            i++;
        }
        this.key = b.c(dVar.data, 0, i);
        int i2 = i + 1;
        if (i2 < dVar.data.length) {
            byte[] bArr = dVar.data;
            strC = b.c(bArr, i2, bArr.length - i2);
        } else {
            strC = "";
        }
        this.bmp = strC;
    }
}
