package com.opos.mobad.g.a.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.ad.d.j;
import com.opos.mobad.ad.d.m;
import com.opos.mobad.ad.d.n;
import com.opos.mobad.ad.d.s;
import com.opos.mobad.o;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.mobad.ad.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.c f6968a;
    private com.opos.mobad.ad.c b;
    private Context c;
    private AtomicBoolean d;

    private boolean a() {
        return this.d.get();
    }

    private void b(Context context, String str, String str2, String str3, boolean z, com.opos.mobad.ad.g gVar) {
        if (!com.opos.mobad.c.b.a().a(1001)) {
            com.opos.cmn.an.f.a.a("MobAdCreator", "init but channel not support");
            return;
        }
        if (TextUtils.isEmpty(com.opos.mobad.c.b.a().y())) {
            com.opos.cmn.an.f.a.a("MobAdCreator", "init but null token");
        } else if (com.opos.mobad.c.b.k().f()) {
            com.opos.cmn.an.f.a.a("MobAdCreator", "init but touristMode");
        } else {
            this.b.a(context, str, str2, str3, z, gVar);
        }
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar) {
        if (a()) {
            return new c(activity, str2, aVar, cVar, z, this.f6968a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.a a(Context context) {
        return this.f6968a.a(context);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.a a(Activity activity, String str, String str2, com.opos.mobad.ad.c.e eVar, com.opos.mobad.ad.c.b bVar) {
        if (a()) {
            return new e(activity, str2, bVar, eVar, this.f6968a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.c.d dVar) {
        if (a()) {
            return this.f6968a.a(activity, str, str2, z, dVar);
        }
        return null;
    }

    public com.opos.mobad.ad.d.c a(Context context, String str, String str2, int i, m mVar) {
        if (a()) {
            return ((o) this.f6968a).a(context, str, str2, i, mVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.c a(Context context, String str, String str2, com.opos.mobad.ad.d.f fVar) {
        if (a()) {
            return this.f6968a.a(context, str, str2, fVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.g a(Context context, String str, String str2, int i, int i2, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        if (a()) {
            return new f(context, str2, i, i2, jVar, aVar, this.f6968a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public n a(Context context, s sVar, String str, String str2, com.opos.mobad.ad.d.o oVar) {
        if (a()) {
            return new g(context, str2, oVar, sVar, this.f6968a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.e.b bVar) {
        if (a()) {
            return new h(context, str2, bVar, this.f6968a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.a a(Context context, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar) {
        if (a()) {
            return this.f6968a.a(context, str, str2, fVar, cVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.b a(Activity activity, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar) {
        if (a()) {
            return this.f6968a.a(activity, str, str2, fVar, cVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public String a(String str, int i) {
        if (!a()) {
            com.opos.cmn.an.f.a.d("", "please init first: " + str);
            return null;
        }
        com.opos.mobad.ad.c cVar = this.f6968a;
        if (cVar == null) {
            return null;
        }
        return cVar.a(str, i);
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z, com.opos.mobad.ad.g gVar) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.c = origApplicationContext;
        if (origApplicationContext == null) {
            com.opos.cmn.an.f.a.a("MobAdCreator", "init but null context");
            return;
        }
        if (a(context).f6642a) {
            this.f6968a.a(context, str, str2, str3, z, gVar);
            b(context, str, str2, str3, z, gVar);
            if (this.d.compareAndSet(false, true)) {
                d.a().a(context);
            }
        }
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
        if (this.d.compareAndSet(true, false)) {
            this.f6968a.b();
            com.opos.mobad.ad.c cVar = this.b;
            if (cVar != null) {
                cVar.b();
            }
            d.a().c();
        }
    }
}
