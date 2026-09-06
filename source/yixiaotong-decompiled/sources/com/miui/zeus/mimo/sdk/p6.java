package com.miui.zeus.mimo.sdk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p6 extends BitmapTransformation {
    public static final byte[] d = ijiami_1011.s.s.s.d(new byte[]{80, 11, 9, Ascii.ETB, 15, 94, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, SignedBytes.MAX_POWER_OF_TWO, 74, 9, 80, 15, 88, 79, Ascii.ETB, 2, 9, Ascii.US, 16, 71, 13, 8, 74, 76, 117, 14, Ascii.SYN, 2, 7, 67, 50, 90, 16, 12, 107, 13, 66, 15, 0, 3, 6, 114, 10, 65, 10, 1, 75, 17, 99, 19, 5, 8, 17, 87, 10, 65, 9, 5, 77, 11, 88, 15}, "3dd9b7").getBytes(BitmapTransformation.CHARSET);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5562a;
    public int b;
    public int c;

    public p6(int i, int i2, int i3) {
        this.f5562a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p6.class != obj.getClass()) {
            return false;
        }
        p6 p6Var = (p6) obj;
        return this.f5562a == p6Var.f5562a && this.b == p6Var.b && this.c == p6Var.c;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (((this.f5562a * 31) + this.b) * 31) + this.c;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap bitmapRoundedCorners = TransformationUtils.roundedCorners(bitmapPool, bitmap, this.f5562a);
        if (bitmapRoundedCorners == null) {
            bitmapRoundedCorners = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapRoundedCorners);
        if (this.b > 0) {
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.c);
            paint.setStrokeWidth(this.b);
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            float f = this.f5562a;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        return bitmapRoundedCorners;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(d);
        messageDigest.update(ByteBuffer.allocate(12).putInt(this.f5562a).putInt(this.b).putInt(this.c).array());
    }
}
