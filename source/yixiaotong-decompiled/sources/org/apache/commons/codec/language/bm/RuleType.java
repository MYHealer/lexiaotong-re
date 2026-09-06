package org.apache.commons.codec.language.bm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");

    private final String name;

    public String getName() {
        return this.name;
    }

    RuleType(String str) {
        this.name = str;
    }
}
