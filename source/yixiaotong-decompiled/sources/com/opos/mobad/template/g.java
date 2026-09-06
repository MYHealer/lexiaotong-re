package com.opos.mobad.template;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f7758a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7759a = false;
    }

    public static void a(a aVar) {
        f7758a = aVar;
    }

    public static boolean a() {
        if (f7758a != null) {
            com.opos.cmn.an.f.a.b("TemplateManager", "shouldCheckViewMockClick:" + f7758a.f7759a);
            return f7758a.f7759a;
        }
        com.opos.cmn.an.f.a.b("TemplateManager", "shouldCheckViewMockClick:false");
        return false;
    }
}
