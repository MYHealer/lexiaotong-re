package client.android.yixiaotong.util.retrofit;

import client.android.yixiaotong.util.retrofit.client.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface Callback<T> {
    void failure(RetrofitError retrofitError);

    void success(T t, Response response);
}
