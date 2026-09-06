package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.huawei.hms.ads.gh;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4670a;

    public ch(Context context) {
        this.f4670a = context;
    }

    public JSONObject a() {
        int i;
        try {
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.f4670a, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (hVarA.b(dd.G, 1) == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (hVarA.b(dd.K, 0) == 1 && Engine.loadSuccess) {
                    ap apVar = new ap(this.f4670a);
                    jSONObject.put("0", apVar.b("0"));
                    jSONObject.put("1", apVar.b("1"));
                    jSONObject.put("2", apVar.b("2"));
                    jSONObject.put("4", apVar.b("4"));
                    jSONObject.put("5", apVar.b("5"));
                    jSONObject.put("6", apVar.b("6"));
                    jSONObject.put("7", apVar.b("7"));
                    jSONObject.put("8", apVar.b("8"));
                    jSONObject.put("9", apVar.b("9"));
                    jSONObject.put("10", apVar.b("10"));
                    jSONObject.put("11", apVar.b("11"));
                    jSONObject.put("12", apVar.b("12"));
                    jSONObject.put(BaseWrapper.ENTER_ID_GAME_CENTER, apVar.b(BaseWrapper.ENTER_ID_GAME_CENTER));
                    jSONObject.put(BaseWrapper.ENTER_ID_AD_SDK, apVar.b(BaseWrapper.ENTER_ID_AD_SDK));
                    jSONObject.put("15", apVar.b("15"));
                    jSONObject.put("16", apVar.b("16"));
                    jSONObject.put(BaseWrapper.ENTER_ID_17, apVar.b(BaseWrapper.ENTER_ID_17));
                    jSONObject.put(BaseWrapper.ENTER_ID_18, apVar.b(BaseWrapper.ENTER_ID_18));
                    jSONObject.put(BaseWrapper.ENTER_ID_19, apVar.b(BaseWrapper.ENTER_ID_19));
                    jSONObject.put(BaseWrapper.ENTER_ID_SYSTEM_HELPER, apVar.b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                    jSONObject.put("21", apVar.b("21"));
                    jSONObject.put(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING, apVar.b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                    jSONObject.put(BaseWrapper.ENTER_ID_SHORTCUT, apVar.b(BaseWrapper.ENTER_ID_SHORTCUT));
                    jSONObject.put("24", apVar.b("24"));
                    jSONObject.put("25", apVar.b("25"));
                    jSONObject.put("26", apVar.b("26"));
                    jSONObject.put("27", apVar.b("27"));
                    jSONObject.put("28", apVar.b("28"));
                    jSONObject.put("29", apVar.b("29"));
                    jSONObject.put(BaseWrapper.ENTER_ID_TOOLKIT, apVar.b(BaseWrapper.ENTER_ID_TOOLKIT));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_DEMO, apVar.b(BaseWrapper.ENTER_ID_OAPS_DEMO));
                    jSONObject.put("32", apVar.b("32"));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_ROAMING, apVar.b(BaseWrapper.ENTER_ID_OAPS_ROAMING));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN, apVar.b(BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST, apVar.b(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET, apVar.b(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_GAMESPACE, apVar.b(BaseWrapper.ENTER_ID_OAPS_GAMESPACE));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SYS_CRASH, apVar.b(BaseWrapper.ENTER_ID_OAPS_SYS_CRASH));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SCANNER, apVar.b(BaseWrapper.ENTER_ID_OAPS_SCANNER));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER, apVar.b(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER));
                    jSONObject.put("41", apVar.b("41"));
                    jSONObject.put("42", apVar.b("42"));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_CLOUD, apVar.a(BaseWrapper.ENTER_ID_OAPS_CLOUD));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SECUREPAY, apVar.a(BaseWrapper.ENTER_ID_OAPS_SECUREPAY));
                    jSONObject.put("101", apVar.b("101"));
                    jSONObject.put("102", apVar.b("102"));
                    jSONObject.put("105", apVar.b("105"));
                    jSONObject.put("106", apVar.b("106"));
                }
                if (hVarA.b(dd.J, 1) == 1 && Engine.loadSuccess) {
                    at atVar = new at(this.f4670a);
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_RECENTS, atVar.d(BaseWrapper.ENTER_ID_OAPS_RECENTS));
                    if (atVar.a()) {
                        i = 1;
                        jSONObject.put("93", 1);
                    } else {
                        i = 1;
                    }
                    if (atVar.b()) {
                        jSONObject.put("94", i);
                    }
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP, atVar.d(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP));
                    jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.Code, atVar.a(com.huawei.openalliance.ad.beans.inner.a.Code));
                    jSONObject.put("51", atVar.b("51"));
                    jSONObject.put("52", atVar.a(this.f4670a, "52", 0));
                    jSONObject.put("55", atVar.c("55"));
                    jSONObject.put("66", atVar.a("66"));
                    jSONObject.put("67", dg.d());
                    jSONObject.put("78", atVar.a("78"));
                    jSONObject.put("79", atVar.a("79"));
                    ay ayVar = new ay(this.f4670a, 200);
                    jSONObject.put(gh.Code, ayVar.a(gh.Code));
                    jSONObject.put("71", ayVar.a("71"));
                    jSONObject.put("72", ayVar.a("72"));
                    jSONObject.put("73", ayVar.a("73"));
                    jSONObject.put("74", ayVar.a("74"));
                }
                if (hVarA.b(dd.M, 1) == 1) {
                    aw awVar = new aw(this.f4670a);
                    jSONObject.put("53", awVar.a(this.f4670a, "53", 1));
                    jSONObject.put("56", awVar.a("56"));
                    jSONObject.put("57", awVar.a("57"));
                    jSONObject.put("64", dg.a());
                }
                if (hVarA.b(dd.N, 1) == 1) {
                    cq cqVar = new cq();
                    jSONObject.put("98", cqVar.a());
                    jSONObject.put(BiddingConst.ADN_ID.VIVO, cqVar.b());
                    String strD = am.d();
                    if (!TextUtils.isEmpty(strD)) {
                        jSONObject.put("77", strD);
                    }
                    jSONObject.put("104", am.c());
                    jSONObject.put(BiddingConst.ADN_ID.MINTEGRAL, dj.e(this.f4670a));
                    aj ajVar = new aj(this.f4670a);
                    jSONObject.put("82", ajVar.h());
                    String strI = ajVar.i();
                    if (!TextUtils.isEmpty(strI)) {
                        jSONObject.put("83", strI);
                    }
                    String strJ = ajVar.j();
                    if (!TextUtils.isEmpty(strJ)) {
                        jSONObject.put("84", strJ);
                    }
                    String strK = ajVar.k();
                    if (!TextUtils.isEmpty(strK)) {
                        jSONObject.put("86", strK);
                    }
                }
                if (hVarA.b(dd.L, 1) == 1) {
                    au auVar = new au(this.f4670a);
                    jSONObject.put("95", auVar.b("95"));
                    jSONObject.put("96", auVar.a() ? 1 : 0);
                    jSONObject.put("97", dg.e());
                    try {
                        jSONObject.put("11301", bf.c(com.kwad.sdk.e.b.QY().QX()));
                        jSONObject.put("11302", bf.c(com.kwad.sdk.e.b.QY().getSdkVersion()));
                        jSONObject.put("11303", bf.c(com.kwad.sdk.e.b.QY().getAppId()));
                    } catch (Throwable unused) {
                    }
                }
                jSONObject.put("11006", zE ? 1 : 0);
                jSONObject.put("11029", zE2 ? 1 : 0);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11007", System.currentTimeMillis() - jCurrentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new ck(str, ci.j).a(this.f4670a);
            if (jSONObjectA2 == null || (jSONObjectA = a()) == null) {
                return null;
            }
            jSONObjectA2.put("module_section", jSONObjectA);
            return jSONObjectA2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
