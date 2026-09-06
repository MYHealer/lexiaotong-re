package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BindingFailedResolveMgr.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class a {
    static final a b = new a();
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<Activity> f3937a = new ArrayList(1);

    a() {
    }

    void a(Activity activity) {
        synchronized (c) {
            for (Activity activity2 : this.f3937a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f3937a.add(activity);
        }
    }

    void b(Activity activity) {
        synchronized (c) {
            this.f3937a.remove(activity);
        }
    }
}
