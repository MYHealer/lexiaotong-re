package cz.msebera.android.httpclient.conn;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface DnsResolver {
    InetAddress[] resolve(String str) throws UnknownHostException;
}
