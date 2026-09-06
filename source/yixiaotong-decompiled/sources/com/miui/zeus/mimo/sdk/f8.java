package com.miui.zeus.mimo.sdk;

import android.animation.ValueAnimator;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f8 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadButtonICP f5427a;

    public f8(DownloadButtonICP downloadButtonICP) {
        this.f5427a = downloadButtonICP;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        DownloadButtonICP downloadButtonICP = this.f5427a;
        if (downloadButtonICP.w != 1) {
            float f = (fFloatValue * 0.11f) + 0.89f;
            downloadButtonICP.setScaleX(f);
            this.f5427a.setScaleY(f);
        } else {
            downloadButtonICP.setPivotY(downloadButtonICP.getHeight());
            float f2 = (fFloatValue * 0.11f) + 0.89f;
            this.f5427a.setScaleY(f2);
            this.f5427a.l.setScaleX(f2);
        }
    }
}
