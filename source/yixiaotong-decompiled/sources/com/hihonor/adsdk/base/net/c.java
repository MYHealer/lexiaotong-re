package com.hihonor.adsdk.base.net;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class c<T> implements Callback<T> {
    abstract void hnadsa(Call<T> call, Throwable th);

    abstract void hnadsa(Call<T> call, Response<T> response);

    @Override // retrofit2.Callback
    public final void onFailure(Call<T> call, Throwable th) {
        hnadsa(call, th);
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call<T> call, Response<T> response) {
        hnadsa(call, response);
    }
}
