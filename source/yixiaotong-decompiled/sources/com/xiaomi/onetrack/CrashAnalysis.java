package com.xiaomi.onetrack;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import com.xiaomi.onetrack.api.m;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.util.aa;
import com.xiaomi.onetrack.util.ac;
import com.xiaomi.onetrack.util.b;
import com.xiaomi.onetrack.util.i;
import com.xiaomi.onetrack.util.k;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CrashAnalysis {
    private static final int i = 604800000;
    private static final int j = 102400;
    private static final int k = 10;
    private static final int l = 20;
    private static final int r = 20;
    private static final boolean s = false;
    private final FileProcessor[] u;
    private final m v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9375a = s.d(new byte[]{39, 68, 84, Ascii.NAK, 90, 36, 15, 5, 10, Ascii.ESC, 66, 12, Ascii.ETB}, "d65f2e");
    private static final String b = s.d(new byte[]{85, 92, 8, Ascii.US, 73, 8, 0, 11, 11, 11, Ascii.US, 1, 95, 84, 0, 66, 69, 79, 37, 13, 1, 7, 66, 17, 99, 71, 12, 93}, "63e11a");
    private static final String c = s.d(new byte[]{90, 87, 14, 80, Ascii.ETB, 87, Ascii.NAK, 1, 44, 3, 71, 4, 125, 95, 5, 86, 17, 66}, "96b3b6");
    private static final String d = s.d(new byte[]{Ascii.US, 69, 6, 81, 0, 16, 5, 75, Ascii.DC2, 13, 92, 7, 67, 66, 13, 92, 4}, "06b2ab");
    private static final String e = s.d(new byte[]{86, 89, 7, 88, 71, Ascii.DC4, 0, 7, 3, 66, 87, 0, 85, 76, 17, 65, 86, 70, 8, 0, 92, 104, 56}, "48d33f");
    private static final String f = s.d(new byte[]{1, Ascii.ETB, Ascii.SYN, 87, 17, 19, 19, 1, 7, 17, 94, 11, 94, 111, 109}, "ded8c3");
    private static final String g = s.d(new byte[]{117, Ascii.ETB, 86, 67, 9, 17, Ascii.NAK, 13, 11, 7, 11, 69, 17}, "6e70a1");
    public static final String JAVA_CRASH = s.d(new byte[]{9, 81, 66, 89}, "c0484f");
    public static final String ANR_CRASH = s.d(new byte[]{80, 95, 69}, "117052");
    public static final String NATIVE_CRASH = s.d(new byte[]{10, 84, SignedBytes.MAX_POWER_OF_TWO, 80, 79, 4}, "d5499a");
    private static final String h = s.d(new byte[]{Ascii.RS, Ascii.RS, 2, 16, 87, 75, 9}, "0fab68");
    private static final String m = s.d(new byte[]{113, Utf8.REPLACEMENT_BYTE, 83, 79, 12, 86, 76, 2, 39, 79, 119, 56, 74, 85, 79, 83, 5, 74}, "1dcb57");
    private static final String n = s.d(new byte[]{104, 16, 104, 85, 78, 10, 0, 73, 0, 35, Ascii.FS, 35, 105, 79, 2, 73, 82, 3, Ascii.FS, 36, Base64.padSymbol, 82, Ascii.FS, 92, 85, Ascii.EM, 85, 36, 78, 117, 60, Ascii.US, 87, 78, 0, 85, 73}, "443ec3");
    private static final String o = s.d(new byte[]{0, 26, 108, 8, Ascii.DC4, 93, 0, 73, 0, 35, Ascii.FS, 35, 109, Ascii.EM, 6, Ascii.DC4, 8, 84, Ascii.FS}, "0b789d");
    private static final String p = s.d(new byte[]{111, 85, 74, Utf8.REPLACEMENT_BYTE, 123, Ascii.RS, 42, 38, 74, 47, 115, 56, Ascii.EM}, "31ad92");
    private static final String q = s.d(new byte[]{16, Ascii.GS, 88, 3, 68, 87, 91, 77, 26, 74, 93, 0, 86, 82, 70, 10, 15, Ascii.US, Ascii.GS, 76, 15, 12, 85, 0, SignedBytes.MAX_POWER_OF_TWO, 8, Ascii.ESC, Ascii.RS, 26, 127, 15, 0, 3, 26, 11, 76, 68, Ascii.GS, 97, 11, 72, 83, 91, 77, 79, 62, 85, 78}, "852b26");
    private static final AtomicBoolean t = new AtomicBoolean(false);

    public class FileProcessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<File> f9378a = new ArrayList();
        public final String b;
        public final String c;

        public FileProcessor(String str) {
            this.c = str;
            this.b = str + s.d(new byte[]{Ascii.FS, Ascii.FS, 80, 19, 4, 67, 9}, "2d3ae0");
        }

        private String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] strArrSplit = str.split(s.d(new byte[]{105, 58}, "6eea05"));
            if (strArrSplit.length != 2) {
                return null;
            }
            String[] strArrSplit2 = strArrSplit[0].split(s.d(new byte[]{62}, "a3e1bd"));
            if (strArrSplit2.length == 3) {
                return strArrSplit2[2];
            }
            return null;
        }

        public void a() throws Throwable {
            for (int i = 0; i < this.f9378a.size(); i++) {
                String absolutePath = this.f9378a.get(i).getAbsoluteFile().getAbsolutePath();
                String strA = a(absolutePath);
                String strA2 = k.a(absolutePath, 102400);
                if (!TextUtils.isEmpty(strA2) && CrashAnalysis.this.v != null) {
                    String strD = CrashAnalysis.d(strA2, this.c);
                    String strC = CrashAnalysis.c(strA2, this.c);
                    long jB = CrashAnalysis.b(strA2);
                    p.a(s.d(new byte[]{34, 68, 89, 71, 91, 113, 15, 5, 10, Ascii.ESC, 66, 12, Ascii.DC2}, "a68430"), s.d(new byte[]{95, 94, 84, 1, 118, 80, 12, 1, 92, 66}, "978d81") + absolutePath);
                    p.a(s.d(new byte[]{34, 68, 7, 16, 10, 119, 15, 5, 10, Ascii.ESC, 66, 12, Ascii.DC2}, "a6fcb6"), s.d(new byte[]{7, 7, 83, Ascii.ETB, 76, 70, 4, 68, 15, 6, 11, 69}, "ab2c94") + strD);
                    p.a(s.d(new byte[]{33, 69, 84, 71, 90, 117, 15, 5, 10, Ascii.ESC, 66, 12, 17}, "b75424"), s.d(new byte[]{81, 17, 17, 13, Ascii.DC4, 11, 65}, "4ccbf1") + strC);
                    p.a(s.d(new byte[]{39, 17, 83, 75, 95, 112, 15, 5, 10, Ascii.ESC, 66, 12, Ascii.ETB}, "dc2871"), s.d(new byte[]{80, Ascii.SYN, 0, 71, 94, 103, 8, 9, 3, 49, 69, 4, 94, Ascii.DC4, 91, Ascii.DC4}, "3da463") + jB);
                    CrashAnalysis.this.v.a(strA2, strC, this.c, strA, strD, jB);
                    k.a(new File(absolutePath));
                    p.a(s.d(new byte[]{113, 69, 7, 67, 91, 34, 15, 5, 10, Ascii.ESC, 66, 12, 65}, "27f03c"), s.d(new byte[]{66, 92, 93, 13, 69, 86, 65, Ascii.SYN, 3, Ascii.DC2, 94, Ascii.ETB, 68, 92, 84, 66, 80, 65, 0, Ascii.ETB, 14, 66, 87, 12, 92, 92}, "090b33"));
                }
            }
        }

        public boolean a(File file) {
            if (!file.getName().contains(this.b)) {
                return false;
            }
            this.f9378a.add(file);
            return true;
        }
    }

    private CrashAnalysis(Context context, m mVar) {
        try {
            Object objNewInstance = Class.forName(s.d(new byte[]{79, 91, Ascii.DC4, 88, 65, 93, 79, 60, 37, 16, 80, Ascii.SYN, 95, Ascii.FS, 47, 87, 91, 65, 49, 5, Ascii.DC4, 3, 92, 0, 67, 93, Ascii.DC4, 74}, "78f925")).getConstructor(new Class[0]).newInstance(new Object[0]);
            String strD = s.d(new byte[]{Ascii.SYN, 86, Ascii.NAK, 121, 82, 77, 8, Ascii.DC2, 3, 38, 68, 8, Ascii.NAK, 114, 13, 91, 103, 81, 19, 1, 7, 6, 66}, "e3a739");
            Boolean bool = Boolean.FALSE;
            a(objNewInstance, strD, bool);
            a(objNewInstance, s.d(new byte[]{74, 93, 77, 47, 93, 95, 37, 13, Ascii.DC4}, "989c28"), a());
            a(objNewInstance, s.d(new byte[]{17, 6, 69, 42, 82, 76, 8, Ascii.DC2, 3, 38, 68, 8, Ascii.DC2, 46, 80, Ascii.DC4}, "bc1d38"), bool);
            a(objNewInstance, s.d(new byte[]{Ascii.DC2, 85, Ascii.SYN, 43, 81, SignedBytes.MAX_POWER_OF_TWO, 8, Ascii.DC2, 3, 38, 68, 8, 17, 118, 6, Ascii.SYN}, "a0be04"), bool);
            a(objNewInstance, s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 81, 65, 44, 89, 69, 0, 32, 19, 15, 65, 36, 95, 88, 97, 14, 74, 86, 0, 0, Ascii.NAK}, "345f83"), bool);
            a(objNewInstance, s.d(new byte[]{67, 83, 65, 35, 92, 16, 51, 1, Ascii.DC2, 10, 67, 10, 71}, "065b2b"), bool);
            Class.forName(s.d(new byte[]{Ascii.GS, 90, 75, 7, 16, 12, 79, 60, 37, 16, 80, Ascii.SYN, 13}, "e99fcd")).getDeclaredMethod(s.d(new byte[]{88, 13, 92, 77}, "1c59b3"), Context.class, objNewInstance.getClass()).invoke(null, StubApp.getOrigApplicationContext(context.getApplicationContext()), objNewInstance);
            p.a(s.d(new byte[]{123, Ascii.SYN, 7, 17, 81, 114, 15, 5, 10, Ascii.ESC, 66, 12, 75}, "8dfb93"), s.d(new byte[]{60, 38, 68, 89, Ascii.ETB, 95, 65, 13, 8, 11, 69, 69, Ascii.ETB, 16, 85, 91, 1, 68, Ascii.DC2}, "de68d7"));
        } catch (Throwable th) {
            p.a(s.d(new byte[]{122, 75, 82, Ascii.ETB, 80, 114, 15, 5, 10, Ascii.ESC, 66, 12, 74}, "993d83"), s.d(new byte[]{97, 115, 71, 2, 66, 94, 65, 13, 8, 11, 69, 69, 95, 81, 92, 15, 84, 82, 91, 68}, "905c16") + th.toString());
        }
        this.v = mVar;
        this.u = new FileProcessor[]{new FileProcessor(s.d(new byte[]{9, 80, 78, 89}, "c18860")), new FileProcessor(s.d(new byte[]{81, 94, 17}, "00c24e")), new FileProcessor(s.d(new byte[]{89, 88, SignedBytes.MAX_POWER_OF_TWO, 92, Ascii.DC2, 1}, "7945dd"))};
    }

    private static String a() {
        return k.a();
    }

    private void a(long j2) {
        aa.d((ac.b() * 100) + j2);
    }

    public static void a(Context context) {
        try {
            a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            Class.forName(s.d(new byte[]{Ascii.ESC, 87, 16, 3, Ascii.NAK, 89, 79, 60, 37, 16, 80, Ascii.SYN, 11}, "c4bbf1")).getDeclaredMethod(s.d(new byte[]{12, 90, 90, 76, 44, 11, 14, 15, 3, 16}, "e438dd"), Context.class, String.class).invoke(null, StubApp.getOrigApplicationContext(context.getApplicationContext()), a());
            Log.d(f9375a, s.d(new byte[]{69, 1, 85, 80, 65, 16, 4, Ascii.SYN, 46, 13, 94, 14, Ascii.ETB, Ascii.ETB, 71, 90, 81, 1, 4, 0, 3, 6}, "7d292d"));
        } catch (Throwable th) {
            Log.d(f9375a, s.d(new byte[]{Ascii.SYN, 85, 4, 89, Ascii.SYN, 69, 4, Ascii.SYN, 46, 13, 94, 14, 68, 86, 2, 89, 9, 84, 5, 94, 70}, "d0c0e1") + th.toString());
        }
    }

    private void a(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException {
        obj.getClass().getDeclaredMethod(str, obj2.getClass() == Boolean.class ? Boolean.TYPE : obj2.getClass()).invoke(obj, obj2);
    }

    private long b() {
        String str;
        String strD;
        long jC = aa.c();
        if (jC == 0) {
            str = f9375a;
            strD = s.d(new byte[]{89, 90, 67, 76, 89, 91, 10, 1, Ascii.DC2, 66, 85, 4, 67, 84, 67, 94, 95, 77, 15, 0, 74, 66, 67, 0, 67, SignedBytes.MAX_POWER_OF_TWO, 17, 86, 16, 85, 0, Ascii.FS, 70, 1, 94, 16, 89, 65}, "75c808");
        } else {
            long jB = ac.b();
            if (jC / 100 == jB) {
                long j2 = jC - (jB * 100);
                p.a(f9375a, s.d(new byte[]{65, 92, 81, 88, 79, Ascii.ETB, Ascii.DC2, 68, Ascii.DC4, 7, 92, 4, 92, 93, Ascii.NAK, 77, 95, 83, 10, 1, Ascii.DC2, 66, 88, Ascii.SYN, Ascii.NAK}, "535960") + j2);
                return j2;
            }
            str = f9375a;
            strD = s.d(new byte[]{87, 86, Ascii.EM, 16, 92, 5, 0, Ascii.GS, 65, 17, 17, 17, 80, 90, 82, 1, 71, 77, 65, Ascii.SYN, 3, Ascii.SYN, 68, Ascii.ETB, 87, Ascii.EM, 84, 5, 75, 65, 2, 11, 19, 12, 69}, "999d3a");
        }
        p.a(str, strD);
        return 10L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(String str) {
        int i2;
        int iIndexOf;
        if (!TextUtils.isEmpty(str)) {
            try {
                int iIndexOf2 = str.indexOf(g);
                if (iIndexOf2 != -1 && (iIndexOf = str.indexOf(s.d(new byte[]{65, Utf8.REPLACEMENT_BYTE}, "f58f95"), (i2 = iIndexOf2 + 13))) != -1) {
                    return b.a(str.substring(i2, iIndexOf));
                }
            } catch (Exception e2) {
                p.b(f9375a, s.d(new byte[]{81, 7, Ascii.DC2, 34, 16, 88, Ascii.DC2, 12, 50, 11, 92, 0, 101, Ascii.SYN, 7, 12, Ascii.DC2, Ascii.EM, 4, Ascii.SYN, Ascii.DC4, 13, 67, 95, Ascii.SYN}, "6bfab9") + e2.toString());
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, String str2) {
        int i2;
        int iIndexOf;
        int iIndexOf2;
        String strD = s.d(new byte[]{16, 94, 82, 3, 16, 83, 6, 11, Ascii.DC4, 11, 84, 1}, "e01bd6");
        if (TextUtils.isEmpty(str)) {
            return strD;
        }
        try {
            if (str2.equals(ANR_CRASH)) {
                int iIndexOf3 = str.indexOf(s.d(new byte[]{Ascii.ETB, 77, 8, 84, 12, 5, 65}, "79a014"));
                if (iIndexOf3 == -1 || (iIndexOf2 = str.indexOf(s.d(new byte[]{107, 69, Ascii.EM, 84, Ascii.NAK, Ascii.SYN}, "ae95a6"), iIndexOf3)) == -1 || (iIndexOf = str.indexOf(10, iIndexOf2 + 6)) == -1) {
                    return strD;
                }
                i2 = iIndexOf2 + 2;
            } else {
                int iIndexOf4 = str.indexOf(f);
                if (iIndexOf4 == -1 || (iIndexOf = str.indexOf("\n\n", (i2 = iIndexOf4 + 15))) == -1) {
                    return strD;
                }
            }
            return str.substring(i2, iIndexOf);
        } catch (Exception e2) {
            p.b(f9375a, s.d(new byte[]{2, 7, 68, 113, 19, 19, 14, Ascii.SYN, 52, 7, 80, Ascii.SYN, 10, 12, 99, SignedBytes.MAX_POWER_OF_TWO, 19, 8, 15, 3, 70, 7, 67, Ascii.ETB, 10, 16, 10, Ascii.DC4}, "eb04aa") + e2.toString());
            return strD;
        }
    }

    private List<File> c() {
        File[] fileArrListFiles = new File(a()).listFiles();
        if (fileArrListFiles == null) {
            p.a(f9375a, s.d(new byte[]{77, 81, 95, Ascii.NAK, 65, 67, 0, 16, 14, 66, 85, 10, 92, 74, Ascii.SYN, 8, 14, 71, 65, 0, 3, 12, 94, 17, 92, Ascii.EM, 87, 70, 5, 90, 19, 1, 5, Ascii.SYN, 94, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, Ascii.NAK, Ascii.SYN, 9, 19, 19, 8, 2, 70, 3, 95, 69, 112, Ascii.SYN, 121, 70, 4, 65, 19, 11, Ascii.DC4, 66, 94, 6, 90, 76, 68, Ascii.NAK, 79}, "996fa3"));
            return null;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new Comparator<File>() { // from class: com.xiaomi.onetrack.CrashAnalysis.2
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                return (int) (file.lastModified() - file2.lastModified());
            }
        });
        int size = listAsList.size();
        if (size <= 20) {
            return listAsList;
        }
        int i2 = size - 20;
        for (int i3 = 0; i3 < i2; i3++) {
            k.a(listAsList.get(i3));
        }
        return listAsList.subList(i2, size);
    }

    public static String calculateJavaDigest(String str) {
        String[] strArrSplit = str.replaceAll(s.d(new byte[]{56, 68}, "d0c260"), "").split(s.d(new byte[]{104, 89}, "47210e"));
        StringBuilder sb = new StringBuilder();
        int iMin = Math.min(strArrSplit.length, 20);
        for (int i2 = 0; i2 < iMin; i2++) {
            strArrSplit[i2] = strArrSplit[i2].replaceAll(q, s.d(new byte[]{69, 9, 104, 58}, "a80bb0")).replaceAll(s.d(new byte[]{105, 70, Utf8.REPLACEMENT_BYTE, 4, Ascii.FS, 10, 0, 73, 0, 35, Ascii.FS, 35, 104, Ascii.EM, 85, Ascii.CAN, 0, 3, Ascii.FS, 36, Base64.padSymbol, 82, Ascii.FS, 92, 84, 79, 2, 117, Ascii.FS, 117, 60, Ascii.US, 87, 78, 0, 85, 72, Ascii.RS, 36, 111, 1, Ascii.RS, 88, 5, 75, 4, 112, 72, 115, Utf8.REPLACEMENT_BYTE, Ascii.US, 5, Ascii.GS, 2, 81, Ascii.EM, 26, 82, 73, 62, 5, 79, 93, 85, Ascii.FS, 85, 32, 73, 32, Utf8.REPLACEMENT_BYTE, 74, 84, Ascii.EM, 83, 84, 73}, "5bd413"), s.d(new byte[]{97, 106}, "929889")).replaceAll(p, "");
        }
        for (int i3 = 0; i3 < iMin && (!strArrSplit[i3].contains(s.d(new byte[]{72, Ascii.CAN, 76}, "f6b98f")) || !strArrSplit[i3].contains(s.d(new byte[]{15, 11, 68, 85}, "bd6053"))); i3++) {
            sb.append(strArrSplit[i3]);
            sb.append('\n');
        }
        return d.h(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x006f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0048 -> B:21:0x006f). Please report as a decompilation issue!!! */
    public static String d(String str, String str2) {
        int i2;
        int iIndexOf;
        String strSubstring;
        int iIndexOf2;
        if (TextUtils.isEmpty(str)) {
            strSubstring = "";
        } else {
            try {
                if (str2.equals(ANR_CRASH)) {
                    int iIndexOf3 = str.indexOf(s.d(new byte[]{17, Ascii.DC2, 80, 93, 12, 0, 65}, "1f9911"));
                    if (iIndexOf3 == -1 || (iIndexOf2 = str.indexOf("\n\n", iIndexOf3)) == -1) {
                        strSubstring = "";
                    } else {
                        strSubstring = calculateJavaDigest(str.substring(iIndexOf3, iIndexOf2));
                    }
                } else {
                    int iIndexOf4 = str.indexOf(e);
                    if (iIndexOf4 == -1 || (iIndexOf = str.indexOf("\n\n", (i2 = iIndexOf4 + 23))) == -1) {
                        strSubstring = "";
                    } else {
                        strSubstring = str.substring(i2, iIndexOf);
                    }
                }
            } catch (Exception e2) {
                p.b(f9375a, s.d(new byte[]{82, 85, 89, 86, 68, 91, 0, 16, 3, 36, 84, 4, 69, 65, 71, 80, 120, 83, 65, 1, Ascii.DC4, 16, 94, Ascii.ETB, 11, Ascii.DC4}, "145517") + e2.toString());
            }
        }
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        boolean z;
        Iterator<File> it;
        List<File> listC = c();
        long jB = b();
        if (listC == null || listC.size() <= 0) {
            z = false;
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jB2 = aa.b();
            long j2 = 604800000;
            if (jB2 > jCurrentTimeMillis) {
                jB2 = jCurrentTimeMillis - 604800000;
            }
            Iterator<File> it2 = listC.iterator();
            long j3 = 0;
            long j4 = 0;
            boolean z2 = false;
            while (it2.hasNext()) {
                File next = it2.next();
                long jLastModified = next.lastModified();
                if (jLastModified < jCurrentTimeMillis - j2 || jLastModified > jCurrentTimeMillis) {
                    p.a(f9375a, s.d(new byte[]{75, 82, 14, 95, 16, 4, 65, 11, 4, 17, 94, 9, 92, 67, 6, 16, 5, 19, 0, Ascii.ETB, 14, 66, 87, 12, 85, 82, 16, 10, 70}, "97c0fa") + next.getName());
                    k.a(next);
                } else if (jLastModified <= jB2) {
                    p.a(f9375a, s.d(new byte[]{82, 14, Ascii.ETB, 91, 1, 67, 0, 8, Ascii.DC4, 7, 80, 1, 77, 65, 16, 80, Ascii.NAK, 12, 19, 16, 3, 6, 17, 6, 70, 0, 17, 93, 69, 5, 8, 8, 3, 78, 17, 12, 83, 15, 13, 71, 0}, "4ab5ec"));
                } else {
                    if (jB > j3) {
                        FileProcessor[] fileProcessorArr = this.u;
                        int length = fileProcessorArr.length;
                        int i2 = 0;
                        while (i2 < length) {
                            if (fileProcessorArr[i2].a(next)) {
                                it = it2;
                                p.a(f9375a, s.d(new byte[]{84, 12, 95, 83, 68, 91, 19, 5, Ascii.NAK, 10, 17, 3, 91, 9, 84, 13}, "2e17d8") + next.getName());
                                jB--;
                                z2 = true;
                                if (j4 < jLastModified) {
                                    j4 = jLastModified;
                                }
                            } else {
                                it = it2;
                            }
                            i2++;
                            it2 = it;
                        }
                    }
                    j2 = 604800000;
                    j3 = 0;
                }
                it2 = it2;
                j2 = 604800000;
                j3 = 0;
            }
            if (j4 > j3) {
                aa.c(j4);
            }
            z = z2;
        }
        if (z) {
            a(jB);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws Throwable {
        for (FileProcessor fileProcessor : this.u) {
            fileProcessor.a();
        }
    }

    public static boolean isSupport() {
        try {
            Class.forName(s.d(new byte[]{74, 91, 66, 80, Ascii.DC2, 10, 79, 60, 37, 16, 80, Ascii.SYN, 90}, "2801ab"));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void start(final Context context, final m mVar) {
        if (t.compareAndSet(false, true)) {
            i.a(new Runnable() { // from class: com.xiaomi.onetrack.CrashAnalysis.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CrashAnalysis crashAnalysis = new CrashAnalysis(context, mVar);
                        if (crashAnalysis.d()) {
                            crashAnalysis.e();
                        } else {
                            p.a(s.d(new byte[]{113, Ascii.SYN, 84, SignedBytes.MAX_POWER_OF_TWO, 95, 115, 15, 5, 10, Ascii.ESC, 66, 12, 65}, "2d5372"), s.d(new byte[]{90, 86, 66, 6, 75, 0, Ascii.DC2, 12, 70, 4, 88, 9, 81, Ascii.EM, 4, 10, 76, 15, 5}, "49be9a"));
                        }
                    } catch (Throwable th) {
                        p.b(s.d(new byte[]{117, 70, 3, 65, 95, 36, 15, 5, 10, Ascii.ESC, 66, 12, 69}, "64b27e"), s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 69, 9, 91, 87, Ascii.SYN, Ascii.DC2, 39, Ascii.DC4, 3, 66, 13, 16, 82, Ascii.DC4, 74, 93, Ascii.ETB, 91, 68}, "07f82e") + th.toString());
                    }
                }
            });
        } else {
            p.b(f9375a, s.d(new byte[]{Ascii.DC4, 77, 13, Ascii.SYN, 15, 0, Ascii.NAK, 12, 9, 6, 17, 13, 7, 75, 67, 84, 7, 0, 15, 68, 15, 12, 71, 10, 13, 93, 7, Ascii.SYN, 15, 10, 19, 1, 70, Ascii.SYN, 89, 4, 8, Ascii.CAN, 12, 88, 1, 0}, "f8c6be"));
        }
    }
}
