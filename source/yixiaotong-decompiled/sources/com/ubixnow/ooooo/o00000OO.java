package com.ubixnow.ooooo;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o00000OO {
    private final long OooO00o;
    private long OooO0O0;
    private long OooO0OO;
    private CountDownTimer OooO0Oo;
    private volatile boolean OooO0o = false;
    private final OooO0O0 OooO0o0;

    public class OooO00o extends CountDownTimer {
        public OooO00o(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            o00000OO.this.OooO0O0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            o00000OO.this.OooO00o(j);
        }
    }

    public static abstract class OooO0O0 {
        public void OooO00o() {
        }

        public void OooO00o(long j) {
        }

        public abstract void OooO0O0();
    }

    public o00000OO(long j, OooO0O0 oooO0O0) {
        this.OooO00o = j;
        this.OooO0o0 = oooO0O0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(long j) {
        try {
            this.OooO0OO = j;
            OooO0O0 oooO0O0 = this.OooO0o0;
            if (oooO0O0 != null) {
                long j2 = (j / 1000) + 1;
                if (this.OooO0O0 != j2) {
                    this.OooO0O0 = j2;
                    oooO0O0.OooO00o(j2);
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void OooO0O0() {
        if (this.OooO0o) {
            this.OooO0o = false;
            OooO0O0 oooO0O0 = this.OooO0o0;
            if (oooO0O0 == null) {
                return;
            }
            try {
                if (this.OooO0OO < 150) {
                    oooO0O0.OooO0O0();
                } else {
                    oooO0O0.OooO00o();
                }
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
        }
    }

    private void OooO0O0(long j) {
        try {
            if (this.OooO0o && this.OooO0Oo == null) {
                OooO00o oooO00o = new OooO00o(j, 50L);
                this.OooO0Oo = oooO00o;
                oooO00o.start();
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    private synchronized void OooO0o0() {
        try {
            CountDownTimer countDownTimer = this.OooO0Oo;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.OooO0Oo = null;
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public synchronized void OooO00o() {
        try {
            OooO0o0();
            OooO0O0();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public long OooO0OO() {
        return this.OooO0OO;
    }

    public synchronized void OooO0Oo() {
        OooO0o0();
    }

    public synchronized void OooO0o() {
        OooO0O0(this.OooO0OO);
    }

    public synchronized void OooO0oO() {
        OooO0o0();
        this.OooO0o = true;
        long j = this.OooO00o * 1000;
        this.OooO0OO = j;
        OooO0O0(j);
    }
}
