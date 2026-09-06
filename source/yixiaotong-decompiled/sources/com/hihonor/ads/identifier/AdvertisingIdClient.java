package com.hihonor.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdvertisingIdClient {

    public static final class Info {
        public String id;
        public boolean isLimit;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        Info info;
        StringBuilder sb;
        a aVar = new a();
        aVar.b = context;
        com.hihonor.cloudservice.oaid.b c0474a = null;
        try {
            Log.i("AdvertisingIdPlatform", "1.0.3.300 getCache start");
            String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
            String string2 = Settings.Global.getString(context.getContentResolver(), "oaid");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                Log.i("AdvertisingIdPlatform", "getCache from sec");
                string = Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state");
                string2 = Settings.Secure.getString(context.getContentResolver(), "oaid");
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                info = null;
            } else {
                boolean z = Boolean.parseBoolean(string);
                info = new Info();
                info.isLimit = z;
                info.id = string2;
                Log.i("AdvertisingIdPlatform", "getAdvertisingIdInfo cache success");
            }
        } catch (Throwable th) {
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo cache error=" + th);
        }
        if (info != null) {
            return info;
        }
        if (!aVar.a(context)) {
            throw new IOException("Service not found or advertisingId not available");
        }
        Log.i("AdvertisingIdPlatform", "bindService start");
        b bVar = new b();
        try {
            try {
                Intent intent = new Intent();
                intent.setAction("com.hihonor.id.HnOaIdService");
                intent.setPackage("com.hihonor.id");
                if (context.bindService(intent, bVar, 1)) {
                    Log.i("AdvertisingIdPlatform", "bind success,start get oaid");
                    aVar.f3492a = new Info();
                    IBinder iBinderA = bVar.a();
                    int i = com.hihonor.cloudservice.oaid.b.a.f3589a;
                    if (iBinderA != null) {
                        IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                        c0474a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.hihonor.cloudservice.oaid.b)) ? new com.hihonor.cloudservice.oaid.b.a.C0474a(iBinderA) : (com.hihonor.cloudservice.oaid.b) iInterfaceQueryLocalInterface;
                    }
                    c0474a.b(aVar.c);
                    c0474a.a(aVar.d);
                }
                aVar.e.await(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MILLISECONDS);
                Log.i("AdvertisingIdPlatform", "unbindService");
                try {
                    aVar.b.unbindService(bVar);
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder("OAIDClientImpl#unbindService error::");
                    Log.e("AdvertisingIdPlatform", sb.append(e.getMessage()).toString());
                }
            } catch (Throwable th2) {
                Log.i("AdvertisingIdPlatform", "unbindService");
                try {
                    aVar.b.unbindService(bVar);
                } catch (Exception e2) {
                    Log.e("AdvertisingIdPlatform", "OAIDClientImpl#unbindService error::" + e2.getMessage());
                }
                aVar.a();
                throw th2;
            }
        } catch (Exception e3) {
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e3.getMessage() + " : " + e3.getClass().getSimpleName());
            Log.i("AdvertisingIdPlatform", "unbindService");
            try {
                aVar.b.unbindService(bVar);
            } catch (Exception e4) {
                e = e4;
                sb = new StringBuilder("OAIDClientImpl#unbindService error::");
                Log.e("AdvertisingIdPlatform", sb.append(e.getMessage()).toString());
            }
        }
        aVar.a();
        return aVar.f3492a;
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        return new a().a(context);
    }
}
