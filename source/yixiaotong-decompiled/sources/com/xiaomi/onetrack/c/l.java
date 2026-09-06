package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class l {
    private static volatile l f;
    private Handler h;
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{49, 74, Ascii.SYN, Ascii.SYN, 84, 94, 40, 9, Ascii.SYN, 33, 80, 6, 10, 86, 40, 3, 95, 82, 6, 1, Ascii.DC4}, "b3eb13");
    private static final String d = ijiami_1011.s.s.s.d(new byte[]{66, 77, 17, 67, 85, 84, 8, 9, Ascii.SYN, Base64.padSymbol, 82, 4, 82, 92, 7}, "14b709");
    private static String e = ijiami_1011.s.s.s.d(new byte[]{65, 77, 71, Ascii.ETB, 1, 15, 8, 9, Ascii.SYN, Base64.padSymbol, 82, 4, 81, 92, 81, 60, 65, 17}, "244cdb");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9473a = ijiami_1011.s.s.s.d(new byte[]{81, 19, 82, 88, 68, 119, 0, 9, 3}, "4e7609");
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{85, 82, 66, 2}, "136ceb");
    private static String g = ijiami_1011.s.s.s.d(new byte[]{70, 79, 16, 67, 7, 95, 62, 13, 11, Ascii.DC2, 110, 6, 84, 85, 11, 82, Base64.padSymbol, 95, 0, 10, 7, 5, 84, Ascii.ETB}, "56c7b2");

    private l() {
        try {
            HandlerThread handlerThread = new HandlerThread(g);
            handlerThread.start();
            this.h = new Handler(handlerThread.getLooper());
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{97, 26, 74, 17, 81, 89, 40, 9, Ascii.SYN, 33, 80, 6, 90, 6, 116, 4, 90, 85, 6, 1, Ascii.DC4}, "2c9e44"), ijiami_1011.s.s.s.d(new byte[]{107, 74, 67, 17, 82, 88, 40, 9, Ascii.SYN, 33, 80, 6, 80, 86, 125, 4, 89, 84, 6, 1, Ascii.DC4, 66, 88, 11, 81, 71, 16, 49, 95, 71, 14, 19, 7, 0, 93, 0, 2, 19}, "830e75") + th.getMessage());
        }
    }

    public static l a() {
        if (f == null) {
            b();
        }
        return f;
    }

    public static synchronized List<JSONObject> b(String str) {
        BufferedReader bufferedReader;
        ArrayList arrayList;
        FileReader fileReader = null;
        try {
            try {
                try {
                    try {
                        File file = new File(c(), String.format(e, str));
                        if (!file.exists()) {
                            com.xiaomi.onetrack.util.m.a((Closeable) null);
                            com.xiaomi.onetrack.util.m.a((Closeable) null);
                            return null;
                        }
                        arrayList = new ArrayList();
                        try {
                            FileReader fileReader2 = new FileReader(file);
                            try {
                                bufferedReader = new BufferedReader(fileReader2);
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        arrayList.add(new JSONObject(c.a(com.xiaomi.onetrack.d.c.a(line))));
                                    } catch (Exception e2) {
                                        e = e2;
                                        fileReader = fileReader2;
                                        com.xiaomi.onetrack.util.p.b(c, ijiami_1011.s.s.s.d(new byte[]{2, 77, 3, Ascii.DC4, 81, 86, Ascii.NAK, 39, 7, 1, 89, 0, 37, 88, Ascii.SYN, 85, Ascii.SYN, 86, 19, Ascii.SYN, 9, 16, 11, 69}, "a9b463") + e.toString());
                                        e.printStackTrace();
                                        com.xiaomi.onetrack.util.m.a(bufferedReader);
                                        com.xiaomi.onetrack.util.m.a(fileReader);
                                        arrayList = arrayList;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileReader = fileReader2;
                                        com.xiaomi.onetrack.util.m.a(bufferedReader);
                                        com.xiaomi.onetrack.util.m.a(fileReader);
                                        throw th;
                                    }
                                }
                                com.xiaomi.onetrack.util.m.a(bufferedReader);
                                com.xiaomi.onetrack.util.m.a(fileReader2);
                            } catch (Exception e3) {
                                e = e3;
                                bufferedReader = null;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = null;
                            }
                        } catch (Exception e4) {
                            arrayList = arrayList;
                            e = e4;
                            bufferedReader = null;
                        }
                        return arrayList;
                    } catch (Exception e5) {
                        e = e5;
                        bufferedReader = null;
                        arrayList = null;
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
                com.xiaomi.onetrack.util.p.b(c, ijiami_1011.s.s.s.d(new byte[]{2, 77, 3, Ascii.DC4, 81, 86, Ascii.NAK, 39, 7, 1, 89, 0, 37, 88, Ascii.SYN, 85, Ascii.SYN, 86, 19, Ascii.SYN, 9, 16, 11, 69}, "a9b463") + e.toString());
                e.printStackTrace();
                com.xiaomi.onetrack.util.m.a(bufferedReader);
                com.xiaomi.onetrack.util.m.a(fileReader);
                arrayList = arrayList;
            } catch (Throwable th4) {
                th = th4;
                com.xiaomi.onetrack.util.m.a(bufferedReader);
                com.xiaomi.onetrack.util.m.a(fileReader);
                throw th;
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public static void b() {
        if (f == null) {
            synchronized (l.class) {
                if (f == null) {
                    f = new l();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(String str, String str2, String str3) {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            File file = new File(c(), String.format(e, str));
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    new File(file.getParentFile().getAbsolutePath()).mkdirs();
                }
                file.createNewFile();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f9473a, str2);
            jSONObject.put(b, str3);
            byte[] bArrA = c.a(jSONObject.toString());
            fileWriter = new FileWriter(file, true);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter.write(com.xiaomi.onetrack.d.c.a(bArrA));
                    bufferedWriter.newLine();
                } catch (Throwable th) {
                    th = th;
                    fileWriter2 = fileWriter;
                    try {
                        com.xiaomi.onetrack.util.p.b(c, ijiami_1011.s.s.s.d(new byte[]{16, Ascii.FS, 75, 70, 3, 89, 8, 9, Ascii.SYN, 66, 85, 10, 48, 4, 78, 87, 34, 85, Ascii.NAK, 5, 70, 7, 67, Ascii.ETB, 12, Ascii.ETB, 2, Ascii.DC2}, "ce82f4") + th.getMessage());
                        fileWriter = fileWriter2;
                    } catch (Throwable th2) {
                        com.xiaomi.onetrack.util.m.a(bufferedWriter);
                        com.xiaomi.onetrack.util.m.a(fileWriter2);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
        }
        com.xiaomi.onetrack.util.m.a(bufferedWriter);
        com.xiaomi.onetrack.util.m.a(fileWriter);
    }

    private static String c() {
        return com.xiaomi.onetrack.f.a.a().getFilesDir().getAbsolutePath() + File.separator + d;
    }

    public synchronized void a(String str) {
        try {
            File file = new File(c());
            if (file.exists() && file.isDirectory()) {
                String str2 = String.format(e, str);
                File[] fileArrListFiles = file.listFiles();
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    if (fileArrListFiles[i].isFile() && fileArrListFiles[i].getName().equalsIgnoreCase(str2)) {
                        fileArrListFiles[i].delete();
                        break;
                    }
                }
            }
        } catch (Exception e2) {
            com.xiaomi.onetrack.util.p.b(c, ijiami_1011.s.s.s.d(new byte[]{67, 77, SignedBytes.MAX_POWER_OF_TWO, 65, 83, 15, 8, 9, Ascii.SYN, 66, 67, 0, 93, 91, 69, 80, 121, 0, Ascii.DC2, 11, 10, 7, 69, 0, 117, 66, 86, 91, 66, 66, 4, Ascii.SYN, Ascii.DC4, 13, 67, 95, 16}, "04356b") + e2.toString());
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.h == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.h.post(new m(this, str, str2, str3));
    }

    public synchronized void c(String str) {
        if (this.h != null && !TextUtils.isEmpty(str)) {
            this.h.post(new n(this, str));
        }
    }
}
