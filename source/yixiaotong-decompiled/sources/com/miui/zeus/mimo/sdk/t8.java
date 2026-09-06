package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t8 extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f5616a;
    public final RectF b;
    public final RectF c;
    public Paint d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public Paint p;
    public Bitmap q;
    public Canvas r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public boolean x;

    public static class a extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5617a;
        public int b;
        public int c;
        public int d;

        public a(int i, int i2) {
            super(i, i2);
            this.f5617a = 4;
            this.b = 32;
            this.c = 0;
            this.d = 0;
        }
    }

    public t8(Context context, AttributeSet attributeSet, int i) {
        super(context, null, i);
        this.f5616a = new RectF();
        RectF rectF = new RectF();
        this.b = rectF;
        this.c = new RectF();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.w = 0;
        this.x = true;
        setWillNotDraw(false);
        WindowManager windowManager = (WindowManager) getContext().getSystemService(ijiami_1011.s.s.s.d(new byte[]{71, 93, 92, 87, 14, Ascii.SYN}, "0423aa"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        rectF.set(0.0f, 0.0f, i2, i3);
        try {
            this.q = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (Throwable unused) {
            this.q = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        this.r = new Canvas(this.q);
        this.d = new Paint();
        Paint paint = new Paint();
        this.p = paint;
        paint.setColor(-1);
        this.p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.p.setFlags(1);
    }

    private Paint getBorderPaint() {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStrokeWidth(f9.a(getContext(), 2.0f));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.SOLID));
        return paint;
    }

    public final void a(View view, RectF rectF, int i) {
        if (i == 16) {
            float f = this.f5616a.left;
            rectF.left = f;
            rectF.right = f + view.getMeasuredWidth();
        } else if (i == 32) {
            rectF.left = (this.f5616a.width() - view.getMeasuredWidth()) / 2.0f;
            rectF.right = (this.f5616a.width() + view.getMeasuredWidth()) / 2.0f;
            rectF.offset(this.f5616a.left, 0.0f);
        } else {
            if (i != 48) {
                return;
            }
            float f2 = this.f5616a.right;
            rectF.right = f2;
            rectF.left = f2 - view.getMeasuredWidth();
        }
    }

    public final void b(View view, RectF rectF, int i) {
        if (i == 16) {
            float f = this.f5616a.top;
            rectF.top = f;
            rectF.bottom = f + view.getMeasuredHeight();
        } else if (i == 32) {
            rectF.top = (this.f5616a.width() - view.getMeasuredHeight()) / 2.0f;
            rectF.bottom = (this.f5616a.width() + view.getMeasuredHeight()) / 2.0f;
            rectF.offset(0.0f, this.f5616a.top);
        } else {
            if (i != 48) {
                return;
            }
            RectF rectF2 = this.f5616a;
            rectF.bottom = rectF2.bottom;
            rectF.top = rectF2.bottom - view.getMeasuredHeight();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        for (int i = 0; i < getChildCount(); i++) {
            try {
                drawChild(canvas, getChildAt(i), drawingTime);
            } catch (NullPointerException unused) {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            clearFocus();
            this.r.setBitmap(null);
            this.q = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.w;
        if (i != 0) {
            this.f5616a.offset(0.0f, i);
            this.v += this.w;
            this.w = 0;
        }
        this.q.eraseColor(0);
        this.r.drawColor(this.d.getColor());
        if (!this.j) {
            if (this.o != 1) {
                Path path = new Path();
                float f = this.k;
                float f2 = this.l;
                float f3 = this.m;
                float f4 = this.n;
                path.addRoundRect(this.f5616a, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
                this.r.drawPath(path, this.p);
                if (this.t) {
                    this.r.drawPath(path, getBorderPaint());
                }
            } else {
                this.r.drawCircle(this.f5616a.centerX(), this.f5616a.centerY(), this.f5616a.width() / 2.0f, this.p);
                if (this.t) {
                    this.r.drawCircle(this.f5616a.centerX(), this.f5616a.centerY(), this.f5616a.width() / 2.0f, getBorderPaint());
                }
            }
        }
        Bitmap bitmap = this.q;
        RectF rectF = this.b;
        canvas.drawBitmap(bitmap, rectF.left, rectF.top, (Paint) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a aVar;
        int childCount = getChildCount();
        float f = getResources().getDisplayMetrics().density;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && (aVar = (a) childAt.getLayoutParams()) != null) {
                int i6 = aVar.f5617a;
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            RectF rectF = this.c;
                            float f2 = this.f5616a.right;
                            rectF.left = f2;
                            rectF.right = f2 + childAt.getMeasuredWidth();
                        } else if (i6 == 4) {
                            RectF rectF2 = this.c;
                            float f3 = this.f5616a.bottom;
                            rectF2.top = f3;
                            rectF2.bottom = f3 + childAt.getMeasuredHeight();
                        } else if (i6 == 5) {
                            this.c.left = (((int) this.f5616a.width()) - childAt.getMeasuredWidth()) >> 1;
                            this.c.top = (((int) this.f5616a.height()) - childAt.getMeasuredHeight()) >> 1;
                            this.c.right = (((int) this.f5616a.width()) + childAt.getMeasuredWidth()) >> 1;
                            this.c.bottom = (((int) this.f5616a.height()) + childAt.getMeasuredHeight()) >> 1;
                            RectF rectF3 = this.c;
                            RectF rectF4 = this.f5616a;
                            rectF3.offset(rectF4.left, rectF4.top);
                        }
                        this.c.offset((int) ((aVar.c * f) + 0.5f), (int) ((aVar.d * f) + 0.5f));
                        RectF rectF5 = this.c;
                        childAt.layout((int) rectF5.left, (int) rectF5.top, (int) rectF5.right, (int) rectF5.bottom);
                    } else {
                        RectF rectF6 = this.c;
                        float f4 = this.f5616a.top;
                        rectF6.bottom = f4;
                        rectF6.top = f4 - childAt.getMeasuredHeight();
                    }
                    a(childAt, this.c, aVar.b);
                    this.c.offset((int) ((aVar.c * f) + 0.5f), (int) ((aVar.d * f) + 0.5f));
                    RectF rectF7 = this.c;
                    childAt.layout((int) rectF7.left, (int) rectF7.top, (int) rectF7.right, (int) rectF7.bottom);
                } else {
                    RectF rectF8 = this.c;
                    float f5 = this.f5616a.left;
                    rectF8.right = f5;
                    rectF8.left = f5 - childAt.getMeasuredWidth();
                }
                b(childAt, this.c, aVar.b);
                this.c.offset((int) ((aVar.c * f) + 0.5f), (int) ((aVar.d * f) + 0.5f));
                RectF rectF9 = this.c;
                childAt.layout((int) rectF9.left, (int) rectF9.top, (int) rectF9.right, (int) rectF9.bottom);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.x) {
            this.v = size2;
            this.x = false;
        }
        int i3 = this.v;
        if (i3 <= size2 && i3 >= size2) {
            this.w = 0;
        } else {
            this.w = size2 - i3;
        }
        setMeasuredDimension(size, size2);
        this.b.set(0.0f, 0.0f, size, size2);
        if (!this.s) {
            int i4 = this.e;
            if (i4 != 0 && this.f == 0) {
                this.f5616a.left -= i4;
            }
            if (i4 != 0 && this.g == 0) {
                this.f5616a.top -= i4;
            }
            if (i4 != 0 && this.h == 0) {
                this.f5616a.right += i4;
            }
            if (i4 != 0 && this.i == 0) {
                this.f5616a.bottom += i4;
            }
            int i5 = this.f;
            if (i5 != 0) {
                this.f5616a.left -= i5;
            }
            int i6 = this.g;
            if (i6 != 0) {
                this.f5616a.top -= i6;
            }
            int i7 = this.h;
            if (i7 != 0) {
                this.f5616a.right += i7;
            }
            int i8 = this.i;
            if (i8 != 0) {
                this.f5616a.bottom += i8;
            }
            this.s = true;
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt != null) {
                measureChild(childAt, i, i2);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.u && motionEvent.getAction() == 0) {
            if (!this.f5616a.contains(motionEvent.getX(), motionEvent.getY())) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setFullingAlpha(int i) {
        this.d.setAlpha(i);
    }

    public void setFullingColor(int i) {
        this.d.setColor(i);
    }

    public void setHighTargetBorderBlurMask(boolean z) {
        this.t = z;
    }

    public void setHighTargetGraphStyle(int i) {
        this.o = i;
    }

    public void setInterceptClickEvent(boolean z) {
        this.u = z;
    }

    public void setOverlayTarget(boolean z) {
        this.j = z;
    }

    public void setPadding(int i) {
        this.e = i;
    }

    public void setPaddingBottom(int i) {
        this.i = i;
    }

    public void setPaddingLeft(int i) {
        this.f = i;
    }

    public void setPaddingRight(int i) {
        this.h = i;
    }

    public void setPaddingTop(int i) {
        this.g = i;
    }

    public void setTargetRect(Rect rect) {
        this.f5616a.set(rect);
    }
}
