package com.hihonor.adsdk.base.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.hihonor.adsdk.common.safe.SafeIntent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AppInstallReceiver extends BroadcastReceiver {
    private final String hnadsa = "AppInstallReceiver";
    private final int hnadsb = 8;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        String action = safeIntent.getAction();
        String dataString = safeIntent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String strSubstring = dataString.substring(8);
        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            com.hihonor.adsdk.common.b.b.hnadsc("AppInstallReceiver", "add", new Object[0]);
            d.hnadsa().hnadsa(strSubstring, 2012);
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            com.hihonor.adsdk.common.b.b.hnadsc("AppInstallReceiver", "remove", new Object[0]);
            d.hnadsa().hnadsa(strSubstring, -1);
        } else if ("android.intent.action.PACKAGE_FULLY_REMOVED".equals(action)) {
            com.hihonor.adsdk.common.b.b.hnadsc("AppInstallReceiver", "FULLY_REMOVED", new Object[0]);
        }
    }
}
