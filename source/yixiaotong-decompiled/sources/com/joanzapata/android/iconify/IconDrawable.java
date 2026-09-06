package com.joanzapata.android.iconify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class IconDrawable extends Drawable {
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_DP = 24;
    private final Context context;
    private final Iconify.IconValue icon;
    private TextPaint paint;
    private int size = -1;
    private int alpha = 255;

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.size;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.size;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public IconDrawable(Context context, Iconify.IconValue iconValue) {
        this.context = context;
        this.icon = iconValue;
        TextPaint textPaint = new TextPaint();
        this.paint = textPaint;
        textPaint.setTypeface(Iconify.getTypeface(context));
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setTextAlign(Paint.Align.CENTER);
        this.paint.setUnderlineText(false);
        this.paint.setColor(-16777216);
        this.paint.setAntiAlias(true);
    }

    public IconDrawable actionBarSize() {
        return sizeDp(24);
    }

    public IconDrawable sizeRes(int i) {
        return sizePx(this.context.getResources().getDimensionPixelSize(i));
    }

    public IconDrawable sizeDp(int i) {
        return sizePx(Utils.convertDpToPx(this.context, i));
    }

    public IconDrawable sizePx(int i) {
        this.size = i;
        setBounds(0, 0, i, i);
        invalidateSelf();
        return this;
    }

    public IconDrawable color(int i) {
        this.paint.setColor(i);
        invalidateSelf();
        return this;
    }

    public IconDrawable colorRes(int i) {
        this.paint.setColor(this.context.getResources().getColor(i));
        invalidateSelf();
        return this;
    }

    public IconDrawable alpha(int i) {
        setAlpha(i);
        invalidateSelf();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.paint.setTextSize(getBounds().height());
        Rect rect = new Rect();
        String strValueOf = String.valueOf(this.icon.character);
        this.paint.getTextBounds(strValueOf, 0, 1, rect);
        canvas.drawText(strValueOf, getBounds().width() / 2.0f, (((getBounds().height() - rect.height()) / 2.0f) + rect.height()) - rect.bottom, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        int alpha = this.paint.getAlpha();
        int i = Utils.isEnabled(iArr) ? this.alpha : this.alpha / 2;
        this.paint.setAlpha(i);
        return alpha != i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.paint.setColorFilter(null);
    }

    public void setStyle(Paint.Style style) {
        this.paint.setStyle(style);
    }
}
