package com.opos.cmn.biz.web.b.a;

import com.opos.cmn.biz.web.b.a.a.c;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.cmn.biz.web.b.a.a.b f6042a;
    public final Map<String, Object> b;
    public final boolean c;
    public final com.opos.cmn.biz.web.b.a.a.a d;
    public final c e;

    /* JADX INFO: renamed from: com.opos.cmn.biz.web.b.a.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.cmn.biz.web.b.a.a.b f6043a;
        private Map<String, Object> b;
        private boolean c = true;
        private com.opos.cmn.biz.web.b.a.a.a d;
        private c e;

        public a a(com.opos.cmn.biz.web.b.a.a.a aVar) {
            this.d = aVar;
            return this;
        }

        public a a(com.opos.cmn.biz.web.b.a.a.b bVar) {
            this.f6043a = bVar;
            return this;
        }

        public a a(c cVar) {
            this.e = cVar;
            return this;
        }

        public a a(Map<String, Object> map) {
            this.b = map;
            return this;
        }

        public a a(boolean z) {
            this.c = z;
            return this;
        }

        public b a() {
            return new b(this, null);
        }
    }

    private b(a aVar) {
        this.f6042a = aVar.f6043a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "WebViewInitParams{iWebActionListener=" + this.f6042a + ", jsInterfaceMap=" + this.b + ", isShowTitle=" + this.c + ", iReceivedSslErrorHandler=" + this.d + ", iWebToDeepLinkListener=" + this.e + '}';
    }
}
