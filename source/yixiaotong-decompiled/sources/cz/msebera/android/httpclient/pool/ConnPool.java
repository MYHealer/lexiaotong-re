package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.concurrent.FutureCallback;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface ConnPool<T, E> {
    Future<E> lease(T t, Object obj, FutureCallback<E> futureCallback);

    void release(E e, boolean z);
}
