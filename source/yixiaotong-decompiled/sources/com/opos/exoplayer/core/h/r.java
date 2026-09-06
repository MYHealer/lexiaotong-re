package com.opos.exoplayer.core.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.opos.exoplayer.core.i.x;
import com.opos.exoplayer.core.i.y;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f6495a;
    private e<? extends b> b;
    private IOException c;

    public interface a<T extends b> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public interface b {
        void a();

        boolean b();

        void c();
    }

    public interface c {
        void g();
    }

    public static final class d extends com.opos.exoplayer.core.i.c {
        public d(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }

        @Override // com.opos.exoplayer.core.i.c
        public String a() {
            return "UnexpectedLoaderException";
        }
    }

    private final class e<T extends b> extends Handler implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6496a;
        private final T c;
        private final a<T> d;
        private final long e;
        private IOException f;
        private int g;
        private volatile Thread h;
        private volatile boolean i;

        public e(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.c = t;
            this.d = aVar;
            this.f6496a = i;
            this.e = j;
        }

        private void a() {
            this.f = null;
            r.this.f6495a.execute(r.this.b);
        }

        private void b() {
            r.this.b = null;
        }

        private long c() {
            return Math.min((this.g - 1) * 1000, 5000);
        }

        public void a(int i) throws IOException {
            IOException iOException = this.f;
            if (iOException != null && this.g > i) {
                throw iOException;
            }
        }

        public void a(long j) {
            com.opos.exoplayer.core.i.a.b(r.this.b == null);
            r.this.b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                a();
            }
        }

        public void a(boolean z) {
            this.i = z;
            this.f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.c.a();
                if (this.h != null) {
                    this.h.interrupt();
                }
            }
            if (z) {
                b();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.d.a((b) this.c, jElapsedRealtime, jElapsedRealtime - this.e, true);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.i) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                a();
                return;
            }
            if (i == 4) {
                throw ((Error) message.obj);
            }
            b();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.e;
            if (this.c.b()) {
                this.d.a((b) this.c, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                this.d.a((b) this.c, jElapsedRealtime, j, false);
                return;
            }
            if (i2 == 2) {
                try {
                    this.d.a(this.c, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    com.opos.cmn.an.f.a.d("LoadTask", "Unexpected exception handling load completed", e);
                    r.this.c = new d(e);
                    return;
                }
            }
            if (i2 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f = iOException;
            int iA = this.d.a(this.c, jElapsedRealtime, j, iOException);
            if (iA == 3) {
                r.this.c = this.f;
            } else if (iA != 2) {
                this.g = iA != 1 ? 1 + this.g : 1;
                a(c());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Object e;
            try {
                this.h = Thread.currentThread();
                if (!this.c.b()) {
                    x.a("load:" + this.c.getClass().getSimpleName());
                    try {
                        this.c.c();
                        x.a();
                    } catch (Throwable th) {
                        x.a();
                        throw th;
                    }
                }
                if (this.i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e2) {
                e = e2;
                if (this.i) {
                    return;
                }
                obtainMessage(3, e).sendToTarget();
            } catch (Error e3) {
                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected error loading stream", e3);
                if (!this.i) {
                    obtainMessage(4, e3).sendToTarget();
                }
                throw e3;
            } catch (InterruptedException unused) {
                com.opos.exoplayer.core.i.a.b(this.c.b());
                if (this.i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e4) {
                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected exception loading stream", e4);
                if (this.i) {
                    return;
                }
                e = new d(e4);
                obtainMessage(3, e).sendToTarget();
            } catch (OutOfMemoryError e5) {
                com.opos.cmn.an.f.a.d("LoadTask", "OutOfMemory error loading stream", e5);
                if (this.i) {
                    return;
                }
                e = new d(e5);
                obtainMessage(3, e).sendToTarget();
            }
        }
    }

    private static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f6497a;

        public f(c cVar) {
            this.f6497a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6497a.g();
        }
    }

    public r(String str) {
        this.f6495a = y.a(str);
    }

    public <T extends b> long a(T t, a<T> aVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        com.opos.exoplayer.core.i.a.b(looperMyLooper != null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new e(looperMyLooper, t, aVar, i, jElapsedRealtime).a(0L);
        return jElapsedRealtime;
    }

    public void a(int i) throws IOException {
        IOException iOException = this.c;
        if (iOException != null) {
            throw iOException;
        }
        e<? extends b> eVar = this.b;
        if (eVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = eVar.f6496a;
            }
            eVar.a(i);
        }
    }

    public void a(c cVar) {
        e<? extends b> eVar = this.b;
        if (eVar != null) {
            eVar.a(true);
        }
        if (cVar != null) {
            this.f6495a.execute(new f(cVar));
        }
        this.f6495a.shutdown();
    }

    public boolean a() {
        return this.b != null;
    }

    public void b() {
        this.b.a(false);
    }
}
