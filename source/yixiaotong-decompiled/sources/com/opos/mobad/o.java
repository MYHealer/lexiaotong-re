package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o implements com.opos.mobad.ad.c {
    private static final String[] k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.opos.mobad.cmn.func.a f7233a;
    protected com.opos.mobad.video.player.d b;
    protected com.opos.mobad.cmn.a.b c;
    protected final com.opos.mobad.cmn.func.adhandler.f d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private Context f;
    private String g;
    private String h;
    private boolean i;
    private m j;

    static {
        if (com.opos.mobad.cmn.func.b.g.j()) {
            k = new String[]{com.kuaishou.weapon.p0.g.b, com.kuaishou.weapon.p0.g.d, com.kuaishou.weapon.p0.g.f4712a};
        } else {
            k = new String[]{com.kuaishou.weapon.p0.g.b, com.kuaishou.weapon.p0.g.d, com.kuaishou.weapon.p0.g.f4712a, "android.permission.QUERY_ALL_PACKAGES"};
        }
    }

    protected o(com.opos.mobad.video.player.d dVar, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.activity.webview.a aVar2, com.opos.mobad.cmn.a.b bVar, com.opos.mobad.cmn.func.adhandler.f fVar) {
        this.b = dVar;
        this.c = bVar;
        this.f7233a = aVar;
        this.d = fVar;
        com.opos.mobad.cmn.service.a.a().a(aVar, aVar2);
    }

    private int a(int i) {
        switch (i) {
            case 1:
                return 6;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return 0;
        }
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar) {
        b bVarB;
        if (a() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.a.d(activity, bVarB, str2, z, this.f7233a, cVar, this.c, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.a a(Context context) {
        if (!com.opos.mobad.cmn.func.b.g.c()) {
            return new com.opos.mobad.ad.c.a(false, "sdk not support android sdk version <19 .");
        }
        if (com.opos.cmn.i.j.a(this.f, k)) {
            return !com.opos.cmn.i.c.a(context, Uri.parse(new StringBuilder("content://").append(context.getPackageName()).append(".MobFileProvider").toString())) ? new com.opos.mobad.ad.c.a(false, "com.heytap.msp.mobad.api.MobFileProvider don't find in AndroidManifest.xml.") : new com.opos.mobad.ad.c.a(true, "");
        }
        return new com.opos.mobad.ad.c.a(false, "don't have some need normal permission.");
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.a a(Activity activity, String str, String str2, com.opos.mobad.ad.c.e eVar, com.opos.mobad.ad.c.b bVar) {
        b bVarB;
        if (a() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.h.b(activity, bVarB, str2, eVar, this.f7233a, bVar, this.b, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.c.d dVar) {
        b bVarB;
        if (a() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.i.a(activity, bVarB, str2, this.f7233a, this.b, dVar);
        }
        return null;
    }

    public com.opos.mobad.ad.d.c a(Context context, String str, String str2, int i, com.opos.mobad.ad.d.m mVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.k.c(bVarB, str2, i, this.f7233a, mVar, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.c a(Context context, String str, String str2, com.opos.mobad.ad.d.f fVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.k.c(bVarB, str2, this.f7233a, fVar, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.g a(Context context, String str, String str2, int i, int i2, com.opos.mobad.ad.d.j jVar, com.opos.mobad.ad.privacy.a aVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.k.d(bVarB, str2, this.f7233a, jVar, aVar, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.n a(Context context, com.opos.mobad.ad.d.s sVar, String str, String str2, com.opos.mobad.ad.d.o oVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.k.e(bVarB, str2, sVar, this.f7233a, oVar, this.c, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.e.b bVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.n.a(bVarB, str2, this.f7233a, this.b, bVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.a a(Context context, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar) {
        b bVarB;
        if (a() && (bVarB = b(context)) != null) {
            return new com.opos.mobad.p.a(bVarB, str2, this.f7233a, cVar, fVar, this.c, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.b a(Activity activity, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar) {
        b bVarB;
        if (a() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.p.c(activity, bVarB, str2, this.f7233a, cVar, fVar, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public String a(String str, int i) {
        String str2;
        if (a()) {
            b bVarB = b(this.f);
            if (bVarB == null) {
                return null;
            }
            int iA = a(i);
            if (iA != 0) {
                return i == 4 ? com.opos.mobad.cmn.a.a(bVarB, str, iA) : com.opos.mobad.cmn.a.b(bVarB, str, iA);
            }
            str2 = "";
        } else {
            str2 = "please init first";
        }
        com.opos.cmn.an.f.a.d("MobBaseAdCreator", str2);
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z, com.opos.mobad.ad.g gVar) {
        String str4;
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("MobBaseAdCreator", "init with null content or appId ");
            str4 = "init with null content or appId";
        } else {
            if (a(context).f6642a) {
                if (this.e.compareAndSet(false, true)) {
                    this.f = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    this.g = str;
                    this.h = str2;
                    this.i = z;
                    d.a().a(context);
                    m mVar = new m();
                    this.j = mVar;
                    mVar.a(context, str);
                }
                gVar.a();
                return;
            }
            str4 = "init but fail";
            com.opos.cmn.an.f.a.b("MobBaseAdCreator", "init but fail");
        }
        gVar.a(str4);
    }

    protected boolean a() {
        return this.e.get() && this.f != null;
    }

    protected b b(Context context) {
        return d.a().b(context);
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
        this.e.compareAndSet(true, false);
        m mVar = this.j;
        if (mVar != null) {
            mVar.a();
        }
        com.opos.mobad.cmn.func.adhandler.f fVar = this.d;
        if (fVar != null) {
            fVar.c();
        }
        com.opos.mobad.cmn.service.a.a().d();
    }
}
