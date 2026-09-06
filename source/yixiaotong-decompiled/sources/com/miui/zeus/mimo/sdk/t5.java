package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t5 implements s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f5613a;

    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            t5.this.f5613a = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            t5.this.f5613a = activity;
            b4 b4Var = b4.a.f5373a;
            if (b4Var.f5372a) {
                b4Var.f5372a = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            t5.this.f5613a = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity == t5.this.f5613a) {
                b4 b4Var = b4.a.f5373a;
                if (b4Var.f5372a) {
                    return;
                }
                b4Var.f5372a = true;
            }
        }
    }

    @Override // com.miui.zeus.mimo.sdk.s5
    public void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }
}
