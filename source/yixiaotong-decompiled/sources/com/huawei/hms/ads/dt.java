package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class dt extends dp {
    public static final String I = "16";
    public static final String V = "15";
    private static final String Z = "AlertReminder";

    public dt(Context context) {
        super(context);
    }

    private void I(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo, final AdContentData adContentData, long j) {
        fh.V(Z, "showNonWifiAlert, context:" + Code());
        com.huawei.openalliance.ad.download.app.f.V(Code(), j, new com.huawei.openalliance.ad.utils.r.a() { // from class: com.huawei.hms.ads.dt.1
            @Override // com.huawei.openalliance.ad.utils.r.a
            public void Code() {
                com.huawei.openalliance.ad.download.app.c.Code(dt.this.Code, "15", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.dt.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            fh.V(dt.Z, " traffic reminder accept");
                        }
                    }
                }, String.class);
                dt.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.r.a
            public void V() {
                com.huawei.openalliance.ad.download.app.c.Code(dt.this.Code, "16", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.dt.1.2
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            fh.V(dt.Z, " traffic reminder reject");
                        }
                    }
                }, String.class);
                dt.this.V(appInfo);
            }
        });
    }

    @Override // com.huawei.hms.ads.dp
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        if (appInfo != null && adContentData != null) {
            I(appInfo, adContentData, j);
        } else {
            fh.V(Z, "appInfo or contentRecord is empty");
            V(appInfo);
        }
    }
}
