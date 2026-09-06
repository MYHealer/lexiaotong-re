package com.opos.mobad.d.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.alipay.sdk.widget.j;
import com.byazt.hv.TTDownloadField;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.stub.StubApp;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {
    private static b b;
    private Context d;
    private volatile CountDownLatch g;
    private volatile LocationManager h;
    private volatile a i;
    private volatile long j;
    private volatile a k;
    private HandlerThread m;
    private Handler n;
    private LocationListener c = new LocationListener() { // from class: com.opos.mobad.d.b.b.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.opos.cmn.an.f.a.a("LocationManager", "location onLocationChanged location");
            if (location != null) {
                b.this.a(location);
                CountDownLatch countDownLatch = b.this.g;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            StringBuilder sb = new StringBuilder("LocationListener onProviderDisabled provider=");
            if (str == null) {
                str = "null";
            }
            com.opos.cmn.an.f.a.a("LocationManager", sb.append(str).toString());
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            StringBuilder sb = new StringBuilder("LocationListener onProviderEnabled provider=");
            if (str == null) {
                str = "null";
            }
            com.opos.cmn.an.f.a.a("LocationManager", sb.append(str).toString());
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            StringBuilder sb = new StringBuilder("LocationListener onStatusChanged provider=");
            if (str == null) {
                str = "null";
            }
            com.opos.cmn.an.f.a.a("LocationManager", sb.append(str).append(",status=").append(i).append(",extras=").append(bundle != null ? bundle.toString() : "null").toString());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f6863a = new AnonymousClass4();
    private com.opos.mobad.d.c.a.b l = new com.opos.mobad.d.c.a.b(Integer.MAX_VALUE, KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
    private com.opos.mobad.d.c.a.c f = new com.opos.mobad.d.c.a.c() { // from class: com.opos.mobad.d.b.b.2
        @Override // com.opos.mobad.d.c.a.c
        public void a(final com.opos.mobad.d.c.a.InterfaceC0957a interfaceC0957a) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.d.b.b.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.a(interfaceC0957a);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("LocationManager", "init fail", e);
                    }
                }
            });
        }
    };
    private com.opos.mobad.d.c.a.c e = new com.opos.mobad.d.c.a.c() { // from class: com.opos.mobad.d.b.b.3
        @Override // com.opos.mobad.d.c.a.c
        public void a(final com.opos.mobad.d.c.a.InterfaceC0957a interfaceC0957a) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.d.b.b.3.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.b(interfaceC0957a);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("LocationManager", "locate fail", e);
                    }
                }
            });
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.d.b.b$4, reason: invalid class name */
    class AnonymousClass4 implements Application.ActivityLifecycleCallbacks {
        private AtomicInteger b = new AtomicInteger(0);
        private Runnable c = new Runnable() { // from class: com.opos.mobad.d.b.b.4.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zA;
                int i = AnonymousClass4.this.b.get();
                boolean z = false;
                if (i < 0) {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    zA = anonymousClass4.a(b.this.d);
                } else {
                    zA = i != 0;
                }
                if (!zA) {
                    try {
                        if (b.this.g != null) {
                            b.this.g.countDown();
                        }
                        if (b.this.h != null && b.this.f()) {
                            b.this.h.removeUpdates(b.this.c);
                            z = true;
                        }
                    } catch (Throwable th) {
                        com.opos.cmn.an.f.a.d("LocationManager", "onActivityStopped error,", th);
                    }
                }
                com.opos.cmn.an.f.a.b("LocationManager", "onActivityStopped,mCount=" + i + ",isFront=" + zA + ",doRemove=" + z);
            }
        };

        AnonymousClass4() {
        }

        public boolean a(Context context) {
            if (context == null) {
                return true;
            }
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        return runningAppProcessInfo.importance == 100;
                    }
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d("LocationManager", "isAppBackground error", th);
            }
            return true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            com.opos.cmn.an.f.a.b("LocationManager", "onActivityStarted,mActivityCount=" + this.b.incrementAndGet());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            this.b.decrementAndGet();
            Handler handler = b.this.n;
            if (handler == null) {
                return;
            }
            handler.removeCallbacks(this.c);
            handler.post(this.c);
        }
    }

    private b() {
    }

    public static b a() {
        b bVar = b;
        if (bVar != null) {
            return bVar;
        }
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if ("gps".equals(location.getProvider())) {
            a aVar = this.i;
            if (aVar == null || aVar.a() < location.getElapsedRealtimeNanos()) {
                this.i = b(location);
            }
        } else if ("network".equals(location.getProvider())) {
            a aVar2 = this.k;
            if (aVar2 == null || aVar2.a() < location.getElapsedRealtimeNanos()) {
                this.k = b(location);
            }
        } else {
            com.opos.cmn.an.f.a.a("LocationManager", "location with unexpected provider");
        }
        com.opos.cmn.an.f.a.b("LocationManager", "reset location:" + this.i + "," + this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.d.c.a.InterfaceC0957a interfaceC0957a) {
        if (this.d == null) {
            interfaceC0957a.b();
            return;
        }
        if (!f()) {
            com.opos.cmn.an.f.a.b("LocationManager", "init but not permission");
            interfaceC0957a.b();
            return;
        }
        LocationManager locationManagerG = g();
        if (locationManagerG == null) {
            interfaceC0957a.b();
            return;
        }
        Location lastKnownLocation = locationManagerG.getLastKnownLocation("network");
        if (lastKnownLocation != null) {
            a(lastKnownLocation);
        }
        interfaceC0957a.a();
    }

    private static final boolean a(a aVar) {
        return aVar == null || SystemClock.elapsedRealtimeNanos() - aVar.a() > 300000000000L;
    }

    private double[] a(a aVar, double[] dArr) {
        dArr[0] = ((double) ((int) (aVar.b() * 10000.0d))) / 10000.0d;
        dArr[1] = ((double) ((int) (aVar.c() * 10000.0d))) / 10000.0d;
        return dArr;
    }

    private a b(Location location) {
        return new a(location.getLatitude(), location.getLongitude(), location.getElapsedRealtimeNanos());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.opos.mobad.d.c.a.InterfaceC0957a interfaceC0957a) {
        if (this.d == null) {
            interfaceC0957a.b();
            return;
        }
        if (!f()) {
            interfaceC0957a.b();
            return;
        }
        if (a(this.k)) {
            e();
            interfaceC0957a.a();
        } else {
            if (this.d == null) {
                interfaceC0957a.b();
                return;
            }
            if (a(this.i) && this.j + 180000 < SystemClock.elapsedRealtime()) {
                d();
            }
            interfaceC0957a.a();
        }
    }

    private void d() {
        LocationManager locationManagerG = g();
        if (locationManagerG != null && h()) {
            com.opos.cmn.an.f.a.b("LocationManager", "location gps");
            this.j = SystemClock.elapsedRealtime();
            locationManagerG.requestLocationUpdates("gps", 60000L, 1.0f, this.c, Looper.getMainLooper());
            this.g = new CountDownLatch(1);
            try {
                try {
                    this.g.await(60000L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("LocationManager", "await fail", e);
                }
            } finally {
                locationManagerG.removeUpdates(this.c);
            }
        }
    }

    private void e() {
        LocationManager locationManagerG = g();
        if (locationManagerG != null && i()) {
            com.opos.cmn.an.f.a.b("LocationManager", "location net");
            locationManagerG.requestLocationUpdates("network", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 1.0f, this.c, Looper.getMainLooper());
            this.g = new CountDownLatch(1);
            try {
                try {
                    this.g.await(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("LocationManager", "await fail", e);
                }
            } finally {
                locationManagerG.removeUpdates(this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.d.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && this.d.checkCallingOrSelfPermission(g.h) == 0;
    }

    private LocationManager g() {
        Context context;
        if (this.h == null && (context = this.d) != null) {
            this.h = (LocationManager) context.getSystemService("location");
        }
        return this.h;
    }

    private boolean h() {
        try {
            return g().isProviderEnabled("gps");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e);
            return false;
        }
    }

    private boolean i() {
        try {
            return g().isProviderEnabled("network");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e);
            return false;
        }
    }

    public void a(Context context) {
        if (context != null && this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    this.d = origApplicationContext;
                    ((Application) origApplicationContext).registerActivityLifecycleCallbacks(this.f6863a);
                    HandlerThread handlerThread = new HandlerThread("LocationManagerThread");
                    this.m = handlerThread;
                    handlerThread.start();
                    this.n = new Handler(this.m.getLooper());
                }
            }
            this.l.a(this.f);
        }
    }

    public void b() {
        if (this.d == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("LocationManager", j.o);
        try {
            LocationManager locationManagerG = f() ? g() : null;
            ((Application) this.d).unregisterActivityLifecycleCallbacks(this.f6863a);
            this.d = null;
            CountDownLatch countDownLatch = this.g;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (locationManagerG != null) {
                locationManagerG.removeUpdates(this.c);
            }
            HandlerThread handlerThread = this.m;
            if (handlerThread != null) {
                handlerThread.quit();
                this.m = null;
                this.n = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("LocationManager", "", e);
        }
    }

    public double[] c() {
        double[] dArr = {0.0d, 0.0d};
        if (this.d == null) {
            return dArr;
        }
        a aVar = this.i;
        a aVar2 = this.k;
        if (a(aVar) || a(aVar2)) {
            this.l.a(this.e);
        }
        if (!a(aVar)) {
            return a(aVar, dArr);
        }
        if (!a(aVar2)) {
            return a(aVar2, dArr);
        }
        if (aVar != null && aVar2 != null && aVar2.a() > aVar.a() + 300000000000L) {
            return a(aVar2, dArr);
        }
        if (aVar != null) {
            return a(aVar, dArr);
        }
        return aVar2 != null ? a(aVar2, dArr) : dArr;
    }
}
