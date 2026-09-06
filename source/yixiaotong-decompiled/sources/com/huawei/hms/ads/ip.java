package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class ip {
    private final String B = "min_show_time_task" + hashCode();
    private final String C = "max_show_time_task" + hashCode();
    protected ej Code;
    private mg Z;

    public ip(ej ejVar, mg mgVar) {
        this.Code = ejVar;
        this.Z = mgVar;
    }

    protected void B() {
        com.huawei.openalliance.ad.utils.bj.Code(this.B);
    }

    public void Code() {
    }

    protected void Code(long j) {
        fh.V(getClass().getSimpleName(), "start max show time task duration: %d", Long.valueOf(j));
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ip.1
            @Override // java.lang.Runnable
            public void run() {
                ip.this.B();
                ip.this.Z();
            }
        }, this.C, j);
    }

    protected void I() {
        mg mgVar = this.Z;
        if (mgVar != null) {
            mgVar.Code();
        }
    }

    public void V() {
    }

    protected void V(long j) {
        fh.V(getClass().getSimpleName(), "start min show time task duration: %d", Long.valueOf(j));
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ip.2
            @Override // java.lang.Runnable
            public void run() {
                ip.this.I();
            }
        }, this.B, j);
    }

    protected void Z() {
        mg mgVar = this.Z;
        if (mgVar != null) {
            mgVar.V();
        }
    }
}
