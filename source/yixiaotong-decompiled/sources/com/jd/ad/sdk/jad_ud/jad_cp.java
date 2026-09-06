package com.jd.ad.sdk.jad_ud;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public enum jad_cp {
    JSON(".json"),
    ZIP(".zip");

    public final String jad_an;

    jad_cp(String str) {
        this.jad_an = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.jad_an;
    }
}
