package com.byazt.uy;

import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum ve {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL(TtmlNode.COMBINE_ALL);

    public String da;

    public String c() {
        return this.da;
    }

    ve(String str) {
        this.da = str;
    }
}
