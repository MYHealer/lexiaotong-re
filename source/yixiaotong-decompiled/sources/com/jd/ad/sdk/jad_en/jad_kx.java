package com.jd.ad.sdk.jad_en;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_kx implements jad_fs, jad_dq {
    public final jad_fs jad_an;
    public final Object jad_bo;
    public volatile jad_dq jad_cp;
    public volatile jad_dq jad_dq;
    public int jad_er = 3;
    public int jad_fs = 3;
    public boolean jad_jt;

    public jad_kx(Object obj, jad_fs jad_fsVar) {
        this.jad_bo = obj;
        this.jad_an = jad_fsVar;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void clear() {
        synchronized (this.jad_bo) {
            this.jad_jt = false;
            this.jad_er = 3;
            this.jad_fs = 3;
            this.jad_dq.clear();
            this.jad_cp.clear();
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean isRunning() {
        boolean z;
        synchronized (this.jad_bo) {
            z = true;
            if (this.jad_er != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs, com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_an() {
        boolean z;
        synchronized (this.jad_bo) {
            z = this.jad_dq.jad_an() || this.jad_cp.jad_an();
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_an(jad_dq jad_dqVar) {
        boolean z;
        synchronized (this.jad_bo) {
            jad_fs jad_fsVar = this.jad_an;
            z = (jad_fsVar == null || jad_fsVar.jad_an(this)) && (jad_dqVar.equals(this.jad_cp) || this.jad_er != 4);
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public jad_fs jad_bo() {
        jad_fs jad_fsVarJad_bo;
        synchronized (this.jad_bo) {
            jad_fs jad_fsVar = this.jad_an;
            jad_fsVarJad_bo = jad_fsVar != null ? jad_fsVar.jad_bo() : this;
        }
        return jad_fsVarJad_bo;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_bo(jad_dq jad_dqVar) {
        boolean z;
        synchronized (this.jad_bo) {
            jad_fs jad_fsVar = this.jad_an;
            z = (jad_fsVar == null || jad_fsVar.jad_bo(this)) && jad_dqVar.equals(this.jad_cp) && !jad_an();
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_cp() {
        boolean z;
        synchronized (this.jad_bo) {
            z = this.jad_er == 4;
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_cp(jad_dq jad_dqVar) {
        boolean z;
        synchronized (this.jad_bo) {
            jad_fs jad_fsVar = this.jad_an;
            z = (jad_fsVar == null || jad_fsVar.jad_cp(this)) && jad_dqVar.equals(this.jad_cp) && this.jad_er != 2;
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public void jad_dq(jad_dq jad_dqVar) {
        synchronized (this.jad_bo) {
            if (jad_dqVar.equals(this.jad_dq)) {
                this.jad_fs = 4;
                return;
            }
            this.jad_er = 4;
            jad_fs jad_fsVar = this.jad_an;
            if (jad_fsVar != null) {
                jad_fsVar.jad_dq(this);
            }
            if (!jad_er.jad_an(this.jad_fs)) {
                this.jad_dq.clear();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er() {
        boolean z;
        synchronized (this.jad_bo) {
            z = this.jad_er == 3;
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er(jad_dq jad_dqVar) {
        if (!(jad_dqVar instanceof jad_kx)) {
            return false;
        }
        jad_kx jad_kxVar = (jad_kx) jad_dqVar;
        if (this.jad_cp == null) {
            if (jad_kxVar.jad_cp != null) {
                return false;
            }
        } else if (!this.jad_cp.jad_er(jad_kxVar.jad_cp)) {
            return false;
        }
        if (this.jad_dq == null) {
            if (jad_kxVar.jad_dq != null) {
                return false;
            }
        } else if (!this.jad_dq.jad_er(jad_kxVar.jad_dq)) {
            return false;
        }
        return true;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_fs() {
        synchronized (this.jad_bo) {
            this.jad_jt = true;
            try {
                if (this.jad_er != 4 && this.jad_fs != 1) {
                    this.jad_fs = 1;
                    this.jad_dq.jad_fs();
                }
                if (this.jad_jt && this.jad_er != 1) {
                    this.jad_er = 1;
                    this.jad_cp.jad_fs();
                }
                this.jad_jt = false;
            } catch (Throwable th) {
                this.jad_jt = false;
                throw th;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public void jad_fs(jad_dq jad_dqVar) {
        synchronized (this.jad_bo) {
            if (!jad_dqVar.equals(this.jad_cp)) {
                this.jad_fs = 5;
                return;
            }
            this.jad_er = 5;
            jad_fs jad_fsVar = this.jad_an;
            if (jad_fsVar != null) {
                jad_fsVar.jad_fs(this);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_dq() {
        synchronized (this.jad_bo) {
            if (!jad_er.jad_an(this.jad_fs)) {
                this.jad_fs = 2;
                this.jad_dq.jad_dq();
            }
            if (!jad_er.jad_an(this.jad_er)) {
                this.jad_er = 2;
                this.jad_cp.jad_dq();
            }
        }
    }
}
