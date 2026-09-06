package com.ubixnow.ooooo;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO0Oo00 {
    private static oOO0Oo00 OooO00o;
    private boolean OooO0O0 = true;
    private final LinkedBlockingQueue<Runnable> OooO0OO = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Runnable> OooO0Oo = new LinkedBlockingQueue<>();

    public class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class OooO0O0 implements Runnable {
        public OooO0O0() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private oOO0Oo00() {
    }

    public static synchronized oOO0Oo00 OooO00o() {
        try {
            if (OooO00o == null) {
                OooO00o = new oOO0Oo00();
            }
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
        return OooO00o;
    }

    public void OooO00o(Runnable runnable) {
        try {
            (this.OooO0O0 ? this.OooO0OO : this.OooO0Oo).put(runnable);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooO00o(boolean z) {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue;
        Runnable oooO0O0;
        this.OooO0O0 = z;
        try {
            if (z) {
                linkedBlockingQueue = this.OooO0Oo;
                oooO0O0 = new OooO00o();
            } else {
                linkedBlockingQueue = this.OooO0OO;
                oooO0O0 = new OooO0O0();
            }
            linkedBlockingQueue.put(oooO0O0);
        } catch (InterruptedException e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooO0O0(Runnable runnable) {
        try {
            if (this.OooO0OO.size() < 50) {
                this.OooO0OO.put(runnable);
            }
        } catch (InterruptedException e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public boolean OooO0O0() {
        return this.OooO0OO.isEmpty();
    }

    public Runnable OooO0OO() {
        try {
            return this.OooO0O0 ? this.OooO0OO.poll() : this.OooO0Oo.poll();
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return null;
        }
    }

    public Runnable OooO0Oo() {
        try {
            return this.OooO0O0 ? this.OooO0OO.take() : this.OooO0Oo.take();
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return null;
        }
    }
}
