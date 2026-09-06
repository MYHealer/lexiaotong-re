package com.jd.ad.sdk.jad_qz;

import androidx.collection.LruCache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt {
    public static final jad_jt jad_bo = new jad_jt();
    public final LruCache<String, com.jd.ad.sdk.jad_lu.jad_jt> jad_an = new LruCache<>(20);

    public void jad_an(String str, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        if (str == null) {
            return;
        }
        this.jad_an.put(str, jad_jtVar);
    }
}
