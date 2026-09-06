package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class v extends t {
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i = 0;
        while (true) {
            if (i >= dVar.data.length) {
                i = -1;
                break;
            } else if (dVar.data[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0 || i > dVar.data.length - 2) {
            new PngjException("bad zTXt chunk: no separator found");
        }
        this.key = b.c(dVar.data, 0, i);
        if (dVar.data[i + 1] != 0) {
            new PngjException("bad zTXt chunk: unknown compression method");
        }
        this.bmp = b.m(b.b(dVar.data, i + 2, (dVar.data.length - i) - 2, false));
    }
}
