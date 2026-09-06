package com.opos.mobad.g;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.d.g;
import com.opos.mobad.ad.d.j;
import com.opos.mobad.ad.d.n;
import com.opos.mobad.ad.d.o;
import com.opos.mobad.ad.d.s;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends com.opos.mobad.ad.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.opos.mobad.c.a.d.a> f7011a;
    private final com.opos.mobad.c.a.d.a b;
    private final b c;
    private final long d;
    private com.opos.mobad.g.a.e.a e;

    public d(com.opos.mobad.g.a.e.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, b bVar) {
        this.e = aVar;
        this.f7011a = list;
        this.b = aVar2;
        this.c = bVar;
        this.d = j;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar) {
        return new com.opos.mobad.g.a.a(activity, str, this.e, false, aVar, cVar, this.f7011a, this.b, this.d, this.c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.a a(Context context) {
        return new com.opos.mobad.ad.c.a(true, "");
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.a a(Activity activity, String str, String str2, com.opos.mobad.ad.c.e eVar, com.opos.mobad.ad.c.b bVar) {
        return new com.opos.mobad.g.a.d(activity, str, this.e, bVar, this.f7011a, this.b, this.d, this.c, eVar);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.c.d dVar) {
        return new com.opos.mobad.g.a.e(activity, str, this.e, dVar, z, this.f7011a, this.b, this.d, this.c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.c a(Context context, String str, String str2, com.opos.mobad.ad.d.f fVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public g a(Context context, String str, String str2, int i, int i2, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        return new com.opos.mobad.g.a.f(context, str, this.e, jVar, this.f7011a, this.b, this.d, this.c, aVar);
    }

    @Override // com.opos.mobad.ad.c
    public n a(Context context, s sVar, String str, String str2, o oVar) {
        return new com.opos.mobad.g.a.g(context, sVar, str, this.e, oVar, this.f7011a, this.b, this.d, this.c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.e.b bVar) {
        return new com.opos.mobad.g.a.j(context, str, this.e, bVar, z, this.f7011a, this.b, this.d, this.c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.a a(Context context, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.b a(Activity activity, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z, com.opos.mobad.ad.g gVar) {
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
    }
}
