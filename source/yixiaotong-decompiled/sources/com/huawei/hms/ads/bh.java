package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bh extends av {
    public bh() {
        super(ak.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData) {
        AppDownloadTask appDownloadTaskCode = new AppDownloadTask.a().Code(appInfo).Code();
        appDownloadTaskCode.C(adContentData.aF());
        appDownloadTaskCode.D(adContentData.M());
        appDownloadTaskCode.I(adContentData.D());
        appDownloadTaskCode.Z(adContentData.L());
        appDownloadTaskCode.C(adContentData.a());
        return appDownloadTaskCode;
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bh.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                if (adContentData != null) {
                    com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                    if (sVar.E() != null) {
                        com.huawei.openalliance.ad.download.app.b.Code(context).Code(bh.this.Code(sVar.E(), adContentData));
                        bh.this.V((RemoteCallResultCallback<String>) remoteCallResultCallback, true);
                        return;
                    }
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bh.this.Code;
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bh.this.Code;
                }
                ah.Code(remoteCallResultCallback2, str2, 3002, null, true);
            }
        });
    }
}
