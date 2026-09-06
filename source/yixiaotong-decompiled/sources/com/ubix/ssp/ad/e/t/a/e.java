package com.ubix.ssp.ad.e.t.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.ubix.ssp.ad.e.a0.u;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends ImageView implements com.ubix.ssp.ad.e.t.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ubix.ssp.ad.e.t.a.c f8864a;
    private Bitmap b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private Rect g;
    public boolean h;
    public boolean i;
    private c j;
    private d k;
    private Paint l;
    private RectF m;
    private boolean n;
    private PorterDuffXfermode o;
    private Rect p;
    float q;
    float r;
    float s;
    float t;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.requestLayout();
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8866a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[d.values().length];
            b = iArr;
            try {
                iArr[d.WAIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[d.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[d.SYNC_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f8866a = iArr2;
            try {
                iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8866a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8866a[ImageView.ScaleType.FIT_XY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private class c extends Thread {
        private c() {
        }

        /* synthetic */ c(e eVar, a aVar) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (e.this.f8864a == null) {
                return;
            }
            while (e.this.c) {
                if (e.this.d) {
                    SystemClock.sleep(10L);
                } else {
                    try {
                        com.ubix.ssp.ad.e.t.a.d dVarG = e.this.f8864a.g();
                        e.this.b = dVarG.f8863a;
                        long j = dVarG.b;
                        if (j <= 0) {
                            j = 100;
                        }
                        e.this.a();
                        SystemClock.sleep(j);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    public enum d {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);

        final int e;

        d(int i) {
            this.e = i;
        }
    }

    public e(Context context) {
        super(context);
        this.f8864a = null;
        this.b = null;
        this.c = true;
        this.d = false;
        this.e = -1;
        this.f = -1;
        this.g = null;
        this.h = false;
        this.i = false;
        this.j = null;
        this.k = d.SYNC_DECODER;
        this.l = new Paint(1);
        this.m = new RectF();
        this.n = false;
        this.o = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.p = new Rect();
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8864a = null;
        this.b = null;
        this.c = true;
        this.d = false;
        this.e = -1;
        this.f = -1;
        this.g = null;
        this.h = false;
        this.i = false;
        this.j = null;
        this.k = d.SYNC_DECODER;
        this.l = new Paint(1);
        this.m = new RectF();
        this.n = false;
        this.o = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.p = new Rect();
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        postInvalidate();
    }

    private void setGifDecoderImage(InputStream inputStream) {
        com.ubix.ssp.ad.e.t.a.c cVar = this.f8864a;
        if (cVar != null) {
            cVar.c();
            this.f8864a = null;
        }
        com.ubix.ssp.ad.e.t.a.c cVar2 = new com.ubix.ssp.ad.e.t.a.c(inputStream, this);
        this.f8864a = cVar2;
        cVar2.start();
        setBackgroundColor(0);
    }

    private void setGifDecoderImage(byte[] bArr) {
        com.ubix.ssp.ad.e.t.a.c cVar = this.f8864a;
        if (cVar != null) {
            cVar.c();
            this.f8864a = null;
        }
        com.ubix.ssp.ad.e.t.a.c cVar2 = new com.ubix.ssp.ad.e.t.a.c(bArr, this);
        this.f8864a = cVar2;
        cVar2.start();
        setBackgroundColor(0);
    }

    public void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.e = i;
        this.f = i2;
        Rect rect = new Rect();
        this.g = rect;
        rect.left = 0;
        rect.top = 0;
        rect.right = i;
        rect.bottom = i2;
        this.m = new RectF(0.0f, 0.0f, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002e  */
    @Override // com.ubix.ssp.ad.e.t.a.b
    public void a(boolean z, int i) {
        c cVar;
        if (z) {
            if (this.f8864a == null) {
                u.d("gif parse error");
                return;
            }
            int i2 = b.b[this.k.ordinal()];
            a aVar = null;
            if (i2 == 1) {
                if (i == -1) {
                    if (this.f8864a.d() > 1) {
                        cVar = new c(this, aVar);
                        cVar.start();
                        return;
                    }
                    a();
                }
                return;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                if (i == 1) {
                    this.b = this.f8864a.e();
                } else if (i != -1) {
                    if (this.j == null) {
                        cVar = new c(this, aVar);
                        this.j = cVar;
                        cVar.start();
                        return;
                    }
                    return;
                }
                a();
            }
            if (i == 1) {
                this.b = this.f8864a.e();
            } else {
                if (i != -1) {
                    return;
                }
                if (this.f8864a.d() > 1) {
                    if (this.j == null) {
                        cVar = new c(this, aVar);
                        this.j = cVar;
                        cVar.start();
                        return;
                    }
                    return;
                }
            }
            a();
        }
    }

    @Override // com.ubix.ssp.ad.e.t.a.b
    public void a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x01db A[Catch: Exception -> 0x0219, TryCatch #0 {Exception -> 0x0219, blocks: (B:2:0x0000, B:4:0x0007, B:5:0x000f, B:8:0x0014, B:12:0x0071, B:13:0x0080, B:23:0x01d5, B:25:0x01db, B:27:0x01ea, B:29:0x01fe, B:31:0x020e, B:30:0x0207, B:26:0x01e3, B:14:0x0087, B:16:0x0090, B:18:0x012b, B:17:0x00de, B:19:0x013e, B:21:0x0146, B:22:0x018c), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x01e3 A[Catch: Exception -> 0x0219, TryCatch #0 {Exception -> 0x0219, blocks: (B:2:0x0000, B:4:0x0007, B:5:0x000f, B:8:0x0014, B:12:0x0071, B:13:0x0080, B:23:0x01d5, B:25:0x01db, B:27:0x01ea, B:29:0x01fe, B:31:0x020e, B:30:0x0207, B:26:0x01e3, B:14:0x0087, B:16:0x0090, B:18:0x012b, B:17:0x00de, B:19:0x013e, B:21:0x0146, B:22:0x018c), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x01fe A[Catch: Exception -> 0x0219, TryCatch #0 {Exception -> 0x0219, blocks: (B:2:0x0000, B:4:0x0007, B:5:0x000f, B:8:0x0014, B:12:0x0071, B:13:0x0080, B:23:0x01d5, B:25:0x01db, B:27:0x01ea, B:29:0x01fe, B:31:0x020e, B:30:0x0207, B:26:0x01e3, B:14:0x0087, B:16:0x0090, B:18:0x012b, B:17:0x00de, B:19:0x013e, B:21:0x0146, B:22:0x018c), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0207 A[Catch: Exception -> 0x0219, TryCatch #0 {Exception -> 0x0219, blocks: (B:2:0x0000, B:4:0x0007, B:5:0x000f, B:8:0x0014, B:12:0x0071, B:13:0x0080, B:23:0x01d5, B:25:0x01db, B:27:0x01ea, B:29:0x01fe, B:31:0x020e, B:30:0x0207, B:26:0x01e3, B:14:0x0087, B:16:0x0090, B:18:0x012b, B:17:0x00de, B:19:0x013e, B:21:0x0146, B:22:0x018c), top: B:34:0x0000 }] */
    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF;
        float width;
        Paint paint;
        float f;
        RectF rectF2;
        Bitmap bitmap;
        RectF rectF3;
        Paint paint2;
        Rect rect;
        Rect rect2;
        int height;
        try {
            super.onDraw(canvas);
            if (this.b == null) {
                this.b = this.f8864a.e();
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 == null) {
                return;
            }
            this.q = (bitmap2.getWidth() * 1.0f) / this.b.getHeight();
            this.r = (getWidth() * 1.0f) / getHeight();
            this.s = 0.0f;
            this.t = 0.0f;
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            int i = b.f8866a[getScaleType().ordinal()];
            if (i == 1) {
                if (this.q > this.r) {
                    this.t = ((getWidth() * 1.0f) / this.b.getWidth()) * this.b.getHeight();
                    this.m.top = Math.abs(getHeight() - this.t) / 2.0f;
                    this.m.bottom = getHeight() - (Math.abs(getHeight() - this.t) / 2.0f);
                    rectF = this.m;
                    rectF.left = 0.0f;
                } else {
                    this.s = ((getHeight() * 1.0f) / this.b.getHeight()) * this.b.getWidth();
                    RectF rectF4 = this.m;
                    rectF4.top = 0.0f;
                    rectF4.bottom = getHeight();
                    this.m.left = Math.abs(getWidth() - this.s) / 2.0f;
                    rectF = this.m;
                    width = getWidth() - (Math.abs(getWidth() - this.s) / 2.0f);
                }
                rectF.right = width;
                if (this.n) {
                    rectF2 = this.m;
                    f = 8.0f;
                    paint = this.l;
                } else {
                    RectF rectF5 = this.m;
                    paint = this.l;
                    f = 0.0f;
                    rectF2 = rectF5;
                }
                canvas.drawRoundRect(rectF2, f, f, paint);
                this.l.setXfermode(this.o);
                if (this.p.isEmpty()) {
                    bitmap = this.b;
                    rectF3 = this.m;
                    paint2 = this.l;
                    rect = null;
                } else {
                    bitmap = this.b;
                    rect = this.p;
                    rectF3 = this.m;
                    paint2 = this.l;
                }
                canvas.drawBitmap(bitmap, rect, rectF3, paint2);
                this.l.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
            }
            if (i != 2) {
                RectF rectF6 = this.m;
                rectF6.top = 0.0f;
                rectF6.bottom = getHeight();
                rectF = this.m;
                rectF.left = 0.0f;
            } else {
                if (this.q > this.r) {
                    float height2 = ((this.b.getHeight() * 1.0f) / getHeight()) * getWidth();
                    this.s = height2;
                    this.p.left = (int) (Math.abs(height2 - this.b.getWidth()) / 2.0f);
                    Rect rect3 = this.p;
                    rect3.top = 0;
                    rect3.right = this.b.getWidth() - ((int) (Math.abs(this.s - this.b.getWidth()) / 2.0f));
                    rect2 = this.p;
                    height = this.b.getHeight();
                } else {
                    float width2 = ((this.b.getWidth() * 1.0f) / getWidth()) * getHeight();
                    this.t = width2;
                    Rect rect4 = this.p;
                    rect4.left = 0;
                    rect4.top = (int) (Math.abs(width2 - this.b.getHeight()) / 2.0f);
                    this.p.right = this.b.getWidth();
                    rect2 = this.p;
                    height = this.b.getHeight() - ((int) (Math.abs(this.t - this.b.getHeight()) / 2.0f));
                }
                rect2.bottom = height;
                RectF rectF7 = this.m;
                rectF7.top = 0.0f;
                rectF7.bottom = getHeight();
                rectF = this.m;
                rectF.left = 0.0f;
            }
            width = getWidth();
            rectF.right = width;
            if (this.n) {
                rectF2 = this.m;
                f = 8.0f;
                paint = this.l;
            } else {
                RectF rectF8 = this.m;
                paint = this.l;
                f = 0.0f;
                rectF2 = rectF8;
            }
            canvas.drawRoundRect(rectF2, f, f, paint);
            this.l.setXfermode(this.o);
            if (this.p.isEmpty()) {
                bitmap = this.b;
                rect = this.p;
                rectF3 = this.m;
                paint2 = this.l;
            } else {
                bitmap = this.b;
                rectF3 = this.m;
                paint2 = this.l;
                rect = null;
            }
            canvas.drawBitmap(bitmap, rect, rectF3, paint2);
            this.l.setXfermode(null);
            canvas.restoreToCount(iSaveLayer);
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size;
        int size2;
        if (this.h) {
            super.onMeasure(i, i2);
        } else {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            com.ubix.ssp.ad.e.t.a.c cVar = this.f8864a;
            if (cVar == null) {
                i4 = 1;
                i3 = 1;
            } else {
                int i5 = cVar.f8862a;
                i3 = cVar.b;
                i4 = i5;
            }
            int iMax = Math.max(i4 + paddingLeft + paddingRight, getSuggestedMinimumWidth());
            int iMax2 = Math.max(i3 + paddingTop + paddingBottom, getSuggestedMinimumHeight());
            int iResolveSize = ImageView.resolveSize(iMax, i);
            int iResolveSize2 = ImageView.resolveSize(iMax2, i2);
            if (iResolveSize == 0 || iResolveSize2 == 0) {
                super.onMeasure(i, i2);
                postDelayed(new a(), 500L);
            } else if (this.i) {
                double dMax = 1.0d / Math.max((View.MeasureSpec.getMode(i) == 0 || iMax <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0d : ((double) iMax) / ((double) size2), (View.MeasureSpec.getMode(i2) == 0 || iMax2 <= (size = View.MeasureSpec.getSize(i2))) ? 1.0d : ((double) iMax2) / ((double) size));
                iResolveSize = (int) (((double) iMax) * dMax);
                iResolveSize2 = (int) (((double) iMax2) * dMax);
                a(iResolveSize, iResolveSize2);
            }
            setMeasuredDimension(iResolveSize, iResolveSize2);
        }
        this.m = new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setGifImage(int i) {
        setGifDecoderImage(getResources().openRawResource(i));
    }

    public void setGifImage(InputStream inputStream) {
        setGifDecoderImage(inputStream);
    }

    public void setGifImage(byte[] bArr) {
        setGifDecoderImage(bArr);
    }

    public void setGifImageType(d dVar) {
        if (this.f8864a == null) {
            this.k = dVar;
        }
    }

    public void setRoundImageBitmap(Bitmap bitmap) {
        if (!this.n) {
            setImageBitmap(bitmap);
            return;
        }
        setBackgroundColor(0);
        this.b = bitmap;
        a(getMeasuredWidth(), getMeasuredHeight());
        invalidate();
    }

    public void setSupportRound(boolean z) {
        this.n = z;
    }
}
