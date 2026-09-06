package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: NotInstalledHmsResolveMgr.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c {
    public static final c b = new c();
    public static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Activity> f3942a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (c) {
            for (Activity activity2 : this.f3942a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f3942a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (c) {
            this.f3942a.remove(activity);
        }
    }
}
