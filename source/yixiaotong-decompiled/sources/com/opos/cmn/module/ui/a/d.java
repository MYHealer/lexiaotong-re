package com.opos.cmn.module.ui.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f6189a;
    private Paint b;
    private boolean c;
    private RectF d;
    private Path e;
    private Path f;
    private a g;
    private PorterDuffColorFilter h;
    private PorterDuffColorFilter i;

    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ColorFilter f6190a;
        public ColorStateList b;
        public ColorStateList c;
        public ColorStateList d;
        public ColorStateList e;
        public PorterDuff.Mode f;
        public float g;
        public int h;
        public float i;

        public a() {
            this.f6190a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = PorterDuff.Mode.SRC_IN;
            this.h = 255;
        }

        public a(a aVar) {
            this.f6190a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = PorterDuff.Mode.SRC_IN;
            this.h = 255;
            this.f6190a = aVar.f6190a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.g = aVar.g;
            this.i = aVar.i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            d dVar = new d(this);
            dVar.c = true;
            return dVar;
        }
    }

    public d() {
        this(new a());
    }

    public d(a aVar) {
        this.f6189a = new Paint(1);
        this.b = new Paint(1);
        this.d = new RectF();
        this.e = new Path();
        this.f = new Path();
        this.g = aVar;
        this.f6189a.setStyle(Paint.Style.FILL);
        this.b.setStyle(Paint.Style.STROKE);
    }

    private static int a(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private boolean a(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.g.b == null || color2 == (colorForState2 = this.g.b.getColorForState(iArr, (color2 = this.f6189a.getColor())))) {
            z = false;
        } else {
            this.f6189a.setColor(colorForState2);
            z = true;
        }
        if (this.g.c == null || color == (colorForState = this.g.c.getColorForState(iArr, (color = this.b.getColor())))) {
            return z;
        }
        this.b.setColor(colorForState);
        return true;
    }

    private boolean d() {
        Paint paint = this.f6189a;
        return ((paint == null || paint.getColor() == 0) && this.h == null) ? false : true;
    }

    private boolean e() {
        Paint paint = this.b;
        return ((paint == null || paint.getStrokeWidth() <= 0.0f || this.b.getColor() == 0) && this.i == null) ? false : true;
    }

    private void f() {
        this.f = g.a(this.f, a(), this.g.i);
    }

    private void g() {
        this.e = g.a(this.e, a(), this.g.i);
    }

    protected RectF a() {
        this.d.set(getBounds());
        return this.d;
    }

    public void a(float f) {
        this.g.i = f;
    }

    public void a(int i) {
        a(ColorStateList.valueOf(i));
    }

    public void a(ColorStateList colorStateList) {
        if (this.g.b != colorStateList) {
            this.g.b = colorStateList;
            onStateChange(getState());
        }
    }

    public ColorStateList b() {
        return this.g.b;
    }

    public void c() {
        this.c = false;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f6189a.setColorFilter(this.h);
        int alpha = this.f6189a.getAlpha();
        this.f6189a.setAlpha(a(alpha, this.g.h));
        this.b.setStrokeWidth(this.g.g);
        this.b.setColorFilter(this.i);
        int alpha2 = this.b.getAlpha();
        this.b.setAlpha(a(alpha2, this.g.h));
        if (this.c) {
            f();
            g();
            this.c = false;
        }
        if (d()) {
            canvas.drawPath(this.e, this.f6189a);
        }
        if (e()) {
            canvas.drawPath(this.f, this.b);
        }
        this.f6189a.setAlpha(alpha);
        this.b.setAlpha(alpha2);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.c = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return super.isStateful() || (this.g.e != null && this.g.e.isStateful()) || ((this.g.d != null && this.g.d.isStateful()) || ((this.g.c != null && this.g.c.isStateful()) || (this.g.b != null && this.g.b.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.g = new a(this.g);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.c = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zA = a(iArr);
        if (zA) {
            invalidateSelf();
        }
        return zA;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.g.h != i) {
            this.g.h = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.g.f6190a != colorFilter) {
            this.g.f6190a = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.g.e = colorStateList;
        PorterDuffColorFilter porterDuffColorFilterA = a(colorStateList, this.g.f);
        this.i = porterDuffColorFilterA;
        this.h = porterDuffColorFilterA;
        c();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.g.f = mode;
        PorterDuffColorFilter porterDuffColorFilterA = a(this.g.e, mode);
        this.i = porterDuffColorFilterA;
        this.h = porterDuffColorFilterA;
        c();
    }
}
