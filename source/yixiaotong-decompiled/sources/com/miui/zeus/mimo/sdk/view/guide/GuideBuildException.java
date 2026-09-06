package com.miui.zeus.mimo.sdk.view.guide;

import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GuideBuildException extends RuntimeException {
    private final String mDetailMessage;

    public GuideBuildException() {
        this.mDetailMessage = s.d(new byte[]{119, 1, 93, 93, 75, 3, 13, 68, 3, 16, 67, 10, 66, 74}, "0d389b");
    }

    public GuideBuildException(String str) {
        this.mDetailMessage = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return s.d(new byte[]{114, Ascii.DC4, 8, 95, 0, 16, 38, 17, 15, 6, 84, 35, 66, 0, 6, 94, 1, 94, Ascii.NAK, 68, 0, 3, 88, 9, 85, 5, 91, 19}, "0aa3d0") + this.mDetailMessage;
    }
}
