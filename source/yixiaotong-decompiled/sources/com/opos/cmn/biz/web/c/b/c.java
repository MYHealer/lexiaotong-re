package com.opos.cmn.biz.web.c.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6055a;
    public final boolean b;
    public final String c;

    /* JADX INFO: renamed from: com.opos.cmn.biz.web.c.b.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {
        private String b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6056a = true;
        private String c = "";

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(boolean z) {
            this.f6056a = z;
            return this;
        }

        public c a() {
            if (this.c == null) {
                this.c = "";
            }
            return new c(this, null);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }
    }

    private c(a aVar) {
        this.b = aVar.f6056a;
        this.c = aVar.b;
        this.f6055a = aVar.c;
    }

    /* synthetic */ c(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "JsCommonInitParams{, businessType=" + this.f6055a + "forceJsInit=" + this.b + ", jsSign=" + this.c + '}';
    }
}
