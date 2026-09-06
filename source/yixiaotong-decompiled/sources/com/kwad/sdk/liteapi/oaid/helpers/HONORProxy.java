package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HONORProxy {
    public c info;
    public Context mContext;
    public final a mBinderOne = new a();
    public final b mBinderTwo = new b();
    public final CountDownLatch mCountDownLatch = new CountDownLatch(2);

    public static final class c {
        public boolean aUJ;
        public String id;
    }

    public class a extends HONORProxyInterface.a {
        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public final void a(int i, long j, boolean z, float f, double d, String str) {
        }

        public a() {
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public final void a(int i, Bundle bundle) {
            LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult retCode = " + i + " retInfo = " + bundle);
            if (i == 0) {
                try {
                    c cVar = HONORProxy.this.info;
                    if (cVar != null) {
                        cVar.id = bundle.getString("oa_id_flag");
                        LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult success");
                    }
                } catch (Throwable th) {
                    LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult error: " + th.getMessage());
                    return;
                }
            }
            HONORProxy.countDown(HONORProxy.this);
        }
    }

    public class b extends HONORProxyInterface.a {
        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public final void a(int i, long j, boolean z, float f, double d, String str) {
        }

        public b() {
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public final void a(int i, Bundle bundle) {
            LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult retCode=" + i + " retInfo= " + bundle);
            if (i == 0) {
                try {
                    if (HONORProxy.this.info != null) {
                        boolean z = bundle.getBoolean("oa_id_limit_state");
                        HONORProxy.this.info.aUJ = z;
                        LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult success  isLimit=" + z);
                    }
                } catch (Throwable th) {
                    LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult error:  " + th.getMessage());
                    return;
                }
            }
            HONORProxy.countDown(HONORProxy.this);
        }
    }

    public boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception unused) {
        }
    }

    public static void countDown(HONORProxy hONORProxy) {
        try {
            hONORProxy.mCountDownLatch.countDown();
        } catch (Exception e) {
            LiteApiLogger.d("HONORDeviceIDHelper", "doCountDown  error:  " + e.getMessage());
        }
    }
}
