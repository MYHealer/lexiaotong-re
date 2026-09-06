package com.jd.ad.sdk.bl.initsdk;

/* JADX INFO: compiled from: JADYunSdk.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements Runnable {
    public jad_an(JADYunSdk.jad_cp jad_cpVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (JADYunSdk.mInitCallback != null) {
            JADYunSdk.mInitCallback.onInitSuccess();
        }
    }
}
