package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class x {
    public static boolean k(File file) {
        return file != null && file.exists() && file.length() > 0 && file.getName().endsWith(".apk");
    }

    public static boolean a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(y.getFileMD5(file).toLowerCase());
    }
}
