package com.google.zxing;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class ChecksumException extends ReaderException {
    private static final ChecksumException instance = new ChecksumException();

    public static ChecksumException getChecksumInstance() {
        return instance;
    }

    private ChecksumException() {
    }
}
