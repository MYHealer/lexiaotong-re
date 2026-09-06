package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static Map<String, WeakReference<C0748a>> aYp = new ConcurrentHashMap();

    public static synchronized Handler NR() {
        return fp("reportHT").getHandler();
    }

    private static C0748a fp(String str) {
        WeakReference<C0748a> weakReference = aYp.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0748a c0748a = new C0748a(str);
            aYp.put(str, new WeakReference<>(c0748a));
            return c0748a;
        }
        return weakReference.get();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    public static class C0748a {
        private HandlerThread aYq;
        private Handler jk;

        public final Handler getHandler() {
            return this.jk;
        }

        public C0748a(String str) {
            HandlerThread handlerThread = new HandlerThread(TextUtils.isEmpty(str) ? "ksad-HT" : "ksad-" + str);
            this.aYq = handlerThread;
            handlerThread.start();
            this.jk = new Handler(this.aYq.getLooper());
        }
    }
}
