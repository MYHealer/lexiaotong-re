package com.byazt.of;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1217, 54})
public abstract class ve {
    public static tt c(RandomAccessFile randomAccessFile, long j, long j2) {
        return c(randomAccessFile.getChannel(), j, j2);
    }

    public static tt c(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new uj(fileChannel, j, j2);
    }
}
