package com.ubixnow.ooooo;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class y implements j {
    private final Context OooO00o;

    public y(Context context) {
        this.OooO00o = context;
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        if (!OooO00o()) {
            l.OooO00o("Only supports Android 10.0 and above for Nubia");
            iVar.OooO00o(new k("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.OooO00o.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new k("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new k("OAID query failed: " + bundleCall.getString(CrashHianalyticsData.MESSAGE));
            }
            l.OooO00o("OAID query success: " + string);
            iVar.OooO00o(string);
        } catch (Exception e) {
            l.OooO00o(e);
            iVar.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
