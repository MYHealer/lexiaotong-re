package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Permission implements Serializable {
    private static final long serialVersionUID = 5884421861234976573L;
    private String groupDesc;
    private String permissionLabel;

    public String Code() {
        return this.permissionLabel;
    }

    public String V() {
        return this.groupDesc;
    }
}
