package com.hihonor.dlinstall.state;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DIWaitingState extends DIState {
    private final long currSize;
    private final String pkgName;
    private final int state;
    private final int taskType;
    private final long totalSize;

    public DIWaitingState(String str, long j, long j2, int i, int i2) {
        this.pkgName = str;
        this.state = i;
        this.taskType = i2;
        this.currSize = j;
        this.totalSize = j2;
    }

    public long getCurrSize() {
        return this.currSize;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public int getState() {
        return this.state;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public long getTotalSize() {
        return this.totalSize;
    }
}
