package com.kwad.sdk.core.network.idc.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private final long aUr;
    private volatile boolean aUs = false;

    public final boolean Ms() {
        return this.aUs;
    }

    public final long Mt() {
        return this.aUr;
    }

    public final a bF(boolean z) {
        this.aUs = true;
        return this;
    }

    public a(long j, boolean z) {
        this.aUr = j;
    }
}
