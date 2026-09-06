package com.opos.cmn.biz.web.base.activity.a.a;

import android.app.Activity;
import android.graphics.Color;
import android.view.Window;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static void a(Activity activity) {
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }

    private static void a(Activity activity, boolean z) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                window.getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Utils", "", e);
            }
        }
    }

    public static void b(Activity activity) {
        if (activity != null) {
            try {
                if (activity.getWindow() != null) {
                    Window window = activity.getWindow();
                    window.getDecorView().setSystemUiVisibility(MediaDiscoverer.Event.Started);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(Color.parseColor("#F5EEEEEE"));
                    a(activity, !com.opos.cmn.biz.web.b.a.a.a(activity));
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Utils", "setWhiteStatusBar", e);
            }
        }
    }
}
