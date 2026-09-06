package com.byazt.ss;

import com.byazt.nr.m;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 951, 13})
public class tt implements com.byazt.yj.uj {
    public long c;
    public c tt;

    public tt(File file, long j, ExecutorService executorService) {
        this.c = j;
        try {
            this.tt = c.c(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            m.tt("LruCountDiskCache", e.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.yj.uj
    public InputStream c(String str) {
        c cVar = this.tt;
        if (cVar == null) {
            return null;
        }
        try {
            c.ve veVarC = cVar.c(str);
            if (veVarC != null) {
                return veVarC.c(0);
            }
        } catch (IOException e) {
            m.tt("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.byazt.yj.c
    public boolean c(String str, byte[] bArr) throws Throwable {
        c cVar = this.tt;
        if (cVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable = null;
        c.C0272c c0272c = null;
        try {
            try {
                c.C0272c c0272cTt = cVar.tt(str);
                try {
                    if (c0272cTt == null) {
                        m.tt("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.byazt.as.tt.c(null);
                        return false;
                    }
                    OutputStream outputStreamC = c0272cTt.c(0);
                    if (outputStreamC == c.ve) {
                        m.tt("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.byazt.as.tt.c(outputStreamC);
                        return false;
                    }
                    outputStreamC.write(bArr);
                    c0272cTt.c();
                    this.tt.c();
                    com.byazt.as.tt.c(outputStreamC);
                    return true;
                } catch (IOException e) {
                    e = e;
                    c0272c = c0272cTt;
                    try {
                        m.tt("LruCountDiskCache", e.toString());
                        if (c0272c != null) {
                            try {
                                c0272c.tt();
                            } catch (IOException unused) {
                            }
                        }
                        com.byazt.as.tt.c(0);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable = closeable;
                        com.byazt.as.tt.c(closeable);
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            com.byazt.as.tt.c(closeable);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // com.byazt.yj.c
    /* JADX INFO: renamed from: tt, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] c(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r8;
        c cVar = this.tt;
        ?? r2 = 0;
        if (cVar != null) {
            try {
                if (str != 0) {
                    try {
                        c.ve veVarC = cVar.c((String) str);
                        if (veVarC == null) {
                            com.byazt.as.tt.c(null);
                            com.byazt.as.tt.c(null);
                            return null;
                        }
                        str = veVarC.c(0);
                        if (str != 0) {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i = str.read(bArr);
                                        if (i == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                } catch (IOException e) {
                                    e = e;
                                } catch (OutOfMemoryError e2) {
                                    e = e2;
                                    m.tt("LruCountDiskCache", e.toString());
                                    r8 = str;
                                    com.byazt.as.tt.c(r8);
                                    com.byazt.as.tt.c(byteArrayOutputStream);
                                    return null;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                byteArrayOutputStream = null;
                            } catch (OutOfMemoryError e4) {
                                e = e4;
                                byteArrayOutputStream = null;
                                m.tt("LruCountDiskCache", e.toString());
                                r8 = str;
                                com.byazt.as.tt.c(r8);
                                com.byazt.as.tt.c(byteArrayOutputStream);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                r2 = str;
                                com.byazt.as.tt.c(r2);
                                com.byazt.as.tt.c(0);
                                throw th;
                            }
                        } else {
                            byteArrayOutputStream = null;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.byazt.as.tt.c(str);
                        com.byazt.as.tt.c(byteArrayOutputStream);
                        return byteArray;
                    } catch (IOException e5) {
                        e = e5;
                        str = 0;
                        byteArrayOutputStream = null;
                    } catch (OutOfMemoryError e6) {
                        e = e6;
                        str = 0;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.byazt.as.tt.c(r2);
                        com.byazt.as.tt.c(0);
                        throw th;
                    }
                    m.tt("LruCountDiskCache", e.toString());
                    r8 = str;
                    com.byazt.as.tt.c(r8);
                    com.byazt.as.tt.c(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    @Override // com.byazt.yj.c
    public void c() {
        try {
            this.tt.delete();
        } catch (IOException e) {
            m.w("LruCountDiskCache", e);
        }
    }

    @Override // com.byazt.yj.c
    /* JADX INFO: renamed from: ve, reason: merged with bridge method [inline-methods] */
    public boolean tt(String str) {
        try {
            try {
                c.ve veVarC = this.tt.c(str);
                boolean z = veVarC != null;
                com.byazt.as.tt.c(veVarC);
                return z;
            } catch (IOException e) {
                m.tt("LruCountDiskCache", e.getMessage());
                com.byazt.as.tt.c(null);
                return false;
            }
        } catch (Throwable th) {
            com.byazt.as.tt.c(null);
            throw th;
        }
    }

    @Override // com.byazt.yj.c
    public void c(double d) {
        this.tt.c((long) (this.c * d));
    }
}
