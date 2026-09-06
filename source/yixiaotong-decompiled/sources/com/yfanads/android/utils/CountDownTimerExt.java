package com.yfanads.android.utils;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class CountDownTimerExt {
    private static final String TAG = "CountDownTimerExt";
    private CountDownTimer countDownTimer;
    private boolean isTimerPaused = true;
    private long mInterval;
    private long millisInFuture;
    private long remainingTime;

    public CountDownTimerExt(long j, long j2) {
        this.mInterval = j2;
        this.millisInFuture = j;
        this.remainingTime = j;
    }

    public final long getMillisInFuture() {
        return this.millisInFuture;
    }

    public final long getRemainingTime() {
        return this.remainingTime;
    }

    public final boolean isRunning() {
        return !this.isTimerPaused;
    }

    public final boolean isTimerPaused() {
        return this.isTimerPaused;
    }

    public abstract void onTimerFinish();

    public abstract void onTimerTick(long j);

    public final void resume() {
        if (isRunning()) {
            return;
        }
        startIt(this.remainingTime, this.mInterval);
    }

    public final void setMillisInFuture(long j) {
        this.millisInFuture = j;
    }

    public final void setRemainingTime(long j) {
        this.remainingTime = j;
    }

    public final void setTimerPaused(boolean z) {
        this.isTimerPaused = z;
    }

    public final void start() {
        startIt(this.remainingTime, this.mInterval);
    }

    public final void stop() {
        try {
            this.countDownTimer.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isTimerPaused = true;
        this.remainingTime = this.millisInFuture;
    }

    public final void pause() {
        if (this.isTimerPaused) {
            return;
        }
        try {
            this.countDownTimer.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isTimerPaused = true;
    }

    public final void start(long j, long j2, long j3) {
        this.millisInFuture = j;
        this.remainingTime = j2;
        this.mInterval = j3;
        start();
    }

    public final synchronized void startIt(long j, long j2) {
        this.remainingTime = j;
        this.mInterval = j2;
        if (this.millisInFuture <= 0 || j2 <= 0) {
            YFLog.debug("CountDownTimerExt invalid parameter");
        } else {
            if (!this.isTimerPaused) {
                stop();
            }
            if (this.isTimerPaused) {
                CountDownTimer countDownTimer = new CountDownTimer(getRemainingTime(), this.mInterval) { // from class: com.yfanads.android.utils.CountDownTimerExt.1
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        CountDownTimerExt.this.onTimerFinish();
                        CountDownTimerExt.this.stop();
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long j3) {
                        CountDownTimerExt.this.setRemainingTime(j3);
                        CountDownTimerExt.this.onTimerTick(j3);
                    }
                };
                this.countDownTimer = countDownTimer;
                try {
                    countDownTimer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.isTimerPaused = false;
            } else {
                YFLog.debug("CountDownTimerExt ignore start");
            }
        }
    }
}
