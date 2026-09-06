package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bj extends av {
    public bj() {
        super(ak.S);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.bj.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i;
                if (adContentData != null) {
                    final com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                    if (bj.this.Code(adContentData)) {
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.bj.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ah.Code(remoteCallResultCallback, bj.this.Code, 1000, Integer.valueOf(bj.this.V(context, str).Code(context, sVar)), true);
                            }
                        });
                        return;
                    } else {
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bj.this.Code;
                        i = 3004;
                    }
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bj.this.Code;
                    i = 3002;
                }
                ah.Code(remoteCallResultCallback2, str2, i, null, true);
            }
        });
    }
}
