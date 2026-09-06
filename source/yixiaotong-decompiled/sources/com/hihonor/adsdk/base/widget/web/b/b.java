package com.hihonor.adsdk.base.widget.web.b;

import android.os.SystemClock;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.f;
import com.hihonor.adsdk.base.g.j.d.i;
import com.hihonor.adsdk.base.g.j.d.j;
import com.hihonor.adsdk.base.g.j.d.k0;
import com.hihonor.adsdk.base.g.k.c.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends a {
    private static final String hnadsj = "WebViewReportManager";
    private static final long hnadsk = -999;
    private long hnadsf;
    private boolean hnadsg = false;
    private int hnadsh = 0;
    private final float hnadsi = 0.0f;

    @Override // com.hihonor.adsdk.base.widget.web.b.a, com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportClick ", new Object[0]);
        BaseAd baseAd = this.hnadsd;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportClick#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
        BaseAd baseAd2 = this.hnadsd;
        new f(baseAd2, baseAd2.getAdUnitId(), aVarHnadsa, 6, 2).hnadse();
        com.hihonor.adsdk.base.g.k.c.b bVar = new com.hihonor.adsdk.base.g.k.c.b(i, i2, i, i2, 6, 0.0f, 2);
        BaseAd baseAd3 = this.hnadsd;
        bVar.hnadsa(baseAd3, baseAd3.getTrackUrl().getClicks());
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a
    protected com.hihonor.adsdk.base.g.j.d.h1.b hnadsb(int i, String str) {
        long jElapsedRealtime;
        long j;
        long j2;
        com.hihonor.adsdk.base.g.j.d.h1.b bVar = new com.hihonor.adsdk.base.g.j.d.h1.b();
        BaseAd baseAd = this.hnadsd;
        if (baseAd != null) {
            bVar.hnadsc(String.valueOf(baseAd.getSequence()));
            bVar.hnadsd(String.valueOf(this.hnadsd.getLandingPageType()));
            bVar.hnadsf(String.valueOf(this.hnadsd.getNewLandingPageType()));
        }
        if (4 != i && 2 != i) {
            if (this.hnadsa != 0) {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                j = this.hnadsa;
            } else {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsj, (Object) "other");
                j2 = hnadsk;
            }
            bVar.hnadsa(String.valueOf(j2));
            bVar.hnadse(str);
            bVar.hnadsb(hnadsd());
            return bVar;
        }
        jElapsedRealtime = SystemClock.elapsedRealtime();
        j = this.hnadsf;
        j2 = jElapsedRealtime - j;
        bVar.hnadsa(String.valueOf(j2));
        bVar.hnadse(str);
        bVar.hnadsb(hnadsd());
        return bVar;
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a
    protected String hnadsc() {
        return hnadsj;
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a, com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsc(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportLoadWebFinished ", new Object[0]);
        if (this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportLoadWebFinished#baseAd is null", new Object[0]);
            return;
        }
        this.hnadsh++;
        com.hihonor.adsdk.base.g.j.d.h1.b bVarHnadsb = hnadsb(7, str);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd);
        bVarHnadsb.hnadsb(hnadsb());
        new k0(ErrorCode.AD_CODE_PAGE_FINISHED, bVarHnadsb, this.hnadsd.getAdUnitId(), aVarHnadsa).hnadsa(com.hihonor.adsdk.base.g.j.e.a.Q0, String.valueOf(this.hnadsh)).hnadse();
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a, com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsd(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportWakeActivity isReportSuccessHA=" + this.hnadsg, new Object[0]);
        if (this.hnadsg) {
            return;
        }
        if (this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportWakeActivity# mBaseAd is null", new Object[0]);
            return;
        }
        this.hnadsf = SystemClock.elapsedRealtime();
        com.hihonor.adsdk.base.g.j.d.h1.b bVarHnadsb = hnadsb(2, str);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd);
        bVarHnadsb.hnadsb(hnadsd());
        BaseAd baseAd = this.hnadsd;
        new j(baseAd, baseAd.getAdUnitId(), aVarHnadsa, bVarHnadsb).hnadsa(-2).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(this.hnadse)).hnadse();
        if (this.hnadsd.getTrackUrl() == null || this.hnadsd.getTrackUrl().getCommons() == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "loadSuccess# TrackUrl() is null", new Object[0]);
            return;
        }
        g gVar = new g(1, 0);
        BaseAd baseAd2 = this.hnadsd;
        gVar.hnadsa(baseAd2, baseAd2.getTrackUrl().getDpSuccess());
        this.hnadsg = true;
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a, com.hihonor.adsdk.base.widget.web.b.d
    public void hnadse(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportWakeFail ", new Object[0]);
        if (this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportWakeFail#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.b bVarHnadsb = hnadsb(5, str);
        new i(this.hnadsd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd), bVarHnadsb, ErrorCode.AD_WEB_DETAIL_URL_NULL, ErrorCode.STR_AD_WEB_DETAIL_URL_NULL).hnadsa(-2).hnadsa(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(this.hnadsd.getItemPosition())).hnadse();
        if (this.hnadsd.getTrackUrl() == null || this.hnadsd.getTrackUrl().getCommons() == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "loadFail# TrackUrl() is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.k.c.f fVar = new com.hihonor.adsdk.base.g.k.c.f(ErrorCode.AD_WEB_DETAIL_URL_NULL, "webView load fail", 1, 0);
        BaseAd baseAd = this.hnadsd;
        fVar.hnadsa(baseAd, baseAd.getTrackUrl().getCommons());
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a, com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportJumpThirdApp ", new Object[0]);
        BaseAd baseAd = this.hnadsd;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsj, "reportJumpThirdApp#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
        BaseAd baseAd2 = this.hnadsd;
        new j(baseAd2, baseAd2.getAdUnitId(), aVarHnadsa, this.hnadsd.getSequence(), 4).hnadsa(-2).hnadse();
    }

    private String hnadsd() {
        return String.valueOf(1);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.a
    protected String hnadsb() {
        return String.valueOf(0);
    }
}
