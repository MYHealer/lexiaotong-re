package com.hihonor.dlinstall.state;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DIDownloadPausedState extends DIState {
    private final long currSize;
    private final String pkgName;
    private final int taskType;
    private final long totalSize;

    public DIDownloadPausedState(String str, long j, long j2) {
        this.pkgName = str;
        this.currSize = j;
        this.totalSize = j2;
        this.taskType = 0;
    }

    public DIDownloadPausedState(String str, long j, long j2, int i) {
        this.pkgName = str;
        this.currSize = j;
        this.totalSize = j2;
        this.taskType = i;
    }

    public long getCurrSize() {
        return this.currSize;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public long getTotalSize() {
        return this.totalSize;
    }
}
