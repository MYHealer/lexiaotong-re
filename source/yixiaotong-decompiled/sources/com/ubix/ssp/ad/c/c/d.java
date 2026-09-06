package com.ubix.ssp.ad.c.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.ubix.ssp.ad.e.v.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends c {

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            AnimatorSet animatorSet = d.this.i;
            if (animatorSet != null) {
                animatorSet.start();
            }
        }
    }

    public d(Context context, Bundle bundle) {
        super(context, bundle);
    }

    private void a() {
        try {
            View viewFindViewById = findViewById(500104);
            if (viewFindViewById == null) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById, "scaleX", 1.0f, 1.05f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewFindViewById, "scaleY", 1.0f, 1.05f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewFindViewById, "scaleX", 1.05f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewFindViewById, "scaleY", 1.05f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(viewFindViewById, Key.ROTATION, 0.0f, 8.0f, -8.0f, 8.0f, -8.0f, 8.0f, -8.0f, 0.0f);
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(viewFindViewById, "empty", 1.0f, 1.0f);
            long j = 100;
            objectAnimatorOfFloat.setDuration(j);
            objectAnimatorOfFloat2.setDuration(j);
            objectAnimatorOfFloat3.setDuration(j);
            objectAnimatorOfFloat4.setDuration(j);
            objectAnimatorOfFloat5.setDuration(1100);
            objectAnimatorOfFloat6.setDuration(900);
            this.i.play(objectAnimatorOfFloat6).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).before(objectAnimatorOfFloat3).before(objectAnimatorOfFloat4);
            this.i.setStartDelay(600);
            this.i.start();
            this.i.addListener(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.c.c.c
    public boolean a(Bundle bundle) {
        setBackground(com.ubix.ssp.ad.e.a0.c.a(Color.parseColor("#00000000"), -16777216, 0));
        String string = bundle.getString("ICON_URL");
        String string2 = bundle.getString("TITLE");
        String string3 = bundle.getString("SUB_TITLE");
        String string4 = bundle.getString("BUTTON_TEXT");
        boolean z = bundle.getBoolean("IS_DOWNLOAD", false);
        e.b().a(string, (ImageView) findViewById(500101), -1, null);
        ((TextView) findViewById(500102)).setText(string2);
        ((TextView) findViewById(500103)).setText(string3);
        TextView textView = (TextView) findViewById(500104);
        if (TextUtils.isEmpty(string4)) {
            string4 = z ? "立即下载" : "查看详情";
        }
        textView.setText(string4);
        a();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.i;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.i.removeAllListeners();
                this.i = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
        this.e.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
        this.e.put("__IMP_AREA__", getLeft() + "_" + getTop() + "_" + getRight() + "_" + getBottom());
        this.e.put("adLeft", getLeft() + "");
        this.e.put("adRight", getRight() + "");
        this.e.put("adTop", getTop() + "");
        this.e.put("adBottom", getBottom() + "");
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            switch (childAt.getId()) {
                case 500101:
                    int i6 = this.f8586a * 5;
                    int i7 = (i4 - i2) - i6;
                    childAt.layout(i6, i6, i7, i7);
                    break;
                case 500102:
                    int i8 = i4 - i2;
                    int i9 = this.f8586a;
                    childAt.layout(i8 - (i9 * 2), (int) (((double) i9) * 3.5d), (i3 - i8) - (i9 * 4), i8 / 2);
                    break;
                case 500103:
                    int i10 = i4 - i2;
                    int i11 = this.f8586a;
                    childAt.layout(i10 - (i11 * 2), (int) (((double) (i10 / 2)) - (((double) i11) * 0.5d)), (i3 - i10) - (i11 * 4), i10 - (i11 * 3));
                    break;
                case 500104:
                    int i12 = i4 - i2;
                    int i13 = this.f8586a;
                    double d = ((double) i13) * 3.5d;
                    int i14 = i13 * 8;
                    childAt.layout((int) (((double) (i3 - i12)) - d), i14, (int) (((double) i3) - d), i12 - i14);
                    break;
            }
        }
    }
}
