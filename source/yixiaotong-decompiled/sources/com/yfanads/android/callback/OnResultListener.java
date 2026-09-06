package com.yfanads.android.callback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface OnResultListener<T> {
    void onFailed(int i, String str);

    void onSuccess(T t);
}
