package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bo extends bl {
    private static final String Z = "JsbReportCommonEvent";

    public bo() {
        super(ak.K);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.ad.Code(str, AdEventReport.class, new Class[0]);
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.bo.1
            /* JADX WARN: Code duplicated, block: B:11:0x003b  */
            /* JADX WARN: Code duplicated, block: B:13:0x003f  */
            /* JADX WARN: Code duplicated, block: B:14:0x004f  */
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i;
                if (jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ba.be, true)) {
                    if (adContentData == null) {
                        fh.V(bo.Z, "ad is null");
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bo.this.Code;
                        i = 3002;
                    } else if (!bo.this.Code(adContentData)) {
                        fh.V(bo.Z, "ad is not in whitelist");
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bo.this.Code;
                        i = 3004;
                    } else if (adEventReport == null) {
                        fh.V(bo.Z, "parmas is null");
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bo.this.Code;
                        i = 3001;
                    } else {
                        fh.V(bo.Z, "start report event");
                        jk.Code(context, str);
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bo.this.Code;
                        i = 1000;
                    }
                } else if (adEventReport == null) {
                    fh.V(bo.Z, "parmas is null");
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bo.this.Code;
                    i = 3001;
                } else {
                    fh.V(bo.Z, "start report event");
                    jk.Code(context, str);
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bo.this.Code;
                    i = 1000;
                }
                ah.Code(remoteCallResultCallback2, str2, i, null, true);
            }
        });
    }
}
