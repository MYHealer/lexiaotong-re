package com.hihonor.adsdk.base.g.j.d.j1;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.api.reward.RewardItem;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f extends a {
    public f(com.hihonor.adsdk.base.bean.b bVar, List<String> list, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(bVar, str, aVar);
        this.hnadsd.put("error_code", String.valueOf(0));
        this.hnadsd.put("type", String.valueOf(1));
        if (list == null) {
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.O, String.valueOf(0));
        } else {
            this.hnadsd.put("ad_id", com.hihonor.adsdk.base.j.g.hnadsa(list));
            this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.O, String.valueOf(list.size()));
        }
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.c;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public f(BaseAd baseAd, Object obj, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put("error_code", String.valueOf(0));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(baseAd.getSequence()));
        this.hnadsd.put("type", String.valueOf(2));
        this.hnadsd.put("msg", com.hihonor.adsdk.base.j.g.hnadsa(obj));
    }

    public f(com.hihonor.adsdk.base.g.j.d.c cVar, String str, String str2, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str2, aVar);
        this.hnadsd.put("error_code", String.valueOf(0));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsd, String.valueOf(cVar.hnadsw()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, cVar.c());
        this.hnadsd.put("type", str);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, cVar.hnadst());
        if (str.equals(String.valueOf(2))) {
            this.hnadsd.put("msg", com.hihonor.adsdk.base.j.g.hnadsa(new RewardItem(cVar.g(), cVar.h())));
        }
    }
}
