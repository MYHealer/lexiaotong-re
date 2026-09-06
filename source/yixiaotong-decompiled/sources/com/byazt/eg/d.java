package com.byazt.eg;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 512})
public abstract class d implements Closeable {
    public abstract rl c();

    public abstract long tt();

    public abstract com.byazt.mk.n ve();

    public final InputStream uj() {
        return ve().a();
    }

    public final byte[] n() throws IOException {
        long jTt = tt();
        if (jTt > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jTt)));
        }
        com.byazt.mk.n nVarVe = ve();
        try {
            byte[] bArrNu = nVarVe.nu();
            com.byazt.kh.ve.c(nVarVe);
            if (jTt == -1 || jTt == bArrNu.length) {
                return bArrNu;
            }
            throw new IOException("Content-Length (" + jTt + ") and stream length (" + bArrNu.length + ") disagree");
        } catch (Throwable th) {
            com.byazt.kh.ve.c(nVarVe);
            throw th;
        }
    }

    public final String a() throws IOException {
        com.byazt.mk.n nVarVe = ve();
        try {
            return nVarVe.c(com.byazt.kh.ve.c(nVarVe, sp()));
        } catch (OutOfMemoryError unused) {
            return null;
        } finally {
            com.byazt.kh.ve.c(nVarVe);
        }
    }

    private Charset sp() {
        rl rlVarC = c();
        return rlVarC != null ? rlVarC.c(com.byazt.kh.ve.n) : com.byazt.kh.ve.n;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.byazt.kh.ve.c(ve());
    }

    public static d c(rl rlVar, byte[] bArr) {
        return c(rlVar, bArr.length, new com.byazt.mk.ve().ve(bArr));
    }

    public static d c(final rl rlVar, final long j, final com.byazt.mk.n nVar) {
        if (nVar == null) {
            throw new NullPointerException("source == null");
        }
        return new d() { // from class: com.byazt.eg.d.1
            @Override // com.byazt.eg.d
            public rl c() {
                return rlVar;
            }

            @Override // com.byazt.eg.d
            public long tt() {
                return j;
            }

            @Override // com.byazt.eg.d
            public com.byazt.mk.n ve() {
                return nVar;
            }
        };
    }
}
