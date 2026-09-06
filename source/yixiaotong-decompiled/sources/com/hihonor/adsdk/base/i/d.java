package com.hihonor.adsdk.base.i;

import android.text.TextUtils;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.init.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    private final String hnadsa;
    private final String hnadsb;
    private boolean hnadsc;
    private boolean hnadsd;
    private final String hnadse;
    private final String hnadsf;
    private final String hnadsg;
    private final String hnadsh;
    private final int hnadsi;
    private final int hnadsj;
    private final int hnadsk;
    private final int hnadsl;
    private final int hnadsm;
    private final int hnadsn;
    private final int hnadso;
    private String hnadsp;
    private String hnadsq;
    private final List<String> hnadsr;
    private final List<String> hnadss;

    public d(a aVar) {
        this.hnadsa = aVar.hnadsa;
        this.hnadsb = aVar.hnadsb;
        this.hnadse = aVar.hnadsc;
        this.hnadsf = aVar.hnadsd;
        this.hnadsg = aVar.hnadse;
        this.hnadsh = aVar.hnadsf;
        this.hnadsi = aVar.hnadsh;
        this.hnadsj = aVar.hnadsi;
        this.hnadsk = aVar.hnadsj;
        this.hnadsl = aVar.hnadsk;
        this.hnadsm = aVar.hnadsl;
        this.hnadsn = aVar.hnadsm;
        this.hnadso = aVar.hnadsn;
        this.hnadsc = aVar.hnadsg;
        this.hnadsr = aVar.hnadso;
        this.hnadss = aVar.hnadsp;
        this.hnadsp = aVar.hnadsq;
        this.hnadsq = aVar.hnadsr;
    }

    public String hnadsa() {
        return this.hnadsf;
    }

    public void hnadsa(boolean z) {
        this.hnadsd = z;
    }

    public int hnadsb() {
        return this.hnadsi;
    }

    public String hnadsc() {
        return this.hnadsg;
    }

    public String hnadsd() {
        return this.hnadsh;
    }

    public List<String> hnadse() {
        return this.hnadss;
    }

    public int hnadsf() {
        return this.hnadsm;
    }

    public String hnadsg() {
        return this.hnadsa;
    }

    public List<String> hnadsh() {
        return this.hnadsr;
    }

    public int hnadsi() {
        return this.hnadso;
    }

    public int hnadsj() {
        return this.hnadsn;
    }

    public int hnadsk() {
        return this.hnadsl;
    }

    public String hnadsl() {
        return this.hnadsb;
    }

    public int hnadsm() {
        return this.hnadsj;
    }

    public int hnadsn() {
        return this.hnadsk;
    }

    public String hnadso() {
        return this.hnadse;
    }

    public String hnadsp() {
        return this.hnadsq;
    }

    public String hnadsq() {
        return this.hnadsp;
    }

    public boolean hnadsr() {
        return this.hnadsc;
    }

    public boolean hnadss() {
        return this.hnadsd;
    }

    public static class a {
        private String hnadsa;
        private String hnadsb;
        private String hnadsc;
        private String hnadsd;
        private String hnadse;
        private String hnadsf;
        private boolean hnadsg;
        private int hnadsh;
        private int hnadsi;
        private int hnadsj;
        private int hnadsk;
        private int hnadsl;
        private int hnadsm;
        private int hnadsn;
        private List<String> hnadso;
        private List<String> hnadsp;
        private String hnadsq;
        private String hnadsr;

        public a() {
            this.hnadsg = i.hnadsa() == 1;
        }

        public a hnadsa(int i) {
            this.hnadsh = i;
            return this;
        }

        public a hnadsa(String str) {
            this.hnadsd = str;
            return this;
        }

        public a hnadsa(List<String> list) {
            this.hnadsp = list;
            return this;
        }

        public a hnadsa(boolean z) {
            this.hnadsg = z;
            return this;
        }

        public a hnadsb(int i) {
            this.hnadsl = i;
            return this;
        }

        public a hnadsb(String str) {
            this.hnadse = str;
            return this;
        }

        public a hnadsb(List<String> list) {
            this.hnadso = list;
            return this;
        }

        public a hnadsc(int i) {
            this.hnadsn = i;
            return this;
        }

        public a hnadsc(String str) {
            this.hnadsf = str;
            return this;
        }

        public a hnadsd(int i) {
            this.hnadsm = i;
            return this;
        }

        public a hnadsd(String str) {
            this.hnadsa = str;
            return this;
        }

        public a hnadse(int i) {
            this.hnadsk = i;
            return this;
        }

        public a hnadse(String str) {
            this.hnadsb = str;
            return this;
        }

        public a hnadsf(int i) {
            this.hnadsi = i;
            return this;
        }

        public a hnadsf(String str) {
            this.hnadsc = str;
            return this;
        }

        public a hnadsg(int i) {
            this.hnadsj = i;
            return this;
        }

        public a hnadsg(String str) {
            this.hnadsq = str;
            return this;
        }

        public a(BaseAd baseAd) {
            this();
            this.hnadsa = baseAd.getDeeplinkUrl();
            this.hnadsb = !TextUtils.isEmpty(baseAd.getDpPackageName()) ? baseAd.getDpPackageName() : baseAd.getAppPackage();
            this.hnadsc = baseAd.getRequestId();
            this.hnadsd = baseAd.getAdId();
            this.hnadse = baseAd.getAdUnitId();
            this.hnadsf = baseAd.getAppVersion();
            this.hnadsh = baseAd.getAdType();
            this.hnadsi = baseAd.getPkgType();
            this.hnadsj = baseAd.getPromotionPurpose();
            this.hnadsk = baseAd.getMiniProgramType();
            this.hnadsl = baseAd.getDataType();
            this.hnadsm = baseAd.getSequence();
            this.hnadsn = baseAd.getItemPosition();
            this.hnadsq = baseAd.getUnInstallFilter();
            this.hnadsr = baseAd.getTemplateId();
            if (baseAd.getTrackUrl() != null) {
                this.hnadso = baseAd.getTrackUrl().getDpSuccess();
                this.hnadsp = baseAd.getTrackUrl().getCommons();
            }
        }

        public d hnadsa() {
            return new d(this);
        }

        public a(com.hihonor.adsdk.base.download.g gVar) {
            this();
            this.hnadsb = gVar.hnadsd();
            this.hnadsc = gVar.g();
            this.hnadsd = gVar.hnadsa();
            this.hnadse = gVar.hnadsc();
            this.hnadsf = gVar.hnadse();
            this.hnadsh = gVar.hnadsb();
            this.hnadsi = gVar.d();
            this.hnadsj = gVar.f();
            this.hnadsl = gVar.hnadsk();
            this.hnadsm = gVar.i();
            this.hnadsn = gVar.hnadsu();
            this.hnadsq = gVar.q();
            this.hnadsr = gVar.n();
            this.hnadso = new ArrayList(0);
            this.hnadsp = new ArrayList(0);
        }

        public a(InstallNotifyBean installNotifyBean) {
            this();
            this.hnadsb = installNotifyBean.getAppPackage();
            this.hnadsc = installNotifyBean.getRequestId();
            this.hnadsd = installNotifyBean.getAdId();
            this.hnadse = installNotifyBean.getAdUnitId();
            this.hnadsf = installNotifyBean.getAppVersion();
            this.hnadsh = installNotifyBean.getAdType();
            this.hnadsi = installNotifyBean.getPkgType();
            this.hnadsj = installNotifyBean.getPromotionPurpose();
            this.hnadsl = installNotifyBean.getDataType();
            this.hnadsm = installNotifyBean.getSequence();
            this.hnadsr = installNotifyBean.getTemplateId();
            this.hnadso = new ArrayList(0);
            this.hnadsp = new ArrayList(0);
        }
    }
}
