package com.hihonor.adsdk.base.i.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private final int hnadsa;
    private final int hnadsb;
    private final String hnadsc;
    private final int hnadsd;
    private boolean hnadse;

    public b(a aVar) {
        this.hnadsa = aVar.hnadsa;
        this.hnadsb = aVar.hnadsb;
        this.hnadsc = aVar.hnadsc;
        this.hnadsd = aVar.hnadsd;
        this.hnadse = aVar.hnadse;
    }

    public int hnadsa() {
        return this.hnadsb;
    }

    public void hnadsa(boolean z) {
        this.hnadse = z;
    }

    public int hnadsb() {
        return this.hnadsa;
    }

    public String hnadsc() {
        return this.hnadsc;
    }

    public int hnadsd() {
        return this.hnadsd;
    }

    public boolean hnadse() {
        return this.hnadse;
    }

    public static class a {
        private int hnadsb;
        private String hnadsc;
        private int hnadsd;
        private int hnadsa = 0;
        private boolean hnadse = true;

        public a hnadsa(int i) {
            this.hnadsb = i;
            return this;
        }

        public a hnadsa(String str) {
            this.hnadsc = str;
            return this;
        }

        public a hnadsa(boolean z) {
            this.hnadse = z;
            return this;
        }

        public a hnadsb(int i) {
            this.hnadsa = i;
            return this;
        }

        public a hnadsc(int i) {
            this.hnadsd = i;
            return this;
        }

        public b hnadsa() {
            return new b(this);
        }
    }
}
