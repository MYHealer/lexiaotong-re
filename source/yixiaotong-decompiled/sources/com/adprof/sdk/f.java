package com.adprof.sdk;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class f extends RelativeLayout {
    public static final int SCREEN_FULLSCREEN = 1;
    public static final int SCREEN_NORMAL = 0;
    public static final int SCREEN_TINY = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f1159a;

    public f(Context context) {
        super(context);
    }

    public abstract j0 getVideoAdController();

    public boolean isCtaClick(MotionEvent motionEvent) {
        return false;
    }
}
