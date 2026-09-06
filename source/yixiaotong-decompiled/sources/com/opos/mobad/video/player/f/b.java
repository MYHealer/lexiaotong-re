package com.opos.mobad.video.player.f;

import com.opos.mobad.ad.f;
import com.opos.mobad.model.data.AdItemData;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements f, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f8401a;
    private boolean b = false;
    private boolean c = false;

    public b(d dVar) {
        this.f8401a = dVar;
    }

    @Override // com.opos.mobad.m.a.InterfaceC0974a
    public void a() {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.a();
    }

    @Override // com.opos.mobad.cmn.func.a.a.b
    public void a(int i, String str) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.a(i, str);
    }

    @Override // com.opos.mobad.ad.l.b
    public void a(long j) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.a(j);
    }

    @Override // com.opos.mobad.video.player.f.d
    public void a(com.opos.mobad.cmn.service.pkginstall.c.b bVar) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.a(bVar);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void a(AdItemData adItemData, String str) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.a(adItemData, str);
    }

    @Override // com.opos.mobad.video.player.f.d
    public void a(com.opos.mobad.o.c cVar) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.a(cVar);
    }

    @Override // com.opos.mobad.ad.l.b
    public void a(String str) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.a(str);
    }

    @Override // com.opos.mobad.ad.f
    public void a(Map<String, String> map) {
        d dVar = this.f8401a;
        if (dVar instanceof f) {
            ((f) dVar).a(map);
        }
    }

    @Override // com.opos.mobad.ad.j
    public void a(Object... objArr) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.a(objArr);
    }

    @Override // com.opos.mobad.m.d.a
    public void b() {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.b();
    }

    @Override // com.opos.mobad.m.d.a
    public void b(long j) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        if (this.b) {
            com.opos.cmn.an.f.a.b("AbsRewardVideoProxyListenerDecorator", "has process close");
        } else {
            this.b = true;
            dVar.b(j);
        }
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void b(AdItemData adItemData, String str) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.b(adItemData, str);
    }

    @Override // com.opos.mobad.m.d.a
    public void b(String str) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.b(str);
    }

    @Override // com.opos.mobad.ad.b.a
    public void c() {
        d dVar = this.f8401a;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void c(AdItemData adItemData, String str) {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.c(adItemData, str);
    }

    @Override // com.opos.mobad.cmn.func.a.a.b
    public void d() {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        if (this.c) {
            com.opos.cmn.an.f.a.b("AbsRewardVideoProxyListenerDecorator", "has ad close");
        } else {
            this.c = true;
            dVar.d();
        }
    }

    @Override // com.opos.mobad.video.player.f.d
    public void e() {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.e();
    }

    @Override // com.opos.mobad.m.d.a
    public void g_() {
        d dVar = this.f8401a;
        if (dVar == null) {
            return;
        }
        dVar.g_();
    }
}
