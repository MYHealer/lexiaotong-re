package com.opos.mobad.k;

import com.opos.mobad.ad.d.h;
import com.opos.mobad.ad.d.j;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.utils.AdHelper;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends com.opos.mobad.q.e {
    private int b;
    private com.opos.mobad.b c;
    private String d;
    private com.opos.mobad.cmn.func.adhandler.a e;
    private com.opos.mobad.ad.privacy.a f;

    public d(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, j jVar, com.opos.mobad.ad.privacy.a aVar2, com.opos.mobad.cmn.func.adhandler.f fVar) {
        super(jVar);
        this.c = bVar;
        com.opos.mobad.cmn.func.adhandler.a aVar3 = new com.opos.mobad.cmn.func.adhandler.a(this.c, str, aVar, fVar);
        this.e = aVar3;
        if (jVar instanceof com.opos.mobad.ad.f) {
            aVar3.a((com.opos.mobad.ad.f) jVar);
        }
        this.d = str;
        this.f = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(AdData adData) {
        ArrayList arrayList = new ArrayList();
        for (AdItemData adItemData : adData.f()) {
            if (adItemData != null) {
                arrayList.add(new com.opos.mobad.k.b.c(this.e.a(), adItemData, this.c, this.d, h(), adItemData.ae()));
            }
        }
        return arrayList;
    }

    private com.opos.mobad.ad.privacy.b h() {
        com.opos.mobad.ad.privacy.a aVar = this.f;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i, List<String> list) {
        this.b = 0;
        com.opos.mobad.model.b.a(StubApp.getOrigApplicationContext(this.c.b().getApplicationContext())).a(this.c, this.d, 4, str, i, new com.opos.mobad.model.b.a() { // from class: com.opos.mobad.k.d.1
            @Override // com.opos.mobad.model.b.a
            public void a(int i2, AdHelper.AdHelperData adHelperData) {
                if (adHelperData == null || adHelperData.f7215a.a() != 0) {
                    d.this.b = i2;
                    d.this.b(d.this.a(adHelperData.f7215a));
                } else {
                    d.this.c.j().a(d.this.d, 4, adHelperData.c.f(), adHelperData.c.b(), adHelperData.d.X(), adHelperData.c.a(), adHelperData.c.O());
                    d.this.b = adHelperData.f7215a.c();
                    d.this.c(-1, com.opos.mobad.ad.a.a(-1));
                }
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    d.this.b = adData.c();
                }
                d.this.c(i2, str2);
            }
        }, com.opos.mobad.model.b.c, list);
        return true;
    }

    @Override // com.opos.mobad.q.f
    protected boolean c(String str) {
        return false;
    }
}
