package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bw extends bl {
    private static final String Z = "JsbReportShowStartEvent";

    public bw() {
        super(ak.m);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bw.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                jk.Code(context, adContentData);
                bw.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
