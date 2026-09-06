package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class aw extends av {
    public aw() {
        super(ak.b);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.aw.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    ah.Code(remoteCallResultCallback, aw.this.Code, 3002, null, true);
                    return;
                }
                aw.this.V(context, str).C(context, new com.huawei.openalliance.ad.inter.data.s(adContentData));
                aw.this.V((RemoteCallResultCallback<String>) remoteCallResultCallback, true);
            }
        });
    }
}
