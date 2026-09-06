package com.xiaomi.onetrack.api;

import android.os.Process;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.CrashAnalysis;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class k implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9431a = ijiami_1011.s.s.s.d(new byte[]{118, 88, 82, 49, 67, 0, 2, 15, 35, 26, 82, 0, 73, 66, 94, 10, 95, 41, 0, 10, 2, 14, 84, Ascii.ETB}, "967e1a");
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 11, 85, 84, Ascii.DC2, 70, 14, 10, 3}, "ad86a2");
    private static final String d = ijiami_1011.s.s.s.d(new byte[]{79, 93, 2, 67, 2, Ascii.ESC, Ascii.EM, 7, Ascii.DC4, 3, 66, 13}, "a7c5c5");
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{90, 86, 2, 10, 66, 71, 0, 7, 3, 66, 87, 0, 89, 67, Ascii.DC4, 19, 83, Ascii.NAK, 8, 0, 92, 104, 56}, "87aa65");
    private static final String f = ijiami_1011.s.s.s.d(new byte[]{85, 70, 17, 91, 65, Ascii.DC4, 19, 1, 7, 17, 94, 11, 10, 62, 106}, "04c434");
    private static final long h = 2;
    private Thread.UncaughtExceptionHandler b;
    private final Date g = new Date();
    private int i = 50;
    private int j = 50;
    private int k = 200;
    private boolean l = true;
    private boolean m = true;

    private String a(Date date, Thread thread, String str) {
        return com.xiaomi.onetrack.util.b.a(this.g, date, ijiami_1011.s.s.s.d(new byte[]{90, 83, 65, 0}, "027af1"), com.xiaomi.onetrack.f.a.e(), com.xiaomi.onetrack.util.b.a(com.xiaomi.onetrack.f.a.b())) + ijiami_1011.s.s.s.d(new byte[]{69, 92, 6, 95, 69}, "55beeb") + Process.myPid() + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 16, 77, 13, 86, 15, 65}, "409d25") + Process.myTid() + ijiami_1011.s.s.s.d(new byte[]{Ascii.US, Ascii.EM, 88, 88, 8, 3, 91, 68}, "3969ef") + thread.getName() + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.NAK, 11, 15, 9, Ascii.DC4}, "955174") + com.xiaomi.onetrack.f.a.e() + ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 8, 8, 13, 62, 51, 11, 5, 16, 3, 17, Ascii.SYN, 67, 85, 87, 90, SignedBytes.MAX_POWER_OF_TWO, 75, 0, 7, 3, 88, 59}, "744149") + str + IOUtils.LINE_SEPARATOR_UNIX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Thread thread, Throwable th) throws Throwable {
        File file;
        String string;
        String strA;
        Date date = new Date();
        RandomAccessFile randomAccessFile = null;
        try {
            file = new File(String.format(Locale.US, ijiami_1011.s.s.s.d(new byte[]{65, 67, 74, 19, Ascii.DC2, 105, 68, 84, 84, 82, 85, 58, 65, 67, 58, 105, 68, 69, 68, Ascii.ETB}, "d0e6a6"), com.xiaomi.onetrack.util.k.a(), c, Long.valueOf(this.g.getTime() * 1000), com.xiaomi.onetrack.util.b.a(com.xiaomi.onetrack.f.a.b()), com.xiaomi.onetrack.f.a.e(), d));
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Exception e2) {
                e = e2;
                com.xiaomi.onetrack.util.p.b(f9431a, ijiami_1011.s.s.s.d(new byte[]{121, 83, Ascii.ETB, 7, 122, 74, 0, Ascii.ETB, 14, 42, 80, 11, 87, 94, 4, Ascii.DC4, Ascii.EM, 91, 19, 1, 7, Ascii.SYN, 84, 41, 92, 85, 39, 15, 85, 93, 65, 2, 7, 11, 93, 0, 87}, "32af98"), e);
            }
        } catch (Exception e3) {
            e = e3;
            file = null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
            try {
                strA = a(date, thread, string);
            } catch (Exception e4) {
                e = e4;
                com.xiaomi.onetrack.util.p.b(f9431a, ijiami_1011.s.s.s.d(new byte[]{127, 4, Ascii.ETB, 84, 118, SignedBytes.MAX_POWER_OF_TWO, 0, Ascii.ETB, 14, 42, 80, 11, 81, 9, 4, 71, Ascii.NAK, 85, 4, 16, 35, 15, 84, Ascii.ETB, 82, 0, 15, 86, 76, Ascii.DC2, 7, 5, 15, 14, 84, 1}, "5ea552"), e);
                strA = null;
            }
        } catch (Exception e5) {
            e = e5;
            string = null;
        }
        if (file == null) {
            return;
        }
        try {
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, ijiami_1011.s.s.s.d(new byte[]{71, 70, Ascii.NAK}, "51fc71"));
                    try {
                        randomAccessFile2.write((e + CrashAnalysis.calculateJavaDigest(string) + "\n\n").getBytes(ijiami_1011.s.s.s.d(new byte[]{101, 102, 39, Ascii.FS, 93}, "02a1e2")));
                        randomAccessFile2.write((f + th.toString() + "\n\n").getBytes(ijiami_1011.s.s.s.d(new byte[]{101, 108, 34, 73, 13}, "08dd51")));
                        if (strA != null) {
                            randomAccessFile2.write(strA.getBytes(ijiami_1011.s.s.s.d(new byte[]{108, 49, 112, 73, 9}, "9e6d10")));
                        }
                        int i = this.k;
                        if (i > 0 || this.i > 0 || this.j > 0) {
                            randomAccessFile2.write(com.xiaomi.onetrack.util.b.a(i, this.i, this.j).getBytes(ijiami_1011.s.s.s.d(new byte[]{102, 54, 114, 75, 10}, "3b4f25")));
                        }
                        if (this.l) {
                            randomAccessFile2.write(com.xiaomi.onetrack.util.b.f().getBytes(ijiami_1011.s.s.s.d(new byte[]{102, 102, 35, 26, 93}, "32e7ee")));
                        }
                        if (this.m) {
                            randomAccessFile2.write(com.xiaomi.onetrack.util.b.e().getBytes(ijiami_1011.s.s.s.d(new byte[]{52, 96, 34, 75, 15}, "a4df72")));
                        }
                        randomAccessFile2.write(com.xiaomi.onetrack.util.b.d().getBytes(ijiami_1011.s.s.s.d(new byte[]{102, 99, 126, 26, 90}, "3787bd")));
                        randomAccessFile2.write(ijiami_1011.s.s.s.d(new byte[]{80, 90, 65, 83, 81, 65, 14, 17, 8, 6, 11, 111, 79, 80, SignedBytes.MAX_POWER_OF_TWO, 60, 60}, "653663").getBytes(ijiami_1011.s.s.s.d(new byte[]{52, 103, 117, 78, 90}, "a33cb4")));
                        randomAccessFile2.close();
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile = randomAccessFile2;
                        com.xiaomi.onetrack.util.p.b(f9431a, ijiami_1011.s.s.s.d(new byte[]{44, 80, 68, 87, 123, 66, 0, Ascii.ETB, 14, 42, 80, 11, 2, 93, 87, 68, Ascii.CAN, 71, 19, 13, Ascii.DC2, 7, 17, 9, 9, 86, Ascii.DC2, 80, 81, 92, 4, 68, 0, 3, 88, 9, 3, 85}, "f12680"), e);
                        if (randomAccessFile == null) {
                        } else {
                            randomAccessFile.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e7) {
                                com.xiaomi.onetrack.util.p.b(f9431a, ijiami_1011.s.s.s.d(new byte[]{114, 4, Ascii.NAK, 85, 113, 19, 0, Ascii.ETB, 14, 42, 80, 11, 92, 9, 6, 70, Ascii.DC2, 2, 13, 11, Ascii.NAK, 7, 17, 55, 89, 11, 7, 91, 95, 32, 2, 7, 3, 17, 66, 35, 81, 9, 6, Ascii.DC4, 84, 0, 8, 8, 3, 6}, "8ec42a"), e7);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e9) {
            com.xiaomi.onetrack.util.p.b(f9431a, ijiami_1011.s.s.s.d(new byte[]{41, 2, 79, 81, 115, 65, 0, Ascii.ETB, 14, 42, 80, 11, 7, 15, 92, 66, 16, 80, 13, 11, Ascii.NAK, 7, 17, 55, 2, 13, 93, 95, 93, 114, 2, 7, 3, 17, 66, 35, 10, 15, 92, 16, 86, 82, 8, 8, 3, 6}, "cc9003"), e9);
        }
    }

    public void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof k) {
            return;
        }
        this.b = defaultUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.d(com.xiaomi.onetrack.util.p.a(f9431a), ijiami_1011.s.s.s.d(new byte[]{83, 17, 0, 68, 93, Ascii.NAK, 9, 5, Ascii.SYN, Ascii.DC2, 84, 11, 85, 7, 76, 9, 70, 65, 0, 7, 13, Ascii.SYN, 67, 4, 83, 6, 91, Ascii.ETB}, "0ca755") + th.getStackTrace());
        FutureTask futureTask = new FutureTask(new l(this, thread, th), null);
        com.xiaomi.onetrack.util.i.a(futureTask);
        try {
            futureTask.get(2L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            Log.e(com.xiaomi.onetrack.util.p.a(f9431a), ijiami_1011.s.s.s.d(new byte[]{88, 88, 93, 84, 15, 87, 36, Ascii.FS, 5, 7, 65, 17, 89, 86, 93, 16, 6, SignedBytes.MAX_POWER_OF_TWO, 19, 11, Ascii.DC4, 66, 11}, "0930c2") + e2.getMessage());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
