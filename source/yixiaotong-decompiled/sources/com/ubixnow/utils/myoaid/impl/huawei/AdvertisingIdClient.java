package com.ubixnow.utils.myoaid.impl.huawei;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.ubixnow.ooooo.j0;
import com.ubixnow.ooooo.k0;
import com.ubixnow.ooooo.l0;
import com.ubixnow.ooooo.m0;
import com.ubixnow.ooooo.p0;
import com.ubixnow.ooooo.r0;
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

    public class OooO00o implements Runnable {
        public final /* synthetic */ Context OooO00o;

        public OooO00o(Context context) {
            this.OooO00o = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.OooO00o);
            } catch (Throwable th) {
                Log.w("AdIdClient", "update Id err: " + th.getClass().getSimpleName());
            }
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException {
        Info infoOooO00o;
        try {
            if (TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "pps_oaid_c")) || (infoOooO00o = l0.OooO00o(context)) == null) {
                return null;
            }
            return infoOooO00o;
        } catch (Throwable th) {
            Log.w("AdIdClient", "get Id err: " + th.getClass().getSimpleName());
            return null;
        }
    }

    private static Info getIdInfoViaAIDL(Context context) throws IOException {
        try {
            context.getPackageManager().getPackageInfo(m0.OooO00o(context), 64);
            k0 k0Var = new k0();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(m0.OooO00o(context));
            try {
                if (!context.bindService(intent, k0Var, 1)) {
                    throw new IOException("bind failed");
                }
                try {
                    r0 r0VarOooO00o = r0.OooO0O0.OooO00o(k0Var.OooO00o());
                    Info info = new Info(r0VarOooO00o.OooOO0O(), r0VarOooO00o.OooO0oO());
                    try {
                        context.unbindService(k0Var);
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
                    context.unbindService(k0Var);
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
            packageManager.getPackageInfo(m0.OooO00o(context), 128);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(m0.OooO00o(context));
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Info requestAdvertisingIdInfo(Context context) throws IOException {
        return l0.OooO0Oo(context) ? l0.OooO0OO(context) : getIdInfoViaAIDL(context);
    }

    private static void updateAdvertisingIdInfo(Context context) {
        p0.OooO00o.execute(new OooO00o(context));
    }

    public static boolean verifyAdId(Context context, String str, boolean z) throws j0 {
        try {
            Info infoRequestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
            if (infoRequestAdvertisingIdInfo != null) {
                return TextUtils.equals(str, infoRequestAdvertisingIdInfo.getId()) && z == infoRequestAdvertisingIdInfo.isLimitAdTrackingEnabled();
            }
            Log.w("AdIdClient", "info is null");
            return false;
        } catch (Throwable unused) {
            throw new j0("Something wrong with verification, please try later.");
        }
    }
}
