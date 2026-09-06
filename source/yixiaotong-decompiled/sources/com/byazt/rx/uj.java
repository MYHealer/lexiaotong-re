package com.byazt.rx;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.nr.m;
import com.google.android.exoplayer2.C;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 15})
public class uj {
    /* JADX WARN: Code duplicated, block: B:9:0x004e A[DONT_GENERATE, PHI: r4
  0x004e: PHI (r4v4 java.lang.Process) = (r4v3 java.lang.Process), (r4v5 java.lang.Process) binds: [B:8:0x004c, B:4:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<String> c(int i, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i), c(i2)};
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            new c(processExec.getInputStream(), copyOnWriteArrayList).start();
            new c(processExec.getErrorStream(), copyOnWriteArrayList).start();
            new tt(processExec, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).start();
            processExec.waitFor(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MILLISECONDS);
            if (processExec != null) {
            }
        } catch (Throwable th) {
            try {
                m.c(th);
            } finally {
                if (processExec != null) {
                    processExec.destroy();
                }
            }
        }
        return copyOnWriteArrayList;
    }

    @com.byazt.zqa.c(c = {0, 1, 152, AppTypeIdUtil.NewDevice4GBathOTA})
    private static class c extends com.byazt.jtc.ve {
        public InputStream c;
        public List<String> tt;

        public c(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.c = inputStream;
            this.tt = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.c));
            int length = 32768;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.startsWith("---------")) {
                            length -= line.getBytes("UTF-8").length;
                            if (length < 0) {
                                break;
                            } else {
                                this.tt.add(line);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException unused) {
                    com.byazt.mg.a.c(bufferedReader);
                    return;
                } catch (Throwable th) {
                    com.byazt.mg.a.c(bufferedReader);
                    throw th;
                }
            }
            com.byazt.mg.a.c(bufferedReader);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 152, 153})
    private static class tt extends com.byazt.jtc.ve {
        public Process c;
        public long tt;

        public tt(Process process, long j) {
            super("LogcatDump$TimerThread");
            this.c = process;
            this.tt = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.tt);
            } catch (InterruptedException e) {
                m.c(e);
            }
            Process process = this.c;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String c(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }
}
