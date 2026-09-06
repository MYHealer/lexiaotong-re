package com.opos.mobad.m;

import android.view.View;
import com.opos.mobad.ad.j;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.opos.mobad.m.a f7144a;
    protected d b;
    protected e c;
    protected long d = -1;
    public String e;
    private AdItemData f;
    private MaterialData g;

    public interface a extends j, com.opos.mobad.m.a.InterfaceC0974a, d.a {
    }

    public f(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.cmn.service.pkginstall.c.b bVar2, final a aVar2) {
        this.f7144a = new com.opos.mobad.m.a(bVar, str, aVar, bVar2, aVar2);
        this.b = new d(bVar, str, aVar2);
        this.c = new e(bVar, new j() { // from class: com.opos.mobad.m.f.1
            @Override // com.opos.mobad.ad.j
            public void a(Object... objArr) {
                f.this.a(aVar2, objArr);
            }
        });
    }

    public static int b(int i, String str) {
        int iA = com.opos.mobad.j.a.a.a(i, str);
        if (iA == 1) {
            return 10601;
        }
        if (iA == 2) {
            return 10602;
        }
        if (iA == 3) {
            return 10603;
        }
        if (iA != 4) {
            return iA;
        }
        return 10604;
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(int i) {
        this.f7144a.a(b(i, ""), this.e);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(int i, int[] iArr) {
        a((View) null, iArr, i == 0 ? com.opos.mobad.cmn.func.b.a.FORWARD : com.opos.mobad.cmn.func.b.a.TILT);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(long j, long j2) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onComplete" + j);
        this.d = j2;
        this.b.a(j2);
        this.c.a(j);
    }

    public void a(View view) {
        a(view, (int[]) null, com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(View view, int i, boolean z) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onMockEventIntercepted");
        this.f7144a.a(view, i, z);
    }

    public void a(View view, Map<String, String> map) {
        Object[] objArr = new Object[1];
        objArr[0] = "onShow" + (map != null ? map.toString() : null);
        com.opos.cmn.an.f.a.b("UniversalPresenter", objArr);
        if (g.a(map)) {
            this.f7144a.b(view, map);
        } else {
            this.f7144a.a(view, map);
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(View view, int[] iArr, boolean z) {
    }

    public void a(j jVar, Object... objArr) {
        if (jVar == null) {
            return;
        }
        jVar.a(objArr);
    }

    public void a(AdItemData adItemData, MaterialData materialData, int i, String str) {
        a(adItemData, materialData, -1L, i, materialData.aa(), str);
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i, int i2, String str) {
        this.f = adItemData;
        this.g = materialData;
        this.d = -1L;
        this.e = str;
        this.f7144a.a(adItemData, materialData, i, i2);
        this.b.a(adItemData, materialData, j, i);
        this.c.a(adItemData, materialData);
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i, String str) {
        a(adItemData, materialData, j, i, materialData.aa(), str);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(int[] iArr) {
        a((View) null, iArr, com.opos.mobad.cmn.func.b.a.SHAKE);
    }

    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onClick adClickArea = " + aVar);
        if (!h.a(this.f, aVar)) {
            return false;
        }
        this.f7144a.a(view, iArr, aVar, this.d);
        e eVar = this.c;
        if (eVar == null) {
            return true;
        }
        eVar.a();
        return true;
    }

    public void b() {
        com.opos.mobad.m.a aVar = this.f7144a;
        if (aVar != null) {
            aVar.c();
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.a();
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void b(int i) {
        this.f7144a.a(i);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void b(long j, long j2) {
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void b(Map<String, String> map) {
        int iA = com.opos.mobad.j.a.c.a(map);
        String strB = com.opos.mobad.j.a.c.b(map);
        String strC = com.opos.mobad.j.a.c.c(map);
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onError code=", Integer.valueOf(iA), ", msg=", strB);
        this.b.a(b(iA, strC), strB, map);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void b(int[] iArr) {
        a((View) null, iArr, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_SHAKE);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void c(int i) {
        this.f7144a.c(i);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void c(long j, long j2) {
    }

    public void d() {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onBackClick");
        this.f7144a.a(true, (int[]) null, this.d);
        this.b.a((View) null, (int[]) null, this.d);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void d(long j, long j2) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onProcess =" + j + ",duration =" + j2);
        this.d = j;
        this.b.a(j, j2);
        this.c.a(j, j2);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void e() {
        this.f7144a.a();
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void e(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onCloseClick");
        this.f7144a.a(false, iArr, this.d);
        this.b.a(view, iArr, this.d);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void f(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.VIDEO);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void g(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.CLICK_BT);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void h(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.NON_CLICK_BT);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void i(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void j(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT);
    }

    public void k(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onClose");
        this.f7144a.b();
        this.b.a(view, iArr, this.d);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void l(View view, int[] iArr) {
    }
}
