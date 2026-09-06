package com.kwad.library.solder.lib.d;

import android.os.Process;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static String aFB;
    private static String aFC;
    private static final Map<String, String> aFD;

    static {
        HashMap map = new HashMap();
        aFD = map;
        map.put("mips", "mips");
        map.put("mips64", "mips64");
        map.put("x86", "x86");
        map.put("x86_64", "x86_64");
        map.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        return Process.is64Bit();
    }

    public static String Ex() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
