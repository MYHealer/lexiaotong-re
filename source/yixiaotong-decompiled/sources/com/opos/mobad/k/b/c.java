package com.opos.mobad.k.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.ad.d.h;
import com.opos.mobad.ad.d.k;
import com.opos.mobad.ad.d.t;
import com.opos.mobad.ad.i;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends i.a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdItemData f7080a;
    private MaterialData b;
    private List<com.opos.mobad.ad.d.e> c = null;
    private List<com.opos.mobad.ad.d.e> d = null;
    private final long e = SystemClock.elapsedRealtime();
    private com.opos.mobad.b f;
    private d g;
    private com.opos.mobad.ad.d.b h;
    private String i;
    private com.opos.mobad.cmn.func.adhandler.a j;

    private static class a implements com.opos.mobad.ad.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AppPrivacyData f7081a;

        public a(AppPrivacyData appPrivacyData) {
            this.f7081a = appPrivacyData;
        }

        @Override // com.opos.mobad.ad.d.b
        public String a() {
            AppPrivacyData appPrivacyData = this.f7081a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.d;
        }

        @Override // com.opos.mobad.ad.d.b
        public String b() {
            AppPrivacyData appPrivacyData = this.f7081a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.c;
        }

        @Override // com.opos.mobad.ad.d.b
        public String c() {
            AppPrivacyData appPrivacyData = this.f7081a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.e;
        }
    }

    public c(com.opos.mobad.cmn.func.adhandler.a aVar, AdItemData adItemData, com.opos.mobad.b bVar, String str, com.opos.mobad.ad.privacy.b bVar2, String str2) {
        this.j = aVar;
        this.f7080a = adItemData;
        this.f = bVar.c();
        this.b = adItemData.i().get(0);
        this.g = new d(bVar, aVar, adItemData, str, bVar2);
        if (this.f7080a.T() != null) {
            this.h = new a(this.f7080a.T());
        }
        this.i = str2;
    }

    private int q() {
        int iZ = this.b.Z();
        if (iZ == 1 || iZ == 2) {
            return 6;
        }
        if (iZ != 3 && iZ != 4 && iZ != 5) {
            if (iZ == 20 || iZ == 21) {
                return 7;
            }
            if (iZ == 30 || iZ == 31) {
                return 8;
            }
            if (iZ != 34) {
                if (iZ == 63) {
                    return 16;
                }
                if (iZ == 71) {
                    return 3;
                }
                if (iZ == 50) {
                    return 15;
                }
                if (iZ == 51) {
                    return 5;
                }
                if (iZ == 60) {
                    return 13;
                }
                if (iZ != 61) {
                    return (iZ == 80 || iZ == 81) ? 14 : 0;
                }
                return 11;
            }
        }
        return 2;
    }

    private boolean r() {
        return (com.opos.mobad.c.b.a().z() & 4) == 0;
    }

    private boolean s() {
        return (com.opos.mobad.c.b.a().z() & 8) == 0;
    }

    private boolean t() {
        return (com.opos.mobad.c.b.a().z() & 16) == 0;
    }

    @Override // com.opos.mobad.ad.d.h
    public String a() {
        return this.b.f();
    }

    @Override // com.opos.mobad.ad.d.h
    public void a(Context context, FrameLayout frameLayout, k kVar) {
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "bindMediaView nativeMediaView: " + frameLayout + ",listener: " + kVar);
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(frameLayout, kVar);
        }
    }

    @Override // com.opos.mobad.ad.d.h
    public void a(Context context, FrameLayout frameLayout, t tVar, List<View> list, List<View> list2) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(context, frameLayout, tVar, list, list2, r(), s(), t());
        }
    }

    @Override // com.opos.mobad.ad.d.h
    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
        d dVar = this.g;
        if (dVar == null) {
            return;
        }
        dVar.a(context, list, aVar, list2, aVar2);
    }

    @Override // com.opos.mobad.ad.d.h
    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2, List<View> list3, h.a aVar3) {
        d dVar = this.g;
        if (dVar == null) {
            return;
        }
        dVar.a(context, list, aVar, list2, aVar2, list3, aVar3);
    }

    @Override // com.opos.mobad.ad.d.h
    public void a(com.opos.mobad.ad.d.i iVar) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(iVar);
        }
    }

    @Override // com.opos.mobad.ad.d.h
    public boolean a(String str) {
        str.hashCode();
        switch (str) {
            case "nativePrivacyComponent":
                return !s();
            case "nativeAdButton":
                return !r();
            case "nativeCloseBtn":
                return !t();
            default:
                return true;
        }
    }

    @Override // com.opos.mobad.ad.d.h
    public String b() {
        return this.b.g();
    }

    @Override // com.opos.mobad.ad.d.h
    public List<com.opos.mobad.ad.d.e> c() {
        List<MaterialData> listI;
        List<MaterialFileData> listH;
        if (this.c == null && (listI = this.f7080a.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && (listH = materialData.h()) != null && listH.size() > 0) {
                    this.c = new ArrayList();
                    for (MaterialFileData materialFileData : listH) {
                        if (materialFileData != null) {
                            this.c.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("getIconFiles =");
        List<com.opos.mobad.ad.d.e> list = this.c;
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.append(list != null ? Integer.valueOf(list.size()) : "null").toString());
        return this.c;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public void c(int i) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(i);
        }
    }

    @Override // com.opos.mobad.ad.d.h
    public List<com.opos.mobad.ad.d.e> d() {
        List<MaterialData> listI;
        List<MaterialFileData> listE;
        if (this.d == null && (listI = this.f7080a.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && materialData.Z() != 60 && (listE = materialData.e()) != null && listE.size() > 0) {
                    this.d = new ArrayList();
                    for (MaterialFileData materialFileData : listE) {
                        if (materialFileData != null) {
                            this.d.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("getImgFiles =");
        List<com.opos.mobad.ad.d.e> list = this.d;
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.append(list != null ? Integer.valueOf(list.size()) : "null").toString());
        return this.d;
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int e() {
        return this.f7080a.ab();
    }

    @Override // com.opos.mobad.ad.i.a, com.opos.mobad.ad.i
    public int f() {
        return this.f7080a.ac();
    }

    @Override // com.opos.mobad.ad.d.h
    public int g() {
        return q();
    }

    @Override // com.opos.mobad.ad.d.h
    public int h() {
        return (int) this.b.s();
    }

    @Override // com.opos.mobad.ad.d.h
    public com.opos.mobad.ad.d.e i() {
        MaterialFileData materialFileDataL = this.f7080a.l();
        b bVar = materialFileDataL != null ? new b(materialFileDataL) : null;
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "getLogoFile=" + (bVar != null ? bVar : "null"));
        return bVar;
    }

    @Override // com.opos.mobad.ad.d.h
    public boolean j() {
        return SystemClock.elapsedRealtime() - this.e <= ((long) (this.f7080a.r() * 60000));
    }

    @Override // com.opos.mobad.ad.d.h
    public String k() {
        return this.f7080a.p();
    }

    @Override // com.opos.mobad.ad.d.h
    public String l() {
        String strA = com.opos.mobad.cmn.func.b.h.a(this.f.b(), this.f7080a, false);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "getClickBnText=" + strA);
        return strA;
    }

    @Override // com.opos.mobad.ad.d.h
    public void m() {
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "release");
        d dVar = this.g;
        if (dVar != null) {
            dVar.a();
            this.g = null;
        }
    }

    @Override // com.opos.mobad.ad.d.h
    public com.opos.mobad.ad.d.b n() {
        return this.h;
    }

    @Override // com.opos.mobad.ad.d.h
    public String o() {
        return this.i;
    }

    @Override // com.opos.mobad.ad.d.h
    public int p() {
        return this.f7080a.F();
    }
}
