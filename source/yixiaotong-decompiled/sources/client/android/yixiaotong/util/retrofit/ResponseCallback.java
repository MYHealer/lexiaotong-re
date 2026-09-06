package client.android.yixiaotong.util.retrofit;

import client.android.yixiaotong.util.retrofit.client.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ResponseCallback implements Callback<Response> {
    public abstract void success(Response response);

    @Override // client.android.yixiaotong.util.retrofit.Callback
    public void success(Response response, Response response2) {
        success(response);
    }
}
