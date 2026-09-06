package com.miui.zeus.mimo.sdk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f4 {
    public static volatile f4 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, r3> f5424a = new ConcurrentHashMap();

    public static f4 a() {
        if (b == null) {
            synchronized (f4.class) {
                b = new f4();
            }
        }
        return b;
    }
}
