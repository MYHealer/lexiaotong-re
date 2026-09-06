package com.google.zxing;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class NotFoundException extends ReaderException {
    private static final NotFoundException instance = new NotFoundException();

    public static NotFoundException getNotFoundInstance() {
        return instance;
    }

    private NotFoundException() {
    }
}
