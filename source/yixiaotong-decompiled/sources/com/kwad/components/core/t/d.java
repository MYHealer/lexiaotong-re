package com.kwad.components.core.t;

import android.R;
import android.app.Activity;
import android.view.Window;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bd;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    public static boolean wJ() {
        return true;
    }

    public static void a(Activity activity, int i, boolean z) {
        a(activity, 0, true, true);
    }

    public static void a(Activity activity, int i, boolean z, boolean z2) {
        if (wJ()) {
            b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static void b(Activity activity, int i, boolean z) {
        int i2;
        Window window = activity.getWindow();
        if (z) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (bd.Wb()) {
                a(activity, true);
            } else if (bd.Wc()) {
                p.b(activity, true);
            }
            i2 = 9472;
        } else {
            i2 = MediaDiscoverer.Event.Started;
        }
        window.getDecorView().setSystemUiVisibility(i2);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    private static boolean a(Activity activity, boolean z) {
        try {
            int iIntValue = ((Integer) ab.au("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            ab.callMethod(activity.getWindow(), "setExtraFlags", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
