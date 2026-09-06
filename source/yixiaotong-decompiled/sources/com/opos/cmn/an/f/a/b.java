package com.opos.cmn.an.f.a;

import android.content.Context;
import com.opos.cmn.an.f.c.f;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5886a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final String f;
    public final Context g;
    public final InterfaceC0866b h;
    public final c i;

    /* JADX INFO: renamed from: com.opos.cmn.an.f.a.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f5887a;
        private InterfaceC0866b g;
        private c h;
        private int b = 2;
        private int c = 2;
        private int d = 7;
        private String e = "";
        private String f = "cmn_log";
        private int i = 2;

        private void a() {
            if (com.opos.cmn.an.d.a.a(this.e)) {
                this.e = this.f5887a.getPackageName();
            }
            if (this.g == null) {
                this.g = new InterfaceC0866b() { // from class: com.opos.cmn.an.f.a.b.a.1
                    @Override // com.opos.cmn.an.f.a.b.InterfaceC0866b
                    public String a() {
                        return f.b(a.this.f5887a);
                    }
                };
            }
            if (this.h == null) {
                this.h = new c() { // from class: com.opos.cmn.an.f.a.b.a.2
                    @Override // com.opos.cmn.an.f.a.b.c
                    public String a() {
                        return com.opos.cmn.an.f.c.b.a(a.this.f5887a);
                    }
                };
            }
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public b a(Context context) {
            if (context == null) {
                throw new NullPointerException("context is null.");
            }
            this.f5887a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            a();
            return new b(this, null);
        }

        public a b(int i) {
            this.c = i;
            return this;
        }

        public a b(String str) {
            if (!com.opos.cmn.an.d.a.a(str)) {
                this.e = str;
            }
            return this;
        }

        public a c(int i) {
            if (i > 0) {
                this.d = i;
            }
            return this;
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.an.f.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0866b {
        String a();
    }

    public interface c {
        String a();
    }

    private b(a aVar) {
        this.f5886a = aVar.f;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f5887a;
        this.h = aVar.g;
        this.i = aVar.h;
        this.e = aVar.i;
    }

    /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "LogInitParams{, context=" + this.g + ", baseTag=" + this.f5886a + ", fileLogLevel=" + this.b + ", consoleLogLevel=" + this.c + ", fileExpireDays=" + this.d + ", pkgName=" + this.f + ", imeiProvider=" + this.h + ", openIdProvider=" + this.i + ", logImplType=" + this.e + '}';
    }
}
