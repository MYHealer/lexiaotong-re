package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class dp {
    protected Context Code;
    private dp I;
    private a V;

    public interface a {
        void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo);

        void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo);
    }

    public dp(Context context) {
        this.Code = context;
    }

    public Context Code() {
        return this.Code;
    }

    public void Code(a aVar) {
        this.V = aVar;
    }

    public void Code(dp dpVar) {
        this.I = dpVar;
    }

    protected void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.Code(appInfo);
        }
    }

    public abstract void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j);

    protected void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.V(appInfo);
        }
    }

    protected void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        dp dpVar = this.I;
        if (dpVar == null) {
            V(appInfo);
        } else {
            dpVar.Code(this.V);
            this.I.Code(appInfo, adContentData, j);
        }
    }
}
