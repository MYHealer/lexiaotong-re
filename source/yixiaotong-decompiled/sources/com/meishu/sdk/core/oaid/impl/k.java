package com.meishu.sdk.core.oaid.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.meishu.sdk.core.oaid.OAIDException;

/* JADX INFO: compiled from: NubiaImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4836a;

    public k(Context context) {
        this.f4836a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4836a == null || aVar == null) {
            return;
        }
        if (!a()) {
            ((com.meishu.sdk.core.utils.l) aVar).a(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f4836a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall != null) {
                String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
                if (string != null && string.length() != 0) {
                    ((com.meishu.sdk.core.utils.l) aVar).a(string);
                    return;
                }
                throw new OAIDException("OAID query failed: " + bundleCall.getString(CrashHianalyticsData.MESSAGE));
            }
            throw new OAIDException("OAID query failed: bundle is null");
        } catch (Exception e) {
            ((com.meishu.sdk.core.utils.l) aVar).a(e);
        }
    }
}
