package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.kuaishou.weapon.p0.jni.Engine;
import com.stub.StubApp;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class r {
    private static r c;
    private static Application d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4725a;
    private String e;
    private static Random f = new Random();
    private static Map<String, s> g = new ConcurrentHashMap();
    private static Map<String, s> h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    public static r a() {
        return c;
    }

    public Map<String, s> b() {
        return h;
    }

    public static r a(Context context, boolean z) {
        try {
            if (c == null) {
                d = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
                c = new r();
            }
        } catch (Throwable unused) {
        }
        return c;
    }

    private r() {
    }

    public boolean a(s sVar, boolean z) {
        this.f4725a = z;
        this.e = sVar.d;
        return a(sVar);
    }

    private synchronized boolean a(s sVar) {
        boolean z;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.e)) {
                s sVar2 = g.get(sVar.e);
                if (sVar2 != null) {
                    if (sVar2.d.equals(sVar.d)) {
                        return true;
                    }
                    a(sVar2.e);
                }
                try {
                    sVar.f = d;
                    if (sVar.p == 1) {
                        try {
                            try {
                                if (TextUtils.isEmpty(sVar.c) || TextUtils.isEmpty(sVar.e)) {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                                sVar.m = d.getFilesDir().getCanonicalPath() + bg.j + sVar.f4726a;
                                String str = sVar.m + "/dex";
                                String str2 = sVar.m + "/lib/" + this.e;
                                dl.c(sVar.m + "/lib");
                                String str3 = str2 + "/" + f.nextInt();
                                e(str);
                                dl.a(str, Boolean.FALSE);
                                e(str3);
                                a(sVar, str3, str, false);
                                h.put(sVar.c, sVar);
                                g.put(sVar.e, sVar);
                            } catch (Throwable unused) {
                                a(sVar.e);
                                z = true;
                            }
                        } catch (Throwable unused2) {
                            return false;
                        }
                    }
                    z = false;
                    if (sVar.p != 1 || z) {
                        PackageInfo packageArchiveInfo = sVar.r;
                        if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                            packageArchiveInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                        }
                        if (TextUtils.isEmpty(packageArchiveInfo.packageName) || !packageArchiveInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            throw new Exception("weapon package name check failed");
                        }
                        if (sVar.p != 1 && sVar.b != 1 && !((Boolean) a(sVar.j, sVar.e).first).booleanValue()) {
                            return false;
                        }
                        sVar.c = packageArchiveInfo.packageName;
                        sVar.o = packageArchiveInfo.applicationInfo.className;
                        sVar.d = packageArchiveInfo.versionName;
                        sVar.l = packageArchiveInfo.activities;
                        sVar.q = packageArchiveInfo.applicationInfo.theme;
                        sVar.m = d.getFilesDir().getCanonicalPath() + bg.j + sVar.f4726a;
                        String str4 = sVar.m + "/dex";
                        String str5 = sVar.m + "/lib/" + this.e;
                        dl.c(sVar.m + "/lib");
                        String str6 = str5 + "/" + f.nextInt();
                        e(str4);
                        dl.a(str4, Boolean.FALSE);
                        e(str6);
                        a(sVar, str6, str4, true);
                        h.put(sVar.c, sVar);
                        g.put(sVar.e, sVar);
                        b.add(Integer.valueOf(sVar.f4726a));
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        File file = new File(str2);
        if (!dl.a(file)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        String strA = f.a(file);
        if (TextUtils.isEmpty(strA)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        if (!strA.equalsIgnoreCase(str)) {
            return new Pair<>(Boolean.FALSE, strA);
        }
        return new Pair<>(Boolean.TRUE, "");
    }

    public boolean a(String str) {
        s sVar = g.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(str);
        h.remove(sVar.c);
        dl.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dl.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public boolean b(String str) {
        s sVar = h.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(sVar.e);
        h.remove(str);
        dl.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dl.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    /* JADX WARN: Code duplicated, block: B:153:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:155:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:163:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:165:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:173:0x0303  */
    /* JADX WARN: Code duplicated, block: B:175:0x0308  */
    /* JADX WARN: Code duplicated, block: B:177:0x030d A[PHI: r11 r17 r18 r21 r22
  0x030d: PHI (r11v11 ??) = (r11v8 ??), (r11v9 ??), (r11v12 ??), (r11v16 ??) binds: [B:156:0x02cf, B:176:0x030b, B:166:0x02ed, B:124:0x0242] A[DONT_GENERATE, DONT_INLINE]
  0x030d: PHI (r17v12 java.io.InputStream) = (r17v9 java.io.InputStream), (r17v10 java.io.InputStream), (r17v13 java.io.InputStream), (r17v20 java.io.InputStream) binds: [B:156:0x02cf, B:176:0x030b, B:166:0x02ed, B:124:0x0242] A[DONT_GENERATE, DONT_INLINE]
  0x030d: PHI (r18v9 ??) = (r18v6 ??), (r18v7 ??), (r18v10 ??), (r18v14 ??) binds: [B:156:0x02cf, B:176:0x030b, B:166:0x02ed, B:124:0x0242] A[DONT_GENERATE, DONT_INLINE]
  0x030d: PHI (r21v12 ??) = (r21v8 ??), (r21v9 ??), (r21v13 ??), (r21v23 ??) binds: [B:156:0x02cf, B:176:0x030b, B:166:0x02ed, B:124:0x0242] A[DONT_GENERATE, DONT_INLINE]
  0x030d: PHI (r22v12 java.lang.String) = (r22v8 java.lang.String), (r22v9 java.lang.String), (r22v13 java.lang.String), (r22v23 java.lang.String) binds: [B:156:0x02cf, B:176:0x030b, B:166:0x02ed, B:124:0x0242] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:180:0x031e  */
    /* JADX WARN: Code duplicated, block: B:183:0x033d A[Catch: all -> 0x0356, TRY_LEAVE, TryCatch #40 {all -> 0x0356, blocks: (B:181:0x0335, B:183:0x033d), top: B:266:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x035a  */
    /* JADX WARN: Code duplicated, block: B:188:0x037c  */
    /* JADX WARN: Code duplicated, block: B:191:0x039e A[Catch: all -> 0x03c3, TRY_LEAVE, TryCatch #22 {all -> 0x03c3, blocks: (B:189:0x0396, B:191:0x039e), top: B:247:0x0396 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:196:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:198:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:200:0x03db  */
    /* JADX WARN: Code duplicated, block: B:208:0x042d A[Catch: all -> 0x04ac, TryCatch #5 {all -> 0x04ac, blocks: (B:206:0x040c, B:208:0x042d, B:210:0x0437, B:214:0x0487, B:215:0x04ab, B:212:0x0441), top: B:241:0x040c, inners: #27 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x0437 A[Catch: all -> 0x04ac, TRY_LEAVE, TryCatch #5 {all -> 0x04ac, blocks: (B:206:0x040c, B:208:0x042d, B:210:0x0437, B:214:0x0487, B:215:0x04ab, B:212:0x0441), top: B:241:0x040c, inners: #27 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x04ac A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:220:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:222:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:224:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:247:0x0396 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0242, code lost:
    
        if (r18 != 0) goto L177;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v47 */
    /* JADX WARN: Type inference failed for: r11v48 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v54 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v29 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v30 */
    /* JADX WARN: Type inference failed for: r18v31 */
    /* JADX WARN: Type inference failed for: r18v32 */
    /* JADX WARN: Type inference failed for: r18v33 */
    /* JADX WARN: Type inference failed for: r18v34 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v11 */
    /* JADX WARN: Type inference failed for: r21v12 */
    /* JADX WARN: Type inference failed for: r21v13 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v20 */
    /* JADX WARN: Type inference failed for: r21v21 */
    /* JADX WARN: Type inference failed for: r21v22 */
    /* JADX WARN: Type inference failed for: r21v23 */
    /* JADX WARN: Type inference failed for: r21v26 */
    /* JADX WARN: Type inference failed for: r21v27 */
    /* JADX WARN: Type inference failed for: r21v28 */
    /* JADX WARN: Type inference failed for: r21v31 */
    /* JADX WARN: Type inference failed for: r21v32 */
    /* JADX WARN: Type inference failed for: r21v33 */
    /* JADX WARN: Type inference failed for: r21v37 */
    /* JADX WARN: Type inference failed for: r21v39 */
    /* JADX WARN: Type inference failed for: r21v40 */
    /* JADX WARN: Type inference failed for: r21v41 */
    /* JADX WARN: Type inference failed for: r21v42 */
    /* JADX WARN: Type inference failed for: r21v43 */
    /* JADX WARN: Type inference failed for: r21v44 */
    /* JADX WARN: Type inference failed for: r21v45 */
    /* JADX WARN: Type inference failed for: r21v46 */
    /* JADX WARN: Type inference failed for: r21v47 */
    /* JADX WARN: Type inference failed for: r21v48 */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(s sVar, String str, String str2, boolean z) throws Throwable {
        boolean z2;
        InputStream inputStream;
        ?? r18;
        Object obj;
        String str3;
        ZipFile zipFile;
        ZipFile zipFile2;
        ZipFile zipFile3;
        Object obj2;
        ?? r19;
        Object obj3;
        Object obj4;
        ?? r21;
        String str4;
        String strA;
        String str5;
        String str6;
        ?? r22;
        File file;
        String str7;
        String str8;
        String str9 = ".so";
        ?? r11 = "armeabi";
        HashSet<String> hashSet = new HashSet<>();
        if (z || TextUtils.isEmpty(sVar.n)) {
            z2 = true;
        } else {
            File file2 = new File(sVar.n);
            if (file2.exists() && file2.isFile()) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        String str10 = "";
        String strReplace = !TextUtils.isEmpty(sVar.d) ? sVar.d.replace(".", "") : "";
        StringBuilder sb = new StringBuilder();
        if (!z2) {
            sb.append(sVar.n);
        }
        byte[] bArr = new byte[4096];
        ?? r16 = 0;
        str = null;
        String str11 = null;
        try {
            try {
                try {
                    ZipFile zipFile4 = new ZipFile(sVar.e);
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile4.entries();
                        inputStream = null;
                        r19 = 0;
                        r11 = r11;
                        while (enumerationEntries.hasMoreElements()) {
                            try {
                                try {
                                    try {
                                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                                        ?? name = zipEntryNextElement.getName();
                                        Enumeration<? extends ZipEntry> enumeration = enumerationEntries;
                                        if (name.contains("../")) {
                                            str3 = str10;
                                        } else {
                                            if (!name.startsWith("lib/") || zipEntryNextElement.isDirectory()) {
                                                r11 = r11;
                                                str3 = str10;
                                                r19 = r19;
                                            } else {
                                                String str12 = Build.CPU_ABI;
                                                try {
                                                    str7 = Build.CPU_ABI2;
                                                } catch (Throwable unused) {
                                                    str7 = null;
                                                }
                                                if (name.contains(str12)) {
                                                    str3 = str10;
                                                } else {
                                                    try {
                                                        if (TextUtils.isEmpty(str7)) {
                                                            str3 = str10;
                                                            str8 = str7;
                                                        } else {
                                                            str3 = str10;
                                                            str8 = str7;
                                                            try {
                                                                if (!name.contains(str8)) {
                                                                }
                                                            } catch (EOFException unused2) {
                                                                r22 = r11;
                                                                r11 = zipFile4;
                                                                r19 = r19;
                                                                r21 = r22;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r19 != 0) {
                                                                    r19.close();
                                                                }
                                                                if (hashSet.contains(Build.CPU_ABI)) {
                                                                    str5 = str + "/" + Build.CPU_ABI;
                                                                    try {
                                                                        if (hashSet.contains(Build.CPU_ABI2)) {
                                                                            str11 = str + "/" + Build.CPU_ABI2;
                                                                        }
                                                                    } catch (Throwable unused3) {
                                                                    }
                                                                    str6 = str11;
                                                                    if (str6 != null) {
                                                                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                    }
                                                                } else {
                                                                    try {
                                                                        if (hashSet.contains(Build.CPU_ABI2)) {
                                                                            str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                        } else {
                                                                            str4 = str3;
                                                                        }
                                                                    } catch (Throwable unused4) {
                                                                    }
                                                                }
                                                                if (TextUtils.isEmpty(str4)) {
                                                                    ?? r2 = r21;
                                                                    str4 = !"armeabi-v7a".equals(Build.CPU_ABI) ? str + "/armeabi:" + System.getProperty("java.library.path") : str + "/armeabi:" + System.getProperty("java.library.path");
                                                                }
                                                                sVar.h = str4;
                                                                sVar.n = sb.toString();
                                                                try {
                                                                    String absolutePath = new File(str2, "apkDex").getAbsolutePath();
                                                                    dl.c(absolutePath);
                                                                    e(absolutePath);
                                                                    strA = dk.a(d);
                                                                    if (TextUtils.isEmpty(sVar.n)) {
                                                                        if (sVar.c.endsWith("v7")) {
                                                                        }
                                                                        try {
                                                                            dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                            Engine.soPath = str + "/" + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                        } catch (Throwable unused5) {
                                                                            throw new RuntimeException("can't load WeaponEngineImpl by both dexFile:" + sb.toString() + " and ZipFile:" + sVar.e);
                                                                        }
                                                                    }
                                                                } catch (Throwable unused6) {
                                                                    return;
                                                                }
                                                            } catch (FileNotFoundException | ZipException unused7) {
                                                                r22 = r11;
                                                                r11 = zipFile4;
                                                                r19 = r19;
                                                                r21 = r22;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r19 != 0) {
                                                                    r19.close();
                                                                }
                                                                if (hashSet.contains(Build.CPU_ABI)) {
                                                                    str5 = str + "/" + Build.CPU_ABI;
                                                                    if (hashSet.contains(Build.CPU_ABI2)) {
                                                                        str11 = str + "/" + Build.CPU_ABI2;
                                                                    }
                                                                    str6 = str11;
                                                                    if (str6 != null) {
                                                                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                    }
                                                                } else if (hashSet.contains(Build.CPU_ABI2)) {
                                                                    str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                } else {
                                                                    str4 = str3;
                                                                }
                                                                if (TextUtils.isEmpty(str4)) {
                                                                    ?? r3 = r21;
                                                                    if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                    }
                                                                }
                                                                sVar.h = str4;
                                                                sVar.n = sb.toString();
                                                                String absolutePath2 = new File(str2, "apkDex").getAbsolutePath();
                                                                dl.c(absolutePath2);
                                                                e(absolutePath2);
                                                                strA = dk.a(d);
                                                                if (TextUtils.isEmpty(sVar.n)) {
                                                                    if (sVar.c.endsWith("v7")) {
                                                                    }
                                                                    dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                    Engine.soPath = str + "/" + strA;
                                                                    Engine.soVersion = sVar.d;
                                                                    Engine.getInstance(d);
                                                                }
                                                            } catch (IOException unused8) {
                                                                r22 = r11;
                                                                r11 = zipFile4;
                                                                r19 = r19;
                                                                r21 = r22;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r19 != 0) {
                                                                    r19.close();
                                                                }
                                                                if (hashSet.contains(Build.CPU_ABI)) {
                                                                    str5 = str + "/" + Build.CPU_ABI;
                                                                    if (hashSet.contains(Build.CPU_ABI2)) {
                                                                        str11 = str + "/" + Build.CPU_ABI2;
                                                                    }
                                                                    str6 = str11;
                                                                    if (str6 != null) {
                                                                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                    }
                                                                } else if (hashSet.contains(Build.CPU_ABI2)) {
                                                                    str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                } else {
                                                                    str4 = str3;
                                                                }
                                                                if (TextUtils.isEmpty(str4)) {
                                                                    ?? r4 = r21;
                                                                    if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                    }
                                                                }
                                                                sVar.h = str4;
                                                                sVar.n = sb.toString();
                                                                String absolutePath3 = new File(str2, "apkDex").getAbsolutePath();
                                                                dl.c(absolutePath3);
                                                                e(absolutePath3);
                                                                strA = dk.a(d);
                                                                if (TextUtils.isEmpty(sVar.n)) {
                                                                    if (sVar.c.endsWith("v7")) {
                                                                    }
                                                                    dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                    Engine.soPath = str + "/" + strA;
                                                                    Engine.soVersion = sVar.d;
                                                                    Engine.getInstance(d);
                                                                }
                                                            }
                                                        }
                                                        if (!name.contains(r11) || (!"armeabi-v7a".equalsIgnoreCase(str12) && (TextUtils.isEmpty(str8) || !"armeabi-v7a".equalsIgnoreCase(str8)))) {
                                                        }
                                                    } catch (EOFException unused9) {
                                                        str3 = str10;
                                                    } catch (FileNotFoundException | ZipException unused10) {
                                                        str3 = str10;
                                                    } catch (IOException unused11) {
                                                        str3 = str10;
                                                    }
                                                }
                                                r22 = r11;
                                                try {
                                                    try {
                                                        String str13 = str + name.substring(3).replace(str9, strReplace + str9);
                                                        String strSubstring = str13.substring(0, str13.lastIndexOf(47));
                                                        hashSet.add(strSubstring.substring(strSubstring.lastIndexOf(47) + 1));
                                                        e(strSubstring);
                                                        new File(str13).delete();
                                                        InputStream inputStream2 = zipFile4.getInputStream(zipEntryNextElement);
                                                        try {
                                                            FileOutputStream fileOutputStream = new FileOutputStream(str13);
                                                            while (true) {
                                                                try {
                                                                    int i = inputStream2.read(bArr);
                                                                    if (i <= 0) {
                                                                        break;
                                                                    }
                                                                    inputStream = inputStream2;
                                                                    try {
                                                                        fileOutputStream.write(bArr, 0, i);
                                                                        inputStream2 = inputStream;
                                                                    } catch (EOFException unused12) {
                                                                        r11 = zipFile4;
                                                                        r19 = fileOutputStream;
                                                                        r21 = r22;
                                                                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                        if (r11 != 0) {
                                                                            r11.close();
                                                                        }
                                                                        if (inputStream != null) {
                                                                            inputStream.close();
                                                                        }
                                                                        if (r19 != 0) {
                                                                            r19.close();
                                                                        }
                                                                        if (hashSet.contains(Build.CPU_ABI)) {
                                                                            str5 = str + "/" + Build.CPU_ABI;
                                                                            if (hashSet.contains(Build.CPU_ABI2)) {
                                                                                str11 = str + "/" + Build.CPU_ABI2;
                                                                            }
                                                                            str6 = str11;
                                                                            if (str6 != null) {
                                                                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                            }
                                                                        } else if (hashSet.contains(Build.CPU_ABI2)) {
                                                                            str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                        } else {
                                                                            str4 = str3;
                                                                        }
                                                                        if (TextUtils.isEmpty(str4)) {
                                                                            ?? r5 = r21;
                                                                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                            }
                                                                        }
                                                                        sVar.h = str4;
                                                                        sVar.n = sb.toString();
                                                                        String absolutePath4 = new File(str2, "apkDex").getAbsolutePath();
                                                                        dl.c(absolutePath4);
                                                                        e(absolutePath4);
                                                                        strA = dk.a(d);
                                                                        if (TextUtils.isEmpty(sVar.n)) {
                                                                            if (sVar.c.endsWith("v7")) {
                                                                            }
                                                                            dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                            Engine.soPath = str + "/" + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                        }
                                                                    } catch (FileNotFoundException | ZipException unused13) {
                                                                        r11 = zipFile4;
                                                                        r19 = fileOutputStream;
                                                                        r21 = r22;
                                                                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                        if (r11 != 0) {
                                                                            r11.close();
                                                                        }
                                                                        if (inputStream != null) {
                                                                            inputStream.close();
                                                                        }
                                                                        if (r19 != 0) {
                                                                            r19.close();
                                                                        }
                                                                        if (hashSet.contains(Build.CPU_ABI)) {
                                                                            str5 = str + "/" + Build.CPU_ABI;
                                                                            if (hashSet.contains(Build.CPU_ABI2)) {
                                                                                str11 = str + "/" + Build.CPU_ABI2;
                                                                            }
                                                                            str6 = str11;
                                                                            if (str6 != null) {
                                                                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                            }
                                                                        } else if (hashSet.contains(Build.CPU_ABI2)) {
                                                                            str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                        } else {
                                                                            str4 = str3;
                                                                        }
                                                                        if (TextUtils.isEmpty(str4)) {
                                                                            ?? r6 = r21;
                                                                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                            }
                                                                        }
                                                                        sVar.h = str4;
                                                                        sVar.n = sb.toString();
                                                                        String absolutePath5 = new File(str2, "apkDex").getAbsolutePath();
                                                                        dl.c(absolutePath5);
                                                                        e(absolutePath5);
                                                                        strA = dk.a(d);
                                                                        if (TextUtils.isEmpty(sVar.n)) {
                                                                            if (sVar.c.endsWith("v7")) {
                                                                            }
                                                                            dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                            Engine.soPath = str + "/" + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                        }
                                                                    } catch (IOException unused14) {
                                                                        r11 = zipFile4;
                                                                        r19 = fileOutputStream;
                                                                        r21 = r22;
                                                                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                        if (r11 != 0) {
                                                                            r11.close();
                                                                        }
                                                                        if (inputStream != null) {
                                                                            inputStream.close();
                                                                        }
                                                                        if (r19 != 0) {
                                                                            r19.close();
                                                                        }
                                                                        if (hashSet.contains(Build.CPU_ABI)) {
                                                                            str5 = str + "/" + Build.CPU_ABI;
                                                                            if (hashSet.contains(Build.CPU_ABI2)) {
                                                                                str11 = str + "/" + Build.CPU_ABI2;
                                                                            }
                                                                            str6 = str11;
                                                                            if (str6 != null) {
                                                                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                            }
                                                                        } else if (hashSet.contains(Build.CPU_ABI2)) {
                                                                            str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                        } else {
                                                                            str4 = str3;
                                                                        }
                                                                        if (TextUtils.isEmpty(str4)) {
                                                                            ?? r7 = r21;
                                                                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                            }
                                                                        }
                                                                        sVar.h = str4;
                                                                        sVar.n = sb.toString();
                                                                        String absolutePath6 = new File(str2, "apkDex").getAbsolutePath();
                                                                        dl.c(absolutePath6);
                                                                        e(absolutePath6);
                                                                        strA = dk.a(d);
                                                                        if (TextUtils.isEmpty(sVar.n)) {
                                                                            if (sVar.c.endsWith("v7")) {
                                                                            }
                                                                            dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                            Engine.soPath = str + "/" + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        r16 = zipFile4;
                                                                        r18 = fileOutputStream;
                                                                        if (r16 != 0) {
                                                                            r16.close();
                                                                        }
                                                                        if (inputStream != null) {
                                                                            inputStream.close();
                                                                        }
                                                                        if (r18 != 0) {
                                                                            r18.close();
                                                                        }
                                                                        throw th;
                                                                    }
                                                                } catch (EOFException unused15) {
                                                                    inputStream = inputStream2;
                                                                } catch (FileNotFoundException | ZipException unused16) {
                                                                    inputStream = inputStream2;
                                                                } catch (IOException unused17) {
                                                                    inputStream = inputStream2;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    inputStream = inputStream2;
                                                                }
                                                            }
                                                            inputStream = inputStream2;
                                                            dl.a(str13, Boolean.TRUE);
                                                            r19 = fileOutputStream;
                                                            r11 = r22;
                                                        } catch (EOFException unused18) {
                                                            inputStream = inputStream2;
                                                            r11 = zipFile4;
                                                            r19 = r19;
                                                            r21 = r22;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                                r11.close();
                                                            }
                                                            if (inputStream != null) {
                                                                inputStream.close();
                                                            }
                                                            if (r19 != 0) {
                                                                r19.close();
                                                            }
                                                            if (hashSet.contains(Build.CPU_ABI)) {
                                                                str5 = str + "/" + Build.CPU_ABI;
                                                                if (hashSet.contains(Build.CPU_ABI2)) {
                                                                    str11 = str + "/" + Build.CPU_ABI2;
                                                                }
                                                                str6 = str11;
                                                                if (str6 != null) {
                                                                    str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                } else {
                                                                    str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                }
                                                            } else if (hashSet.contains(Build.CPU_ABI2)) {
                                                                str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                            } else {
                                                                str4 = str3;
                                                            }
                                                            if (TextUtils.isEmpty(str4)) {
                                                                ?? r8 = r21;
                                                                if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                }
                                                            }
                                                            sVar.h = str4;
                                                            sVar.n = sb.toString();
                                                            String absolutePath7 = new File(str2, "apkDex").getAbsolutePath();
                                                            dl.c(absolutePath7);
                                                            e(absolutePath7);
                                                            strA = dk.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                                if (sVar.c.endsWith("v7")) {
                                                                }
                                                                dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                Engine.soPath = str + "/" + strA;
                                                                Engine.soVersion = sVar.d;
                                                                Engine.getInstance(d);
                                                            }
                                                        } catch (FileNotFoundException | ZipException unused19) {
                                                            inputStream = inputStream2;
                                                            r11 = zipFile4;
                                                            r19 = r19;
                                                            r21 = r22;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                                r11.close();
                                                            }
                                                            if (inputStream != null) {
                                                                inputStream.close();
                                                            }
                                                            if (r19 != 0) {
                                                                r19.close();
                                                            }
                                                            if (hashSet.contains(Build.CPU_ABI)) {
                                                                str5 = str + "/" + Build.CPU_ABI;
                                                                if (hashSet.contains(Build.CPU_ABI2)) {
                                                                    str11 = str + "/" + Build.CPU_ABI2;
                                                                }
                                                                str6 = str11;
                                                                if (str6 != null) {
                                                                    str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                } else {
                                                                    str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                }
                                                            } else if (hashSet.contains(Build.CPU_ABI2)) {
                                                                str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                            } else {
                                                                str4 = str3;
                                                            }
                                                            if (TextUtils.isEmpty(str4)) {
                                                                ?? r9 = r21;
                                                                if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                }
                                                            }
                                                            sVar.h = str4;
                                                            sVar.n = sb.toString();
                                                            String absolutePath8 = new File(str2, "apkDex").getAbsolutePath();
                                                            dl.c(absolutePath8);
                                                            e(absolutePath8);
                                                            strA = dk.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                                if (sVar.c.endsWith("v7")) {
                                                                }
                                                                dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                Engine.soPath = str + "/" + strA;
                                                                Engine.soVersion = sVar.d;
                                                                Engine.getInstance(d);
                                                            }
                                                        } catch (IOException unused20) {
                                                            inputStream = inputStream2;
                                                            r11 = zipFile4;
                                                            r19 = r19;
                                                            r21 = r22;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                                r11.close();
                                                            }
                                                            if (inputStream != null) {
                                                                inputStream.close();
                                                            }
                                                            if (r19 != 0) {
                                                                r19.close();
                                                            }
                                                            if (hashSet.contains(Build.CPU_ABI)) {
                                                                str5 = str + "/" + Build.CPU_ABI;
                                                                if (hashSet.contains(Build.CPU_ABI2)) {
                                                                    str11 = str + "/" + Build.CPU_ABI2;
                                                                }
                                                                str6 = str11;
                                                                if (str6 != null) {
                                                                    str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                } else {
                                                                    str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                                }
                                                            } else if (hashSet.contains(Build.CPU_ABI2)) {
                                                                str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                                                            } else {
                                                                str4 = str3;
                                                            }
                                                            if (TextUtils.isEmpty(str4)) {
                                                                ?? r10 = r21;
                                                                if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                }
                                                            }
                                                            sVar.h = str4;
                                                            sVar.n = sb.toString();
                                                            String absolutePath9 = new File(str2, "apkDex").getAbsolutePath();
                                                            dl.c(absolutePath9);
                                                            e(absolutePath9);
                                                            strA = dk.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                                if (sVar.c.endsWith("v7")) {
                                                                }
                                                                dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                Engine.soPath = str + "/" + strA;
                                                                Engine.soVersion = sVar.d;
                                                                Engine.getInstance(d);
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            inputStream = inputStream2;
                                                            r16 = zipFile4;
                                                            r18 = r19;
                                                            if (r16 != 0) {
                                                                r16.close();
                                                            }
                                                            if (inputStream != null) {
                                                                inputStream.close();
                                                            }
                                                            if (r18 != 0) {
                                                                r18.close();
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (FileNotFoundException | ZipException unused21) {
                                                    }
                                                } catch (EOFException unused22) {
                                                } catch (IOException unused23) {
                                                }
                                            }
                                            try {
                                                if (name.endsWith(".dex") && !zipEntryNextElement.isDirectory() && z2) {
                                                    String str14 = sVar.m;
                                                    e(str14);
                                                    file = new File(str14, sVar.f4726a + com.huawei.openalliance.ad.constant.x.A + sVar.d + ".dex");
                                                    try {
                                                        InputStream inputStream3 = zipFile4.getInputStream(zipEntryNextElement);
                                                        try {
                                                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                                            while (true) {
                                                                try {
                                                                    int i2 = inputStream3.read(bArr);
                                                                    if (i2 <= 0) {
                                                                        break;
                                                                    }
                                                                    try {
                                                                        fileOutputStream2.write(bArr, 0, i2);
                                                                    } catch (Throwable unused24) {
                                                                        inputStream = inputStream3;
                                                                        r19 = fileOutputStream2;
                                                                        if (file != null && file.exists()) {
                                                                            file.delete();
                                                                        }
                                                                        enumerationEntries = enumeration;
                                                                        r11 = r11;
                                                                        str10 = str3;
                                                                        str9 = str9;
                                                                        r19 = r19;
                                                                    }
                                                                } catch (Throwable unused25) {
                                                                }
                                                            }
                                                            fileOutputStream2.close();
                                                            if (inputStream3 != null) {
                                                                inputStream3.close();
                                                            }
                                                            sb.append(file.getAbsolutePath());
                                                            dl.a(sb.toString(), Boolean.TRUE);
                                                            inputStream = inputStream3;
                                                            r19 = fileOutputStream2;
                                                        } catch (Throwable unused26) {
                                                            inputStream = inputStream3;
                                                            r19 = r19;
                                                        }
                                                    } catch (Throwable unused27) {
                                                        r19 = r19;
                                                    }
                                                }
                                            } catch (Throwable unused28) {
                                                file = null;
                                                r19 = r19;
                                            }
                                            enumerationEntries = enumeration;
                                            r11 = r11;
                                            str10 = str3;
                                            str9 = str9;
                                            r19 = r19;
                                        }
                                        enumerationEntries = enumeration;
                                        r11 = r11;
                                        str10 = str3;
                                        str9 = str9;
                                        r19 = r19;
                                    } catch (FileNotFoundException | ZipException unused29) {
                                        r22 = r11;
                                        str3 = str10;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (EOFException unused30) {
                                r22 = r11;
                                str3 = str10;
                            } catch (IOException unused31) {
                                r22 = r11;
                                str3 = str10;
                            }
                        }
                        r21 = r11;
                        str3 = str10;
                        zipFile4.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (EOFException unused32) {
                        obj4 = "armeabi";
                        str3 = "";
                        zipFile3 = zipFile4;
                        inputStream = null;
                        r19 = inputStream;
                        r11 = zipFile3;
                        r21 = obj4;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (r19 != 0) {
                            r19.close();
                        }
                        if (hashSet.contains(Build.CPU_ABI)) {
                            str5 = str + "/" + Build.CPU_ABI;
                            if (hashSet.contains(Build.CPU_ABI2)) {
                                str11 = str + "/" + Build.CPU_ABI2;
                            }
                            str6 = str11;
                            if (str6 != null) {
                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                            } else {
                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                            }
                        } else if (hashSet.contains(Build.CPU_ABI2)) {
                            str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        } else {
                            str4 = str3;
                        }
                        if (TextUtils.isEmpty(str4)) {
                            ?? r12 = r21;
                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                            }
                        }
                        sVar.h = str4;
                        sVar.n = sb.toString();
                        String absolutePath10 = new File(str2, "apkDex").getAbsolutePath();
                        dl.c(absolutePath10);
                        e(absolutePath10);
                        strA = dk.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                            if (sVar.c.endsWith("v7")) {
                            }
                            dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                            Engine.soPath = str + "/" + strA;
                            Engine.soVersion = sVar.d;
                            Engine.getInstance(d);
                        }
                    } catch (FileNotFoundException | ZipException unused33) {
                        obj3 = "armeabi";
                        str3 = "";
                        zipFile2 = zipFile4;
                        inputStream = null;
                        r19 = inputStream;
                        r11 = zipFile2;
                        r21 = obj3;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (r19 != 0) {
                            r19.close();
                        }
                        if (hashSet.contains(Build.CPU_ABI)) {
                            str5 = str + "/" + Build.CPU_ABI;
                            if (hashSet.contains(Build.CPU_ABI2)) {
                                str11 = str + "/" + Build.CPU_ABI2;
                            }
                            str6 = str11;
                            if (str6 != null) {
                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                            } else {
                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                            }
                        } else if (hashSet.contains(Build.CPU_ABI2)) {
                            str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        } else {
                            str4 = str3;
                        }
                        if (TextUtils.isEmpty(str4)) {
                            ?? r13 = r21;
                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                            }
                        }
                        sVar.h = str4;
                        sVar.n = sb.toString();
                        String absolutePath11 = new File(str2, "apkDex").getAbsolutePath();
                        dl.c(absolutePath11);
                        e(absolutePath11);
                        strA = dk.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                            if (sVar.c.endsWith("v7")) {
                            }
                            dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                            Engine.soPath = str + "/" + strA;
                            Engine.soVersion = sVar.d;
                            Engine.getInstance(d);
                        }
                    } catch (IOException unused34) {
                        obj2 = "armeabi";
                        str3 = "";
                        zipFile = zipFile4;
                        inputStream = null;
                        r19 = inputStream;
                        r11 = zipFile;
                        r21 = obj2;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (r19 != 0) {
                            r19.close();
                        }
                        if (hashSet.contains(Build.CPU_ABI)) {
                            str5 = str + "/" + Build.CPU_ABI;
                            if (hashSet.contains(Build.CPU_ABI2)) {
                                str11 = str + "/" + Build.CPU_ABI2;
                            }
                            str6 = str11;
                            if (str6 != null) {
                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                            } else {
                                str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                            }
                        } else if (hashSet.contains(Build.CPU_ABI2)) {
                            str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        } else {
                            str4 = str3;
                        }
                        if (TextUtils.isEmpty(str4)) {
                            ?? r14 = r21;
                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                            }
                        }
                        sVar.h = str4;
                        sVar.n = sb.toString();
                        String absolutePath12 = new File(str2, "apkDex").getAbsolutePath();
                        dl.c(absolutePath12);
                        e(absolutePath12);
                        strA = dk.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                            if (sVar.c.endsWith("v7")) {
                            }
                            dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                            Engine.soPath = str + "/" + strA;
                            Engine.soVersion = sVar.d;
                            Engine.getInstance(d);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                        r19 = 0;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r16 = r11;
                    r18 = r19;
                }
            } catch (EOFException unused35) {
                obj = "armeabi";
                str3 = "";
                zipFile3 = null;
                inputStream = null;
                obj4 = obj;
                r19 = inputStream;
                r11 = zipFile3;
                r21 = obj4;
                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                if (r11 != 0) {
                    r11.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (r19 != 0) {
                    r19.close();
                }
                if (hashSet.contains(Build.CPU_ABI)) {
                    str5 = str + "/" + Build.CPU_ABI;
                    if (hashSet.contains(Build.CPU_ABI2)) {
                        str11 = str + "/" + Build.CPU_ABI2;
                    }
                    str6 = str11;
                    if (str6 != null) {
                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                    } else {
                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                    }
                } else if (hashSet.contains(Build.CPU_ABI2)) {
                    str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                } else {
                    str4 = str3;
                }
                if (TextUtils.isEmpty(str4)) {
                    ?? r15 = r21;
                    if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                    }
                }
                sVar.h = str4;
                sVar.n = sb.toString();
                String absolutePath13 = new File(str2, "apkDex").getAbsolutePath();
                dl.c(absolutePath13);
                e(absolutePath13);
                strA = dk.a(d);
                if (TextUtils.isEmpty(sVar.n)) {
                    if (sVar.c.endsWith("v7")) {
                    }
                    dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                    Engine.soPath = str + "/" + strA;
                    Engine.soVersion = sVar.d;
                    Engine.getInstance(d);
                }
            } catch (FileNotFoundException | ZipException unused36) {
                obj = "armeabi";
                str3 = "";
                zipFile2 = null;
                inputStream = null;
                obj3 = obj;
                r19 = inputStream;
                r11 = zipFile2;
                r21 = obj3;
                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                if (r11 != 0) {
                    r11.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (r19 != 0) {
                    r19.close();
                }
                if (hashSet.contains(Build.CPU_ABI)) {
                    str5 = str + "/" + Build.CPU_ABI;
                    if (hashSet.contains(Build.CPU_ABI2)) {
                        str11 = str + "/" + Build.CPU_ABI2;
                    }
                    str6 = str11;
                    if (str6 != null) {
                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                    } else {
                        str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                    }
                } else if (hashSet.contains(Build.CPU_ABI2)) {
                    str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                } else {
                    str4 = str3;
                }
                if (TextUtils.isEmpty(str4)) {
                    ?? r17 = r21;
                    if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                    }
                }
                sVar.h = str4;
                sVar.n = sb.toString();
                String absolutePath14 = new File(str2, "apkDex").getAbsolutePath();
                dl.c(absolutePath14);
                e(absolutePath14);
                strA = dk.a(d);
                if (TextUtils.isEmpty(sVar.n)) {
                    if (sVar.c.endsWith("v7")) {
                    }
                    dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                    Engine.soPath = str + "/" + strA;
                    Engine.soVersion = sVar.d;
                    Engine.getInstance(d);
                }
            } catch (IOException e) {
                obj = "armeabi";
                str3 = "";
                try {
                    throw new FileNotFoundException(e.getMessage() + "--backupFile not exists");
                } catch (EOFException unused37) {
                    zipFile3 = null;
                    inputStream = null;
                    obj4 = obj;
                    r19 = inputStream;
                    r11 = zipFile3;
                    r21 = obj4;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                        r11.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (r19 != 0) {
                        r19.close();
                    }
                    if (hashSet.contains(Build.CPU_ABI)) {
                        str5 = str + "/" + Build.CPU_ABI;
                        if (hashSet.contains(Build.CPU_ABI2)) {
                            str11 = str + "/" + Build.CPU_ABI2;
                        }
                        str6 = str11;
                        if (str6 != null) {
                            str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        } else {
                            str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        }
                    } else if (hashSet.contains(Build.CPU_ABI2)) {
                        str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                    } else {
                        str4 = str3;
                    }
                    if (TextUtils.isEmpty(str4)) {
                        ?? r110 = r21;
                        if ((!"armeabi-v7a".equals(Build.CPU_ABI) && hashSet.contains(r110)) || ("armeabi-v7a".equals(Build.CPU_ABI2) && hashSet.contains(r110))) {
                        }
                    }
                    sVar.h = str4;
                    sVar.n = sb.toString();
                    String absolutePath15 = new File(str2, "apkDex").getAbsolutePath();
                    dl.c(absolutePath15);
                    e(absolutePath15);
                    strA = dk.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                        if (!sVar.c.endsWith("v7") || sVar.c.endsWith("v8")) {
                            dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                            Engine.soPath = str + "/" + strA;
                            Engine.soVersion = sVar.d;
                            Engine.getInstance(d);
                        }
                    }
                } catch (FileNotFoundException | ZipException unused38) {
                    zipFile2 = null;
                    inputStream = null;
                    obj3 = obj;
                    r19 = inputStream;
                    r11 = zipFile2;
                    r21 = obj3;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                        r11.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (r19 != 0) {
                        r19.close();
                    }
                    if (hashSet.contains(Build.CPU_ABI)) {
                        str5 = str + "/" + Build.CPU_ABI;
                        if (hashSet.contains(Build.CPU_ABI2)) {
                            str11 = str + "/" + Build.CPU_ABI2;
                        }
                        str6 = str11;
                        if (str6 != null) {
                            str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        } else {
                            str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        }
                    } else if (hashSet.contains(Build.CPU_ABI2)) {
                        str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                    } else {
                        str4 = str3;
                    }
                    if (TextUtils.isEmpty(str4)) {
                        ?? r111 = r21;
                        if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                        }
                    }
                    sVar.h = str4;
                    sVar.n = sb.toString();
                    String absolutePath16 = new File(str2, "apkDex").getAbsolutePath();
                    dl.c(absolutePath16);
                    e(absolutePath16);
                    strA = dk.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                        if (sVar.c.endsWith("v7")) {
                        }
                        dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                        Engine.soPath = str + "/" + strA;
                        Engine.soVersion = sVar.d;
                        Engine.getInstance(d);
                    }
                } catch (IOException unused39) {
                    zipFile = null;
                    inputStream = null;
                    obj2 = obj;
                    r19 = inputStream;
                    r11 = zipFile;
                    r21 = obj2;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                        r11.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (r19 != 0) {
                        r19.close();
                    }
                    if (hashSet.contains(Build.CPU_ABI)) {
                        str5 = str + "/" + Build.CPU_ABI;
                        if (hashSet.contains(Build.CPU_ABI2)) {
                            str11 = str + "/" + Build.CPU_ABI2;
                        }
                        str6 = str11;
                        if (str6 != null) {
                            str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + str6 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        } else {
                            str4 = str5 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                        }
                    } else if (hashSet.contains(Build.CPU_ABI2)) {
                        str4 = str + "/" + Build.CPU_ABI2 + com.huawei.openalliance.ad.constant.x.bQ + System.getProperty("java.library.path");
                    } else {
                        str4 = str3;
                    }
                    if (TextUtils.isEmpty(str4)) {
                        ?? r112 = r21;
                        if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                        }
                    }
                    sVar.h = str4;
                    sVar.n = sb.toString();
                    String absolutePath17 = new File(str2, "apkDex").getAbsolutePath();
                    dl.c(absolutePath17);
                    e(absolutePath17);
                    strA = dk.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                        if (sVar.c.endsWith("v7")) {
                        }
                        dm.a(getClass().getClassLoader(), new File(str + "/" + strA));
                        Engine.soPath = str + "/" + strA;
                        Engine.soVersion = sVar.d;
                        Engine.getInstance(d);
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            r18 = 0;
        }
    }

    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) throws Throwable {
        File file;
        String str3;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.e));
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        try {
                            str3 = Build.CPU_ABI2;
                        } catch (Throwable unused) {
                            str3 = null;
                        }
                        if (name.contains(str4) || ((!TextUtils.isEmpty(str3) && name.contains(str3)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str4) || (!TextUtils.isEmpty(str3) && "armeabi-v7a".equalsIgnoreCase(str3)))))) {
                            String str5 = str + name.substring(3).replace(".so", str2 + ".so");
                            String strSubstring = str5.substring(0, str5.lastIndexOf(47));
                            hashSet.add(strSubstring.substring(strSubstring.lastIndexOf(47) + 1));
                            e(strSubstring);
                            File file2 = new File(str5);
                            file2.delete();
                            file2.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(str5);
                            while (true) {
                                try {
                                    int i = zipInputStream.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream2.write(bArr, 0, i);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    zipInputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream2.close();
                            dl.a(str5, Boolean.TRUE);
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                    try {
                        if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                            String str6 = sVar.m;
                            e(str6);
                            file = new File(str6, sVar.f4726a + com.huawei.openalliance.ad.constant.x.A + sVar.d + ".dex");
                            try {
                                file.delete();
                                file.createNewFile();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int i2 = zipInputStream.read(bArr);
                                        if (i2 <= 0) {
                                            break;
                                        } else {
                                            fileOutputStream3.write(bArr, 0, i2);
                                        }
                                    } catch (Throwable unused2) {
                                        fileOutputStream = fileOutputStream3;
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                    }
                                }
                                fileOutputStream3.close();
                                if (sb.length() > 0) {
                                    sb.setLength(0);
                                }
                                sb.append(file.getAbsolutePath());
                                dl.a(sb.toString(), Boolean.TRUE);
                                fileOutputStream = fileOutputStream3;
                            } catch (Throwable unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        file = null;
                    }
                    zipInputStream.closeEntry();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        zipInputStream.close();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
