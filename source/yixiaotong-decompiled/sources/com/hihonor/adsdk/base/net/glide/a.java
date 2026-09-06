package com.hihonor.adsdk.base.net.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements Transformation<Bitmap> {
    private BitmapPool hnadsa;
    private float hnadsb;
    private boolean hnadsc;
    private boolean hnadsd;
    private boolean hnadse;
    private boolean hnadsf;

    public a(Context context, float f) {
        this.hnadsa = Glide.get(context).getBitmapPool();
        this.hnadsb = f;
    }

    public void hnadsa(boolean z, boolean z2, boolean z3, boolean z4) {
        this.hnadsc = z;
        this.hnadsd = z2;
        this.hnadse = z4;
        this.hnadsf = z3;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int i, int i2) {
        int height;
        int width;
        Bitmap bitmap = resource.get();
        if (i > i2 && i != 0 && i2 != 0) {
            float f = i2;
            float f2 = i;
            height = bitmap.getWidth();
            width = (int) (bitmap.getWidth() * (f / f2));
            if (width > bitmap.getHeight()) {
                width = bitmap.getHeight();
                height = (int) (bitmap.getHeight() * (f2 / f));
            }
        } else if (i >= i2 || i == 0 || i2 == 0) {
            height = bitmap.getHeight();
            width = height;
        } else {
            float f3 = i;
            float f4 = i2;
            int height2 = bitmap.getHeight();
            int height3 = (int) (bitmap.getHeight() * (f3 / f4));
            if (height3 > bitmap.getWidth()) {
                height = bitmap.getWidth();
                width = (int) (bitmap.getWidth() * (f4 / f3));
            } else {
                height = height3;
                width = height2;
            }
        }
        if (i2 != 0 && width != 0) {
            this.hnadsb *= width / i2;
        }
        Bitmap bitmapCreateBitmap = this.hnadsa.get(height, width, Bitmap.Config.ARGB_8888);
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(height, width, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        int width2 = (bitmap.getWidth() - height) / 2;
        int height4 = (bitmap.getHeight() - width) / 2;
        if (width2 != 0 || height4 != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width2, -height4);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        float f5 = this.hnadsb;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        if (!this.hnadsc) {
            float f6 = this.hnadsb;
            canvas.drawRect(0.0f, 0.0f, f6, f6, paint);
        }
        if (!this.hnadsd) {
            canvas.drawRect(canvas.getWidth() - this.hnadsb, 0.0f, canvas.getWidth(), this.hnadsb, paint);
        }
        if (!this.hnadse) {
            float height5 = canvas.getHeight();
            float f7 = this.hnadsb;
            canvas.drawRect(0.0f, height5 - f7, f7, canvas.getHeight(), paint);
        }
        if (!this.hnadsf) {
            canvas.drawRect(canvas.getWidth() - this.hnadsb, canvas.getHeight() - this.hnadsb, canvas.getWidth(), canvas.getHeight(), paint);
        }
        return BitmapResource.obtain(bitmapCreateBitmap, this.hnadsa);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
