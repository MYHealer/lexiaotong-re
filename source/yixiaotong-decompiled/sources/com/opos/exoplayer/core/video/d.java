package com.opos.exoplayer.core.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowManager f6555a;
    private final b b;
    private final a c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private long j;
    private long k;
    private long l;

    private final class a implements DisplayManager.DisplayListener {
        private final DisplayManager b;

        public a(DisplayManager displayManager) {
            this.b = displayManager;
        }

        public void a() {
            this.b.registerDisplayListener(this, null);
        }

        public void b() {
            this.b.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                d.this.c();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b b = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f6557a = -9223372036854775807L;
        private final Handler c;
        private final HandlerThread d;
        private Choreographer e;
        private int f;

        private b() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.d = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper(), this);
            this.c = handler;
            handler.sendEmptyMessage(0);
        }

        public static b a() {
            return b;
        }

        private void d() {
            this.e = Choreographer.getInstance();
        }

        private void e() {
            int i = this.f + 1;
            this.f = i;
            if (i == 1) {
                this.e.postFrameCallback(this);
            }
        }

        private void f() {
            int i = this.f - 1;
            this.f = i;
            if (i == 0) {
                this.e.removeFrameCallback(this);
                this.f6557a = -9223372036854775807L;
            }
        }

        public void b() {
            this.c.sendEmptyMessage(1);
        }

        public void c() {
            this.c.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.f6557a = j;
            this.e.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                d();
                return true;
            }
            if (i == 1) {
                e();
                return true;
            }
            if (i != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public d() {
        this(null);
    }

    public d(Context context) {
        WindowManager windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        this.f6555a = windowManager;
        if (windowManager != null) {
            this.c = y.f6517a >= 17 ? a(context) : null;
            this.b = b.a();
        } else {
            this.c = null;
            this.b = null;
        }
        this.d = -9223372036854775807L;
        this.e = -9223372036854775807L;
    }

    private static long a(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private a a(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    private boolean b(long j, long j2) {
        return Math.abs((j2 - this.j) - (j - this.k)) > 20000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Display defaultDisplay = this.f6555a.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / ((double) defaultDisplay.getRefreshRate()));
            this.d = refreshRate;
            this.e = (refreshRate * 80) / 100;
        }
    }

    public long a(long j, long j2) {
        long j3;
        long j4;
        long j5 = 1000 * j;
        if (this.i) {
            if (j != this.f) {
                this.l++;
                this.g = this.h;
            }
            long j6 = this.l;
            if (j6 >= 6) {
                j4 = this.g + ((j5 - this.k) / j6);
                if (!b(j4, j2)) {
                    j3 = (this.j + j4) - this.k;
                }
            } else {
                if (b(j5, j2)) {
                }
                j3 = j2;
                j4 = j5;
            }
            this.i = false;
            j3 = j2;
            j4 = j5;
        } else {
            j3 = j2;
            j4 = j5;
        }
        if (!this.i) {
            this.k = j5;
            this.j = j2;
            this.l = 0L;
            this.i = true;
        }
        this.f = j;
        this.h = j4;
        b bVar = this.b;
        if (bVar == null || this.d == -9223372036854775807L) {
            return j3;
        }
        long j7 = bVar.f6557a;
        return j7 == -9223372036854775807L ? j3 : a(j3, j7, this.d) - this.e;
    }

    public void a() {
        this.i = false;
        if (this.f6555a != null) {
            this.b.b();
            a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    public void b() {
        if (this.f6555a != null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.b();
            }
            this.b.c();
        }
    }
}
