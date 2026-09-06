package com.yfanads.android.utils.log.writer;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class Writer {
    public abstract void appendLog(String str);

    public abstract boolean close();

    public abstract File getOpenedFile();

    public abstract String getOpenedFileName();

    public abstract boolean isOpened();

    public abstract boolean open(File file);
}
