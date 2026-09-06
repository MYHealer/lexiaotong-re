package com.miui.zeus.mimo.sdk.view.wave;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import ijiami_1011.s.s.s;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class IconWaveAnimView extends RelativeLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f5718a;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5719a;

        public a(i8 i8Var) {
            this.f5719a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i8 i8Var = this.f5719a;
            if (i8Var != null) {
                i8Var.onClick(view, IconWaveAnimView.this.getClickAreaType());
            }
        }
    }

    public IconWaveAnimView(Context context) {
        super(context);
        a();
    }

    public IconWaveAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public IconWaveAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(s.d(new byte[]{69, Ascii.SYN, 89, 10, 71, 88, 0, 16, 15, 13, 95, Base64.padSymbol}, "1d8d44"), Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.16f, 6.5f), Keyframe.ofFloat(0.36f, 22.5f), Keyframe.ofFloat(0.536f, 23.5f), Keyframe.ofFloat(0.816f, -5.5f), Keyframe.ofFloat(1.0f, 0.0f)), PropertyValuesHolder.ofKeyframe(s.d(new byte[]{68, 71, 83, 86, 17, 13, 0, 16, 15, 13, 95, 60}, "0528ba"), Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.16f, -10.0f), Keyframe.ofFloat(0.36f, 12.0f), Keyframe.ofFloat(0.536f, -22.0f), Keyframe.ofFloat(0.816f, 7.5f), Keyframe.ofFloat(1.0f, 0.0f)));
        objectAnimatorOfPropertyValuesHolder.setDuration(5000L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(s.d(new byte[]{67, 88, 69, 80, 65, 92, 14, 10}, "171155"), Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.16f, 4.0f), Keyframe.ofFloat(0.28f, -5.0f), Keyframe.ofFloat(0.456f, 4.0f), Keyframe.ofFloat(0.72f, -6.0f), Keyframe.ofFloat(0.824f, -2.0f), Keyframe.ofFloat(1.0f, 0.0f)));
        objectAnimatorOfPropertyValuesHolder2.setDuration(5000L);
        objectAnimatorOfPropertyValuesHolder2.setInterpolator(new LinearInterpolator());
        objectAnimatorOfPropertyValuesHolder2.setRepeatCount(-1);
        objectAnimatorOfPropertyValuesHolder2.setRepeatMode(1);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5718a = animatorSet;
        animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_PICTURE;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        AnimatorSet animatorSet = this.f5718a;
        if (i != 0) {
            animatorSet.pause();
        } else if (animatorSet.isStarted()) {
            this.f5718a.resume();
        } else {
            this.f5718a.start();
        }
    }

    public void setIClickAreaListener(i8 i8Var) {
        setOnClickListener(new a(i8Var));
    }
}
