package com.miui.zeus.mimo.sdk.server.http;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public enum Error {
    CALLBACK(-2),
    UNKNOWN(-1),
    NETWORK(1),
    TIMEOUT(2),
    INVALID_RESPONSE(3),
    SERVER(4),
    NULL_RESPONSE(5),
    EXCEPTION(6),
    NO_CONTENT(101);

    private int mValue;

    Error(int i) {
        this.mValue = i;
    }

    public static Error valueOf(int i) {
        Error[] errorArrValues = values();
        for (int i2 = 0; i2 < 9; i2++) {
            Error error = errorArrValues[i2];
            if (i == error.mValue) {
                return error;
            }
        }
        return UNKNOWN;
    }

    public int value() {
        return this.mValue;
    }
}
