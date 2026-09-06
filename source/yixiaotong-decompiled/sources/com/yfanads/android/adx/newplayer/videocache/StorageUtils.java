package com.yfanads.android.adx.newplayer.videocache;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class StorageUtils {
    private static final String INDIVIDUAL_DIR_NAME = "video-cache";

    private static File getCacheDirectory(Context context, boolean z) {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            externalStorageState = "";
        }
        File externalCacheDir = (z && "mounted".equals(externalStorageState)) ? getExternalCacheDir(context) : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        Log.w("StorageUtils", "Can't define system cache directory! '" + str + "%s' will be used.");
        return new File(str);
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Log.w("StorageUtils", "Unable to create external cache directory");
        return null;
    }

    public static File getIndividualCacheDirectory(Context context) {
        return new File(getCacheDirectory(context, true), INDIVIDUAL_DIR_NAME);
    }
}
