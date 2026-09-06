package com.adprof.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class xc extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Bitmap f1522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f837a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f838a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f840a;

    public xc(Context context, int i) {
        super(context);
        this.f839a = new Paint(3);
        this.f840a = new Rect();
        this.f838a = i;
        a();
    }

    public static Bitmap a(Context context) {
        Bitmap bitmap;
        Bitmap bitmap2 = f1522a;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            return f1522a;
        }
        synchronized (f837a) {
            Bitmap bitmap3 = f1522a;
            if (bitmap3 == null || bitmap3.isRecycled()) {
                try {
                    f1522a = BitmapFactory.decodeResource(StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources(), R.drawable.adprof_bubblee);
                } catch (Throwable th) {
                    pk.a(th);
                }
                bitmap = f1522a;
            } else {
                bitmap = f1522a;
            }
            throw th;
        }
        return bitmap;
    }

    public final void a() {
        setClickable(true);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            Bitmap bitmapA = a(getContext());
            if (bitmapA != null && !bitmapA.isRecycled() && !this.f840a.isEmpty()) {
                canvas.drawBitmap(bitmapA, (Rect) null, this.f840a, this.f839a);
            }
        } catch (Exception e) {
            pk.a(e);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        try {
            int i3 = this.f838a;
            if (i3 > 0) {
                int iMax = Math.max(1, i3);
                setMeasuredDimension(iMax, iMax);
            } else {
                super.onMeasure(i, i2);
            }
        } catch (Throwable th) {
            pk.a(th);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f840a.set(0, 0, i, i2);
    }
}
