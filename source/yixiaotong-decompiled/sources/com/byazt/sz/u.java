package com.byazt.sz;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 67})
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2732a;
    public Paint c;
    public int n;
    public String sp;
    public c tt;
    public View uj;
    public AnimatorSet ve = new AnimatorSet();

    public u(View view, c cVar) {
        this.uj = view;
        this.tt = cVar;
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
    }

    public void c() {
        ArrayList arrayList = new ArrayList();
        List<c.C0276c> listVe = this.tt.ve();
        if (listVe == null || listVe.size() <= 0) {
            return;
        }
        for (c.C0276c c0276c : listVe) {
            if (c0276c != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0276c.c());
                if (TextUtils.equals(c0276c.getType(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0276c.getType(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0276c.getType());
                }
                objectAnimator.setStartDelay(c0276c.uj());
                objectAnimator.setTarget(this.uj);
                if (TextUtils.equals(c0276c.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setIntValues((int) c0276c.n(), (int) c0276c.a());
                } else {
                    objectAnimator.setFloatValues(c0276c.n(), c0276c.a());
                }
                int iTt = (int) this.tt.tt();
                if (iTt != 0) {
                    objectAnimator.setRepeatCount(iTt);
                } else {
                    objectAnimator.setRepeatCount((int) c0276c.tt());
                }
                if (TextUtils.equals(c0276c.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strA = this.tt.a();
                if (TextUtils.isEmpty(strA)) {
                    strA = c0276c.ve();
                }
                if (TextUtils.equals(strA, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0276c.sp() != null && c0276c.sp().length > 0) {
                    objectAnimator.setFloatValues(c0276c.sp());
                }
                if (TextUtils.equals(c0276c.getType(), "rotationX")) {
                    this.uj.post(new Runnable() { // from class: com.byazt.sz.u.1
                        @Override // java.lang.Runnable
                        public void run() {
                            u.this.uj.setPivotX(u.this.uj.getWidth() / 2.0f);
                            u.this.uj.setPivotY(u.this.uj.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0276c.getType(), "ripple")) {
                    this.sp = c0276c.i();
                }
                String strX = c0276c.x();
                strX.hashCode();
                switch (strX) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.tt.uj() != 0) {
            this.ve.setDuration(this.tt.uj());
        }
        this.ve.setStartDelay(this.tt.n());
        if (TextUtils.equals(this.tt.c(), "sequentially")) {
            this.ve.playSequentially(arrayList);
        } else {
            this.ve.playTogether(arrayList);
        }
        this.ve.start();
    }

    public void tt() {
        AnimatorSet animatorSet = this.ve;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void c(Canvas canvas, n nVar) {
        try {
            if (nVar.getRipple() == 0.0f || TextUtils.isEmpty(this.sp)) {
                return;
            }
            this.c.setColor(com.byazt.cd.c.c(this.sp));
            this.c.setAlpha(90);
            ((ViewGroup) this.uj.getParent()).setClipChildren(true);
            int i = this.n;
            int i2 = this.f2732a;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * nVar.getRipple(), this.c);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void c(int i, int i2) {
        this.n = i / 2;
        this.f2732a = i2 / 2;
    }
}
