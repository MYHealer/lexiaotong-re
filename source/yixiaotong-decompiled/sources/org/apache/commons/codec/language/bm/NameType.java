package org.apache.commons.codec.language.bm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public enum NameType {
    ASHKENAZI("ash"),
    GENERIC("gen"),
    SEPHARDIC("sep");

    private final String name;

    public String getName() {
        return this.name;
    }

    NameType(String str) {
        this.name = str;
    }
}
