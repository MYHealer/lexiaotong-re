package com.miui.zeus.mimo.sdk.ad.reward.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.a0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardMaskBView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f5309a;
    public TextView b;
    public ViewGroup c;
    public ValueAnimator d;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ViewGroup viewGroup = RewardMaskBView.this.c;
            if (viewGroup != null) {
                viewGroup.setScaleX(fFloatValue);
                RewardMaskBView.this.c.setScaleY(fFloatValue);
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ViewGroup viewGroup = RewardMaskBView.this.c;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
        }
    }

    public RewardMaskBView(Context context) {
        super(context);
    }

    public RewardMaskBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RewardMaskBView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.d.addUpdateListener(new a());
        this.d.addListener(new b());
        this.d.start();
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.f5309a.setVisibility(8);
        } else {
            this.f5309a.setText(str);
            this.f5309a.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.b.setVisibility(8);
        } else {
            this.b.setText(str2);
            this.b.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.d.removeAllUpdateListeners();
            this.d.removeAllListeners();
            this.d = null;
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.c = (ViewGroup) findViewById(a0.G4);
        this.f5309a = (TextView) findViewById(a0.O4);
        this.b = (TextView) findViewById(a0.g1);
        this.c.setVisibility(4);
        a();
    }

    public void setMaxWith(int i) {
        this.f5309a.setMaxWidth(i);
        this.b.setMaxWidth(i);
    }
}
