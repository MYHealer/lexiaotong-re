package com.byazt.jb;

import com.byazt.mk.gt;
import com.byazt.mk.my;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 71})
public final class x implements Closeable {
    public static final Logger c = Logger.getLogger(n.class.getName());
    public final boolean n;
    public final uj.c tt;
    public final c uj;
    public final com.byazt.mk.n ve;

    interface tt {
        void c(int i, int i2, List<ve> list) throws IOException;

        void c(int i, long j);

        void c(int i, com.byazt.jb.tt ttVar);

        void c(int i, com.byazt.jb.tt ttVar, com.byazt.mk.a aVar);

        void c(boolean z, int i, int i2);

        void c(boolean z, int i, int i2, List<ve> list);

        void c(boolean z, int i, com.byazt.mk.n nVar, int i2) throws IOException;

        void c(boolean z, yp ypVar);
    }

    public x(com.byazt.mk.n nVar, boolean z) {
        this.ve = nVar;
        this.n = z;
        c cVar = new c(nVar);
        this.uj = cVar;
        this.tt = new uj.c(4096, cVar);
    }

    public void c(tt ttVar) throws IOException {
        if (this.n) {
            if (!c(true, ttVar)) {
                throw n.tt("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.byazt.mk.a aVarVe = this.ve.ve(n.c.sp());
        Logger logger = c;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.byazt.kh.ve.c("<< CONNECTION %s", aVarVe.n()));
        }
        if (!n.c.equals(aVarVe)) {
            throw n.tt("Expected a connection header but was %s", aVarVe.c());
        }
    }

    public boolean c(boolean z, tt ttVar) throws IOException {
        try {
            this.ve.c(9L);
            int iC = c(this.ve);
            if (iC < 0 || iC > 16384) {
                throw n.tt("FRAME_SIZE_ERROR: %s", Integer.valueOf(iC));
            }
            byte bX = (byte) (this.ve.x() & 255);
            if (z && bX != 4) {
                throw n.tt("Expected a SETTINGS frame but was %s", Byte.valueOf(bX));
            }
            byte bX2 = (byte) (this.ve.x() & 255);
            int iDa = this.ve.da() & Integer.MAX_VALUE;
            Logger logger = c;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(n.c(true, iDa, iC, bX, bX2));
            }
            switch (bX) {
                case 0:
                    tt(ttVar, iC, bX2, iDa);
                    return true;
                case 1:
                    c(ttVar, iC, bX2, iDa);
                    return true;
                case 2:
                    ve(ttVar, iC, bX2, iDa);
                    return true;
                case 3:
                    uj(ttVar, iC, bX2, iDa);
                    return true;
                case 4:
                    n(ttVar, iC, bX2, iDa);
                    return true;
                case 5:
                    a(ttVar, iC, bX2, iDa);
                    return true;
                case 6:
                    sp(ttVar, iC, bX2, iDa);
                    return true;
                case 7:
                    x(ttVar, iC, bX2, iDa);
                    return true;
                case 8:
                    i(ttVar, iC, bX2, iDa);
                    return true;
                default:
                    this.ve.x(iC);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void c(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw n.tt("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short sX = (b & 8) != 0 ? (short) (this.ve.x() & 255) : (short) 0;
        if ((b & 32) != 0) {
            c(ttVar, i2);
            i -= 5;
        }
        ttVar.c(z, i2, -1, c(c(i, b, sX), sX, b, i2));
    }

    private List<ve> c(int i, short s, byte b, int i2) throws IOException {
        c cVar = this.uj;
        cVar.uj = i;
        cVar.c = i;
        this.uj.n = s;
        this.uj.tt = b;
        this.uj.ve = i2;
        this.tt.c();
        return this.tt.tt();
    }

    private void tt(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw n.tt("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw n.tt("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sX = (b & 8) != 0 ? (short) (this.ve.x() & 255) : (short) 0;
        ttVar.c(z, i2, this.ve, c(i, b, sX));
        this.ve.x(sX);
    }

    private void ve(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw n.tt("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw n.tt("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        c(ttVar, i2);
    }

    private void c(tt ttVar, int i) throws IOException {
        this.ve.da();
        this.ve.x();
    }

    private void uj(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw n.tt("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw n.tt("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iDa = this.ve.da();
        com.byazt.jb.tt ttVarC = com.byazt.jb.tt.c(iDa);
        if (ttVarC == null) {
            throw n.tt("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iDa));
        }
        ttVar.c(i2, ttVarC);
    }

    private void n(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw n.tt("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw n.tt("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw n.tt("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        yp ypVar = new yp();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sI = this.ve.i();
            int iDa = this.ve.da();
            if (sI == 2) {
                if (iDa != 0 && iDa != 1) {
                    throw n.tt("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (sI == 3) {
                sI = 4;
            } else if (sI != 4) {
                if (sI == 5 && (iDa < 16384 || iDa > 16777215)) {
                    throw n.tt("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iDa));
                }
            } else {
                if (iDa < 0) {
                    throw n.tt("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                sI = 7;
            }
            ypVar.c(sI, iDa);
        }
        ttVar.c(false, ypVar);
    }

    private void a(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw n.tt("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sX = (b & 8) != 0 ? (short) (this.ve.x() & 255) : (short) 0;
        ttVar.c(i2, this.ve.da() & Integer.MAX_VALUE, c(c(i - 4, b, sX), sX, b, i2));
    }

    private void sp(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw n.tt("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw n.tt("TYPE_PING streamId != 0", new Object[0]);
        }
        ttVar.c((b & 1) != 0, this.ve.da(), this.ve.da());
    }

    private void x(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw n.tt("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw n.tt("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iDa = this.ve.da();
        int iDa2 = this.ve.da();
        int i3 = i - 8;
        com.byazt.jb.tt ttVarC = com.byazt.jb.tt.c(iDa2);
        if (ttVarC == null) {
            throw n.tt("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iDa2));
        }
        com.byazt.mk.a aVarVe = com.byazt.mk.a.tt;
        if (i3 > 0) {
            aVarVe = this.ve.ve(i3);
        }
        ttVar.c(iDa, ttVarC, aVarVe);
    }

    private void i(tt ttVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw n.tt("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jDa = ((long) this.ve.da()) & 2147483647L;
        if (jDa == 0) {
            throw n.tt("windowSizeIncrement was 0", Long.valueOf(jDa));
        }
        ttVar.c(i2, jDa);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ve.close();
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 62})
    static final class c implements my {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.byazt.mk.n f2380a;
        public int c;
        public short n;
        public byte tt;
        public int uj;
        public int ve;

        @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public c(com.byazt.mk.n nVar) {
            this.f2380a = nVar;
        }

        @Override // com.byazt.mk.my
        public long c(com.byazt.mk.ve veVar, long j) throws IOException {
            while (true) {
                int i = this.uj;
                if (i == 0) {
                    this.f2380a.x(this.n);
                    this.n = (short) 0;
                    if ((this.tt & 4) != 0) {
                        return -1L;
                    }
                    tt();
                } else {
                    long jC = this.f2380a.c(veVar, Math.min(j, i));
                    if (jC == -1) {
                        return -1L;
                    }
                    this.uj = (int) (((long) this.uj) - jC);
                    return jC;
                }
            }
        }

        @Override // com.byazt.mk.my
        public gt c() {
            return this.f2380a.c();
        }

        private void tt() throws IOException {
            int i = this.ve;
            int iC = x.c(this.f2380a);
            this.uj = iC;
            this.c = iC;
            byte bX = (byte) (this.f2380a.x() & 255);
            this.tt = (byte) (this.f2380a.x() & 255);
            if (x.c.isLoggable(Level.FINE)) {
                x.c.fine(n.c(true, this.ve, this.c, bX, this.tt));
            }
            int iDa = this.f2380a.da() & Integer.MAX_VALUE;
            this.ve = iDa;
            if (bX != 9) {
                throw n.tt("%s != TYPE_CONTINUATION", Byte.valueOf(bX));
            }
            if (iDa != i) {
                throw n.tt("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    public static int c(com.byazt.mk.n nVar) throws IOException {
        return (nVar.x() & 255) | ((nVar.x() & 255) << 16) | ((nVar.x() & 255) << 8);
    }

    public static int c(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw n.tt("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
