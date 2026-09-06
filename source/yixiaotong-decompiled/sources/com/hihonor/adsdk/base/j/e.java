package com.hihonor.adsdk.base.j;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e implements com.hihonor.adsdk.base.net.i.a {
    private static final int hnadsj = -100;
    private String hnadsa;
    private String hnadsb;
    private int hnadsc;
    private int hnadsd;
    private int hnadse;
    private String hnadsf;
    private int hnadsg;
    private int hnadsh;
    private final Context hnadsi;

    static /* synthetic */ class a {
    }

    private static class b {
        private static final e hnadsa = new e(null);

        private b() {
        }
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    public static e hnadsb() {
        return b.hnadsa;
    }

    private void hnadsl() {
        this.hnadsa = com.hihonor.adsdk.base.j.b.hnadsh(this.hnadsi);
    }

    private void hnadsm() {
        this.hnadsb = o.hnadsc(this.hnadsi);
    }

    private void hnadsn() {
        this.hnadsc = o.hnadsb(this.hnadsi);
    }

    private void hnadso() {
        this.hnadsh = j.hnadsc();
    }

    private void hnadsp() {
        this.hnadsg = j.hnadsf(this.hnadsi) ? 2 : 1;
    }

    private void hnadsq() {
        this.hnadsd = com.hihonor.adsdk.common.f.j.hnadsc(this.hnadsi);
    }

    private void hnadsr() {
        this.hnadse = com.hihonor.adsdk.common.f.j.hnadse(this.hnadsi);
    }

    private void hnadss() {
        this.hnadsf = j.hnadse(this.hnadsi);
    }

    @Override // com.hihonor.adsdk.base.net.i.a
    public void hnadsa() {
        hnadsn();
    }

    public String hnadsc() {
        if (TextUtils.isEmpty(this.hnadsa)) {
            hnadsl();
        }
        return this.hnadsa;
    }

    public String hnadsd() {
        if (TextUtils.isEmpty(this.hnadsb)) {
            hnadsm();
        }
        return this.hnadsb;
    }

    public int hnadsh() {
        if (this.hnadsd == -100 || j.hnadsk()) {
            hnadsq();
        }
        return this.hnadsd;
    }

    public int hnadsi() {
        if (this.hnadse == -100 || j.hnadsk()) {
            hnadsr();
        }
        return this.hnadse;
    }

    public String hnadsj() {
        if (TextUtils.isEmpty(this.hnadsf)) {
            hnadss();
        }
        return this.hnadsf;
    }

    public void hnadsk() {
        hnadsl();
        hnadsm();
        hnadso();
        hnadsn();
        hnadsq();
        hnadsr();
        hnadss();
        hnadsp();
        com.hihonor.adsdk.base.net.i.hnadsa(this);
    }

    private e() {
        this.hnadsc = -100;
        this.hnadsd = -100;
        this.hnadse = -100;
        this.hnadsg = -100;
        this.hnadsh = -100;
        this.hnadsi = HnAds.get().getContext();
    }

    public int hnadse() {
        if (this.hnadsc == -100) {
            hnadsn();
        }
        return this.hnadsc;
    }

    public int hnadsf() {
        if (this.hnadsh == -100) {
            hnadso();
        }
        return this.hnadsh;
    }

    public int hnadsg() {
        if (this.hnadsg == -100) {
            hnadsp();
        }
        return this.hnadsg;
    }
}
