package com.byazt.ga;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 66})
public final class t<V> {
    public final V c;
    public final Throwable tt;

    public V c() {
        return this.c;
    }

    public Throwable tt() {
        return this.tt;
    }

    public t(V v) {
        this.c = v;
        this.tt = null;
    }

    public t(Throwable th) {
        this.tt = th;
        this.c = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (c() != null && c().equals(tVar.c())) {
            return true;
        }
        if (tt() == null || tVar.tt() == null) {
            return false;
        }
        return tt().toString().equals(tt().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{c(), tt()});
    }
}
