package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3891a = "_multiKitLoadNative";
    private static final String b = "com.huawei.hms.runtimekit.container.kitsdk.KitContext";
    private static ThreadPoolExecutor c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    private static String a(Context context) throws IOException {
        return context.createDeviceProtectedStorageContext().getFilesDir().getCanonicalPath() + File.separator + "modules";
    }

    public static String a(Context context, String str, String str2, PackageInfo packageInfo) {
        af.b(f3891a, " generaNewNativePath");
        if (!b(context)) {
            return str2;
        }
        if (!TextUtils.isEmpty(str2) && str2.contains(File.separator)) {
            return b(context, str, str2, packageInfo);
        }
        af.b(f3891a, "nativePath is empty or error");
        return str2;
    }

    private static void a(final String str, final int i, final boolean z) {
        c.execute(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.ag.1
            @Override // java.lang.Runnable
            public final void run() {
                File file = new File(str);
                String string = Integer.toString(i);
                if (ag.c(file)) {
                    for (File file2 : file.listFiles()) {
                        if (!z || !file2.getPath().contains(string)) {
                            af.b(ag.f3891a, (ag.d(file2) ? new StringBuilder(" delete success : ") : new StringBuilder(" delete failed : ")).append(file2.getName()).toString());
                        }
                    }
                }
            }
        });
    }

    private static void a(ZipFile zipFile, String str, PackageInfo packageInfo, boolean z) {
        aj.a(zipFile);
        try {
            if (TextUtils.isEmpty(str) || packageInfo.versionCode <= 0) {
                return;
            }
            a(str, packageInfo.versionCode, z);
        } catch (Exception unused) {
            af.c(f3891a, "IOException:");
        }
    }

    private static String b(Context context, String str, String str2, PackageInfo packageInfo) throws Throwable {
        String str3;
        ZipFile zipFile = null;
        try {
            str3 = (context.createDeviceProtectedStorageContext().getFilesDir().getCanonicalPath() + File.separator + "modules") + File.separator + packageInfo.packageName;
            try {
                try {
                    String strSubstring = str2.substring(str2.lastIndexOf(File.separator) + 1);
                    ZipFile zipFile2 = new ZipFile(str);
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                        HashSet hashSet = new HashSet();
                        ac.a(enumerationEntries, hashSet, strSubstring);
                        if (hashSet.size() <= 0) {
                            af.b(f3891a, "native is empty");
                            a(zipFile2, str3, packageInfo, true);
                            return str2;
                        }
                        String str4 = str3 + File.separator + packageInfo.versionCode + File.separator + "lib" + File.separator + strSubstring;
                        if (new File(str4).exists() || ac.a(zipFile2, hashSet, str4) == 0) {
                            a(zipFile2, str3, packageInfo, true);
                            return str4;
                        }
                        af.b(f3891a, "the apk decompress fail");
                        a(zipFile2, str3, packageInfo, false);
                        return str2;
                    } catch (Exception unused) {
                        zipFile = zipFile2;
                        af.c(f3891a, "catch IOException");
                        a(zipFile, str3, packageInfo, true);
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        a(zipFile, str3, packageInfo, true);
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            str3 = null;
        } catch (Throwable th3) {
            th = th3;
            str3 = null;
        }
    }

    private static boolean b(Context context) {
        try {
            return context.getClassLoader().loadClass(b) != null;
        } catch (ClassNotFoundException unused) {
            af.b(f3891a, "The cp is not hms kit.");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file) {
        return file.exists() && file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(File file) {
        boolean z;
        boolean z2 = false;
        if (c(file)) {
            z = true;
            for (File file2 : file.listFiles()) {
                z = z && d(file2);
            }
        } else {
            z = true;
        }
        if (!z) {
            return z;
        }
        if (z && file.delete()) {
            z2 = true;
        }
        return z2;
    }
}
