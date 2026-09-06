package com.bytedance.android.live.base.api.callback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface CommonCallback<T, D> {
    void onFail(D d);

    void onSuccess(T t);
}
