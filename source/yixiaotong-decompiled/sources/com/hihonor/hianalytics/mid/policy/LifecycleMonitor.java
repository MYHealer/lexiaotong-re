package com.hihonor.hianalytics.mid.policy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.hnha.r3;
import com.hihonor.hianalytics.hnha.s3;
import com.hihonor.hianalytics.hnha.t3;
import com.hihonor.hianalytics.util.SystemUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class LifecycleMonitor implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3701a = false;
    private boolean b = false;
    private int c = 0;
    private Object d = null;
    private WeakReference<Activity> e = null;

    /* JADX INFO: renamed from: com.hihonor.hianalytics.mid.policy.LifecycleMonitor$1, reason: invalid class name */
    class AnonymousClass1 implements LifecycleObserver {
        AnonymousClass1(LifecycleMonitor lifecycleMonitor) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a() {
            p2.e().a();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        private void onAppBackground() {
            j2.a("LifecycleMonitor", "onAppBackground");
            SystemUtils.a(true);
            t3.f(new r3() { // from class: com.hihonor.hianalytics.mid.policy.LifecycleMonitor$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LifecycleMonitor.AnonymousClass1.a();
                }
            });
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        private void onAppForeground() {
            SystemUtils.a(false);
            j2.a("LifecycleMonitor", "onAppForeground");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (!this.f3701a || b()) {
            return;
        }
        if (SystemUtils.getApp() != null) {
            SystemUtils.getApp().registerActivityLifecycleCallbacks(this);
            this.c = 0;
            this.b = true;
        } else {
            if (this.c < 2) {
                t3.b(new s3(new Runnable() { // from class: com.hihonor.hianalytics.mid.policy.LifecycleMonitor$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a();
                    }
                }), 100L);
                this.c++;
                return;
            }
            try {
                Class.forName("androidx.lifecycle.ProcessLifecycleOwner");
                if (this.d == null) {
                    this.d = new AnonymousClass1(this);
                }
                ProcessLifecycleOwner.get().getLifecycle().addObserver((LifecycleObserver) this.d);
            } catch (Throwable th) {
                j2.g("LifecycleMonitor", "checkToUpdateByLifecycle failEx=" + SystemUtils.getDesensitizedException(th));
            }
        }
    }

    private boolean b() {
        return this.b || this.d != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c() {
        p2.e().a();
    }

    public synchronized void d() {
        if (this.f3701a) {
            return;
        }
        this.f3701a = true;
        t3.e(new r3() { // from class: com.hihonor.hianalytics.mid.policy.LifecycleMonitor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        j2.a("LifecycleMonitor", "onActivityCreated activity=" + activity + ",savedInstanceState=" + bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        j2.a("LifecycleMonitor", "onActivityDestroyed activity=" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        j2.a("LifecycleMonitor", "onActivityPaused activity=" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        j2.a("LifecycleMonitor", "onActivityResumed activity=" + activity);
        this.e = new WeakReference<>(activity);
        SystemUtils.a(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        j2.a("LifecycleMonitor", "onActivitySaveInstanceState activity=" + activity + ",outState=" + bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        j2.a("LifecycleMonitor", "onActivityStarted activity=" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        j2.a("LifecycleMonitor", "onActivityStopped activity=" + activity);
        WeakReference<Activity> weakReference = this.e;
        Activity activity2 = weakReference == null ? null : weakReference.get();
        if (activity2 == null || activity2.equals(activity)) {
            SystemUtils.a(true);
            t3.f(new r3() { // from class: com.hihonor.hianalytics.mid.policy.LifecycleMonitor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LifecycleMonitor.c();
                }
            });
        }
    }
}
