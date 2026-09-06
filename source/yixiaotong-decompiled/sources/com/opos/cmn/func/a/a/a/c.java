package com.opos.cmn.func.a.a.a;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6065a;
    public final String b;
    public final String c;
    public final boolean d;
    public final List<String> e;
    public final b f;

    public static class a {
        private String b;
        private String c;
        private List<String> e;
        private b f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6066a = true;
        private boolean d = true;

        public c a() {
            return new c(this, null);
        }
    }

    public interface b {
    }

    /* JADX INFO: renamed from: com.opos.cmn.func.a.a.a.c$c, reason: collision with other inner class name */
    static /* synthetic */ class C0886c {
    }

    private c(a aVar) {
        this.f6065a = aVar.f6066a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    /* synthetic */ c(a aVar, C0886c c0886c) {
        this(aVar);
    }

    public String toString() {
        return "HttpDnsConfig{enableHttpDns=" + this.f6065a + ", region='" + this.b + "', appVersion='" + this.c + "', enableDnUnit=" + this.d + ", innerWhiteList=" + this.e + ", accountCallback=" + this.f + '}';
    }
}
