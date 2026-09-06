package com.hihonor.adsdk.base.g.j.d.k1;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.VideoReportBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends h {
    public c(BaseAd baseAd, VideoReportBean videoReportBean, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(baseAd.getSequence()));
        this.hnadsd.put("msg", com.hihonor.adsdk.base.j.g.hnadsa(videoReportBean));
        this.hnadsd.put("type", String.valueOf(2));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.D, String.valueOf(videoReportBean.getPlayerSource()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.t0, String.valueOf(videoReportBean.getPlayAction()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.u0, String.valueOf(videoReportBean.getCurrentSecond()));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.v0, String.valueOf(videoReportBean.getCurrentPercent()));
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.t;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 1;
    }

    public c(com.hihonor.adsdk.base.g.j.d.c cVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, cVar.c());
        this.hnadsd.put("msg", cVar.hnadst());
        this.hnadsd.put("type", String.valueOf(2));
        this.hnadsd.put(com.hihonor.adsdk.base.g.j.e.a.D, cVar.b());
    }
}
