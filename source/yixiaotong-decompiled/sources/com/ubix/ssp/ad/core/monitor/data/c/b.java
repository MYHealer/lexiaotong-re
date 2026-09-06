package com.ubix.ssp.ad.core.monitor.data.c;

import android.content.Context;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.w.h;
import com.ubixnow.ooooo.oOOOoo00;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f8592a;
    private final c b;
    private a c;

    private b(Context context, String str) {
        this.b = c.a(str);
        this.c = new d(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static b a(Context context, String str) {
        if (f8592a == null) {
            f8592a = new b(context, str);
        }
        return f8592a;
    }

    public static b b() {
        b bVar = f8592a;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("The static method getInstance(Context context, String packageName) should be called before calling getInstance()");
    }

    public int a(String str) {
        this.c.a(this.b.a(), str);
        return this.c.b(this.b.a());
    }

    public int a(JSONObject jSONObject) {
        int iA = this.c.a(this.b.a(), jSONObject);
        return iA == 0 ? this.c.b(this.b.a()) : iA;
    }

    public void a() {
        this.c.a(this.b.a(), oOOOoo00.OooOoO);
    }

    public String[] a(String str, int i) {
        try {
            return this.c.a(this.b.a(), i);
        } catch (Exception e) {
            h.a(e);
            return null;
        }
    }

    public int c() {
        return this.c.b(this.b.a());
    }
}
