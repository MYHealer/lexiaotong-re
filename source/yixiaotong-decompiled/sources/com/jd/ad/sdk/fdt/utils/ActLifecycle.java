package com.jd.ad.sdk.fdt.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ActLifecycle implements Application.ActivityLifecycleCallbacks {
    public static final CopyOnWriteArrayList<jad_an> jad_bo = new CopyOnWriteArrayList<>();
    public static final CopyOnWriteArrayList<OnLifecycleChangeListener> jad_cp = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<WeakReference<Activity>> jad_an = new CopyOnWriteArrayList<>();

    public interface OnLifecycleChangeListener {
        void onActivityDestroyed(Activity activity);

        default void onActivityPaused(Activity activity) {
        }

        default void onActivityResumed(Activity activity) {
        }

        default void onActivityStopped(Activity activity) {
        }
    }

    public interface jad_an {
        void jad_an();

        void jad_bo();
    }

    public static void addLifecycleListener(OnLifecycleChangeListener onLifecycleChangeListener) {
        if (onLifecycleChangeListener == null) {
            return;
        }
        jad_cp.add(onLifecycleChangeListener);
    }

    public static void jad_an(jad_an jad_anVar) {
        jad_bo.add(jad_anVar);
    }

    public static void removeLifecycleListener(OnLifecycleChangeListener onLifecycleChangeListener) {
        if (onLifecycleChangeListener == null) {
            return;
        }
        jad_cp.remove(onLifecycleChangeListener);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        CopyOnWriteArrayList<OnLifecycleChangeListener> copyOnWriteArrayList = jad_cp;
        if (copyOnWriteArrayList.size() > 0) {
            for (OnLifecycleChangeListener onLifecycleChangeListener : copyOnWriteArrayList) {
                if (onLifecycleChangeListener != null) {
                    onLifecycleChangeListener.onActivityDestroyed(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        CopyOnWriteArrayList<OnLifecycleChangeListener> copyOnWriteArrayList = jad_cp;
        if (copyOnWriteArrayList.size() > 0) {
            for (OnLifecycleChangeListener onLifecycleChangeListener : copyOnWriteArrayList) {
                if (onLifecycleChangeListener != null) {
                    onLifecycleChangeListener.onActivityPaused(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        CopyOnWriteArrayList<OnLifecycleChangeListener> copyOnWriteArrayList = jad_cp;
        if (copyOnWriteArrayList.size() > 0) {
            for (OnLifecycleChangeListener onLifecycleChangeListener : copyOnWriteArrayList) {
                if (onLifecycleChangeListener != null) {
                    onLifecycleChangeListener.onActivityResumed(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.jad_an.size() == 0) {
            CopyOnWriteArrayList<jad_an> copyOnWriteArrayList = jad_bo;
            if (copyOnWriteArrayList.size() > 0) {
                for (jad_an jad_anVar : copyOnWriteArrayList) {
                    if (jad_anVar != null) {
                        jad_anVar.jad_an();
                    }
                }
            }
        }
        if (activity == null) {
            return;
        }
        this.jad_an.add(new WeakReference<>(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.jad_an.size() > 0) {
            for (WeakReference<Activity> weakReference : this.jad_an) {
                if (weakReference.get() == activity) {
                    this.jad_an.remove(weakReference);
                    break;
                }
            }
        }
        if (this.jad_an.size() == 0) {
            CopyOnWriteArrayList<jad_an> copyOnWriteArrayList = jad_bo;
            if (copyOnWriteArrayList.size() > 0) {
                for (jad_an jad_anVar : copyOnWriteArrayList) {
                    if (jad_anVar != null) {
                        jad_anVar.jad_bo();
                    }
                }
            }
        }
        CopyOnWriteArrayList<OnLifecycleChangeListener> copyOnWriteArrayList2 = jad_cp;
        if (copyOnWriteArrayList2.size() > 0) {
            for (OnLifecycleChangeListener onLifecycleChangeListener : copyOnWriteArrayList2) {
                if (onLifecycleChangeListener != null) {
                    onLifecycleChangeListener.onActivityStopped(activity);
                }
            }
        }
    }
}
