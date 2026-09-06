package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ImpEX implements Serializable {
    private static final long serialVersionUID = 6214247551210205893L;
    private String key;
    private String value;

    public ImpEX() {
    }

    public ImpEX(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String Code() {
        return this.key;
    }

    public void Code(String str) {
        this.key = str;
    }

    public String V() {
        return this.value;
    }

    public void V(String str) {
        this.value = str;
    }
}
