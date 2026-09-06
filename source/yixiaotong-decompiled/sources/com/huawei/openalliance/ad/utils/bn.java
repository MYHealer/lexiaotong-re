package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.dv;
import com.huawei.hms.ads.fh;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class bn {
    private static final String B = "../";
    private static final String C = "..\\";
    private static final String Code = "ZipUtil";
    private static final int I = 100;
    private static final int V = 524288000;
    private static final int Z = 4096;

    private static String Code(String str) throws Throwable {
        String str2 = "UTF-8";
        ZipFile zipFile = null;
        try {
            try {
                try {
                    ZipFile zipFile2 = new ZipFile(str);
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                        while (enumerationEntries.hasMoreElements()) {
                            try {
                                enumerationEntries.nextElement();
                            } catch (Exception unused) {
                                fh.I(Code, "zipFile format exception");
                                str2 = "GBK";
                                zipFile2.close();
                                return str2;
                            }
                        }
                        zipFile2.close();
                    } catch (IOException unused2) {
                        zipFile = zipFile2;
                        fh.I(Code, "zipFile create exception");
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused3) {
                                fh.Z(Code, "close zipFile IOException ");
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                    fh.Z(Code, "close zipFile IOException ");
                }
            } catch (IOException unused5) {
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void Code(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            V(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                V(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                Code(file2);
            }
            V(file);
        }
    }

    private static void Code(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        bb.Code((Closeable) fileInputStream);
        bb.Code(bufferedOutputStream);
        bb.Code((Closeable) zipInputStream);
        bb.Code(fileOutputStream);
    }

    private static boolean Code(String str, int i, int i2) throws Throwable {
        ZipFile zipFile = null;
        boolean z = false;
        try {
            try {
                try {
                    ZipFile zipFile2 = new ZipFile(str, Charset.forName(Code(str)));
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                        long size = 0;
                        int i3 = 0;
                        while (true) {
                            if (!enumerationEntries.hasMoreElements()) {
                                z = true;
                                break;
                            }
                            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                            size += zipEntryNextElement.getSize();
                            i3++;
                            if (V(zipEntryNextElement.getName()) || i3 >= i2 || size > i || zipEntryNextElement.getSize() == -1) {
                                fh.Z(Code, "File name is invalid or too many files or too big");
                                break;
                            }
                        }
                        zipFile2.close();
                    } catch (Exception e) {
                        e = e;
                        zipFile = zipFile2;
                        fh.Z(Code, "not a valid zip file, IOException : " + e.getClass().getSimpleName());
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused) {
                                fh.Z(Code, "close zipFile IOException ");
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
            fh.Z(Code, "close zipFile IOException ");
        }
    }

    private static boolean Code(String str, String str2, int i, int i2) {
        String str3;
        if (TextUtils.isEmpty(str) || V(str)) {
            str3 = "zip file is not valid";
        } else {
            if (!TextUtils.isEmpty(str2) && !V(str2)) {
                if (Code(str, i, i2)) {
                    return true;
                }
                fh.Z(Code, "zip file contains valid chars or too many files");
                throw new dv("unsecure zipfile!");
            }
            str3 = "target directory is not valid";
        }
        fh.Z(Code, str3);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0133  */
    public static boolean Code(String str, String str2, int i, int i2, boolean z) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        ZipInputStream zipInputStream;
        FileOutputStream fileOutputStream;
        boolean z2;
        String strSubstring = str2;
        boolean z3 = false;
        if (!Code(str, str2, i, i2)) {
            return false;
        }
        if (strSubstring.endsWith(File.separator) && str2.length() > File.separator.length()) {
            strSubstring = strSubstring.substring(0, str2.length() - File.separator.length());
        }
        byte[] bArr = new byte[4096];
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream2), Charset.forName(Code(str)));
                FileOutputStream fileOutputStream2 = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            z2 = true;
                            break;
                        }
                        String name = nextEntry.getName();
                        if (V(name)) {
                            fh.I(Code, "File name is invalid");
                            z2 = false;
                            break;
                        }
                        File file = new File(strSubstring + File.separator + name);
                        if (z && file.exists()) {
                            Code(file);
                        }
                        if (nextEntry.isDirectory()) {
                            I(file);
                            arrayList.add(file);
                        } else {
                            File parentFile = file.getParentFile();
                            if (parentFile != null && !parentFile.exists()) {
                                I(parentFile);
                            }
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                int i3 = 0;
                                while (i3 + 4096 <= i) {
                                    try {
                                        int i4 = zipInputStream.read(bArr, 0, 4096);
                                        if (i4 == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, i4);
                                        i3 += i4;
                                    } catch (IOException e) {
                                        e = e;
                                        fileInputStream = fileInputStream2;
                                        try {
                                            fh.Z(Code, "Unzip IOException : " + e.getClass().getSimpleName());
                                            Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                            if (!z3) {
                                                Code(arrayList);
                                            }
                                            return z3;
                                        } catch (Throwable th) {
                                            th = th;
                                            Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileInputStream = fileInputStream2;
                                        Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                        throw th;
                                    }
                                }
                                arrayList.add(file);
                                bufferedOutputStream.flush();
                                bb.Code(bufferedOutputStream);
                                bb.Code(fileOutputStream);
                                bufferedOutputStream2 = bufferedOutputStream;
                                fileOutputStream2 = fileOutputStream;
                            } catch (IOException e2) {
                                e = e2;
                                bufferedOutputStream = bufferedOutputStream2;
                                fileInputStream = fileInputStream2;
                                fh.Z(Code, "Unzip IOException : " + e.getClass().getSimpleName());
                                Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                if (!z3) {
                                    Code(arrayList);
                                }
                                return z3;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedOutputStream = bufferedOutputStream2;
                                fileInputStream = fileInputStream2;
                                Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                throw th;
                            }
                        }
                        zipInputStream.closeEntry();
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = fileOutputStream2;
                    }
                }
                bb.Code((Closeable) zipInputStream);
                bb.Code((Closeable) fileInputStream2);
                Code(fileInputStream2, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                z3 = z2;
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = null;
                zipInputStream = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                zipInputStream = null;
                fileOutputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedOutputStream = null;
            zipInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream = null;
            zipInputStream = null;
            fileOutputStream = null;
        }
        if (!z3) {
            Code(arrayList);
        }
        return z3;
    }

    public static boolean Code(String str, String str2, boolean z) {
        return Code(str, str2, 524288000, 100, z);
    }

    public static boolean Code(String str, String str2, boolean z, int i) {
        if (i <= 0) {
            i = 100;
        }
        return Code(str, str2, 524288000, i, z);
    }

    private static boolean Code(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                Code(it.next());
            }
            return true;
        } catch (Exception e) {
            fh.Z(Code, "unzip fail delete file failed" + e.getClass().getSimpleName());
            return false;
        }
    }

    private static void I(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        fh.Z(Code, "mkdirs error , files exists or IOException.");
    }

    private static void V(File file) {
        if (file == null || file.delete()) {
            return;
        }
        fh.Z(Code, "delete file error");
    }

    private static boolean V(String str) {
        return str.contains(B) || str.contains(C) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
    }
}
