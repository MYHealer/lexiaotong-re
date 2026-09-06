package com.opos.mobad.p;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.utils.AdHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: com.opos.mobad.p.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.mobad.ad.f.e f7260a;
        public final AdHelper.AdHelperData b;
        public boolean c;
        private final com.opos.mobad.ad.f.d d;

        private a(com.opos.mobad.ad.f.d dVar, com.opos.mobad.ad.f.e eVar, AdHelper.AdHelperData adHelperData) {
            this.c = false;
            this.d = dVar;
            this.f7260a = eVar;
            this.b = adHelperData;
        }

        /* synthetic */ a(com.opos.mobad.ad.f.d dVar, com.opos.mobad.ad.f.e eVar, AdHelper.AdHelperData adHelperData, AnonymousClass1 anonymousClass1) {
            this(dVar, eVar, adHelperData);
        }

        public long a() {
            AdHelper.AdHelperData adHelperData = this.b;
            if (adHelperData == null) {
                return 0L;
            }
            return adHelperData.c.q();
        }

        public com.opos.mobad.ad.f.d b() {
            if (!c() || d()) {
                return null;
            }
            return this.d;
        }

        public boolean c() {
            AdHelper.AdHelperData adHelperData = this.b;
            if (adHelperData == null) {
                return true;
            }
            return adHelperData.d.a();
        }

        public boolean d() {
            AdHelper.AdHelperData adHelperData = this.b;
            if (adHelperData == null) {
                return false;
            }
            int iZ = adHelperData.d.Z();
            return iZ == 61 || iZ == 51;
        }

        public String toString() {
            return "SplashVo{bottomArea=" + this.d + ", customSkipView=" + this.f7260a + ", adHelperData=" + this.b + '}';
        }
    }

    public static a a(com.opos.mobad.ad.f.f fVar, AdHelper.AdHelperData adHelperData) {
        AnonymousClass1 anonymousClass1 = null;
        if (fVar == null || adHelperData == null) {
            return null;
        }
        return new a(fVar.e, fVar.g, adHelperData, anonymousClass1);
    }

    public static com.opos.mobad.template.d.f a(com.opos.mobad.b bVar, a aVar, com.opos.mobad.template.e eVar, com.opos.mobad.template.d dVar, int i) {
        if (aVar == null) {
            return null;
        }
        MaterialFileData materialFileDataB = b(aVar);
        String strA = materialFileDataB != null ? com.opos.cmn.d.d.a(bVar.b(), materialFileDataB.a()) : "";
        com.opos.mobad.template.d.f fVarA = com.opos.mobad.model.a.a(bVar.b(), bVar, aVar.b.c, aVar.b.d, false, false, i);
        fVarA.a(aVar.a(), aVar.a()).g(strA, materialFileDataB != null ? materialFileDataB.b() : "").a(eVar).a(dVar).d(d(aVar)).f(e(aVar));
        return fVarA;
    }

    public static boolean a(a aVar) {
        AdData adData;
        return (!c(aVar) || (adData = aVar.b.f7215a) == null || !adData.b() || aVar.f7260a == null || aVar.f7260a.a() == null) ? false : true;
    }

    public static MaterialFileData b(a aVar) {
        if (c(aVar)) {
            return aVar.b.e;
        }
        return null;
    }

    public static boolean c(a aVar) {
        return (aVar == null || aVar.b == null) ? false : true;
    }

    private static String d(a aVar) {
        return !TextUtils.isEmpty(aVar.b.d.V()) ? aVar.b.d.V() : "点击跳转详情页或第三方应用";
    }

    private static int e(a aVar) {
        int iJ = aVar.b.c.J();
        if (!aVar.c() || aVar.d()) {
            iJ = 0;
        }
        int i = 1;
        if (iJ != 1) {
            i = 2;
            if (iJ != 2) {
                return 0;
            }
        }
        return i;
    }
}
