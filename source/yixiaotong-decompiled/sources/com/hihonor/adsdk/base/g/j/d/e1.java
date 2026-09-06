package com.hihonor.adsdk.base.g.j.d;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class e1 implements Serializable {
    protected LinkedHashMap<String, String> hnadsd = new LinkedHashMap<>();

    public e1(String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        if (Objects.nonNull(aVar)) {
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadse, str);
            this.hnadsd.put("ad_type", String.valueOf(aVar.hnadsb()));
            this.hnadsd.put("request_id", aVar.hnadsk());
            this.hnadsd.put("ad_id", aVar.hnadsa());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsj, aVar.hnadsh());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.F0, String.valueOf(aVar.hnadsi()));
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.E0, String.valueOf(aVar.hnadsj()));
            this.hnadsd.put("dataType", String.valueOf(aVar.hnadsg()));
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.Q, aVar.hnadsn());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsq, aVar.hnadso());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.K, aVar.hnadse());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.P0, String.valueOf(System.currentTimeMillis()));
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, aVar.hnadsc());
            this.hnadsd.put("app_version", aVar.hnadsd());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsp, aVar.hnadsf());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(com.hihonor.adsdk.base.init.i.hnadsa()));
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.Z0, aVar.hnadsp());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.c1, aVar.hnadsl());
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.W0, aVar.hnadsm());
        }
        hnadsa(aVar);
    }

    public e1 hnadsa(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.hnadsd.put(str, str2);
        }
        return this;
    }

    public abstract String hnadsa();

    public void hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
    }

    public abstract int hnadsb();

    public abstract int hnadsc();

    public boolean hnadsd() {
        return true;
    }

    public void hnadse() {
        com.hihonor.adsdk.base.g.j.b.hnadsa().hnadsa(hnadsc(), hnadsb(), hnadsa(), this.hnadsd, hnadsd());
    }

    public void hnadsa(LinkedHashMap<String, String> linkedHashMap) {
        com.hihonor.adsdk.base.g.j.b.hnadsa().hnadsa(hnadsc(), hnadsb(), hnadsa(), linkedHashMap, hnadsd());
    }
}
