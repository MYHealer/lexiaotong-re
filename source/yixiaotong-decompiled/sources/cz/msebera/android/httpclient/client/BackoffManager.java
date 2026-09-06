package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface BackoffManager {
    void backOff(HttpRoute httpRoute);

    void probe(HttpRoute httpRoute);
}
