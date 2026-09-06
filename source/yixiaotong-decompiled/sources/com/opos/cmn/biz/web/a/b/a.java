package com.opos.cmn.biz.web.a.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6036a;
    public final String b;

    /* JADX INFO: renamed from: com.opos.cmn.biz.web.a.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.opos.cmn.biz.web.a.b.a$a, reason: collision with other inner class name */
    public static class C0882a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6037a;
        private String b;

        public C0882a a(String str) {
            this.f6037a = str;
            return this;
        }

        public a a() throws Exception {
            if (TextUtils.isEmpty(this.f6037a)) {
                throw new Exception("url is null.");
            }
            return new a(this, null);
        }

        public C0882a b(String str) {
            this.b = str;
            return this;
        }
    }

    private a(C0882a c0882a) {
        this.f6036a = c0882a.f6037a;
        this.b = c0882a.b;
    }

    /* synthetic */ a(C0882a c0882a, AnonymousClass1 anonymousClass1) {
        this(c0882a);
    }

    public String toString() {
        return "CacheResourceRequest{url=" + this.f6036a + ", md5=" + this.b + '}';
    }
}
