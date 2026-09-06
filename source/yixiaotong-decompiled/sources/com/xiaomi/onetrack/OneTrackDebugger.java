package com.xiaomi.onetrack;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import com.xiaomi.onetrack.util.o;
import com.xiaomi.onetrack.util.oaid.a;
import ijiami_1011.s.s.s;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OneTrackDebugger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile OneTrackDebugger f9385a;
    private static String b = s.d(new byte[]{90, 12, 85, Ascii.ESC, 65, 15, 0, 11, 11, 11, Ascii.US, 10, 87, 6, 76, 71, 88, 5, 10, 74, 9, Ascii.SYN, 85, 0, 91, Ascii.SYN, 95, 82, 92, Ascii.DC4, 79, 34, 10, 13, 80, 17, 110, 10, 86, 81, 86, 17, 50, 1, Ascii.DC4, Ascii.DC4, 88, 6, 92}, "9c859f");
    private ConcurrentHashMap<Long, Configuration> c = new ConcurrentHashMap<>();

    private OneTrackDebugger() {
    }

    public static OneTrackDebugger getInstance() {
        if (f9385a == null) {
            synchronized (OneTrackDebugger.class) {
                if (f9385a == null) {
                    f9385a = new OneTrackDebugger();
                }
            }
        }
        return f9385a;
    }

    public String getInstanceId() {
        return o.a().b();
    }

    public String getOaid(Context context) {
        return a.a().a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public ConcurrentHashMap<Long, Configuration> getSdkConfig() {
        return this.c;
    }

    public void setSdkConfig(Configuration configuration) {
        this.c.put(Long.valueOf(System.currentTimeMillis()), configuration);
    }

    public void startDebugger() {
        try {
            com.xiaomi.onetrack.f.a.b().startService(new Intent(com.xiaomi.onetrack.f.a.b(), Class.forName(b)));
        } catch (Throwable th) {
            Log.d(s.d(new byte[]{75, 77, 5, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 34, 4, 6, 19, 5, 86, 0, 74}, "89df4f"), th.getMessage());
        }
    }
}
