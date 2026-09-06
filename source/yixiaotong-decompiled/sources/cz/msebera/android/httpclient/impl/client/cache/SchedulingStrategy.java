package cz.msebera.android.httpclient.impl.client.cache;

import java.io.Closeable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface SchedulingStrategy extends Closeable {
    void schedule(AsynchronousValidationRequest asynchronousValidationRequest);
}
