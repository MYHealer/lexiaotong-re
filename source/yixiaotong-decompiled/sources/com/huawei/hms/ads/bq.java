package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class bq extends bl {
    private static final String Z = "JsbReportPlayPauseEvent";

    public bq() {
        super(ak.l);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.ad.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bq.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    jk.Code(context, adContentData, com.huawei.openalliance.ad.constant.aj.C, Long.valueOf(adEventReport2.d() == null ? 0L : adEventReport.d().longValue()), Long.valueOf(adEventReport.e() != null ? adEventReport.e().longValue() : 0L), Integer.valueOf(adEventReport.f() == null ? 0 : adEventReport.f().intValue()), Integer.valueOf(adEventReport.g() != null ? adEventReport.g().intValue() : 0));
                }
                bq.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
