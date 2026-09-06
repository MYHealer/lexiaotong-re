package com.fancy;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o9 {
    public static File _a(Context context) {
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            externalCacheDir = new File(_ie._a("/data/data/").append(context.getPackageName()).append("/cache/").toString());
        }
        return new File(externalCacheDir, "video-cache");
    }
}
