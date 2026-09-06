package com.ubixnow.ooooo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO000 extends BitmapDrawable {
    private final Paint OooO00o;
    private final Path OooO0O0;

    public oO000(Context context, Bitmap bitmap, float f) {
        this(context, bitmap, bitmap.getWidth(), bitmap.getHeight(), f);
    }

    public oO000(Context context, Bitmap bitmap, float f, float f2, float f3) {
        super(context.getResources(), bitmap);
        Paint paint = new Paint();
        this.OooO00o = paint;
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setScale(f / bitmap.getWidth(), f2 / bitmap.getHeight());
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Path path = new Path();
        this.OooO0O0 = path;
        path.addRoundRect(new RectF(0.0f, 0.0f, f, f2), f3, f3, Path.Direction.CW);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawPath(this.OooO0O0, this.OooO00o);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getBitmap().getHeight();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getBitmap().getWidth();
    }
}
