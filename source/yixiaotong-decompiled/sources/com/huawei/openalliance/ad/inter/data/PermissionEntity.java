package com.huawei.openalliance.ad.inter.data;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PermissionEntity implements Serializable {
    private static final long serialVersionUID = -1825501272693801533L;
    private String name;
    private int type;

    public PermissionEntity() {
    }

    public PermissionEntity(String str, int i) {
        this.name = str;
        this.type = i;
    }

    public String Code() {
        return this.name;
    }

    public int V() {
        return this.type;
    }
}
