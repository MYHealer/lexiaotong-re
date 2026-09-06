package com.adprof.sdk;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c6 implements cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6 f1102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final t5 f170a;

    static {
        int i = lp.f1294a;
    }

    public c6(t5 t5Var) {
        this(t5Var, new p6(4096));
    }

    public c6(t5 t5Var, p6 p6Var) {
        this.f170a = t5Var;
        this.f1102a = p6Var;
    }

    public static void a(String str, li liVar, jp jpVar) throws jp {
        q7 q7Var = liVar.f445a;
        int i = q7Var.c;
        try {
            q7Var.a(jpVar);
            String.format("%s-retry [timeout=%s]", str, Integer.valueOf(i));
            int i2 = kp.f1273a;
        } catch (jp e) {
            String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(i));
            int i3 = kp.f1273a;
            throw e;
        }
    }

    public final byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] byteArray;
        ph phVar = new ph(this.f1102a, i);
        int i2 = 1024;
        if (i > 0 && i < 1024) {
            i2 = i;
        }
        byte[] bArrA = null;
        try {
            bArrA = this.f1102a.a(i2);
            long j = 0;
            while (true) {
                int i3 = inputStream.read(bArrA, 0, i2);
                if (i3 == -1 || (i >= 1 && j >= i)) {
                    break;
                }
                phVar.write(bArrA, 0, i3);
                j += (long) i3;
            }
            byteArray = phVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                int i4 = lp.f1294a;
            }
            this.f1102a.a(bArrA);
        } catch (Throwable th) {
            try {
                lp.m679a("readError", th.getMessage());
                byteArray = phVar.toByteArray();
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    int i5 = lp.f1294a;
                }
                this.f1102a.a(bArrA);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                    int i6 = lp.f1294a;
                }
                this.f1102a.a(bArrA);
                phVar.close();
            }
        }
        return byteArray;
    }

    public static Map a(List list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < list.size(); i++) {
            w9 w9Var = (w9) list.get(i);
            treeMap.put(w9Var.f1495a, w9Var.b);
        }
        return treeMap;
    }

    /* JADX WARN: Code duplicated, block: B:142:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x000a A[SYNTHETIC] */
    @Override // com.adprof.sdk.cg
    public fg a(li liVar) throws Throwable {
        Throwable th;
        InputStream inputStream;
        String str;
        jp egVar;
        InputStream inputStream2;
        gl glVar;
        InputStream inputStream3;
        byte[] bArrA;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List listEmptyList = Collections.emptyList();
            ia iaVar = null;
            try {
                ia iaVarA = this.f170a.a(liVar, Collections.emptyMap());
                try {
                    int i = iaVarA.f1227a;
                    List listUnmodifiableList = Collections.unmodifiableList(iaVarA.f378a);
                    if (i == 304) {
                        fg fgVar = new fg(304, null, fg.a(listUnmodifiableList), listUnmodifiableList, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                        InputStream inputStream4 = iaVarA.f377a;
                        if (inputStream4 != null) {
                            try {
                                inputStream4.close();
                            } catch (IOException e) {
                                lp.m679a(e.getMessage(), new Object[0]);
                            }
                        }
                        return fgVar;
                    }
                    if (i == 301 || i == 302) {
                        String string = (String) ((TreeMap) a(listUnmodifiableList)).get("Location");
                        URI uriCreate = URI.create(string);
                        if (uriCreate != null && !uriCreate.isAbsolute()) {
                            try {
                                URI uriCreate2 = URI.create(liVar.m674a());
                                if (uriCreate2 != null) {
                                    string = uriCreate2.resolve(uriCreate).toString();
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        liVar.f449b = string;
                        int i2 = kp.f1273a;
                    }
                    InputStream inputStream5 = iaVarA.f377a;
                    if (inputStream5 != null) {
                        int iA = iaVarA.b;
                        if (liVar.a() >= 0) {
                            iA = liVar.a();
                        }
                        bArrA = a(inputStream5, iA);
                    } else {
                        bArrA = new byte[0];
                    }
                    byte[] bArr = bArrA;
                    if (SystemClock.elapsedRealtime() - jElapsedRealtime > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                        int i3 = liVar.f445a.d;
                        int i4 = lp.f1294a;
                    }
                    if (i < 200 || i > 299) {
                        throw new IOException();
                    }
                    fg fgVar2 = new fg(i, bArr, fg.a(listUnmodifiableList), listUnmodifiableList, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                    InputStream inputStream6 = iaVarA.f377a;
                    if (inputStream6 != null) {
                        try {
                            inputStream6.close();
                        } catch (IOException e2) {
                            lp.m679a(e2.getMessage(), new Object[0]);
                        }
                    }
                    return fgVar2;
                } catch (MalformedURLException e3) {
                    e = e3;
                    throw new RuntimeException("Bad URL " + liVar.m674a(), e);
                } catch (SocketTimeoutException unused2) {
                    iaVar = iaVarA;
                    a("socket", liVar, new on());
                    if (iaVar != null && (inputStream3 = iaVar.f377a) != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException e4) {
                            lp.m679a(e4.getMessage(), new Object[0]);
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                    iaVar = iaVarA;
                    if (iaVar == null) {
                        throw new kg(e);
                    }
                    try {
                        int i5 = iaVar.f1227a;
                        lp.m679a("Unexpected response code %d for %s", Integer.valueOf(i5), liVar.m674a());
                        if (iaVar != 0) {
                            fg fgVar3 = new fg(i5, 0, fg.a(listEmptyList), listEmptyList, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (i5 == 301 || i5 == 302) {
                                String.format("%s-Redirect [timeout=%s]", "redirect", Integer.valueOf(liVar.f445a.c));
                                int i6 = kp.f1273a;
                            } else if (i5 == 401 || i5 == 403) {
                                str = com.alipay.sdk.app.statistic.c.d;
                                egVar = new w3(fgVar3);
                            } else {
                                if (i5 < 400 || i5 > 499) {
                                    if (i5 < 500 || i5 > 599) {
                                        if (i5 <= 599) {
                                            throw new gl(fgVar3);
                                        }
                                        if (!liVar.f450b) {
                                            throw new gl(fgVar3);
                                        }
                                        glVar = new gl(fgVar3);
                                    } else {
                                        if (!liVar.f450b) {
                                            throw new gl(fgVar3);
                                        }
                                        glVar = new gl(fgVar3);
                                    }
                                } else {
                                    if (!liVar.f450b) {
                                        throw new gl(fgVar3);
                                    }
                                    glVar = new gl(fgVar3);
                                }
                                a("server", liVar, glVar);
                            }
                            inputStream2 = iaVar.f377a;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e6) {
                                    lp.m679a(e6.getMessage(), new Object[0]);
                                }
                            }
                        } else {
                            str = "network";
                            egVar = new eg(e);
                        }
                        a(str, liVar, egVar);
                        inputStream2 = iaVar.f377a;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (iaVar != null || (inputStream = iaVar.f377a) == null) {
                            throw th;
                        }
                        try {
                            inputStream.close();
                            throw th;
                        } catch (IOException e7) {
                            lp.m679a(e7.getMessage(), new Object[0]);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    iaVar = iaVarA;
                    if (iaVar != null) {
                        throw th;
                    }
                    throw th;
                }
            } catch (MalformedURLException e8) {
                e = e8;
            } catch (SocketTimeoutException unused3) {
            } catch (IOException e9) {
                e = e9;
            }
        }
    }
}
