package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f4554a;

    public static Context a() {
        return f4554a;
    }

    public static void a(Context context) {
        if (context == null || f4554a != null) {
            return;
        }
        f4554a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
