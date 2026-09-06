package com.opos.mobad.cmn.func.adhandler;

import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements com.opos.mobad.cmn.service.pkginstall.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.cmn.service.pkginstall.c.b f6794a;
    private com.opos.mobad.b b;
    private e c;

    public c(com.opos.mobad.b bVar, e eVar, com.opos.mobad.cmn.service.pkginstall.c.b bVar2) {
        this.b = bVar;
        this.c = eVar;
        this.f6794a = bVar2;
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void a(AdItemData adItemData, String str) {
        com.opos.cmn.an.f.a.b("DownloaderPkgInstallListenerWrapper", "notifyInstallCompletedEvent pkgName = " + str);
        com.opos.mobad.cmn.service.pkginstall.c.b bVar = this.f6794a;
        if (bVar != null) {
            bVar.a(adItemData, str);
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.a(200, "");
        }
        this.b.l().c(str);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void b(AdItemData adItemData, String str) {
        com.opos.mobad.cmn.service.pkginstall.c.b bVar = this.f6794a;
        if (bVar != null) {
            bVar.b(adItemData, str);
        }
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void c(AdItemData adItemData, String str) {
        com.opos.mobad.cmn.service.pkginstall.c.b bVar = this.f6794a;
        if (bVar != null) {
            bVar.c(adItemData, str);
        }
    }
}
