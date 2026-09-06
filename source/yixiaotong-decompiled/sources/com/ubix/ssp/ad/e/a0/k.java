package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.system.Os;
import android.text.TextUtils;
import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8707a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static volatile File e;
    private static volatile File f;

    class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return k.b(file) < k.b(file2) ? 1 : -1;
        }
    }

    public static String a(double d2) {
        StringBuilder sbAppend;
        String str;
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            sbAppend = new StringBuilder().append(d2);
            str = "B";
        } else {
            double d4 = d3 / 1024.0d;
            if (d4 < 1.0d) {
                sbAppend = new StringBuilder().append(new BigDecimal(Double.toString(d3)).setScale(2, 4).toPlainString());
                str = "KB";
            } else {
                double d5 = d4 / 1024.0d;
                if (d5 < 1.0d) {
                    sbAppend = new StringBuilder().append(new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString());
                    str = "MB";
                } else {
                    double d6 = d5 / 1024.0d;
                    if (d6 < 1.0d) {
                        sbAppend = new StringBuilder().append(new BigDecimal(Double.toString(d5)).setScale(2, 4).toPlainString());
                        str = "GB";
                    } else {
                        sbAppend = new StringBuilder().append(new BigDecimal(d6).setScale(2, 4).toPlainString());
                        str = "TB";
                    }
                }
            }
        }
        return sbAppend.append(str).toString();
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String strA = com.ubix.ssp.ad.e.a0.d0.a.a(context);
        d = strA;
        return strA;
    }

    public static void a(String str, long j) {
        File[] fileArrA;
        if (TextUtils.isEmpty(str) || (fileArrA = a(str)) == null || fileArrA.length <= 0) {
            return;
        }
        long length = 0;
        for (int i = 0; i < fileArrA.length; i++) {
            length += fileArrA[i].length();
            if (length > j) {
                File[] fileArr = (File[]) Arrays.copyOfRange(fileArrA, i, fileArrA.length);
                if (fileArr != null) {
                    a(fileArr);
                    return;
                }
                return;
            }
        }
    }

    public static void a(File[] fileArr) {
        for (File file : fileArr) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    public static File[] a(String str) {
        File[] fileArrListFiles;
        File file = new File(str);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        Arrays.sort(fileArrListFiles, new a());
        return fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(File file) {
        try {
            return Os.stat(file.getPath()).st_atime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static File b(Context context) {
        if (e != null) {
            return e;
        }
        File cacheDir = context.getCacheDir();
        e = cacheDir;
        return cacheDir;
    }

    public static File c(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return new File(b);
        }
        d = a(context);
        b = d + "/download";
        File file = new File(b);
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static File d(Context context) {
        if (f != null) {
            return f;
        }
        File externalCacheDir = context.getExternalCacheDir();
        f = externalCacheDir;
        return externalCacheDir;
    }

    public static File e(Context context) {
        if (!TextUtils.isEmpty(f8707a)) {
            return new File(f8707a);
        }
        d = a(context);
        f8707a = d + "/imgCache";
        File file = new File(f8707a);
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static File f(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return new File(c);
        }
        d = a(context);
        c = d + "/videoCache";
        File file = new File(c);
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }
}
