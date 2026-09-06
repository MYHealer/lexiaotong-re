package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bf extends av {
    public bf() {
        super(ak.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(AppStatus appStatus) {
        return appStatus == null ? AppStatus.DOWNLOAD.toString() : appStatus.toString();
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bf.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                AppStatus appStatusS = AppStatus.DOWNLOAD;
                if (adContentData != null) {
                    appStatusS = com.huawei.hms.ads.jsb.a.Code(context).Code().S(context, new com.huawei.openalliance.ad.inter.data.s(adContentData));
                }
                ah.Code(remoteCallResultCallback, bf.this.Code, 1000, bf.this.Code(appStatusS), true);
            }
        });
    }
}
