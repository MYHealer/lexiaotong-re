package com.opos.exoplayer.core.a;

import android.os.Handler;
import com.opos.exoplayer.core.Format;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface e {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f6240a;
        private final e b;

        /* JADX INFO: renamed from: com.opos.exoplayer.core.a.e$a$a, reason: collision with other inner class name */
        class RunnableC0902a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.b.d f6241a;

            RunnableC0902a(com.opos.exoplayer.core.b.d dVar) {
                this.f6241a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.c(this.f6241a);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f6242a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            b(String str, long j, long j2) {
                this.f6242a = str;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.b(this.f6242a, this.b, this.c);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Format f6243a;

            c(Format format) {
                this.f6243a = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.b(this.f6243a);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6244a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            d(int i, long j, long j2) {
                this.f6244a = i;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6244a, this.b, this.c);
            }
        }

        /* JADX INFO: renamed from: com.opos.exoplayer.core.a.e$a$e, reason: collision with other inner class name */
        class RunnableC0903e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.b.d f6245a;

            RunnableC0903e(com.opos.exoplayer.core.b.d dVar) {
                this.f6245a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6245a.a();
                a.this.b.d(this.f6245a);
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6246a;

            f(int i) {
                this.f6246a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6246a);
            }
        }

        public a(Handler handler, e eVar) {
            this.f6240a = eVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.b = eVar;
        }

        public void a(int i) {
            if (this.b != null) {
                this.f6240a.post(new f(i));
            }
        }

        public void a(int i, long j, long j2) {
            if (this.b != null) {
                this.f6240a.post(new d(i, j, j2));
            }
        }

        public void a(Format format) {
            if (this.b != null) {
                this.f6240a.post(new c(format));
            }
        }

        public void a(com.opos.exoplayer.core.b.d dVar) {
            if (this.b != null) {
                this.f6240a.post(new RunnableC0902a(dVar));
            }
        }

        public void a(String str, long j, long j2) {
            if (this.b != null) {
                this.f6240a.post(new b(str, j, j2));
            }
        }

        public void b(com.opos.exoplayer.core.b.d dVar) {
            if (this.b != null) {
                this.f6240a.post(new RunnableC0903e(dVar));
            }
        }
    }

    void a(int i);

    void a(int i, long j, long j2);

    void b(Format format);

    void b(String str, long j, long j2);

    void c(com.opos.exoplayer.core.b.d dVar);

    void d(com.opos.exoplayer.core.b.d dVar);
}
