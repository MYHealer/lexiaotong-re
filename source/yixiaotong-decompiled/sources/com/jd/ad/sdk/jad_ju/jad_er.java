package com.jd.ad.sdk.jad_ju;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_er extends IOException {
    public jad_er(String str, int i, Throwable th) {
        super(str + ", status code: " + i, th);
    }
}
