package com.opos.mobad.ad.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6643a;
    public final boolean b;
    public final b c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6644a = true;
        private boolean b = false;
        private b c = b.NORMAL;

        public a a(b bVar) {
            this.c = bVar;
            return this;
        }

        public a a(boolean z) {
            this.f6644a = z;
            return this;
        }

        public e a() {
            return new e(this);
        }

        public a b(boolean z) {
            this.b = z;
            return this;
        }
    }

    public enum b {
        NORMAL,
        INSTANT_EXIT
    }

    public e(a aVar) {
        this.f6643a = aVar.b;
        this.b = aVar.f6644a;
        this.c = aVar.c;
    }
}
