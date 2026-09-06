package com.hihonor.secure.android.common.ssl.util;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static Context k;

    public static Context k() {
        return k;
    }

    public static void setContext(Context context) {
        if (context == null || k != null) {
            return;
        }
        k = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
