package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
@ElementTypesAreNonnullByDefault
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@CheckForNull String str) {
        super(str);
    }

    public VerifyException(@CheckForNull Throwable th) {
        super(th);
    }

    public VerifyException(@CheckForNull String str, @CheckForNull Throwable th) {
        super(str, th);
    }
}
