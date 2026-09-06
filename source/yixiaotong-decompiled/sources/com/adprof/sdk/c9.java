package com.adprof.sdk;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c9 implements cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5 f1105a;

    static {
        int i = lp.f1294a;
    }

    public c9(t5 t5Var, p6 p6Var) {
        this.f1105a = t5Var;
    }

    public static void a(String str, li liVar, jp jpVar) throws jp {
        q7 q7Var = liVar.f445a;
        int i = q7Var.c;
        try {
            q7Var.a(jpVar);
            String.format("%s-retry [RetryCount %s]  [timeout=%s]", str, Integer.valueOf(q7Var.d), Integer.valueOf(i));
            int i2 = kp.f1273a;
        } catch (jp e) {
            String.format("%s-timeout-giveup [RetryCount %s] [timeout=%s]", str, Integer.valueOf(q7Var.d), Integer.valueOf(i));
            int i3 = kp.f1273a;
            throw e;
        }
    }

    public static Map a(List list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < list.size(); i++) {
            w9 w9Var = (w9) list.get(i);
            treeMap.put(w9Var.f1495a, w9Var.b);
        }
        return treeMap;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005a A[Catch: IOException -> 0x0080, MalformedURLException -> 0x0087, SocketTimeoutException -> 0x013f, TryCatch #6 {IOException -> 0x0080, blocks: (B:7:0x0019, B:9:0x0025, B:11:0x003b, B:13:0x003f, B:15:0x0043, B:18:0x004f, B:20:0x005a, B:25:0x0066, B:27:0x007a, B:28:0x007f, B:16:0x004b), top: B:85:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0091  */
    /* JADX WARN: Code duplicated, block: B:41:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:88:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x010f A[SYNTHETIC] */
    @Override // com.adprof.sdk.cg
    public fg a(li liVar) throws jp {
        int i;
        jp egVar;
        String str;
        fg fgVar;
        w3 w3Var;
        byte[] bArrA;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            int i2 = lp.f1294a;
            List listEmptyList = Collections.emptyList();
            ia iaVar = null;
            byte[] bArr = null;
            try {
                try {
                    try {
                        ia iaVarA = this.f1105a.a(liVar, Collections.emptyMap());
                        try {
                            int i3 = iaVarA.f1227a;
                            List listUnmodifiableList = Collections.unmodifiableList(iaVarA.f378a);
                            if (i3 == 304) {
                                return new fg(304, null, fg.a(listUnmodifiableList), listUnmodifiableList, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            }
                            if (iaVarA.f377a != null) {
                                if (liVar instanceof e9) {
                                    bArrA = ((e9) liVar).a(iaVarA);
                                }
                                if (SystemClock.elapsedRealtime() - jElapsedRealtime > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                                    int i4 = liVar.f445a.d;
                                }
                                if (i3 < 200 && i3 <= 299) {
                                    return new fg(i3, bArr, fg.a(listUnmodifiableList), listUnmodifiableList, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                }
                                throw new IOException();
                            }
                            bArrA = new byte[0];
                            bArr = bArrA;
                            if (SystemClock.elapsedRealtime() - jElapsedRealtime > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                                int i5 = liVar.f445a.d;
                            }
                            if (i3 < 200) {
                            }
                            throw new IOException();
                        } catch (IOException e) {
                            e = e;
                            iaVar = iaVarA;
                            if (iaVar != null) {
                                throw new kg(e);
                            }
                            i = iaVar.f1227a;
                            lp.m679a("%s Unexpected response code %d for %s", e.getMessage(), Integer.valueOf(i), liVar.m674a());
                            if (iaVar != 0) {
                                fgVar = new fg(i, 0, fg.a(listEmptyList), listEmptyList, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                if (i != 401) {
                                }
                                w3Var = new w3(fgVar);
                                a(com.alipay.sdk.app.statistic.c.d, liVar, w3Var);
                            } else {
                                egVar = new eg(e);
                                str = "network";
                            }
                            a(str, liVar, egVar);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (iaVar != null) {
                            throw new kg(e);
                        }
                        i = iaVar.f1227a;
                        lp.m679a("%s Unexpected response code %d for %s", e.getMessage(), Integer.valueOf(i), liVar.m674a());
                        if (iaVar != 0) {
                            fgVar = new fg(i, 0, fg.a(listEmptyList), listEmptyList, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (i != 401 || i == 403) {
                                w3Var = new w3(fgVar);
                            } else if (i == 301 || i == 302) {
                                w3Var = new w3(fgVar);
                            } else {
                                if (i >= 400 && i <= 499) {
                                    throw new gl(fgVar);
                                }
                                if (i < 500 || i > 599) {
                                    throw new gl(fgVar);
                                }
                                if (!liVar.f450b) {
                                    throw new gl(fgVar);
                                }
                                egVar = new gl(fgVar);
                                str = "server";
                            }
                            a(com.alipay.sdk.app.statistic.c.d, liVar, w3Var);
                        } else {
                            egVar = new eg(e);
                            str = "network";
                        }
                        a(str, liVar, egVar);
                    }
                } catch (MalformedURLException e3) {
                    e = e3;
                    throw new RuntimeException("Bad URL " + liVar.m674a(), e);
                } catch (SocketTimeoutException unused) {
                    a("socket", liVar, new on());
                }
            } catch (MalformedURLException e4) {
                e = e4;
            } catch (SocketTimeoutException unused2) {
            } catch (IOException e5) {
                e = e5;
            }
        }
    }
}
