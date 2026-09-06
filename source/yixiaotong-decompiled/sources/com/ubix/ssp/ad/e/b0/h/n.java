package com.ubix.ssp.ad.e.b0.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n extends Exception {
    public n(String str) {
        super(str + ". Version: ");
    }

    public n(String str, Throwable th) {
        super(str + ". Version: ", th);
    }

    public n(Throwable th) {
        super("No explanation error. Version: ", th);
    }
}
