package com.jd.ad.sdk.jad_mx;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_yl implements jad_fs, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<Object> {
    public final jad_fs.jad_an jad_an;
    public final jad_jt<?> jad_bo;
    public int jad_cp;
    public int jad_dq = -1;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_er;
    public List<com.jd.ad.sdk.jad_qb.jad_na<File, ?>> jad_fs;
    public volatile com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_hu;
    public File jad_iv;
    public int jad_jt;
    public jad_zm jad_jw;

    public jad_yl(jad_jt<?> jad_jtVar, jad_fs.jad_an jad_anVar) {
        this.jad_bo = jad_jtVar;
        this.jad_an = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(Exception exc) {
        this.jad_an.jad_an(this.jad_jw, exc, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_ju.jad_an.RESOURCE_DISK_CACHE);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(Object obj) {
        this.jad_an.jad_an(this.jad_er, obj, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_ju.jad_an.RESOURCE_DISK_CACHE, this.jad_jw);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public boolean jad_an() {
        List<com.jd.ad.sdk.jad_ju.jad_hu> listJad_an = this.jad_bo.jad_an();
        boolean z = false;
        if (listJad_an.isEmpty()) {
            return false;
        }
        List<Class<?>> listJad_dq = this.jad_bo.jad_dq();
        if (listJad_dq.isEmpty()) {
            if (File.class.equals(this.jad_bo.jad_kx)) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.jad_bo.jad_dq.getClass() + " to " + this.jad_bo.jad_kx);
        }
        while (true) {
            List<com.jd.ad.sdk.jad_qb.jad_na<File, ?>> list = this.jad_fs;
            if (list != null && this.jad_jt < list.size()) {
                this.jad_hu = null;
                while (!z && this.jad_jt < this.jad_fs.size()) {
                    List<com.jd.ad.sdk.jad_qb.jad_na<File, ?>> list2 = this.jad_fs;
                    int i = this.jad_jt;
                    this.jad_jt = i + 1;
                    com.jd.ad.sdk.jad_qb.jad_na<File, ?> jad_naVar = list2.get(i);
                    File file = this.jad_iv;
                    jad_jt<?> jad_jtVar = this.jad_bo;
                    this.jad_hu = jad_naVar.jad_an(file, jad_jtVar.jad_er, jad_jtVar.jad_fs, jad_jtVar.jad_iv);
                    if (this.jad_hu != null && this.jad_bo.jad_cp(this.jad_hu.jad_cp.jad_an())) {
                        this.jad_hu.jad_cp.jad_an(this.jad_bo.jad_ob, this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.jad_dq + 1;
            this.jad_dq = i2;
            if (i2 >= listJad_dq.size()) {
                int i3 = this.jad_cp + 1;
                this.jad_cp = i3;
                if (i3 >= listJad_an.size()) {
                    return false;
                }
                this.jad_dq = 0;
            }
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = listJad_an.get(this.jad_cp);
            Class<?> cls = listJad_dq.get(this.jad_dq);
            com.jd.ad.sdk.jad_ju.jad_na<Z> jad_naVarJad_bo = this.jad_bo.jad_bo(cls);
            jad_jt<?> jad_jtVar2 = this.jad_bo;
            this.jad_jw = new jad_zm(jad_jtVar2.jad_cp.jad_an, jad_huVar, jad_jtVar2.jad_na, jad_jtVar2.jad_er, jad_jtVar2.jad_fs, jad_naVarJad_bo, cls, jad_jtVar2.jad_iv);
            File fileJad_an = jad_jtVar2.jad_bo().jad_an(this.jad_jw);
            this.jad_iv = fileJad_an;
            if (fileJad_an != null) {
                this.jad_er = jad_huVar;
                this.jad_fs = this.jad_bo.jad_cp.jad_bo.jad_an(fileJad_an);
                this.jad_jt = 0;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public void jad_cp() {
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = this.jad_hu;
        if (jad_anVar != null) {
            jad_anVar.jad_cp.jad_cp();
        }
    }
}
