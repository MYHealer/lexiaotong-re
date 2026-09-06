package com.opos.mobad.template.cmn;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ae {
    public static Animator a(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(250L);
        float y = view.getY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("y", (view.getHeight() / 2) + y, y));
        objectAnimatorOfPropertyValuesHolder.setDuration(267L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfPropertyValuesHolder);
        return animatorSet;
    }

    public static Animator a(RelativeLayout relativeLayout) {
        relativeLayout.removeAllViews();
        Context context = relativeLayout.getContext();
        int iA = com.opos.cmn.an.h.f.a.a(context, 141.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, -1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.opos_mobad_btn_splash);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAlpha(0.0f);
        relativeLayout.addView(imageView, layoutParams);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("x", iA * (-1), relativeLayout.getWidth()), PropertyValuesHolder.ofFloat("alpha", 1.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1217L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolatorCreate);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(217L);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static Animator a(final l lVar) {
        Context context = lVar.getContext();
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(lVar, "alpha", 1.0f, 1.0f);
        com.opos.mobad.template.a.d dVar = new com.opos.mobad.template.a.d();
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.5f, 1.0f), 450L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 1.0f, 0.0f), 400L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 0.0f), 70L);
        objectAnimatorOfFloat.setEvaluator(dVar);
        objectAnimatorOfFloat.setDuration(920L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        float fA = com.opos.cmn.an.h.f.a.a(context, 30.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fA, fA);
        com.opos.mobad.template.a.d dVar2 = new com.opos.mobad.template.a.d();
        dVar2.a(new com.opos.mobad.template.a.e(interpolatorCreate, fA, 0.0f), 450L);
        dVar2.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 0.0f), 400L);
        dVar2.a(new com.opos.mobad.template.a.e(interpolatorCreate, fA, fA), 70L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.template.cmn.ae.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                lVar.a(((Float) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfFloat.setEvaluator(dVar2);
        valueAnimatorOfFloat.setDuration(920L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat);
        return animatorSet;
    }

    public static Animator b(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(250L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(267L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfPropertyValuesHolder);
        return animatorSet;
    }

    public static Animator b(RelativeLayout relativeLayout) {
        relativeLayout.removeAllViews();
        Context context = relativeLayout.getContext();
        int iA = com.opos.cmn.an.h.f.a.a(context, 72.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, -1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.opos_mobad_btn_splash_2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAlpha(0.0f);
        relativeLayout.addView(imageView, layoutParams);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        relativeLayout.getWidth();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("x", iA * (-1), iA), PropertyValuesHolder.ofFloat("alpha", 1.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1217L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolatorCreate);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(217L);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static Animator b(final l lVar) {
        int iA = com.opos.cmn.an.h.f.a.a(lVar.getContext(), 28.0f);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iA, 0);
        valueAnimatorOfInt.setDuration(333L);
        valueAnimatorOfInt.setInterpolator(interpolatorCreate);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.template.cmn.ae.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                lVar.setAlpha(1.0f);
                lVar.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(lVar, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(interpolatorCreate);
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt2.setDuration(83L);
        valueAnimatorOfInt2.setInterpolator(interpolatorCreate);
        ValueAnimator valueAnimatorOfInt3 = ValueAnimator.ofInt(iA, 0);
        valueAnimatorOfInt3.setDuration(333L);
        valueAnimatorOfInt3.setInterpolator(interpolatorCreate);
        valueAnimatorOfInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.template.cmn.ae.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                lVar.setAlpha(1.0f);
                lVar.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lVar, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(167L);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfInt, objectAnimatorOfFloat, valueAnimatorOfInt2, valueAnimatorOfInt3, objectAnimatorOfFloat2);
        return animatorSet;
    }

    public static Animator c(View view) {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        int iA = com.opos.cmn.an.h.f.a.a(view.getContext(), 10.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(view.getContext(), 5.0f);
        int iA3 = com.opos.cmn.an.h.f.a.a(view.getContext(), 3.0f);
        float x = view.getX();
        float f = iA;
        float f2 = x + f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "x", x, f2);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(interpolatorCreate);
        float f3 = x - f;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "x", f2, f3);
        objectAnimatorOfFloat2.setDuration(133L);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
        float f4 = iA2 + x;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "x", f3, f4);
        objectAnimatorOfFloat3.setDuration(100L);
        objectAnimatorOfFloat3.setInterpolator(interpolatorCreate);
        float f5 = x - iA3;
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "x", f4, f5);
        objectAnimatorOfFloat4.setDuration(83L);
        objectAnimatorOfFloat4.setInterpolator(interpolatorCreate);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, "x", f5, x);
        objectAnimatorOfFloat5.setDuration(67L);
        objectAnimatorOfFloat5.setInterpolator(interpolatorCreate);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5);
        return animatorSet;
    }

    public static Animator c(RelativeLayout relativeLayout) {
        relativeLayout.removeAllViews();
        Context context = relativeLayout.getContext();
        int iA = com.opos.cmn.an.h.f.a.a(context, 178.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, -1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.opos_mobad_btn_splash_2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAlpha(0.0f);
        relativeLayout.addView(imageView, layoutParams);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        relativeLayout.getWidth();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("x", iA * (-1), iA), PropertyValuesHolder.ofFloat("alpha", 1.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1217L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolatorCreate);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(217L);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static Animator d(View view) {
        Context context = view.getContext();
        view.setPivotX(com.opos.cmn.an.h.f.a.a(context, 60.0f));
        view.setPivotY(com.opos.cmn.an.h.f.a.a(context, 60.0f));
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 0.0f);
        com.opos.mobad.template.a.d dVar = new com.opos.mobad.template.a.d();
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 30.0f), 250L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 30.0f, -25.0f), 217L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, -25.0f, 15.0f), 167L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 15.0f, -10.0f), 167L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, -10.0f, 5.0f), 133L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 5.0f, 0.0f), 117L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 0.0f), 617L);
        objectAnimatorOfFloat.setEvaluator(dVar);
        objectAnimatorOfFloat.setDuration(dVar.a());
        objectAnimatorOfFloat.setRepeatCount(-1);
        return objectAnimatorOfFloat;
    }

    public static Animator d(RelativeLayout relativeLayout) {
        relativeLayout.removeAllViews();
        Context context = relativeLayout.getContext();
        int iA = com.opos.cmn.an.h.f.a.a(context, 296.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, -1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.opos_mobad_btn_splash_2);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAlpha(0.0f);
        relativeLayout.addView(imageView, layoutParams);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("x", iA * (-1), iA), PropertyValuesHolder.ofFloat("alpha", 1.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1217L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolatorCreate);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(217L);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static Animator e(View view) {
        Context context = view.getContext();
        view.setPivotX(com.opos.cmn.an.h.f.a.a(context, 27.0f));
        view.setPivotY(com.opos.cmn.an.h.f.a.a(context, 27.0f));
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 0.0f);
        com.opos.mobad.template.a.d dVar = new com.opos.mobad.template.a.d();
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 30.0f), 250L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 30.0f, -25.0f), 217L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, -25.0f, 15.0f), 167L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 15.0f, -10.0f), 167L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, -10.0f, 5.0f), 133L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 5.0f, 0.0f), 117L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 0.0f), 617L);
        objectAnimatorOfFloat.setEvaluator(dVar);
        objectAnimatorOfFloat.setDuration(dVar.a());
        objectAnimatorOfFloat.setRepeatCount(-1);
        return objectAnimatorOfFloat;
    }

    public static Animator f(View view) {
        Context context = view.getContext();
        view.setPivotX(com.opos.cmn.an.h.f.a.a(context, 27.0f));
        view.setPivotY(com.opos.cmn.an.h.f.a.a(context, 27.0f));
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 0.0f);
        com.opos.mobad.template.a.d dVar = new com.opos.mobad.template.a.d();
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 15.0f), 250L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 15.0f, -10.0f), 217L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, -10.0f, 15.0f), 167L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 15.0f, -10.0f), 167L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, -10.0f, 5.0f), 133L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 5.0f, 0.0f), 117L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 0.0f), 617L);
        objectAnimatorOfFloat.setEvaluator(dVar);
        objectAnimatorOfFloat.setDuration(dVar.a());
        objectAnimatorOfFloat.setRepeatCount(-1);
        return objectAnimatorOfFloat;
    }

    public static Animator g(View view) {
        Context context = view.getContext();
        view.setPivotX(com.opos.cmn.an.h.f.a.a(context, 27.0f));
        view.setPivotY(com.opos.cmn.an.h.f.a.a(context, 27.0f));
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 0.0f);
        com.opos.mobad.template.a.d dVar = new com.opos.mobad.template.a.d();
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 30.0f), 250L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 30.0f, -25.0f), 217L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, -25.0f, 15.0f), 167L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 15.0f, -10.0f), 167L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, -10.0f, 5.0f), 133L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 5.0f, 0.0f), 117L);
        dVar.a(new com.opos.mobad.template.a.e(interpolatorCreate, 0.0f, 0.0f), 617L);
        objectAnimatorOfFloat.setEvaluator(dVar);
        objectAnimatorOfFloat.setDuration(dVar.a());
        objectAnimatorOfFloat.setRepeatCount(-1);
        return objectAnimatorOfFloat;
    }
}
