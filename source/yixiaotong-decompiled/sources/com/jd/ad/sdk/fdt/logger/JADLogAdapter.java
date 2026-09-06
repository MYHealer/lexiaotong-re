package com.jd.ad.sdk.fdt.logger;

import com.huawei.openalliance.ad.constant.x;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_kt.jad_an;
import com.jd.ad.sdk.jad_kt.jad_bo;
import com.jd.ad.sdk.jad_kt.jad_dq;
import com.jd.ad.sdk.jad_kt.jad_er;
import com.jd.ad.sdk.jad_kt.jad_jt;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADLogAdapter implements jad_bo {
    private final jad_an formatStrategy = jad_er.jad_an().jad_bo(false).jad_an(false).jad_an(0).jad_bo(7).jad_an(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("JADLog").append(JADYunSdk.getSDKVersion()).toString()).jad_an();

    @Override // com.jd.ad.sdk.jad_kt.jad_bo
    public boolean isLoggable(int i, String str) {
        return i != 3;
    }

    /* JADX WARN: String concatenation convert failed
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v1 java.lang.StringBuilder, still in use, count: 1, list:
  (r8v1 java.lang.StringBuilder) from 0x00e7: INVOKE 
  (r8v1 java.lang.StringBuilder)
  (wrap java.lang.String:0x00e3: INVOKE 
  (r9v1 java.lang.String)
  (wrap int:0x00e1: ARITH (wrap int:0x00dd: INVOKE (r9v1 java.lang.String), (".") VIRTUAL call: java.lang.String.lastIndexOf(java.lang.String):int A[MD:(java.lang.String):int (c), WRAPPED] (LINE:15)) + (1 int) A[WRAPPED] (LINE:15))
 VIRTUAL call: java.lang.String.substring(int):java.lang.String A[MD:(int):java.lang.String (c), WRAPPED] (LINE:15))
 VIRTUAL call: java.lang.StringBuilder.append(java.lang.String):java.lang.StringBuilder A[MD:(java.lang.String):java.lang.StringBuilder (c), WRAPPED] (LINE:16)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
    	at jadx.core.dex.visitors.SimplifyVisitor.removeStringBuilderInsns(SimplifyVisitor.java:520)
    	at jadx.core.dex.visitors.SimplifyVisitor.convertStringBuilderChain(SimplifyVisitor.java:440)
    	at jadx.core.dex.visitors.SimplifyVisitor.convertInvoke(SimplifyVisitor.java:337)
    	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:145)
    	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:115)
    	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
    	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
    	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
     */
    @Override // com.jd.ad.sdk.jad_kt.jad_bo
    public void log(int i, String str, String str2) {
        int i2;
        String str3;
        jad_er jad_erVar = (jad_er) this.formatStrategy;
        jad_erVar.getClass();
        str2.getClass();
        String str4 = (jad_jt.jad_an((CharSequence) str) || (str3 = jad_erVar.jad_fs) == str || (str3 != null && str != null && str3.length() == str.length() && str3.equals(str))) ? jad_erVar.jad_fs : jad_erVar.jad_fs + x.A + str;
        if (jad_erVar.jad_dq) {
            jad_erVar.jad_an(i, str4, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
        int length = jad_erVar.jad_an;
        if (jad_erVar.jad_dq) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (jad_erVar.jad_cp) {
                jad_erVar.jad_an(i, str4, com.jd.ad.sdk.jad_bo.jad_bo.jad_an("│ Thread: ").append(Thread.currentThread().getName()).toString());
                if (jad_erVar.jad_dq) {
                    jad_erVar.jad_an(i, str4, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                }
            }
            stackTrace.getClass();
            int i3 = 5;
            while (true) {
                i2 = -1;
                if (i3 >= stackTrace.length) {
                    break;
                }
                String className = stackTrace[i3].getClassName();
                if (!className.equals(jad_dq.class.getName()) && !className.equals(Logger.class.getName())) {
                    i2 = (-1) + i3;
                    break;
                }
                i3++;
            }
            int i4 = i2 + jad_erVar.jad_bo;
            String str5 = "";
            if (length + i4 > stackTrace.length) {
                length = (stackTrace.length - i4) - 1;
            }
            while (length > 0) {
                int i5 = length + i4;
                if (i5 < stackTrace.length) {
                    String className2 = stackTrace[i5].getClassName();
                    className2.getClass();
                    r5.append(str5).append(className2.substring(className2.lastIndexOf(".") + 1)).append(".").append(stackTrace[i5].getMethodName()).append("  (").append(stackTrace[i5].getFileName()).append(x.bQ).append(stackTrace[i5].getLineNumber()).append(")");
                    jad_erVar.jad_an(i, str4, r5.toString());
                    str5 = str5 + "   ";
                }
                length--;
            }
        }
        byte[] bytes = str2.getBytes();
        int length2 = bytes.length;
        if (length2 <= 4000) {
            if (jad_erVar.jad_an > 0 && jad_erVar.jad_dq) {
                jad_erVar.jad_an(i, str4, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
            jad_erVar.jad_bo(i, str4, str2);
            if (!jad_erVar.jad_dq) {
                return;
            }
        } else {
            if (jad_erVar.jad_an > 0 && jad_erVar.jad_dq) {
                jad_erVar.jad_an(i, str4, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
            for (int i6 = 0; i6 < length2; i6 += 4000) {
                jad_erVar.jad_bo(i, str4, new String(bytes, i6, Math.min(length2 - i6, 4000)));
            }
            if (!jad_erVar.jad_dq) {
                return;
            }
        }
        jad_erVar.jad_an(i, str4, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}
