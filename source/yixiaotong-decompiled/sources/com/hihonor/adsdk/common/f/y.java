package com.hihonor.adsdk.common.f;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class y {
    private static final String hnadsa = "StatusBarUtils";

    public static void hnadsa(Window window) {
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        hnadsa(window, !u.hnadsi());
    }

    public static void hnadsb(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(z);
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
    }

    public static void hnadsa(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                WindowInsetsController windowInsetsController = window.getDecorView().getRootView().getWindowInsetsController();
                if (windowInsetsController != null) {
                    windowInsetsController.setSystemBarsAppearance(z ? 8 : 0, 8);
                    return;
                }
            } catch (Throwable th) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "setAppearanceLightStatusBars error." + th.getMessage(), new Object[0]);
            }
        }
        if (z) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            return;
        }
        View decorView2 = window.getDecorView();
        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
    }

    public static void hnadsa(Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
        hnadsb(window, false);
    }
}
