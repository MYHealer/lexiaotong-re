package com.opos.mobad.k;

import com.opos.mobad.ad.d.o;
import com.opos.mobad.ad.d.p;
import com.opos.mobad.ad.d.q;
import com.opos.mobad.ad.d.s;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.q.g;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends g {
    private int b;
    private s c;
    private com.opos.mobad.b d;
    private String e;
    private com.opos.mobad.cmn.func.adhandler.a f;
    private com.opos.mobad.cmn.a.b g;
    private List<String> h;
    private o i;

    public e(com.opos.mobad.b bVar, String str, s sVar, com.opos.mobad.cmn.func.a aVar, o oVar, com.opos.mobad.cmn.a.b bVar2, com.opos.mobad.cmn.func.adhandler.f fVar) {
        super(oVar);
        this.b = 0;
        this.i = new o() { // from class: com.opos.mobad.k.e.2
            @Override // com.opos.mobad.ad.d.a
            public void a(int i, String str2) {
            }

            @Override // com.opos.mobad.ad.d.o
            public void a(q qVar, p pVar) {
                e.this.a(qVar, pVar);
            }

            @Override // com.opos.mobad.ad.d.a
            public void a(List<p> list) {
            }

            @Override // com.opos.mobad.ad.d.o
            public void b(p pVar) {
                e.this.a(pVar);
            }

            @Override // com.opos.mobad.ad.d.o
            public void c(p pVar) {
                e.this.b(pVar);
            }

            @Override // com.opos.mobad.ad.d.o
            public void d(p pVar) {
                e.this.c(pVar);
            }

            @Override // com.opos.mobad.ad.d.o
            public void e(p pVar) {
                e.this.d(pVar);
            }
        };
        this.d = bVar;
        this.c = sVar;
        this.e = str;
        com.opos.mobad.cmn.func.adhandler.a aVar2 = new com.opos.mobad.cmn.func.adhandler.a(bVar, str, aVar, fVar);
        this.f = aVar2;
        if (oVar instanceof com.opos.mobad.ad.f) {
            aVar2.a((com.opos.mobad.ad.f) oVar);
        }
        this.g = bVar2;
    }

    private p a(AdItemData adItemData, MaterialData materialData) {
        try {
            com.opos.mobad.template.l.a aVarA = com.opos.mobad.j.b.c.a(adItemData.V());
            com.opos.mobad.template.a aVarA2 = com.opos.mobad.ui.c.b.a().a(this.d.b(), materialData.b(), materialData.Z(), aVarA, (com.opos.mobad.template.a.InterfaceC1003a) null);
            if (aVarA2 == null) {
                return null;
            }
            return new com.opos.mobad.k.b.e(this.d, adItemData, materialData, this.e, this.f.a(), aVarA2, this.i, this.g, adItemData.ae(), aVarA);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterNativeTemplateAd", "", (Throwable) e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<p> a(AdHelper.AdHelperData adHelperData) {
        p pVarA;
        ArrayList arrayList = null;
        if (adHelperData != null) {
            try {
                List<AdItemData> listF = adHelperData.f7215a.f();
                if (listF != null && listF.size() > 0) {
                    for (AdItemData adItemData : listF) {
                        if (adItemData != null && adItemData.i() != null && (pVarA = a(adItemData, adItemData.i().get(0))) != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(pVarA);
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterNativeTemplateAd", "", (Throwable) e);
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i, List<String> list) {
        this.b = 0;
        this.h = list;
        com.opos.mobad.model.b.a(StubApp.getOrigApplicationContext(this.d.b().getApplicationContext())).a(this.d, this.e, 4, str, i, new com.opos.mobad.model.b.a() { // from class: com.opos.mobad.k.e.1
            @Override // com.opos.mobad.model.b.a
            public void a(int i2, final AdHelper.AdHelperData adHelperData) {
                if (adHelperData == null || adHelperData.f7215a.a() != 0) {
                    e.this.b = i2;
                    com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.k.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.opos.mobad.b bVar;
                            String strB;
                            String str2;
                            String str3;
                            String strC;
                            String strA;
                            int iB;
                            List listA = e.this.a(adHelperData);
                            if (listA != null) {
                                e.this.b(listA);
                                return;
                            }
                            if (adHelperData == null) {
                                bVar = e.this.d;
                                strB = "";
                                str2 = e.this.e;
                                str3 = "4";
                                strC = "";
                                strA = "";
                                iB = 0;
                            } else {
                                bVar = e.this.d;
                                strB = adHelperData.c.b();
                                str2 = e.this.e;
                                str3 = "4";
                                strC = adHelperData.c.c();
                                strA = adHelperData.c.a();
                                iB = adHelperData.d.b();
                            }
                            com.opos.mobad.cmn.func.b.e.a(bVar, strB, str2, str3, strC, strA, iB, 10301);
                            e.this.c(10301, "render ad failed,ad item data is null.");
                        }
                    });
                } else {
                    e.this.d.j().a(e.this.e, 4, adHelperData.c.f(), adHelperData.c.b(), adHelperData.d.X(), adHelperData.c.a(), adHelperData.c.O());
                    e.this.b = adHelperData.f7215a.c();
                    e.this.c(-1, com.opos.mobad.ad.a.a(-1));
                }
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    e.this.b = adData.c();
                }
                e.this.c(i2, str2);
            }
        }, com.opos.mobad.model.b.d, list);
        return true;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        super.c(i);
    }

    @Override // com.opos.mobad.q.f
    protected boolean c(String str) {
        return false;
    }
}
