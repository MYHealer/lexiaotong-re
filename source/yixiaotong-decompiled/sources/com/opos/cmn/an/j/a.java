package com.opos.cmn.an.j;

import android.text.TextUtils;
import com.opos.cmn.an.j.a.c;
import com.opos.cmn.an.j.b.e;
import com.opos.cmn.an.j.b.f;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f5941a;
    private com.opos.cmn.an.j.a.b b;
    private ThreadLocal<f> c;

    /* JADX INFO: renamed from: com.opos.cmn.an.j.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.opos.cmn.an.j.a$a, reason: collision with other inner class name */
    public static class C0869a {
        private com.opos.cmn.an.j.a.b g;
        private c h;
        private BlockingQueue<Runnable> i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5942a = 3;
        private int b = 5;
        private int c = 128;
        private int d = 60000;
        private String f = "cmn_thread";
        private int e = 5;

        public C0869a a(int i) {
            this.f5942a = i;
            return this;
        }

        public C0869a a(String str) {
            this.f = str;
            return this;
        }

        public C0869a a(BlockingQueue<Runnable> blockingQueue) {
            this.i = blockingQueue;
            return this;
        }

        public a a() {
            this.e = Math.max(1, Math.min(10, this.e));
            this.f = TextUtils.isEmpty(this.f) ? "cmn_thread" : this.f;
            if (this.i == null) {
                this.i = new LinkedBlockingQueue(this.c);
            }
            return new a(this.f5942a, this.b, this.d, TimeUnit.MILLISECONDS, this.i, this.e, this.f, this.g, this.h, null);
        }

        public C0869a b(int i) {
            this.b = i;
            return this;
        }

        public C0869a c(int i) {
            this.d = i;
            return this;
        }
    }

    private a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, int i3, String str, com.opos.cmn.an.j.a.b bVar, c cVar) {
        super(i, i2, j, timeUnit, blockingQueue, new com.opos.cmn.an.j.b.a(str, i3), new ThreadPoolExecutor.DiscardPolicy());
        this.c = new ThreadLocal<>();
        this.b = bVar;
        this.f5941a = cVar;
    }

    /* synthetic */ a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, int i3, String str, com.opos.cmn.an.j.a.b bVar, c cVar, AnonymousClass1 anonymousClass1) {
        this(i, i2, j, timeUnit, blockingQueue, i3, str, bVar, cVar);
    }

    private synchronized void a() {
        this.c.set(null);
    }

    private synchronized f b() {
        f fVar;
        fVar = this.c.get();
        if (fVar == null) {
            fVar = new f();
            fVar.b = this.f5941a;
            fVar.c = this.b;
            fVar.d = com.opos.cmn.an.j.a.a.THREAD;
            this.c.set(fVar);
        }
        return fVar;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f fVarB = b();
        fVarB.e = runnable;
        super.execute(new e(fVarB));
        a();
    }
}
