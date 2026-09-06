package com.kwad.sdk.api.loader;

import android.os.Process;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class ac {
    static boolean is64Bit() {
        return Process.is64Bit();
    }

    public static String Ex() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
