package com.oplus.log;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.hv.TTDownloadField;
import com.oplus.log.d.i;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private static boolean i;
    private static boolean k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.oplus.log.g.c f5787a;
    private com.oplus.log.a.b b;
    private f c;
    private com.oplus.log.b.a d;
    private com.oplus.log.b.a.b e;
    private com.oplus.log.b.a.d f;
    private com.oplus.log.f.d g;
    private Context h;
    private com.oplus.log.core.c j;

    /* JADX INFO: renamed from: com.oplus.log.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f5788a = new c();

        private String a(Context context, String str) {
            String str2;
            if (com.oplus.log.d.b.f5816a.isEmpty()) {
                if (TextUtils.isEmpty(i.f5822a)) {
                    int iMyPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
                    String str3 = null;
                    if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.pid == iMyPid) {
                                str3 = runningAppProcessInfo.processName;
                                break;
                            }
                        }
                    }
                    i.f5822a = str3;
                }
                str2 = i.f5822a;
            } else {
                str2 = com.oplus.log.d.b.f5816a;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str).append("/").append(str2).append("/");
            return sb.toString();
        }

        public a a(int i) {
            this.f5788a.a(i);
            return this;
        }

        public a a(c.a aVar) {
            this.f5788a.a(aVar);
            return this;
        }

        public a a(c.b bVar) {
            this.f5788a.a(bVar);
            return this;
        }

        public a a(com.oplus.log.g.a aVar) {
            this.f5788a.a(aVar);
            return this;
        }

        public a a(String str) {
            this.f5788a.a(str);
            return this;
        }

        public b a(Context context) {
            AnonymousClass1 anonymousClass1 = null;
            if (TextUtils.isEmpty(this.f5788a.e()) || context == null || context.getFilesDir() == null) {
                return null;
            }
            String strD = this.f5788a.d();
            if (strD == null || strD.isEmpty()) {
                this.f5788a.c(a(context, context.getFilesDir().getAbsolutePath()));
            } else {
                this.f5788a.c(a(context, strD));
            }
            b bVar = new b(anonymousClass1);
            bVar.a(context, this.f5788a);
            return bVar;
        }

        public a b(int i) {
            this.f5788a.b(i);
            return this;
        }

        public a b(String str) {
            this.f5788a.c(str);
            return this;
        }

        public a c(int i) {
            this.f5788a.c(i);
            return this;
        }

        public a c(String str) {
            this.f5788a.b(str);
            this.f5788a.d(str);
            return this;
        }

        public a d(String str) {
            this.f5788a.e(str);
            return this;
        }

        public a e(String str) {
            com.oplus.log.d.b.f5816a = str;
            return this;
        }
    }

    private b() {
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void b(boolean z) {
        i = z;
    }

    public static boolean c() {
        return i;
    }

    public static boolean d() {
        return k;
    }

    public static a e() {
        return new a();
    }

    private void f() {
        com.oplus.log.b.a aVar = new com.oplus.log.b.a();
        this.d = aVar;
        Context context = this.h;
        com.oplus.log.f.d dVar = this.g;
        if (context != null) {
            ((Application) StubApp.getOrigApplicationContext(context.getApplicationContext())).registerActivityLifecycleCallbacks(aVar.b);
            aVar.f5789a = new ArrayList();
            aVar.f5789a.add(new com.oplus.log.b.a.a(dVar));
        }
        if (this.e == null) {
            com.oplus.log.b.a.b bVar = new com.oplus.log.b.a.b(this.g);
            this.e = bVar;
            bVar.a(this.h);
        }
        com.oplus.log.b.a.d dVar2 = new com.oplus.log.b.a.d(this.g);
        this.f = dVar2;
        dVar2.a(this.h);
        new com.oplus.log.b.a.e(this.g).a(this.h);
    }

    private void g() {
        com.oplus.log.b.a.d dVar = this.f;
        if (dVar != null) {
            try {
                this.h.unregisterReceiver(dVar);
            } catch (Exception e) {
                if (c()) {
                    e.printStackTrace();
                }
            }
            this.f = null;
        }
        com.oplus.log.b.a aVar = this.d;
        if (aVar != null) {
            Context context = this.h;
            if (context != null) {
                ((Application) StubApp.getOrigApplicationContext(context.getApplicationContext())).unregisterActivityLifecycleCallbacks(aVar.b);
            }
            this.d = null;
        }
        this.h = null;
    }

    public final com.oplus.log.a a() {
        f fVar = this.c;
        return fVar != null ? fVar : new f(null);
    }

    public final void a(int i2) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.a(i2);
        }
    }

    public final void a(Context context, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.h = origApplicationContext;
            com.oplus.log.d.b.a(origApplicationContext);
        }
        com.oplus.log.core.c.a aVar = new com.oplus.log.core.c.a();
        aVar.f5803a = cVar.d();
        aVar.b = cVar.e();
        com.oplus.log.core.c.a aVarA = aVar.a(cVar.j());
        aVarA.h = cVar.g();
        aVarA.e = "0123456789012345".getBytes();
        aVarA.f = "0123456789012345".getBytes();
        this.j = aVarA.a();
        this.b = new com.oplus.log.a.b(this.j);
        f fVar = new f(this.b);
        this.c = fVar;
        fVar.a(cVar.h());
        this.c.b(cVar.i());
        com.oplus.log.g.c cVar2 = new com.oplus.log.g.c(cVar);
        this.f5787a = cVar2;
        cVar2.a(this.b);
        this.g = new com.oplus.log.f.c(this.b);
        this.c.a("NearX-HLog", "sdk version : 4.0.6");
        f();
    }

    public final void a(com.oplus.log.g.c.g gVar) {
        com.oplus.log.g.c cVar = this.f5787a;
        if (cVar != null) {
            cVar.a(gVar);
        }
    }

    public final void a(String str, String str2, long j, long j2, boolean z, String str3) {
        if (this.f5787a != null) {
            this.f5787a.a(new com.oplus.log.g.c.C0865c(str, j, j2, z, str2, str3), 0);
        }
    }

    public final void a(String str, String str2, com.oplus.log.g.c.e eVar) {
        com.oplus.log.g.c cVar = this.f5787a;
        if (cVar != null) {
            cVar.a(str, str2, eVar);
        }
    }

    public final void a(boolean z) {
        com.oplus.log.a.b bVar = this.b;
        if (bVar != null) {
            if (z) {
                bVar.a();
            } else {
                bVar.a(null);
            }
        }
    }

    public final void b() {
        this.f5787a = null;
        this.c = null;
        this.g = null;
        g();
        this.b = null;
    }

    public final void b(int i2) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.b(i2);
        }
    }
}
