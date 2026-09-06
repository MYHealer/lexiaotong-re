package com.jd.ad.sdk.jad_lo;

import android.os.Looper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    /* JADX WARN: Code duplicated, block: B:11:0x003c A[PHI: r0 r1
  0x003c: PHI (r0v2 java.lang.String) = (r0v0 java.lang.String), (r0v4 java.lang.String) binds: [B:10:0x003a, B:8:0x0037] A[DONT_GENERATE, DONT_INLINE]
  0x003c: PHI (r1v2 java.lang.Process) = (r1v1 java.lang.Process), (r1v3 java.lang.Process) binds: [B:10:0x003a, B:8:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    public static String jad_an(String str) {
        String strJad_an = "";
        Process processExec = null;
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                processExec = Runtime.getRuntime().exec(str);
                processExec.getOutputStream().close();
                jad_jt jad_jtVar = new jad_jt(processExec.getInputStream(), false);
                jad_jtVar.start();
                if (processExec.waitFor(2L, TimeUnit.SECONDS)) {
                    strJad_an = jad_jtVar.jad_an();
                }
            }
            if (processExec != null) {
                processExec.destroy();
            }
        } catch (Throwable unused) {
            if (processExec != null) {
                processExec.destroy();
            }
        }
        return strJad_an;
    }
}
