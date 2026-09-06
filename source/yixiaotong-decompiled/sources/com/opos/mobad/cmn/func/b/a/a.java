package com.opos.mobad.cmn.func.b.a;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.opos.acs.st.STManager;
import com.opos.cmn.an.c.c;
import com.opos.cmn.i.h;
import com.opos.mobad.b;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.service.e.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static Map<String, String> a(b bVar) {
        HashMap map = new HashMap();
        map.put("appId", bVar.d());
        map.put("phBrand", com.opos.cmn.an.c.a.a(bVar.b()));
        map.put("phMaker", c.e());
        map.put("aid", com.opos.mobad.service.e.b.n().f());
        map.put("ua", g.h());
        String strG = bVar.h().g();
        if (TextUtils.isEmpty(strG)) {
            strG = "";
        }
        map.put("ouId", strG);
        String strH = bVar.h().h();
        map.put("duId", TextUtils.isEmpty(strH) ? "" : strH);
        map.put("ouidStatus", bVar.h().k() ? "1" : "0");
        map.put("appOuidStatus", bVar.h().e() ? "1" : "0");
        com.opos.mobad.service.d.a.C0991a c0991aL = bVar.h().l();
        if (c0991aL != null) {
            map.put("imei", c0991aL.f7355a);
            c0991aL.getClass();
            map.put("imeiType", String.valueOf(1));
        }
        return map;
    }

    public static void a(AdItemData adItemData, MaterialData materialData, Map<String, String> map) {
        if (map != null) {
            map.put("adSource", adItemData.b());
            map.put("adId", adItemData.f());
            map.put("cache", adItemData.N() ? "1" : "0");
            map.put("planId", adItemData.h());
            b(adItemData.c(), map);
            map.put("mtId", materialData.c());
            map.put("traceId", materialData.o());
            c(adItemData.a(), map);
            map.put("classifyByAge", adItemData.aa() != null ? adItemData.aa() : "");
            a(adItemData, map);
            map.put("tInteractiveMode", String.valueOf(materialData.af()));
        }
    }

    public static void a(AdItemData adItemData, Map<String, String> map) {
        if (map == null || adItemData == null) {
            return;
        }
        if (TextUtils.isEmpty(adItemData.H())) {
            map.put("isFallback", "2");
        } else {
            map.put("isFallback", "1");
            map.put("errorReqId", adItemData.H());
        }
    }

    public static void a(String str, Map<String, String> map) {
        h.a(map, STManager.KEY_AD_POS_ID, str);
        h.a(map, "newPosId", str);
    }

    public static void a(Map<String, String> map) {
        map.put("uSdkVC", g.g() + "");
        map.put("bizSdkVer", g.g() + "");
        map.put("InstVer", d.a().d());
        map.put("InstSdkVer", d.a().b());
    }

    public static void a(Map<String, String> map, float f) {
        a(map, "transparency", String.valueOf(f));
    }

    public static void a(Map<String, String> map, String str) {
        h.a(map, "dataType", str);
        h.a(map, "oriDatatype", str);
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map != null) {
            String strA = h.a(map, "cTransport");
            h.a(map, "cTransport", (!TextUtils.isEmpty(strA) ? strA + ";" : "") + str + x.A + str2);
        }
    }

    public static void b(String str, Map<String, String> map) {
        h.a(map, "respId", str);
    }

    public static void b(Map<String, String> map) {
        h.a(map, "turnX", "-1");
        h.a(map, "turnY", "-1");
        h.a(map, "turnZ", "-1");
        h.a(map, "turnTime", "-1");
    }

    public static void b(Map<String, String> map, float f) {
        a(map, "coverRatio", String.valueOf(f));
    }

    public static void c(String str, Map<String, String> map) {
        h.a(map, "sdkReqId", str);
        h.a(map, "reqId", str);
    }
}
