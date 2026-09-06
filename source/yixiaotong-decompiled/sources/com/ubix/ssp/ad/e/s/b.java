package com.ubix.ssp.ad.e.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.stub.StubApp;
import com.ubix.ssp.ad.d.l;
import com.ubix.ssp.ad.e.a0.g;
import com.ubix.ssp.ad.e.a0.m;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.w.k;
import com.ubix.ssp.open.comm.DownloadService;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f8849a;
    public static volatile ConcurrentHashMap<String, com.ubix.ssp.ad.d.a> b = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, com.ubix.ssp.ad.d.a> c = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, com.ubix.ssp.ad.e.s.g.c> d = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, DownloadService.DownloadBinder> e = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Integer> f = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, g> g = new ConcurrentHashMap<>();
    public String h;
    private c i;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.s.g.c f8850a;
        final /* synthetic */ Intent b;
        final /* synthetic */ int c;

        a(com.ubix.ssp.ad.e.s.g.c cVar, Intent intent, int i) {
            this.f8850a = cVar;
            this.b = intent;
            this.c = i;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DownloadService.DownloadBinder downloadBinder = (DownloadService.DownloadBinder) iBinder;
            this.f8850a.a(downloadBinder);
            downloadBinder.runTask(this.b);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.e.remove(Integer.valueOf(this.c));
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.s.b$b, reason: collision with other inner class name */
    class C1094b implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8851a;
        final /* synthetic */ com.ubix.ssp.ad.d.a b;
        final /* synthetic */ Context c;
        final /* synthetic */ String d;
        final /* synthetic */ com.ubix.ssp.ad.e.y.a.a.c e;

        C1094b(String str, com.ubix.ssp.ad.d.a aVar, Context context, String str2, com.ubix.ssp.ad.e.y.a.a.c cVar) {
            this.f8851a = str;
            this.b = aVar;
            this.c = context;
            this.d = str2;
            this.e = cVar;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0051  */
        /* JADX WARN: Code duplicated, block: B:15:0x007b  */
        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a() {
            b bVar;
            Context origApplicationContext;
            com.ubix.ssp.ad.d.a aVar;
            boolean z;
            u.e("CountDownTool onFinish time");
            b.g.remove(this.f8851a);
            com.ubix.ssp.ad.e.y.a.a.b bVar2 = this.b.f8604a.d;
            if (bVar2 != null && !TextUtils.isEmpty(bVar2.R)) {
                com.ubix.ssp.ad.e.a0.f fVar = new com.ubix.ssp.ad.e.a0.f(new l(), new HashMap());
                com.ubix.ssp.ad.e.y.a.a aVar2 = this.b.f8604a;
                int iA = fVar.a(aVar2, aVar2.d.R);
                if (iA == 2 || iA == 22) {
                    bVar = b.this;
                    origApplicationContext = StubApp.getOrigApplicationContext(this.c.getApplicationContext());
                    aVar = this.b;
                    z = true;
                } else {
                    b.c().a(StubApp.getOrigApplicationContext(this.c.getApplicationContext()), this.f8851a, this.d, -1, true);
                    bVar = b.this;
                    origApplicationContext = StubApp.getOrigApplicationContext(this.c.getApplicationContext());
                    aVar = this.b;
                    z = false;
                }
            } else if (com.ubix.ssp.ad.e.a0.c.a(this.f8851a, com.ubix.ssp.ad.e.a0.c.a(this.e))) {
                bVar = b.this;
                origApplicationContext = StubApp.getOrigApplicationContext(this.c.getApplicationContext());
                aVar = this.b;
                z = true;
            } else {
                b.c().a(StubApp.getOrigApplicationContext(this.c.getApplicationContext()), this.f8851a, this.d, -1, true);
                bVar = b.this;
                origApplicationContext = StubApp.getOrigApplicationContext(this.c.getApplicationContext());
                aVar = this.b;
                z = false;
            }
            bVar.a(origApplicationContext, aVar, "delay", z);
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a(long j) {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void b() {
            u.e("CountDownTool onTerminal time");
        }
    }

    private b() {
        c cVarA = c.a();
        this.i = cVarA;
        if (cVarA != null) {
            cVarA.a(com.ubix.ssp.ad.e.a0.c.e());
        }
    }

    private com.ubix.ssp.ad.e.s.g.c a(String str, File file, String str2, int i, int i2) {
        com.ubix.ssp.ad.e.s.g.c cVar = new com.ubix.ssp.ad.e.s.g.c();
        cVar.a(i);
        cVar.b(i2);
        cVar.a(new com.ubix.ssp.ad.e.s.g.a(str, file, str2, i));
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, com.ubix.ssp.ad.d.a aVar, String str, boolean z) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap map2 = new HashMap();
        map.put("EVENT_REQUEST_ID", aVar.d);
        map.put("EVENT_SLOT_ID", aVar.g);
        map2.put("ubix_tx_type", str);
        map.put("EVENT_ATTRS", map2);
        com.ubix.ssp.ad.e.w.f.a(context).b(map, z ? "04010" : "04011", "");
    }

    private void a(Context context, com.ubix.ssp.ad.e.s.g.c cVar, int i, int i2) {
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("service_intent_notify_id", i);
        intent.putExtra("service_intent_unique_id", i2);
        context.bindService(intent, new a(cVar, intent, i), 1);
    }

    private void a(Context context, String str, File file, String str2, int i) {
        try {
            int iHashCode = str.hashCode();
            com.ubix.ssp.ad.e.s.g.c cVar = d.get(Integer.valueOf(str.hashCode()));
            f.put(Integer.valueOf(i), Integer.valueOf(iHashCode));
            if (cVar == null) {
                com.ubix.ssp.ad.e.s.g.c cVarA = a(str, file, str2, i, iHashCode);
                d.put(Integer.valueOf(str.hashCode()), cVarA);
                a(context, cVarA, i, iHashCode);
                return;
            }
            if (cVar.a() == null) {
                a(context, cVar, i, iHashCode);
                return;
            }
            Intent intent = new Intent(context, (Class<?>) DownloadService.class);
            intent.putExtra("service_intent_notify_id", i);
            intent.putExtra("service_intent_unique_id", iHashCode);
            intent.putExtra("service_intent_fellow_notify_ids", iHashCode);
            if (!file.exists()) {
                cVar.b().b().a(0L);
                cVar.b().b().b(47);
            }
            if (cVar.b().b().b() == 46) {
                intent.setAction("ACTION_COMPLETE");
            } else {
                if (cVar.b().b().b() != 44) {
                    cVar.a().runTask(intent);
                }
                intent.setAction("ACTION_BIND");
            }
            m.a(context).a(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static d c() {
        if (f8849a == null) {
            synchronized (b.class) {
                if (f8849a == null) {
                    f8849a = new b();
                }
            }
        }
        return f8849a;
    }

    private int d(int i) {
        Integer num;
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(Integer.valueOf(i)) || (num = f.get(Integer.valueOf(i))) == null) {
            return -1;
        }
        return num.intValue();
    }

    public static ConcurrentHashMap<Integer, com.ubix.ssp.ad.d.a> d() {
        return c;
    }

    @Override // com.ubix.ssp.ad.e.s.d
    public com.ubix.ssp.ad.e.s.g.c a(int i) {
        if (i == -1) {
            return null;
        }
        try {
            Integer num = f.get(Integer.valueOf(i));
            if (num != null) {
                return d.get(num);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    @Override // com.ubix.ssp.ad.e.s.d
    public void a(Context context, int i) {
        com.ubix.ssp.ad.e.s.g.c cVarA;
        try {
            int iD = d(i);
            if (iD == -1 || (cVarA = a(i)) == null) {
                return;
            }
            cVarA.a().pauseTask(i, iD);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.e.s.d
    public void a(Context context, com.ubix.ssp.ad.e.s.g.b bVar, int i, int i2) {
        u.b("dealInstall" + i + ";" + i2);
        try {
            if (TextUtils.isEmpty(com.ubix.ssp.ad.e.a0.c.a(context, bVar.e()))) {
                u.a("file is not a valid apk");
                bVar.b(47);
                bVar.a(0L);
            } else if (bVar.b() == 46) {
                com.ubix.ssp.ad.d.a aVar = d().get(Integer.valueOf(i));
                String strA = com.ubix.ssp.ad.e.a0.c.a(context, bVar.e());
                if (!TextUtils.isEmpty(strA) && !b.containsKey(strA)) {
                    b.put(strA, aVar);
                }
                a(context, strA, bVar.e(), i2, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00ad A[Catch: all -> 0x0120, TryCatch #0 {all -> 0x0120, blocks: (B:15:0x0048, B:17:0x004c, B:19:0x0052, B:36:0x0082, B:38:0x0088, B:40:0x0090, B:47:0x00b7, B:49:0x00cd, B:51:0x00e2, B:53:0x00e9, B:55:0x00f1, B:56:0x0112, B:58:0x011c, B:48:0x00c3, B:45:0x00ad, B:34:0x007d), top: B:63:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7 A[Catch: all -> 0x0120, TryCatch #0 {all -> 0x0120, blocks: (B:15:0x0048, B:17:0x004c, B:19:0x0052, B:36:0x0082, B:38:0x0088, B:40:0x0090, B:47:0x00b7, B:49:0x00cd, B:51:0x00e2, B:53:0x00e9, B:55:0x00f1, B:56:0x0112, B:58:0x011c, B:48:0x00c3, B:45:0x00ad, B:34:0x007d), top: B:63:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c3 A[Catch: all -> 0x0120, TryCatch #0 {all -> 0x0120, blocks: (B:15:0x0048, B:17:0x004c, B:19:0x0052, B:36:0x0082, B:38:0x0088, B:40:0x0090, B:47:0x00b7, B:49:0x00cd, B:51:0x00e2, B:53:0x00e9, B:55:0x00f1, B:56:0x0112, B:58:0x011c, B:48:0x00c3, B:45:0x00ad, B:34:0x007d), top: B:63:0x0048 }] */
    @Override // com.ubix.ssp.ad.e.s.d
    public void a(Context context, String str, com.ubix.ssp.ad.d.a aVar, String str2, String str3) {
        boolean zOptBoolean;
        Context origApplicationContext;
        boolean z = true;
        if (aVar != null && aVar.f8604a.d != null) {
            HashMap<String, String> map = new HashMap<>();
            com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
            if (bVar.l == 1 && bVar.d == 4) {
                map.put("__CLICK_ID__", this.h);
            }
            if (com.ubix.ssp.ad.e.a0.c.g(str)) {
                k.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(aVar.f8604a.d, map, 304);
            }
        }
        if (aVar != null) {
            try {
                com.ubix.ssp.ad.e.y.a.a aVar2 = aVar.f8604a;
                if (aVar2 == null || aVar.e == 9) {
                    return;
                }
                com.ubix.ssp.ad.e.y.a.a.c cVar = aVar2.f;
                int iMax = 20;
                try {
                    JSONObject jSONObject = new JSONObject(cVar.q);
                    zOptBoolean = jSONObject.has("delay_dp_enable") ? jSONObject.optBoolean("delay_dp_enable", false) : false;
                    try {
                        if (jSONObject.has("delay_dp_time")) {
                            iMax = Math.max(jSONObject.optInt("delay_dp_time", 20), 0);
                        }
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zOptBoolean = false;
                }
                if (zOptBoolean) {
                    com.ubix.ssp.ad.e.y.a.a.b bVar2 = aVar.f8604a.d;
                    if (bVar2 != null) {
                        String str4 = bVar2.R;
                        if (!TextUtils.isEmpty(str4)) {
                            int iA = new com.ubix.ssp.ad.e.a0.f(new l(), new HashMap()).a(aVar.f8604a, str4);
                            if (iA == 2 || iA == 22) {
                                origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            } else {
                                origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                                z = false;
                            }
                        } else if (com.ubix.ssp.ad.e.a0.c.a(str, com.ubix.ssp.ad.e.a0.c.a(cVar))) {
                            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                        } else {
                            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            z = false;
                        }
                    } else if (com.ubix.ssp.ad.e.a0.c.a(str, com.ubix.ssp.ad.e.a0.c.a(cVar))) {
                        origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                        z = false;
                    } else {
                        origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    }
                    a(origApplicationContext, aVar, str2, z);
                    u.e("CountDownTool isPositive " + z);
                    if (z) {
                        g gVar = g.get(str);
                        if (gVar != null) {
                            gVar.a();
                            return;
                        }
                        return;
                    }
                    u.e("CountDownTool Start time");
                    if (iMax <= 0 || g.get(str) != null) {
                        return;
                    }
                    g gVar2 = new g(((long) iMax) * 1000);
                    g.put(str, gVar2);
                    gVar2.a(new C1094b(str, aVar, context, str3, cVar));
                    gVar2.e();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    @Override // com.ubix.ssp.ad.e.s.d
    public void a(Context context, String str, String str2, int i, boolean z) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), "com.ubix.ssp.open.comm.AdActivity"));
        intent.addFlags(268435456);
        intent.putExtra(OapsKey.KEY_PKG, str);
        intent.putExtra("path", str2);
        intent.putExtra("isSimple", z);
        intent.putExtra("nid", i);
        context.startActivity(intent);
    }

    @Override // com.ubix.ssp.ad.e.s.d
    public void a(Context context, String str, String str2, com.ubix.ssp.ad.d.a aVar, int i) {
        if (str == null) {
            str = "";
        }
        String str3 = str;
        try {
            com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
            if (bVar.l == 1 && bVar.d == 4) {
                this.h = str3;
            }
            File file = new File(com.ubix.ssp.ad.e.a0.k.c(context), str2.hashCode() + ".apk");
            c.put(Integer.valueOf(i), aVar);
            a(context, str2, file, str3, i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.e.s.d
    public int b(int i) {
        com.ubix.ssp.ad.e.s.g.a aVarC;
        if (i == -1 || (aVarC = c(i)) == null || aVarC.b() == null) {
            return -1;
        }
        return aVarC.b().b();
    }

    @Override // com.ubix.ssp.ad.e.s.d
    public void b(Context context, int i) {
        com.ubix.ssp.ad.e.s.g.c cVarA;
        int iD = d(i);
        if (iD == -1 || (cVarA = a(i)) == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("service_intent_notify_id", i);
        intent.putExtra("service_intent_unique_id", iD);
        cVarA.a().runTask(intent);
    }

    @Override // com.ubix.ssp.ad.e.s.d
    public com.ubix.ssp.ad.e.s.g.a c(int i) {
        if (i == -1) {
            return null;
        }
        try {
            com.ubix.ssp.ad.e.s.g.c cVarA = a(i);
            if (cVarA != null) {
                return cVarA.b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }
}
