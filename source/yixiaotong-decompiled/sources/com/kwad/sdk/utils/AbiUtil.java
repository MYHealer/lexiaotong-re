package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class AbiUtil {
    private static Abi boc;

    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String cK(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean isArm64(Context context) {
        return cL(context) == Abi.ARM64_V8A;
    }

    private static Abi cL(Context context) {
        Abi abi = boc;
        if (abi != null) {
            return abi;
        }
        Abi abi2 = Process.is64Bit() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        boc = abi2;
        return abi2;
    }
}
