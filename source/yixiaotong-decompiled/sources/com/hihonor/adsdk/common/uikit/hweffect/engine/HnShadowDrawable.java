package com.hihonor.adsdk.common.uikit.hweffect.engine;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.R;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnShadowDrawable extends Drawable implements com.hihonor.adsdk.common.uikit.hweffect.engine.b {
    private static final boolean DEBUG = false;
    protected static final int DEFAULT_DRAW_FLAG = 15;
    protected static final int DRAW_BOTTOM = 8;
    protected static final int DRAW_LEFT = 1;
    protected static final int DRAW_RIGHT = 4;
    protected static final int DRAW_TOP = 2;
    protected static final int ELEVATION_INDEX = 1;
    private static final int HALF = 2;
    protected static final int INVALID = -1;
    public static final int LEVEL_EXTRA_THICK = 3;
    public static final int LEVEL_REGULAR = 1;
    public static final int LEVEL_THICK = 2;
    public static final int LEVEL_THIN = 0;
    protected static final float MIN_ELEVATION = 1.0f;
    protected static final float NO_RADIUS = 0.0f;
    protected static final int OFFSET_Y_INDEX = 0;
    protected static final int SHADOW_COLOR_INDEX = 2;
    private static final String TAG = "HnShadowDrawable";
    public static final int TYPE_BLUR = 0;
    public static final int TYPE_OTHER = 2;
    public static final int TYPE_SOLID = 1;
    private Bitmap mBottomBitmap;
    private Paint mClearPaint;
    private RectF mContentRect;
    private Context mContext;
    private float mCornerRadius;
    private int mDrawFlags;
    private boolean mIsUseRoundCorner;
    private Bitmap mLeftBitmap;
    private Bitmap mLeftBottomBitmap;
    private Bitmap mLeftTopBitmap;
    private float mOffsetX;
    private float mOffsetY;
    private Rect mPadding;
    private Resources mResources;
    private Bitmap mRightBitmap;
    private Bitmap mRightBottomBitmap;
    private Bitmap mRightTopBitmap;
    private int mShadowColor;
    private float mShadowElevation;
    private Paint mShadowPaint;
    private boolean mShowShadow;
    private Bitmap mTopBitmap;
    protected static final int[][] BLUR_CONFIG = {new int[]{1, 8, R.color.honor_ads_default_shadow_color}, new int[]{2, 12, R.color.honor_ads_default_shadow_color}, new int[]{3, 16, R.color.honor_ads_default_shadow_color}, new int[]{8, 24, R.color.honor_ads_default_shadow_color}};
    protected static final int[][] SOLID_CONFIG = {new int[]{2, 8, R.color.honor_ads_default_shadow_color}, new int[]{2, 12, R.color.honor_ads_light_shadow_color}, new int[]{3, 16, R.color.honor_ads_light_shadow_color}, new int[]{8, 24, R.color.honor_ads_light_shadow_color}};
    private static final PorterDuffXfermode CLEAR_MODE = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private int mShadowBaseType = 0;
    private int mShadowLevel = -1;
    private Rect mSrcRect = new Rect();
    private RectF mDstRect = new RectF();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] hnadsa;

        static {
            c.b.values();
            int[] iArr = new int[8];
            hnadsa = iArr;
            try {
                c.b bVar = c.b.LEFT;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = hnadsa;
                c.b bVar2 = c.b.TOP;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = hnadsa;
                c.b bVar3 = c.b.RIGHT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = hnadsa;
                c.b bVar4 = c.b.BOTTOM;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = hnadsa;
                c.b bVar5 = c.b.LEFT_TOP;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = hnadsa;
                c.b bVar6 = c.b.LEFT_BOTTOM;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = hnadsa;
                c.b bVar7 = c.b.RIGHT_TOP;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = hnadsa;
                c.b bVar8 = c.b.RIGHT_BOTTOM;
                iArr8[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static class b {
        private int hnadsa;
        private int hnadsb;
        private int hnadsc;
        private float hnadsd;
        private float hnadse;
        private float hnadsf;
        private float hnadsg;
        private boolean hnadsh;
        private boolean hnadsi;
        private int hnadsj;
        private Context hnadsk;

        public b(Context context) {
            this.hnadsk = context;
        }

        b hnadsa(float f) {
            this.hnadse = f;
            return this;
        }

        b hnadsa(int i) {
            this.hnadsj = i;
            return this;
        }

        b hnadsa(boolean z) {
            this.hnadsh = z;
            return this;
        }

        b hnadsb(float f) {
            this.hnadsf = f;
            return this;
        }

        b hnadsb(int i) {
            this.hnadsa = i;
            return this;
        }

        b hnadsb(boolean z) {
            this.hnadsi = z;
            return this;
        }

        b hnadsc(float f) {
            this.hnadsg = f;
            return this;
        }

        b hnadsc(int i) {
            this.hnadsc = i;
            return this;
        }

        b hnadsd(int i) {
            this.hnadsb = i;
            return this;
        }

        b hnadsd(float f) {
            this.hnadsd = Math.max(f, 1.0f);
            return this;
        }

        HnShadowDrawable hnadsa() {
            HnShadowDrawable hnShadowDrawable = new HnShadowDrawable(this.hnadsk);
            hnShadowDrawable.mShadowBaseType = this.hnadsa;
            hnShadowDrawable.mShadowLevel = this.hnadsb;
            hnShadowDrawable.mShadowColor = this.hnadsc;
            hnShadowDrawable.mShadowElevation = this.hnadsd;
            hnShadowDrawable.mOffsetX = this.hnadsf;
            hnShadowDrawable.mOffsetY = this.hnadsg;
            hnShadowDrawable.mCornerRadius = this.hnadse;
            hnShadowDrawable.mIsUseRoundCorner = this.hnadsh;
            hnShadowDrawable.mShowShadow = this.hnadsi;
            hnShadowDrawable.mDrawFlags = this.hnadsj;
            return hnShadowDrawable;
        }
    }

    public HnShadowDrawable() {
        init();
    }

    private void drawBorders(Canvas canvas, float f, float f2, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        RectF rectF = this.mContentRect;
        float f3 = i;
        float f4 = rectF.left + f3;
        float f5 = rectF.right - f3;
        float f6 = rectF.top + f3;
        float f7 = rectF.bottom - f3;
        if (f2 > f3) {
            if (isDrawLeft() && (bitmap4 = this.mLeftBitmap) != null) {
                this.mSrcRect.set(0, 0, bitmap4.getWidth(), this.mLeftBitmap.getHeight());
                this.mDstRect.set(this.mContentRect.left - this.mSrcRect.width(), f6, this.mContentRect.left, f7);
                canvas.drawBitmap(this.mLeftBitmap, this.mSrcRect, this.mDstRect, (Paint) null);
            }
            if (isDrawRight() && (bitmap3 = this.mRightBitmap) != null) {
                this.mSrcRect.set(0, 0, bitmap3.getWidth(), this.mRightBitmap.getHeight());
                RectF rectF2 = this.mDstRect;
                float f8 = this.mContentRect.right;
                rectF2.set(f8, f6, this.mSrcRect.width() + f8, f7);
                canvas.drawBitmap(this.mRightBitmap, this.mSrcRect, this.mDstRect, (Paint) null);
            }
        }
        if (f > f3) {
            if (isDrawTop() && (bitmap2 = this.mTopBitmap) != null) {
                this.mSrcRect.set(0, 0, bitmap2.getWidth(), this.mTopBitmap.getHeight());
                this.mDstRect.set(f4, this.mContentRect.top - this.mSrcRect.height(), f5, this.mContentRect.top);
                canvas.drawBitmap(this.mTopBitmap, this.mSrcRect, this.mDstRect, (Paint) null);
            }
            if (!isDrawBottom() || (bitmap = this.mBottomBitmap) == null) {
                return;
            }
            this.mSrcRect.set(0, 0, bitmap.getWidth(), this.mBottomBitmap.getHeight());
            RectF rectF3 = this.mDstRect;
            float f9 = this.mContentRect.bottom;
            rectF3.set(f4, f9, f5, this.mSrcRect.height() + f9);
            canvas.drawBitmap(this.mBottomBitmap, this.mSrcRect, this.mDstRect, (Paint) null);
        }
    }

    private void drawCorners(Canvas canvas, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        RectF rectF = this.mContentRect;
        float f = i;
        float f2 = rectF.left + f;
        float f3 = rectF.right - f;
        float f4 = rectF.top + f;
        float f5 = rectF.bottom - f;
        if ((isDrawLeft() || isDrawTop()) && (bitmap = this.mLeftTopBitmap) != null) {
            this.mSrcRect.set(0, 0, bitmap.getWidth(), this.mLeftTopBitmap.getHeight());
            this.mDstRect.set(f2 - this.mSrcRect.width(), f4 - this.mSrcRect.height(), f2, f4);
            canvas.drawBitmap(this.mLeftTopBitmap, this.mSrcRect, this.mDstRect, (Paint) null);
        }
        if ((isDrawLeft() || isDrawBottom()) && (bitmap2 = this.mLeftBottomBitmap) != null) {
            this.mSrcRect.set(0, 0, bitmap2.getWidth(), this.mLeftBottomBitmap.getHeight());
            this.mDstRect.set(f2 - this.mSrcRect.width(), f5, f2, this.mSrcRect.height() + f5);
            canvas.drawBitmap(this.mLeftBottomBitmap, this.mSrcRect, this.mDstRect, (Paint) null);
        }
        if ((isDrawTop() || isDrawRight()) && (bitmap3 = this.mRightTopBitmap) != null) {
            this.mSrcRect.set(0, 0, bitmap3.getWidth(), this.mRightTopBitmap.getHeight());
            this.mDstRect.set(f3, f4 - this.mSrcRect.height(), this.mSrcRect.width() + f3, f4);
            canvas.drawBitmap(this.mRightTopBitmap, this.mSrcRect, this.mDstRect, (Paint) null);
        }
        if ((isDrawRight() || isDrawBottom()) && (bitmap4 = this.mRightBottomBitmap) != null) {
            this.mSrcRect.set(0, 0, bitmap4.getWidth(), this.mRightBottomBitmap.getHeight());
            this.mDstRect.set(f3, f5, this.mSrcRect.width() + f3, this.mSrcRect.height() + f5);
            canvas.drawBitmap(this.mRightBottomBitmap, this.mSrcRect, this.mDstRect, (Paint) null);
        }
    }

    private ArrayList<c.b> getPosition(float f, float f2, int i) {
        ArrayList<c.b> arrayList = new ArrayList<>();
        if (isDrawLeft() || isDrawTop()) {
            arrayList.add(c.b.LEFT_TOP);
        }
        if (isDrawTop() || isDrawRight()) {
            arrayList.add(c.b.RIGHT_TOP);
        }
        if (isDrawBottom() || isDrawRight()) {
            arrayList.add(c.b.RIGHT_BOTTOM);
        }
        if (isDrawBottom() || isDrawLeft()) {
            arrayList.add(c.b.LEFT_BOTTOM);
        }
        float f3 = i;
        if (f2 > f3) {
            if (isDrawLeft()) {
                arrayList.add(c.b.LEFT);
            }
            if (isDrawRight()) {
                arrayList.add(c.b.RIGHT);
            }
        }
        if (f > f3) {
            if (isDrawTop()) {
                arrayList.add(c.b.TOP);
            }
            if (isDrawBottom()) {
                arrayList.add(c.b.BOTTOM);
            }
        }
        return arrayList;
    }

    private void init() {
        Paint paint = new Paint();
        this.mShadowPaint = paint;
        paint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(0);
        Paint paint2 = new Paint(1);
        this.mClearPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mClearPaint.setColor(-1);
        this.mClearPaint.setAntiAlias(true);
        this.mClearPaint.setXfermode(CLEAR_MODE);
        this.mContentRect = new RectF();
    }

    private void initAttributes(Resources resources, TypedArray typedArray) {
        this.mCornerRadius = typedArray.getDimension(R.styleable.HonorAdsHnShadowDrawable_honorAdsCornerRadius, 0.0f);
        int i = typedArray.getInt(R.styleable.HonorAdsHnShadowDrawable_honorAdsShadowBaseType, 0);
        this.mShadowBaseType = i;
        if (i == 2) {
            this.mOffsetY = typedArray.getDimension(R.styleable.HonorAdsHnShadowDrawable_honorAdsShadowOffsetY, 0.0f);
            this.mShadowElevation = Math.max(typedArray.getDimension(R.styleable.HonorAdsHnShadowDrawable_honorAdsShadowElevation, 1.0f), 1.0f);
            this.mShadowColor = typedArray.getColor(R.styleable.HonorAdsHnShadowDrawable_honorAdsShadowColor, 0);
        } else {
            int i2 = typedArray.getInt(R.styleable.HonorAdsHnShadowDrawable_honorAdsShadowLevel, -1);
            this.mShadowLevel = i2;
            setParamsByLevel(resources, i2);
        }
        this.mShowShadow = typedArray.getBoolean(R.styleable.HonorAdsHnShadowDrawable_honorAdsShowShadow, true);
        this.mIsUseRoundCorner = typedArray.getBoolean(R.styleable.HonorAdsHnShadowDrawable_honorAdsUseRoundCorner, true);
        this.mDrawFlags = typedArray.getInt(R.styleable.HonorAdsHnShadowDrawable_honorAdsShadowDrawnSide, 15);
    }

    private void setParamsByLevel(Resources resources, int i) {
        int i2 = this.mShadowBaseType;
        boolean z = i2 == 0 && i >= BLUR_CONFIG.length;
        boolean z2 = i2 == 1 && i >= SOLID_CONFIG.length;
        if (i < 0 || z || z2) {
            throw new IllegalArgumentException("Shadow's type or level is out of range!");
        }
        float f = resources.getDisplayMetrics().density;
        if (this.mShadowBaseType != 1) {
            int[] iArr = BLUR_CONFIG[i];
            this.mOffsetY = iArr[0] * f;
            this.mShadowElevation = iArr[1] * f;
            this.mShadowColor = resources.getColor(iArr[2]);
            return;
        }
        int[] iArr2 = SOLID_CONFIG[i];
        this.mOffsetY = iArr2[0] * f;
        this.mShadowElevation = iArr2[1] * f;
        this.mShadowColor = resources.getColor(iArr2[2]);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        SystemClock.elapsedRealtimeNanos();
        if (!this.mShowShadow || this.mContentRect.width() <= 0.0f || this.mContentRect.height() <= 0.0f) {
            return;
        }
        float fWidth = this.mContentRect.width() / 2.0f;
        float fHeight = this.mContentRect.height() / 2.0f;
        int iMin = (int) Math.min(this.mCornerRadius, Math.min(fWidth, fHeight));
        drawCorners(canvas, iMin);
        drawBorders(canvas, fWidth, fHeight, iMin);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowElevation() {
        return this.mShadowElevation;
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowOffsetX() {
        return this.mOffsetX;
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowOffsetY() {
        return this.mOffsetY;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public boolean isDrawBottom() {
        return (this.mDrawFlags & 8) != 0;
    }

    public boolean isDrawLeft() {
        return (this.mDrawFlags & 1) != 0;
    }

    public boolean isDrawRight() {
        return (this.mDrawFlags & 4) != 0;
    }

    public boolean isDrawTop() {
        return (this.mDrawFlags & 2) != 0;
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public boolean isShowShadow() {
        return this.mShowShadow;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        SystemClock.elapsedRealtimeNanos();
        if (this.mShowShadow) {
            setContentRect(rect);
            if (this.mContentRect.width() <= 0.0f || this.mContentRect.height() <= 0.0f) {
                com.hihonor.adsdk.common.b.b.hnadsc(TAG, "View's size <= 0, won't draw", new Object[0]);
                return;
            }
            this.mShadowPaint.setShadowLayer(this.mShadowElevation, this.mOffsetX, this.mOffsetY, this.mShadowColor);
            float fWidth = this.mContentRect.width() / 2.0f;
            float fHeight = this.mContentRect.height() / 2.0f;
            int iMin = (int) Math.min(this.mCornerRadius, Math.min(fWidth, fHeight));
            Bitmap[] bitmapArrHnadsa = c.hnadsa(this.mContext, (int) this.mShadowElevation, (int) this.mOffsetY, iMin, this.mIsUseRoundCorner, this.mShadowColor, this.mShadowPaint, this.mClearPaint, getPosition(fWidth, fHeight, iMin));
            if (bitmapArrHnadsa != null) {
                for (int i = 0; i < bitmapArrHnadsa.length; i++) {
                    switch (r13.get(i)) {
                        case LEFT:
                            this.mLeftBitmap = bitmapArrHnadsa[i];
                            break;
                        case TOP:
                            this.mTopBitmap = bitmapArrHnadsa[i];
                            break;
                        case RIGHT:
                            this.mRightBitmap = bitmapArrHnadsa[i];
                            break;
                        case BOTTOM:
                            this.mBottomBitmap = bitmapArrHnadsa[i];
                            break;
                        case LEFT_TOP:
                            this.mLeftTopBitmap = bitmapArrHnadsa[i];
                            break;
                        case LEFT_BOTTOM:
                            this.mLeftBottomBitmap = bitmapArrHnadsa[i];
                            break;
                        case RIGHT_TOP:
                            this.mRightTopBitmap = bitmapArrHnadsa[i];
                            break;
                        default:
                            this.mRightBottomBitmap = bitmapArrHnadsa[i];
                            break;
                    }
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowElevation(float f) {
        this.mShadowElevation = Math.max(f, 1.0f);
        Rect rect = this.mPadding;
        if (rect != null) {
            getPadding(rect);
        }
        invalidateSelf();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowLevel(int i) {
        if (i < 0 || i >= BLUR_CONFIG.length) {
            throw new IllegalArgumentException("Level not valid");
        }
        this.mShadowLevel = i;
        Resources resources = this.mResources;
        if (resources != null) {
            setParamsByLevel(resources, i);
            Rect rect = this.mPadding;
            if (rect != null) {
                getPadding(rect);
            }
            invalidateSelf();
        }
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowType(int i) {
        setShadowLevel(i);
    }

    public void updateContentRect(RectF rectF) {
        if (rectF != null) {
            this.mContentRect.set(rectF);
        }
    }

    private void setContentRect(Rect rect) {
        Rect rect2 = this.mPadding;
        if (rect2 == null) {
            this.mContentRect.left = rect.left + (isDrawLeft() ? this.mShadowElevation : 0.0f);
            this.mContentRect.top = rect.top + (isDrawTop() ? this.mShadowElevation : 0.0f);
            this.mContentRect.right = rect.right - (isDrawRight() ? this.mShadowElevation : 0.0f);
            this.mContentRect.bottom = rect.bottom - (isDrawBottom() ? this.mShadowElevation : 0.0f);
            return;
        }
        RectF rectF = this.mContentRect;
        rectF.left = rect.left + rect2.left;
        rectF.top = rect.top + rect2.top;
        rectF.right = rect.right - rect2.right;
        rectF.bottom = rect.bottom - rect2.bottom;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        this.mResources = resources;
        TypedArray typedArrayObtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.HonorAdsHnShadowDrawable, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.HonorAdsHnShadowDrawable);
        initAttributes(resources, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setCornerRadius(float f) {
        this.mCornerRadius = f;
        invalidateSelf();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowColor(int i) {
        this.mShadowColor = i;
        invalidateSelf();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShowShadow(boolean z) {
        this.mShowShadow = z;
        invalidateSelf();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowBaseType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("BaseType not valid");
        }
        this.mShadowBaseType = i;
        Resources resources = this.mResources;
        if (resources != null) {
            setParamsByLevel(resources, this.mShadowLevel);
            Rect rect = this.mPadding;
            if (rect != null) {
                getPadding(rect);
            }
            invalidateSelf();
        }
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowOffsetX(float f) {
        this.mOffsetX = f;
        Rect rect = this.mPadding;
        if (rect != null) {
            getPadding(rect);
        }
        invalidateSelf();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowOffsetY(float f) {
        this.mOffsetY = f;
        Rect rect = this.mPadding;
        if (rect != null) {
            getPadding(rect);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.mShowShadow) {
            return false;
        }
        int i = (int) this.mShadowElevation;
        int iAbs = Math.abs((int) this.mOffsetX);
        int iAbs2 = Math.abs((int) this.mOffsetY);
        rect.set(isDrawLeft() ? i + iAbs : 0, isDrawTop() ? i + iAbs2 : 0, isDrawRight() ? iAbs + i : 0, isDrawBottom() ? iAbs2 + i : 0);
        this.mPadding = new Rect(rect);
        return i != 0;
    }

    HnShadowDrawable(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        init();
    }
}
