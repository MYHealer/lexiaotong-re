package com.google.zxing;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class FormatException extends ReaderException {
    private static final FormatException instance = new FormatException();

    public static FormatException getFormatInstance() {
        return instance;
    }

    private FormatException() {
    }
}
