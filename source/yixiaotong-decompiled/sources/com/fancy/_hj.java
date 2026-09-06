package com.fancy;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hj implements _eg {
    public Context _a;

    public _hj(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        String string;
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this._a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : "";
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (_a4Var != null) {
            _a4Var._a(string);
        }
    }
}
