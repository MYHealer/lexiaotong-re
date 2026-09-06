package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    int getCount() {
        return this.count;
    }

    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    void incrementCount() {
        this.count++;
    }

    Pair(int i, int i2, FinderPattern finderPattern) {
        super(i, i2);
        this.finderPattern = finderPattern;
    }
}
