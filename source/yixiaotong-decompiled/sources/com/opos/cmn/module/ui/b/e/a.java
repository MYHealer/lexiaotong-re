package com.opos.cmn.module.ui.b.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6209a;
    public final boolean b;
    public final boolean c;

    /* JADX INFO: renamed from: com.opos.cmn.module.ui.b.e.a$a, reason: collision with other inner class name */
    public static class C0898a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6210a = 0;
        private boolean b;
        private boolean c;

        public C0898a a(int i) {
            this.f6210a = i;
            return this;
        }

        public C0898a a(boolean z) {
            this.b = z;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public C0898a b(boolean z) {
            this.c = z;
            return this;
        }
    }

    public a(C0898a c0898a) {
        this.f6209a = c0898a.f6210a;
        this.b = c0898a.b;
        this.c = c0898a.c;
    }
}
