package com.byazt.hx;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.eg.d;
import com.byazt.eg.gu;
import com.byazt.eg.h;
import com.byazt.eg.yv;
import com.byazt.iq.sp;
import com.byazt.mk.gt;
import com.byazt.mk.my;
import com.byazt.mk.rh;
import com.byazt.mk.t;
import com.byazt.yx.i;
import com.byazt.yx.sl;
import com.byazt.yx.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 731, 20})
public final class c implements com.byazt.yx.ve {
    public final gu c;
    public final sp tt;
    public final com.byazt.mk.uj uj;
    public final com.byazt.mk.n ve;
    public int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2318a = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: renamed from: com.byazt.hx.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 731, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    public c(gu guVar, sp spVar, com.byazt.mk.n nVar, com.byazt.mk.uj ujVar) {
        this.c = guVar;
        this.tt = spVar;
        this.ve = nVar;
        this.uj = ujVar;
    }

    @Override // com.byazt.yx.ve
    public rh c(yv yvVar, long j) {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(yvVar.c("Transfer-Encoding"))) {
            return n();
        }
        if (j != -1) {
            return c(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.byazt.yx.ve
    public void ve() {
        com.byazt.iq.ve veVarTt = this.tt.tt();
        if (veVarTt != null) {
            veVarTt.tt();
        }
    }

    @Override // com.byazt.yx.ve
    public void c(yv yvVar) throws IOException {
        c(yvVar.ve(), i.c(yvVar, this.tt.tt().c().tt().type()));
    }

    @Override // com.byazt.yx.ve
    public d c(h hVar) throws IOException {
        String strC = hVar.c("Content-Type");
        if (!com.byazt.yx.n.ve(hVar)) {
            return new x(strC, 0L, t.c(tt(0L)));
        }
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(hVar.c("Transfer-Encoding"))) {
            return new x(strC, -1L, t.c(c(hVar.c().c())));
        }
        long jC = com.byazt.yx.n.c(hVar);
        if (jC != -1) {
            return new x(strC, jC, t.c(tt(jC)));
        }
        return new x(strC, -1L, t.c(a()));
    }

    @Override // com.byazt.yx.ve
    public void c() throws IOException {
        this.uj.flush();
    }

    @Override // com.byazt.yx.ve
    public void tt() throws IOException {
        this.uj.flush();
    }

    public void c(com.byazt.eg.rh rhVar, String str) throws IOException {
        if (this.n != 0) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.uj.tt(str).tt(IOUtils.LINE_SEPARATOR_WINDOWS);
        int iC = rhVar.c();
        for (int i = 0; i < iC; i++) {
            this.uj.tt(rhVar.c(i)).tt(": ").tt(rhVar.tt(i)).tt(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.uj.tt(IOUtils.LINE_SEPARATOR_WINDOWS);
        this.n = 1;
    }

    @Override // com.byazt.yx.ve
    public h.c c(boolean z) throws IOException {
        int i = this.n;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.n);
        }
        try {
            sl slVarC = sl.c(sp());
            h.c cVarC = new h.c().c(slVarC.c).c(slVarC.tt).c(slVarC.ve).c(uj());
            if (z && slVarC.tt == 100) {
                return null;
            }
            this.n = 4;
            return cVarC;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.tt);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private String sp() throws IOException {
        String strN = this.ve.n(this.f2318a);
        this.f2318a -= (long) strN.length();
        return strN;
    }

    public com.byazt.eg.rh uj() throws IOException {
        com.byazt.eg.rh.c cVar = new com.byazt.eg.rh.c();
        while (true) {
            String strSp = sp();
            if (strSp.length() != 0) {
                com.byazt.kh.c.c.c(cVar, strSp);
            } else {
                return cVar.c();
            }
        }
    }

    public rh n() {
        if (this.n != 1) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 2;
        return new tt();
    }

    public rh c(long j) {
        if (this.n != 1) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 2;
        return new uj(j);
    }

    public my tt(long j) throws IOException {
        if (this.n != 4) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 5;
        return new n(j);
    }

    public my c(com.byazt.eg.my myVar) throws IOException {
        if (this.n != 4) {
            throw new IllegalStateException("state: " + this.n);
        }
        this.n = 5;
        return new ve(myVar);
    }

    public my a() throws IOException {
        if (this.n != 4) {
            throw new IllegalStateException("state: " + this.n);
        }
        sp spVar = this.tt;
        if (spVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.n = 5;
        spVar.uj();
        return new a();
    }

    public void c(com.byazt.mk.i iVar) {
        gt gtVarC = iVar.c();
        iVar.c(gt.ve);
        gtVarC.a();
        gtVarC.n();
    }

    @com.byazt.zqa.c(c = {0, 1, 731, 187})
    private final class uj implements rh {
        public final com.byazt.mk.i tt;
        public long uj;
        public boolean ve;

        @Override // com.byazt.mk.rh
        public gt c() {
            return this.tt;
        }

        public uj(long j) {
            this.tt = new com.byazt.mk.i(c.this.uj.c());
            this.uj = j;
        }

        @Override // com.byazt.mk.rh
        public void a_(com.byazt.mk.ve veVar, long j) throws IOException {
            if (this.ve) {
                throw new IllegalStateException("closed");
            }
            com.byazt.kh.ve.c(veVar.tt(), 0L, j);
            if (j > this.uj) {
                throw new ProtocolException("expected " + this.uj + " bytes but received " + j);
            }
            c.this.uj.a_(veVar, j);
            this.uj -= j;
        }

        @Override // com.byazt.mk.rh, java.io.Flushable
        public void flush() throws IOException {
            if (this.ve) {
                return;
            }
            c.this.uj.flush();
        }

        @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.ve) {
                return;
            }
            this.ve = true;
            if (this.uj > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            c.this.c(this.tt);
            c.this.n = 3;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 731, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private final class tt implements rh {
        public final com.byazt.mk.i tt;
        public boolean ve;

        @Override // com.byazt.mk.rh
        public gt c() {
            return this.tt;
        }

        public tt() {
            this.tt = new com.byazt.mk.i(c.this.uj.c());
        }

        @Override // com.byazt.mk.rh
        public void a_(com.byazt.mk.ve veVar, long j) throws IOException {
            if (this.ve) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            c.this.uj.sl(j);
            c.this.uj.tt(IOUtils.LINE_SEPARATOR_WINDOWS);
            c.this.uj.a_(veVar, j);
            c.this.uj.tt(IOUtils.LINE_SEPARATOR_WINDOWS);
        }

        @Override // com.byazt.mk.rh, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.ve) {
                return;
            }
            c.this.uj.flush();
        }

        @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.ve) {
                return;
            }
            this.ve = true;
            c.this.uj.tt("0\r\n\r\n");
            c.this.c(this.tt);
            c.this.n = 3;
        }
    }

    /* JADX INFO: renamed from: com.byazt.hx.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 731, 44})
    private abstract class AbstractC0177c implements my {
        public final com.byazt.mk.i c;
        public boolean tt;
        public long ve;

        @Override // com.byazt.mk.my
        public gt c() {
            return this.c;
        }

        private AbstractC0177c() {
            this.c = new com.byazt.mk.i(c.this.ve.c());
            this.ve = 0L;
        }

        public /* synthetic */ AbstractC0177c(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.byazt.mk.my
        public long c(com.byazt.mk.ve veVar, long j) throws IOException {
            try {
                long jC = c.this.ve.c(veVar, j);
                if (jC > 0) {
                    this.ve += jC;
                }
                return jC;
            } catch (IOException e) {
                c(false, e);
                throw e;
            }
        }

        public final void c(boolean z, IOException iOException) throws IOException {
            if (c.this.n == 6) {
                return;
            }
            if (c.this.n != 5) {
                throw new IllegalStateException("state: " + c.this.n);
            }
            c.this.c(this.c);
            c.this.n = 6;
            if (c.this.tt != null) {
                c.this.tt.c(!z, c.this, this.ve, iOException);
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 731, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT})
    private class n extends AbstractC0177c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2320a;

        public n(long j) throws IOException {
            super(c.this, null);
            this.f2320a = j;
            if (j == 0) {
                c(true, (IOException) null);
            }
        }

        @Override // com.byazt.hx.c.AbstractC0177c, com.byazt.mk.my
        public long c(com.byazt.mk.ve veVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.tt) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.f2320a;
            if (j2 == 0) {
                return -1L;
            }
            long jC = super.c(veVar, Math.min(j2, j));
            if (jC == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                c(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.f2320a - jC;
            this.f2320a = j3;
            if (j3 == 0) {
                c(true, (IOException) null);
            }
            return jC;
        }

        @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.tt) {
                return;
            }
            if (this.f2320a != 0 && !com.byazt.kh.ve.c(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, (IOException) null);
            }
            this.tt = true;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 731, 132})
    private class ve extends AbstractC0177c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.byazt.eg.my f2321a;
        public long sp;
        public boolean x;

        public ve(com.byazt.eg.my myVar) {
            super(c.this, null);
            this.sp = -1L;
            this.x = true;
            this.f2321a = myVar;
        }

        @Override // com.byazt.hx.c.AbstractC0177c, com.byazt.mk.my
        public long c(com.byazt.mk.ve veVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.tt) {
                throw new IllegalStateException("closed");
            }
            if (!this.x) {
                return -1L;
            }
            long j2 = this.sp;
            if (j2 == 0 || j2 == -1) {
                tt();
                if (!this.x) {
                    return -1L;
                }
            }
            long jC = super.c(veVar, Math.min(j, this.sp));
            if (jC != -1) {
                this.sp -= jC;
                return jC;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            c(false, (IOException) protocolException);
            throw protocolException;
        }

        private void tt() throws IOException {
            if (this.sp != -1) {
                c.this.ve.m();
            }
            try {
                this.sp = c.this.ve.u();
                String strTrim = c.this.ve.m().trim();
                if (this.sp < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.sp + strTrim + "\"");
                }
                if (this.sp == 0) {
                    this.x = false;
                    com.byazt.yx.n.c(c.this.c.a(), this.f2321a, c.this.uj());
                    c(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.tt) {
                return;
            }
            if (this.x && !com.byazt.kh.ve.c(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, (IOException) null);
            }
            this.tt = true;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 731, 744})
    private class a extends AbstractC0177c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2319a;

        public a() {
            super(c.this, null);
        }

        @Override // com.byazt.hx.c.AbstractC0177c, com.byazt.mk.my
        public long c(com.byazt.mk.ve veVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.tt) {
                throw new IllegalStateException("closed");
            }
            if (this.f2319a) {
                return -1L;
            }
            long jC = super.c(veVar, j);
            if (jC != -1) {
                return jC;
            }
            this.f2319a = true;
            c(true, (IOException) null);
            return -1L;
        }

        @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.tt) {
                return;
            }
            if (!this.f2319a) {
                c(false, (IOException) null);
            }
            this.tt = true;
        }
    }
}
