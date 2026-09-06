package com.xiaomi.onetrack.f;

import android.content.Context;
import com.google.common.base.Ascii;
import com.stub.StubApp;
import com.xiaomi.onetrack.util.i;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9496a = s.d(new byte[]{41, 12, 92, 96, 19, 85, 2, 15, 39, Ascii.DC2, 65}, "fb94a4");
    private static g b;

    private g(Context context) {
        i.a(new h(this, StubApp.getOrigApplicationContext(context.getApplicationContext())));
    }

    public static void a(Context context) {
        if (b == null) {
            b = new g(context);
        }
    }
}
