package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);

    final int c;

    ErrorBehaviour(int i) {
        this.c = i;
    }
}
