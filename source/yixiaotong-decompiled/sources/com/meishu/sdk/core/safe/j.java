package com.meishu.sdk.core.safe;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: SafeOnScrollChangedListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j implements ViewTreeObserver.OnScrollChangedListener {
    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        try {
            safeOnScrollChanged();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void safeOnScrollChanged() {
    }
}
