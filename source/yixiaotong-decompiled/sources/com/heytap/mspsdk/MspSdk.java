package com.heytap.mspsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.mspsdk.core.crash.a;
import com.heytap.mspsdk.core.crash.c;
import com.heytap.mspsdk.core.e;
import com.heytap.mspsdk.event.b;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.log.MspLog;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MspSdk {
    private static final String TAG = "MspSdk";
    private static AtomicBoolean sInitialized = new AtomicBoolean(false);

    public static void addMspProcessCrashListener(Context context, String str, c cVar) {
        try {
            MspLog.d(TAG, "addMspProcessCrashListener:" + str);
            if (context != null && StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                String strA = a.a(context, str);
                a.a().a(context);
                a.a().a(context, strA, cVar);
            }
        } catch (Exception e) {
            MspLog.e(TAG, e);
        }
    }

    public static <T> T apiProxy(Class<T> cls, Bundle bundle) throws MspSdkException {
        return (T) com.heytap.mspsdk.proxy.a.a().a(cls, null, null, bundle);
    }

    public static <T> T apiProxy(Class<T> cls, Parcelable parcelable, Bundle bundle) throws MspSdkException {
        return (T) com.heytap.mspsdk.proxy.a.a().a(cls, null, parcelable, bundle);
    }

    public static <T, R extends T> T apiProxy(R r) throws MspSdkException {
        return (T) apiProxy(r, (b) null);
    }

    public static <T, R extends T> T apiProxy(R r, b bVar) throws MspSdkException {
        return (T) com.heytap.mspsdk.proxy.a.a().a(r, bVar);
    }

    public static synchronized void init(Context context) {
        if (sInitialized.get()) {
            MspLog.iIgnore(TAG, "Sdk has initialized! version:2.0.1.7");
            return;
        }
        MspLog.iIgnore(TAG, "Sdk init start");
        e.a().a(context);
        sInitialized.set(true);
        MspLog.iIgnore(TAG, "Sdk init finish, version:2.0.1.7");
    }

    public static boolean preConnectToMspCore() {
        return e.a().a((ArrayList<String>) null);
    }

    public static void removeOnDownloadInstallListener() {
        e.a().d();
    }

    public static void setOnDownloadInstallListener(com.heytap.mspsdk.guide.b bVar) {
        e.a().a(bVar);
    }
}
