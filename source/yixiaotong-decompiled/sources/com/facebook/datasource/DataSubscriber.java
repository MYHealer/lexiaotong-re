package com.facebook.datasource;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface DataSubscriber<T> {
    void onCancellation(DataSource<T> dataSource);

    void onFailure(DataSource<T> dataSource);

    void onNewResult(DataSource<T> dataSource);

    void onProgressUpdate(DataSource<T> dataSource);
}
