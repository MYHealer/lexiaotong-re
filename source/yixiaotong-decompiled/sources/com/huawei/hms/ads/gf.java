package com.huawei.hms.ads;

import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class gf implements gj {
    public static final String Code = "appInfo";
    public static final String I = "downloadSource";
    public static final String V = "contentRecord";
    private static final String Z = "AppNotificationBaseAction";

    @Override // com.huawei.hms.ads.gj
    public void Code(Context context, Intent intent) {
        StringBuilder sb;
        try {
            com.huawei.openalliance.ad.inter.data.AppInfo appInfo = (com.huawei.openalliance.ad.inter.data.AppInfo) intent.getSerializableExtra("appInfo");
            AdContentData adContentData = (AdContentData) intent.getSerializableExtra("contentRecord");
            int intExtra = intent.getIntExtra(I, 1);
            if (appInfo != null && adContentData != null) {
                if (gk.Code(context).I(appInfo.Code())) {
                    Code(context, appInfo, adContentData, intExtra);
                    gk.Code(context).V(appInfo.Code());
                } else {
                    fh.V(Z, "packageName may be illegal:" + appInfo.Code());
                }
            }
        } catch (IllegalStateException e) {
            e = e;
            sb = new StringBuilder("AppNotificationBaseAction.onReceive IllegalStateException:");
            fh.I(Z, sb.append(e.getClass().getSimpleName()).toString());
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder("AppNotificationBaseAction.onReceive Exception:");
            fh.I(Z, sb.append(e.getClass().getSimpleName()).toString());
        }
    }

    protected void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i) {
        fh.V(Z, "do nothing at base action!");
    }
}
