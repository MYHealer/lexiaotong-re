package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    public static boolean cM(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy() && !be.useStoragePermissionDisable();
        } catch (Throwable unused) {
        }
    }
}
