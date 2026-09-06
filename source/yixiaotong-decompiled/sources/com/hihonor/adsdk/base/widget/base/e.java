package com.hihonor.adsdk.base.widget.base;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.f.i;
import com.hihonor.adsdk.base.g.j.d.t0;
import com.hihonor.adsdk.base.g.j.d.y;
import com.hihonor.adsdk.base.g.k.c.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {
    private static final String hnadsd = "BaseViewController";
    private BaseAd hnadsa;
    private Context hnadsb;
    private i hnadsc;

    public e() {
        this.hnadsc = i.hnadsa();
    }

    public void hnadsd() {
        hnadsa(0);
    }

    public void hnadsa(int i) {
        BaseAd baseAd = this.hnadsa;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "Ad is null.", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "AdView call controller click method, interactType is " + baseAd.getInteractType() + ",ad is " + this.hnadsa, new Object[0]);
        this.hnadsc.hnadsb(i).hnadsa(true).hnadsd();
    }

    public void hnadsb() {
        i iVar = this.hnadsc;
        if (iVar != null) {
            iVar.hnadsb(System.currentTimeMillis());
        }
    }

    public void hnadsc() {
        i iVar = this.hnadsc;
        if (iVar != null) {
            iVar.hnadsb();
        }
    }

    @Deprecated
    public e(Context context) {
        this();
        this.hnadsb = context;
    }

    public void hnadsa(BaseAd baseAd) {
        this.hnadsc.hnadsb(baseAd);
        this.hnadsa = baseAd;
    }

    public void hnadsa(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "AdView well to report exposure", new Object[0]);
        BaseAd baseAd = this.hnadsa;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "Ad is null.", new Object[0]);
            return;
        }
        try {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
            BaseAd baseAd2 = this.hnadsa;
            new t0(baseAd2, baseAd2.getAdUnitId(), aVarHnadsa).hnadse();
            new s(view.getMeasuredWidth(), view.getMeasuredHeight()).hnadsa(this.hnadsa, this.hnadsa.getTrackUrl().getImpressions());
        } catch (Exception e) {
            String str = "report ad exposure ex. error info:" + e.getMessage();
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "reportExposure, " + str, new Object[0]);
            hnadsa(com.hihonor.adsdk.base.g.j.e.b.hnadsg, ErrorCode.d.hnadsi, str);
        }
    }

    public void hnadsa(Point point, Point point2, int i, float f, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "AdView well to report click event", new Object[0]);
        BaseAd baseAd = this.hnadsa;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "Ad is null.", new Object[0]);
            return;
        }
        try {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
            BaseAd baseAd2 = this.hnadsa;
            new com.hihonor.adsdk.base.g.j.d.f(baseAd2, baseAd2.getAdUnitId(), aVarHnadsa, i, i2).hnadse();
            com.hihonor.adsdk.base.g.k.c.b bVar = new com.hihonor.adsdk.base.g.k.c.b(point.x, point.y, point2.x, point2.y, i, f, i2);
            BaseAd baseAd3 = this.hnadsa;
            bVar.hnadsa(baseAd3, baseAd3.getTrackUrl().getClicks());
        } catch (Exception e) {
            String str = "report ad click ex. error info:" + e.getMessage();
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "reportClick, " + str, new Object[0]);
            hnadsa(com.hihonor.adsdk.base.g.j.e.b.hnadsh, ErrorCode.d.hnadsj, str);
        }
    }

    public void hnadsa() {
        i iVar = this.hnadsc;
        if (iVar != null) {
            iVar.hnadsa(System.currentTimeMillis());
        }
    }

    private void hnadsa(String str, int i, String str2) {
        BaseAd baseAd = this.hnadsa;
        if (baseAd != null) {
            new y(this.hnadsa.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), str, i, str2).hnadse();
        }
    }
}
