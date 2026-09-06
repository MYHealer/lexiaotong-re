package com.google.android.exoplayer2.upstream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface TransferListener {
    void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i);

    void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z);

    void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z);

    void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z);
}
