package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class DecodedChar extends DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    char getValue() {
        return this.value;
    }

    boolean isFNC1() {
        return this.value == '$';
    }

    DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }
}
