package com.opos.cmn.i;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    public static final boolean a(Context context, Uri uri) {
        boolean z = false;
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
            z = contentProviderClientAcquireContentProviderClient != null;
            if (contentProviderClientAcquireContentProviderClient != null) {
                contentProviderClientAcquireContentProviderClient.release();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("", "check provider", e);
        }
        return z;
    }
}
