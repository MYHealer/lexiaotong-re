package com.opos.cmn.an.j;

import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.opos.cmn.an.j.a f5944a;
    private static com.opos.cmn.an.j.a b;
    private static com.opos.cmn.an.j.a c;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final com.opos.cmn.an.j.a f5945a;
        private static final int b;
        private static final int c;
        private static final int d;

        static {
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            b = iAvailableProcessors;
            int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
            c = iMax;
            int i = (iAvailableProcessors * 2) + 1;
            d = i;
            f5945a = new com.opos.cmn.an.j.a.C0869a().a(iMax).b(i).c(KSImageLoader.InnerImageLoadingListener.MAX_DURATION).a("comp_thread").a();
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.an.j.b$b, reason: collision with other inner class name */
    private static final class C0870b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static com.opos.cmn.an.j.a f5946a;
        static final com.opos.cmn.an.j.a b;

        static {
            com.opos.cmn.an.j.a aVarA = new com.opos.cmn.an.j.a.C0869a().a(2).b(20).c(3000).a(new SynchronousQueue()).a("io_thread").a();
            b = aVarA;
            aVarA.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.opos.cmn.an.j.b.b.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    synchronized (this) {
                        if (C0870b.f5946a == null) {
                            C0870b.f5946a = new com.opos.cmn.an.j.a.C0869a().a(5).b(5).c(3000).a(new LinkedBlockingQueue()).a("io_backup_thread").a();
                            C0870b.f5946a.allowCoreThreadTimeOut(true);
                        }
                    }
                    C0870b.f5946a.execute(runnable);
                }
            });
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final com.opos.cmn.an.j.a f5947a = new com.opos.cmn.an.j.a.C0869a().a(1).b(1).a("single_thread").a();
    }

    public static com.opos.cmn.an.j.a a() {
        if (f5944a == null) {
            f5944a = C0870b.b;
        }
        return f5944a;
    }

    public static void a(Runnable runnable) {
        c().execute(runnable);
    }

    public static com.opos.cmn.an.j.a b() {
        if (b == null) {
            b = a.f5945a;
        }
        return b;
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeNetTask", e);
        }
    }

    public static com.opos.cmn.an.j.a c() {
        if (c == null) {
            c = c.f5947a;
        }
        return c;
    }

    public static void c(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeIOTask", e);
        }
    }

    public static void d(Runnable runnable) {
        try {
            b().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeBizTask", e);
        }
    }

    public static void e(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeDLTask", e);
        }
    }
}
