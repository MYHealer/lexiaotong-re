package com.jd.ad.sdk.jad_zm;

import com.jd.ad.sdk.logger.Logger;
import java.io.BufferedInputStream;
import java.io.Closeable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_mz implements Closeable {
    public static final /* synthetic */ int jad_er = 0;
    public int jad_an;
    public jad_fs jad_bo;
    public jad_ob jad_cp;
    public com.jd.ad.sdk.jad_zm.jad_an jad_dq;

    public static final class jad_an {
        public int jad_an;
        public jad_fs jad_bo;
        public jad_ob jad_cp;
        public com.jd.ad.sdk.jad_zm.jad_an jad_dq;
    }

    static {
        new jad_mz(new jad_an());
    }

    public jad_mz(jad_an jad_anVar) {
        this.jad_an = jad_anVar.jad_an;
        this.jad_bo = jad_anVar.jad_bo;
        this.jad_cp = jad_anVar.jad_cp;
        this.jad_dq = jad_anVar.jad_dq;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            com.jd.ad.sdk.jad_zm.jad_an jad_anVar = this.jad_dq;
            if (jad_anVar != null) {
                jad_anVar.jad_an();
                this.jad_dq = null;
            }
            jad_fs jad_fsVar = this.jad_bo;
            if (jad_fsVar != null) {
                jad_fsVar.jad_an.clear();
                this.jad_bo = null;
            }
            BufferedInputStream bufferedInputStream = this.jad_cp.jad_bo;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (Exception e) {
            Logger.w("Exception while response close", e.getMessage());
        }
    }

    public jad_ob jad_bo() {
        return this.jad_cp;
    }

    public int jad_cp() {
        return this.jad_an;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Response{mCode=").append(this.jad_an).append(", mHeaders=").append(this.jad_bo).append(", mBody=").append(this.jad_cp).append('}').toString();
    }
}
