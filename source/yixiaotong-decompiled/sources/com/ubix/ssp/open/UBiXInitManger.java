package com.ubix.ssp.open;

import android.content.Context;
import com.stub.StubApp;
import com.ubix.ssp.open.manager.InitManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UBiXInitManger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InitManager f9053a;
    public static a b = a.ONLINE;

    public enum a {
        TEST,
        ONLINE
    }

    public static InitManager getInstance(Context context) {
        if (f9053a == null) {
            synchronized (UBiXInitManger.class) {
                if (f9053a == null) {
                    f9053a = new com.ubix.ssp.ad.e.u.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return f9053a;
    }

    public String getSdkVersion() {
        return "2.10.2.11";
    }
}
