package com.hihonor.adsdk.base.player;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.g.e;
import com.hihonor.adsdk.base.g.j.d.k1.c;
import com.hihonor.adsdk.base.g.j.d.k1.d;
import com.hihonor.adsdk.base.g.j.d.k1.f;
import com.hihonor.adsdk.base.g.j.d.k1.g;
import com.hihonor.adsdk.base.g.j.d.t0;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.k.c.f0;
import com.hihonor.adsdk.base.g.k.c.g0;
import com.hihonor.adsdk.base.g.k.c.h0;
import com.hihonor.adsdk.base.g.k.c.i0;
import com.hihonor.adsdk.base.g.k.c.r;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsl = "VideoReportController";
    private VideoReportBean hnadsa;
    private BaseAd hnadsb;
    private final int hnadsc = 0;
    private final int hnadsd = 1;
    private final int hnadse = 2;
    private final int hnadsf = 3;
    private final int hnadsg = 4;
    private final int hnadsh = 5;
    private final int hnadsi = 6;
    private final int hnadsj = 7;
    private String hnadsk;

    private void hnadsk() {
        if (Objects.isNull(this.hnadsb) || Objects.isNull(this.hnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportRewardShow mBaseAd is null or mVideoReportBean is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportRewardShow.and isExposure: " + hnadsb() + ",isParameterNormal: " + hnadsc() + ", ad type: " + this.hnadsb.getAdType() + ", Video isCompleted(): " + this.hnadsa.isCompleted() + ", Video Scene: " + this.hnadsa.getScene(), new Object[0]);
        if (hnadsc() && this.hnadsb.getAdType() == 4 && !this.hnadsa.isCompleted() && !hnadsb() && this.hnadsa.getScene().equals(String.valueOf(1))) {
            e.hnadsa(this.hnadsk);
            r rVar = new r(this.hnadsa.getMeasuredWidth(), this.hnadsa.getMeasuredHeight());
            BaseAd baseAd = this.hnadsb;
            rVar.hnadsa(baseAd, baseAd.getTrackUrl().getImpressions());
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsb);
            BaseAd baseAd2 = this.hnadsb;
            new t0(baseAd2, baseAd2.getAdUnitId(), aVarHnadsa).hnadse();
        }
    }

    public void hnadsa(int i, String str, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "#onVideoError#video error report.errorCode = %s, message = %s", Integer.valueOf(i), str);
        VideoReportBean videoReportBean = this.hnadsa;
        if (videoReportBean != null) {
            videoReportBean.setCode(String.valueOf(i));
            this.hnadsa.setMsg(str);
            this.hnadsa.setErrorType(i2);
        }
        hnadsa(5);
    }

    protected boolean hnadsb() {
        boolean zHnadsb = e.hnadsb(this.hnadsk);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "Call isExposure. result: " + zHnadsb, new Object[0]);
        return zHnadsb;
    }

    public void hnadsd() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "#onVideoAdEnd#video end report", new Object[0]);
        hnadsa(4);
    }

    public void hnadse() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "#onVideoAdPause#video pause report", new Object[0]);
        hnadsa(1);
    }

    public void hnadsf() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "#onVideoAdStart#video start report", new Object[0]);
        hnadsk();
        hnadsa(0);
    }

    public void hnadsg() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "#onVideoBuffering#video buffering report", new Object[0]);
        hnadsa(2);
    }

    public void hnadsh() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "#onVideoFirstStart#video first start report", new Object[0]);
        hnadsa(6);
    }

    public void hnadsi() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "#onVideoResume#video resume report", new Object[0]);
        hnadsa(3);
    }

    public void hnadsj() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "#onVideoTrigger#video trigger report", new Object[0]);
        hnadsa(7);
    }

    private boolean hnadsc() {
        boolean z = (this.hnadsa == null || this.hnadsb == null) ? false : true;
        if (!z) {
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.EX_VIDEO_ABNORMAL, ErrorCode.STR_EX_VIDEO_ABNORMAL).hnadse();
        }
        return z;
    }

    public void hnadsb(int i) {
        VideoReportBean videoReportBean = this.hnadsa;
        if (videoReportBean != null) {
            videoReportBean.setPlayerSource(i);
        }
    }

    public void hnadsa(VideoReportBean videoReportBean, BaseAd baseAd) {
        this.hnadsa = videoReportBean;
        this.hnadsb = baseAd;
        hnadsa();
    }

    private void hnadsa() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "call init exposure id", new Object[0]);
        if (this.hnadsb != null) {
            this.hnadsk = this.hnadsb.getRequestId() + this.hnadsb.getAdId();
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "init exposure id： " + this.hnadsk, new Object[0]);
        }
    }

    private void hnadsa(int i) {
        if (hnadsc()) {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsb);
            if (i == 0) {
                BaseAd baseAd = this.hnadsb;
                new com.hihonor.adsdk.base.g.j.d.k1.e(baseAd, this.hnadsa, baseAd.getAdUnitId(), aVarHnadsa).hnadse();
                if (1 == this.hnadsa.getPlayAction()) {
                    i0 i0Var = new i0();
                    BaseAd baseAd2 = this.hnadsb;
                    i0Var.hnadsa(baseAd2, baseAd2.getTrackUrl().getFeedPlay());
                    return;
                } else {
                    f0 f0Var = new f0();
                    BaseAd baseAd3 = this.hnadsb;
                    f0Var.hnadsa(baseAd3, baseAd3.getTrackUrl().getFeedAutoPlay());
                    return;
                }
            }
            if (i == 1) {
                BaseAd baseAd4 = this.hnadsb;
                new c(baseAd4, this.hnadsa, baseAd4.getAdUnitId(), aVarHnadsa).hnadse();
                g0 g0Var = new g0(this.hnadsa.getCurrentSecond(), this.hnadsa.getCurrentPercent());
                BaseAd baseAd5 = this.hnadsb;
                g0Var.hnadsa(baseAd5, baseAd5.getTrackUrl().getFeedBreak());
                return;
            }
            if (i == 3) {
                BaseAd baseAd6 = this.hnadsb;
                new d(baseAd6, this.hnadsa, baseAd6.getAdUnitId(), aVarHnadsa).hnadse();
                return;
            }
            if (i == 4) {
                BaseAd baseAd7 = this.hnadsb;
                new com.hihonor.adsdk.base.g.j.d.k1.a(baseAd7, this.hnadsa, baseAd7.getAdUnitId(), aVarHnadsa).hnadse();
                h0 h0Var = new h0();
                BaseAd baseAd8 = this.hnadsb;
                h0Var.hnadsa(baseAd8, baseAd8.getTrackUrl().getFeedOver());
                return;
            }
            if (i == 5) {
                BaseAd baseAd9 = this.hnadsb;
                new com.hihonor.adsdk.base.g.j.d.k1.b(baseAd9, this.hnadsa, baseAd9.getAdUnitId(), aVarHnadsa).hnadse();
            } else if (i == 6) {
                BaseAd baseAd10 = this.hnadsb;
                new f(baseAd10, this.hnadsa, baseAd10.getAdUnitId(), aVarHnadsa).hnadse();
            } else {
                if (i != 7) {
                    return;
                }
                BaseAd baseAd11 = this.hnadsb;
                new g(baseAd11, this.hnadsa, baseAd11.getAdUnitId(), aVarHnadsa).hnadse();
            }
        }
    }
}
