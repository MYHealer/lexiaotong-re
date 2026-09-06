package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SplashDismissController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f3040a;
    private WeakReference<Activity> b;
    private CallBack e;
    private boolean c = false;
    private boolean d = false;
    private boolean f = false;

    public interface CallBack {
        void onResume();
    }

    public SplashDismissController(Activity activity, Activity activity2) {
        this.f3040a = new WeakReference<>(activity);
        if (activity2 != null) {
            this.b = new WeakReference<>(activity2);
        }
        a();
    }

    private void a() {
        Activity activity = this.f3040a.get();
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.adapter.baidu.SplashDismissController.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    SplashDismissController.this.e = null;
                    if ((SplashDismissController.this.f3040a == null || SplashDismissController.this.f3040a.get() != activity2) && (SplashDismissController.this.b == null || SplashDismissController.this.b.get() != activity2)) {
                        return;
                    }
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                    if ((SplashDismissController.this.f3040a == null || SplashDismissController.this.f3040a.get() != activity2) && (SplashDismissController.this.b == null || SplashDismissController.this.b.get() != activity2)) {
                        return;
                    }
                    SplashDismissController.this.d = true;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    if (((SplashDismissController.this.f3040a == null || SplashDismissController.this.f3040a.get() != activity2) && (SplashDismissController.this.b == null || SplashDismissController.this.b.get() != activity2)) || SplashDismissController.this.e == null) {
                        return;
                    }
                    SplashDismissController.this.e.onResume();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                }
            });
        }
    }

    public boolean isCallDismiss() {
        return this.f;
    }

    public boolean jumpToAdPage() {
        return this.c && this.d;
    }

    public void setCallBack(CallBack callBack) {
        this.e = callBack;
    }

    public void setCallDismiss(boolean z) {
        this.f = z;
    }

    public void setClick(boolean z) {
        this.c = z;
    }
}
