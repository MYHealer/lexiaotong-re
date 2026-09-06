package com.jd.ad.sdk.jad_hk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jt implements jad_mz {
    public final jad_bo jad_an;
    public final jad_an jad_bo;
    public jad_jw jad_cp;
    public int jad_dq;
    public boolean jad_er;
    public long jad_fs;

    public jad_jt(jad_bo jad_boVar) {
        this.jad_an = jad_boVar;
        jad_an jad_anVarJad_an = jad_boVar.jad_an();
        this.jad_bo = jad_anVarJad_an;
        jad_jw jad_jwVar = jad_anVarJad_an.jad_an;
        this.jad_cp = jad_jwVar;
        this.jad_dq = jad_jwVar != null ? jad_jwVar.jad_bo : -1;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.jad_er = true;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz
    public long jad_an(jad_an jad_anVar, long j) {
        jad_jw jad_jwVar;
        jad_jw jad_jwVar2;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.jad_er) {
            throw new IllegalStateException("closed");
        }
        jad_jw jad_jwVar3 = this.jad_cp;
        if (jad_jwVar3 != null && (jad_jwVar3 != (jad_jwVar2 = this.jad_bo.jad_an) || this.jad_dq != jad_jwVar2.jad_bo)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.jad_an.jad_an(this.jad_fs + 1)) {
            return -1L;
        }
        if (this.jad_cp == null && (jad_jwVar = this.jad_bo.jad_an) != null) {
            this.jad_cp = jad_jwVar;
            this.jad_dq = jad_jwVar.jad_bo;
        }
        long jMin = Math.min(j, this.jad_bo.jad_bo - this.jad_fs);
        jad_an jad_anVar2 = this.jad_bo;
        long j2 = this.jad_fs;
        jad_anVar2.getClass();
        if (jad_anVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        jad_ob.jad_an(jad_anVar2.jad_bo, j2, jMin);
        if (jMin != 0) {
            jad_anVar.jad_bo += jMin;
            jad_jw jad_jwVar4 = jad_anVar2.jad_an;
            while (true) {
                long j3 = jad_jwVar4.jad_cp - jad_jwVar4.jad_bo;
                if (j2 < j3) {
                    break;
                }
                j2 -= j3;
                jad_jwVar4 = jad_jwVar4.jad_fs;
            }
            long j4 = jMin;
            while (j4 > 0) {
                jad_jw jad_jwVarJad_bo = jad_jwVar4.jad_bo();
                int i = (int) (((long) jad_jwVarJad_bo.jad_bo) + j2);
                jad_jwVarJad_bo.jad_bo = i;
                jad_jwVarJad_bo.jad_cp = Math.min(i + ((int) j4), jad_jwVarJad_bo.jad_cp);
                jad_jw jad_jwVar5 = jad_anVar.jad_an;
                if (jad_jwVar5 == null) {
                    jad_jwVarJad_bo.jad_jt = jad_jwVarJad_bo;
                    jad_jwVarJad_bo.jad_fs = jad_jwVarJad_bo;
                    jad_anVar.jad_an = jad_jwVarJad_bo;
                } else {
                    jad_jwVar5.jad_jt.jad_an(jad_jwVarJad_bo);
                }
                j4 -= (long) (jad_jwVarJad_bo.jad_cp - jad_jwVarJad_bo.jad_bo);
                jad_jwVar4 = jad_jwVar4.jad_fs;
                j2 = 0;
            }
        }
        this.jad_fs += jMin;
        return jMin;
    }
}
