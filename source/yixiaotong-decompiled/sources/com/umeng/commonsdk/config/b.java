package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CollectController.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f9214a = new HashMap();
    private static Object b = new Object();

    /* JADX INFO: renamed from: com.umeng.commonsdk.config.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectController.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    private b() {
    }

    public void a() {
        synchronized (b) {
            f9214a.clear();
        }
    }

    /* JADX INFO: compiled from: CollectController.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f9215a = new b(null);

        private a() {
        }
    }

    public static b b() {
        return a.f9215a;
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (b) {
            if (!f9214a.containsKey(str)) {
                return true;
            }
            return f9214a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                Map<String, Boolean> map = f9214a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
