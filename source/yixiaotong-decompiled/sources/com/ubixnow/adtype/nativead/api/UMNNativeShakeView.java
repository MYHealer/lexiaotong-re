package com.ubixnow.adtype.nativead.api;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.ubixnow.core.R;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNNativeShakeView extends RelativeLayout {
    private ObjectAnimator animator;

    public UMNNativeShakeView(Context context) {
        super(context);
    }

    public UMNNativeShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UMNNativeShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void changeOnlyImageSize(int i) {
        TextView textView = (TextView) findViewById(R.id.tv_shake);
        ImageView imageView = (ImageView) findViewById(R.id.iv_shake_icon);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        int i2 = i / 10;
        imageView.setPadding(i2, i2, i2, i2);
        textView.setVisibility(8);
        post(new Runnable() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeShakeView.1
            @Override // java.lang.Runnable
            public void run() {
                UMNNativeShakeView.this.startShakeAnim();
            }
        });
    }

    public void changeSize(int i, int i2) {
        ooooO000.OooO0O0("----shake view", "width:" + i);
        ImageView imageView = (ImageView) findViewById(R.id.iv_shake_icon);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int i3 = (i2 * 11) / 20;
        layoutParams.height = i3;
        layoutParams.width = i3;
        imageView.setLayoutParams(layoutParams);
        int i4 = i2 / 10;
        imageView.setPadding(i4, i4, i4, i4);
        invalidate();
        post(new Runnable() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeShakeView.2
            @Override // java.lang.Runnable
            public void run() {
                UMNNativeShakeView.this.startShakeAnim();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ooooO000.OooO0O0("----shake view", "onDetachedFromWindow");
        removeAnim();
    }

    public void removeAnim() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.animator = null;
        }
    }

    public Animation startShakeAnim() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_shake_icon);
        if (imageView == null || this.animator != null) {
            return null;
        }
        imageView.setPivotX(imageView.getWidth());
        imageView.setPivotY(imageView.getWidth());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, Key.ROTATION, 0.0f, 2.0f, -6.0f, 6.0f, -6.0f, 3.0f, 0.0f);
        this.animator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setStartDelay(500L);
        this.animator.setDuration(1800L);
        this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.animator.setRepeatCount(-1);
        this.animator.start();
        return null;
    }
}
