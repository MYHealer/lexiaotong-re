package com.opos.mobad.cmn.func.adhandler;

import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f6797a;
    private String b;
    private AdItemData c;
    private MaterialData d;
    private int[] g;
    private boolean h;
    private long i = -1;
    private Map<String, String> e = new HashMap();
    private com.opos.mobad.service.f.b f = com.opos.mobad.service.f.c.a();

    public e(com.opos.mobad.b bVar, String str, AdItemData adItemData) {
        this.f6797a = bVar;
        this.b = str;
        this.c = adItemData;
        this.d = adItemData.i().get(0);
    }

    private e a(com.opos.mobad.service.f.b.EnumC0995b enumC0995b) {
        this.f.a(enumC0995b);
        return this;
    }

    private static void a(e eVar, b.c cVar) {
        com.opos.mobad.service.f.b.EnumC0995b enumC0995b;
        if (cVar.f6789a == 4 || cVar.f6789a == 10) {
            enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.APP_HOME;
        } else if (cVar.f6789a == 2 || cVar.f6789a == 12) {
            enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.BROWSER;
        } else if (cVar.f6789a == 3 || cVar.f6789a == 13) {
            enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.WEB_VIEW;
        } else if (cVar.f6789a == 5 || cVar.f6789a == 9 || cVar.f6789a == 20 || cVar.f6789a == 11) {
            enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.DEEP_LINK;
        } else if (cVar.f6789a == 7) {
            enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.DOWNLOADER;
        } else if (cVar.f6789a == 1 || cVar.f6789a == 18 || cVar.f6789a == 17) {
            enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.MARKET;
        } else if (cVar.f6789a == 6) {
            enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.INSTANT;
        } else {
            if (cVar.f6789a != 8) {
                if (cVar.f6789a == 19) {
                    enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.WECHAT_NATIVE_PAGE;
                }
                eVar.d(cVar.a());
            }
            enumC0995b = com.opos.mobad.service.f.b.EnumC0995b.MINI_PROGRAM;
        }
        eVar.a(enumC0995b);
        eVar.d(cVar.a());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:26:0x005d  */
    private static void a(e eVar, b.e eVar2) {
        if (eVar2 == null || eVar2.b == null) {
            com.opos.cmn.an.f.a.b("AdHandler_HandlerReporter", "fillClickReportResult:" + eVar2);
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandler_HandlerReporter", "fillSTReportResult :" + eVar2.b);
        switch (eVar2.b.f6789a) {
            case 1:
            case 17:
            case 18:
                eVar.b().g();
                break;
            case 2:
            case 3:
            case 6:
            case 8:
            case 11:
            case 19:
                eVar.g();
                break;
            case 4:
            case 10:
                eVar.j();
                break;
            case 5:
                if (!eVar2.a()) {
                    eVar.g();
                } else {
                    eVar.f();
                }
                break;
            case 7:
                if (!eVar2.b()) {
                    eVar.h();
                } else {
                    eVar.b().g();
                }
                break;
            case 9:
            case 20:
                if (eVar2.b.a() || eVar2.c.f6789a != 10) {
                    eVar.f();
                } else {
                    eVar.j();
                }
                break;
            case 12:
            case 13:
                eVar.b().i();
                break;
        }
        if (!eVar2.a()) {
            if (eVar2.b.f6789a == 6 && eVar2.b.b == -3) {
                eVar.d(eVar2.b.c);
                return;
            }
            if ((eVar2.b.f6789a != 9 && eVar2.c.f6789a != 20) || eVar2.c.f6789a != 10 || !eVar2.c.a()) {
                if (eVar2.b.b == -4) {
                    eVar.e();
                    return;
                } else {
                    eVar.d();
                    return;
                }
            }
        }
        eVar.c();
    }

    private e b() {
        String strR = this.d.r();
        if (TextUtils.isEmpty(strR)) {
            return this;
        }
        this.e.put("dlChannel", strR);
        return this;
    }

    private void b(b.e eVar) {
        MaterialData materialData = this.d;
        if (materialData != null && !TextUtils.isEmpty(materialData.ag())) {
            com.opos.mobad.cmn.func.b.a.a.a(this.e, "dpToken", this.d.ag());
            String str = eVar.f6790a.f instanceof com.opos.mobad.cmn.func.adhandler.a.a.a ? ((com.opos.mobad.cmn.func.adhandler.a.a.a) eVar.f6790a.f).c : "";
            if (!TextUtils.isEmpty(str)) {
                com.opos.mobad.cmn.func.b.a.a.a(this.e, "dpRequestId", str);
            }
        }
        a(this, eVar);
        a(this, eVar.c);
        this.f.a(this.f6797a.b());
        this.e.put("progress", String.valueOf(this.i));
        String str2 = this.e.get("evtType");
        com.opos.cmn.an.f.a.b("AdHandler_HandlerReporter", "report adClick " + eVar + ",evtType:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        str2.hashCode();
        byte b = -1;
        switch (str2.hashCode()) {
            case 49:
                if (str2.equals("1")) {
                    b = 0;
                }
                break;
            case 52:
                if (str2.equals("4")) {
                    b = 1;
                }
                break;
            case 53:
                if (str2.equals("5")) {
                    b = 2;
                }
                break;
            case 55:
                if (str2.equals("7")) {
                    b = 3;
                }
                break;
            case 57:
                if (str2.equals("9")) {
                    b = 4;
                }
                break;
        }
        switch (b) {
            case 0:
                com.opos.mobad.cmn.func.b.e.a(this.f6797a, this.b, this.c, this.d, this.h, this.g, this.e);
                break;
            case 1:
                com.opos.mobad.cmn.func.b.e.b(this.f6797a, this.b, this.c, this.d, this.h, this.g, this.e);
                break;
            case 2:
                com.opos.mobad.cmn.func.b.e.c(this.f6797a, this.b, this.c, this.d, this.h, this.g, this.e);
                break;
            case 3:
                com.opos.mobad.cmn.func.b.e.a(this.f6797a, this.c, this.d, this.h, this.g, this.e);
                break;
            case 4:
                com.opos.mobad.cmn.func.b.e.d(this.f6797a, this.b, this.c, this.d, this.h, this.g, this.e);
                break;
            default:
                com.opos.cmn.an.f.a.a("", "report but error :" + str2);
                break;
        }
    }

    private e c() {
        this.e.put("jumpRet", "1");
        return this;
    }

    private e d() {
        this.e.put("jumpRet", "0");
        return this;
    }

    private e d(int i) {
        d();
        this.e.put("rsCode", String.valueOf(i));
        return this;
    }

    private e d(boolean z) {
        this.f.a(z ? "1" : "0");
        return this;
    }

    private e e() {
        this.e.put("jumpRet", "2");
        return this;
    }

    private e f() {
        com.opos.mobad.cmn.func.b.e.b(this.e);
        return this;
    }

    private e g() {
        com.opos.mobad.cmn.func.b.e.d(this.e);
        return this;
    }

    private e h() {
        com.opos.mobad.cmn.func.b.e.a(this.e);
        return this;
    }

    private e i() {
        com.opos.mobad.cmn.func.b.e.c(this.e);
        return this;
    }

    private e j() {
        com.opos.mobad.cmn.func.b.e.a(this.e, this.d);
        return this;
    }

    public e a(float f) {
        com.opos.mobad.cmn.func.b.a.a.a(this.e, f);
        return this;
    }

    public e a(int i) {
        com.opos.mobad.cmn.func.b.a.a.a(this.e, "viewVisibility", String.valueOf(i));
        return this;
    }

    public e a(long j) {
        if (j <= 0) {
            return this;
        }
        com.opos.mobad.cmn.func.b.e.a(this.e, j, this.d.s());
        this.f.a(j);
        this.i = j;
        return this;
    }

    public e a(View view) {
        if (view == null) {
            return this;
        }
        com.opos.mobad.cmn.func.b.e.a(view, this.e);
        this.f.a(com.opos.cmn.an.h.f.a.b(this.f6797a.b(), view.getWidth()), com.opos.cmn.an.h.f.a.b(this.f6797a.b(), view.getHeight()));
        return this;
    }

    public e a(com.opos.mobad.cmn.func.b.a aVar, int[] iArr) {
        Map<String, String> map;
        String strValueOf;
        String str;
        if (aVar == com.opos.mobad.cmn.func.b.a.SHAKE || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_SHAKE) {
            this.f.a(com.opos.mobad.service.f.b.a.SHAKE);
            this.f.b(iArr);
            com.opos.mobad.cmn.func.b.e.a(this.e, String.valueOf(this.d.d()), iArr);
            iArr = null;
        } else {
            if (aVar == com.opos.mobad.cmn.func.b.a.CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_INTERSTITIAL_RETAIN || aVar == com.opos.mobad.cmn.func.b.a.OUT_COUPONS) {
                this.f.a(com.opos.mobad.service.f.b.a.BUTTON).a(iArr);
                if (aVar == com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE) {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = "8";
                } else if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_INTERSTITIAL_RETAIN) {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = "11";
                } else if (aVar == com.opos.mobad.cmn.func.b.a.OUT_COUPONS) {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = "12";
                } else {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = "1";
                }
            } else if (aVar == com.opos.mobad.cmn.func.b.a.NON_CLICK_BT) {
                this.f.a(com.opos.mobad.service.f.b.a.EXTRA).a(iArr);
                map = this.e;
                strValueOf = String.valueOf(this.d.G());
                str = "2";
            } else {
                str = "4";
                if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT) {
                    this.f.a(com.opos.mobad.service.f.b.a.FLOATLAYER_BUTTON).a(iArr);
                    map = this.e;
                    strValueOf = String.valueOf(this.d.S());
                } else if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT) {
                    this.f.a(com.opos.mobad.service.f.b.a.FLOATLAYER_EXTRA).a(iArr);
                    com.opos.mobad.cmn.func.b.e.a(this.e, "5", String.valueOf(this.d.T()));
                } else if (aVar == com.opos.mobad.cmn.func.b.a.VIDEO) {
                    this.f.a(com.opos.mobad.service.f.b.a.VIDEO).a(iArr);
                    map = this.e;
                    strValueOf = String.valueOf(this.d.H());
                    str = "3";
                } else if (aVar == com.opos.mobad.cmn.func.b.a.FORWARD) {
                    this.f.a(com.opos.mobad.service.f.b.a.FORWARD);
                    com.opos.mobad.cmn.func.b.e.a(this.e, "9", String.valueOf(this.d.d()), "4");
                } else if (aVar == com.opos.mobad.cmn.func.b.a.TILT) {
                    this.f.a(com.opos.mobad.service.f.b.a.TILT);
                    com.opos.mobad.cmn.func.b.e.a(this.e, "10", String.valueOf(this.d.d()), "5");
                }
            }
            com.opos.mobad.cmn.func.b.e.a(map, str, strValueOf);
        }
        this.g = iArr;
        return this;
    }

    public e a(List<String> list) {
        if (list != null && list.size() > 0) {
            this.f.a(list);
        }
        return this;
    }

    public e a(Map<String, String> map) {
        if (map.containsKey("template_interactive_mode")) {
            this.e.put("aInteractiveMode", map.get("template_interactive_mode"));
        }
        return this;
    }

    public e a(boolean z) {
        this.h = z;
        return this;
    }

    public com.opos.mobad.service.f.b a() {
        return this.f.a();
    }

    public void a(int i, String str) {
        com.opos.mobad.service.f.b bVarA;
        List<String> listL;
        if (i == 101) {
            com.opos.mobad.cmn.func.b.e.b(this.f6797a, this.c, this.d);
            if (this.d.L() == null || this.d.L().size() <= 0) {
                return;
            }
            bVarA = com.opos.mobad.service.f.c.a();
            listL = this.d.L();
        } else if (i != 200) {
            if (i != 105) {
                if (i != 106) {
                    return;
                }
                com.opos.mobad.cmn.func.b.e.a(this.f6797a, this.c, this.d, str);
                return;
            } else {
                com.opos.mobad.cmn.func.b.e.c(this.f6797a, this.c, this.d);
                if (this.d.M() == null || this.d.M().size() <= 0) {
                    return;
                }
                bVarA = com.opos.mobad.service.f.c.a();
                listL = this.d.M();
            }
        } else {
            if (this.d.N() == null || this.d.N().size() <= 0) {
                return;
            }
            bVarA = com.opos.mobad.service.f.c.a();
            listL = this.d.N();
        }
        bVarA.a(listL).a(this.f6797a.b());
    }

    public void a(b.e eVar) {
        if (eVar == null || eVar.b == null) {
            com.opos.cmn.an.f.a.b("", "report but null");
        } else if (b.a(eVar.b.f6789a)) {
            b(eVar);
        } else {
            if (eVar.b.f6789a != 16) {
                return;
            }
            com.opos.mobad.cmn.func.b.e.a(this.f6797a, this.b, (eVar.c.b == 2 || this.c.L() == null) ? null : this.c.L().f7182a, eVar.c.b);
        }
    }

    public e b(float f) {
        com.opos.mobad.cmn.func.b.a.a.b(this.e, f);
        return this;
    }

    public e b(int i) {
        this.e.put("clientTemplateId", String.valueOf(i));
        return this;
    }

    public e b(Map<String, String> map) {
        if (map.containsKey("nativeCoordinate")) {
            com.opos.mobad.cmn.func.b.a.a.a(this.e, "nativeCoordinate", map.get("nativeCoordinate"));
        }
        return this;
    }

    public e b(boolean z) {
        com.opos.mobad.cmn.func.b.e.b(this.e, z ? "1" : "2");
        return this;
    }

    public e c(int i) {
        this.e.put("endTmType", String.valueOf(i));
        return this;
    }

    public e c(boolean z) {
        Map<String, String> map;
        String str;
        if (z) {
            map = this.e;
            str = "2";
        } else {
            map = this.e;
            str = "1";
        }
        map.put("clickState", str);
        return this;
    }
}
