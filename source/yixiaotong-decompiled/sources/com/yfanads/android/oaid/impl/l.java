package com.yfanads.android.oaid.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: NubiaImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class l implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9668a;

    public l(Context context) {
        this.f9668a = context;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9668a != null) {
            if (!a()) {
                YFLog.debug("Only supports Android 10.0 and above for Nubia");
                aVar.onOAIDGetFail(new com.yfanads.android.oaid.a("Only supports Android 10.0 and above for Nubia"));
                return;
            }
            try {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f9668a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
                if (contentProviderClientAcquireContentProviderClient == null) {
                    return;
                }
                Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                contentProviderClientAcquireContentProviderClient.close();
                if (bundleCall != null) {
                    String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
                    if (string != null && string.length() != 0) {
                        aVar.onOAIDGetSuccess(string);
                        return;
                    }
                    throw new com.yfanads.android.oaid.a("OAID query failed: " + bundleCall.getString(CrashHianalyticsData.MESSAGE));
                }
                throw new com.yfanads.android.oaid.a("OAID query failed: bundle is null");
            } catch (Exception e) {
                YFLog.debug(e);
                aVar.onOAIDGetFail(e);
            }
        }
    }
}
