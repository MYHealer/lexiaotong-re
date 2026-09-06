package com.kwad.components.core.h;

import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a implements Runnable {
    private InterfaceC0662a Sy;
    private volatile Handler jk;
    private long Sv = 1000;
    private boolean Sw = true;
    private long Sx = 0;
    private float mSpeed = 1.0f;

    /* JADX INFO: renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0662a {
        void G(long j);
    }

    public final void a(InterfaceC0662a interfaceC0662a) {
        this.Sy = interfaceC0662a;
    }

    public final void pause() {
        this.Sw = true;
    }

    public final void resume() {
        this.Sw = false;
    }

    public final void setSpeed(float f) {
        if (f > 0.0f) {
            this.mSpeed = f;
        }
    }

    public a(Handler handler) {
        this.jk = handler;
    }

    public final void start() {
        this.Sw = false;
        if (this.jk != null) {
            this.jk.post(this);
        }
    }

    public final void stop() {
        if (this.jk != null) {
            this.jk.removeCallbacks(this);
        }
    }

    public final void destroy() {
        stop();
        this.jk = null;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0662a interfaceC0662a;
        if (this.jk != null) {
            if (!this.Sw && (interfaceC0662a = this.Sy) != null) {
                interfaceC0662a.G(this.Sx);
                this.Sx += this.Sv;
            }
            if (this.jk != null) {
                this.jk.postDelayed(this, (long) (this.Sv / this.mSpeed));
            }
        }
    }
}
