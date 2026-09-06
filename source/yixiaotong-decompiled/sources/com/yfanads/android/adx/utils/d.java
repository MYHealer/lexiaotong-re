package com.yfanads.android.adx.utils;

import android.R;
import android.app.Activity;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: compiled from: StatusBar.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d {
    public static void a(Activity activity) {
        activity.getWindow().setFlags(1024, 1024);
    }

    public static void b(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(MediaDiscoverer.Event.Started);
        activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.transparent));
    }
}
