package com.opos.cmn.module.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class f extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Paint f6193a;
    protected Matrix b;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Matrix();
        Paint paint = new Paint();
        this.f6193a = paint;
        paint.setAntiAlias(true);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        try {
            Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
            if (bitmap != null) {
                return bitmap;
            }
            int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("RoundImageView", "drawableToBitmap", (Throwable) e);
            return null;
        }
    }

    protected abstract void a(Canvas canvas, int i, int i2);

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapA;
        try {
            if (getDrawable() == null || (bitmapA = a(getDrawable())) == null) {
                return;
            }
            BitmapShader bitmapShader = new BitmapShader(bitmapA, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            float fMax = (bitmapA.getWidth() == getWidth() && bitmapA.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
            this.b.setScale(fMax, fMax);
            bitmapShader.setLocalMatrix(this.b);
            this.f6193a.setShader(bitmapShader);
            a(canvas, getWidth(), getHeight());
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("RoundImageView", "onDraw", th);
        }
    }
}
