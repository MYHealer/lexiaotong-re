package com.hihonor.adsdk.common.e.f.a;

import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends a {
    private static final int hnadsm = 1;
    private static final float hnadsn = 0.5f;
    private static final float hnadso = 1.2f;
    private static final int hnadsp = 120;
    private static final int hnadsq = 40;
    private static final int hnadsr = 50;
    private static final float hnadss = 3.5f;
    private Paint hnadsg;
    private MaskFilter hnadsh;
    private MaskFilter hnadsi;
    private Path hnadsj;
    private Paint hnadsk;
    private Paint hnadsl;

    public g(d dVar) {
        super(dVar);
        this.hnadsg = new Paint();
        this.hnadsh = new BlurMaskFilter(120.0f, BlurMaskFilter.Blur.NORMAL);
        this.hnadsi = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.NORMAL);
        this.hnadsj = new Path();
        this.hnadsk = new Paint();
        this.hnadsl = new Paint();
        hnadsa(dVar.hnadse());
    }

    private void hnadsa(Resources resources) {
        if (resources == null || resources.getDisplayMetrics() == null) {
            return;
        }
        float f = resources.getDisplayMetrics().density;
        if (Float.compare(f, 3.5f) < 0) {
            this.hnadsi = new BlurMaskFilter((f / 4.5f) * 50.0f, BlurMaskFilter.Blur.NORMAL);
        }
    }

    private void hnadsb(Canvas canvas) {
        this.hnadsl.setShader(new LinearGradient(0.0f, 0.0f, hnadsf().width(), hnadsf().height(), hnadsb(), hnadsc(), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(hnadsf(), hnadse(), hnadse(), this.hnadsl);
        this.hnadsl.setShader(null);
    }

    private void hnadsc(Canvas canvas) {
        this.hnadsj.rewind();
        this.hnadsj.addRoundRect(hnadsf(), hnadse(), hnadse(), Path.Direction.CCW);
        canvas.clipPath(this.hnadsj);
        this.hnadsg.setMaskFilter(this.hnadsh);
        RectF rectFHnadsb = hnadsb(hnadsf());
        this.hnadsg.setColor(hnadsd()[0]);
        canvas.drawOval(rectFHnadsb, this.hnadsg);
        if (hnadsd().length > 0) {
            RectF rectFHnadsa = hnadsa(hnadsf());
            this.hnadsg.setColor(hnadsd()[1]);
            canvas.drawOval(rectFHnadsa, this.hnadsg);
        }
        this.hnadsg.setMaskFilter(null);
    }

    private void hnadsd(Canvas canvas) {
        RectF rectF = new RectF(24.0f, hnadsf().height() - 40.0f, hnadsf().width() - 24.0f, hnadsf().height() - 1.0f);
        this.hnadsk.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, hnadsb(), hnadsc(), Shader.TileMode.CLAMP));
        this.hnadsk.setMaskFilter(this.hnadsi);
        canvas.drawRoundRect(rectF, 20.0f, 20.0f, this.hnadsk);
        this.hnadsk.setShader(null);
        this.hnadsk.setMaskFilter(null);
    }

    private RectF hnadsb(RectF rectF) {
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left + (rectF.width() * 0.15f);
        rectF2.top = rectF.top + (rectF.height() * 0.32f);
        rectF2.right = rectF2.left + (rectF.width() * 0.55f);
        rectF2.bottom = rectF2.top + (rectF.height() * 1.13f);
        return rectF2;
    }

    @Override // com.hihonor.adsdk.common.e.f.a.i
    public void hnadsa(Canvas canvas) {
        Rect clipBounds = canvas.getClipBounds();
        int i = clipBounds.left;
        if (i != 0 || clipBounds.top != 0) {
            canvas.translate(i, clipBounds.top);
        }
        canvas.save();
        if (e.hnadsc(hnadsa())) {
            hnadsd(canvas);
        }
        if (e.hnadsa(hnadsa())) {
            hnadsb(canvas);
        }
        if (e.hnadsb(hnadsa())) {
            hnadsc(canvas);
        }
        canvas.restore();
        int i2 = clipBounds.left;
        if (i2 == 0 && clipBounds.top == 0) {
            return;
        }
        canvas.translate(-i2, -clipBounds.top);
    }

    private RectF hnadsa(RectF rectF) {
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left + (rectF.width() * 0.45f);
        rectF2.top = rectF.top - (rectF.height() * 0.92f);
        rectF2.right = rectF2.left + (rectF.width() * 0.55f);
        rectF2.bottom = rectF2.top + (rectF.height() * 1.3f);
        return rectF2;
    }
}
