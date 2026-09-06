package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import java.io.File;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5416a = ijiami_1011.s.s.s.d(new byte[]{92, 5}, "924155");
    public static final String[] b = {ijiami_1011.s.s.s.d(new byte[]{84, 88, 83, 4, 94, 91, 17, 1, 1, Base64.padSymbol, 87, 10, 74, 110, 92, 11, 72, 90, 0, Ascii.GS, 3, 16, 66, 1, 83, Ascii.US, 66, 13}, "811b86"), ijiami_1011.s.s.s.d(new byte[]{91, 89, 87, SignedBytes.MAX_POWER_OF_TWO, 15, 84, 11, 10, 15, 76, 66, 10}, "7056c7"), ijiami_1011.s.s.s.d(new byte[]{9, 95, 82, 92, 13, 89, 13, 11, 7, 6, 84, Ascii.ETB, 75, 69, 95}, "e606c0")};
    public static boolean c;
    public static volatile e7 d;

    public boolean a(MimoAdInfo mimoAdInfo) {
        if (mimoAdInfo == null || !mimoAdInfo.Q0) {
            return false;
        }
        if (c) {
            return true;
        }
        File file = new File(y8.f5752a.getFilesDir(), ijiami_1011.s.s.s.d(new byte[]{65, 95, 2, Ascii.GS, 6, 74}, "13cdc8"));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file.getAbsolutePath());
        if (!a(file2)) {
            return false;
        }
        try {
            c = false;
            v6.a(y8.f5752a.getClassLoader(), file2);
            for (String str : b) {
                System.loadLibrary(str.replaceAll(ijiami_1011.s.s.s.d(new byte[]{75, 70, 87}, "e5816f"), "").replaceAll(ijiami_1011.s.s.s.d(new byte[]{93, 88, 6}, "11dbc2"), ""));
            }
            c = true;
            m.b(f5416a, ijiami_1011.s.s.s.d(new byte[]{32, 13, Ascii.ETB, 74, 77, 16, 13, 11, 7, 6, 17, Ascii.GS, 15, 5, 10, 84, 80, 99, 14, 68, Ascii.NAK, Ascii.ETB, 82, 6, 3, Ascii.ETB, Ascii.SYN}, "fde990"));
            return true;
        } catch (Throwable th) {
            c = false;
            m.c(f5416a, ijiami_1011.s.s.s.d(new byte[]{37, 89, 70, 65, 70, 65, 13, 11, 7, 6, 17, Ascii.GS, 10, 81, 91, 95, 91, 50, 14, 68, 0, 3, 88, 9, 79}, "c0422a"), th);
            return false;
        }
    }

    public final boolean a(File file) {
        for (String str : b) {
            File file2 = new File(file, str);
            if (!file2.exists() || !file2.isFile()) {
                return false;
            }
        }
        return true;
    }
}
