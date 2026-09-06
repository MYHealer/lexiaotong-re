package com.jd.ad.sdk.jad_ir;

import android.text.TextUtils;
import java.util.Collection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_kx {
    public static <T> T jad_an(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("Argument must not be null");
    }

    public static <T> T jad_an(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static String jad_an(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    public static <T extends Collection<Y>, Y> T jad_an(T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    public static void jad_an(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
