package com.opos.mobad.provider;

import android.content.Context;
import android.net.Uri;
import com.opos.process.bridge.server.ProcessBridgeProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class MobAdGlobalProvider extends ProcessBridgeProvider {
    private static final String AUTHORITY_SUFFIX = "MobAdGlobalProvider";

    public static final String getAuthority(Context context) {
        return context.getPackageName() + ".MobAdGlobalProvider";
    }

    public static Uri getUri(Context context) {
        return Uri.parse("content://" + getAuthority(context));
    }

    @Override // com.opos.process.bridge.server.ProcessBridgeProvider, android.content.ContentProvider
    public boolean onCreate() {
        return super.onCreate();
    }
}
