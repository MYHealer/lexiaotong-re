package com.yfanads.android.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.ez;
import com.yfanads.android.oaid.repackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: HuaweiImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class h implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9664a;
    public String b;

    public h(Context context) {
        this.f9664a = context;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void b(com.yfanads.android.oaid.ifs.a aVar) {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        n.a(this.f9664a, intent, aVar, new n.a() { // from class: com.yfanads.android.oaid.impl.h$$ExternalSyntheticLambda1
            @Override // com.yfanads.android.oaid.impl.n.a
            public final String a(IBinder iBinder) {
                return h.a(iBinder);
            }
        });
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.f9664a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
                return true;
            }
            if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
                return true;
            }
            this.b = "com.huawei.hms";
            return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
        } catch (Exception e) {
            Log.e("OAID", "supported " + e.getMessage());
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(final com.yfanads.android.oaid.ifs.a aVar) {
        Context context = this.f9664a;
        if (context != null) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(this.f9664a.getContentResolver(), "pps_track_limit");
                Log.i("OAID", "doGet oaid:" + string + ",limit:" + string2);
                if (ez.Code.equalsIgnoreCase(string2)) {
                    aVar.onOAIDGetFail(new com.yfanads.android.oaid.a("User has disabled advertising identifier"));
                } else if (!TextUtils.isEmpty(string)) {
                    Log.i("OAID", "Get oaid from global settings: " + string);
                    aVar.onOAIDGetSuccess(string);
                } else {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.yfanads.android.oaid.impl.h$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.b(aVar);
                        }
                    });
                }
            } catch (Exception e) {
                Log.e("OAID", "supported " + e.getMessage());
                aVar.onOAIDGetFail(e);
            }
        }
    }

    public static /* synthetic */ String a(IBinder iBinder) throws com.yfanads.android.oaid.a, RemoteException {
        OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
        if (!openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
            return openDeviceIdentifierServiceAsInterface.getOaid();
        }
        throw new com.yfanads.android.oaid.a("User has disabled advertising identifier");
    }
}
