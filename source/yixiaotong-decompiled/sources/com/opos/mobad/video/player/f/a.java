package com.opos.mobad.video.player.f;

import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.cmn.service.pkginstall.c.b f8400a;

    @Override // com.opos.mobad.video.player.f.d
    public void a(com.opos.mobad.cmn.service.pkginstall.c.b bVar) {
        this.f8400a = bVar;
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void a(AdItemData adItemData, String str) {
        com.opos.mobad.cmn.service.pkginstall.c.b bVar = this.f8400a;
        if (bVar != null) {
            bVar.a(adItemData, str);
        }
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void b(AdItemData adItemData, String str) {
        com.opos.mobad.cmn.service.pkginstall.c.b bVar = this.f8400a;
        if (bVar != null) {
            bVar.b(adItemData, str);
        }
    }

    @Override // com.opos.mobad.ad.b.a
    public void c() {
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void c(AdItemData adItemData, String str) {
        com.opos.mobad.cmn.service.pkginstall.c.b bVar = this.f8400a;
        if (bVar != null) {
            bVar.c(adItemData, str);
        }
    }
}
