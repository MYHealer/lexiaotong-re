package com.kwad.sdk.core.e.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class g {
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String string = "";
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall != null) {
                string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : "";
                com.kwad.sdk.core.d.c.i("NubiaDeviceIDHelper", "getOAID oaid:" + string + "faledMsg:" + bundleCall.getString(CrashHianalyticsData.MESSAGE));
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.i("NubiaDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        return string;
    }
}
