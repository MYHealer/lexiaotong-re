package com.yfanads.android.custom.view;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class CustomCountDownTimer {
    private final CountDownListener countDownListener;
    private CountDownTimer countDownTimer;
    private volatile boolean isPaused = false;
    private long timeRemaining;

    public interface CountDownListener {
        void onFinishAction();

        void updateCountDownUI(int i);
    }

    public CustomCountDownTimer(long j, long j2, CountDownListener countDownListener) {
        this.timeRemaining = j;
        this.countDownListener = countDownListener;
        this.countDownTimer = createCountDownTimer(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFinishAction() {
        this.countDownListener.onFinishAction();
    }

    private CountDownTimer createCountDownTimer(long j, long j2) {
        return new CountDownTimer(j, j2) { // from class: com.yfanads.android.custom.view.CustomCountDownTimer.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                CustomCountDownTimer.this.checkFinishAction();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                CustomCountDownTimer.this.timeRemaining = j3;
                CustomCountDownTimer.this.countDownListener.updateCountDownUI((int) (j3 / 1000));
            }
        };
    }

    public void cancel() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.timeRemaining = 0L;
        }
    }

    public void pause() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.isPaused = true;
        }
    }

    public void start() {
        if (!this.isPaused) {
            CountDownTimer countDownTimer = this.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.start();
                return;
            }
            return;
        }
        long j = this.timeRemaining;
        if (j > 0) {
            CountDownTimer countDownTimerCreateCountDownTimer = createCountDownTimer(j, 1000L);
            this.countDownTimer = countDownTimerCreateCountDownTimer;
            countDownTimerCreateCountDownTimer.start();
            this.isPaused = false;
        }
    }
}
