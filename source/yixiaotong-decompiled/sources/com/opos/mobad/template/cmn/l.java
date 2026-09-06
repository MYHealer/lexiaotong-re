package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7520a;
    private float b;
    private Bitmap c;

    public l(Context context) {
        super(context);
        this.f7520a = 0.0f;
        this.b = 0.0f;
    }

    public void a(int i) {
        this.f7520a = i;
        invalidate();
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapCreateBitmap;
        Canvas canvas2;
        float f = this.f7520a;
        if (f <= 0.0f) {
            super.onDraw(canvas);
            return;
        }
        if (f * 2.0f >= getWidth() || this.f7520a * 2.0f >= getHeight()) {
            return;
        }
        Bitmap bitmap = this.c;
        if (bitmap != null && bitmap.getWidth() == getWidth() && this.c.getHeight() == getHeight()) {
            bitmapCreateBitmap = this.c;
            canvas2 = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            paint.setColor(0);
            canvas2.drawPaint(paint);
        } else {
            Bitmap bitmap2 = this.c;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.c = null;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.c = bitmapCreateBitmap;
            canvas2 = new Canvas(bitmapCreateBitmap);
        }
        super.onDraw(canvas2);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setShader(new BitmapShader(bitmapCreateBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        float f2 = this.f7520a;
        float width = getWidth() - this.f7520a;
        float height = getHeight() - this.f7520a;
        float f3 = this.b;
        canvas.drawRoundRect(f2, f2, width, height, f3, f3, paint2);
    }
}
