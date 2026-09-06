package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class kn extends kr {
    private static final String Code = "OpenMiniPageAction";
    private int V;

    public kn(Context context, AdContentData adContentData) {
        super(context, adContentData);
        this.V = 2;
    }

    private AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        AppDownloadTask appDownloadTaskCode = com.huawei.openalliance.ad.download.app.g.I().Code(appInfo);
        if (appDownloadTaskCode == null) {
            appDownloadTaskCode = new AppDownloadTask.a().Code(appInfo).Code();
            if (appDownloadTaskCode != null) {
                appDownloadTaskCode.Code(Integer.valueOf(this.V));
                appDownloadTaskCode.Code(this.Z);
                if (this.Z != null) {
                    appDownloadTaskCode.B(this.Z.w());
                    appDownloadTaskCode.Z(this.Z.L());
                    appDownloadTaskCode.C(this.Z.a());
                    appDownloadTaskCode.I(this.Z.D());
                    appDownloadTaskCode.b(this.Z.aE());
                    appDownloadTaskCode.C(this.Z.aF());
                }
            }
        } else if (this.Z != null) {
            appDownloadTaskCode.Z(this.Z.L());
            appDownloadTaskCode.B(this.Z.w());
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
        String str;
        fh.V(Code, "handle OpenMiniPageAction");
        if (this.Z == null || this.Z.y() == null) {
            str = "getAppInfo is null";
        } else {
            com.huawei.openalliance.ad.inter.data.AppInfo appInfoY = this.Z.y();
            if (appInfoY == null || !com.huawei.openalliance.ad.utils.h.Code(this.I, appInfoY.Code())) {
                AppDownloadTask appDownloadTaskCode = Code(appInfoY);
                if (appDownloadTaskCode != null) {
                    appDownloadTaskCode.S(this.Z.at());
                    appDownloadTaskCode.F(this.Z.au());
                    appDownloadTaskCode.Code(Integer.valueOf(this.V));
                    appDownloadTaskCode.D(this.Z.M());
                    appDownloadTaskCode.I((Integer) 1);
                    Code(com.huawei.openalliance.ad.constant.v.F);
                    com.huawei.openalliance.ad.download.app.g.I().Code(appDownloadTaskCode);
                    return true;
                }
                str = "downloadTask is null";
            } else {
                str = "app installed";
            }
        }
        fh.V(Code, str);
        return I();
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        Code(com.huawei.openalliance.ad.constant.v.F);
    }
}
