package com.adprof.sdk.base.view.gif;

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
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.adprof.sdk.oh;
import com.adprof.sdk.p9;
import com.adprof.sdk.pk;
import com.adprof.sdk.q9;
import com.adprof.sdk.r9;
import com.adprof.sdk.tl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class GifImageView2 extends ImageView implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BitmapShader f134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Matrix f135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p9 f141a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f142a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Thread f143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f144a;
    public final Runnable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f145b;
    public boolean c;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GifImageView2 gifImageView2 = GifImageView2.this;
            gifImageView2.f133a = null;
            gifImageView2.f141a = null;
            gifImageView2.f143a = null;
            gifImageView2.c = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap = GifImageView2.this.f133a;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            GifImageView2 gifImageView2 = GifImageView2.this;
            gifImageView2.setImageBitmap(gifImageView2.f133a);
        }
    }

    public interface c {
        void a();
    }

    public interface d {
        void a();
    }

    public interface e {
        Bitmap a(Bitmap bitmap);
    }

    public GifImageView2(Context context) {
        super(context);
        this.f138a = null;
        this.f139a = null;
        this.f140a = null;
        this.f132a = -1L;
        this.f137a = new Handler(Looper.getMainLooper());
        this.f142a = new a();
        this.b = new b();
        this.f1085a = 20;
        a();
    }

    public GifImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f138a = null;
        this.f139a = null;
        this.f140a = null;
        this.f132a = -1L;
        this.f137a = new Handler(Looper.getMainLooper());
        this.f142a = new a();
        this.b = new b();
        this.f1085a = 20;
        a();
    }

    public final Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            return bitmap;
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        if (width > 0 && height > 0) {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, width, height);
                drawable.draw(canvas);
                return bitmapCreateBitmap;
            } catch (Throwable th) {
                pk.a("GifDecoderView", "drawableToBitmap error: ", th);
            }
        }
        return null;
    }

    public final void a() {
        this.f135a = new Matrix();
        Paint paint = new Paint();
        this.f136a = paint;
        paint.setAntiAlias(true);
    }

    public void c() {
        this.f144a = false;
        Thread thread = this.f143a;
        if (thread != null) {
            thread.interrupt();
            this.f143a = null;
        }
    }

    public int getFrameCount() {
        return this.f141a.f556a.c;
    }

    public long getFramesDisplayDuration() {
        return this.f132a;
    }

    public int getGifHeight() {
        return this.f141a.f556a.e;
    }

    public int getGifWidth() {
        return this.f141a.f556a.h;
    }

    public d getOnAnimationStop() {
        return this.f139a;
    }

    public e getOnFrameAvailable() {
        return this.f140a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f144a = false;
        this.f145b = false;
        this.c = true;
        c();
        this.f137a.post(this.f142a);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        try {
            Bitmap bitmapA = a(getDrawable());
            if (bitmapA == null || bitmapA.isRecycled() || bitmapA.isRecycled()) {
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f134a = new BitmapShader(bitmapA, tileMode, tileMode);
            float fMax = (bitmapA.getWidth() == getWidth() && bitmapA.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
            this.f135a.setScale(fMax, fMax);
            this.f134a.setLocalMatrix(this.f135a);
            this.f136a.setShader(this.f134a);
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            float f = this.f1085a;
            canvas.drawRoundRect(rectF, f, f, this.f136a);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        long jNanoTime;
        int i;
        c cVar = this.f138a;
        if (cVar != null) {
            cVar.a();
        }
        do {
            if (!this.f144a && !this.f145b) {
                break;
            }
            p9 p9Var = this.f141a;
            r9 r9Var = p9Var.f556a;
            int i2 = r9Var.c;
            int i3 = -1;
            if (i2 <= 0) {
                z = false;
            } else {
                int i4 = p9Var.c;
                z = true;
                if (i4 == i2 - 1) {
                    p9Var.d++;
                }
                int i5 = r9Var.f;
                if (i5 == -1 || p9Var.d <= i5) {
                    p9Var.c = (i4 + 1) % i2;
                } else {
                    z = false;
                }
            }
            try {
                long jNanoTime2 = System.nanoTime();
                Bitmap bitmapB = this.f141a.b();
                this.f133a = bitmapB;
                e eVar = this.f140a;
                if (eVar != null) {
                    this.f133a = eVar.a(bitmapB);
                }
                jNanoTime = (System.nanoTime() - jNanoTime2) / 1000000;
                try {
                    this.f137a.post(this.b);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused2) {
                jNanoTime = 0;
            }
            this.f145b = false;
            if (!this.f144a || !z) {
                this.f144a = false;
                break;
            }
            try {
                p9 p9Var2 = this.f141a;
                r9 r9Var2 = p9Var2.f556a;
                int i6 = r9Var2.c;
                if (i6 <= 0 || (i = p9Var2.c) < 0) {
                    i3 = 0;
                } else if (i >= 0 && i < i6) {
                    i3 = ((q9) r9Var2.f700a.get(i)).b;
                }
                int i7 = (int) (((long) i3) - jNanoTime);
                if (i7 > 0) {
                    long j = this.f132a;
                    if (j <= 0) {
                        j = i7;
                    }
                    Thread.sleep(j);
                }
            } catch (InterruptedException unused3) {
            }
        } while (this.f144a);
        if (this.c) {
            this.f137a.post(this.f142a);
        }
        this.f143a = null;
        d dVar = this.f139a;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setBorderRadius(int i) {
        this.f1085a = i;
    }

    public void setBytes(byte[] bArr) {
        p9 p9Var = new p9(new tl());
        this.f141a = p9Var;
        try {
            p9Var.a(bArr);
            boolean z = this.f144a;
            if (z) {
                b();
                return;
            }
            p9 p9Var2 = this.f141a;
            if (p9Var2.c != 0 && -1 < p9Var2.f556a.c) {
                p9Var2.c = -1;
                if (z) {
                    return;
                }
                this.f145b = true;
                b();
            }
        } catch (Throwable th) {
            this.f141a = null;
            pk.b("GifImageView2 setBytes error: ", th);
        }
    }

    public void setFramesDisplayDuration(long j) {
        this.f132a = j;
    }

    public void setOnAnimationStart(c cVar) {
        this.f138a = cVar;
    }

    public void setOnAnimationStop(d dVar) {
        this.f139a = dVar;
    }

    public void setOnFrameAvailable(e eVar) {
        this.f140a = eVar;
    }

    public final void b() {
        if ((this.f144a || this.f145b) && this.f141a != null && this.f143a == null) {
            Thread thread = new Thread(this);
            this.f143a = thread;
            thread.start();
        }
    }
}
