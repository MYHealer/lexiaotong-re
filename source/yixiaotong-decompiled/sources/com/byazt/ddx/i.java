package com.byazt.ddx;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 42})
public class i {

    public interface c {
        void c(long j);

        void c(String str);

        void c(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
        if (cVarVe == null) {
            return;
        }
        cVarVe.c((Application.ActivityLifecycleCallbacks) null);
    }

    public void c(final c cVar) {
        com.byazt.aas.c cVarVe;
        if (cVar == null || (cVarVe = com.byazt.omf.x.m().ve()) == null) {
            return;
        }
        cVarVe.c(new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.ddx.i.1
            public long uj;
            public WeakReference<Object> ve;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                i.this.c();
                cVar.c("create");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                i.this.c();
                cVar.c("start");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                i.this.c();
                cVar.c(System.currentTimeMillis() - this.uj);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                this.ve = new WeakReference<>(activity);
                this.uj = System.currentTimeMillis();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                i.this.c();
                cVar.c(c(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                i.this.c();
                cVar.c("destroy");
            }

            private boolean c(Activity activity) {
                WeakReference<Object> weakReference;
                return (activity == null || (weakReference = this.ve) == null || activity != weakReference.get()) ? false : true;
            }
        });
    }
}
