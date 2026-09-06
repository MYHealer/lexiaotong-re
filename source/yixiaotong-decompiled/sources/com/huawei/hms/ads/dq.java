package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class dq extends dp {
    private static final String B = "117";
    private static final String I = "115";
    private static final String V = "ConfirmDownloadAlertStrategy";
    private static final String Z = "116";

    private static class a implements RemoteCallResultCallback<String> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() != -1) {
                fh.V(dq.V, "confirm reminder reject");
            }
        }
    }

    public dq(Context context) {
        super(context);
    }

    private void Code(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo, final AdContentData adContentData) {
        fh.V(V, "showConfirmDownloadAlert, context:" + Code());
        Code(I, adContentData);
        com.huawei.openalliance.ad.download.app.f.Code(Code(), "11".equals(appInfo.y()), new com.huawei.openalliance.ad.utils.r.a() { // from class: com.huawei.hms.ads.dq.1
            @Override // com.huawei.openalliance.ad.utils.r.a
            public void Code() {
                dq.this.Code(dq.Z, adContentData);
                dq.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.r.a
            public void V() {
                dq.this.Code(dq.B, adContentData);
                dq.this.V(appInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, AdContentData adContentData) {
        com.huawei.openalliance.ad.download.app.c.Code(this.Code, str, adContentData, new a(), String.class);
    }

    @Override // com.huawei.hms.ads.dp
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        if (appInfo != null && adContentData != null) {
            Code(appInfo, adContentData);
        } else {
            fh.V(V, "appInfo or contentRecord is empty");
            V(appInfo);
        }
    }
}
