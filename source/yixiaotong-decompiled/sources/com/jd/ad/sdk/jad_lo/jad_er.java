package com.jd.ad.sdk.jad_lo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public static jad_er jad_an;

    public static jad_er jad_an() {
        if (jad_an == null) {
            synchronized (jad_er.class) {
                if (jad_an == null) {
                    jad_an = new jad_er();
                }
            }
        }
        return jad_an;
    }
}
