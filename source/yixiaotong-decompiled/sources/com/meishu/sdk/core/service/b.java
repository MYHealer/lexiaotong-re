package com.meishu.sdk.core.service;

import android.app.Activity;
import com.meishu.sdk.core.utils.o0;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: MsLifecycleUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements Runnable {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        try {
            WeakReference<Activity> weakReference = d.b;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity != null && !activity.isFinishing()) {
                o0.b.f4927a.f4926a = null;
                activity.finish();
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                d.b = null;
                d.c = null;
            }
        }
    }
}
