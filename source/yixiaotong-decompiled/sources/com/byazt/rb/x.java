package com.byazt.rb;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 23, 71})
public class x implements sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2678a;
    public View c;
    public float n;
    public float tt;
    public float uj;
    public float ve;

    public float c() {
        return this.tt;
    }

    @Override // com.byazt.rb.sp
    public float getRipple() {
        return this.ve;
    }

    @Override // com.byazt.rb.sp
    public float getRubIn() {
        return this.f2678a;
    }

    @Override // com.byazt.rb.sp
    public float getShine() {
        return this.uj;
    }

    @Override // com.byazt.rb.sp
    public float getStretch() {
        return this.n;
    }

    public x(View view) {
        this.c = view;
    }

    public void c(float f) {
        View view = this.c;
        if (view == null) {
            return;
        }
        this.tt = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public void tt(float f) {
        View view = this.c;
        if (view == null) {
            return;
        }
        this.ve = f;
        view.postInvalidate();
    }

    public void ve(float f) {
        View view = this.c;
        if (view == null) {
            return;
        }
        this.uj = f;
        view.postInvalidate();
    }

    public void uj(float f) {
        this.n = f;
        this.c.postInvalidate();
    }

    public void n(float f) {
        this.f2678a = f;
        this.c.postInvalidate();
    }

    public void c(int i) {
        View view = this.c;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
