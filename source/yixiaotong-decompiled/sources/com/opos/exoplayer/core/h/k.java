package com.opos.exoplayer.core.h;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class k implements d, t<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f6485a;
    private final d.a b;
    private final com.opos.exoplayer.core.i.t c;
    private final com.opos.exoplayer.core.i.e d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6486a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        a(int i, long j, long j2) {
            this.f6486a = i;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.b.a(this.f6486a, this.b, this.c);
        }
    }

    public k() {
        this(null, null);
    }

    public k(Handler handler, d.a aVar) {
        this(handler, aVar, 2000);
    }

    public k(Handler handler, d.a aVar, int i) {
        this(handler, aVar, i, com.opos.exoplayer.core.i.e.f6500a);
    }

    public k(Handler handler, d.a aVar, int i, com.opos.exoplayer.core.i.e eVar) {
        this.f6485a = handler;
        this.b = aVar;
        this.c = new com.opos.exoplayer.core.i.t(i);
        this.d = eVar;
        this.j = -1L;
    }

    private void a(int i, long j, long j2) {
        Handler handler = this.f6485a;
        if (handler == null || this.b == null) {
            return;
        }
        handler.post(new a(i, j, j2));
    }

    @Override // com.opos.exoplayer.core.h.d
    public synchronized long a() {
        return this.j;
    }

    @Override // com.opos.exoplayer.core.h.t
    public synchronized void a(Object obj) {
        com.opos.exoplayer.core.i.a.b(this.e > 0);
        long jA = this.d.a();
        int i = (int) (jA - this.f);
        long j = i;
        this.h += j;
        long j2 = this.i;
        long j3 = this.g;
        this.i = j2 + j3;
        if (i > 0) {
            this.c.a((int) Math.sqrt(j3), (8000 * j3) / j);
            if (this.h >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || this.i >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float fA = this.c.a(0.5f);
                this.j = Float.isNaN(fA) ? -1L : (long) fA;
            }
        }
        a(i, this.g, this.j);
        int i2 = this.e - 1;
        this.e = i2;
        if (i2 > 0) {
            this.f = jA;
        }
        this.g = 0L;
    }

    @Override // com.opos.exoplayer.core.h.t
    public synchronized void a(Object obj, int i) {
        this.g += (long) i;
    }

    @Override // com.opos.exoplayer.core.h.t
    public synchronized void a(Object obj, i iVar) {
        if (this.e == 0) {
            this.f = this.d.a();
        }
        this.e++;
    }
}
