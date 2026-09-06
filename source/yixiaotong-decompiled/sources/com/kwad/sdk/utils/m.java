package com.kwad.sdk.utils;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class m<T> {
    protected boolean boG = false;
    protected boolean enable;

    protected abstract T cY(Context context);

    public final void cs(boolean z) {
        this.enable = z;
    }

    public m(boolean z) {
        this.enable = z;
    }

    public final T cX(Context context) {
        if (!this.enable || this.boG) {
            return null;
        }
        try {
            return cY(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }
}
