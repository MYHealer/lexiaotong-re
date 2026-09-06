package com.yfanads.android.libs;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class AbsCallback<T> {
    private final SoftReference<T> mSoftReference;

    public AbsCallback(T t) {
        this.mSoftReference = new SoftReference<>(t);
    }

    public T get() {
        return this.mSoftReference.get();
    }
}
