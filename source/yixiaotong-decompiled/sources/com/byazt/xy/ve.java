package com.byazt.xy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum ve {
    JSON(".json"),
    ZIP(".zip");

    public final String ve;

    @Override // java.lang.Enum
    public String toString() {
        return this.ve;
    }

    ve(String str) {
        this.ve = str;
    }

    public String c() {
        return ".temp" + this.ve;
    }
}
