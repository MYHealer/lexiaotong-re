package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_kx {
    public static final com.jd.ad.sdk.jad_ny.jad_er jad_an = new jad_an();

    public class jad_an extends com.jd.ad.sdk.jad_ny.jad_fs {
        @Override // com.jd.ad.sdk.jad_ny.jad_fs, com.jd.ad.sdk.jad_ny.jad_er
        public void jad_an(Bitmap bitmap) {
        }
    }

    public static com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            if (i != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i2 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i2 = current.getIntrinsicHeight();
                    }
                    Lock lock = jad_vi.jad_bo;
                    lock.lock();
                    Bitmap bitmapJad_an = jad_erVar.jad_an(i, i2, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmapJad_an);
                        current.setBounds(0, 0, i, i2);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = bitmapJad_an;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Logger.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
                z = true;
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                Logger.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            bitmap = null;
            z = true;
        }
        if (!z) {
            jad_erVar = jad_an;
        }
        return jad_er.jad_an(bitmap, jad_erVar);
    }
}
