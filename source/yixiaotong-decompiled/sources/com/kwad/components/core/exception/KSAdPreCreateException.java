package com.kwad.components.core.exception;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class KSAdPreCreateException extends RuntimeException {
    private static final String LIBRARY_VERSION = ". Version: 5.4.10.1";

    public KSAdPreCreateException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public KSAdPreCreateException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }
}
