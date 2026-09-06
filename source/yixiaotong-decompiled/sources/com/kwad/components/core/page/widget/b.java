package com.kwad.components.core.page.widget;

import android.content.Context;
import android.view.TextureView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b extends TextureView {
    public b(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
