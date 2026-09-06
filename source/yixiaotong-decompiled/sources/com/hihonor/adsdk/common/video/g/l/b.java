package com.hihonor.adsdk.common.video.g.l;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsa = "StorageUtils";
    private static final String hnadsb = "video-cache";

    private static File hnadsa(Context context, boolean z) {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getCacheDirectory, NullPointerException: " + e.getMessage(), new Object[0]);
            externalStorageState = "";
        }
        File fileHnadsa = (z && "mounted".equals(externalStorageState)) ? hnadsa(context) : null;
        if (fileHnadsa == null) {
            fileHnadsa = context.getCacheDir();
        }
        if (fileHnadsa != null) {
            return fileHnadsa;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "Can't define system cache directory! '" + str + "%s' will be used.", new Object[0]);
        return new File(str);
    }

    public static File hnadsb(Context context) {
        return new File(hnadsa(context, true), hnadsb);
    }

    private static File hnadsa(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "Unable to create external cache directory", new Object[0]);
        return null;
    }
}
