package com.opos.cmn.an.i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f5938a;
    public final ExecutorService b;
    public final ExecutorService c;
    public final ExecutorService d;
    public final ExecutorService e;
    public final ScheduledExecutorService f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ExecutorService f5939a;
        private ExecutorService b;
        private ExecutorService c;
        private ExecutorService d;
        private ExecutorService e;
        private ScheduledExecutorService f;

        private void b() {
            if (this.f5939a == null) {
                this.f5939a = com.opos.cmn.an.i.a.a();
            }
            if (this.b == null) {
                this.b = com.opos.cmn.an.i.a.b();
            }
            if (this.c == null) {
                this.c = com.opos.cmn.an.i.a.d();
            }
            if (this.d == null) {
                this.d = com.opos.cmn.an.i.a.c();
            }
            if (this.e == null) {
                this.e = com.opos.cmn.an.i.a.e();
            }
            if (this.f == null) {
                this.f = com.opos.cmn.an.i.a.f();
            }
        }

        public a a(ExecutorService executorService) {
            this.f5939a = executorService;
            return this;
        }

        public a a(ScheduledExecutorService scheduledExecutorService) {
            this.f = scheduledExecutorService;
            return this;
        }

        public d a() {
            b();
            return new d(this);
        }

        public a b(ExecutorService executorService) {
            this.b = executorService;
            return this;
        }

        public a c(ExecutorService executorService) {
            this.c = executorService;
            return this;
        }

        public a d(ExecutorService executorService) {
            this.d = executorService;
            return this;
        }

        public a e(ExecutorService executorService) {
            this.e = executorService;
            return this;
        }
    }

    public d(a aVar) {
        this.f5938a = aVar.f5939a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "ThreadPoolParams{netExecutorService=" + this.f5938a + ", ioExecutorService=" + this.b + ", bizExecutorService=" + this.c + ", dlExecutorService=" + this.d + ", singleExecutorService=" + this.e + ", scheduleExecutorService=" + this.f + '}';
    }
}
