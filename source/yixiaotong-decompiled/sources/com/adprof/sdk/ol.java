package com.adprof.sdk;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ol implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rl f1349a;

    public ol(rl rlVar) {
        this.f1349a = rlVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int height = this.f1349a.getHeight();
        int width = this.f1349a.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        this.f1349a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ViewGroup.LayoutParams layoutParams = this.f1349a.f706a.getLayoutParams();
        int i = height / 2;
        layoutParams.width = i;
        layoutParams.height = i;
        this.f1349a.f706a.setLayoutParams(layoutParams);
        float f = i;
        this.f1349a.f706a.setPivotX(f);
        this.f1349a.f706a.setPivotY(f * 0.8f);
    }
}
