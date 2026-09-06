package com.huawei.hms.scankit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;
import com.huawei.hms.scankit.p.y5;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class ViewfinderView extends View {
    private int[] A;
    private float[] B;
    private Rect C;
    private boolean D;
    Point E;
    private boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f4180a;
    private TextPaint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private c i;
    private String j;
    private int k;
    private float l;
    public int m;
    public int n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private b t;
    private int u;
    private int v;
    private Rect w;
    private int x;
    private ValueAnimator y;
    Paint z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewfinderView.this.m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewfinderView.this.invalidate();
        }
    }

    public enum b {
        NONE(0),
        LINE(1),
        GRID(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4182a;

        b(int i) {
            this.f4182a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(int i) {
            for (b bVar : values()) {
                if (bVar.f4182a == i) {
                    return bVar;
                }
            }
            return LINE;
        }
    }

    public enum c {
        TOP(0),
        BOTTOM(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4183a;

        c(int i) {
            this.f4183a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(int i) {
            for (c cVar : values()) {
                if (cVar.f4183a == i) {
                    return cVar;
                }
            }
            return TOP;
        }
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewfinderView);
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_maskColor, b(context, R.color.scankit_viewfinder_mask));
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_frameColor, b(context, R.color.scankit_viewfinder_frame));
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_cornerColor, b(context, R.color.scankit_viewfinder_corner));
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_laserColor, b(context, R.color.scankit_viewfinder_lasers));
        this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_resultPointColor, b(context, R.color.scankit_viewfinder_result_point_color));
        this.j = typedArrayObtainStyledAttributes.getString(R.styleable.ViewfinderView_scankit_labelText);
        this.k = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_labelTextColor, b(context, R.color.scankit_viewfinder_text_color));
        this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.h = typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.i = c.b(typedArrayObtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_labelTextLocation, 0));
        this.o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_showResultPoint, false);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameWidth, 0);
        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameHeight, 0);
        this.t = b.b(typedArrayObtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_laserStyle, b.LINE.f4182a));
        this.u = typedArrayObtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_gridColumn, 20);
        this.v = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        this.F = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_line_anim, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f4180a = new Paint(1);
        this.b = new TextPaint(1);
        this.x = a(context, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH);
        this.q = getDisplayMetrics().heightPixels;
        this.p = getDisplayMetrics().widthPixels;
    }

    public static int b(Context context, int i) {
        try {
            return context.getColor(i);
        } catch (Resources.NotFoundException unused) {
            Log.e("ViewfinderView", "getColor: Resources.NotFoundException");
            return ViewCompat.MEASURED_SIZE_MASK;
        } catch (Exception unused2) {
            Log.e("ViewfinderView", "getColor: Exception");
            return ViewCompat.MEASURED_SIZE_MASK;
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public void a(y5 y5Var) {
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.pause();
            this.y.removeAllListeners();
            this.y.cancel();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.p = i;
        this.q = i2;
        a();
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.F) {
            canvas.save();
            String str = Build.DEVICE;
            a(canvas, "HWTAH".equals(str) || str.equals("HWTAH-C"));
            canvas.restore();
        }
        a(canvas);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 0;
        this.n = 0;
        this.w = new Rect();
        this.z = new Paint();
        this.A = new int[]{Color.parseColor("#FFFFFFFF"), Color.parseColor("#72FFFFFF"), Color.parseColor("#58FFFFFF"), Color.parseColor("#40FFFFFF"), Color.parseColor("#28FFFFFF"), Color.parseColor("#13FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.B = new float[]{0.0f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
        this.D = true;
        this.F = true;
        a(context, attributeSet);
    }

    private void a(Canvas canvas, boolean z) {
        this.f4180a.setStyle(Paint.Style.FILL);
        this.f4180a.setColor(this.e);
        if (!e.y && !z) {
            Rect rect = this.w;
            rect.left = 0;
            int i = this.m;
            rect.top = i;
            rect.bottom = i + this.x;
            rect.right = this.p;
        } else {
            Rect rect2 = this.w;
            int i2 = this.p / 2;
            rect2.left = i2 - 540;
            int i3 = this.m;
            rect2.top = i3;
            rect2.bottom = i3 + this.x;
            rect2.right = i2 + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON;
        }
        int i4 = this.p / 2;
        float f = i4;
        float f2 = this.w.bottom + 500;
        this.f4180a.setShader(new RadialGradient(f, f2, 690, this.A, this.B, Shader.TileMode.CLAMP));
        this.f4180a.setStrokeWidth(10.0f);
        Rect rect3 = this.w;
        float f3 = rect3.left;
        float f4 = rect3.bottom;
        canvas.drawLine(f3, f4, rect3.right, f4, this.f4180a);
        canvas.clipRect(this.w);
        canvas.drawCircle(f, f2, i4 + 200, this.f4180a);
    }

    public void a() {
        if (e.y) {
            this.n = this.q;
        } else {
            this.n = this.q - a(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE);
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.n - this.x);
        this.y = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.y.setInterpolator(new AccelerateDecelerateInterpolator());
        this.y.setRepeatMode(1);
        this.y.setRepeatCount(-1);
        this.y.addUpdateListener(new a());
        this.y.start();
    }

    public void a(Rect rect, boolean z, Point point) {
        this.D = z;
        this.E = point;
        if (this.C == null) {
            this.C = rect;
            invalidate();
        }
    }

    public static int a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(Canvas canvas) {
        Point point;
        int i;
        int i2;
        int i3;
        if (this.C == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.D) {
            Point point2 = this.E;
            point = new Point(point2.y, point2.x);
        } else {
            Point point3 = this.E;
            point = new Point(point3.x, point3.y);
        }
        int i4 = point.x;
        float f = width / i4;
        int i5 = point.y;
        float f2 = height / i5;
        int i6 = (int) (((double) i5) * 0.1d);
        int i7 = (int) ((((double) i4) * 0.15d) / 2.0d);
        RectF rectF = new RectF();
        if (this.D) {
            if (f > f2) {
                i2 = (int) (point.y * f);
                canvas.translate(0.0f, (height / 2) - (i2 / 2));
                i3 = width;
            } else {
                i = (int) (point.x * f2);
                canvas.translate((width / 2) - (i / 2), 0.0f);
                i3 = i;
                i2 = height;
            }
        } else if (f > f2) {
            i2 = (int) (point.y * f);
            canvas.translate(0.0f, (height / 2) - (i2 / 2));
            i3 = width;
        } else {
            i = (int) (point.x * f2);
            canvas.translate((width / 2) - (i / 2), 0.0f);
            i3 = i;
            i2 = height;
        }
        Rect rect = this.C;
        float f3 = rect.left + i7;
        float f4 = point.x;
        float f5 = (rect.right + i7) / f4;
        float f6 = rect.top + i6;
        float f7 = point.y;
        float f8 = f6 / f7;
        float f9 = (rect.bottom + i6) / f7;
        float f10 = i3;
        float f11 = (f3 / f4) * f10;
        rectF.left = f11;
        float f12 = f5 * f10;
        rectF.right = f12;
        float f13 = i2;
        float f14 = f8 * f13;
        rectF.top = f14;
        float f15 = f9 * f13;
        rectF.bottom = f15;
        float f16 = (f11 + f12) / 2.0f;
        float f17 = (f14 + f15) / 2.0f;
        this.z.setStyle(Paint.Style.FILL);
        this.z.setColor(-1);
        canvas.drawCircle(f16, f17, ((int) (((double) (getDisplayMetrics().density * 24.0f)) + 0.5d)) / 2, this.z);
        this.z.setColor(Color.parseColor("#007DFF"));
        canvas.drawCircle(f16, f17, ((int) (((double) (getDisplayMetrics().density * 22.0f)) + 0.5d)) / 2, this.z);
        if (this.D) {
            if (f > f2) {
                canvas.translate(0.0f, (i2 / 2) - (height / 2));
                return;
            } else {
                canvas.translate((i3 / 2) - (width / 2), 0.0f);
                return;
            }
        }
        if (f > f2) {
            canvas.translate(0.0f, (i2 / 2) - (height / 2));
        } else {
            canvas.translate((i3 / 2) - (width / 2), 0.0f);
        }
    }
}
