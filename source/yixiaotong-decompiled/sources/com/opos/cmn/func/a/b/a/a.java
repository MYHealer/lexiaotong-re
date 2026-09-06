package com.opos.cmn.func.a.b.a;

import com.opos.cmn.envdev.api.EnvDevConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static boolean a() {
        try {
            return EnvDevConfig.isTaphttpTestEnv();
        } catch (Throwable unused) {
            return false;
        }
    }
}
