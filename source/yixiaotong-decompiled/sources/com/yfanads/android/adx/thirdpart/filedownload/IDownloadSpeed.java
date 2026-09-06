package com.yfanads.android.adx.thirdpart.filedownload;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface IDownloadSpeed {

    public interface Lookup {
        int getSpeed();

        void setMinIntervalUpdateSpeed(int i);
    }

    public interface Monitor {
        void end(long j);

        void reset();

        void start(long j);

        void update(long j);
    }
}
