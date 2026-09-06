package com.opos.mobad.template.cmn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class q extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7523a;
    public int b;
    private int c;

    public q() {
        this(0);
    }

    public q(int i) {
        this.b = -1;
        a(i);
    }

    private void a(View view, long j) {
        ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.9f).setDuration(j).start();
        ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.9f).setDuration(j).start();
    }

    private void b(final View view, long j) {
        ObjectAnimator.ofFloat(view, "scaleX", 0.9f, 1.0f).setDuration(j).start();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "scaleY", 0.9f, 1.0f).setDuration(j);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.template.cmn.q.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (view != null) {
                    q.this.b = -1;
                    view.clearAnimation();
                }
                super.onAnimationEnd(animator);
            }
        });
        duration.start();
    }

    public void a(int i) {
        this.f7523a = i;
        if (i != 0) {
            float[] fArr = new float[3];
            ColorUtils.colorToHSL(i, fArr);
            fArr[1] = fArr[1] * 0.9f;
            fArr[2] = fArr[2] * 0.9f;
            this.c = ColorUtils.HSLToColor(fArr);
        }
    }

    @Override // com.opos.mobad.template.cmn.p, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.onTouch(view, motionEvent);
        if (motionEvent.getAction() == 0) {
            this.b = 0;
            int i = this.c;
            if (i != 0) {
                view.setBackgroundColor(i);
            }
            a(view, 300L);
        } else if (1 == motionEvent.getAction()) {
            this.b = 1;
            int i2 = this.f7523a;
            if (i2 != 0) {
                view.setBackgroundColor(i2);
            }
            b(view, 300L);
        } else if (3 == motionEvent.getAction()) {
            this.b = 3;
        }
        return false;
    }
}
