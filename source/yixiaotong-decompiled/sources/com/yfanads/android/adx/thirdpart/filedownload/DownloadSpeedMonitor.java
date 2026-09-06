package com.yfanads.android.adx.thirdpart.filedownload;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DownloadSpeedMonitor implements IDownloadSpeed.Monitor, IDownloadSpeed.Lookup {
    private long mLastRefreshSofarBytes;
    private long mLastRefreshTime;
    private int mMinIntervalUpdateSpeed = 1000;
    private int mSpeed;
    private long mStartSofarBytes;
    private long mStartTime;
    private long mTotalBytes;

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IDownloadSpeed.Lookup
    public int getSpeed() {
        return this.mSpeed;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IDownloadSpeed.Monitor
    public void reset() {
        this.mSpeed = 0;
        this.mLastRefreshTime = 0L;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IDownloadSpeed.Lookup
    public void setMinIntervalUpdateSpeed(int i) {
        this.mMinIntervalUpdateSpeed = i;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IDownloadSpeed.Monitor
    public void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.mStartSofarBytes = j;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IDownloadSpeed.Monitor
    public void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.mStartSofarBytes;
        this.mLastRefreshTime = 0L;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (jUptimeMillis <= 0) {
            this.mSpeed = (int) j2;
        } else {
            this.mSpeed = (int) (j2 / jUptimeMillis);
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IDownloadSpeed.Monitor
    public void update(long j) {
        if (this.mMinIntervalUpdateSpeed <= 0) {
            return;
        }
        if (this.mLastRefreshTime != 0) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.mLastRefreshTime;
            if (jUptimeMillis < this.mMinIntervalUpdateSpeed && (this.mSpeed != 0 || jUptimeMillis <= 0)) {
                return;
            }
            int i = (int) ((j - this.mLastRefreshSofarBytes) / jUptimeMillis);
            this.mSpeed = i;
            this.mSpeed = Math.max(0, i);
        }
        this.mLastRefreshSofarBytes = j;
        this.mLastRefreshTime = SystemClock.uptimeMillis();
    }
}
