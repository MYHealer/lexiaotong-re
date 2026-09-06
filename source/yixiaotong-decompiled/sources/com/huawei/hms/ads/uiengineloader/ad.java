package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3889a = "dl_FileUtil";

    public static String a(Context context) {
        return a(context.createDeviceProtectedStorageContext().getDataDir());
    }

    public static String a(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            af.d(f3889a, "getFilePath Exception: " + e.getMessage());
            return null;
        }
    }

    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e) {
            af.d(f3889a, "makeDirectory Exception: " + e.getMessage());
            return false;
        }
    }

    public static boolean b(String str) {
        boolean z;
        boolean z2 = true;
        try {
            File file = new File(str);
            String[] list = file.list();
            if (!file.isDirectory() || list == null || list.length <= 0) {
                z = true;
            } else {
                z = true;
                for (String str2 : list) {
                    try {
                        z = z && b(new StringBuilder().append(str).append(File.separator).append(str2).toString());
                    } catch (Throwable th) {
                        th = th;
                        z2 = z;
                        af.b(f3889a, " delete err: " + th.getClass().getSimpleName());
                        return z2;
                    }
                }
            }
            return z && file.delete();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) {
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf <= 0 ? str : str.substring(0, iLastIndexOf);
    }
}
