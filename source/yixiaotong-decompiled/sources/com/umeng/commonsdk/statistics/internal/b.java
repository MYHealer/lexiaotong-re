package com.umeng.commonsdk.statistics.internal;

/* JADX INFO: compiled from: IRequestStat.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface b {
    void onRequestEnd();

    void onRequestFailed();

    void onRequestStart();

    void onRequestSucceed(boolean z);
}
