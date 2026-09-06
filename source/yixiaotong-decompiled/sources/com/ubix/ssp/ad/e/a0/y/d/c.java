package com.ubix.ssp.ad.e.a0.y.d;

import android.app.Instrumentation;
import android.content.Context;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.n;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.w.f;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f8737a;
    private boolean b;
    private final String c = new String(n.a().a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ="));
    private final String d = new String(n.a().a("c0N1cnJlbnRBY3Rpdml0eVRocmVhZA=="));
    private final String e = new String(n.a().a("bUluc3RydW1lbnRhdGlvbg=="));

    private c() {
    }

    public static c a() {
        if (f8737a == null) {
            f8737a = new c();
        }
        return f8737a;
    }

    public void a(Context context) {
        try {
            if (b()) {
                return;
            }
            Class<?> cls = Class.forName(this.c);
            Field declaredField = cls.getDeclaredField(this.d);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField(this.e);
            declaredField2.setAccessible(true);
            declaredField2.set(obj, new b((Instrumentation) declaredField2.get(obj)));
            u.e("guard", DebugKt.DEBUG_PROPERTY_VALUE_ON);
            this.b = true;
            f.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).b(new HashMap<>(), "09000", "succ");
        } catch (Exception e) {
            this.b = false;
            if (u.a()) {
                e.printStackTrace();
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("EVENT_CODE_ERROR", e.getMessage());
            f.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).b(map, "09000", "fail");
        }
    }

    public boolean b() {
        return this.b;
    }
}
