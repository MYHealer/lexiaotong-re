package com.miui.zeus.mimo.sdk;

import android.animation.Animator;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g8 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadButtonICP f5442a;

    public g8(DownloadButtonICP downloadButtonICP) {
        this.f5442a = downloadButtonICP;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f5442a.setScaleX(1.0f);
        this.f5442a.setScaleY(1.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f5442a.setScaleX(1.0f);
        this.f5442a.setScaleY(1.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
