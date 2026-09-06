package com.opos.mobad.k.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.ad.d.l;
import com.opos.mobad.ad.d.q;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.mobad.ad.d.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f7077a;
    private com.opos.mobad.k.c b;
    private AdItemData c;
    private MaterialData d;
    private List<com.opos.mobad.ad.d.e> e = null;
    private List<com.opos.mobad.ad.d.e> f = null;
    private long g = SystemClock.elapsedRealtime();
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private l k;

    /* JADX INFO: renamed from: com.opos.mobad.k.b.a$a, reason: collision with other inner class name */
    private static class C0970a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AppPrivacyData f7078a;

        public C0970a(AppPrivacyData appPrivacyData) {
            this.f7078a = appPrivacyData;
        }

        @Override // com.opos.mobad.ad.d.b
        public String a() {
            AppPrivacyData appPrivacyData = this.f7078a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.d;
        }

        @Override // com.opos.mobad.ad.d.b
        public String b() {
            AppPrivacyData appPrivacyData = this.f7078a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.c;
        }

        @Override // com.opos.mobad.ad.d.b
        public String c() {
            AppPrivacyData appPrivacyData = this.f7078a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.e;
        }

        @Override // com.opos.mobad.ad.d.l
        public String d() {
            AppPrivacyData appPrivacyData = this.f7078a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.b;
        }

        @Override // com.opos.mobad.ad.d.l
        public String e() {
            AppPrivacyData appPrivacyData = this.f7078a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f7189a;
        }

        @Override // com.opos.mobad.ad.d.l
        public String f() {
            AppPrivacyData appPrivacyData = this.f7078a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f;
        }
    }

    public a(Context context, com.opos.mobad.k.c cVar, AdItemData adItemData) {
        this.f7077a = context;
        this.b = cVar;
        this.c = adItemData;
        this.d = adItemData.i().get(0);
        if (this.c.T() != null) {
            this.k = new C0970a(this.c.T());
        }
    }

    private String a(int i) {
        switch (i) {
            case 10200:
                return "ad repeat exposure.";
            case 10201:
                return "ad exposure expired.";
            case 10202:
                return "ad hasn't exposed.";
            case 10203:
                return "ad repeat click.";
            case 10204:
                return "ad click expired.";
            default:
                return "";
        }
    }

    private int m() {
        int i;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "mReqAdTime=" + this.g + ",mHasAdShow=" + this.h + ",nowTime=" + jElapsedRealtime + ",getShowInterval=" + this.c.r());
        if (this.h) {
            i = 10200;
        } else {
            i = jElapsedRealtime - this.g > ((long) (this.c.r() * 60000)) ? 10201 : 0;
        }
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getAdShowStatus =" + i);
        return i;
    }

    private int n() {
        int i;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "mReqAdTime=" + this.g + ",mHasAdShow=" + this.h + ",mHasAdClick=" + this.i + ",nowTime=" + jElapsedRealtime + ",getClickInterval=" + this.c.s());
        if (!this.h) {
            i = 10202;
        } else if (this.i) {
            i = 10203;
        } else {
            i = jElapsedRealtime - this.g > ((long) (this.c.s() * 60000)) ? 10204 : 0;
        }
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getAdClickStatus =" + i);
        return i;
    }

    @Override // com.opos.mobad.ad.d.d
    public String a() {
        return this.d.f();
    }

    @Override // com.opos.mobad.ad.d.d
    public synchronized void a(View view) {
        if (!this.b.d()) {
            int iM = m();
            if (iM == 0) {
                this.b.b(this.c);
                this.b.a(view, this.c, true, (Map<String, String>) null);
                this.h = true;
            } else {
                this.b.a(view, this.c, false, (Map<String, String>) null);
                this.b.b().a(new q(iM, a(iM)), this);
            }
            this.b.a(this.c);
        }
    }

    @Override // com.opos.mobad.ad.d.d
    public boolean a(String str) {
        MaterialData materialData;
        boolean z = false;
        if (!this.b.d()) {
            try {
                if (!com.opos.cmn.an.d.a.a(str) && this.c != null && (materialData = this.d) != null) {
                    boolean zEquals = str.equals(materialData.i());
                    try {
                        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "isCurrentApp downloadPkgName=" + this.d.i());
                        z = zEquals;
                    } catch (Exception e) {
                        e = e;
                        z = zEquals;
                        com.opos.cmn.an.f.a.a("NativeAdDataImpl", "", (Throwable) e);
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        StringBuilder sb = new StringBuilder("isCurrentApp pkgName=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.append(str).append(",result=").append(z).toString());
        return z;
    }

    @Override // com.opos.mobad.ad.d.d
    public String b() {
        return this.d.g();
    }

    @Override // com.opos.mobad.ad.d.d
    public synchronized void b(View view) {
        if (!this.b.d()) {
            int iN = n();
            if (iN == 0) {
                this.i = true;
                this.b.a(this.c, true, null, com.opos.mobad.cmn.func.b.a.CLICK_BT, view, this.j);
            } else {
                this.b.a(this.c, false, null, com.opos.mobad.cmn.func.b.a.CLICK_BT, view, this.j);
                this.b.b().a(new q(iN, a(iN)), this);
            }
            if (!this.j) {
                this.j = true;
            }
        }
    }

    @Override // com.opos.mobad.ad.d.d
    public List<com.opos.mobad.ad.d.e> c() {
        List<MaterialData> listI;
        List<MaterialFileData> listH;
        if (this.e == null && (listI = this.c.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && (listH = materialData.h()) != null && listH.size() > 0) {
                    this.e = new ArrayList();
                    for (MaterialFileData materialFileData : listH) {
                        if (materialFileData != null) {
                            this.e.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("getIconFiles =");
        List<com.opos.mobad.ad.d.e> list = this.e;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.append(list != null ? Integer.valueOf(list.size()) : "null").toString());
        return this.e;
    }

    @Override // com.opos.mobad.ad.d.d
    public List<com.opos.mobad.ad.d.e> d() {
        List<MaterialData> listI;
        List<MaterialFileData> listE;
        if (this.f == null && (listI = this.c.i()) != null && listI.size() > 0) {
            for (MaterialData materialData : listI) {
                if (materialData != null && (listE = materialData.e()) != null && listE.size() > 0) {
                    this.f = new ArrayList();
                    for (MaterialFileData materialFileData : listE) {
                        if (materialFileData != null) {
                            this.f.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("getImgFiles =");
        List<com.opos.mobad.ad.d.e> list = this.f;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.append(list != null ? Integer.valueOf(list.size()) : "null").toString());
        return this.f;
    }

    @Override // com.opos.mobad.ad.d.d
    public int e() {
        int iZ = this.d.Z();
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
                if (iZ == 51) {
                    return 5;
                }
                if (iZ == 61) {
                    return 11;
                }
                if (iZ != 63) {
                    return iZ != 71 ? 0 : 3;
                }
                return 4;
            }
        }
        return 2;
    }

    @Override // com.opos.mobad.ad.d.d
    public int f() {
        return this.d.d();
    }

    @Override // com.opos.mobad.ad.d.d
    public com.opos.mobad.ad.d.e g() {
        MaterialFileData materialFileDataL = this.c.l();
        b bVar = materialFileDataL != null ? new b(materialFileDataL) : null;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getLogoFile=" + (bVar != null ? bVar : "null"));
        return bVar;
    }

    @Override // com.opos.mobad.ad.d.d
    public boolean h() {
        boolean z = m() == 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "isAdValid=" + z);
        return z;
    }

    @Override // com.opos.mobad.ad.d.d
    public String i() {
        return this.c.p();
    }

    @Override // com.opos.mobad.ad.d.d
    public String j() {
        String strA = h.a(this.f7077a, this.c, false);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getClickBnText=" + strA);
        return strA;
    }

    @Override // com.opos.mobad.ad.d.d
    public boolean k() {
        MaterialData materialData;
        boolean zA = false;
        if (!this.b.d()) {
            try {
                AdItemData adItemData = this.c;
                if (adItemData != null && (materialData = this.d) != null) {
                    zA = this.b.a(adItemData, materialData);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("NativeAdDataImpl", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "launchApp=" + zA);
        return zA;
    }

    @Override // com.opos.mobad.ad.d.d
    public l l() {
        return this.k;
    }
}
