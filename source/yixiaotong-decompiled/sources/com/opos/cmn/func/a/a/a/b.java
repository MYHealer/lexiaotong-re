package com.opos.cmn.func.a.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6062a;
    public final long b;
    public final a c;

    public enum a {
        CN,
        EU,
        SA,
        SEA
    }

    /* JADX INFO: renamed from: com.opos.cmn.func.a.a.a.b$b, reason: collision with other inner class name */
    public static class C0885b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6064a = true;
        private long b = 54883;
        private a c = null;

        public b a() {
            return new b(this, null);
        }
    }

    static /* synthetic */ class c {
    }

    private b(C0885b c0885b) {
        this.f6062a = c0885b.f6064a;
        this.b = c0885b.b;
        this.c = c0885b.c;
    }

    /* synthetic */ b(C0885b c0885b, c cVar) {
        this(c0885b);
    }

    public String toString() {
        return "CloudConfig{enableCloudConfig=" + this.f6062a + ", productId=" + this.b + ", areaCode=" + this.c + '}';
    }
}
