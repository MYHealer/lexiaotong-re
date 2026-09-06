package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bt extends bl {
    private static final String Z = "JsbReportPlayTimeEvent";

    public bt() {
        super(ak.l);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        final long jOptLong = new JSONObject(str).optLong(com.huawei.openalliance.ad.constant.ba.bc, 0L);
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bt.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                adContentData.B(jOptLong);
                jk.V(context, adContentData, com.huawei.openalliance.ad.constant.aj.h);
                bt.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
