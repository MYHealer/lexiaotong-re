package com.jd.ad.sdk.bl.initsdk;

/* JADX INFO: compiled from: JADYunSdk.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements Runnable {
    public final /* synthetic */ int jad_an;
    public final /* synthetic */ String jad_bo;

    public jad_bo(JADYunSdk.jad_cp jad_cpVar, int i, String str) {
        this.jad_an = i;
        this.jad_bo = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (JADYunSdk.mInitCallback != null) {
            JADYunSdk.mInitCallback.onInitFailure(this.jad_an, this.jad_bo);
        }
    }
}
