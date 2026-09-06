package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class c extends KSFrameLayout {
    private Animator qU;
    private boolean qV;

    protected void a(Context context, AttributeSet attributeSet, int i) {
    }

    protected abstract Animator fZ();

    protected abstract int getAnimationDelayTime();

    protected abstract View getInteractionView();

    protected abstract void oa();

    protected abstract void ob();

    public c(Context context) {
        this(context, null, 0);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qV = false;
        a(context, attributeSet, i);
        oa();
    }

    public final void fY() {
        Animator animator = this.qU;
        if (animator != null) {
            animator.cancel();
            this.qU = null;
        }
        Animator animatorFZ = fZ();
        this.qU = animatorFZ;
        if (animatorFZ != null) {
            animatorFZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (c.this.qV) {
                        return;
                    }
                    c.this.getInteractionView().postDelayed(new bi() { // from class: com.kwad.components.ad.splashscreen.widget.c.1.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            if (c.this.qU != null) {
                                c.this.qU.start();
                            }
                        }
                    }, c.this.getAnimationDelayTime());
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    c.this.ob();
                }
            });
            this.qU.start();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        Animator animator = this.qU;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void oc() {
        this.qV = true;
        Animator animator = this.qU;
        if (animator != null) {
            animator.cancel();
        }
    }
}
