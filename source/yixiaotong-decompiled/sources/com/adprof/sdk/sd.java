package com.adprof.sdk;

import android.webkit.ConsoleMessage;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract /* synthetic */ class sd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1420a;

    static {
        int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
        f1420a = iArr;
        try {
            iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
    }
}
