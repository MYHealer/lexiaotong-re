package com.adprof.sdk;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class lg implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1287a;

    public lg(Context context) {
        this.f1287a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1287a == null || ebVar == null) {
            return;
        }
        if (!a()) {
            ebVar.a(new mg("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f1287a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new mg("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new mg("OAID query failed: " + bundleCall.getString(CrashHianalyticsData.MESSAGE));
            }
            ebVar.a(string);
        } catch (Exception e) {
            ebVar.a(e);
        }
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
