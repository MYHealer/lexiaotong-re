package cz.msebera.android.httpclient.client.cache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class InputLimit {
    private boolean reached = false;
    private final long value;

    public long getValue() {
        return this.value;
    }

    public boolean isReached() {
        return this.reached;
    }

    public void reached() {
        this.reached = true;
    }

    public InputLimit(long j) {
        this.value = j;
    }
}
