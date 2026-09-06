package com.byazt.oq;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.nr.z;
import com.byazt.or.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 972})
public class HandLongPressView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f2585a;
    public Context c;
    public boolean n;
    public ImageView tt;
    public AnimatorSet uj;
    public CircleRippleView ve;

    public HandLongPressView(Context context) {
        super(context);
        this.n = true;
        this.c = context;
        this.uj = new AnimatorSet();
        ve();
        uj();
        post(new Runnable() { // from class: com.byazt.oq.HandLongPressView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HandLongPressView.this.tt.getLayoutParams();
                layoutParams.topMargin = ((int) ((HandLongPressView.this.ve.getMeasuredHeight() / 2.0f) - x.c(HandLongPressView.this.getContext(), 5.0f))) + ((int) x.c(HandLongPressView.this.c, 20.0f));
                layoutParams.leftMargin = ((int) ((HandLongPressView.this.ve.getMeasuredWidth() / 2.0f) - x.c(HandLongPressView.this.getContext(), 5.0f))) + ((int) x.c(HandLongPressView.this.c, 20.0f));
                layoutParams.bottomMargin = (int) (((-HandLongPressView.this.ve.getMeasuredHeight()) / 2.0f) + x.c(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-HandLongPressView.this.ve.getMeasuredWidth()) / 2.0f) + x.c(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                HandLongPressView.this.tt.setLayoutParams(layoutParams);
            }
        });
    }

    private void ve() {
        this.ve = new CircleRippleView(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) x.c(this.c, 80.0f), (int) x.c(this.c, 80.0f));
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.topMargin = (int) x.c(this.c, 20.0f);
        layoutParams.leftMargin = (int) x.c(this.c, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.ve, layoutParams);
        this.ve.c();
        this.tt = new ImageView(this.c);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.c(this.c, 80.0f), (int) x.c(this.c, 80.0f));
        z.c(this.c, "tt_splash_hand", this.tt, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.tt, layoutParams2);
        TextView textView = new TextView(this.c);
        this.f2585a = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) x.c(this.c, 10.0f);
        addView(this.f2585a, layoutParams3);
    }

    private void uj() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tt, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.oq.HandLongPressView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(HandLongPressView.this.tt, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                HandLongPressView.this.tt.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (HandLongPressView.this.n) {
                    HandLongPressView.this.ve.c();
                    HandLongPressView.this.ve.setAlpha(1.0f);
                } else {
                    HandLongPressView.this.ve.tt();
                    HandLongPressView.this.ve.setAlpha(0.0f);
                }
                HandLongPressView handLongPressView = HandLongPressView.this;
                handLongPressView.n = !handLongPressView.n;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.tt, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.uj.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.f2585a.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.f2585a.setTextColor(i);
    }

    public void c() {
        this.uj.start();
    }

    public void tt() {
        AnimatorSet animatorSet = this.uj;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CircleRippleView circleRippleView = this.ve;
        if (circleRippleView != null) {
            circleRippleView.tt();
        }
    }
}
