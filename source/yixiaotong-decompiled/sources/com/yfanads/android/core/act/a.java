package com.yfanads.android.core.act;

import com.yfanads.android.core.inter.YFAdInterEventCallback;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AdInteractionManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a {
    public static final a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f9637a = new ConcurrentHashMap();

    public static a a() {
        return b;
    }

    public final void a(String str, YFAdInterEventCallback yFAdInterEventCallback) {
        this.f9637a.put(str, new WeakReference(yFAdInterEventCallback));
    }
}
