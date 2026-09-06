package com.jd.ad.sdk.jad_zk;

import com.alipay.sdk.util.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_re {
    public final Set<com.jd.ad.sdk.jad_en.jad_dq> jad_an = Collections.newSetFromMap(new WeakHashMap());
    public final Set<com.jd.ad.sdk.jad_en.jad_dq> jad_bo = new HashSet();
    public boolean jad_cp;

    public boolean jad_an(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        boolean z = true;
        if (jad_dqVar == null) {
            return true;
        }
        boolean zRemove = this.jad_an.remove(jad_dqVar);
        if (!this.jad_bo.remove(jad_dqVar) && !zRemove) {
            z = false;
        }
        if (z) {
            jad_dqVar.clear();
        }
        return z;
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.jad_an.size() + ", isPaused=" + this.jad_cp + i.d;
    }
}
