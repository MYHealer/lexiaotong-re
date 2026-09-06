package com.opos.mobad.cmn.func.adhandler;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.cmn.func.adhandler.a.g;
import com.opos.mobad.cmn.func.adhandler.a.h;
import com.opos.mobad.cmn.func.adhandler.a.i;
import com.opos.mobad.cmn.func.adhandler.a.j;
import com.opos.mobad.cmn.func.adhandler.a.k;
import com.opos.mobad.cmn.func.adhandler.a.l;
import com.opos.mobad.cmn.func.adhandler.a.m;
import com.opos.mobad.cmn.func.adhandler.a.n;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdItemData f6795a;
    public MaterialData b;
    public com.opos.mobad.cmn.service.pkginstall.c.b c;
    public b.d d;
    public com.opos.mobad.service.f.b e;
    public com.opos.mobad.cmn.func.adhandler.a.e f;
    public List<com.opos.mobad.cmn.func.adhandler.a.e> g;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.mobad.cmn.func.adhandler.a.e f6796a;
        public final List<com.opos.mobad.cmn.func.adhandler.a.e> b;

        public a(com.opos.mobad.cmn.func.adhandler.a.e eVar, List<com.opos.mobad.cmn.func.adhandler.a.e> list) {
            this.f6796a = eVar;
            this.b = list;
        }
    }

    private d(AdItemData adItemData, com.opos.mobad.cmn.func.adhandler.a.e eVar, List<com.opos.mobad.cmn.func.adhandler.a.e> list) {
        this.g = null;
        this.f6795a = adItemData;
        this.b = adItemData.i().get(0);
        this.f = eVar;
        this.g = list;
    }

    public static int a(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 12;
            case 10:
                return 13;
            default:
                return 0;
        }
    }

    public static int a(MaterialData materialData, com.opos.mobad.cmn.func.b.a aVar) {
        int iD;
        if (aVar == com.opos.mobad.cmn.func.b.a.SHAKE || aVar == com.opos.mobad.cmn.func.b.a.CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE || aVar == com.opos.mobad.cmn.func.b.a.FORWARD || aVar == com.opos.mobad.cmn.func.b.a.TILT || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_INTERSTITIAL_RETAIN || aVar == com.opos.mobad.cmn.func.b.a.OUT_COUPONS) {
            iD = materialData.d();
        } else if (aVar == com.opos.mobad.cmn.func.b.a.NON_CLICK_BT) {
            iD = materialData.G();
        } else if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_SHAKE) {
            iD = materialData.S();
        } else if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT) {
            iD = materialData.T();
        } else {
            iD = aVar == com.opos.mobad.cmn.func.b.a.VIDEO ? materialData.H() : 0;
        }
        return a(iD);
    }

    private static a a(Context context, AdItemData adItemData, MaterialData materialData, int i) {
        return a(context, adItemData, materialData, i, null, null, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (r5.F() == 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
    
        if (r5.F() == 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
    
        r1 = com.opos.mobad.cmn.func.adhandler.a.b.b(r5.q());
        r3 = com.opos.mobad.cmn.func.adhandler.a.d.b(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0088, code lost:
    
        r3 = com.opos.mobad.cmn.func.adhandler.a.d.b(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a a(Context context, AdItemData adItemData, MaterialData materialData, int i, b.a aVar, com.opos.mobad.t.a aVar2, com.opos.mobad.t.c cVar, String str, String str2) {
        com.opos.mobad.cmn.func.adhandler.a.e eVarA;
        List<com.opos.mobad.cmn.func.adhandler.a.e> listA;
        com.opos.mobad.cmn.func.adhandler.a.e eVarA2;
        com.opos.mobad.cmn.func.adhandler.a.e eVarA3 = null;
        switch (i) {
            case 1:
                eVarA3 = com.opos.mobad.cmn.func.adhandler.a.b.a(materialData.q());
                eVarA = n.a(adItemData, materialData, aVar2, cVar, str);
                if (!TextUtils.isEmpty(materialData.ag())) {
                    com.opos.mobad.cmn.func.adhandler.a.a.a aVarA = com.opos.mobad.cmn.func.adhandler.a.b.a(materialData);
                    List<com.opos.mobad.cmn.func.adhandler.a.e> listA2 = a(eVarA3);
                    listA2.add(eVarA);
                    listA = listA2;
                    eVarA3 = aVarA;
                } else {
                    listA = a(eVarA);
                }
                break;
            case 2:
                if (com.opos.cmn.an.h.d.a.d(context, materialData.i())) {
                    break;
                } else if (1 == materialData.I() || 3 == materialData.I()) {
                    eVarA2 = h.a(materialData);
                } else {
                    eVarA2 = 2 == materialData.I() ? com.opos.mobad.cmn.func.adhandler.a.c.a(materialData, aVar) : j.a(materialData, adItemData.af());
                }
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 3:
                if (!com.opos.cmn.an.h.d.a.d(context, materialData.i())) {
                    eVarA2 = n.b(adItemData, materialData, aVar2, cVar, str);
                }
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 4:
                eVarA2 = com.opos.mobad.cmn.func.adhandler.a.d.a(materialData);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 5:
                eVarA2 = com.opos.mobad.cmn.func.adhandler.a.b.c(materialData.k());
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 6:
                eVarA3 = com.opos.mobad.cmn.func.adhandler.a.f.a(adItemData, materialData);
                eVarA = n.a(adItemData, materialData, aVar2, cVar, str);
                listA = a(eVarA);
                break;
            case 7:
                eVarA3 = i.a(adItemData, materialData);
                eVarA = n.a(adItemData, materialData, aVar2, cVar, str);
                listA = a(eVarA);
                break;
            case 8:
                eVarA2 = m.a(adItemData);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 9:
                eVarA2 = g.a(adItemData, materialData, aVar2);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 10:
                eVarA2 = com.opos.mobad.cmn.func.adhandler.a.a.a(adItemData);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 11:
                eVarA2 = l.a(adItemData, materialData);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 12:
                eVarA2 = new k(materialData.i(), str2);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 13:
                eVarA2 = new com.opos.mobad.cmn.func.adhandler.a.b.c(materialData.J());
                eVarA3 = eVarA2;
                listA = null;
                break;
            default:
                listA = null;
                break;
        }
        com.opos.cmn.an.f.a.b("AdHandler_HandlerParams", "createActionData() actionData=", eVarA3);
        return new a(eVarA3, listA);
    }

    public static final d a(Context context, AdItemData adItemData, int i) {
        if (adItemData == null || adItemData.i() == null || adItemData.i().get(0) == null) {
            return null;
        }
        a aVarA = a(context, adItemData, adItemData.i().get(0), i);
        return new d(adItemData, aVarA.f6796a, aVarA.b);
    }

    public static final d a(Context context, AdItemData adItemData, int i, b.a aVar, com.opos.mobad.t.a aVar2, com.opos.mobad.t.c cVar, String str) {
        return a(context, adItemData, i, aVar, aVar2, cVar, str, "");
    }

    public static final d a(Context context, AdItemData adItemData, int i, b.a aVar, com.opos.mobad.t.a aVar2, com.opos.mobad.t.c cVar, String str, String str2) {
        if (adItemData == null || adItemData.i() == null || adItemData.i().get(0) == null) {
            return null;
        }
        a aVarA = a(context, adItemData, adItemData.i().get(0), i, aVar, aVar2, cVar, str, str2);
        return new d(adItemData, aVarA.f6796a, aVarA.b);
    }

    public static final d a(Context context, AdItemData adItemData, com.opos.mobad.cmn.func.b.a aVar, b.a aVar2, com.opos.mobad.t.a aVar3, com.opos.mobad.t.c cVar, String str, String str2) {
        if (adItemData == null || adItemData.i() == null || adItemData.i().get(0) == null) {
            return null;
        }
        return a(context, adItemData, a(adItemData.i().get(0), aVar), aVar2, aVar3, cVar, str, str2);
    }

    private static List<com.opos.mobad.cmn.func.adhandler.a.e> a(com.opos.mobad.cmn.func.adhandler.a.e eVar) {
        if (eVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        return arrayList;
    }

    public d a(b.d dVar) {
        this.d = dVar;
        return this;
    }

    public d a(com.opos.mobad.cmn.service.pkginstall.c.b bVar) {
        this.c = bVar;
        return this;
    }

    public d a(com.opos.mobad.service.f.b bVar) {
        this.e = bVar;
        return this;
    }

    public AdItemData a() {
        return this.f6795a;
    }

    public MaterialData b() {
        return this.b;
    }
}
