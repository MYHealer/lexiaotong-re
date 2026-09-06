package com.jd.ad.sdk.jad_ob;

/* JADX INFO: compiled from: InitImp.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs implements Runnable {
    public final /* synthetic */ String jad_an;

    public jad_fs(String str) {
        this.jad_an = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.jd.ad.sdk.jad_vi.jad_an.jad_bo) {
            return;
        }
        jad_er.jad_an(this.jad_an);
    }
}
