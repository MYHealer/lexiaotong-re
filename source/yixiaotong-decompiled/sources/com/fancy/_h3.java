package com.fancy;

import android.view.Surface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _h3 implements Runnable {
    public final /* synthetic */ Surface _a;

    public _h3(Surface surface) {
        this._a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this._a.release();
        } catch (Throwable unused) {
        }
    }
}
