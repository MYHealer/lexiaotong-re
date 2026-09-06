package com.adprof.sdk;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f1258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f415a;
    public static String b;

    public static File a() {
        if (f1258a == null) {
            File file = new File(b, "downloadApk");
            f1258a = file;
            if (!file.exists()) {
                f1258a.mkdirs();
            }
        }
        return f1258a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m667a() {
        String str = b + File.separator + "downloadLog";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String b() {
        String str = f415a + File.separator + "video";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }
}
