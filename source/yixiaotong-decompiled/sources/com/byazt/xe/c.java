package com.byazt.xe;

import com.byazt.uq.sp;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1093, 20})
public class c {
    public static boolean c(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = processExec.getErrorStream();
            InputStream inputStream = processExec.getInputStream();
            c(errorStream);
            c(inputStream);
            if (processExec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
            return false;
        } catch (IOException e) {
            com.byazt.bog.a.c(e);
            return false;
        } catch (InterruptedException e2) {
            com.byazt.bog.a.c(e2);
            return false;
        }
    }

    private static void c(final InputStream inputStream) {
        com.byazt.th.n.tt(new Runnable() { // from class: com.byazt.xe.c.1
            @Override // java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(String.valueOf(line)));
                            } else {
                                sp.c(bufferedReader);
                                return;
                            }
                        } catch (IOException e) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e)));
                            sp.c(bufferedReader);
                            return;
                        }
                    } catch (Throwable th) {
                        sp.c(bufferedReader);
                        throw th;
                    }
                    sp.c(bufferedReader);
                    throw th;
                }
            }
        });
    }
}
