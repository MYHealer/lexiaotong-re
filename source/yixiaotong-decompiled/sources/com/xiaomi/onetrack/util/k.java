package com.xiaomi.onetrack.util;

import android.text.TextUtils;
import android.util.LruCache;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9516a = ijiami_1011.s.s.s.d(new byte[]{32, 12, 13, 4, 99, Ascii.SYN, 8, 8}, "feaa6b");
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{87, 10, 3, 66, 66, 3, 2, 15}, "8df60b");
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{69, 13, 85, 82, 70, 66, 14, 10, 3}, "1b8056");
    private static LruCache<String, a> d = new l(1048576);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9517a;

        private a() {
        }

        public /* synthetic */ a(l lVar) {
            this();
        }
    }

    public static String a() {
        return c(c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.xiaomi.onetrack.util.l] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static String a(String str) throws Throwable {
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        a aVar = d.get(str);
        if (aVar != null) {
            return aVar.f9517a;
        }
        ?? r0 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                File file = new File(b(), str);
                StringBuilder sb = new StringBuilder();
                if (file.exists()) {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } catch (Exception e) {
                            e = e;
                            r0 = bufferedReader;
                            p.c(f9516a, ijiami_1011.s.s.s.d(new byte[]{6, 3, 77, Ascii.DC4, 7, 17, 19, 11, Ascii.DC4, 88}, "af94bc") + e.toString());
                            m.a((Closeable) r0);
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            m.a(bufferedReader2);
                            throw th;
                        }
                    }
                } else {
                    bufferedReader = null;
                }
                String string = sb.toString();
                a aVar2 = new a(r0);
                aVar2.f9517a = string;
                d.put(str, aVar2);
                m.a(bufferedReader);
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String a(String str, int i) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(str);
            StringBuilder sb = new StringBuilder();
            if (file.exists()) {
                bufferedReader = new BufferedReader(new FileReader(file));
                do {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line).append(IOUtils.LINE_SEPARATOR_UNIX);
                        } catch (Exception e) {
                            e = e;
                            p.c(f9516a, ijiami_1011.s.s.s.d(new byte[]{6, 3, 76, 17, 7, Ascii.ETB, 19, 11, Ascii.DC4, 88}, "af81be") + e.toString());
                            m.a(bufferedReader);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        m.a(bufferedReader2);
                        throw th;
                    }
                } while (sb.length() <= i);
            } else {
                bufferedReader = null;
            }
            if (sb.length() > i) {
                String strSubstring = sb.substring(0, i - 1);
                m.a(bufferedReader);
                return strSubstring;
            }
            String string = sb.toString();
            m.a(bufferedReader);
            return string;
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(File file) {
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        } catch (Exception e) {
            p.c(f9516a, ijiami_1011.s.s.s.d(new byte[]{5, 85, 89, 84, 82, 5, 65, 16, 9, 66, 67, 0, 14, 91, 70, 93, Ascii.ETB, 7, 8, 8, 3, 88, 17}, "c4087a") + file.getName() + ijiami_1011.s.s.s.d(new byte[]{74}, "f43bd4") + e.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.xiaomi.onetrack.util.l] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.Closeable] */
    public static void a(String str, String str2) throws Throwable {
        Throwable th;
        ?? r4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                a aVar = new a(r0);
                aVar.f9517a = str2;
                d.put(str, aVar);
                String strB = b();
                File file = new File(strB);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(strB, str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2), 1024);
                try {
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    r4 = bufferedWriter;
                } catch (Exception e) {
                    r0 = bufferedWriter;
                    e = e;
                    try {
                        p.c(f9516a, ijiami_1011.s.s.s.d(new byte[]{69, 16, SignedBytes.MAX_POWER_OF_TWO, 19, 85, 66, 19, 11, Ascii.DC4, 88}, "5e4300") + e.toString());
                        r4 = r0;
                    } catch (Throwable th2) {
                        th = th2;
                        m.a((Closeable) r0);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r0 = bufferedWriter;
                    m.a((Closeable) r0);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            m.a((Closeable) r4);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static String b() {
        return c(b);
    }

    public static void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.remove(str);
            File file = new File(b(), str);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        } catch (Exception e) {
            p.c(f9516a, ijiami_1011.s.s.s.d(new byte[]{87, 92, 93, 3, 19, Ascii.DC2, 4, Ascii.SYN, Ascii.DC4, 13, 67, 95}, "408ba2") + e.toString());
        }
    }

    private static String c(String str) {
        String str2 = com.xiaomi.onetrack.f.a.a().getFilesDir().getAbsolutePath() + File.separator + str;
        File file = new File(str2);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str2;
    }
}
