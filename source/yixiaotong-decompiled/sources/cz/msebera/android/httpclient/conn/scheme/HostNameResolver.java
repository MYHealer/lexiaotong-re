package cz.msebera.android.httpclient.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@Deprecated
public interface HostNameResolver {
    InetAddress resolve(String str) throws IOException;
}
