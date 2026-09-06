package com.yfanads.android.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LifecycleObserver {
    private static volatile LifecycleObserver sLifecycleObserver;
    private SoftReference<Activity> currentActivity;
    private Application mApplication;
    private final Set<Integer> mStartedActivitySet = new HashSet();
    private final List<LifecycleListener> mListeners = new CopyOnWriteArrayList();
    private boolean mIsInBackground = true;
    private boolean mHasInit = false;
    private boolean mEnable = false;

    private LifecycleObserver() {
    }

    public static LifecycleObserver getInstance() {
        if (sLifecycleObserver == null) {
            synchronized (LifecycleObserver.class) {
                if (sLifecycleObserver == null) {
                    sLifecycleObserver = new LifecycleObserver();
                }
            }
        }
        return sLifecycleObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackToForeground() {
        try {
            this.mIsInBackground = false;
            Iterator<LifecycleListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onBackToForeground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppGoToBackground() {
        try {
            this.mIsInBackground = true;
            Iterator<LifecycleListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onBackToBackground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public Activity getCurrentActivity() {
        SoftReference<Activity> softReference = this.currentActivity;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void init(Context context) {
        try {
            if (!(context instanceof Application) || this.mHasInit) {
                return;
            }
            this.mHasInit = true;
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.yfanads.android.lifecycle.LifecycleObserver.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    LifecycleObserver.this.mEnable = true;
                    try {
                        Iterator it = LifecycleObserver.this.mListeners.iterator();
                        while (it.hasNext()) {
                            ((LifecycleListener) it.next()).onActivityCreated(activity, bundle);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    try {
                        Iterator it = LifecycleObserver.this.mListeners.iterator();
                        while (it.hasNext()) {
                            ((LifecycleListener) it.next()).onActivityDestroyed(activity);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    try {
                        if (LifecycleObserver.this.currentActivity != null && LifecycleObserver.this.currentActivity.get() != null && ((Activity) LifecycleObserver.this.currentActivity.get()).equals(activity)) {
                            LifecycleObserver.this.currentActivity = null;
                        }
                        Iterator it = LifecycleObserver.this.mListeners.iterator();
                        while (it.hasNext()) {
                            ((LifecycleListener) it.next()).onActivityPaused(activity);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    try {
                        LifecycleObserver.this.currentActivity = new SoftReference(activity);
                        Iterator it = LifecycleObserver.this.mListeners.iterator();
                        while (it.hasNext()) {
                            ((LifecycleListener) it.next()).onActivityResumed(activity);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    try {
                        LifecycleObserver.this.mStartedActivitySet.add(Integer.valueOf(activity.hashCode()));
                        if (LifecycleObserver.this.mStartedActivitySet.size() == 1) {
                            LifecycleObserver.this.onAppBackToForeground();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    try {
                        LifecycleObserver.this.mStartedActivitySet.remove(Integer.valueOf(activity.hashCode()));
                        if (LifecycleObserver.this.mStartedActivitySet.size() == 0) {
                            LifecycleObserver.this.onAppGoToBackground();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void registerLifecycleListener(LifecycleListener lifecycleListener) {
        try {
            if (this.mListeners.contains(lifecycleListener)) {
                Log.e("lifecycle", "list has " + lifecycleListener);
            } else {
                this.mListeners.add(lifecycleListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unRegisterLifecycleListener(LifecycleListener lifecycleListener) {
        try {
            this.mListeners.remove(lifecycleListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
