package com.jd.ad.sdk.jad_hk;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq implements jad_mz {
    public final /* synthetic */ jad_na jad_an;
    public final /* synthetic */ InputStream jad_bo;

    public jad_dq(jad_na jad_naVar, InputStream inputStream) {
        this.jad_an = jad_naVar;
        this.jad_bo = inputStream;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.jad_bo.close();
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz
    public long jad_an(jad_an jad_anVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        try {
            this.jad_an.jad_an();
            jad_jw jad_jwVarJad_an = jad_anVar.jad_an(1);
            int i = this.jad_bo.read(jad_jwVarJad_an.jad_an, jad_jwVarJad_an.jad_cp, (int) Math.min(j, 8192 - jad_jwVarJad_an.jad_cp));
            if (i == -1) {
                return -1L;
            }
            jad_jwVarJad_an.jad_cp += i;
            long j2 = i;
            jad_anVar.jad_bo += j2;
            return j2;
        } catch (AssertionError e) {
            if (e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) {
                throw e;
            }
            throw new IOException(e);
        }
    }

    public String toString() {
        return jad_pc.jad_an("source(").append(this.jad_bo).append(")").toString();
    }
}
