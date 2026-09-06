package com.opos.mobad.ad.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6648a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f6649a = 30000;

        public a a(long j) {
            if (j >= 500 && j <= 30000) {
                this.f6649a = j;
            }
            return this;
        }

        public r a() {
            return new r(this);
        }
    }

    public r(a aVar) {
        this.f6648a = aVar.f6649a;
    }

    public String toString() {
        return "NativeAdParams{fetchTimeout=" + this.f6648a + '}';
    }
}
