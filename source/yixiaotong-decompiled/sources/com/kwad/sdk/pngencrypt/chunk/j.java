package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class j extends t {
    private boolean blV;
    private String blW;
    private String blX;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.blV = false;
        this.blW = "";
        this.blX = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (i < dVar.data.length) {
            if (dVar.data[i] == 0) {
                iArr[i2] = i;
                i2++;
                if (i2 == 1) {
                    i += 2;
                }
                if (i2 == 3) {
                    break;
                }
            }
            i++;
        }
        if (i2 != 3) {
            new PngjException("Bad formed PngChunkITXT chunk");
        }
        this.key = b.c(dVar.data, 0, iArr[0]);
        int i3 = iArr[0];
        boolean z = dVar.data[i3 + 1] != 0;
        this.blV = z;
        int i4 = i3 + 2;
        if (z && dVar.data[i4] != 0) {
            new PngjException("Bad formed PngChunkITXT chunk - bad compression method ");
        }
        this.blW = b.c(dVar.data, i4, iArr[1] - i4);
        byte[] bArr = dVar.data;
        int i5 = iArr[1];
        this.blX = b.d(bArr, i5 + 1, (iArr[2] - i5) - 1);
        int i6 = iArr[2] + 1;
        if (this.blV) {
            byte[] bArr2 = dVar.data;
            this.bmp = b.n(b.b(bArr2, i6, bArr2.length - i6, false));
        } else {
            byte[] bArr3 = dVar.data;
            this.bmp = b.d(bArr3, i6, bArr3.length - i6);
        }
    }
}
