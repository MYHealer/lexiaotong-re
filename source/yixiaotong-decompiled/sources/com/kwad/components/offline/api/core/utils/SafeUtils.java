package com.kwad.components.offline.api.core.utils;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SafeUtils {
    public static boolean isDebugPkg(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
