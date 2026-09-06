package com.facebook.datasource;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(DataSource<T> dataSource) {
    }

    protected abstract void onFailureImpl(DataSource<T> dataSource);

    protected abstract void onNewResultImpl(DataSource<T> dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(DataSource<T> dataSource) {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(DataSource<T> dataSource) {
        try {
            onNewResultImpl(dataSource);
        } finally {
            if (dataSource.isFinished()) {
                dataSource.close();
            }
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(DataSource<T> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }
}
