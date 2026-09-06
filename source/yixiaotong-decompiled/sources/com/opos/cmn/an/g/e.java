package com.opos.cmn.an.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5923a;
    public final c b;
    public final com.opos.cmn.an.g.a c;
    public final d d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f5924a;
        private c b;
        private com.opos.cmn.an.g.a c;
        private d d;

        private void b() {
            if (this.f5924a == null) {
                this.f5924a = new com.opos.cmn.an.g.a.b.a();
            }
            if (this.b == null) {
                this.b = new com.opos.cmn.an.g.a.d.a();
            }
            if (this.c == null) {
                this.c = new com.opos.cmn.an.g.a.c.a();
            }
            if (this.d == null) {
                this.d = new com.opos.cmn.an.g.a.e.a();
            }
        }

        public a a(com.opos.cmn.an.g.a aVar) {
            this.c = aVar;
            return this;
        }

        public a a(b bVar) {
            this.f5924a = bVar;
            return this;
        }

        public a a(c cVar) {
            this.b = cVar;
            return this;
        }

        public a a(d dVar) {
            this.d = dVar;
            return this;
        }

        public e a() {
            b();
            return new e(this);
        }
    }

    public e(a aVar) {
        this.f5923a = aVar.f5924a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
    }

    public String toString() {
        return "NetInitParams{iHttpExecutor=" + this.f5923a + ", iHttpsExecutor=" + this.b + ", iHttp2Executor=" + this.c + ", iSpdyExecutor=" + this.d + '}';
    }
}
