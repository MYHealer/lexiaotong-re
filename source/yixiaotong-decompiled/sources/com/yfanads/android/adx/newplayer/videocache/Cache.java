package com.yfanads.android.adx.newplayer.videocache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface Cache {
    void append(byte[] bArr, int i);

    long available();

    void close();

    void complete();

    boolean isCompleted();

    int read(byte[] bArr, long j, int i);
}
