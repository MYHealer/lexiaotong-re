package com.jd.ad.sdk.jad_uf;

import com.jd.ad.sdk.jad_kv.jad_er;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements jad_er<ByteBuffer> {
    public final ByteBuffer jad_an;

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_uf.jad_an$jad_an, reason: collision with other inner class name */
    public static class C0584jad_an implements jad_er.jad_an<ByteBuffer> {
        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        public jad_er<ByteBuffer> jad_an(ByteBuffer byteBuffer) {
            return new jad_an(byteBuffer);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        public Class<ByteBuffer> jad_an() {
            return ByteBuffer.class;
        }
    }

    public jad_an(ByteBuffer byteBuffer) {
        this.jad_an = byteBuffer;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public ByteBuffer jad_an() {
        this.jad_an.position(0);
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public void jad_bo() {
    }
}
