package com.byazt.eg;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 47})
public final class eo {
    public final c c;
    public final Proxy tt;
    public final InetSocketAddress ve;

    public c c() {
        return this.c;
    }

    public Proxy tt() {
        return this.tt;
    }

    public InetSocketAddress ve() {
        return this.ve;
    }

    public eo(c cVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (cVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.c = cVar;
        this.tt = proxy;
        this.ve = inetSocketAddress;
    }

    public boolean uj() {
        return this.c.i != null && this.tt.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof eo)) {
            return false;
        }
        eo eoVar = (eo) obj;
        return eoVar.c.equals(this.c) && eoVar.tt.equals(this.tt) && eoVar.ve.equals(this.ve);
    }

    public int hashCode() {
        return ((((this.c.hashCode() + 527) * 31) + this.tt.hashCode()) * 31) + this.ve.hashCode();
    }

    public String toString() {
        return "Route{" + this.ve + com.alipay.sdk.util.i.d;
    }
}
