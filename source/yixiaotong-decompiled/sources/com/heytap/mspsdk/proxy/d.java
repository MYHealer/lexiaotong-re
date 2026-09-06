package com.heytap.mspsdk.proxy;

import android.os.Bundle;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.log.MspLog;
import com.opos.process.bridge.client.BaseActivityClient;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.client.BaseServiceClient;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3474a;
    public final Method b;
    public final Object[] c;
    public final com.heytap.mspsdk.core.b d;
    public final com.heytap.mspsdk.event.a e;
    public Bundle f;

    public d(Object obj, Method method, Object[] objArr, com.heytap.mspsdk.core.b bVar, Bundle bundle, com.heytap.mspsdk.event.a aVar) {
        this.f3474a = obj;
        this.b = method;
        this.c = objArr;
        this.d = bVar;
        this.e = aVar;
        this.f = a(bundle);
    }

    private Bundle b(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.BUNDLE_KEY_MSP_SDK_VERSION_CODE, 2000107);
        bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_VERSION_NAME, "2.0.1.7");
        bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_CALLING_PKG, com.heytap.mspsdk.core.e.a().b().getPackageName());
        bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME, str);
        bundle.putBundle(Constants.BUNDLE_KEY_MSP_SDK_IPC_TIME_RECORDER, new Bundle());
        return bundle;
    }

    private Bundle c() {
        Bundle bundle = this.f;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(Constants.BUNDLE_KEY_MSP_SDK_COMMON_BUNDLE);
        if (bundle2 == null) {
            MspLog.e("InvokeRequest", "commBundle is null");
            return null;
        }
        Bundle bundle3 = bundle2.getBundle(Constants.BUNDLE_KEY_MSP_SDK_IPC_TIME_RECORDER);
        if (bundle3 == null) {
            MspLog.e("InvokeRequest", "timeRecorderBundle is null");
        }
        return bundle3;
    }

    public Bundle a() {
        return this.f;
    }

    public Bundle a(Bundle bundle) {
        if (bundle == null) {
            bundle = b();
        }
        bundle.putBundle(Constants.BUNDLE_KEY_MSP_SDK_COMMON_BUNDLE, b(bundle.getString(Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME)));
        return bundle;
    }

    public void a(String str) {
        try {
            Bundle bundleC = c();
            if (bundleC != null) {
                bundleC.putLong(str, System.currentTimeMillis());
            } else {
                MspLog.e("InvokeRequest", "timeRecorderBundle is null");
            }
        } catch (Throwable th) {
            MspLog.e(th);
        }
    }

    public Bundle b() {
        Object obj = this.f3474a;
        if (obj instanceof BaseProviderClient) {
            return ((BaseProviderClient) obj).getData();
        }
        if (obj instanceof BaseServiceClient) {
            return ((BaseServiceClient) obj).getData();
        }
        return obj instanceof BaseActivityClient ? ((BaseActivityClient) obj).getData() : new Bundle();
    }
}
