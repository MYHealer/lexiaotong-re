package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class p extends com.opos.mobad.ad.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.cmn.func.a f7243a;
    private AtomicBoolean b;
    private m c;

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar) {
        b bVarB;
        if (this.b.get() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.a.d(activity, bVarB, str2, z, this.f7243a, cVar, null, null);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.a a(Context context) {
        return new com.opos.mobad.ad.c.a(true, "");
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.a a(Activity activity, String str, String str2, com.opos.mobad.ad.c.e eVar, com.opos.mobad.ad.c.b bVar) {
        return new com.opos.mobad.oversea.a(bVar);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.c.d dVar) {
        return new com.opos.mobad.oversea.b(dVar);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.c a(Context context, String str, String str2, com.opos.mobad.ad.d.f fVar) {
        return new com.opos.mobad.oversea.c(fVar);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.g a(Context context, String str, String str2, int i, int i2, com.opos.mobad.ad.d.j jVar, com.opos.mobad.ad.privacy.a aVar) {
        b bVarB;
        if (this.b.get() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.k.d(bVarB, str2, this.f7243a, jVar, null, null);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.n a(Context context, com.opos.mobad.ad.d.s sVar, String str, String str2, com.opos.mobad.ad.d.o oVar) {
        b bVarB;
        if (this.b.get() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.k.e(bVarB, str2, sVar, this.f7243a, oVar, null, null);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.e.b bVar) {
        return new com.opos.mobad.oversea.d(bVar);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.a a(Context context, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.b a(Activity activity, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar) {
        return new com.opos.mobad.oversea.e(cVar);
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z, com.opos.mobad.ad.g gVar) {
        if (this.b.compareAndSet(false, true)) {
            this.c.a(context, str);
            d.a().a(context);
            com.opos.mobad.cmn.service.a.a().a(this.f7243a, (com.opos.mobad.activity.webview.a) null);
            gVar.a();
        }
    }

    protected b b(Context context) {
        return d.a().b(context);
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
        if (this.b.compareAndSet(true, false)) {
            this.c.a();
        }
    }
}
