package com.ubix.ssp.ad.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f8837a;
    private int b;
    private int c;
    private int d;
    private float e;
    private AnimatorSet f;
    private ImageView g;
    private ImageView h;
    private int i;
    private String j;
    private String k;

    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (n.this.f != null) {
                n.this.f.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public n(Context context, boolean z, boolean z2) {
        super(context);
        this.f8837a = 4.0d;
        this.e = 250.0f;
        this.f = null;
        this.i = 1300;
        this.j = "向上滑动!";
        this.k = "跳转详情或第三方应用!";
        double dA = com.ubix.ssp.ad.e.a0.r.a().a(context);
        this.f8837a = dA;
        int i = (int) (dA * 54.0d);
        this.b = i;
        double d = i;
        this.c = (int) (0.65d * d);
        this.d = (int) (d * 0.8d);
        a(z, z2);
        b();
        setLayoutParams(new RelativeLayout.LayoutParams(-2, MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION));
    }

    private void a(boolean z, boolean z2) {
        if (z2) {
            try {
                double d = this.b;
                this.e = (float) (0.8d * d);
                int i = (int) (d * 0.7d);
                this.b = i;
                this.c = (int) (((double) i) * 0.6d);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        TextView textView = new TextView(getContext());
        TextView textView2 = new TextView(getContext());
        textView.setId(910203);
        textView2.setId(910204);
        textView.setText(this.j);
        textView2.setText(this.k);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
        textView.getPaint().setFakeBoldText(true);
        textView.setTextSize(16.0f);
        if (!z) {
            textView.setVisibility(4);
            textView2.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, 910204);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = (int) (this.f8837a * 8.0d);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(12);
        layoutParams2.addRule(14);
        layoutParams2.bottomMargin = (int) (this.f8837a * 8.0d);
        addView(textView2, layoutParams2);
        addView(textView, layoutParams);
        this.g = new ImageView(getContext());
        ImageView imageView = new ImageView(getContext());
        this.h = imageView;
        imageView.setAlpha(0.0f);
        this.g.setImageDrawable(q.a("ubix/ic_hand_common.webp"));
        this.h.setBackgroundDrawable(com.ubix.ssp.ad.e.a0.c.a(Color.parseColor("#bbffffff"), Color.parseColor("#00ffffff"), 12));
        int i2 = this.b;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i2);
        if (z) {
            layoutParams3.addRule(2, 910203);
        } else {
            layoutParams3.addRule(12);
        }
        layoutParams3.addRule(14);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.c, this.d);
        if (z) {
            layoutParams4.addRule(2, 910203);
        } else {
            layoutParams4.addRule(12);
        }
        layoutParams4.addRule(14);
        double d2 = this.f8837a;
        layoutParams3.bottomMargin = (int) (((double) (z2 ? 2 : 4)) * d2);
        layoutParams4.bottomMargin = (int) (d2 * ((double) (z2 ? 2 : 4)));
        addView(this.h, layoutParams4);
        addView(this.g, layoutParams3);
    }

    private void b() {
        synchronized (this) {
            try {
                if (this.g != null && this.h != null) {
                    if (this.f == null) {
                        this.f = new AnimatorSet();
                    }
                    float f = this.e;
                    float f2 = -((float) ((((double) f) * 0.95d) / 8.0d));
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "translationY", 0.0f, f2, 2.0f * f2, 3.0f * f2, 4.0f * f2, 5.0f * f2, 6.0f * f2, 7.0f * f2, f2 * 8.0f, -f);
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.g, "alpha", 0.3f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.7f, 0.0f);
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.h, "alpha", 0.0f, 0.0f, 0.7f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.3f, 0.0f, 0.0f);
                    ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.h, "scaleY", 0.75f, this.e / 100.0f);
                    this.h.setPivotY(this.d);
                    ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.g, "alpha", 0.0f, 0.0f);
                    objectAnimatorOfFloat.setDuration(this.i);
                    objectAnimatorOfFloat2.setDuration(this.i);
                    objectAnimatorOfFloat3.setDuration(this.i);
                    objectAnimatorOfFloat4.setDuration(this.i);
                    objectAnimatorOfFloat5.setDuration(400L);
                    this.f.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).after(objectAnimatorOfFloat5);
                    this.f.setInterpolator(new DecelerateInterpolator());
                    this.f.addListener(new a());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                AnimatorSet animatorSet = this.f;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.f.removeAllListeners();
                    this.f = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this) {
            try {
                if (this.f == null) {
                    b();
                }
                AnimatorSet animatorSet = this.f;
                if (animatorSet != null) {
                    animatorSet.start();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            c();
        } else {
            a();
        }
    }

    public void setDuration(int i) {
        this.i = i;
    }

    public void setMoveDistance(float f) {
        this.e = f;
    }
}
