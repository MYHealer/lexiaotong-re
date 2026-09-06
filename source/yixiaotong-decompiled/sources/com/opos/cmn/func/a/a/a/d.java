package com.opos.cmn.func.a.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.cmn.func.a.a.a.b f6067a;
    public final c b;
    public final com.opos.cmn.func.a.a.a.a c;
    public final f d;
    public final e e;
    public final boolean f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.cmn.func.a.a.a.b f6068a;
        private c b;
        private f c;
        private com.opos.cmn.func.a.a.a.a d;
        private e e;
        private boolean f = true;

        public d a() {
            if (this.f6068a == null) {
                this.f6068a = new com.opos.cmn.func.a.a.a.b.C0885b().a();
            }
            if (this.b == null) {
                this.b = new c.a().a();
            }
            if (this.c == null) {
                this.c = new f.a().a();
            }
            if (this.d == null) {
                this.d = new com.opos.cmn.func.a.a.a.a.C0884a().a();
            }
            return new d(this, null);
        }
    }

    static /* synthetic */ class b {
    }

    private d(a aVar) {
        this.f6067a = aVar.f6068a;
        this.b = aVar.b;
        this.d = aVar.c;
        this.c = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    /* synthetic */ d(a aVar, b bVar) {
        this(aVar);
    }

    public String toString() {
        return "HttpExtConfig{cloudConfig=" + this.f6067a + ", httpDnsConfig=" + this.b + ", appTraceConfig=" + this.c + ", iPv6Config=" + this.d + ", httpStatConfig=" + this.e + ", closeNetLog=" + this.f + '}';
    }
}
