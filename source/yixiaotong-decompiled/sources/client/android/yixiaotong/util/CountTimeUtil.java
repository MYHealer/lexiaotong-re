package client.android.yixiaotong.util;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CountTimeUtil {
    private static final long COUNTDOWN_INTERVAL = 1000;
    private static final long TOTAL_TIME = 300000;
    private CountDownTimer countDownTimer;
    private OnListener mOnListener;
    private long timeRemaining = 300000;
    private boolean isTimerRunning = false;

    public interface OnListener {
        void onFinish();
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [client.android.yixiaotong.util.CountTimeUtil$1] */
    public void startCountdown(long j, long j2, OnListener onListener) {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timeRemaining = j2;
        this.mOnListener = onListener;
        this.countDownTimer = new CountDownTimer(j, 1000L) { // from class: client.android.yixiaotong.util.CountTimeUtil.1
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                CountTimeUtil.this.timeRemaining = j3;
                CountTimeUtil.this.isTimerRunning = true;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                CountTimeUtil.this.timeRemaining = 0L;
                CountTimeUtil.this.isTimerRunning = false;
                CountTimeUtil.this.countdownComplete();
            }
        }.start();
    }

    public void stopCountdown() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.isTimerRunning = false;
        }
    }

    private void updateCountdownText(long j) {
        int i = (int) (j / 1000);
        String.format("%02d:%02d", Integer.valueOf(i / 60), Integer.valueOf(i % 60));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countdownComplete() {
        OnListener onListener = this.mOnListener;
        if (onListener != null) {
            onListener.onFinish();
        }
    }
}
