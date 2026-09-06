package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ZipUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4577a = "ZipUtil";
    private static final int b = 104857600;
    private static final int c = 100;
    private static final int d = 4096;
    private static final String e = "../";
    private static final String f = "..\\";

    /* JADX WARN: Code duplicated, block: B:79:0x0131  */
    private static List<File> a(File file, File file2, long j, boolean z) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        ZipFile zipFile = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream = null;
        zipFile = null;
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = true;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                int i = 0;
                while (true) {
                    if (!enumerationEntries.hasMoreElements()) {
                        z2 = z3;
                        break;
                    }
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        String name = zipEntryNextElement.getName();
                        if (!TextUtils.isEmpty(name)) {
                            String strNormalize = Normalizer.normalize(name, Normalizer.Form.NFKC);
                            if (e(strNormalize)) {
                                Log.e(f4577a, "zipPath is a invalid path: " + d(strNormalize));
                                break;
                            }
                            File file3 = new File(file2, strNormalize.replaceAll("\\\\", "/"));
                            if (z && file3.exists() && file3.isFile()) {
                                e(file3);
                            }
                            arrayList.add(file3);
                            if (zipEntryNextElement.isDirectory()) {
                                if (!a(file3)) {
                                    IOUtil.closeSecure(zipFile2);
                                    a(arrayList);
                                    return null;
                                }
                            } else {
                                if (!b(file3)) {
                                    IOUtil.closeSecure(zipFile2);
                                    a(arrayList);
                                    return null;
                                }
                                try {
                                    bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntryNextElement));
                                    try {
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                                        try {
                                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                                            try {
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int i2 = bufferedInputStream.read(bArr);
                                                    if (i2 == -1) {
                                                        break;
                                                    }
                                                    i += i2;
                                                    if (i > j) {
                                                        Log.e(f4577a, "unzipFileNew: over than top size");
                                                        z3 = false;
                                                        break;
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, i2);
                                                }
                                                IOUtil.closeSecure((InputStream) bufferedInputStream);
                                                IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                                IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                            } catch (Throwable th) {
                                                th = th;
                                                fileOutputStream = fileOutputStream2;
                                                IOUtil.closeSecure((InputStream) bufferedInputStream);
                                                IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                                IOUtil.closeSecure((OutputStream) fileOutputStream);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            bufferedOutputStream = null;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedOutputStream = null;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    bufferedInputStream = null;
                                    bufferedOutputStream = null;
                                }
                            }
                        }
                    } catch (IllegalArgumentException unused) {
                        Log.e(f4577a, "entries.nextElement IllegalArgumentException");
                    }
                }
                IOUtil.closeSecure(zipFile2);
                if (!z2) {
                    a(arrayList);
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
                try {
                    Log.e(f4577a, "unzip new IOException : " + e.getMessage());
                    IOUtil.closeSecure(zipFile);
                    a(arrayList);
                } catch (Throwable th5) {
                    th = th5;
                    z3 = z2;
                    IOUtil.closeSecure(zipFile);
                    if (!z3) {
                        a(arrayList);
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                z2 = true;
                zipFile = zipFile2;
                z3 = z2;
                IOUtil.closeSecure(zipFile);
                if (!z3) {
                    a(arrayList);
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Throwable th7) {
            th = th7;
            IOUtil.closeSecure(zipFile);
            if (!z3) {
                a(arrayList);
            }
            throw th;
        }
        return arrayList;
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(f4577a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    private static String d(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(iLastIndexOf + 1);
    }

    private static void e(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            c(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                c(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                e(file2);
            }
            c(file);
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, 104857600L, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, 104857600L, 100, z);
    }

    private static void c(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(f4577a, "delete file error");
    }

    /* JADX WARN: Code duplicated, block: B:92:0x0164  */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static boolean unZip(String str, String str2, long j, int i, boolean z) throws Throwable {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        int i2;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream;
        boolean z2;
        FileOutputStream fileOutputStream3;
        String strSubstring = str2;
        int i3 = 0;
        if (!a(str, str2, j, i)) {
            return false;
        }
        if (strSubstring.endsWith(File.separator) && str2.length() > File.separator.length()) {
            strSubstring = strSubstring.substring(0, str2.length() - File.separator.length());
        }
        int i4 = 4096;
        byte[] bArr = new byte[4096];
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
                int i5 = 0;
                int i6 = 1;
                fileOutputStream2 = null;
                try {
                    while (true) {
                        try {
                            try {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry == null) {
                                    i2 = i3;
                                    break;
                                }
                                String strReplaceAll = nextEntry.getName().replaceAll("\\\\", "/");
                                File file = new File(strSubstring, strReplaceAll);
                                String strNormalize = Normalizer.normalize(strReplaceAll, Normalizer.Form.NFKC);
                                if (e(strNormalize)) {
                                    Log.e(f4577a, "zipPath is a invalid path: " + d(strNormalize));
                                    i2 = i3;
                                    i6 = i2;
                                    break;
                                }
                                if (z && file.exists() && file.isFile()) {
                                    e(file);
                                }
                                if (nextEntry.isDirectory()) {
                                    d(file);
                                    arrayList.add(file);
                                    i2 = i3;
                                } else {
                                    File parentFile = file.getParentFile();
                                    if (parentFile != null && !parentFile.exists()) {
                                        d(parentFile);
                                    }
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                        while (true) {
                                            try {
                                                try {
                                                    int i7 = zipInputStream.read(bArr, i3, i4);
                                                    if (i7 == -1) {
                                                        i2 = i3;
                                                        break;
                                                    }
                                                    i5 += i7;
                                                    if (i5 > j) {
                                                        try {
                                                            Log.e(f4577a, "unzip  over than top size");
                                                            i2 = 0;
                                                            i6 = 0;
                                                            break;
                                                        } catch (IOException e2) {
                                                            e = e2;
                                                            fileOutputStream3 = fileOutputStream;
                                                            i2 = 0;
                                                            fileOutputStream = fileOutputStream3;
                                                            fileInputStream2 = fileInputStream;
                                                            LogsUtil.e(f4577a, "Unzip IOException : " + e.getMessage());
                                                            z2 = i2;
                                                            fileInputStream = fileInputStream2;
                                                            bufferedOutputStream2 = bufferedOutputStream;
                                                            fileOutputStream2 = fileOutputStream;
                                                            a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                                            if (z2 == 0) {
                                                                a(arrayList);
                                                            }
                                                            return z2;
                                                        }
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, i7);
                                                    i3 = 0;
                                                    i4 = 4096;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    fileInputStream2 = fileInputStream;
                                                    a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                                    throw th;
                                                }
                                            } catch (IOException e3) {
                                                e = e3;
                                                i2 = i3;
                                            }
                                        }
                                        try {
                                            arrayList.add(file);
                                            bufferedOutputStream.flush();
                                            IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                            IOUtil.closeSecure((OutputStream) fileOutputStream);
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            fileOutputStream2 = fileOutputStream;
                                        } catch (IOException e4) {
                                            e = e4;
                                            fileOutputStream3 = fileOutputStream;
                                            fileOutputStream = fileOutputStream3;
                                            fileInputStream2 = fileInputStream;
                                            LogsUtil.e(f4577a, "Unzip IOException : " + e.getMessage());
                                            z2 = i2;
                                            fileInputStream = fileInputStream2;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            fileOutputStream2 = fileOutputStream;
                                            a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                            if (z2 == 0) {
                                                a(arrayList);
                                            }
                                            return z2;
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                        i2 = i3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        fileInputStream2 = fileInputStream;
                                        a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                        throw th;
                                    }
                                }
                                try {
                                    zipInputStream.closeEntry();
                                    i3 = i2;
                                    i4 = 4096;
                                } catch (IOException e6) {
                                    e = e6;
                                    FileOutputStream fileOutputStream4 = fileOutputStream2;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    fileOutputStream3 = fileOutputStream4;
                                    fileOutputStream = fileOutputStream3;
                                    fileInputStream2 = fileInputStream;
                                    LogsUtil.e(f4577a, "Unzip IOException : " + e.getMessage());
                                    z2 = i2;
                                    fileInputStream = fileInputStream2;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                    if (z2 == 0) {
                                        a(arrayList);
                                    }
                                    return z2;
                                }
                                fileOutputStream = fileOutputStream2;
                                bufferedOutputStream = bufferedOutputStream2;
                                fileInputStream2 = fileInputStream;
                                try {
                                    LogsUtil.e(f4577a, "Unzip IOException : " + e.getMessage());
                                    z2 = i2;
                                    fileInputStream = fileInputStream2;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                    if (z2 == 0) {
                                        a(arrayList);
                                    }
                                    return z2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                    throw th;
                                }
                            } catch (IOException e7) {
                                e = e7;
                                i2 = i3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                    IOUtil.closeSecure((InputStream) zipInputStream);
                    IOUtil.closeSecure((InputStream) fileInputStream);
                    z2 = i6;
                } catch (IOException e8) {
                    e = e8;
                    fileOutputStream = fileOutputStream2;
                    bufferedOutputStream = bufferedOutputStream2;
                    fileInputStream2 = fileInputStream;
                    LogsUtil.e(f4577a, "Unzip IOException : " + e.getMessage());
                    z2 = i2;
                    fileInputStream = fileInputStream2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    fileOutputStream2 = fileOutputStream;
                }
            } catch (IOException e9) {
                e = e9;
                i2 = 0;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            }
        } catch (IOException e10) {
            e = e10;
            i2 = 0;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
        a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
        if (z2 == 0) {
            a(arrayList);
        }
        return z2;
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        if (!a(str, str2, j, i)) {
            return null;
        }
        if (str2.endsWith(File.separator) && str2.length() > File.separator.length()) {
            str2 = str2.substring(0, str2.length() - File.separator.length());
        }
        return a(c(str), c(str2), j, z);
    }

    private static void d(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(f4577a, "mkdirs error , files exists or IOException.");
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.contains(e) || str.contains(f) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
        }
        Log.e(f4577a, "isContainInvalidStr: name is null");
        return true;
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str) || !e(str)) {
            return;
        }
        Log.e(f4577a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x0073
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static boolean a(java.lang.String r11, long r12, int r14) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "ZipUtil"
            r2 = 0
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52
            java.util.Enumeration r11 = r4.entries()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            r5 = 0
            r2 = r3
        L12:
            boolean r7 = r11.hasMoreElements()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            r8 = 1
            if (r7 == 0) goto L45
            java.lang.Object r7 = r11.nextElement()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            long r9 = r7.getSize()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            long r5 = r5 + r9
            int r2 = r2 + r8
            java.lang.String r8 = r7.getName()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            boolean r8 = e(r8)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            if (r8 != 0) goto L3f
            if (r2 >= r14) goto L3f
            int r8 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r8 > 0) goto L3f
            long r7 = r7.getSize()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            r9 = -1
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L12
        L3f:
            java.lang.String r11 = "File name is invalid or too many files or too big"
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r11)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            goto L46
        L45:
            r3 = r8
        L46:
            r4.close()     // Catch: java.io.IOException -> L73
            goto L76
        L4a:
            r11 = move-exception
            r2 = r4
            goto L77
        L4d:
            r11 = move-exception
            r2 = r4
            goto L53
        L50:
            r11 = move-exception
            goto L77
        L52:
            r11 = move-exception
        L53:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r12.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r13 = "not a valid zip file, IOException : "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch: java.lang.Throwable -> L50
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> L50
            java.lang.StringBuilder r11 = r12.append(r11)     // Catch: java.lang.Throwable -> L50
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L50
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r11)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L76
            r2.close()     // Catch: java.io.IOException -> L73
            goto L76
        L73:
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)
        L76:
            return r3
        L77:
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.io.IOException -> L7d
            goto L80
        L7d:
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)
        L80:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.lang.String, long, int):boolean");
    }

    private static boolean a(String str, String str2, long j, int i) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !e(str)) {
            if (!TextUtils.isEmpty(str2) && !e(str2)) {
                if (a(str, j, i)) {
                    return true;
                }
                LogsUtil.e(f4577a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(f4577a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(f4577a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(f4577a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
