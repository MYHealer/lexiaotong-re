package com.opos.cmn.an.f.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5890a;
    public final boolean b;

    /* JADX INFO: renamed from: com.opos.cmn.an.f.a.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5891a;
        private boolean b = true;

        public a a(String str) {
            this.f5891a = str;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public c a() {
            return new c(this, null);
        }
    }

    private c(a aVar) {
        this.f5890a = aVar.f5891a;
        this.b = aVar.b;
    }

    /* synthetic */ c(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "UploadParams{, businessType=" + this.f5890a + ", onlyWifi=" + this.b + '}';
    }
}
