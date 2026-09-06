package com.ubixnow.ooooo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.ubixnow.utils.myoaid.impl.huawei.AdvertisingIdClient;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class u implements j {
    private final Context OooO00o;
    private String OooO0O0;

    public class OooO00o implements a0.OooO00o {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.a0.OooO00o
        public String OooO00o(IBinder iBinder) throws RemoteException, k {
            r0 r0VarOooO00o = r0.OooO0O0.OooO00o(iBinder);
            if (r0VarOooO00o.OooO0oO()) {
                throw new k("User has disabled advertising identifier");
            }
            return r0VarOooO00o.OooOO0O();
        }
    }

    public u(Context context) {
        this.OooO00o = context;
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        Context context = this.OooO00o;
        if (context == null || iVar == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!Boolean.parseBoolean(Settings.Global.getString(this.OooO00o.getContentResolver(), "pps_track_limit"))) {
                if (TextUtils.isEmpty(string) || string.equals("00000000-0000-0000-0000-000000000000")) {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.OooO00o);
                    if (advertisingIdInfo != null) {
                        string = advertisingIdInfo.getId();
                    }
                }
                iVar.OooO00o(string);
                return;
            }
            iVar.OooO00o("00000000-0000-0000-0000-000000000000");
        } catch (Exception e) {
            l.OooO00o(e);
            if (TextUtils.isEmpty(this.OooO0O0) && !OooO00o()) {
                iVar.OooO00o(new k("Huawei Advertising ID not available"));
                return;
            }
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(this.OooO0O0);
            a0.OooO00o(this.OooO00o, intent, iVar, new OooO00o());
        }
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        Context context = this.OooO00o;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.OooO0O0 = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.OooO0O0 = "com.huawei.hwid.tv";
            } else {
                this.OooO0O0 = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            l.OooO00o(e);
            return false;
        }
    }
}
