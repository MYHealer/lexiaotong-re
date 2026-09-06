package com.jd.ad.sdk.jad_qd;

/* JADX INFO: compiled from: JADAntiUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements Runnable {
    public final /* synthetic */ boolean[] jad_an;

    public jad_bo(boolean[] zArr) {
        this.jad_an = zArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jad_an[0] = jad_cp.jad_er();
    }
}
