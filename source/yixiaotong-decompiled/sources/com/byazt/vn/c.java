package com.byazt.vn;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.widget.ImageView;
import com.byazt.nr.m;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 660, 20})
public class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2820a;
    public final Matrix da;
    public ImageView.ScaleType gt;
    public final Paint i;
    public final boolean[] m;
    public ColorStateList my;
    public final Paint n;
    public boolean nu;
    public float rh;
    public final RectF sl;
    public final int sp;
    public Shader.TileMode t;
    public Shader.TileMode u;
    public final Bitmap uj;
    public final RectF ve;
    public final RectF x;
    public boolean yp;
    public float z;
    public final RectF c = new RectF();
    public final RectF tt = new RectF();

    public c c(boolean z) {
        this.nu = z;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.sp;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2820a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public c(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.ve = rectF;
        this.x = new RectF();
        this.da = new Matrix();
        this.sl = new RectF();
        this.t = Shader.TileMode.CLAMP;
        this.u = Shader.TileMode.CLAMP;
        this.yp = true;
        this.z = 0.0f;
        this.m = new boolean[]{true, true, true, true};
        this.nu = false;
        this.rh = 0.0f;
        this.my = ColorStateList.valueOf(-16777216);
        this.gt = ImageView.ScaleType.FIT_CENTER;
        this.uj = bitmap;
        int width = bitmap.getWidth();
        this.f2820a = width;
        int height = bitmap.getHeight();
        this.sp = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.n = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.my.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.rh);
    }

    public static c c(Bitmap bitmap) {
        if (bitmap != null) {
            return new c(bitmap);
        }
        return null;
    }

    public static Drawable c(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof c) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), c(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapTt = tt(drawable);
        return bitmapTt != null ? new c(bitmapTt) : drawable;
    }

    public static Bitmap tt(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            m.c(th);
            m.tt("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.my.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.my.getColorForState(iArr, 0);
        if (this.i.getColor() != colorForState) {
            this.i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* JADX INFO: renamed from: com.byazt.vn.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 660, 26})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            c = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void c() {
        float fWidth;
        float fHeight;
        int i = AnonymousClass1.c[this.gt.ordinal()];
        if (i == 1) {
            this.x.set(this.c);
            RectF rectF = this.x;
            float f = this.rh;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.da.reset();
            this.da.setTranslate((int) (((this.x.width() - this.f2820a) * 0.5f) + 0.5f), (int) (((this.x.height() - this.sp) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.x.set(this.c);
            RectF rectF2 = this.x;
            float f2 = this.rh;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.da.reset();
            float fWidth2 = 0.0f;
            if (this.f2820a * this.x.height() > this.x.width() * this.sp) {
                fWidth = this.x.height() / this.sp;
                fHeight = 0.0f;
                fWidth2 = (this.x.width() - (this.f2820a * fWidth)) * 0.5f;
            } else {
                fWidth = this.x.width() / this.f2820a;
                fHeight = (this.x.height() - (this.sp * fWidth)) * 0.5f;
            }
            this.da.setScale(fWidth, fWidth);
            Matrix matrix = this.da;
            float f3 = this.rh;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.da.reset();
            float fMin = (((float) this.f2820a) > this.c.width() || ((float) this.sp) > this.c.height()) ? Math.min(this.c.width() / this.f2820a, this.c.height() / this.sp) : 1.0f;
            float fWidth3 = (int) (((this.c.width() - (this.f2820a * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.c.height() - (this.sp * fMin)) * 0.5f) + 0.5f);
            this.da.setScale(fMin, fMin);
            this.da.postTranslate(fWidth3, fHeight2);
            this.x.set(this.ve);
            this.da.mapRect(this.x);
            RectF rectF3 = this.x;
            float f4 = this.rh;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.da.setRectToRect(this.ve, this.x, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.x.set(this.ve);
            this.da.setRectToRect(this.ve, this.c, Matrix.ScaleToFit.END);
            this.da.mapRect(this.x);
            RectF rectF4 = this.x;
            float f5 = this.rh;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.da.setRectToRect(this.ve, this.x, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.x.set(this.ve);
            this.da.setRectToRect(this.ve, this.c, Matrix.ScaleToFit.START);
            this.da.mapRect(this.x);
            RectF rectF5 = this.x;
            float f6 = this.rh;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.da.setRectToRect(this.ve, this.x, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.x.set(this.ve);
            this.da.setRectToRect(this.ve, this.c, Matrix.ScaleToFit.CENTER);
            this.da.mapRect(this.x);
            RectF rectF6 = this.x;
            float f7 = this.rh;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.da.setRectToRect(this.ve, this.x, Matrix.ScaleToFit.FILL);
        } else {
            this.x.set(this.c);
            RectF rectF7 = this.x;
            float f8 = this.rh;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.da.reset();
            this.da.setRectToRect(this.ve, this.x, Matrix.ScaleToFit.FILL);
        }
        this.tt.set(this.x);
        this.yp = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.c.set(rect);
        c();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.yp) {
            BitmapShader bitmapShader = new BitmapShader(this.uj, this.t, this.u);
            if (this.t == Shader.TileMode.CLAMP && this.u == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.da);
            }
            this.n.setShader(bitmapShader);
            this.yp = false;
        }
        if (this.nu) {
            if (this.rh > 0.0f) {
                canvas.drawOval(this.tt, this.n);
                canvas.drawOval(this.x, this.i);
                return;
            } else {
                canvas.drawOval(this.tt, this.n);
                return;
            }
        }
        if (!c(this.m)) {
            canvas.drawRect(this.tt, this.n);
            if (this.rh > 0.0f) {
                canvas.drawRect(this.x, this.i);
                return;
            }
            return;
        }
        float f = this.z;
        if (this.rh > 0.0f) {
            canvas.drawRoundRect(this.tt, f, f, this.n);
            canvas.drawRoundRect(this.x, f, f, this.i);
            c(canvas);
            tt(canvas);
            return;
        }
        canvas.drawRoundRect(this.tt, f, f, this.n);
        c(canvas);
    }

    private void c(Canvas canvas) {
        if (tt(this.m) || this.z == 0.0f) {
            return;
        }
        float f = this.tt.left;
        float f2 = this.tt.top;
        float fWidth = this.tt.width() + f;
        float fHeight = this.tt.height() + f2;
        float f3 = this.z;
        if (!this.m[0]) {
            this.sl.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.sl, this.n);
        }
        if (!this.m[1]) {
            this.sl.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.sl, this.n);
        }
        if (!this.m[2]) {
            this.sl.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.sl, this.n);
        }
        if (this.m[3]) {
            return;
        }
        this.sl.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.sl, this.n);
    }

    private void tt(Canvas canvas) {
        if (tt(this.m) || this.z == 0.0f) {
            return;
        }
        float f = this.tt.left;
        float f2 = this.tt.top;
        float fWidth = f + this.tt.width();
        float fHeight = f2 + this.tt.height();
        float f3 = this.z;
        float f4 = this.rh / 2.0f;
        if (!this.m[0]) {
            canvas.drawLine(f - f4, f2, f + f3, f2, this.i);
            canvas.drawLine(f, f2 - f4, f, f2 + f3, this.i);
        }
        if (!this.m[1]) {
            canvas.drawLine((fWidth - f3) - f4, f2, fWidth, f2, this.i);
            canvas.drawLine(fWidth, f2 - f4, fWidth, f2 + f3, this.i);
        }
        if (!this.m[2]) {
            canvas.drawLine((fWidth - f3) - f4, fHeight, fWidth + f4, fHeight, this.i);
            canvas.drawLine(fWidth, fHeight - f3, fWidth, fHeight, this.i);
        }
        if (this.m[3]) {
            return;
        }
        canvas.drawLine(f - f4, fHeight, f + f3, fHeight, this.i);
        canvas.drawLine(f, fHeight - f3, f, fHeight, this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.n.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.n.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.n.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.n.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.n.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.n.setFilterBitmap(z);
        invalidateSelf();
    }

    public c c(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (hashSet.isEmpty()) {
            this.z = 0.0f;
        } else {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(fFloatValue)));
            }
            this.z = fFloatValue;
        }
        boolean[] zArr = this.m;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public c c(float f) {
        this.rh = f;
        this.i.setStrokeWidth(f);
        return this;
    }

    public c c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.my = colorStateList;
        this.i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public c c(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.gt != scaleType) {
            this.gt = scaleType;
            c();
        }
        return this;
    }

    public c c(Shader.TileMode tileMode) {
        if (this.t != tileMode) {
            this.t = tileMode;
            this.yp = true;
            invalidateSelf();
        }
        return this;
    }

    public c tt(Shader.TileMode tileMode) {
        if (this.u != tileMode) {
            this.u = tileMode;
            this.yp = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean c(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean tt(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
