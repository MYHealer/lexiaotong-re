package com.meishu.sdk.core.service;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MsLifecycleUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        try {
            List<e> list = d.g;
            if (!list.isEmpty()) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    try {
                        ((e) it.next()).onActivityDestroyed(activity);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if ("MeishuOpenDeepLinkActivity".equals(activity.getClass().getSimpleName())) {
            Runnable runnable = d.c;
            if (runnable != null) {
                d.f4860a.removeCallbacks(runnable);
                d.c = null;
            }
            d.b = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Runnable runnable;
        boolean unused = d.e = false;
        try {
            List<e> list = d.g;
            if (!list.isEmpty()) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    try {
                        ((e) it.next()).onActivityPause(activity);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (!"MeishuOpenDeepLinkActivity".equals(activity.getClass().getSimpleName()) || (runnable = d.c) == null) {
            return;
        }
        d.f4860a.removeCallbacks(runnable);
        d.c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        boolean unused = d.e = true;
        try {
            List<e> list = d.g;
            if (!list.isEmpty()) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    try {
                        ((e) it.next()).onActivityResume(activity);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if ("MeishuOpenDeepLinkActivity".equals(activity.getClass().getSimpleName())) {
            Runnable runnable = d.c;
            if (runnable != null) {
                d.f4860a.removeCallbacks(runnable);
                d.c = null;
            }
            d.b = new WeakReference<>(activity);
            b bVar = new b();
            d.c = bVar;
            d.f4860a.postDelayed(bVar, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (d.d.incrementAndGet() == 1) {
            d.a(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (d.d.decrementAndGet() == 0) {
            d.a(false);
        }
    }
}
