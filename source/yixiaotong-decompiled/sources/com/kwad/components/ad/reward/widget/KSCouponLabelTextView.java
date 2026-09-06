package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class KSCouponLabelTextView extends TextView implements d {
    private final Rect EX;
    private final RectF EY;
    private final RectF Fb;
    private float Fd;
    private float Fe;
    private float Ff;
    private final RectF Fg;
    private final RectF Fh;
    private final Path Fi;
    private Path Fj;
    private Path Fk;
    private boolean Fl;
    private final Paint mPaint;
    private int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.EX = new Rect();
        this.EY = new RectF();
        this.Fg = new RectF();
        this.Fh = new RectF();
        this.Fi = new Path();
        this.Fb = new RectF();
        this.Fl = true;
        a(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.EX = new Rect();
        this.EY = new RectF();
        this.Fg = new RectF();
        this.Fh = new RectF();
        this.Fi = new Path();
        this.Fb = new RectF();
        this.Fl = true;
        a(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.EX = new Rect();
        this.EY = new RectF();
        this.Fg = new RectF();
        this.Fh = new RectF();
        this.Fi = new Path();
        this.Fb = new RectF();
        this.Fl = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Fd = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.Fe = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.Ff = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        typedArrayObtainStyledAttributes.recycle();
        lI();
    }

    private void lI() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.Fe);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Fl) {
            if (getPaddingLeft() + getPaddingRight() + getPaint().measureText(getText().toString()) <= getMeasuredWidth()) {
                return;
            }
            setVisibility(8);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.EX.setEmpty();
        getDrawingRect(this.EX);
        float f = this.Fe / 2.0f;
        this.EY.set(this.EX);
        this.EY.left += f;
        this.EY.top += f;
        this.EY.right -= f;
        this.EY.bottom -= f;
        a(this.EY, this.Fg);
        b(this.EY, this.Fh);
        Path path = this.Fj;
        if (path == null) {
            this.Fj = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.Fk;
        if (path2 == null) {
            this.Fk = new Path();
        } else {
            path2.reset();
        }
        a(this.Fi, this.Fj, this.Fk, this.EY, this.Fg, this.Fh);
        canvas.drawPath(this.Fi, this.mPaint);
    }

    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f = this.Fd;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.Fj, Path.Op.DIFFERENCE);
        path.op(this.Fk, Path.Op.DIFFERENCE);
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.Fd);
        this.Fb.set(rectF);
        RectF rectF4 = this.Fb;
        rectF4.bottom = rectF4.top + (this.Fd * 2.0f);
        RectF rectF5 = this.Fb;
        rectF5.right = rectF5.left + (this.Fd * 2.0f);
        path.arcTo(this.Fb, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.Fd, rectF.top);
        this.Fb.set(rectF);
        RectF rectF6 = this.Fb;
        rectF6.left = rectF6.right - (this.Fd * 2.0f);
        RectF rectF7 = this.Fb;
        rectF7.bottom = rectF7.top + (this.Fd * 2.0f);
        path.arcTo(this.Fb, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.Fd);
        this.Fb.set(rectF);
        RectF rectF8 = this.Fb;
        rectF8.left = rectF8.right - (this.Fd * 2.0f);
        RectF rectF9 = this.Fb;
        rectF9.top = rectF9.bottom - (this.Fd * 2.0f);
        path.arcTo(this.Fb, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Fd, rectF.bottom);
        this.Fb.set(rectF);
        RectF rectF10 = this.Fb;
        rectF10.right = rectF10.left + (this.Fd * 2.0f);
        RectF rectF11 = this.Fb;
        rectF11.top = rectF11.bottom - (this.Fd * 2.0f);
        path.arcTo(this.Fb, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        rectF2.left -= this.Ff;
        rectF2.right = rectF2.left + (this.Ff * 2.0f);
        rectF2.top += (rectF.height() - (this.Ff * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (this.Ff * 2.0f);
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        rectF2.right += this.Ff;
        rectF2.left = rectF2.right - (this.Ff * 2.0f);
        rectF2.top += (rectF.height() - (this.Ff * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (this.Ff * 2.0f);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        lI();
        invalidate();
    }
}
