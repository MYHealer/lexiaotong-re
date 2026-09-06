package com.hihonor.adsdk.common.f;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsa = "AnimatorUtils";

    class a implements Animator.AnimatorListener {
        final /* synthetic */ c hnadsa;

        a(c cVar) {
            this.hnadsa = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.hnadsa.hnadsa();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.f.b$b, reason: collision with other inner class name */
    class AnimationAnimationListenerC0459b implements Animation.AnimationListener {
        final /* synthetic */ c hnadsa;

        AnimationAnimationListenerC0459b(c cVar) {
            this.hnadsa = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c cVar = this.hnadsa;
            if (cVar != null) {
                cVar.hnadsa();
            }
        }
    }

    public interface c {
        void hnadsa();
    }

    public static void hnadsa(View view, int i, c cVar) {
        FastOutSlowInInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.7f, 1.0f);
        long j = i;
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.setInterpolator(fastOutSlowInInterpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.7f, 1.0f);
        objectAnimatorOfFloat2.setDuration(j);
        objectAnimatorOfFloat2.setInterpolator(fastOutSlowInInterpolator);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setDuration(j);
        objectAnimatorOfFloat3.setInterpolator(fastOutSlowInInterpolator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3);
        animatorSet.addListener(new a(cVar));
        animatorSet.start();
    }

    public static AlphaAnimation hnadsa(View view, long j, c cVar) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new AnimationAnimationListenerC0459b(cVar));
        view.startAnimation(alphaAnimation);
        return alphaAnimation;
    }
}
