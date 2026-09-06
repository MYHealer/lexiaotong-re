package com.ubix.ssp.ad.e.a0.b0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C1061a f8629a = null;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.b0.a$a, reason: collision with other inner class name */
    public static class C1061a {
        public void a(Activity activity) {
        }

        public void a(Activity activity, Bundle bundle) {
        }

        public void b(Activity activity) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void e(Activity activity) {
        }
    }

    public a(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void a(C1061a c1061a) {
        this.f8629a = c1061a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        C1061a c1061a = this.f8629a;
        if (c1061a != null) {
            c1061a.a(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        C1061a c1061a = this.f8629a;
        if (c1061a != null) {
            c1061a.a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        C1061a c1061a = this.f8629a;
        if (c1061a != null) {
            c1061a.b(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        C1061a c1061a = this.f8629a;
        if (c1061a != null) {
            c1061a.c(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C1061a c1061a = this.f8629a;
        if (c1061a != null) {
            c1061a.b(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        C1061a c1061a = this.f8629a;
        if (c1061a != null) {
            c1061a.d(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        C1061a c1061a = this.f8629a;
        if (c1061a != null) {
            c1061a.e(activity);
        }
    }
}
