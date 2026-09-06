package com.opos.cmn.an.i;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f5940a = new byte[0];
    private static d b;

    private static void a() {
        if (b == null) {
            synchronized (f5940a) {
                if (b == null) {
                    b = new d.a().a(a.a()).b(a.b()).c(a.d()).d(a.c()).e(a.e()).a(a.f()).a();
                    com.opos.cmn.an.f.a.b("ThreadPoolTool", "initIfNeed ThreadPoolParams=" + b.toString());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        a();
        ExecutorService executorService = b.b;
        if (executorService != null) {
            try {
                executorService.execute(runnable);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeIOTask", e);
            }
        }
    }
}
