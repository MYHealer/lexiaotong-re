package com.jd.ad.sdk.jad_zk;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_er implements jad_cp {
    public final Context jad_an;
    public final jad_cp.jad_an jad_bo;

    public jad_er(Context context, jad_cp.jad_an jad_anVar) {
        this.jad_an = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.jad_bo = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_an() {
        jad_sf jad_sfVarJad_an = jad_sf.jad_an(this.jad_an);
        jad_cp.jad_an jad_anVar = this.jad_bo;
        synchronized (jad_sfVarJad_an) {
            jad_sfVarJad_an.jad_bo.remove(jad_anVar);
            if (jad_sfVarJad_an.jad_cp && jad_sfVarJad_an.jad_bo.isEmpty()) {
                jad_sfVarJad_an.jad_an.jad_an();
                jad_sfVarJad_an.jad_cp = false;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_cp() {
        jad_sf jad_sfVarJad_an = jad_sf.jad_an(this.jad_an);
        jad_cp.jad_an jad_anVar = this.jad_bo;
        synchronized (jad_sfVarJad_an) {
            jad_sfVarJad_an.jad_bo.add(jad_anVar);
            if (!jad_sfVarJad_an.jad_cp && !jad_sfVarJad_an.jad_bo.isEmpty()) {
                jad_sfVarJad_an.jad_cp = jad_sfVarJad_an.jad_an.jad_bo();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_dq() {
    }
}
