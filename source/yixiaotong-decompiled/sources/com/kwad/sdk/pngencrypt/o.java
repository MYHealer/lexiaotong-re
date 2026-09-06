package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class o implements Closeable {
    protected ErrorBehaviour bjK = ErrorBehaviour.STRICT;
    public final k bkK;
    public final boolean blg;
    protected final c blh;
    protected final a bli;
    protected final w blj;
    protected int blk;
    private i<? extends Object> bll;

    private void a(i<? extends Object> iVar) {
        this.bll = iVar;
    }

    public o(InputStream inputStream, boolean z) {
        this.blk = -1;
        a aVar = new a(inputStream);
        this.bli = aVar;
        boolean z2 = true;
        aVar.ch(true);
        c cVarTm = Tm();
        this.blh = cVarTm;
        try {
            if (aVar.b(cVarTm, 36) != 36) {
                new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)");
            }
            this.bkK = cVarTm.SN();
            if (cVarTm.SO() == null) {
                z2 = false;
            }
            this.blg = z2;
            aY(5024024L);
            aW(901001001L);
            aX(2024024L);
            this.blj = new w(cVarTm.bjQ);
            a(m.Tf());
            this.blk = -1;
        } catch (RuntimeException e) {
            this.bli.close();
            this.blh.close();
            throw e;
        }
    }

    private void Ti() {
        while (this.blh.bjP < 4) {
            if (this.bli.a(this.blh) <= 0) {
                new PngjException("Premature ending reading first chunks");
            }
        }
    }

    public final w Tj() {
        if (this.blh.SL()) {
            Ti();
        }
        return this.blj;
    }

    public final void Tk() {
        Tl();
        if (this.blh.SL()) {
            Ti();
        }
        end();
    }

    private void aW(long j) {
        this.blh.aW(901001001L);
    }

    private void aY(long j) {
        this.blh.aY(5024024L);
    }

    private void aX(long j) {
        this.blh.aX(2024024L);
    }

    public final void end() {
        try {
            if (this.blh.SL()) {
                Ti();
            }
            if (this.blh.SM() != null && !this.blh.SM().isDone()) {
                this.blh.SM().Gr();
            }
            while (!this.blh.isDone() && this.bli.a(this.blh) > 0) {
            }
        } finally {
            close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.blh);
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.bli);
    }

    private void Tl() {
        this.blh.cj(false);
    }

    private static c Tm() {
        return new c(false);
    }

    public final String toString() {
        return this.bkK.toString() + " interlaced=" + this.blg;
    }
}
