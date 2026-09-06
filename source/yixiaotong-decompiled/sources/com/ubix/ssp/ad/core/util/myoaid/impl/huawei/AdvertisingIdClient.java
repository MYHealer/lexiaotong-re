package com.ubix.ssp.ad.core.util.myoaid.impl.huawei;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.ubix.ssp.ad.e.a0.u;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";
    private static final String TAG = "AdvertisingIdClient";

    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        public Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        public String getId() {
            return this.advertisingId;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8594a;

        a(Context context) {
            this.f8594a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.f8594a);
            } catch (Throwable th) {
                Log.w("AdIdClient", "update Id err: " + th.getClass().getSimpleName());
            }
        }
    }

    public static Info getAdvertisingIdInfo(Context context) {
        try {
            if (TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "pps_oaid_c"))) {
                return null;
            }
            Info infoA = c.a(context);
            return infoA != null ? infoA : requestAdvertisingIdInfo(context);
        } catch (Throwable th) {
            Log.w("AdIdClient", "get Id err: " + th.getClass().getSimpleName());
            return null;
        }
    }

    private static Info getIdInfoViaAIDL(Context context) throws IOException {
        try {
            context.getPackageManager().getPackageInfo(d.a(context), 64);
            b bVar = new b();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(d.a(context));
            try {
                if (!context.bindService(intent, bVar, 1)) {
                    throw new IOException("bind failed");
                }
                try {
                    com.ubix.ssp.ad.e.a0.c0.i.b.a aVarA = com.ubix.ssp.ad.e.a0.c0.i.b.a.AbstractBinderC1071a.a(bVar.a());
                    Info info = new Info(aVarA.i(), aVarA.g());
                    try {
                        context.unbindService(bVar);
                    } catch (Throwable th) {
                        Log.w("AdIdClient", "unbind " + th.getClass().getSimpleName());
                    }
                    return info;
                } catch (RemoteException unused) {
                    throw new IOException("bind hms service RemoteException");
                } catch (InterruptedException unused2) {
                    throw new IOException("bind hms service InterruptedException");
                }
            } catch (Throwable th2) {
                try {
                    context.unbindService(bVar);
                } catch (Throwable th3) {
                    Log.w("AdIdClient", "unbind " + th3.getClass().getSimpleName());
                }
                throw th2;
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Service not found");
        } catch (Exception unused4) {
            throw new IOException("Service not found: Exception");
        }
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo(d.a(context), 128);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(d.a(context));
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Info requestAdvertisingIdInfo(Context context) {
        if (c.d(context)) {
            u.e(TAG, "requestAdvertisingIdInfo via provider");
            return c.c(context);
        }
        u.e(TAG, "requestAdvertisingIdInfo via aidl");
        return getIdInfoViaAIDL(context);
    }

    private static void updateAdvertisingIdInfo(Context context) {
        f.f8603a.execute(new a(context));
    }

    public static boolean verifyAdId(Context context, String str, boolean z) throws com.ubix.ssp.ad.core.util.myoaid.impl.huawei.a {
        try {
            Info infoRequestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
            if (infoRequestAdvertisingIdInfo != null) {
                return TextUtils.equals(str, infoRequestAdvertisingIdInfo.getId()) && z == infoRequestAdvertisingIdInfo.isLimitAdTrackingEnabled();
            }
            Log.w("AdIdClient", "info is null");
            return false;
        } catch (Throwable unused) {
            throw new com.ubix.ssp.ad.core.util.myoaid.impl.huawei.a("Something wrong with verification, please try later.");
        }
    }
}
