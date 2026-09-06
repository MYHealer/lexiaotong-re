package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bu extends bl {
    private static final String Z = "JsbReportPraiseEvent";

    public bu() {
        super(ak.H);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bu.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                dd.Code(context, adContentData);
                bu.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
