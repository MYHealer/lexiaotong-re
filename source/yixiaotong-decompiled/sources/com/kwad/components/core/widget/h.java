package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h extends ViewOutlineProvider {
    private float awz;

    private h(float f) {
        this.awz = f;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.awz);
    }

    public static void f(View view, float f) {
        if (f <= 0.0f) {
            view.setOutlineProvider(null);
            view.setClipToOutline(false);
        } else {
            view.setOutlineProvider(new h(f));
            view.setClipToOutline(true);
        }
    }
}
