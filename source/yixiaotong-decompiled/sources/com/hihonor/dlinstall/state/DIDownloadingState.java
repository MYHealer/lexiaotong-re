package com.hihonor.dlinstall.state;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DIDownloadingState extends DIState {
    private final long currSize;
    private final String pkgName;
    private final float speed;
    private final int taskType;
    private final long totalSize;

    public DIDownloadingState(String str, long j, long j2, float f) {
        this.pkgName = str;
        this.currSize = j;
        this.totalSize = j2;
        this.speed = f;
        this.taskType = 0;
    }

    public DIDownloadingState(String str, long j, long j2, float f, int i) {
        this.pkgName = str;
        this.currSize = j;
        this.totalSize = j2;
        this.speed = f;
        this.taskType = i;
    }

    public long getCurrSize() {
        return this.currSize;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public float getSpeed() {
        return this.speed;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public long getTotalSize() {
        return this.totalSize;
    }
}
