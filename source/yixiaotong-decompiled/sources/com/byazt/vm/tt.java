package com.byazt.vm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 13})
public abstract class tt<T> {
    public volatile T c;

    public abstract T c(Object... objArr);

    public final T tt(Object... objArr) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = c(objArr);
                }
            }
        }
        return this.c;
    }
}
