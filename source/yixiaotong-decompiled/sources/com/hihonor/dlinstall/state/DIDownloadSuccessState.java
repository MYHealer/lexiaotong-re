package com.hihonor.dlinstall.state;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DIDownloadSuccessState extends DIState {
    private final String pkgName;
    private final int taskType;
    private final long totalSize;

    public DIDownloadSuccessState(String str, long j) {
        this.pkgName = str;
        this.totalSize = j;
        this.taskType = 0;
    }

    public DIDownloadSuccessState(String str, long j, int i) {
        this.pkgName = str;
        this.totalSize = j;
        this.taskType = i;
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
