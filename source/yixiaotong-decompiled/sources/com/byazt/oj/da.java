package com.byazt.oj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.tm.DynamicBaseWidget;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 72})
public class da extends uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2554a;
    public float n;
    public c uj;

    public da(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        int i;
        String str;
        if ((this.ve instanceof ImageView) && (this.ve.getParent() instanceof DynamicBaseWidget)) {
            this.ve = (View) this.ve.getParent();
        }
        this.ve.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "alpha", 0.0f, 1.0f).setDuration((int) (this.tt.da() * 1000.0d));
        this.uj = new c(this.ve);
        final int i2 = this.ve.getLayoutParams().height;
        this.n = i2;
        this.f2554a = this.ve.getLayoutParams().width;
        if (TtmlNode.LEFT.equals(this.tt.c()) || TtmlNode.RIGHT.equals(this.tt.c())) {
            i = (int) this.f2554a;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.uj, str, 0, i).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.byazt.oj.da.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                da.this.uj.c(i2);
            }
        });
        return arrayList;
    }

    @com.byazt.zqa.c(c = {0, 1, 787, 45})
    private class c {
        public View tt;

        public c(View view) {
            this.tt = view;
        }

        public void c(int i) {
            if (Constant.MAP_KEY_TOP.equals(da.this.tt.c())) {
                if (da.this.ve instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) da.this.ve).getChildCount(); i2++) {
                        ((ViewGroup) da.this.ve).getChildAt(i2).setTranslationY(i - da.this.n);
                    }
                }
                da.this.ve.setTranslationY(da.this.n - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.tt.getLayoutParams();
            layoutParams.height = i;
            this.tt.setLayoutParams(layoutParams);
            this.tt.requestLayout();
        }
    }
}
