package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
class AnimatorTracker {
    private Animator currentAnimator;

    public void clear() {
        this.currentAnimator = null;
    }

    AnimatorTracker() {
    }

    public void onNextAnimationStart(Animator animator) {
        cancelCurrent();
        this.currentAnimator = animator;
    }

    public void cancelCurrent() {
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }
}
