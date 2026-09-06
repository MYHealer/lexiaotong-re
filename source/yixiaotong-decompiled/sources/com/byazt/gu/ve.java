package com.byazt.gu;

import com.byazt.eg.gr;
import com.byazt.eg.m;
import com.byazt.gqp.u;
import com.byazt.gqp.yp;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 17, 54})
public class ve extends m {
    public com.byazt.gu.c tt;

    public ve(com.byazt.gu.c cVar) {
        this.tt = cVar;
    }

    @Override // com.byazt.eg.m
    public void c(com.byazt.eg.n nVar, InetSocketAddress inetSocketAddress, Proxy proxy, gr grVar, IOException iOException) {
        super.c(nVar, inetSocketAddress, proxy, grVar, iOException);
        com.byazt.gu.c cVar = this.tt;
        if (cVar != null) {
            cVar.c(new c(nVar), inetSocketAddress, proxy, c(grVar), iOException);
        }
    }

    @Override // com.byazt.eg.m
    public void c(com.byazt.eg.n nVar, IOException iOException) {
        super.c(nVar, iOException);
        com.byazt.gu.c cVar = this.tt;
        if (cVar != null) {
            cVar.c(new c(nVar), iOException);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 17, 24})
    private static class c implements com.byazt.gqp.tt {
        public com.byazt.eg.n c;

        @Override // com.byazt.gqp.tt
        public void c(com.byazt.gqp.ve veVar) {
        }

        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public com.byazt.gqp.tt clone() {
            return null;
        }

        @Override // com.byazt.gqp.tt
        public com.byazt.gqp.m tt() throws IOException {
            return null;
        }

        public c(com.byazt.eg.n nVar) {
            this.c = nVar;
        }

        @Override // com.byazt.gqp.tt
        public yp c() {
            return new x(this.c.c());
        }

        @Override // com.byazt.gqp.tt
        public void ve() {
            this.c.ve();
        }

        @Override // com.byazt.gqp.tt
        public boolean uj() {
            return this.c.uj();
        }
    }

    private u c(gr grVar) {
        if (grVar != null) {
            try {
                return u.c(grVar.toString());
            } catch (IOException unused) {
            }
        }
        return null;
    }
}
