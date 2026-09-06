package com.adprof.sdk.base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RoundImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BitmapShader f118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Matrix f119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f120a;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1082a = 20;
        this.f119a = new Matrix();
        Paint paint = new Paint();
        this.f120a = paint;
        paint.setAntiAlias(true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        if (getDrawable() == null) {
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas2);
            bitmap = bitmapCreateBitmap;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f118a = new BitmapShader(bitmap, tileMode, tileMode);
        float fMax = (bitmap.getWidth() == getWidth() && bitmap.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmap.getWidth(), (getHeight() * 1.0f) / bitmap.getHeight());
        this.f119a.setScale(fMax, fMax);
        this.f118a.setLocalMatrix(this.f119a);
        this.f120a.setShader(this.f118a);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f = this.f1082a;
        canvas.drawRoundRect(rectF, f, f, this.f120a);
    }
}
