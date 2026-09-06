package com.jd.ad.sdk.jad_mx;

import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_ep implements jad_fs, jad_fs.jad_an {
    public final jad_jt<?> jad_an;
    public final jad_fs.jad_an jad_bo;
    public volatile int jad_cp;
    public volatile jad_cp jad_dq;
    public volatile Object jad_er;
    public volatile com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_fs;
    public volatile jad_dq jad_jt;

    public jad_ep(jad_jt<?> jad_jtVar, jad_fs.jad_an jad_anVar) {
        this.jad_an = jad_jtVar;
        this.jad_bo = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs.jad_an
    public void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, Exception exc, com.jd.ad.sdk.jad_kv.jad_dq<?> jad_dqVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar) {
        this.jad_bo.jad_an(jad_huVar, exc, jad_dqVar, this.jad_fs.jad_cp.jad_dq());
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs.jad_an
    public void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, Object obj, com.jd.ad.sdk.jad_kv.jad_dq<?> jad_dqVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2) {
        this.jad_bo.jad_an(jad_huVar, obj, jad_dqVar, this.jad_fs.jad_cp.jad_dq(), jad_huVar);
    }

    public final boolean jad_an(Object obj) throws Throwable {
        long jJad_an = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        boolean z = false;
        try {
            com.jd.ad.sdk.jad_kv.jad_er jad_erVarJad_bo = this.jad_an.jad_cp.jad_bo.jad_bo(obj);
            Object objJad_an = jad_erVarJad_bo.jad_an();
            com.jd.ad.sdk.jad_ju.jad_dq<X> jad_dqVarJad_an = this.jad_an.jad_an(objJad_an);
            jad_er jad_erVar = new jad_er(jad_dqVarJad_an, objJad_an, this.jad_an.jad_iv);
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = this.jad_fs.jad_an;
            jad_jt<?> jad_jtVar = this.jad_an;
            jad_dq jad_dqVar = new jad_dq(jad_huVar, jad_jtVar.jad_na);
            com.jd.ad.sdk.jad_oz.jad_an jad_anVarJad_bo = jad_jtVar.jad_bo();
            jad_anVarJad_bo.jad_an(jad_dqVar, jad_erVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Logger.v("SourceGenerator", "Finished encoding source to cache, key: " + jad_dqVar + ", data: " + obj + ", encoder: " + jad_dqVarJad_an + ", duration: " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an));
            }
            if (jad_anVarJad_bo.jad_an(jad_dqVar) != null) {
                this.jad_jt = jad_dqVar;
                this.jad_dq = new jad_cp(Collections.singletonList(this.jad_fs.jad_an), this.jad_an, this);
                this.jad_fs.jad_cp.jad_bo();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Logger.d("SourceGenerator", "Attempt to write: " + this.jad_jt + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.jad_bo.jad_an(this.jad_fs.jad_an, jad_erVarJad_bo.jad_an(), this.jad_fs.jad_cp, this.jad_fs.jad_cp.jad_dq(), this.jad_fs.jad_an);
                return false;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.jad_fs.jad_cp.jad_bo();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs.jad_an
    public void jad_bo() {
        throw new UnsupportedOperationException();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public void jad_cp() {
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = this.jad_fs;
        if (jad_anVar != null) {
            jad_anVar.jad_cp.jad_cp();
        }
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public boolean jad_an() {
        if (this.jad_er != null) {
            Object obj = this.jad_er;
            this.jad_er = null;
            try {
                if (!jad_an(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Logger.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.jad_dq != null && this.jad_dq.jad_an()) {
            return true;
        }
        this.jad_dq = null;
        this.jad_fs = null;
        boolean z = false;
        while (!z && this.jad_cp < this.jad_an.jad_cp().size()) {
            List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> listJad_cp = this.jad_an.jad_cp();
            int i = this.jad_cp;
            this.jad_cp = i + 1;
            this.jad_fs = listJad_cp.get(i);
            if (this.jad_fs != null && (this.jad_an.jad_pc.jad_an(this.jad_fs.jad_cp.jad_dq()) || this.jad_an.jad_cp(this.jad_fs.jad_cp.jad_an()))) {
                this.jad_fs.jad_cp.jad_an(this.jad_an.jad_ob, new jad_do(this, this.jad_fs));
                z = true;
            }
        }
        return z;
    }
}
