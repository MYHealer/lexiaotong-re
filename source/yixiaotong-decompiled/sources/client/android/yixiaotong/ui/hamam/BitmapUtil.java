package client.android.yixiaotong.ui.hamam;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BitmapUtil {
    public static Bitmap generatorStatusIcon(Bitmap bitmap, Resources resources, int i, int i2) {
        resources.getDimension(R.dimen.app_icon_size);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), paint);
        Paint paint2 = new Paint(257);
        paint2.setColor(i);
        float f = i2;
        canvas.drawCircle(bitmap.getWidth() - i2, f, f, paint2);
        return bitmapCreateBitmap;
    }
}
