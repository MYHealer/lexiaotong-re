package cz.msebera.android.httpclient.impl.client;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class SystemClock implements Clock {
    SystemClock() {
    }

    @Override // cz.msebera.android.httpclient.impl.client.Clock
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
