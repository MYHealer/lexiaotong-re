package com.meishu.sdk.core.download;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.meishu.sdk.core.safe.SafeBroadcastReceiver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InstallManager$InstallReceiver extends SafeBroadcastReceiver {
    @Override // com.meishu.sdk.core.safe.SafeBroadcastReceiver
    public void a(Context context, Intent intent) {
        context.getPackageManager();
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            Log.e("InstallManager", "onReceive:  app_added  " + intent.getData().getSchemeSpecificPart());
        } else if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            Log.e("InstallManager", "onReceive:  app_removed  " + intent.getData().getSchemeSpecificPart());
        }
    }
}
