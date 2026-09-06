package com.hihonor.adsdk.base.bean;

import com.hihonor.adsdk.base.AdSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private AdSlot hnadsa;
    private com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> hnadsb;
    private int hnadsc;
    private String hnadsd;

    public a(C0425a c0425a) {
        this.hnadsa = c0425a.hnadsa;
        this.hnadsb = c0425a.hnadsb;
        this.hnadsc = c0425a.hnadsc;
        this.hnadsd = c0425a.hnadsd;
    }

    public AdSlot hnadsa() {
        return this.hnadsa;
    }

    public int hnadsb() {
        return this.hnadsc;
    }

    public com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> hnadsc() {
        return this.hnadsb;
    }

    public String hnadsd() {
        return this.hnadsd;
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.bean.a$a, reason: collision with other inner class name */
    public static class C0425a {
        private AdSlot hnadsa;
        private com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> hnadsb;
        private int hnadsc;
        private String hnadsd;

        public C0425a hnadsa(int i) {
            this.hnadsc = i;
            return this;
        }

        public C0425a hnadsa(AdSlot adSlot) {
            this.hnadsa = adSlot;
            return this;
        }

        public C0425a hnadsa(com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> eVar) {
            this.hnadsb = eVar;
            return this;
        }

        public C0425a hnadsa(String str) {
            this.hnadsd = str;
            return this;
        }

        public a hnadsa() {
            return new a(this);
        }
    }
}
