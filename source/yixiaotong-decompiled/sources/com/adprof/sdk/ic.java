package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ic {
    public static void a(Context context, Intent intent) throws gc {
        qh.a(context);
        qh.a(intent);
        try {
            if (!context.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                a(context, intent, "Unable to open intent: " + intent);
                return;
            }
        } catch (Throwable th) {
            pk.b("deviceCanHandleIntent error: ", th);
        }
        try {
            intent.addFlags(872415232);
            AdprofSdk.getInstance().getContext().startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, Uri uri) throws gc {
        qh.a(context);
        qh.a(uri);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (!TextUtils.isEmpty(null)) {
            intent.setPackage(null);
        }
        a(context, intent, "Unable to open intent: " + intent);
    }

    public static void a(Context context, Intent intent, String str) throws gc {
        qh.a(context);
        qh.a(intent);
        try {
            qh.a(context);
            qh.a(intent);
            try {
                intent.addFlags(872415232);
                context.startActivity(intent);
            } catch (Throwable th) {
                throw new gc(th);
            }
        } catch (Throwable th2) {
            throw new gc(str + IOUtils.LINE_SEPARATOR_UNIX + th2.getMessage());
        }
    }
}
