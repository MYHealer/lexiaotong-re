package client.android.yixiaotong.util.retrofit.client;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface Client {

    public interface Provider {
        Client get();
    }

    Response execute(Request request) throws IOException;
}
