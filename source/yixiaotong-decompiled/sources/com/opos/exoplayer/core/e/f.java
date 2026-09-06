package com.opos.exoplayer.core.e;

import android.os.Handler;
import com.opos.exoplayer.core.Format;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface f {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f6392a;
        private final f b;
        private final long c;

        /* JADX INFO: renamed from: com.opos.exoplayer.core.e.f$a$a, reason: collision with other inner class name */
        class RunnableC0919a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.h.i f6393a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Format d;
            final /* synthetic */ int e;
            final /* synthetic */ Object f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ long i;

            RunnableC0919a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
                this.f6393a = iVar;
                this.b = i;
                this.c = i2;
                this.d = format;
                this.e = i3;
                this.f = obj;
                this.g = j;
                this.h = j2;
                this.i = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6393a, this.b, this.c, this.d, this.e, this.f, a.this.a(this.g), a.this.a(this.h), this.i);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.h.i f6394a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Format d;
            final /* synthetic */ int e;
            final /* synthetic */ Object f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ long i;
            final /* synthetic */ long j;
            final /* synthetic */ long k;

            b(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
                this.f6394a = iVar;
                this.b = i;
                this.c = i2;
                this.d = format;
                this.e = i3;
                this.f = obj;
                this.g = j;
                this.h = j2;
                this.i = j3;
                this.j = j4;
                this.k = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6394a, this.b, this.c, this.d, this.e, this.f, a.this.a(this.g), a.this.a(this.h), this.i, this.j, this.k);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.h.i f6395a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Format d;
            final /* synthetic */ int e;
            final /* synthetic */ Object f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ long i;
            final /* synthetic */ long j;
            final /* synthetic */ long k;

            c(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
                this.f6395a = iVar;
                this.b = i;
                this.c = i2;
                this.d = format;
                this.e = i3;
                this.f = obj;
                this.g = j;
                this.h = j2;
                this.i = j3;
                this.j = j4;
                this.k = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.b(this.f6395a, this.b, this.c, this.d, this.e, this.f, a.this.a(this.g), a.this.a(this.h), this.i, this.j, this.k);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.h.i f6396a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Format d;
            final /* synthetic */ int e;
            final /* synthetic */ Object f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ long i;
            final /* synthetic */ long j;
            final /* synthetic */ long k;
            final /* synthetic */ IOException l;
            final /* synthetic */ boolean m;

            d(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
                this.f6396a = iVar;
                this.b = i;
                this.c = i2;
                this.d = format;
                this.e = i3;
                this.f = obj;
                this.g = j;
                this.h = j2;
                this.i = j3;
                this.j = j4;
                this.k = j5;
                this.l = iOException;
                this.m = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6396a, this.b, this.c, this.d, this.e, this.f, a.this.a(this.g), a.this.a(this.h), this.i, this.j, this.k, this.l, this.m);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6397a;
            final /* synthetic */ Format b;
            final /* synthetic */ int c;
            final /* synthetic */ Object d;
            final /* synthetic */ long e;

            e(int i, Format format, int i2, Object obj, long j) {
                this.f6397a = i;
                this.b = format;
                this.c = i2;
                this.d = obj;
                this.e = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f6397a, this.b, this.c, this.d, a.this.a(this.e));
            }
        }

        public a(Handler handler, f fVar) {
            this(handler, fVar, 0L);
        }

        public a(Handler handler, f fVar, long j) {
            this.f6392a = fVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.b = fVar;
            this.c = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(long j) {
            long jA = com.opos.exoplayer.core.b.a(j);
            if (jA == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.c + jA;
        }

        public void a(int i, Format format, int i2, Object obj, long j) {
            Handler handler;
            if (this.b == null || (handler = this.f6392a) == null) {
                return;
            }
            handler.post(new e(i, format, i2, obj, j));
        }

        public void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
            Handler handler;
            if (this.b == null || (handler = this.f6392a) == null) {
                return;
            }
            handler.post(new RunnableC0919a(iVar, i, i2, format, i3, obj, j, j2, j3));
        }

        public void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            Handler handler;
            if (this.b == null || (handler = this.f6392a) == null) {
                return;
            }
            handler.post(new b(iVar, i, i2, format, i3, obj, j, j2, j3, j4, j5));
        }

        public void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            Handler handler;
            if (this.b == null || (handler = this.f6392a) == null) {
                return;
            }
            handler.post(new d(iVar, i, i2, format, i3, obj, j, j2, j3, j4, j5, iOException, z));
        }

        public void b(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            Handler handler;
            if (this.b == null || (handler = this.f6392a) == null) {
                return;
            }
            handler.post(new c(iVar, i, i2, format, i3, obj, j, j2, j3, j4, j5));
        }
    }

    void a(int i, Format format, int i2, Object obj, long j);

    void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3);

    void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void a(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void b(com.opos.exoplayer.core.h.i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);
}
