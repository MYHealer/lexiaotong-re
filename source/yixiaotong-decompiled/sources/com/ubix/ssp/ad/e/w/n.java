package com.ubix.ssp.ad.e.w;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n extends com.ubix.ssp.ad.e.w.b {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8911a;
        final /* synthetic */ JSONObject b;

        a(String str, JSONObject jSONObject) {
            this.f8911a = str;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.a(d.TRACK, this.f8911a, this.b);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n.this.f.a();
            } catch (Exception e) {
                h.a(e);
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n.this.f.b();
            } catch (Exception e) {
                h.a(e);
            }
        }
    }

    n() {
    }

    n(Context context, i iVar) {
        super(context, iVar);
    }

    public static n a(Context context) {
        if (!com.ubix.ssp.ad.e.w.b.c() && context != null) {
            Map<Context, n> map = com.ubix.ssp.ad.e.w.b.f8893a;
            synchronized (map) {
                n nVar = map.get(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                if (nVar != null) {
                    return nVar;
                }
                h.b("-----.AbsUbixDataAPI", "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
                return new o();
            }
        }
        return new o();
    }

    private static n a(Context context, i iVar) {
        n nVar;
        if (context == null) {
            return new o();
        }
        Map<Context, n> map = com.ubix.ssp.ad.e.w.b.f8893a;
        synchronized (map) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            nVar = map.get(origApplicationContext);
            if (nVar == null) {
                nVar = new n(origApplicationContext, iVar);
                map.put(origApplicationContext, nVar);
            }
        }
        return nVar;
    }

    public static void b(Context context, i iVar) {
        if (context == null || iVar == null) {
            throw new NullPointerException("Context、UbixConfigOptions 不可以为 null");
        }
        n nVarA = a(context, iVar);
        if (nVarA.h) {
            return;
        }
        nVarA.a();
    }

    private static n j() {
        Map<Context, n> map = com.ubix.ssp.ad.e.w.b.f8893a;
        synchronized (map) {
            if (map.size() > 0) {
                Iterator<n> it = map.values().iterator();
                if (it.hasNext()) {
                    return it.next();
                }
            }
            return new o();
        }
    }

    public static n l() {
        return com.ubix.ssp.ad.e.w.b.c() ? new o() : j();
    }

    @Override // com.ubix.ssp.ad.e.w.g
    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.g = str;
            } else {
                this.g = str;
                h.b("-----.AbsUbixDataAPI", "Server url is null or empty.");
            }
        } catch (Exception e) {
            h.a(e);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            this.n.a(new a(str, jSONObject));
        } catch (Exception e) {
            h.a(e);
        }
    }

    @Override // com.ubix.ssp.ad.e.w.g
    public void a(boolean z) {
        h.b(z);
    }

    public void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("md_event", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a("SDKEvent", jSONObject);
    }

    public void e() {
        this.n.a(new b());
    }

    public void f() {
        this.n.a(new c());
    }

    public int g() {
        return com.ubix.ssp.ad.e.w.b.c.d;
    }

    public int h() {
        return com.ubix.ssp.ad.e.w.b.c.c;
    }

    public long i() {
        return com.ubix.ssp.ad.e.w.b.c.e;
    }

    public String k() {
        return this.g;
    }
}
