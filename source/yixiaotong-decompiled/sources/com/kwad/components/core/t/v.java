package com.kwad.components.core.t;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class v {
    public static void c(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility(MediaDiscoverer.Event.Started);
    }

    public static void d(Window window) {
        View decorView = window.getDecorView();
        decorView.setPadding(0, 0, 0, 0);
        decorView.setBackgroundColor(0);
        window.setLayout(-1, -1);
    }
}
