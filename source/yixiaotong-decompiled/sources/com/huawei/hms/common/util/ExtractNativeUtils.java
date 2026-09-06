package com.huawei.hms.common.util;

import android.content.Context;
import com.huawei.hms.feature.dynamic.ModuleCopy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ExtractNativeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3990a = "ExtractNativeUtils";
    public static final int b = 0;
    public static final int c = -1;
    public static final int d = 50;
    public static final int e = 52428800;
    public static final Pattern f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3991a;
        public ZipEntry b;
        public String c;

        public b(ZipEntry zipEntry, String str, String str2) {
            this.b = zipEntry;
            this.f3991a = str;
            this.c = str2;
        }

        public /* synthetic */ b(ZipEntry zipEntry, String str, String str2, a aVar) {
            this(zipEntry, str, str2);
        }
    }

    public static int a(File file, String str) throws Throwable {
        Logger.i(f3990a, "begin extractNativeLibrary");
        int i = 0;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                        HashMap map = new HashMap();
                        int iA = a(enumerationEntries, (HashMap<String, HashSet<b>>) map, 0);
                        if (iA == -1) {
                            Logger.e(f3990a, "Unsafe zip name!");
                            try {
                                zipFile2.close();
                            } catch (IOException e2) {
                                Logger.e(f3990a, "IOException:", e2);
                            }
                            return -1;
                        }
                        if (iA > 50) {
                            Logger.e(f3990a, "the total number is larger than the max");
                            try {
                                zipFile2.close();
                            } catch (IOException e3) {
                                Logger.e(f3990a, "IOException:", e3);
                            }
                            return -1;
                        }
                        Iterator it = map.keySet().iterator();
                        int iA2 = 0;
                        while (it.hasNext()) {
                            try {
                                Set<b> set = (Set) map.get((String) it.next());
                                if (set == null) {
                                    Logger.e(f3990a, "Get nativeZipEntries failed.");
                                    try {
                                        zipFile2.close();
                                    } catch (IOException e4) {
                                        Logger.e(f3990a, "IOException:", e4);
                                    }
                                    return -1;
                                }
                                for (b bVar : set) {
                                    String str2 = str + File.separator + bVar.c;
                                    ModuleCopy.makeDirectory(str2);
                                    new File(str2).setExecutable(true, false);
                                    iA2 = a(zipFile2, bVar, str2);
                                    if (iA2 != 0) {
                                        try {
                                            zipFile2.close();
                                        } catch (IOException e5) {
                                            Logger.e(f3990a, "IOException:", e5);
                                        }
                                        return iA2;
                                    }
                                    new File(str2, bVar.f3991a).setReadable(true, false);
                                }
                            } catch (IOException e6) {
                                e = e6;
                                i = iA2;
                                zipFile = zipFile2;
                                Logger.e(f3990a, "catch IOException ", e);
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (IOException e7) {
                                        e = e7;
                                        iA2 = i;
                                    }
                                }
                                return i;
                            }
                            Logger.e(f3990a, "IOException:", e);
                            return iA2;
                        }
                        try {
                            zipFile2.close();
                            return iA2;
                        } catch (IOException e8) {
                            e = e8;
                        }
                    } catch (IOException e9) {
                        e = e9;
                    }
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e10) {
                            Logger.e(f3990a, "IOException:", e10);
                        }
                    }
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int a(Enumeration enumeration, HashMap<String, HashSet<b>> map, int i) {
        while (enumeration.hasMoreElements()) {
            Object objNextElement = enumeration.nextElement();
            if (objNextElement != null && (objNextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) objNextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    Logger.e(f3990a, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = f.matcher(name);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    HashSet<b> hashSet = map.get(strGroup);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(strGroup, hashSet);
                    }
                    hashSet.add(new b(zipEntry, strGroup2, strGroup, null));
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static int a(ZipFile e2, b bVar, String str) throws Throwable {
        ?? r10;
        IOException e3;
        int i = -1;
        FileOutputStream fileOutputStream = null;
        ?? r4 = 0;
        ?? r5 = 0;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                byte[] bArr = new byte[4096];
                FileOutputStream fileOutputStream3 = new FileOutputStream(new File(str, bVar.f3991a));
                try {
                    e2 = e2.getInputStream(bVar.b);
                    int i2 = 0;
                    while (true) {
                        try {
                            int i3 = e2.read(bArr);
                            if (i3 <= 0) {
                                i = 0;
                                fileOutputStream = i2;
                                break;
                            }
                            int i4 = i2 + i3;
                            if (i4 > 52428800) {
                                Logger.e(f3990a, "so file too big , " + bVar.c + " , " + bVar.f3991a);
                                fileOutputStream = i4;
                                break;
                            }
                            fileOutputStream3.write(bArr, 0, i3);
                            i2 = i4;
                        } catch (FileNotFoundException unused) {
                            r4 = e2;
                            e2 = r4;
                            fileOutputStream = fileOutputStream3;
                            Logger.e(f3990a, "FileNotFoundException");
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    Logger.e(f3990a, "IOException", e4);
                                }
                            }
                            if (e2 != 0) {
                            }
                            return i;
                        } catch (IOException e5) {
                            e3 = e5;
                            r5 = e2;
                            e2 = r5;
                            fileOutputStream = fileOutputStream3;
                            Logger.e(f3990a, "IOException", e3);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e6) {
                                    Logger.e(f3990a, "IOException", e6);
                                }
                            }
                            if (e2 != 0) {
                            }
                            return i;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream3;
                            Throwable th2 = th;
                            r10 = e2;
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e7) {
                                    Logger.e(f3990a, "IOException", e7);
                                }
                            }
                            if (r10 != 0) {
                                throw th;
                            }
                            try {
                                r10.close();
                                throw th;
                            } catch (IOException e8) {
                                Logger.e(f3990a, "IOException", e8);
                                throw th;
                            }
                        }
                    }
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e9) {
                        Logger.e(f3990a, "IOException", e9);
                    }
                } catch (FileNotFoundException unused2) {
                } catch (IOException e10) {
                    e3 = e10;
                } catch (Throwable th3) {
                    th = th3;
                    e2 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (FileNotFoundException unused3) {
            e2 = 0;
        } catch (IOException e11) {
            e3 = e11;
            e2 = 0;
        } catch (Throwable th5) {
            th = th5;
            r10 = 0;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (r10 != 0) {
                throw th;
            }
            r10.close();
            throw th;
        }
        try {
            e2.close();
        } catch (IOException e12) {
            e2 = e12;
            Logger.e(f3990a, "IOException", (Throwable) e2);
        }
        return i;
    }

    public static boolean a(Context context, String str) {
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                Logger.i(f3990a, "The extract-native-flag has set, need to extract.");
                return true;
            }
            Logger.i(f3990a, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            Logger.w(f3990a, "Get package name failed: name not found.");
            return true;
        }
    }
}
