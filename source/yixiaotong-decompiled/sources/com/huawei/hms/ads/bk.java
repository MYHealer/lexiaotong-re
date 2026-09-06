package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bk extends ah {
    private static final String Z = "JsbUnregisterAppStatusProxy";

    public bk() {
        super(ak.z);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, false, new ad() { // from class: com.huawei.hms.ads.bk.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData == null || adContentData.y() == null) {
                    return;
                }
                com.huawei.hms.ads.jsb.a.Code(context).Code(adContentData.a());
            }
        });
    }
}
