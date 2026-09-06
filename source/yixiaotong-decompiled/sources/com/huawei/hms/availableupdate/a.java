package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: UpdateAdapterMgr.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a {
    public static final a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Activity> f3940a;

    public boolean a(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity activityA = a();
        if (activityA == null || activityA.isFinishing()) {
            this.f3940a = new WeakReference<>(activity);
            return true;
        }
        activity.finish();
        HMSLog.i("UpdateAdapterMgr", "finish one");
        return false;
    }

    public void b(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity activityA = a();
        if (activity == null || !activity.equals(activityA)) {
            return;
        }
        HMSLog.i("UpdateAdapterMgr", "reset");
        this.f3940a = null;
    }

    public final Activity a() {
        WeakReference<Activity> weakReference = this.f3940a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
