package com.ubix.ssp.ad.e.a0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {
    private int b;
    private f d;
    private e e;
    private InterfaceC1085d f;
    private c g;
    private Application h;
    private Application.ActivityLifecycleCallbacks i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8680a = 0;
    private boolean c = true;
    private ArrayList<b> j = new ArrayList<>();

    class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.d$a$a, reason: collision with other inner class name */
        class C1084a extends TimerTask {
            C1084a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (d.this.j.size() == 1 && ((b) d.this.j.get(d.this.j.size() - 1)).a().equals("onPaused") && d.this.e != null) {
                    d.this.e.b(1000L, false);
                }
            }
        }

        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            u.e("onActivityPaused " + activity + ";" + d.this.f8680a + ";" + activity.hashCode() + com.huawei.openalliance.ad.constant.x.bQ + d.this.b);
            if (d.this.b == activity.hashCode() || d.this.b == -1) {
                d.this.j.add(new b("onPaused", SystemClock.elapsedRealtime(), activity.hashCode()));
                if (d.this.e != null) {
                    new Timer().schedule(new C1084a(), 1000L);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b bVar;
            InterfaceC1085d interfaceC1085d;
            int i;
            u.e("onActivityResumed " + activity + ";" + d.this.f8680a + ";" + activity.hashCode() + com.huawei.openalliance.ad.constant.x.bQ + d.this.b);
            if ((d.this.b != activity.hashCode() && d.this.b != -1) || d.this.j.isEmpty() || (bVar = (b) d.this.j.get(d.this.j.size() - 1)) == null) {
                return;
            }
            if (bVar.a().equals("onPaused")) {
                if (d.this.e != null) {
                    d.this.e.b(SystemClock.elapsedRealtime() - bVar.b(), true);
                }
                if (d.this.f == null) {
                    return;
                }
                interfaceC1085d = d.this.f;
                i = 100;
            } else {
                d.this.j.add(new b("onResumed", SystemClock.elapsedRealtime(), activity.hashCode()));
                if (d.this.g != null) {
                    d.this.g.b(SystemClock.elapsedRealtime() - d.this.a());
                }
                if (d.this.f == null) {
                    return;
                }
                int iB = d.this.b();
                if (iB != -1) {
                    if (iB == 0) {
                        d.this.f.b(99);
                        return;
                    } else {
                        d.this.f.b(99 - (iB * 10));
                        return;
                    }
                }
                interfaceC1085d = d.this.f;
                i = 98;
            }
            interfaceC1085d.a(i);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            d.b(d.this);
            u.e("onActivityStarted " + activity + ";" + d.this.f8680a + ";" + activity.hashCode() + com.huawei.openalliance.ad.constant.x.bQ + d.this.b + ";" + activity.getWindow().isActive());
            if (d.this.b == activity.hashCode() || d.this.b == -1) {
                if (d.this.f8680a != 1 || d.this.d == null) {
                    d.this.j.add(new b("onStarted", SystemClock.elapsedRealtime(), activity.hashCode()));
                } else {
                    d.this.d.b();
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:38:0x0104  */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            b bVar;
            d.c(d.this);
            u.e("onActivityStopped " + activity + ";" + d.this.f8680a + ";" + activity.hashCode() + com.huawei.openalliance.ad.constant.x.bQ + d.this.b);
            if (d.this.b == activity.hashCode() || d.this.b == -1) {
                if (d.this.f8680a == 0 && d.this.d != null) {
                    d.this.d.a();
                    return;
                }
                boolean zB = com.ubix.ssp.ad.e.a0.y.e.e.b(activity);
                if (d.this.j.size() > 0 && (bVar = (b) d.this.j.get(d.this.j.size() - 1)) != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - bVar.b();
                    if (bVar.a().equals("onPaused")) {
                        if (jElapsedRealtime < 1000) {
                            if (d.this.e != null) {
                                d.this.e.a(jElapsedRealtime, false);
                            }
                            if (d.this.g != null) {
                                d.this.g.a(jElapsedRealtime);
                            }
                        } else {
                            if (d.this.e != null) {
                                d.this.e.b(jElapsedRealtime, false);
                            }
                            if (zB && d.this.g != null) {
                                d.this.g.a(jElapsedRealtime);
                            }
                        }
                    } else if (bVar.a().equals("onStarted") && d.this.g != null && zB) {
                        d.this.g.a(jElapsedRealtime);
                    }
                }
                d.this.j.add(new b("onStopped", SystemClock.elapsedRealtime(), com.ubix.ssp.ad.e.a0.y.e.e.b(activity), activity.hashCode()));
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8683a;
        private long b;
        private boolean c;
        private int d;

        public b(String str, long j, int i) {
            this.c = true;
            this.d = -1;
            this.f8683a = str;
            this.b = j;
        }

        public b(String str, long j, boolean z, int i) {
            this.d = -1;
            this.f8683a = str;
            this.b = j;
            this.c = z;
        }

        public String a() {
            return this.f8683a;
        }

        public long b() {
            return this.b;
        }
    }

    public interface c {
        void a(long j);

        void b(long j);
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.d$d, reason: collision with other inner class name */
    public interface InterfaceC1085d {
        void a(int i);

        void b(int i);
    }

    public interface e {
        void a(long j, boolean z);

        void b(long j, boolean z);
    }

    public interface f {
        void a();

        void b();
    }

    public d(Context context) {
        Activity activityA = com.ubix.ssp.ad.e.a0.c.a();
        if (activityA != null) {
            this.b = activityA.hashCode();
            if (com.ubix.ssp.ad.e.a0.c.a(activityA)) {
                this.f8680a++;
            }
        } else {
            this.b = -1;
        }
        a((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a() {
        if (!this.j.isEmpty()) {
            for (int size = this.j.size() - 1; size >= 0; size--) {
                b bVar = this.j.get(size);
                if (bVar != null && bVar.a().equals("onStopped")) {
                    return bVar.b();
                }
            }
        }
        return SystemClock.elapsedRealtime();
    }

    private void a(Application application) {
        this.h = application;
        a aVar = new a();
        this.i = aVar;
        application.registerActivityLifecycleCallbacks(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        if (this.j.size() < 4) {
            return -1;
        }
        String str = "";
        boolean z = true;
        for (b bVar : this.j) {
            str = str + bVar.a();
            if (!bVar.c) {
                z = false;
            }
        }
        u.e("blockPredict-" + str);
        if (str.equals("onPausedonStoppedonStartedonResumed")) {
            return z ? 0 : -1;
        }
        String[] strArrSplit = str.split("onStoppedonStarted");
        if (strArrSplit.length <= 0) {
            return -1;
        }
        return strArrSplit.length - 1;
    }

    static /* synthetic */ int b(d dVar) {
        int i = dVar.f8680a;
        dVar.f8680a = i + 1;
        return i;
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.f8680a;
        dVar.f8680a = i - 1;
        return i;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public void a(InterfaceC1085d interfaceC1085d) {
        this.f = interfaceC1085d;
    }

    public void a(e eVar) {
        this.e = eVar;
    }

    public void a(f fVar) {
        this.d = fVar;
    }

    public void c() {
        this.h.unregisterActivityLifecycleCallbacks(this.i);
    }
}
