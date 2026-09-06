package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f extends e {
    private final List<PngChunk> blJ;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + Tq().size() + " queue: " + this.blJ.size();
    }
}
