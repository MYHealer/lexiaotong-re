package com.miui.zeus.mimo.sdk.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.view.component.IconICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoGiftBoxView extends RelativeLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f5666a;
    public View b;
    public int c;
    public int d;
    public LinearLayout e;
    public IconICP f;

    public MimoGiftBoxView(Context context) {
        this(context, null);
    }

    public MimoGiftBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MimoGiftBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_OTHER;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f5666a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f5666a.removeAllUpdateListeners();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        IconICP iconICP;
        super.onMeasure(i, i2);
        LinearLayout linearLayout = this.e;
        if (linearLayout == null || linearLayout.getLayoutParams() == null || (iconICP = this.f) == null || iconICP.getLayoutParams() == null || getWidth() <= 0 || getHeight() <= 0 || getWidth() <= getHeight() || this.c == getWidth() || this.d == getHeight()) {
            return;
        }
        this.c = getWidth();
        this.d = getHeight();
        int width = (getWidth() * 663) / 1020;
        getLayoutParams().width = getWidth();
        getLayoutParams().height = width;
        ((RelativeLayout.LayoutParams) this.e.getLayoutParams()).leftMargin = (int) ((getWidth() * 72) / 1020.0f);
        int width2 = (int) ((getWidth() * 120) / 1020.0f);
        this.f.getLayoutParams().width = width2;
        this.f.getLayoutParams().height = width2;
    }
}
