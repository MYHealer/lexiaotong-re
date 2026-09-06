package com.meishu.sdk.core.service;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: MsLifecycleUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f4860a = new Handler(Looper.getMainLooper());
    public static WeakReference<Activity> b = null;
    public static Runnable c = null;
    public static AtomicInteger d = new AtomicInteger(0);
    public static volatile boolean e = false;
    public static final AtomicBoolean f = new AtomicBoolean(false);
    public static final List<e> g = Collections.synchronizedList(new ArrayList());

    public static boolean a() {
        return d.get() > 0;
    }

    public static void a(e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            List<e> list = g;
            if (list.contains(eVar)) {
                return;
            }
            list.add(eVar);
        } catch (Exception unused) {
        }
    }

    public static void b(e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            g.remove(eVar);
        } catch (Exception unused) {
        }
    }

    public static void a(boolean z) {
        try {
            List<e> list = g;
            if (list.isEmpty()) {
                return;
            }
            ArrayList arrayList = null;
            for (e eVar : new ArrayList(list)) {
                try {
                    if (!eVar.onAppStateUpdate(z)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(eVar);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (arrayList != null) {
                g.removeAll(arrayList);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
