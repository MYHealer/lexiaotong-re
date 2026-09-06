package com.byazt.fe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.byazt.cd.x;
import com.byazt.sa.uj;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1154, 1863})
public class UGRatingBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f2223a;
    public float c;
    public LinearLayout n;
    public Context sp;
    public float tt;
    public float uj;
    public double ve;
    public uj x;

    public void c(uj ujVar) {
        this.x = ujVar;
    }

    public UGRatingBar(Context context) {
        super(context);
        this.sp = context;
        this.n = new LinearLayout(context);
        this.f2223a = new LinearLayout(context);
        this.n.setOrientation(0);
        this.n.setGravity(GravityCompat.START);
        this.f2223a.setOrientation(0);
        this.f2223a.setGravity(GravityCompat.START);
    }

    public void c(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.n.removeAllViews();
        this.f2223a.removeAllViews();
        this.c = (int) x.c(this.sp, f);
        this.tt = (int) x.c(this.sp, f);
        this.ve = d;
        this.uj = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            c(starImageView, "tt_ugen_rating_star");
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.f2223a.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            c(starImageView2, "tt_ugen_rating_star");
            starImageView2.setColorFilter(i2);
            this.n.addView(starImageView2);
        }
        addView(this.n);
        addView(this.f2223a);
        requestLayout();
    }

    public void c(ImageView imageView, String str) {
        imageView.setImageResource(com.byazt.cd.uj.tt(this.sp, str));
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.c, (int) this.tt);
        layoutParams.leftMargin = (int) this.uj;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.uj;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.c(i, i2);
        }
        super.onMeasure(i, i2);
        this.n.measure(i, i2);
        double dFloor = Math.floor(this.ve);
        float f = this.uj;
        float f2 = this.c;
        this.f2223a.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f + f + f2)) * dFloor) + ((double) f) + ((this.ve - dFloor) * ((double) f2))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.n.getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.c(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i4);
        }
    }
}
