package com.facebook.common.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class Suppliers {
    public static <T> Supplier<T> of(final T t) {
        return new Supplier<T>() { // from class: com.facebook.common.internal.Suppliers.1
            @Override // com.facebook.common.internal.Supplier
            public T get() {
                return (T) t;
            }
        };
    }
}
