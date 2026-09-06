package com.opos.cmn.func.a.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6060a;
    public final long b;

    /* JADX INFO: renamed from: com.opos.cmn.func.a.a.a.a$a, reason: collision with other inner class name */
    public static class C0884a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6061a = true;
        private long b = 0;

        public a a() {
            if (this.b <= 0) {
                this.b = com.opos.cmn.func.a.b.a.a.a() ? 173525665583603712L : 183259052372135936L;
            }
            return new a(this, null);
        }
    }

    static /* synthetic */ class b {
    }

    private a(C0884a c0884a) {
        this.f6060a = c0884a.f6061a;
        this.b = c0884a.b;
    }

    /* synthetic */ a(C0884a c0884a, b bVar) {
        this(c0884a);
    }

    public String toString() {
        return "AppTraceConfig{enableTrace=" + this.f6060a + ", traceConfigId=" + this.b + '}';
    }
}
