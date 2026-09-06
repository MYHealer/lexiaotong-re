package com.miui.zeus.mimo.sdk;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class s7 extends RelativeLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f5596a;
    public final List<ImageICP> b;
    public int c;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            s7.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public s7(Context context, int i) {
        super(context);
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = i;
        setBackgroundColor(0);
        a(arrayList);
        a();
    }

    public final void a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f5596a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.f5596a.setRepeatMode(2);
        this.f5596a.setRepeatCount(-1);
        this.f5596a.addUpdateListener(new a());
        this.f5596a.start();
    }

    public abstract void a(float f);

    public abstract void a(List<ImageICP> list);

    public void a(List<String> list, i8 i8Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i < this.b.size()) {
                ImageICP imageICP = this.b.get(i);
                String str = list.get(i);
                if (b.g(str)) {
                    imageICP.setVisibility(8);
                } else {
                    imageICP.setVisibility(0);
                    imageICP.setClickAreaType(getClickAreaType());
                    imageICP.a(str, i8Var);
                }
            }
        }
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_MOD;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f5596a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f5596a.removeAllUpdateListeners();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            ValueAnimator valueAnimator = this.f5596a;
            if (valueAnimator == null || !valueAnimator.isPaused()) {
                return;
            }
            this.f5596a.resume();
            return;
        }
        ValueAnimator valueAnimator2 = this.f5596a;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f5596a.pause();
    }
}
