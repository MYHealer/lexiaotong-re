package com.ubix.ssp.ad.h.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.ubix.ssp.ad.e.a0.j;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends b {
    private int v;
    private int w;
    private Bitmap x;
    private Rect y;
    WindowManager z;

    public e(Context context, Bundle bundle) {
        super(context, bundle);
        this.x = null;
        this.y = new Rect();
        this.z = null;
        this.v = r.a().h(getContext());
        this.w = r.a().c(getContext()) - com.ubix.ssp.ad.e.a0.c.e(getContext());
        setWillNotDraw(false);
        d();
    }

    private void a(Bitmap bitmap) {
        if (bitmap != null && bitmap.getWidth() - this.c >= 0 && bitmap.getHeight() - this.d >= 0) {
            int width = (bitmap.getWidth() - this.c) / 2;
            int height = bitmap.getHeight();
            int i = this.d;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, width, (height - i) / 2, this.c, i);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(bitmapCreateBitmap2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Rect rect = new Rect(0, 0, this.c, this.d);
            canvas.drawRoundRect(new RectF(rect), 12.0f, 12.0f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmapCreateBitmap, rect, rect, paint);
            this.x = j.a(bitmapCreateBitmap2, 50, true);
            Drawable drawableA = com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#A6020202"), 12);
            drawableA.setBounds(0, 0, this.c, this.d);
            drawableA.draw(canvas);
            GradientDrawable gradientDrawableA = com.ubix.ssp.ad.e.a0.c.a(Color.parseColor("#CCC9C9C9"), Color.parseColor("#6BEDEDED"), 12, GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawableA.setBounds(0, 0, this.c, this.d);
            gradientDrawableA.draw(canvas);
            GradientDrawable gradientDrawableA2 = com.ubix.ssp.ad.e.a0.c.a(Color.parseColor("#00000000"), Color.parseColor("#40000000"), 12);
            int i2 = this.d;
            gradientDrawableA2.setBounds(0, i2 - 100, this.c, i2);
            gradientDrawableA2.draw(canvas);
            try {
                ((Activity) findViewById(400004).getContext()).getWindow().getDecorView().setDrawingCacheEnabled(false);
                ((Activity) findViewById(400004).getContext()).getWindow().getDecorView().destroyDrawingCache();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            int i3 = this.v;
            int i4 = this.c;
            int i5 = this.w;
            int i6 = this.d;
            this.y = new Rect((i3 - i4) / 2, (i5 - i6) / 2, (i3 + i4) / 2, (i5 + i6) / 2);
            setLayoutParams(new RelativeLayout.LayoutParams(this.v, this.w));
            bitmap.recycle();
            invalidate();
        }
    }

    private boolean b(Bitmap bitmap) {
        if (bitmap == null || bitmap.getWidth() * bitmap.getHeight() <= 0) {
            return true;
        }
        try {
            int width = bitmap.getWidth() - 1;
            int height = bitmap.getHeight() - 1;
            return bitmap.getPixel(0, 0) == 0 && bitmap.getPixel(width, 0) == 0 && bitmap.getPixel(0, height) == 0 && bitmap.getPixel(width, height) == 0 && bitmap.getPixel(width / 2, height / 2) == 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void d() {
        Bitmap bitmapCreateBitmap;
        try {
            ((Activity) findViewById(400004).getContext()).getWindow().getDecorView().setDrawingCacheEnabled(true);
            bitmapCreateBitmap = ((Activity) findViewById(400004).getContext()).getWindow().getDecorView().getDrawingCache();
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapCreateBitmap = null;
        }
        if (bitmapCreateBitmap == null || b(bitmapCreateBitmap)) {
            bitmapCreateBitmap = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(-12303292);
        }
        a(bitmapCreateBitmap);
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public void a() {
        super.a();
        try {
            Bitmap bitmap = this.x;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.x.recycle();
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public boolean a(int i) {
        return true;
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public int getRealTemplateId() {
        return 6003;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Bitmap bitmap = this.x;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.y, (Paint) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x01ef A[PHI: r6 r7 r8
  0x01ef: PHI (r6v23 int) = (r6v22 int), (r6v25 int) binds: [B:53:0x01e8, B:46:0x01c4] A[DONT_GENERATE, DONT_INLINE]
  0x01ef: PHI (r7v28 int) = (r7v27 int), (r7v30 int) binds: [B:53:0x01e8, B:46:0x01c4] A[DONT_GENERATE, DONT_INLINE]
  0x01ef: PHI (r8v24 int) = (r8v23 int), (r8v29 int) binds: [B:53:0x01e8, B:46:0x01c4] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean z2;
        int measuredWidth;
        int iA;
        int measuredWidth2;
        int iA2;
        super.onLayout(z, i, i2, i3, i4);
        int i6 = this.f8969a;
        if (getResources().getConfiguration().orientation == 2) {
            i6 = this.b;
        }
        int i7 = i6;
        int i8 = 0;
        while (i8 < getChildCount()) {
            View childAt = getChildAt(i8);
            switch (childAt.getId()) {
                case 400001:
                    i5 = i8;
                    int i9 = this.v;
                    int i10 = (this.f8969a + i9) / 2;
                    int iMin = Math.min(i9, this.w) / 16;
                    int i11 = this.j * 4;
                    int i12 = i10 - (iMin + i11);
                    int i13 = this.w;
                    int i14 = (i13 - this.d) / 2;
                    int i15 = this.v;
                    childAt.layout(i12, i14 + i11, ((this.f8969a + i15) / 2) - i11, i14 + (Math.min(i15, i13) / 16) + (this.j * 4));
                    continue;
                    i8 = i5 + 1;
                    break;
                case 400002:
                    i5 = i8;
                    childAt.layout(((this.v - this.f8969a) / 2) + (this.j * 2), getAppInfoTop() - (i7 / 28), ((this.v - this.f8969a) / 2) + (this.j * 2) + (i7 / 12), getAppInfoTop());
                    continue;
                    i8 = i5 + 1;
                    break;
                case 400003:
                    i5 = i8;
                    View viewFindViewById = findViewById(400002);
                    childAt.layout(viewFindViewById.getRight() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() - childAt.getMeasuredHeight()) / 2), viewFindViewById.getRight() + this.j + getMeasuredWidth(), viewFindViewById.getTop() + ((viewFindViewById.getHeight() + childAt.getMeasuredHeight()) / 2));
                    continue;
                    i8 = i5 + 1;
                    break;
                case 400004:
                    i5 = i8;
                    int i16 = this.v;
                    int i17 = this.f8969a;
                    int i18 = this.j * 2;
                    int i19 = (this.w - this.d) / 2;
                    childAt.layout(((i16 - i17) / 2) + i18, i19 + i18, ((i16 + i17) / 2) - i18, (i19 + this.b) - i18);
                    continue;
                    i8 = i5 + 1;
                    break;
                case 910100:
                case 910200:
                    i5 = i8;
                    int top = findViewById(400002) != null ? findViewById(400002).getTop() : i4;
                    if (findViewById(910301) != null) {
                        top = findViewById(910301).getTop();
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (findViewById(400004) != null) {
                        findViewById(400004).getBottom();
                    }
                    int measuredHeight = top - childAt.getMeasuredHeight();
                    int i20 = (this.v - this.f8969a) / 2;
                    if (getRealTemplateId() == 6003) {
                        measuredWidth = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i20;
                        iA = measuredHeight - (z2 ? r.a(20.0f) : 0);
                        measuredWidth2 = i20 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                        if (z2) {
                            iA2 = r.a(20.0f);
                        } else {
                            iA2 = 0;
                        }
                    } else {
                        measuredWidth = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i20;
                        iA = measuredHeight - (z2 ? r.a(40.0f) : 0);
                        measuredWidth2 = i20 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                        if (z2) {
                            iA2 = r.a(40.0f);
                        } else {
                            iA2 = 0;
                        }
                    }
                    childAt.layout(measuredWidth, iA, measuredWidth2, top - iA2);
                    continue;
                    i8 = i5 + 1;
                    break;
                case 910301:
                    try {
                        int i21 = (int) ((this.o * 25.0d) / 2.0d);
                        int i22 = this.f8969a;
                        double d = i22;
                        int i23 = (int) (d * 0.88d * 0.16d);
                        int i24 = ((int) (((double) ((this.v - i22) / 2)) + (d * 0.06d))) - i21;
                        int appInfoTop = (((getAppInfoTop() - (i7 / 20)) - 50) - i23) - i21;
                        int i25 = this.v;
                        int i26 = this.f8969a;
                        i5 = i8;
                        try {
                            childAt.layout(i24, appInfoTop, ((int) (((double) ((i25 + i26) / 2)) - (((double) i26) * 0.06d))) + i21, ((getAppInfoTop() - (i7 / 20)) - 50) + i21);
                            ((com.ubix.ssp.ad.e.c) childAt).b();
                            int i27 = i21 * 2;
                            ((com.ubix.ssp.ad.e.c) childAt).a(((int) (((double) this.f8969a) * 0.88d)) + i27, i23 + i27);
                            continue;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        i5 = i8;
                    }
                    i8 = i5 + 1;
                    break;
                case 910401:
                    View viewFindViewById2 = findViewById(920101);
                    int i28 = (int) ((this.o * 25.0d) / 2.0d);
                    int i29 = (int) (((double) (this.f8969a - (this.j * 6))) * 0.212d);
                    int height = viewFindViewById2 != null ? viewFindViewById2.getHeight() : 0;
                    int i30 = this.v;
                    int i31 = this.f8969a;
                    int i32 = (this.w + this.d) / 2;
                    double d2 = ((double) (height + (i7 / 20) + 50 + (i28 * 2) + i29)) * 1.6d;
                    childAt.layout((i30 - i31) / 2, (int) (((double) i32) - d2), (i30 + i31) / 2, i32);
                    ((com.ubix.ssp.ad.e.e) childAt).a(this.f8969a, (int) d2);
                    break;
                case 920101:
                    int i33 = ((this.v - this.f8969a) / 2) + (this.j * 2);
                    int measuredHeight2 = ((this.w + this.d) / 2) - childAt.getMeasuredHeight();
                    int i34 = this.j;
                    int i35 = i34 * 3;
                    childAt.layout(i33, measuredHeight2 - i35, ((this.v + this.f8969a) / 2) - (i34 * 2), ((this.w + this.d) / 2) - i35);
                    childAt.getLayoutParams().width = this.f8969a - (this.j * 4);
                    break;
                case 920301:
                    int i36 = (this.v - this.f8969a) / 2;
                    int i37 = this.j * 4;
                    childAt.layout(i36 + i37, ((this.w - this.d) / 2) + i37, i36 + r.b(20.0f) + (this.j * 4), ((this.w - this.d) / 2) + r.b(12.0f) + (this.j * 4));
                    break;
            }
            i5 = i8;
            i8 = i5 + 1;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int iG;
        super.onSizeChanged(i, i2, i3, i4);
        if (this.z == null) {
            this.z = (WindowManager) getContext().getSystemService("window");
        }
        int orientation = this.z.getDefaultDisplay().getOrientation();
        a(this.i);
        if (orientation == 1 || orientation == 3) {
            this.v = r.a().f(getContext());
            iG = r.a().g(getContext());
        } else {
            this.v = r.a().h(getContext());
            iG = r.a().c(getContext());
        }
        this.w = iG - com.ubix.ssp.ad.e.a0.c.e(getContext());
        int i5 = this.v;
        int i6 = this.c;
        int i7 = this.w;
        int i8 = this.d;
        this.y = new Rect((i5 - i6) / 2, (i7 - i8) / 2, (i5 + i6) / 2, (i7 + i8) / 2);
    }
}
