package com.huawei.hms.ads;

import com.huawei.openalliance.ad.inter.data.PermissionEntity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AppPermision {
    private String name;
    private int type;

    public AppPermision(PermissionEntity permissionEntity) {
        if (permissionEntity != null) {
            this.name = permissionEntity.Code();
            this.type = permissionEntity.V();
        }
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }
}
