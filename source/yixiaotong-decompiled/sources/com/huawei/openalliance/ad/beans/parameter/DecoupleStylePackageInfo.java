package com.huawei.openalliance.ad.beans.parameter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class DecoupleStylePackageInfo {
    private String sha256;
    private int size;
    private String version;

    public String Code() {
        return this.version;
    }

    public void Code(int i) {
        this.size = i;
    }

    public void Code(String str) {
        this.version = str;
    }

    public int I() {
        return this.size;
    }

    public String V() {
        return this.sha256;
    }

    public void V(String str) {
        this.sha256 = str;
    }
}
