package com.opos.mobad.ad.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6650a;
    public final int b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6651a = 0;
        private int b = 0;

        public a a(int i) {
            this.f6651a = i;
            return this;
        }

        public s a() {
            return new s(this);
        }

        public a b(int i) {
            this.b = i;
            return this;
        }
    }

    public s(a aVar) {
        this.f6650a = aVar.f6651a;
        this.b = aVar.b;
    }

    public String toString() {
        return "NativeAdSize{widthInDp=" + this.f6650a + ", heightInDp=" + this.b + '}';
    }
}
