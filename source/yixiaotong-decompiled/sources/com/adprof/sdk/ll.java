package com.adprof.sdk;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f1291a = new ConcurrentHashMap();

    public static void a(d dVar) {
        String strE;
        String strTrim = (dVar == null || (strE = dVar.e()) == null) ? "" : strE.trim();
        if (TextUtils.isEmpty(strTrim)) {
            return;
        }
        f1291a.remove(strTrim);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x001f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0028  */
    /* JADX WARN: Code duplicated, block: B:19:0x002b A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:16:0x0022, B:19:0x002b, B:20:0x002f, B:23:0x0036, B:25:0x0041, B:27:0x0048), top: B:34:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0035 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0036 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:16:0x0022, B:19:0x002b, B:20:0x002f, B:23:0x0036, B:25:0x0041, B:27:0x0048), top: B:34:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0041 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:16:0x0022, B:19:0x002b, B:20:0x002f, B:23:0x0036, B:25:0x0041, B:27:0x0048), top: B:34:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0047  */
    /* JADX WARN: Code duplicated, block: B:34:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m678a(d dVar) {
        int i;
        String strE;
        String strTrim;
        Integer num;
        int iIntValue;
        try {
            ul ulVarA = vl.a(dVar);
            if (ulVarA != null) {
                String str = ulVarA.i;
                if (TextUtils.isEmpty(str) || (i = Integer.parseInt(str.trim())) < 0) {
                }
                if (i <= 0) {
                    return false;
                }
                if (dVar == null) {
                    strTrim = "";
                } else {
                    try {
                        strE = dVar.e();
                        if (strE == null) {
                            strTrim = "";
                        } else {
                            strTrim = strE.trim();
                        }
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                if (TextUtils.isEmpty(strTrim)) {
                    return false;
                }
                ConcurrentHashMap concurrentHashMap = f1291a;
                num = (Integer) concurrentHashMap.get(strTrim);
                if (num != null) {
                    iIntValue = num.intValue() + 1;
                } else {
                    iIntValue = 1;
                }
                concurrentHashMap.put(strTrim, Integer.valueOf(iIntValue));
                return i > 0 && iIntValue >= i;
            }
        } catch (Throwable unused2) {
        }
        i = 0;
        if (i <= 0) {
            return false;
        }
        if (dVar == null) {
            strTrim = "";
        } else {
            strE = dVar.e();
            if (strE == null) {
                strTrim = "";
            } else {
                strTrim = strE.trim();
            }
        }
        if (TextUtils.isEmpty(strTrim)) {
            return false;
        }
        ConcurrentHashMap concurrentHashMap2 = f1291a;
        num = (Integer) concurrentHashMap2.get(strTrim);
        if (num != null) {
            iIntValue = num.intValue() + 1;
        } else {
            iIntValue = 1;
        }
        concurrentHashMap2.put(strTrim, Integer.valueOf(iIntValue));
        if (i > 0) {
            return false;
        }
    }
}
