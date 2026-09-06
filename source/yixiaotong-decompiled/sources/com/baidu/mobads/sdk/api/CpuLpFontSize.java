package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR("reg"),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");

    String mValue;

    public String getValue() {
        return this.mValue;
    }

    CpuLpFontSize(String str) {
        this.mValue = str;
    }
}
