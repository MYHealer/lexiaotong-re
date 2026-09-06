package com.ubix.ssp.ad.e.a0.c0.h;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class k implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8657a;

    public k(Context context) {
        this.f8657a = context;
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8657a == null || cVar == null) {
            return;
        }
        if (!a()) {
            com.ubix.ssp.ad.e.a0.c0.f.a("Only supports Android 10.0 and above for Nubia");
            cVar.a(new com.ubix.ssp.ad.e.a0.c0.e("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f8657a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new com.ubix.ssp.ad.e.a0.c0.e("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new com.ubix.ssp.ad.e.a0.c0.e("OAID query failed: " + bundleCall.getString(CrashHianalyticsData.MESSAGE));
            }
            com.ubix.ssp.ad.e.a0.c0.f.a("OAID query success: " + string);
            cVar.a(string);
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            cVar.a(e);
        }
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
