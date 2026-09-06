package com.byazt.xc;

import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 674, 20})
public class c {
    public static AnimationSet c() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setFillAfter(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation2.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        translateAnimation2.setStartOffset(1000L);
        translateAnimation2.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(translateAnimation2);
        return animationSet;
    }

    public static AnimationSet tt() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(1000L);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    public static AnimationSet ve() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
        translateAnimation.setDuration(1000L);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }
}
