package com.opos.mobad.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7120a;
    public final long b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7121a = false;
        private long b = -1;

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a a(boolean z) {
            this.f7121a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f7120a = aVar.f7121a;
        this.b = aVar.b;
    }

    public String toString() {
        return "DownloadResponse{success=" + this.f7120a + ", contentLength=" + this.b + '}';
    }
}
