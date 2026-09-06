package com.jd.ad.sdk.jad_lu;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_sf<V> {
    public final V jad_an;
    public final Throwable jad_bo;

    public jad_sf(V v) {
        this.jad_an = v;
        this.jad_bo = null;
    }

    public jad_sf(Throwable th) {
        this.jad_bo = th;
        this.jad_an = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jad_sf)) {
            return false;
        }
        jad_sf jad_sfVar = (jad_sf) obj;
        V v = this.jad_an;
        if (v != null && v.equals(jad_sfVar.jad_an)) {
            return true;
        }
        Throwable th = this.jad_bo;
        if (th == null || jad_sfVar.jad_bo == null) {
            return false;
        }
        return th.toString().equals(this.jad_bo.toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.jad_an, this.jad_bo});
    }
}
