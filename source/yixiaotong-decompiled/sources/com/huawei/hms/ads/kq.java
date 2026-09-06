package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class kq extends kr {
    private static final String Code = "SpecifiedAgdDownloadAction";
    private int S;
    private int V;

    public kq(Context context, AdContentData adContentData) {
        super(context, adContentData);
        this.V = 2;
        this.S = 1;
    }

    private AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        AppDownloadTask appDownloadTaskCode = com.huawei.openalliance.ad.download.app.g.I().Code(appInfo);
        if (appDownloadTaskCode == null && (appDownloadTaskCode = new AppDownloadTask.a().Code(appInfo).Code()) != null) {
            appDownloadTaskCode.Code(Integer.valueOf(this.V));
            appDownloadTaskCode.I(Integer.valueOf(this.S));
            appDownloadTaskCode.Code(this.Z);
        }
        if (appDownloadTaskCode != null && this.Z != null) {
            appDownloadTaskCode.B(this.Z.w());
            appDownloadTaskCode.Z(this.Z.L());
            appDownloadTaskCode.C(this.Z.a());
            appDownloadTaskCode.I(this.Z.D());
            appDownloadTaskCode.b(this.Z.aE());
            appDownloadTaskCode.C(this.Z.aF());
        }
        return appDownloadTaskCode;
    }

    public void Code(int i) {
        this.V = i;
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        fh.V(Code, "handle SpecifiedAgdDownloadAction");
        if (this.Z == null || this.Z.y() == null) {
            fh.V(Code, "getAppInfo is null");
            return I();
        }
        com.huawei.openalliance.ad.inter.data.AppInfo appInfoY = this.Z.y();
        if (appInfoY != null && com.huawei.openalliance.ad.utils.h.Code(this.I, appInfoY.Code())) {
            fh.V(Code, "app installed");
            return I();
        }
        AppDownloadTask appDownloadTaskCode = Code(appInfoY);
        if (appDownloadTaskCode == null) {
            fh.V(Code, "downloadTask is null");
            return I();
        }
        appDownloadTaskCode.Code(Integer.valueOf(this.V));
        Code(com.huawei.openalliance.ad.constant.v.Code);
        com.huawei.openalliance.ad.download.app.g.I().Code(appDownloadTaskCode);
        return true;
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        Code(com.huawei.openalliance.ad.constant.v.Code);
    }

    public void V(int i) {
        this.S = i;
    }
}
