package com.hihonor.adsdk.common.f.e0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends IllegalStateException {
    private Throwable hnadsd;

    public a(String str, Throwable th) {
        super(str);
        this.hnadsd = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.hnadsd;
    }
}
