package com.xiaomi.onetrack.c;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f9470a = 0;
    public static final long b = 1;
    public static final long c = 2;
    private static final String f = ijiami_1011.s.s.s.d(new byte[]{121, 82, Ascii.ETB, 17, 86, 17, 10, 37, 5, 1, 84, Ascii.SYN, 68, 122, 2, 8, 88, 4, 4, Ascii.SYN}, "77cf9c");
    private static final String g = ijiami_1011.s.s.s.d(new byte[]{91, 7, 77, 78, 92, SignedBytes.MAX_POWER_OF_TWO, 10, 37, 5, 1, 84, Ascii.SYN, 70}, "5b9932");
    private static String h = ijiami_1011.s.s.s.d(new byte[]{93, 88, 82, 66, 70, 80, 2, 15, 57, 12, 84, 17, 83, 85, 84, 83, 71, 66, 62, 65, Ascii.NAK}, "267641");
    public static final String d = ijiami_1011.s.s.s.d(new byte[]{7, 78, 86, 11, 71, 40, 0, 9, 3}, "b83e3f");
    public static final String e = ijiami_1011.s.s.s.d(new byte[]{92, 87, 68, 84}, "86053f");
    private static SimpleDateFormat i = new SimpleDateFormat(ijiami_1011.s.s.s.d(new byte[]{65, 26, 26, 26, 117, 41, 5, 0}, "8ccc8d"));
    private static boolean j = false;
    private static volatile boolean k = true;
    private static volatile boolean l = false;

    public static synchronized void a(com.xiaomi.onetrack.api.j jVar) {
        if (d()) {
            if (jVar != null && b()) {
                l = true;
                com.xiaomi.onetrack.util.i.a(new k(jVar));
            }
        }
    }

    public static void a(String str, String str2) {
        com.xiaomi.onetrack.util.i.a(new j(str, str2));
    }

    public static void a(boolean z) {
        j = z;
    }

    public static boolean a() {
        return j;
    }

    public static void b(boolean z) {
        File file = new File(com.xiaomi.onetrack.f.a.a().getFilesDir(), ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 90, 16, 109, 94, 7, Ascii.NAK, 59, 7, 14, 93, 10, 78, 80, 0}, "95d20b"));
        File file2 = new File(com.xiaomi.onetrack.f.a.a().getFilesDir(), ijiami_1011.s.s.s.d(new byte[]{75, 90, 17, 108, 13, 84, Ascii.NAK, 59, 2, 11, 66, 4, 9, 89, 10, 68, 6, 85}, "e5e3c1"));
        try {
            if (z) {
                file.createNewFile();
                if (file2.exists()) {
                    file2.delete();
                }
            } else {
                file2.createNewFile();
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (IOException e2) {
            com.xiaomi.onetrack.util.p.b(f, ijiami_1011.s.s.s.d(new byte[]{68, 81, 16, 127, 1, Ascii.NAK, Ascii.SYN, 11, Ascii.DC4, 9, 112, 6, 84, 81, Ascii.ETB, 66, 55, Ascii.NAK, 0, 16, 3, 39, 95, 4, 85, 88, 1, 85, 94, 65}, "74d1da") + z + ijiami_1011.s.s.s.d(new byte[]{83, 2, 92, 84, 93, 83, 65}, "5c5887"), e2);
        }
    }

    public static boolean b() {
        return !new File(com.xiaomi.onetrack.f.a.a().getFilesDir(), ijiami_1011.s.s.s.d(new byte[]{79, 88, Ascii.NAK, Base64.padSymbol, 88, 3, Ascii.NAK, 59, 2, 11, 66, 4, 13, 91, 14, Ascii.NAK, 83, 2}, "a7ab6f")).exists();
    }

    public static synchronized List<JSONObject> c() {
        BufferedReader bufferedReader;
        Exception exc;
        File file = new File(e(), String.format(h, i.format(new Date())));
        FileReader fileReader = null;
        if (!file.exists()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
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
                        exc = e2;
                        fileReader = fileReader2;
                        try {
                            com.xiaomi.onetrack.util.p.b(f, ijiami_1011.s.s.s.d(new byte[]{80, 71, 2, 66, 5, 81, Ascii.NAK, 39, 7, 1, 89, 0, 119, 82, Ascii.ETB, 3, 66, 81, 19, Ascii.SYN, 9, 16, 11, 69}, "33cbb4") + exc.toString());
                            exc.printStackTrace();
                            com.xiaomi.onetrack.util.m.a(bufferedReader);
                            com.xiaomi.onetrack.util.m.a(fileReader);
                        } catch (Throwable th) {
                            th = th;
                            com.xiaomi.onetrack.util.m.a(bufferedReader);
                            com.xiaomi.onetrack.util.m.a(fileReader);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = fileReader2;
                        com.xiaomi.onetrack.util.m.a(bufferedReader);
                        com.xiaomi.onetrack.util.m.a(fileReader);
                        throw th;
                    }
                }
                com.xiaomi.onetrack.util.m.a(bufferedReader);
                com.xiaomi.onetrack.util.m.a(fileReader2);
            } catch (Exception e3) {
                exc = e3;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e4) {
            exc = e4;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        int size = arrayList.size();
        List<JSONObject> listSubList = arrayList;
        if (size > 200) {
            listSubList = arrayList.subList(arrayList.size() - 200, arrayList.size());
        }
        if (listSubList.size() > 0) {
            k = true;
        }
        return listSubList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, String str2) {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        File file = new File(e(), String.format(h, i.format(new Date())));
        FileWriter fileWriter2 = null;
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    new File(file.getParentFile().getAbsolutePath()).mkdirs();
                }
                file.createNewFile();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d, str);
            jSONObject.put(e, str2);
            byte[] bArrA = c.a(jSONObject.toString());
            fileWriter = new FileWriter(file, true);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter.write(com.xiaomi.onetrack.d.c.a(bArrA));
                    bufferedWriter.newLine();
                    k = true;
                } catch (Exception e2) {
                    e = e2;
                    fileWriter2 = fileWriter;
                    try {
                        com.xiaomi.onetrack.util.p.b(f, ijiami_1011.s.s.s.d(new byte[]{83, 68, 87, Ascii.SYN, 6, 12, 50, 5, 16, 7, 117, 4, 68, 81, Ascii.SYN, 83, 16, 17, 14, Ascii.SYN, 92, 66}, "0066bc") + e.toString());
                        e.printStackTrace();
                        fileWriter = fileWriter2;
                    } catch (Throwable th) {
                        th = th;
                        com.xiaomi.onetrack.util.m.a(bufferedWriter);
                        com.xiaomi.onetrack.util.m.a(fileWriter2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter2 = fileWriter;
                    com.xiaomi.onetrack.util.m.a(bufferedWriter);
                    com.xiaomi.onetrack.util.m.a(fileWriter2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedWriter = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
        }
        com.xiaomi.onetrack.util.m.a(bufferedWriter);
        com.xiaomi.onetrack.util.m.a(fileWriter);
    }

    public static synchronized void c(boolean z) {
        try {
            File file = new File(e());
            if (file.exists() && file.isDirectory()) {
                String str = String.format(h, i.format(new Date()));
                File[] fileArrListFiles = file.listFiles();
                for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                    if (fileArrListFiles[i2].isFile() && (z || !fileArrListFiles[i2].getName().equalsIgnoreCase(str))) {
                        fileArrListFiles[i2].delete();
                    }
                }
                if (file.listFiles().length == 0) {
                    k = false;
                }
                return;
            }
            k = false;
        } catch (Exception e2) {
            com.xiaomi.onetrack.util.p.b(f, ijiami_1011.s.s.s.d(new byte[]{85, 70, 85, Ascii.SYN, 70, 92, 12, 11, 16, 7, 126, 7, 69, 93, 88, 83, SignedBytes.MAX_POWER_OF_TWO, 92, 36, Ascii.DC2, 3, 12, 69, 69, 83, SignedBytes.MAX_POWER_OF_TWO, 70, 89, 70, 3, 65}, "624649") + e2.toString());
            e2.printStackTrace();
        }
    }

    public static boolean d() {
        return !l && k;
    }

    private static String e() {
        return com.xiaomi.onetrack.f.a.a().getFilesDir().getAbsolutePath() + File.separator + g;
    }
}
