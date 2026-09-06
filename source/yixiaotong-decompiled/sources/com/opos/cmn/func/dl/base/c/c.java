package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.func.a.a.e f6119a;
    private Map<String, String> b = new HashMap();

    public static class a implements d.a {
        @Override // com.opos.cmn.func.dl.base.c.d.a
        public final d a() {
            return new c();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a() {
        com.opos.cmn.func.a.a.e eVar = this.f6119a;
        if (eVar != null) {
            return eVar.c;
        }
        return null;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a(Context context, String str, b bVar) {
        if (bVar.f6118a != null) {
            this.b.putAll(bVar.f6118a);
        }
        this.f6119a = com.opos.cmn.func.a.a.b.a().a(context, new com.opos.cmn.func.a.a.d.a().b(str).a(this.b).a("GET").a());
        return a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String a(String str) {
        com.opos.cmn.func.a.a.e eVar = this.f6119a;
        return (eVar == null || eVar.f == null) ? "" : this.f6119a.f.a(str);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void a(String str, String str2) {
        this.b.put(str, str2);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String b() {
        com.opos.cmn.func.a.a.e eVar = this.f6119a;
        return eVar != null ? eVar.b : "";
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void c() {
        com.opos.cmn.func.a.a.e eVar = this.f6119a;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final int d() {
        com.opos.cmn.func.a.a.e eVar = this.f6119a;
        if (eVar != null) {
            return eVar.f6077a;
        }
        return -1;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final long e() {
        com.opos.cmn.func.a.a.e eVar = this.f6119a;
        if (eVar != null) {
            return eVar.d;
        }
        return -1L;
    }
}
