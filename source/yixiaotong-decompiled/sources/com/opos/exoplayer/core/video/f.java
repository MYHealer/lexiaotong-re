package com.opos.exoplayer.core.video;

import android.os.Handler;
import android.view.Surface;
import com.opos.exoplayer.core.Format;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface f {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f6558a;
        private final f b;

        /* JADX INFO: renamed from: com.opos.exoplayer.core.video.f$a$a, reason: collision with other inner class name */
        class RunnableC0931a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.b.d f6559a;

            RunnableC0931a(com.opos.exoplayer.core.b.d dVar) {
                this.f6559a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6559a);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f6560a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            b(String str, long j, long j2) {
                this.f6560a = str;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6560a, this.b, this.c);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Format f6561a;

            c(Format format) {
                this.f6561a = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6561a);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6562a;
            final /* synthetic */ long b;

            d(int i, long j) {
                this.f6562a = i;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6562a, this.b);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6563a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ float d;

            e(int i, int i2, int i3, float f) {
                this.f6563a = i;
                this.b = i2;
                this.c = i3;
                this.d = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6563a, this.b, this.c, this.d);
            }
        }

        /* JADX INFO: renamed from: com.opos.exoplayer.core.video.f$a$f, reason: collision with other inner class name */
        class RunnableC0932f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Surface f6564a;

            RunnableC0932f(Surface surface) {
                this.f6564a = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6564a);
            }
        }

        class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.b.d f6565a;

            g(com.opos.exoplayer.core.b.d dVar) {
                this.f6565a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6565a.a();
                a.this.b.b(this.f6565a);
            }
        }

        public a(Handler handler, f fVar) {
            this.f6558a = fVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.b = fVar;
        }

        public void a(int i, int i2, int i3, float f) {
            if (this.b != null) {
                this.f6558a.post(new e(i, i2, i3, f));
            }
        }

        public void a(int i, long j) {
            if (this.b != null) {
                this.f6558a.post(new d(i, j));
            }
        }

        public void a(Surface surface) {
            if (this.b != null) {
                this.f6558a.post(new RunnableC0932f(surface));
            }
        }

        public void a(Format format) {
            if (this.b != null) {
                this.f6558a.post(new c(format));
            }
        }

        public void a(com.opos.exoplayer.core.b.d dVar) {
            if (this.b != null) {
                this.f6558a.post(new RunnableC0931a(dVar));
            }
        }

        public void a(String str, long j, long j2) {
            if (this.b != null) {
                this.f6558a.post(new b(str, j, j2));
            }
        }

        public void b(com.opos.exoplayer.core.b.d dVar) {
            if (this.b != null) {
                this.f6558a.post(new g(dVar));
            }
        }
    }

    void a(int i, int i2, int i3, float f);

    void a(int i, long j);

    void a(Surface surface);

    void a(Format format);

    void a(com.opos.exoplayer.core.b.d dVar);

    void a(String str, long j, long j2);

    void b(com.opos.exoplayer.core.b.d dVar);
}
