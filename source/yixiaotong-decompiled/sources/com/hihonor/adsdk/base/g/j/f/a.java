package com.hihonor.adsdk.base.g.j.f;

import android.content.Context;
import android.location.Address;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.c;
import com.hihonor.adsdk.base.j.e;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.base.j.n.g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements b {
    private static final String hnadsa = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ";
    private static final String hnadsb = "1";

    @Override // com.hihonor.adsdk.base.g.j.f.b
    public LinkedHashMap<String, String> hnadsa(Context context, String str, LinkedHashMap<String, String> linkedHashMap, boolean z) {
        hnadsa(linkedHashMap);
        hnadsa(str, linkedHashMap, z);
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsu, HnAds.get().getCfg().getAppId());
        linkedHashMap.put("country_code", "CN");
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsy, "10024300");
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsz, "1.0.24.300");
        linkedHashMap.put("package_name", com.hihonor.adsdk.base.g.j.a.hnadsa().hnadse);
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.b, com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsf);
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.e, e.hnadsb().hnadsi() + "");
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.f, e.hnadsb().hnadsh() + "");
        linkedHashMap.put("os_version", com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsd);
        linkedHashMap.put("network_type", e.hnadsb().hnadse() + "");
        linkedHashMap.put("language", j.hnadsd(context));
        linkedHashMap.put("install_type", com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsh);
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.p, hnadsa());
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.q, com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsa() + "");
        linkedHashMap.put("sdk_type", "1");
        return linkedHashMap;
    }

    private String hnadsa() {
        Address addressHnadsb = g.hnadsa().hnadsb();
        return addressHnadsb != null ? addressHnadsb.getLocality() : "";
    }

    private static void hnadsa(LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("oaid", com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb());
    }

    private void hnadsa(String str, LinkedHashMap<String, String> linkedHashMap, boolean z) {
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.v, str);
        SimpleDateFormat simpleDateFormatHnadsa = com.hihonor.adsdk.common.safe.b.hnadsa(hnadsa, Locale.CHINA);
        linkedHashMap.put("t", simpleDateFormatHnadsa == null ? "" : simpleDateFormatHnadsa.format(new Date()));
        if (z) {
            linkedHashMap.put("p", c.u0.hnadsa);
            linkedHashMap.put("s", c.u0.hnadsb);
            linkedHashMap.put("id", c.u0.hnadsc);
        }
    }
}
