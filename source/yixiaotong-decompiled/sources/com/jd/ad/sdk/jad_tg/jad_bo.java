package com.jd.ad.sdk.jad_tg;

/* JADX INFO: compiled from: MultiProcessManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        synchronized (jad_an.class) {
            jad_an.jad_an(jad_an.jad_an);
        }
        synchronized (jad_an.class) {
            jad_an.jad_an(jad_an.jad_bo);
        }
    }
}
