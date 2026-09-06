package com.ubix.ssp.ad.e.w;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
abstract class b implements g {
    protected static i c;
    protected Context e;
    protected c f;
    protected String g;
    protected boolean h;
    protected com.ubix.ssp.ad.e.w.s.c i;
    protected boolean j;
    protected boolean k;
    protected boolean l;
    protected boolean m;
    protected l n;
    protected m o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Map<Context, n> f8893a = new HashMap();
    static boolean b = false;
    protected static boolean d = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ubix.ssp.ad.e.w.s.b.a(b.this.e);
        }
    }

    protected b() {
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = false;
        this.e = null;
        this.f = null;
    }

    public b(Context context, i iVar) {
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = false;
        this.e = context;
        try {
            String packageName = context.getPackageName();
            c = iVar.clone();
            this.n = l.a();
            this.o = new m();
            new Thread(this.o, "Ubix.TaskQueueThread").start();
            p.b();
            a(c.f8892a, packageName);
            this.i = new com.ubix.ssp.ad.e.w.s.c(this.e, this.m);
            this.f = c.a(this.e, (n) this);
            d();
            h.a();
        } catch (Throwable th) {
            h.a("-----.AbsUbixDataAPI", th.getMessage());
        }
    }

    private void b(d dVar, String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(str, jSONObject);
        this.f.a(dVar.a(), jSONObject2);
    }

    private static boolean b() {
        i iVar = c;
        if (iVar != null) {
            return iVar.i;
        }
        h.b("-----.AbsUbixDataAPI", "SAConfigOptions is null");
        return true;
    }

    public static boolean c() {
        return b();
    }

    protected void a() {
        if (c.b) {
            p.a();
        }
        i iVar = c;
        if (iVar.j) {
            a(iVar.g);
        }
    }

    protected void a(d dVar, String str, JSONObject jSONObject) {
        try {
            b(dVar, str, jSONObject);
        } catch (Exception e) {
            h.a(e);
        }
    }

    protected void a(String str, String str2) {
        if (c == null) {
            this.h = false;
            c = new i(str);
        } else {
            this.h = true;
        }
        com.ubix.ssp.ad.core.monitor.data.c.b.a(this.e, str2);
        this.n.a(c.f);
        i iVar = c;
        if (iVar.j) {
            a(iVar.g);
        }
        h.a(c.i);
        a(str);
        if (c.b) {
            p.a();
        }
        i iVar2 = c;
        if (iVar2.e == 0) {
            iVar2.a(33554432L);
        }
        if (c.i) {
            this.j = false;
            d = true;
        }
    }

    void d() {
        this.n.a(new a());
    }
}
