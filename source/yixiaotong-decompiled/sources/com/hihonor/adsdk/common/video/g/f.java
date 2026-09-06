package com.hihonor.adsdk.common.video.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f extends Exception {
    private static final String hnadse = ". Version: 1.0.24.111";
    private int hnadsd;

    public f(String str) {
        super(str + hnadse);
    }

    public int hnadsa() {
        return this.hnadsd;
    }

    public f(int i, String str) {
        super(str + hnadse);
        this.hnadsd = i;
    }

    public f(String str, Throwable th) {
        super(str + hnadse, th);
    }

    public f(int i, String str, Throwable th) {
        super(str + hnadse, th);
        this.hnadsd = i;
    }

    public f(Throwable th) {
        super("No explanation error. Version: 1.0.24.111", th);
    }

    public f(int i, Throwable th) {
        super("No explanation error. Version: 1.0.24.111", th);
        this.hnadsd = i;
    }
}
