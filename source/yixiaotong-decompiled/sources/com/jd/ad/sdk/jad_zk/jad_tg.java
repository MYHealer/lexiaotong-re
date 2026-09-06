package com.jd.ad.sdk.jad_zk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_tg implements Runnable {
    public final /* synthetic */ boolean jad_an;
    public final /* synthetic */ jad_sf.jad_dq.jad_an jad_bo;

    public jad_tg(jad_sf.jad_dq.jad_an jad_anVar, boolean z) {
        this.jad_bo = jad_anVar;
        this.jad_an = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        jad_sf.jad_dq.jad_an jad_anVar = this.jad_bo;
        boolean z = this.jad_an;
        jad_anVar.getClass();
        com.jd.ad.sdk.jad_ir.jad_ly.jad_an();
        jad_sf.jad_dq jad_dqVar = jad_sf.jad_dq.this;
        boolean z2 = jad_dqVar.jad_an;
        jad_dqVar.jad_an = z;
        if (z2 != z) {
            jad_dqVar.jad_bo.jad_an(z);
        }
    }
}
