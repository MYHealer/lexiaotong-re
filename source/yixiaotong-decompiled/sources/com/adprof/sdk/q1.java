package com.adprof.sdk;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static q1 f1374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WeakReference f647a;
    public static WeakReference b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f648a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f651b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f649a = new HashSet();

    public interface a {
        void a(Activity activity);

        void b(Activity activity);

        void c(Activity activity);

        void d(Activity activity);

        void e(Activity activity);
    }

    public static Activity a() {
        WeakReference weakReference = f647a;
        Activity activity = weakReference == null ? null : (Activity) weakReference.get();
        if (activity != null) {
            pk.a("\n\n  getTopActivity = " + activity.getClass().getName() + " \n\n");
        }
        return activity;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static q1 m710a() {
        if (f1374a == null) {
            synchronized (q1.class) {
                if (f1374a == null) {
                    f1374a = new q1();
                }
            }
        }
        return f1374a;
    }

    public static boolean a(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public void a(a aVar) {
        try {
            if (aVar == null) {
                return;
            }
            try {
                Iterator it = new CopyOnWriteArraySet(this.f649a).iterator();
                while (it.hasNext()) {
                    if (((WeakReference) it.next()).get() == aVar) {
                        return;
                    }
                }
            } catch (Exception e) {
                pk.b("AdLifecycleManager isContains ", e);
            }
            this.f649a.add(new WeakReference(aVar));
        } catch (Exception e2) {
            pk.b("AdLifecycleManager addLifecycleListener ", e2);
        }
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            Iterator it = this.f649a.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == aVar) {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            pk.b("removeLifecycleListener error: ", th);
        }
    }
}
