package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.hihonor.hianalytics.util.SystemUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f3692a = new Object();

    private static long a(File file, String str) {
        try {
            if (file.exists() && (TextUtils.isEmpty(str) || file.getName().contains(str))) {
                return file.length();
            }
        } catch (Exception e) {
            j2.b(com.huawei.openalliance.ad.utils.u.Code, "getFileSize:" + SystemUtils.getDesensitizedException(e));
        }
        return 0L;
    }

    public static List<String> a(Context context) {
        return com.hihonor.hianalytics.util.d.a(context);
    }

    private static boolean a(Context context, String str) {
        File file = new File(context.getFilesDir(), c(context, str));
        if (!file.exists()) {
            j2.c(com.huawei.openalliance.ad.utils.u.Code, "cached file not found");
            return false;
        }
        long length = file.length();
        if (length <= CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            return true;
        }
        j2.c(com.huawei.openalliance.ad.utils.u.Code, "v1 cached file size overlarge - file len: %d limitedSize: %d", Long.valueOf(length), Long.valueOf(CacheDataSink.DEFAULT_FRAGMENT_SIZE));
        return false;
    }

    public static boolean a(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    j2.c(com.huawei.openalliance.ad.utils.u.Code, "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                a(file2);
            }
        }
        return file.delete();
    }

    public static boolean a(String str) {
        j2.c(com.huawei.openalliance.ad.utils.u.Code, "deleteComponentFile");
        return a(new File(str));
    }

    public static long b(File file, String str) {
        long jB = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return 0L;
            }
            for (File file2 : fileArrListFiles) {
                jB += file2.isDirectory() ? b(file2, str) : a(file2, str);
            }
        } catch (Exception e) {
            j2.b(com.huawei.openalliance.ad.utils.u.Code, "getFileSizes:" + SystemUtils.getDesensitizedException(e));
        }
        return jB;
    }

    public static void b(Context context, String str) {
        synchronized (f3692a) {
            context.deleteFile(c(context, str));
        }
    }

    public static void b(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            if (file.delete()) {
                return;
            }
            j2.g(com.huawei.openalliance.ad.utils.u.Code, "remover file fail!");
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            j2.g(com.huawei.openalliance.ad.utils.u.Code, "not have file remove!");
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                b(file2);
            } else if (!file2.delete()) {
                j2.b(com.huawei.openalliance.ad.utils.u.Code, "remover file fail!");
            }
        }
    }

    private static String c(Context context, String str) {
        return "hianalytics_" + str + "_" + context.getPackageName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileInputStream] */
    public static String d(Context context, String str) {
        FileInputStream fileInputStreamOpenFileInput;
        ?? r1 = 0;
        if (!a(context, str)) {
            return null;
        }
        synchronized (f3692a) {
            try {
                try {
                    com.hihonor.hianalytics.util.c cVar = new com.hihonor.hianalytics.util.c(2048);
                    fileInputStreamOpenFileInput = context.openFileInput(c(context, str));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = fileInputStreamOpenFileInput.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            cVar.a(bArr, i);
                            throw th;
                        }
                        if (cVar.b() == 0) {
                            if (fileInputStreamOpenFileInput != null) {
                                try {
                                    fileInputStreamOpenFileInput.close();
                                } catch (IOException unused) {
                                    j2.g(com.huawei.openalliance.ad.utils.u.Code, "IOException happened when getInfoFromFile's FileOutputStream close");
                                }
                            }
                            return null;
                        }
                        String str2 = new String(cVar.a(), i.f3644a);
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused2) {
                                j2.g(com.huawei.openalliance.ad.utils.u.Code, "IOException happened when getInfoFromFile's FileOutputStream close");
                            }
                        }
                        return str2;
                    } catch (FileNotFoundException unused3) {
                        j2.g(com.huawei.openalliance.ad.utils.u.Code, "getInfoFromFile(): is not found file");
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused4) {
                                j2.g(com.huawei.openalliance.ad.utils.u.Code, "IOException happened when getInfoFromFile's FileOutputStream close");
                            }
                        }
                        return null;
                    } catch (IOException unused5) {
                        j2.g(com.huawei.openalliance.ad.utils.u.Code, "getInfoFromFile(): IOException");
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused6) {
                                j2.g(com.huawei.openalliance.ad.utils.u.Code, "IOException happened when getInfoFromFile's FileOutputStream close");
                            }
                        }
                        return null;
                    }
                } catch (FileNotFoundException unused7) {
                    fileInputStreamOpenFileInput = null;
                } catch (IOException unused8) {
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException unused9) {
                            j2.g(com.huawei.openalliance.ad.utils.u.Code, "IOException happened when getInfoFromFile's FileOutputStream close");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = context;
            }
            throw th;
        }
    }
}
