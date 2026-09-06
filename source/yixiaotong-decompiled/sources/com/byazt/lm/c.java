package com.byazt.lm;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1949, 20})
public class c implements Application.ActivityLifecycleCallbacks {
    public static volatile boolean c;
    public int tt = 0;
    public InterfaceC0210c uj;
    public volatile WeakReference<Activity> ve;

    /* JADX INFO: renamed from: com.byazt.lm.c$c, reason: collision with other inner class name */
    public interface InterfaceC0210c {
        void c();

        void tt();
    }

    public void c(InterfaceC0210c interfaceC0210c) {
        this.uj = interfaceC0210c;
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
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public Boolean c() {
        return Boolean.valueOf(c);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.tt++;
        c = false;
        InterfaceC0210c interfaceC0210c = this.uj;
        if (interfaceC0210c != null) {
            interfaceC0210c.tt();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.ve = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.tt - 1;
        this.tt = i;
        if (i == 0) {
            c = true;
            InterfaceC0210c interfaceC0210c = this.uj;
            if (interfaceC0210c != null) {
                interfaceC0210c.c();
            }
        }
    }

    public Activity tt() {
        if (this.ve == null) {
            return null;
        }
        return this.ve.get();
    }
}
