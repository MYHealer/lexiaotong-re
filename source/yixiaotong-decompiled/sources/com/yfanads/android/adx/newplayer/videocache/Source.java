package com.yfanads.android.adx.newplayer.videocache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface Source {
    void close();

    long length();

    void open(long j);

    int read(byte[] bArr);
}
