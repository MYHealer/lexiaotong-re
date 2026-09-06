package com.adprof.sdk;

import com.adprof.sdk.api.AdprofSdkConfig;
import com.adprof.sdk.api.CustomController;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class v7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static v7 f1473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u7 f763a;

    public static CustomController a(v7 v7Var) {
        v7Var.getClass();
        AdprofSdkConfig sdkConfig = AdprofSdk.getInstance().getSdkConfig();
        if (sdkConfig != null) {
            return sdkConfig.customController;
        }
        return null;
    }

    public static v7 a() {
        if (f1473a == null) {
            synchronized (v7.class) {
                if (f1473a == null) {
                    f1473a = new v7();
                }
            }
        }
        return f1473a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public u7 m721a() {
        u7 u7Var = this.f763a;
        if (u7Var != null) {
            return u7Var;
        }
        u7 u7Var2 = new u7(this);
        this.f763a = u7Var2;
        return u7Var2;
    }
}
