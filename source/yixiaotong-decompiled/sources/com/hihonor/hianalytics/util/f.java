package com.hihonor.hianalytics.util;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class f {
    public static String a() throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        return context == null ? "" : context.getFilesDir().getPath();
    }

    public static String a(String str) throws IllegalAccessException, InvocationTargetException {
        InputStream inputStreamOpen;
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "loadAssetFileContent illegal fileName=" + str;
        } else {
            Context context = SystemUtils.getContext();
            if (context == null) {
                str2 = "loadAssetFileContent context null";
            } else {
                try {
                    inputStreamOpen = context.getResources().getAssets().open(str);
                    try {
                        String strA = j.a(inputStreamOpen, 2048);
                        k.a(inputStreamOpen);
                        return strA;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            j2.g("FileUtils", "loadAssetFileContent failWithEx=" + SystemUtils.getDesensitizedException(th));
                            return null;
                        } finally {
                            k.a(inputStreamOpen);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamOpen = null;
                }
            }
        }
        j2.g("FileUtils", str2);
        return null;
    }

    public static boolean a(File file) {
        StringBuilder sb;
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e = e;
                sb = new StringBuilder("forceCreateFile failE=");
            }
        } else {
            if (file.isFile()) {
                return true;
            }
            try {
                return b(file) && file.createNewFile();
            } catch (IOException e2) {
                e = e2;
                sb = new StringBuilder("forceCreateFile fail2E=");
            }
        }
        j2.g("FileUtils", sb.append(SystemUtils.getDesensitizedException(e)).toString());
        return false;
    }

    public static boolean a(File file, String str) {
        if (str != null) {
            return a(file, str.getBytes(com.hihonor.hianalytics.hnha.i.f3644a));
        }
        j2.g("FileUtils", "saveInfoToFile info null");
        return false;
    }

    public static boolean a(File file, byte[] bArr) throws Throwable {
        if (bArr == null) {
            j2.g("FileUtils", "saveDataToFile empty data");
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    k.a(fileOutputStream2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    j2.g("FileUtils", "saveDataToFile failE=" + SystemUtils.getDesensitizedException(e));
                    k.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    k.a(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                b(file2);
            }
        }
        return file.delete();
    }

    public static String c(File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    c cVar = new c(1024);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        cVar.a(bArr, i);
                    }
                    if (cVar.b() == 0) {
                        k.a(fileInputStream2);
                        return "";
                    }
                    String str = new String(cVar.a(), com.hihonor.hianalytics.hnha.i.f3644a);
                    k.a(fileInputStream2);
                    return str;
                } catch (IOException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    j2.g("FileUtils", "getInfoFromFile failE=" + SystemUtils.getDesensitizedException(e));
                    k.a(fileInputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    k.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }
}
