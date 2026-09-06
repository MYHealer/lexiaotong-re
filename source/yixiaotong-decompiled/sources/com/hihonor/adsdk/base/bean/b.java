package com.hihonor.adsdk.base.bean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private String hnadsa;
    private String hnadsb;
    private int hnadsc;
    private int hnadsd;
    private long hnadse;
    private long hnadsf;
    private int hnadsg;
    private int hnadsh;
    private String hnadsi;
    private int hnadsj;
    private boolean hnadsk;
    private String hnadsl;

    public b(a aVar) {
        this.hnadsa = aVar.hnadsa;
        this.hnadsb = aVar.hnadsb;
        this.hnadsc = aVar.hnadsc;
        this.hnadsd = aVar.hnadsd;
        this.hnadse = aVar.hnadse;
        this.hnadsf = aVar.hnadsf;
        this.hnadsg = aVar.hnadsk;
        this.hnadsh = aVar.hnadsh;
        this.hnadsi = aVar.hnadsi;
        this.hnadsj = aVar.hnadsj;
        this.hnadsk = aVar.hnadsg;
        this.hnadsl = aVar.hnadsl;
    }

    public int hnadsa() {
        return this.hnadsc;
    }

    public int hnadsb() {
        return this.hnadsh;
    }

    public String hnadsc() {
        return this.hnadsi;
    }

    public int hnadsd() {
        return this.hnadsg;
    }

    public int hnadse() {
        return this.hnadsd;
    }

    public int hnadsf() {
        return this.hnadsj;
    }

    public String hnadsg() {
        return this.hnadsa;
    }

    public String hnadsh() {
        return this.hnadsb;
    }

    public long hnadsi() {
        return this.hnadsf;
    }

    public String hnadsj() {
        return this.hnadsl;
    }

    public long hnadsk() {
        return this.hnadse;
    }

    public boolean hnadsl() {
        return this.hnadsk;
    }

    public static final class a {
        private String hnadsa;
        private String hnadsb;
        private int hnadsc;
        private int hnadsd;
        private long hnadse;
        private long hnadsf;
        private boolean hnadsg;
        private int hnadsh;
        private String hnadsi;
        private int hnadsj;
        private int hnadsk;
        private String hnadsl;

        public a hnadsa(int i) {
            this.hnadsc = i;
            return this;
        }

        public a hnadsa(long j) {
            this.hnadsf = j;
            return this;
        }

        public a hnadsa(String str) {
            this.hnadsi = str;
            return this;
        }

        public a hnadsa(boolean z) {
            this.hnadsg = z;
            return this;
        }

        public a hnadsb(int i) {
            this.hnadsh = i;
            return this;
        }

        public a hnadsb(long j) {
            this.hnadse = j;
            return this;
        }

        public a hnadsb(String str) {
            this.hnadsa = str;
            return this;
        }

        public a hnadsc(int i) {
            this.hnadsk = i;
            return this;
        }

        public a hnadsc(String str) {
            this.hnadsb = str;
            return this;
        }

        public a hnadsd(int i) {
            this.hnadsd = i;
            return this;
        }

        public a hnadsd(String str) {
            this.hnadsl = str;
            return this;
        }

        public a hnadse(int i) {
            this.hnadsj = i;
            return this;
        }

        public b hnadsa() {
            return new b(this);
        }
    }
}
