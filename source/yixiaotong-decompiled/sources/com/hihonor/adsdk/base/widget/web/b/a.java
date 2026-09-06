package com.hihonor.adsdk.base.widget.web.b;

import android.os.SystemClock;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.i0;
import com.hihonor.adsdk.base.g.j.d.j0;
import com.hihonor.adsdk.base.g.j.d.l0;
import com.hihonor.adsdk.base.g.j.d.m0;
import com.hihonor.adsdk.base.g.j.d.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a implements d {
    protected long hnadsa;
    protected boolean hnadsb = false;
    protected boolean hnadsc = true;
    protected BaseAd hnadsd;
    protected int hnadse;

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa() {
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(int i) {
        this.hnadse = i;
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(int i, int i2) {
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(BaseAd baseAd) {
        this.hnadsd = baseAd;
    }

    protected abstract com.hihonor.adsdk.base.g.j.d.h1.b hnadsb(int i, String str);

    protected abstract String hnadsb();

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsb(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "reportLoadWebSuccess ", new Object[0]);
        if (this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "reportLoadWebSuccess#baseAd is null", new Object[0]);
            return;
        }
        if (this.hnadsb) {
            return;
        }
        this.hnadsb = true;
        com.hihonor.adsdk.base.g.j.d.h1.b bVarHnadsb = hnadsb(3, str);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd);
        bVarHnadsb.hnadsb(hnadsb());
        new l0(bVarHnadsb, this.hnadsd.getAdUnitId(), aVarHnadsa).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(this.hnadse)).hnadse();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "WebView onPage loadSuccess", new Object[0]);
    }

    protected abstract String hnadsc();

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsc(String str) {
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsd(String str) {
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadse(String str) {
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "reportStartLoadWeb ", new Object[0]);
        if (this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "reportStartLoadWeb#baseAd is null", new Object[0]);
            return;
        }
        this.hnadsa = SystemClock.elapsedRealtime();
        com.hihonor.adsdk.base.g.j.d.h1.b bVarHnadsb = hnadsb(1, str);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd);
        bVarHnadsb.hnadsb(hnadsb());
        bVarHnadsb.hnadsa(this.hnadsc);
        new m0(bVarHnadsb, this.hnadsd.getAdUnitId(), aVarHnadsa).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(this.hnadse)).hnadse();
        if (this.hnadsc) {
            this.hnadsc = false;
        }
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(String str, Integer num, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "reportLoadWebFail ", new Object[0]);
        if (this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "reportLoadWebFail#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.b bVarHnadsb = hnadsb(6, str);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd);
        bVarHnadsb.hnadsb(hnadsb());
        new j0(bVarHnadsb, this.hnadsd.getAdUnitId(), aVarHnadsa).hnadsa("error_code", String.valueOf(num)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadst, str2).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(this.hnadse)).hnadse();
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(int i, String str) {
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd);
        BaseAd baseAd = this.hnadsd;
        new x(baseAd != null ? baseAd.getAdUnitId() : "", aVarHnadsa, i, str).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(this.hnadse)).hnadse();
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(String str, int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "reportCloseWeb clickTimes: " + i + ", jumpTimes: " + i2, new Object[0]);
        if (this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "reportCloseWeb#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.b bVarHnadsb = hnadsb(4, str);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd);
        bVarHnadsb.hnadsb(hnadsb());
        bVarHnadsb.hnadsb(i2);
        bVarHnadsb.hnadsa(i);
        new i0(bVarHnadsb, this.hnadsd.getAdUnitId(), aVarHnadsa).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(this.hnadse)).hnadse();
    }
}
