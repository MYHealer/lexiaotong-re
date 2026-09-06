package com.adprof.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class p1 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q1 f1354a;

    public p1(q1 q1Var) {
        this.f1354a = q1Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        q1 q1Var = this.f1354a;
        q1Var.getClass();
        try {
            Iterator it = new CopyOnWriteArraySet(q1Var.f649a).iterator();
            while (it.hasNext()) {
                q1.a aVar = (q1.a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.d(activity);
                }
            }
        } catch (Throwable th) {
            pk.b("AdLifecycleManager onCreate error: ", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (pk.f594a) {
            pk.d("---onActivity Destroyed     activity  =  " + activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (pk.f594a) {
            pk.d("---onActivity Paused     activity  = " + activity);
        }
        q1 q1Var = this.f1354a;
        q1Var.getClass();
        try {
            Iterator it = new CopyOnWriteArraySet(q1Var.f649a).iterator();
            while (it.hasNext()) {
                q1.a aVar = (q1.a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.b(activity);
                }
            }
        } catch (Throwable th) {
            pk.b("AdLifecycleManager onPause error: ", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (pk.f594a) {
            pk.d("---onActivity Resumed     activity  = " + activity);
        }
        if (activity != null) {
            WeakReference weakReference = q1.f647a;
            Activity activity2 = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity2 != null && activity2 != activity) {
                q1.b = new WeakReference(activity2);
            }
            q1.f647a = new WeakReference(activity);
        }
        q1 q1Var = this.f1354a;
        q1Var.getClass();
        try {
            Iterator it = new CopyOnWriteArraySet(q1Var.f649a).iterator();
            while (it.hasNext()) {
                q1.a aVar = (q1.a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.a(activity);
                }
            }
        } catch (Throwable th) {
            pk.b("AdLifecycleManager onResume error: ", th);
        }
        q1 q1Var2 = this.f1354a;
        if (q1Var2.f651b && q1Var2.f648a > 0) {
            try {
                n5.m693a(activity);
                d dVar = n5.b;
                if (dVar != null) {
                    try {
                        n5 n5VarM590a = dVar.m590a();
                        if (n5VarM590a != null) {
                            n5VarM590a.b(n5.b, "dp_success_return");
                        }
                    } catch (Throwable th2) {
                        try {
                            pk.c("checkAndOpenLandingOnResume error: ", th2);
                        } catch (Throwable th3) {
                            n5.c();
                            throw th3;
                        }
                    }
                    n5.c();
                }
            } catch (Throwable th4) {
                pk.c("onActivityResumed checkAndOpenLandingOnResume error: ", th4);
            }
        }
        this.f1354a.f651b = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        q1 q1Var = this.f1354a;
        q1Var.f648a++;
        try {
            Iterator it = new CopyOnWriteArraySet(q1Var.f649a).iterator();
            while (it.hasNext()) {
                q1.a aVar = (q1.a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.e(activity);
                }
            }
        } catch (Throwable th) {
            pk.b("AdLifecycleManager onStart error: ", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        q1 q1Var = this.f1354a;
        int i = q1Var.f648a - 1;
        q1Var.f648a = i;
        if (i < 0) {
            q1Var.f648a = 0;
        }
        if (q1Var.f648a == 0) {
            q1Var.f651b = true;
        }
        try {
            Iterator it = new CopyOnWriteArraySet(q1Var.f649a).iterator();
            while (it.hasNext()) {
                q1.a aVar = (q1.a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.c(activity);
                }
            }
        } catch (Throwable th) {
            pk.b("AdLifecycleManager onStop error: ", th);
        }
    }
}
