package com.jd.ad.sdk.jad_oz;

import com.jd.ad.sdk.jad_ir.jad_kx;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_cp {
    public final Map<String, jad_an> jad_an = new HashMap();
    public final jad_bo jad_bo = new jad_bo();

    public static class jad_an {
        public final Lock jad_an = new ReentrantLock();
        public int jad_bo;
    }

    public static class jad_bo {
        public final Queue<jad_an> jad_an = new ArrayDeque();
    }

    public void jad_an(String str) {
        jad_an jad_anVar;
        synchronized (this) {
            jad_anVar = (jad_an) jad_kx.jad_an(this.jad_an.get(str));
            int i = jad_anVar.jad_bo;
            if (i < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + jad_anVar.jad_bo);
            }
            int i2 = i - 1;
            jad_anVar.jad_bo = i2;
            if (i2 == 0) {
                jad_an jad_anVarRemove = this.jad_an.remove(str);
                if (!jad_anVarRemove.equals(jad_anVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + jad_anVar + ", but actually removed: " + jad_anVarRemove + ", safeKey: " + str);
                }
                jad_bo jad_boVar = this.jad_bo;
                synchronized (jad_boVar.jad_an) {
                    if (jad_boVar.jad_an.size() < 10) {
                        jad_boVar.jad_an.offer(jad_anVarRemove);
                    }
                }
            }
        }
        jad_anVar.jad_an.unlock();
    }
}
