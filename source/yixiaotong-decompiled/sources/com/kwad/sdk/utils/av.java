package com.kwad.sdk.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.byazt.tk.AdBaseConstants;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class av {
    public static PendingIntent a(Context context, int i, Intent intent) {
        return PendingIntent.getBroadcast(context, i, intent, 201326592);
    }

    private static PendingIntent b(Context context, int i, Intent intent) {
        return PendingIntent.getActivity(context, i, intent, 201326592);
    }

    public static PendingIntent a(Context context, File file, int i, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri uriC = c(context, file);
        intent.setDataAndType(uriC, AdBaseConstants.MIME_APK);
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uriC, 3);
        }
        if (z) {
            com.kwad.sdk.c.Ey();
            if (com.kwad.sdk.c.EB()) {
                intent = j(intent);
            }
        }
        return b(context, i, intent);
    }

    private static Uri c(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
    }

    private static Intent j(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra(com.huawei.openalliance.ad.download.app.d.e, intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    public static PendingIntent d(Context context, String str, int i) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i, launchIntentForPackage);
    }
}
