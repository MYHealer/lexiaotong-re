package com.byazt.ff;

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
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 1152})
public class TTRoundRectImageView extends ImageView {
    public Paint c;
    public int tt;
    public Matrix uj;
    public int ve;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tt = 25;
        this.ve = 25;
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setFilterBitmap(true);
        this.uj = new Matrix();
    }

    public TTRoundRectImageView(Context context, int i, int i2) {
        this(context);
        this.tt = i;
        this.ve = i2;
    }

    public void setXRound(int i) {
        this.tt = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.ve = i;
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmapC = c(drawable);
            if (bitmapC != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(bitmapC, tileMode, tileMode);
                float fMax = (bitmapC.getWidth() == getWidth() && bitmapC.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapC.getWidth(), (getHeight() * 1.0f) / bitmapC.getHeight());
                this.uj.setScale(fMax, fMax);
                bitmapShader.setLocalMatrix(this.uj);
                this.c.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.tt, this.ve, this.c);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    private Bitmap c(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
