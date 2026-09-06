package com.ubix.ssp.ad.e.w;

import android.content.Context;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.u;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f8899a = null;
    public static int b = 15;
    public static int c = 15;
    public static int d;
    private Context e;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f8900a;

        a(HashMap map) {
            this.f8900a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8900a.remove("EVENT_STATUS_CODE");
            this.f8900a.remove("EVENT_STATUS_MSG");
            f.this.a(j.RequestStart, this.f8900a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f8901a;

        b(HashMap map) {
            this.f8901a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8901a.remove("EVENT_STATUS_CODE");
            this.f8901a.remove("EVENT_STATUS_MSG");
            f.this.a(j.RequestSuccess, this.f8901a);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f8902a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        c(HashMap map, int i, String str) {
            this.f8902a = map;
            this.b = i;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap map = this.f8902a;
            StringBuilder sb = new StringBuilder();
            j jVar = j.RequestFail;
            map.put("EVENT_STATUS_CODE", sb.append(jVar.a()).append(this.b).toString());
            this.f8902a.put("EVENT_STATUS_MSG", this.c);
            f.this.a(jVar, this.f8902a);
        }
    }

    private f(Context context) {
        this.e = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static e a(Context context) {
        e eVar = f8899a;
        if (eVar != null) {
            return eVar;
        }
        f fVar = new f(context);
        f8899a = fVar;
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, Map<String, Object> map) {
        Object obj;
        try {
            if (d == 0 || map == null || !a(jVar)) {
                return;
            }
            if (map.containsKey("EVENT_AD_TYPE") && "4".equals("" + map.get("EVENT_AD_TYPE"))) {
                return;
            }
            com.ubix.ssp.ad.e.y.b.a aVar = new com.ubix.ssp.ad.e.y.b.a();
            try {
                aVar.c = map.containsKey("EVENT_TIME") ? Long.parseLong(map.get("EVENT_TIME") + "") : System.currentTimeMillis();
            } catch (Exception unused) {
                aVar.c = System.currentTimeMillis();
            }
            aVar.e = jVar.b();
            aVar.d = UUID.randomUUID().toString().replace(x.A, "");
            if (map.containsKey("EVENT_SLOT_ID")) {
                aVar.f = map.get("EVENT_SLOT_ID") + "";
            }
            if (map.containsKey("EVENT_AD_TYPE")) {
                aVar.g = map.get("EVENT_AD_TYPE") + "";
            }
            if (map.containsKey("EVENT_REQUEST_ID")) {
                aVar.h = map.get("EVENT_REQUEST_ID") + "";
            }
            aVar.i = map.containsKey("EVENT_STATUS_CODE") ? map.get("EVENT_STATUS_CODE") + "" : jVar.a();
            if (map.containsKey("EVENT_STATUS_MSG")) {
                aVar.j = map.get("EVENT_STATUS_MSG") + "";
            }
            if (jVar.d() && map.containsKey("EVENT_DURATION")) {
                aVar.k = map.get("EVENT_DURATION") + "";
            }
            if (map.containsKey("EVENT_BID_CPM")) {
                aVar.l = map.get("EVENT_BID_CPM") + "";
            }
            if (map.containsKey("EVENT_MATERIAL_ID")) {
                aVar.m = map.get("EVENT_MATERIAL_ID") + "";
            }
            if (map.containsKey("EVENT_CREATIVE_URL")) {
                aVar.n = map.get("EVENT_CREATIVE_URL") + "";
            }
            if (map.containsKey("EVENT_CODE_ERROR")) {
                aVar.o = map.get("EVENT_CODE_ERROR") + "";
            }
            if (map.containsKey("EVENT_ATTRS") && (obj = map.get("EVENT_ATTRS")) != null) {
                aVar.p = (Map) obj;
            }
            u.b("trace eventName=" + jVar.b());
            String strB = com.ubix.ssp.ad.e.a0.n.b().b(com.ubix.ssp.ad.e.y.c.f.a(aVar));
            u.b(aVar.toString());
            n.l().b(strB);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(j jVar) {
        if (d == 0) {
            return false;
        }
        int iC = jVar.c();
        return (d & iC) == iC;
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void a() {
        i iVar = new i(com.ubix.ssp.ad.e.x.f.f());
        iVar.b();
        iVar.a(false);
        iVar.a(b);
        iVar.b(c * 1000);
        n.b(com.ubix.ssp.ad.e.a0.c.e(), iVar);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void a(int i, String str) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        j jVar = j.LaunchNetFail;
        map.put("EVENT_STATUS_CODE", sb.append(jVar.a()).append(i).toString());
        map.put("EVENT_STATUS_MSG", str);
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void a(long j) {
        HashMap map = new HashMap();
        map.put("EVENT_DURATION", Long.valueOf(j));
        a(j.LaunchLocalSuccess, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void a(j jVar, HashMap<String, Object> map, String str, String str2) {
        map.put("EVENT_STATUS_CODE", j.Monitor.a() + str);
        map.put("EVENT_STATUS_MSG", str2);
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void a(HashMap<String, Object> map) {
        com.ubix.ssp.ad.e.a0.c.y();
        com.ubix.ssp.ad.e.a0.c.d.execute(new a(map));
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void a(HashMap<String, Object> map, int i, String str) {
        StringBuilder sb = new StringBuilder();
        j jVar = j.FilledFail;
        map.put("EVENT_STATUS_CODE", sb.append(jVar.a()).append(i).toString());
        map.put("EVENT_STATUS_MSG", str);
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void a(HashMap<String, Object> map, String str) {
        map.remove("EVENT_STATUS_CODE");
        map.put("EVENT_STATUS_MSG", str);
        a(j.ClickTarget, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void a(HashMap<String, Object> map, String str, String str2) {
        map.put("EVENT_STATUS_CODE", str);
        map.put("EVENT_STATUS_MSG", str2);
        a(j.Feedback, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void b(int i, String str) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        j jVar = j.LaunchLocalFail;
        map.put("EVENT_STATUS_CODE", sb.append(jVar.a()).append(i).toString());
        map.put("EVENT_STATUS_MSG", str);
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void b(long j) {
        HashMap map = new HashMap();
        map.put("EVENT_TIME", Long.valueOf(j));
        a(j.LaunchStart, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void b(HashMap<String, Object> map) {
        j jVar = j.ClickRepeat;
        map.put("EVENT_STATUS_CODE", jVar.a());
        map.put("EVENT_STATUS_MSG", "广告重复点击");
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void b(HashMap<String, Object> map, int i, String str) {
        StringBuilder sb = new StringBuilder();
        j jVar = j.ShowFail;
        map.put("EVENT_STATUS_CODE", sb.append(jVar.a()).append(i).toString());
        map.put("EVENT_STATUS_MSG", str);
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void b(HashMap<String, Object> map, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        j jVar = j.Monitor;
        map.put("EVENT_STATUS_CODE", sb.append(jVar.a()).append(str).toString());
        map.put("EVENT_STATUS_MSG", str2);
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void c(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.DetectSuccess, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void c(HashMap<String, Object> map, int i, String str) {
        com.ubix.ssp.ad.e.a0.c.y();
        com.ubix.ssp.ad.e.a0.c.d.execute(new c(map, i, str));
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void d(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.ClickSuccess, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void d(HashMap<String, Object> map, int i, String str) {
        StringBuilder sb = new StringBuilder();
        j jVar = j.RenderFail;
        map.put("EVENT_STATUS_CODE", sb.append(jVar.a()).append(i).toString());
        map.put("EVENT_STATUS_MSG", str);
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void e(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.ResponseSuccess, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void e(HashMap<String, Object> map, int i, String str) {
        StringBuilder sb = new StringBuilder();
        j jVar = j.ResponseFail;
        map.put("EVENT_STATUS_CODE", sb.append(jVar.a()).append(i).toString());
        map.put("EVENT_STATUS_MSG", str);
        a(jVar, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void f(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.RenderStart, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void g(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.ShowStart, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void h(HashMap<String, Object> map) {
        com.ubix.ssp.ad.e.a0.c.y();
        com.ubix.ssp.ad.e.a0.c.d.execute(new b(map));
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void i(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.ClickDelaySuccess, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void j(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.AppList, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void k(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.ShowSuccess, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void l(HashMap<String, Object> map) {
        a(j.Crash, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void m(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.FilledSuccess, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void n(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.RenderSuccess, map);
    }

    @Override // com.ubix.ssp.ad.e.w.e
    public void o(HashMap<String, Object> map) {
        map.remove("EVENT_STATUS_CODE");
        map.remove("EVENT_STATUS_MSG");
        a(j.ClickDelayStart, map);
    }
}
