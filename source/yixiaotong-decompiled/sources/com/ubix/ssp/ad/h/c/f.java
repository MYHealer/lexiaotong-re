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
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.ubix.ssp.ad.e.a0.j;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends b {
    private int v;
    private int w;
    private Bitmap x;
    private Rect y;
    WindowManager z;

    public f(Context context, Bundle bundle) {
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
            int width2 = bitmap.getWidth() - 1;
            return bitmap.getPixel(0, 0) == 0 && bitmap.getPixel(width, 0) == 0 && bitmap.getPixel(0, width2) == 0 && bitmap.getPixel(width, width2) == 0 && bitmap.getPixel(width / 2, width2 / 2) == 0;
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
        return 6013;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Bitmap bitmap = this.x;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(this.x, (Rect) null, this.y, (Paint) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:56:0x01f0 A[PHI: r6 r7 r8
  0x01f0: PHI (r6v45 int) = (r6v44 int), (r6v47 int) binds: [B:54:0x01e9, B:47:0x01c5] A[DONT_GENERATE, DONT_INLINE]
  0x01f0: PHI (r7v38 int) = (r7v37 int), (r7v40 int) binds: [B:54:0x01e9, B:47:0x01c5] A[DONT_GENERATE, DONT_INLINE]
  0x01f0: PHI (r8v40 int) = (r8v39 int), (r8v45 int) binds: [B:54:0x01e9, B:47:0x01c5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int measuredWidth;
        int iA;
        int measuredWidth2;
        int iA2;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.f8969a;
        if (getResources().getConfiguration().orientation == 2) {
            i5 = this.b;
        }
        int i6 = i5;
        int i7 = 0;
        while (i7 < getChildCount()) {
            View childAt = getChildAt(i7);
            switch (childAt.getId()) {
                case 400001:
                    i7 = i7;
                    int i8 = this.v;
                    int i9 = (this.f8969a + i8) / 2;
                    int iMin = Math.min(i8, this.w) / 16;
                    int i10 = this.j * 4;
                    int i11 = i9 - (iMin + i10);
                    int i12 = this.w;
                    int i13 = (i12 - this.d) / 2;
                    int i14 = this.v;
                    childAt.layout(i11, i13 + i10, ((this.f8969a + i14) / 2) - i10, i13 + (Math.min(i14, i12) / 16) + (this.j * 4));
                    break;
                case 400002:
                    i7 = i7;
                    childAt.layout(((this.v - this.f8969a) / 2) + (this.j * 2), getAppInfoTop() - (i6 / 28), ((this.v - this.f8969a) / 2) + (this.j * 2) + (i6 / 12), getAppInfoTop());
                    break;
                case 400003:
                    i7 = i7;
                    View viewFindViewById = findViewById(400002);
                    childAt.layout(viewFindViewById.getRight() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() - childAt.getMeasuredHeight()) / 2), viewFindViewById.getRight() + this.j + getMeasuredWidth(), viewFindViewById.getTop() + ((viewFindViewById.getHeight() + childAt.getMeasuredHeight()) / 2));
                    break;
                case 400004:
                    int i15 = this.v;
                    int i16 = this.f8969a;
                    int i17 = this.j * 2;
                    int i18 = (this.w - this.d) / 2;
                    childAt.layout(((i15 - i16) / 2) + i17, i18 + i17, ((i15 + i16) / 2) - i17, (i18 + this.b) - i17);
                    break;
                case 400007:
                    i7 = i7;
                    if (!this.s) {
                        int i19 = this.v;
                        int i20 = (i19 - this.f8969a) / 2;
                        int i21 = this.j * 4;
                        int i22 = i20 + i21;
                        int i23 = this.w;
                        int i24 = ((i23 - this.d) / 2) + i21;
                        int iMin2 = i20 + (Math.min(i19, i23) / 16) + (this.j * 4);
                        int i25 = this.w;
                        childAt.layout(i22, i24, iMin2, ((i25 - this.d) / 2) + (Math.min(this.v, i25) / 16) + (this.j * 4));
                    } else {
                        int iB = ((this.v - this.f8969a) / 2) + (this.j * 6) + r.b(20.0f);
                        int i26 = this.w;
                        int i27 = ((i26 - this.d) / 2) + (this.j * 4);
                        int i28 = this.v;
                        int iMin3 = ((i28 - this.f8969a) / 2) + (Math.min(i28, i26) / 16) + r.b(20.0f) + (this.j * 6);
                        int i29 = this.w;
                        childAt.layout(iB, i27, iMin3, ((i29 - this.d) / 2) + (Math.min(this.v, i29) / 16) + (this.j * 4));
                    }
                    break;
                case 400008:
                    childAt.setVisibility(0);
                    childAt.setBackgroundColor(-16777216);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    int i30 = this.f8969a;
                    int i31 = this.j * 4;
                    layoutParams.width = i30 - i31;
                    layoutParams.height = this.b - i31;
                    int i110 = this.v;
                    int i111 = this.f8969a;
                    int i112 = this.j * 2;
                    int i113 = (this.w - this.d) / 2;
                    childAt.layout(((i110 - i111) / 2) + i112, i113 + i112, ((i110 + i111) / 2) - i112, (i113 + this.b) - i112);
                    break;
                case 910100:
                case 910200:
                    i7 = i7;
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
                    int i32 = (this.v - this.f8969a) / 2;
                    if (getRealTemplateId() == 6003) {
                        measuredWidth = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i32;
                        iA = measuredHeight - (z2 ? r.a(20.0f) : 0);
                        measuredWidth2 = i32 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                        if (z2) {
                            iA2 = r.a(20.0f);
                        } else {
                            iA2 = 0;
                        }
                    } else {
                        measuredWidth = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i32;
                        iA = measuredHeight - (z2 ? r.a(40.0f) : 0);
                        measuredWidth2 = i32 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                        if (z2) {
                            iA2 = r.a(40.0f);
                        } else {
                            iA2 = 0;
                        }
                    }
                    childAt.layout(measuredWidth, iA, measuredWidth2, top - iA2);
                    break;
                case 910301:
                    try {
                        int i33 = (int) ((this.o * 25.0d) / 2.0d);
                        int i34 = this.f8969a;
                        double d = i34;
                        int i35 = (int) (d * 0.88d * 0.16d);
                        int i36 = ((int) (((double) ((this.v - i34) / 2)) + (d * 0.06d))) - i33;
                        int appInfoTop = (((getAppInfoTop() - (i6 / 20)) - 50) - i35) - i33;
                        int i37 = this.v;
                        int i38 = this.f8969a;
                        i7 = i7;
                        try {
                            childAt.layout(i36, appInfoTop, ((int) (((double) ((i37 + i38) / 2)) - (((double) i38) * 0.06d))) + i33, ((getAppInfoTop() - (i6 / 20)) - 50) + i33);
                            ((com.ubix.ssp.ad.e.c) childAt).b();
                            int i39 = i33 * 2;
                            ((com.ubix.ssp.ad.e.c) childAt).a(((int) (((double) this.f8969a) * 0.88d)) + i39, i35 + i39);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        i7 = i7;
                    }
                    break;
                case 910401:
                    View viewFindViewById2 = findViewById(920101);
                    int i40 = (int) ((this.o * 25.0d) / 2.0d);
                    int i41 = (int) (((double) (this.f8969a - (this.j * 6))) * 0.212d);
                    int height = viewFindViewById2 != null ? viewFindViewById2.getHeight() : 0;
                    int i42 = this.v;
                    int i43 = this.f8969a;
                    int i44 = (this.w + this.d) / 2;
                    double d2 = ((double) (height + (i6 / 20) + 50 + (i40 * 2) + i41)) * 1.6d;
                    childAt.layout((i42 - i43) / 2, (int) (((double) i44) - d2), (i42 + i43) / 2, i44);
                    ((com.ubix.ssp.ad.e.e) childAt).a(this.f8969a, (int) d2);
                    i7 = i7;
                    break;
                case 920101:
                    int i45 = ((this.v - this.f8969a) / 2) + (this.j * 2);
                    int measuredHeight2 = ((this.w + this.d) / 2) - childAt.getMeasuredHeight();
                    int i46 = this.j;
                    int i47 = i46 * 3;
                    childAt.layout(i45, measuredHeight2 - i47, ((this.v + this.f8969a) / 2) - (i46 * 2), ((this.w + this.d) / 2) - i47);
                    childAt.getLayoutParams().width = this.f8969a - (this.j * 4);
                    i7 = i7;
                    break;
                case 920301:
                    int i48 = (this.v - this.f8969a) / 2;
                    int i49 = this.j * 4;
                    childAt.layout(i48 + i49, ((this.w - this.d) / 2) + i49, i48 + r.b(20.0f) + (this.j * 4), ((this.w - this.d) / 2) + r.b(12.0f) + (this.j * 4));
                    i7 = i7;
                    break;
                default:
                    i7 = i7;
                    break;
            }
            i7++;
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
