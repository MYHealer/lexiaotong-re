package com.byazt.eg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 158})
public final class sl {
    public static final sl c;
    public static final sl tt;
    public static final sl ve;
    public static final x[] x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f2141a;
    public final boolean n;
    public final String[] sp;
    public final boolean uj;

    public boolean c() {
        return this.uj;
    }

    public boolean uj() {
        return this.n;
    }

    static {
        x[] xVarArr = {x.sl, x.u, x.t, x.yp, x.m, x.z, x.sp, x.i, x.x, x.da, x.n, x.f2146a, x.ve, x.uj, x.tt};
        x = xVarArr;
        sl slVarC = new c(true).c(xVarArr).c(zb.TLS_1_3, zb.TLS_1_2, zb.TLS_1_1, zb.TLS_1_0).c(true).c();
        c = slVarC;
        tt = new c(slVarC).c(zb.TLS_1_0).c(true).c();
        ve = new c(false).c();
    }

    public sl(c cVar) {
        this.uj = cVar.c;
        this.f2141a = cVar.tt;
        this.sp = cVar.ve;
        this.n = cVar.uj;
    }

    public List<x> tt() {
        String[] strArr = this.f2141a;
        if (strArr != null) {
            return x.c(strArr);
        }
        return null;
    }

    public List<zb> ve() {
        String[] strArr = this.sp;
        if (strArr != null) {
            return zb.c(strArr);
        }
        return null;
    }

    public void c(SSLSocket sSLSocket, boolean z) {
        sl slVarTt = tt(sSLSocket, z);
        String[] strArr = slVarTt.sp;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = slVarTt.f2141a;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private sl tt(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f2141a != null) {
            enabledCipherSuites = com.byazt.kh.ve.c(x.c, sSLSocket.getEnabledCipherSuites(), this.f2141a);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.sp != null) {
            enabledProtocols = com.byazt.kh.ve.c(com.byazt.kh.ve.x, sSLSocket.getEnabledProtocols(), this.sp);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iC = com.byazt.kh.ve.c(x.c, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iC != -1) {
            enabledCipherSuites = com.byazt.kh.ve.c(enabledCipherSuites, supportedCipherSuites[iC]);
        }
        return new c(this).c(enabledCipherSuites).tt(enabledProtocols).c();
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.uj) {
            return false;
        }
        if (this.sp == null || com.byazt.kh.ve.tt(com.byazt.kh.ve.x, this.sp, sSLSocket.getEnabledProtocols())) {
            return this.f2141a == null || com.byazt.kh.ve.tt(x.c, this.f2141a, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof sl)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        sl slVar = (sl) obj;
        boolean z = this.uj;
        if (z != slVar.uj) {
            return false;
        }
        return !z || (Arrays.equals(this.f2141a, slVar.f2141a) && Arrays.equals(this.sp, slVar.sp) && this.n == slVar.n);
    }

    public int hashCode() {
        if (this.uj) {
            return ((((Arrays.hashCode(this.f2141a) + 527) * 31) + Arrays.hashCode(this.sp)) * 31) + (!this.n ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.uj) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f2141a != null ? tt().toString() : "[all enabled]") + ", tlsVersions=" + (this.sp != null ? ve().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.n + ")";
    }

    @com.byazt.zqa.c(c = {0, 1, 16, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION})
    public static final class c {
        public boolean c;
        public String[] tt;
        public boolean uj;
        public String[] ve;

        public c(boolean z) {
            this.c = z;
        }

        public c(sl slVar) {
            this.c = slVar.uj;
            this.tt = slVar.f2141a;
            this.ve = slVar.sp;
            this.uj = slVar.n;
        }

        public c c(x... xVarArr) {
            if (!this.c) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[xVarArr.length];
            for (int i = 0; i < xVarArr.length; i++) {
                strArr[i] = xVarArr[i].nu;
            }
            return c(strArr);
        }

        public c c(String... strArr) {
            if (!this.c) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.tt = (String[]) strArr.clone();
            return this;
        }

        public c c(zb... zbVarArr) {
            if (!this.c) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[zbVarArr.length];
            for (int i = 0; i < zbVarArr.length; i++) {
                strArr[i] = zbVarArr[i].f2150a;
            }
            return tt(strArr);
        }

        public c tt(String... strArr) {
            if (!this.c) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.ve = (String[]) strArr.clone();
            return this;
        }

        public c c(boolean z) {
            if (!this.c) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.uj = z;
            return this;
        }

        public sl c() {
            return new sl(this);
        }
    }
}
