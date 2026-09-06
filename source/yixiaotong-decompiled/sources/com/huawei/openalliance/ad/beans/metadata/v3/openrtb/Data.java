package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Data implements Serializable {
    private static final long serialVersionUID = 4120218934780835998L;
    private int len;
    private int type;
    private String value;

    public int Code() {
        return this.type;
    }

    public void Code(int i) {
        this.type = i;
    }

    public void Code(String str) {
        this.value = str;
    }

    public int I() {
        return this.len;
    }

    public String V() {
        return this.value;
    }

    public void V(int i) {
        this.len = i;
    }
}
