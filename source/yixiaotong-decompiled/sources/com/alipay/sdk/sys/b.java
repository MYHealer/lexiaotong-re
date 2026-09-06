package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.data.c;
import com.stub.StubApp;
import com.ta.utdid2.device.UTDevice;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f1651a;
    private Context b;

    public Context b() {
        return this.b;
    }

    private b() {
    }

    public static b a() {
        if (f1651a == null) {
            f1651a = new b();
        }
        return f1651a;
    }

    public void a(Context context, c cVar) {
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public c c() {
        return c.b();
    }

    public static boolean d() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public String e() {
        try {
            return UTDevice.getUtdid(this.b);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.e, com.alipay.sdk.app.statistic.c.k, th);
            return "";
        }
    }
}
