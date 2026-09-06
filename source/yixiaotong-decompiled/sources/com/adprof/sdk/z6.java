package com.adprof.sdk;

import com.adprof.sdk.api.CustomController;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class z6 {
    public static CustomController a() {
        try {
            if (AdprofSdk.getInstance() == null || AdprofSdk.getInstance().getSdkConfig() == null) {
                return null;
            }
            return AdprofSdk.getInstance().getSdkConfig().customController;
        } catch (Throwable th) {
            pk.b("read customController error", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m736a() {
        CustomController customControllerA = a();
        return customControllerA == null || customControllerA.canUseSensor();
    }
}
