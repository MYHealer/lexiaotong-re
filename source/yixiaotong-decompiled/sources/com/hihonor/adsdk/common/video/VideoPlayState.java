package com.hihonor.adsdk.common.video;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class VideoPlayState {
    public static final int STATE_BUFFERING_PAUSED = 7;
    public static final int STATE_BUFFERING_PLAYING = 6;
    public static final int STATE_COMPLETED = 8;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 5;
    public static final int STATE_PLAYING = 4;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_STARTED = 3;
    private int mCurrentState = 0;

    public int getState() {
        return this.mCurrentState;
    }

    public boolean isTargetState(int i) {
        return this.mCurrentState == i;
    }

    public void setState(int i) {
        this.mCurrentState = i;
    }
}
