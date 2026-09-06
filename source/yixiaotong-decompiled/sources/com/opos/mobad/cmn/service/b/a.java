package com.opos.mobad.cmn.service.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.stub.StubApp;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6847a;
    private final AtomicInteger b = new AtomicInteger(0);
    private Application.ActivityLifecycleCallbacks c = null;
    private CopyOnWriteArrayList<InterfaceC0954a> d;

    /* JADX INFO: renamed from: com.opos.mobad.cmn.service.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0954a {
        void a();

        void b();
    }

    private a() {
        this.d = null;
        this.d = new CopyOnWriteArrayList<>();
    }

    public static a a() {
        a aVar = f6847a;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f6847a;
                if (aVar == null) {
                    aVar = new a();
                    f6847a = aVar;
                }
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i = this.b.get();
        com.opos.cmn.an.f.a.b("ActivityLifecycleMgr", "checkStatus() count=" + i);
        if (i <= 0) {
            if (z) {
                c();
            } else {
                d();
            }
        }
    }

    private void b() {
        if (this.c != null) {
            return;
        }
        this.c = new Application.ActivityLifecycleCallbacks() { // from class: com.opos.mobad.cmn.service.b.a.1
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
                a.this.a(true);
                a.this.b.incrementAndGet();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                a.this.b.decrementAndGet();
                a.this.a(false);
            }
        };
    }

    private void c() {
        CopyOnWriteArrayList<InterfaceC0954a> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (InterfaceC0954a interfaceC0954a : this.d) {
            if (interfaceC0954a != null) {
                interfaceC0954a.a();
            }
        }
    }

    private void d() {
        CopyOnWriteArrayList<InterfaceC0954a> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (InterfaceC0954a interfaceC0954a : this.d) {
            if (interfaceC0954a != null) {
                interfaceC0954a.b();
            }
        }
    }

    public void a(Context context) {
        Application application;
        com.opos.cmn.an.f.a.b("ActivityLifecycleMgr", "init()");
        if (context == null || (application = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext())) == null) {
            return;
        }
        b();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.c;
        if (activityLifecycleCallbacks != null) {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void a(InterfaceC0954a interfaceC0954a) {
        if (interfaceC0954a == null || this.d.contains(interfaceC0954a)) {
            return;
        }
        this.d.add(interfaceC0954a);
    }

    public void b(Context context) {
        Application application;
        com.opos.cmn.an.f.a.b("ActivityLifecycleMgr", "destroy()");
        if (context == null || (application = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext())) == null) {
            return;
        }
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.c;
        if (activityLifecycleCallbacks != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.c = null;
        }
        CopyOnWriteArrayList<InterfaceC0954a> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.d = null;
        }
    }

    public void b(InterfaceC0954a interfaceC0954a) {
        if (interfaceC0954a == null) {
            return;
        }
        this.d.remove(interfaceC0954a);
    }
}
