package com.oplus.log.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.oplus.log.b.a.c;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<c> f5789a;
    public Application.ActivityLifecycleCallbacks b = new Application.ActivityLifecycleCallbacks() { // from class: com.oplus.log.b.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            if (a.this.f5789a == null || a.this.f5789a.size() <= 0) {
                return;
            }
            Iterator<c> it = a.this.f5789a.iterator();
            while (it.hasNext()) {
                it.next().a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            if (a.this.f5789a == null || a.this.f5789a.size() <= 0) {
                return;
            }
            Iterator<c> it = a.this.f5789a.iterator();
            while (it.hasNext()) {
                it.next().b(activity);
            }
        }
    };
}
