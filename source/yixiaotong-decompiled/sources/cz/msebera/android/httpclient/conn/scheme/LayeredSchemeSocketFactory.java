package cz.msebera.android.httpclient.conn.scheme;

import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@Deprecated
public interface LayeredSchemeSocketFactory extends SchemeSocketFactory {
    Socket createLayeredSocket(Socket socket, String str, int i, boolean z) throws IOException;
}
