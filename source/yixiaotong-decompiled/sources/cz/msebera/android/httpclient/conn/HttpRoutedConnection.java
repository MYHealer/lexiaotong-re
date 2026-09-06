package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@Deprecated
public interface HttpRoutedConnection extends HttpInetConnection {
    HttpRoute getRoute();

    SSLSession getSSLSession();

    boolean isSecure();
}
