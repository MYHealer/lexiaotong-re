package com.jd.ad.sdk.jad_zk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements jad_ly {
    public final Set<jad_mz> jad_an = Collections.newSetFromMap(new WeakHashMap());
    public boolean jad_bo;
    public boolean jad_cp;

    public void jad_an() {
        this.jad_cp = true;
        Iterator it = ((ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((jad_mz) it.next()).jad_dq();
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_ly
    public void jad_an(jad_mz jad_mzVar) {
        this.jad_an.remove(jad_mzVar);
    }

    public void jad_bo() {
        this.jad_bo = true;
        Iterator it = ((ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((jad_mz) it.next()).jad_cp();
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_ly
    public void jad_bo(jad_mz jad_mzVar) {
        this.jad_an.add(jad_mzVar);
        if (this.jad_cp) {
            jad_mzVar.jad_dq();
        } else if (this.jad_bo) {
            jad_mzVar.jad_cp();
        } else {
            jad_mzVar.jad_an();
        }
    }

    public void jad_cp() {
        this.jad_bo = false;
        Iterator it = ((ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((jad_mz) it.next()).jad_an();
        }
    }
}
