package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpConnection;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface HttpConnectionFactory<T extends HttpConnection> {
    T createConnection(Socket socket) throws IOException;
}
