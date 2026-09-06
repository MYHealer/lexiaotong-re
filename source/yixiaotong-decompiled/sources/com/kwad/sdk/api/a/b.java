package com.kwad.sdk.api.a;

import com.kwad.sdk.api.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public void run() {
        try {
            doTask();
        } catch (Throwable th) {
            c.t(th);
        }
    }
}
