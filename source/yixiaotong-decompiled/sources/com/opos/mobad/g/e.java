package com.opos.mobad.g;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.heytap.nearx.tapplugin.pluginapi.PluginApi;
import com.opos.mobad.ad.d.g;
import com.opos.mobad.ad.d.j;
import com.opos.mobad.ad.d.m;
import com.opos.mobad.ad.d.n;
import com.opos.mobad.ad.d.o;
import com.opos.mobad.ad.d.s;
import com.opos.mobad.model.e.k;
import com.opos.mobad.provider.MobAdGlobalProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f7012a;

    private void b() {
    }

    private void c() {
        if (this.f7012a == null) {
            return;
        }
        com.opos.mobad.c.b.f().a(this.f7012a.a(), this.f7012a.b(), this.f7012a.c());
    }

    public com.opos.mobad.ad.a.b a(Activity activity, String str, com.opos.mobad.ad.a.c cVar) {
        return c.e().a(activity, str, cVar);
    }

    public com.opos.mobad.ad.c.a a(Activity activity, String str, com.opos.mobad.ad.c.e eVar, com.opos.mobad.ad.c.b bVar) {
        return c.e().a(activity, str, eVar, bVar);
    }

    public com.opos.mobad.ad.c.c a(Activity activity, String str, com.opos.mobad.ad.c.d dVar) {
        return c.e().a(activity, str, dVar);
    }

    public com.opos.mobad.ad.d.c a(Context context, String str, int i, m mVar) {
        return c.e().a(context, str, i, mVar);
    }

    public com.opos.mobad.ad.d.c a(Context context, String str, com.opos.mobad.ad.d.f fVar) {
        return c.e().a(context, str, fVar);
    }

    public g a(Context context, String str, j jVar) {
        return c.e().a(context, str, jVar);
    }

    public n a(Context context, String str, s sVar, o oVar) {
        return c.e().a(context, str, sVar, oVar);
    }

    public com.opos.mobad.ad.e.a a(Context context, String str, com.opos.mobad.ad.e.b bVar) {
        return c.e().a(context, str, bVar);
    }

    public com.opos.mobad.ad.f.a a(Context context, String str, com.opos.mobad.ad.f.c cVar, com.opos.mobad.ad.f.f fVar) {
        return c.e().a(context, str, cVar, fVar);
    }

    public com.opos.mobad.ad.f.b a(Activity activity, String str, com.opos.mobad.ad.f.c cVar, com.opos.mobad.ad.f.f fVar) {
        return c.e().a(activity, str, cVar, fVar);
    }

    public String a(String str, int i) {
        return c.e().a(str, i);
    }

    public void a(Context context) {
        if (context == null) {
            com.opos.cmn.an.f.a.d("MobAdManager", "exit with null context");
            return;
        }
        c.b(com.opos.mobad.service.a.a(context));
        com.opos.mobad.c.b.m();
        com.opos.mobad.service.a.a();
    }

    public void a(Context context, String str, int i) {
        a(context, str, i, (com.opos.mobad.ad.g) null);
    }

    public void a(Context context, String str, int i, com.opos.mobad.ad.g gVar) {
        a(context, str, false, true, i, gVar, false, 0, null);
    }

    public void a(Context context, String str, boolean z, boolean z2, int i, com.opos.mobad.ad.g gVar, boolean z3, int i2, com.opos.mobad.ad.d dVar) {
        a(context, str, z, z2, i, gVar, z3, i2, dVar, null);
    }

    public void a(final Context context, final String str, boolean z, boolean z2, final int i, com.opos.mobad.ad.g gVar, boolean z3, int i2, final com.opos.mobad.ad.d dVar, com.opos.mobad.ad.e eVar) {
        this.f7012a = new k();
        if (context == null || com.opos.cmn.an.d.a.a(str)) {
            if (gVar != null) {
                gVar.a("context or appId is null.");
                return;
            }
            return;
        }
        if (PluginApi.sPluginMode) {
            if (com.opos.cmn.an.c.c.b() >= 21 || gVar == null) {
                return;
            }
            gVar.a("init sdk failed! sdk not support android sdk version < 21");
            return;
        }
        if (com.opos.cmn.an.c.c.b() < 19) {
            if (gVar != null) {
                gVar.a("init sdk failed! sdk not support android sdk version < 19");
                return;
            }
            return;
        }
        if (!com.opos.cmn.i.c.a(context, Uri.parse("content://" + MobAdGlobalProvider.getAuthority(context)))) {
            if (gVar != null) {
                gVar.a("init sdk failed! com.opos.mobad.provider.MobAdGlobalProvider don't find in AndroidManifest.xml.");
                return;
            }
            return;
        }
        if (!com.opos.cmn.i.c.a(context, Uri.parse("content://" + context.getPackageName() + ".MobFileProvider"))) {
            if (gVar != null) {
                gVar.a("init sdk failed! com.heytap.msp.mobad.api.MobFileProvider don't find in AndroidManifest.xml.");
                return;
            }
            return;
        }
        Context context2 = PluginApi.sPluginContext;
        if (PluginApi.sPluginMode && context2 == null) {
            if (gVar != null) {
                gVar.a("init sdk failed!");
                return;
            }
            return;
        }
        Context context3 = context2 == null ? context : context2;
        k kVar = this.f7012a;
        if (kVar != null) {
            kVar.a(true);
        }
        com.opos.cmn.an.e.a.a.a(context3);
        com.opos.mobad.service.a.a(context3, context);
        com.opos.mobad.c.b.a(context3, z, new com.opos.mobad.service.e.d.a() { // from class: com.opos.mobad.g.e.1
            private String d;
            private String e;
            private int f = -1;

            @Override // com.opos.mobad.service.e.d.a
            public String a() {
                return str;
            }

            @Override // com.opos.mobad.service.e.d.a
            public String b() {
                if (TextUtils.isEmpty(this.d)) {
                    this.d = context.getPackageName();
                }
                return this.d;
            }

            @Override // com.opos.mobad.service.e.d.a
            public String c() {
                if (TextUtils.isEmpty(this.e)) {
                    Context context4 = context;
                    this.e = com.opos.cmn.an.h.d.a.c(context4, context4.getPackageName());
                }
                return this.e;
            }

            @Override // com.opos.mobad.service.e.d.a
            public int d() {
                if (this.f < 0) {
                    Context context4 = context;
                    this.f = com.opos.cmn.an.h.d.a.b(context4, context4.getPackageName());
                }
                return this.f;
            }
        }, new com.opos.mobad.service.e.d.f() { // from class: com.opos.mobad.g.e.2
            @Override // com.opos.mobad.service.e.d.f
            public int a() {
                return 810004;
            }

            @Override // com.opos.mobad.service.e.d.f
            public String b() {
                return "8.1.0";
            }

            @Override // com.opos.mobad.service.e.d.f
            public int c() {
                return i;
            }
        }, z2, z3, i2, new com.opos.mobad.service.e.d.InterfaceC0994d() { // from class: com.opos.mobad.g.e.3
            private String c;
            private String d;
            private Boolean e;

            @Override // com.opos.mobad.service.e.d.InterfaceC0994d
            public String a() {
                if (TextUtils.isEmpty(this.c)) {
                    this.c = com.opos.mobad.cmn.func.b.c.a(context);
                }
                return this.c;
            }

            @Override // com.opos.mobad.service.e.d.InterfaceC0994d
            public String b() {
                if (TextUtils.isEmpty(this.d)) {
                    this.d = com.opos.mobad.cmn.func.b.c.a();
                }
                return this.d;
            }

            @Override // com.opos.mobad.service.e.d.InterfaceC0994d
            public boolean c() {
                if (this.e == null) {
                    this.e = Boolean.valueOf(com.opos.mobad.cmn.func.b.c.b(context));
                }
                return this.e.booleanValue();
            }

            @Override // com.opos.mobad.service.e.d.InterfaceC0994d
            public void d() {
                this.c = com.opos.mobad.cmn.func.b.c.a(context);
                this.d = com.opos.mobad.cmn.func.b.c.a();
                this.e = Boolean.valueOf(com.opos.mobad.cmn.func.b.c.b(context));
            }
        }, new com.opos.mobad.service.e.d.g() { // from class: com.opos.mobad.g.e.4
            private String c;
            private String d;
            private Boolean e;

            @Override // com.opos.mobad.service.e.d.g
            public String a() {
                if (TextUtils.isEmpty(this.c)) {
                    this.c = com.opos.mobad.cmn.func.b.c.a(context);
                }
                return this.c;
            }

            @Override // com.opos.mobad.service.e.d.g
            public String b() {
                if (TextUtils.isEmpty(this.d)) {
                    this.d = com.opos.mobad.cmn.func.b.c.a();
                }
                return this.d;
            }

            @Override // com.opos.mobad.service.e.d.g
            public boolean c() {
                if (this.e == null) {
                    this.e = Boolean.valueOf(com.opos.mobad.cmn.func.b.c.b(context));
                }
                return this.e.booleanValue();
            }

            @Override // com.opos.mobad.service.e.d.g
            public void d() {
                this.c = com.opos.mobad.cmn.func.b.c.a(context);
                this.d = com.opos.mobad.cmn.func.b.c.a();
                this.e = Boolean.valueOf(com.opos.mobad.cmn.func.b.c.b(context));
            }
        }, dVar == null ? null : new com.opos.mobad.service.e.d.c() { // from class: com.opos.mobad.g.e.5
            @Override // com.opos.mobad.service.e.d.c
            public String a() {
                return dVar.a();
            }
        }, eVar);
        k kVar2 = this.f7012a;
        if (kVar2 != null) {
            kVar2.b(true);
        }
        c.e().a(context, str, i, z, z3);
        if (com.opos.cmn.a.a.a()) {
            com.opos.mobad.ad.c.a aVarB = c.e().b();
            if (!aVarB.f6642a) {
                com.opos.cmn.an.f.a.d("MobAdManager", aVarB.b);
                if (gVar != null) {
                    gVar.a(aVarB.b);
                    return;
                }
                return;
            }
        }
        if (!c.e().c()) {
            if (gVar != null) {
                gVar.a("init fail");
                return;
            }
            return;
        }
        b();
        com.opos.mobad.cmn.func.b.e.a(context);
        k kVar3 = this.f7012a;
        if (kVar3 != null) {
            kVar3.c(true);
            c();
        }
        if (gVar != null) {
            gVar.a();
        }
    }

    public boolean a() {
        return com.opos.mobad.c.b.a().c();
    }

    public boolean a(String str) {
        return com.opos.mobad.c.b.a().f(str);
    }

    public com.opos.mobad.ad.f.b b(Activity activity, String str, com.opos.mobad.ad.f.c cVar, com.opos.mobad.ad.f.f fVar) {
        return c.e().b(activity, str, cVar, fVar);
    }
}
