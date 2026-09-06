package com.opos.mobad.model.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h implements com.opos.mobad.model.e.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.model.b.c f7158a;

    public h(com.opos.mobad.model.b.c cVar) {
        this.f7158a = cVar;
    }

    @Override // com.opos.mobad.model.e.h
    public com.opos.mobad.model.e.g a(com.opos.mobad.b bVar, String str, String str2, com.opos.mobad.model.c.c cVar, boolean z, int i, int i2, com.opos.mobad.model.e.h.a aVar) {
        return new j(bVar, str, str2, cVar, z, this.f7158a, i, i2, aVar);
    }
}
