package com.opos.mobad.service.b;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {
    public static int a(Context context, String str, com.opos.mobad.service.i.a<String> aVar) throws Throwable {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "prepare failed!zipPath or destPath is empty!";
        } else {
            if (new File(str).exists()) {
                File fileA = f.a(context, str);
                if (fileA == null) {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "prepare but null dirFile!");
                    return 2;
                }
                String absolutePath = fileA.getAbsolutePath();
                com.opos.cmn.an.f.a.c("Dynamic-ZipTool", "destPath:" + absolutePath);
                int i = 0;
                if (!fileA.exists()) {
                    fileA.mkdirs();
                } else if (!a(fileA)) {
                    return 0;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean zA = a(str, absolutePath);
                com.opos.cmn.an.f.a.c("Dynamic-ZipTool", "unzipFile result:" + zA);
                if (zA) {
                    if (aVar != null) {
                        aVar.a(absolutePath);
                    }
                    if (a(fileA)) {
                        a(absolutePath);
                        i = 4;
                    }
                } else {
                    a(absolutePath);
                    i = 3;
                }
                int i2 = i;
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "prepare result:", Boolean.valueOf(zA), "zipPath =", str, ",destPath:", absolutePath, ",costTime", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                return i2;
            }
            str2 = "prepare failed!zipPath not exist";
        }
        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", str2);
        return 1;
    }

    public static void a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                File file2 = new File(str + "_dirty");
                if (file2.exists()) {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "rn but exists");
                    d(file2);
                }
                if (file.renameTo(file2)) {
                    c(file2);
                } else {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "rn fail");
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "clear temp fail", th);
        }
    }

    public static boolean a(File file) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (!a(file2)) {
                    return false;
                }
            }
            com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "is dir empty " + file.getAbsolutePath());
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    public static boolean a(String str, String str2) throws Throwable {
        Exception e;
        Throwable th;
        if (com.opos.cmn.an.d.a.a(str) || com.opos.cmn.an.d.a.a(str2)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "zip file not exist!" + file.getAbsolutePath());
            return false;
        }
        ZipInputStream zipInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
                            try {
                                ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream, Charset.forName("gbk"));
                                try {
                                    boolean zA = a(zipInputStream2, new File(str2));
                                    checkedInputStream.close();
                                    fileInputStream.close();
                                    try {
                                        zipInputStream2.close();
                                    } catch (Exception e2) {
                                        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e2);
                                    }
                                    return zA;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        try {
                                            checkedInputStream.close();
                                        } catch (Throwable th4) {
                                            th.addSuppressed(th4);
                                        }
                                        throw th3;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            try {
                                throw th;
                            } catch (Throwable th7) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th8) {
                                    th.addSuppressed(th8);
                                }
                                throw th7;
                            }
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e);
                    if (0 != 0) {
                        return false;
                    }
                    try {
                        zipInputStream.close();
                        return false;
                    } catch (Exception e4) {
                        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e4);
                        return false;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e);
                if (0 != 0) {
                    return false;
                }
                zipInputStream.close();
                return false;
            } catch (Throwable th10) {
                th = th10;
                if (0 != 0) {
                    try {
                        zipInputStream.close();
                    } catch (Exception e6) {
                        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e6);
                    }
                }
                throw th;
            }
        } catch (Throwable th11) {
            th = th11;
        }
    }

    private static boolean a(ZipInputStream zipInputStream, File file) {
        return false;
    }

    private static void c(final File file) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.d(file);
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "clear succ");
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "clear temp fail", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                d(file2);
            }
        }
        file.delete();
    }
}
