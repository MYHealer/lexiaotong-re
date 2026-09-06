package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
abstract class DecodedObject {
    private final int newPosition;

    final int getNewPosition() {
        return this.newPosition;
    }

    DecodedObject(int i) {
        this.newPosition = i;
    }
}
