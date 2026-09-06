package com.hihonor.adsdk.base.g.j.d.h1;

import com.hihonor.adsdk.base.mediation.adn.AdnConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private Integer hnadsa;
    private String hnadsb;
    private String hnadsc;
    private Integer hnadsd;
    private Integer hnadse;
    private String hnadsf;
    private String hnadsg;
    private Integer hnadsh;
    private String hnadsi;
    private String hnadsj;
    private String hnadsk;
    private String hnadsl;
    private String hnadsm;
    private String hnadsn;
    private String hnadso;
    private String hnadsp;

    public a(C0436a c0436a) {
        this.hnadsi = AdnConfig.b.hnadsa;
        this.hnadsj = AdnConfig.a.hnadsa;
        this.hnadsk = "0";
        this.hnadsb = c0436a.hnadsc;
        this.hnadsf = c0436a.hnadsa;
        this.hnadsa = c0436a.hnadsb;
        this.hnadsg = c0436a.hnadsh;
        this.hnadsc = c0436a.hnadsg;
        this.hnadsh = c0436a.hnadsd;
        this.hnadsd = c0436a.hnadse;
        this.hnadse = c0436a.hnadsf;
        this.hnadsi = c0436a.hnadsi;
        this.hnadsj = c0436a.hnadsj;
        this.hnadsk = c0436a.hnadsk;
        this.hnadsl = c0436a.hnadsl;
        this.hnadsm = c0436a.hnadsm;
        this.hnadsn = c0436a.hnadsn;
        this.hnadso = c0436a.hnadso;
        this.hnadsp = c0436a.hnadsp;
    }

    public String hnadsa() {
        return this.hnadsc;
    }

    public Integer hnadsb() {
        return this.hnadsa;
    }

    public String hnadsc() {
        return this.hnadsl;
    }

    public String hnadsd() {
        return this.hnadsm;
    }

    public String hnadse() {
        return this.hnadsj;
    }

    public String hnadsf() {
        return this.hnadsn;
    }

    public Integer hnadsg() {
        return this.hnadse;
    }

    public String hnadsh() {
        return this.hnadsf;
    }

    public Integer hnadsi() {
        return this.hnadsd;
    }

    public Integer hnadsj() {
        return this.hnadsh;
    }

    public String hnadsk() {
        return this.hnadsb;
    }

    public String hnadsl() {
        return this.hnadsk;
    }

    public String hnadsm() {
        return this.hnadso;
    }

    public String hnadsn() {
        return this.hnadsg;
    }

    public String hnadso() {
        return this.hnadsi;
    }

    public String hnadsp() {
        return this.hnadsp;
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.g.j.d.h1.a$a, reason: collision with other inner class name */
    public static class C0436a {
        private String hnadsa;
        private Integer hnadsb;
        private String hnadsc;
        private Integer hnadsd;
        private Integer hnadse;
        private Integer hnadsf;
        private String hnadsg;
        private String hnadsh;
        private String hnadsi = AdnConfig.b.hnadsa;
        private String hnadsj = AdnConfig.a.hnadsa;
        private String hnadsk = "0";
        private String hnadsl;
        private String hnadsm;
        private String hnadsn;
        private String hnadso;
        private String hnadsp;

        public C0436a hnadsa(Integer num) {
            this.hnadsb = num;
            return this;
        }

        public C0436a hnadsa(String str) {
            this.hnadsg = str;
            return this;
        }

        public C0436a hnadsb(Integer num) {
            this.hnadsf = num;
            return this;
        }

        public C0436a hnadsb(String str) {
            this.hnadsl = str;
            return this;
        }

        public C0436a hnadsc(Integer num) {
            this.hnadse = num;
            return this;
        }

        public C0436a hnadsc(String str) {
            this.hnadsm = str;
            return this;
        }

        public C0436a hnadsd(Integer num) {
            this.hnadsd = num;
            return this;
        }

        public C0436a hnadsd(String str) {
            this.hnadsj = str;
            return this;
        }

        public C0436a hnadse(String str) {
            this.hnadsn = str;
            return this;
        }

        public C0436a hnadsf(String str) {
            this.hnadsa = str;
            return this;
        }

        public C0436a hnadsg(String str) {
            this.hnadsc = str;
            return this;
        }

        public C0436a hnadsh(String str) {
            this.hnadsk = str;
            return this;
        }

        public C0436a hnadsi(String str) {
            this.hnadso = str;
            return this;
        }

        public C0436a hnadsj(String str) {
            this.hnadsh = str;
            return this;
        }

        public C0436a hnadsk(String str) {
            this.hnadsi = str;
            return this;
        }

        public C0436a hnadsl(String str) {
            this.hnadsp = str;
            return this;
        }

        public a hnadsa() {
            return new a(this);
        }
    }
}
