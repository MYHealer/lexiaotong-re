package com.meishu.sdk.meishu_ad.view.player.media.datasouce.download;

import java.io.RandomAccessFile;

/* JADX INFO: compiled from: IBaseDownloader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a {
    void a(long j);

    void a(String str, long j, int i, RandomAccessFile randomAccessFile);

    boolean a(RandomAccessFile randomAccessFile, long j);

    void close();
}
