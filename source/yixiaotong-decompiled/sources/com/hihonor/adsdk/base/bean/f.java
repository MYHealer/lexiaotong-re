package com.hihonor.adsdk.base.bean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f {
    private int hnadsa;
    public String hnadsb;

    public f(int i, String str) {
        this.hnadsa = i;
        this.hnadsb = str;
    }

    public int hnadsa() {
        return this.hnadsa;
    }

    public void hnadsa(int i) {
        this.hnadsa = i;
    }

    public void hnadsa(String str) {
        this.hnadsb = str;
    }

    public String hnadsb() {
        return this.hnadsb;
    }

    public String toString() {
        return "ResultBean{code=" + this.hnadsa + ", msg='" + this.hnadsb + "'}";
    }
}
