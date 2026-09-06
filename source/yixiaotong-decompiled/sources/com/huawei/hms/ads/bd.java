package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bd extends av {
    public bd() {
        super(ak.f3815a);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bd.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    ah.Code(remoteCallResultCallback, bd.this.Code, 3002, null, true);
                    return;
                }
                bd.this.V(context, str).B(context, new com.huawei.openalliance.ad.inter.data.s(adContentData));
                bd.this.V((RemoteCallResultCallback<String>) remoteCallResultCallback, true);
            }
        });
    }
}
