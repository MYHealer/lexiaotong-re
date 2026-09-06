package com.opos.exoplayer.a;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.f.j;
import com.opos.exoplayer.core.g.f;
import com.opos.exoplayer.core.g.g;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.ApicFrame;
import com.opos.exoplayer.core.q;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6228a;
    private final com.opos.exoplayer.a.a b;
    private View c;
    private final b d;
    private final View e;
    private final ImageView f;
    private final d g;
    private final com.opos.exoplayer.a.b h;
    private final FrameLayout i;
    private q j;
    private boolean k;
    private boolean l;
    private Bitmap m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;

    static /* synthetic */ class a {
    }

    private final class b extends q.a implements View.OnLayoutChangeListener, j, com.opos.exoplayer.core.video.e {
        private b() {
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a() {
            if (c.this.e != null) {
                c.this.e.setVisibility(4);
            }
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a(int i, int i2, int i3, float f) {
            if (c.this.b == null) {
                return;
            }
            float f2 = (i2 == 0 || i == 0) ? 1.0f : (i * f) / i2;
            if (c.this.c instanceof TextureView) {
                if (i3 == 90 || i3 == 270) {
                    f2 = 1.0f / f2;
                }
                if (c.this.r != 0) {
                    c.this.c.removeOnLayoutChangeListener(this);
                }
                c.this.r = i3;
                if (c.this.r != 0) {
                    c.this.c.addOnLayoutChangeListener(this);
                }
                c.b((TextureView) c.this.c, c.this.r);
            }
            c.this.b.a(f2);
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(m mVar, g gVar) {
            c.this.e();
        }

        @Override // com.opos.exoplayer.core.f.j
        public void a(List<com.opos.exoplayer.core.f.b> list) {
            if (c.this.g != null) {
                c.this.g.a(list);
            }
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(boolean z, int i) {
            if (c.this.d() && c.this.p) {
                c.this.a();
            } else {
                c.this.b(false);
            }
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void b(int i) {
            if (c.this.d() && c.this.p) {
                c.this.a();
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            c.b((TextureView) view, c.this.r);
        }
    }

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6228a = 2;
        a aVar = null;
        if (isInEditMode()) {
            this.b = null;
            this.d = null;
            this.c = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            ImageView imageView = new ImageView(context);
            if (y.f6517a >= 23) {
                a(getResources(), imageView);
            } else {
                b(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        this.d = new b(this, aVar);
        setDescendantFocusability(262144);
        com.opos.exoplayer.a.a aVar2 = new com.opos.exoplayer.a.a(context);
        this.b = aVar2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(aVar2, layoutParams);
        a(aVar2, 0);
        View view = new View(context);
        this.e = view;
        view.setBackgroundColor(-16777216);
        aVar2.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (this.f6228a != 0) {
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            View textureView = this.f6228a == 2 ? new TextureView(context) : new SurfaceView(context);
            this.c = textureView;
            textureView.setLayoutParams(layoutParams2);
            aVar2.addView(this.c, 0);
        } else {
            this.c = null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.i = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(context);
        this.f = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        aVar2.addView(imageView2, new FrameLayout.LayoutParams(-1, -1));
        this.l = true;
        d dVar = new d(context);
        this.g = dVar;
        aVar2.addView(dVar, new FrameLayout.LayoutParams(-1, -1));
        dVar.b();
        dVar.a();
        View view2 = new View(context);
        addView(view2, new FrameLayout.LayoutParams(-1, -1));
        com.opos.exoplayer.a.b bVar = new com.opos.exoplayer.a.b(context, null, 0, attributeSet);
        this.h = bVar;
        bVar.setLayoutParams(view2.getLayoutParams());
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        int iIndexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeView(view2);
        viewGroup.addView(bVar, iIndexOfChild);
        this.n = this.n;
        this.q = true;
        this.o = true;
        this.p = true;
        this.k = true;
        a();
    }

    private static void a(Resources resources, ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#FFF4F3F0"));
    }

    private static void a(com.opos.exoplayer.a.a aVar, int i) {
        aVar.a(i);
    }

    private boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                com.opos.exoplayer.a.a aVar = this.b;
                if (aVar != null) {
                    aVar.a(width / height);
                }
                this.f.setImageBitmap(bitmap);
                this.f.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private boolean a(Metadata metadata) {
        for (int i = 0; i < metadata.a(); i++) {
            Metadata.Entry entryA = metadata.a(i);
            if (entryA instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) entryA).d;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        return false;
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#FFF4F3F0"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TextureView textureView, int i) {
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width == 0.0f || height == 0.0f || i == 0) {
            textureView.setTransform(null);
            return;
        }
        Matrix matrix = new Matrix();
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        matrix.postRotate(i, f, f2);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        textureView.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!(d() && this.p) && this.k) {
            boolean z2 = this.h.d() && this.h.a() <= 0;
            boolean zC = c();
            if (z || z2 || zC) {
                c(zC);
            }
            if (z || zC) {
                c(zC);
            }
        }
    }

    private void c(boolean z) {
        if (this.k) {
            this.h.a(z ? 0 : this.n);
            this.h.b();
        }
    }

    private boolean c() {
        q qVar = this.j;
        if (qVar == null) {
            return true;
        }
        int iC = qVar.c();
        return this.o && (iC == 1 || iC == 4 || !this.j.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        q qVar = this.j;
        return qVar != null && qVar.o() && this.j.d();
    }

    private boolean d(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        q qVar = this.j;
        if (qVar == null) {
            return;
        }
        g gVarG = qVar.g();
        for (int i = 0; i < gVarG.f6474a; i++) {
            if (this.j.b(i) == 2 && gVarG.a(i) != null) {
                f();
                return;
            }
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.l) {
            for (int i2 = 0; i2 < gVarG.f6474a; i2++) {
                f fVarA = gVarG.a(i2);
                if (fVarA != null) {
                    for (int i3 = 0; i3 < fVarA.e(); i3++) {
                        Metadata metadata = fVarA.a(i3).d;
                        if (metadata != null && a(metadata)) {
                            return;
                        }
                    }
                }
            }
            if (a(this.m)) {
                return;
            }
        }
        f();
    }

    private void f() {
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f.setVisibility(4);
        }
    }

    public void a() {
        com.opos.exoplayer.a.b bVar = this.h;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void a(int i) {
        if (this.f6228a == i || this.j == null || this.b == null) {
            return;
        }
        View view = this.c;
        this.f6228a = i;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View surfaceView = this.f6228a == 1 ? new SurfaceView(getContext()) : new TextureView(getContext());
        this.c = surfaceView;
        surfaceView.setLayoutParams(layoutParams);
        q.d dVarA = this.j.a();
        if (dVarA != null) {
            if (view != null) {
                this.b.removeView(view);
                if (view instanceof TextureView) {
                    dVarA.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    dVarA.b((SurfaceView) view);
                }
            }
            View view2 = this.c;
            if (view2 != null) {
                this.b.addView(view2, 0);
                View view3 = this.c;
                if (view3 instanceof TextureView) {
                    dVarA.a((TextureView) view3);
                } else if (view3 instanceof SurfaceView) {
                    dVarA.a((SurfaceView) view3);
                }
            }
        }
    }

    public void a(q qVar) {
        q qVar2 = this.j;
        if (qVar2 == qVar) {
            return;
        }
        if (qVar2 != null) {
            qVar2.b(this.d);
            q.d dVarA = this.j.a();
            if (dVarA != null) {
                dVarA.b(this.d);
                View view = this.c;
                if (view instanceof TextureView) {
                    dVarA.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    dVarA.b((SurfaceView) view);
                }
            }
            q.c cVarB = this.j.b();
            if (cVarB != null) {
                cVarB.b(this.d);
            }
        }
        this.j = qVar;
        if (this.k) {
            this.h.a(qVar);
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        d dVar = this.g;
        if (dVar != null) {
            dVar.b(null);
        }
        if (qVar == null) {
            a();
            f();
            return;
        }
        q.d dVarA2 = qVar.a();
        if (dVarA2 != null) {
            View view3 = this.c;
            if (view3 instanceof TextureView) {
                dVarA2.a((TextureView) view3);
            } else if (view3 instanceof SurfaceView) {
                dVarA2.a((SurfaceView) view3);
            }
            dVarA2.a(this.d);
        }
        q.c cVarB2 = qVar.b();
        if (cVarB2 != null) {
            cVarB2.a(this.d);
        }
        qVar.a(this.d);
        b(false);
        e();
    }

    public void a(boolean z) {
        com.opos.exoplayer.a.b bVar;
        q qVar;
        com.opos.exoplayer.core.i.a.b((z && this.h == null) ? false : true);
        if (this.k == z) {
            return;
        }
        this.k = z;
        if (z) {
            bVar = this.h;
            qVar = this.j;
        } else {
            com.opos.exoplayer.a.b bVar2 = this.h;
            if (bVar2 == null) {
                return;
            }
            bVar2.c();
            bVar = this.h;
            qVar = null;
        }
        bVar.a(qVar);
    }

    public boolean a(KeyEvent keyEvent) {
        return this.k && this.h.a(keyEvent);
    }

    public View b() {
        return this.c;
    }

    public void b(int i) {
        com.opos.exoplayer.core.i.a.b(this.b != null);
        this.b.a(i);
    }

    public void c(int i) {
        View view = this.e;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        q qVar = this.j;
        if (qVar != null && qVar.o()) {
            this.i.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = d(keyEvent.getKeyCode()) && this.k && !this.h.d();
        b(true);
        return z || a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.k || this.j == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.h.d()) {
            b(true);
        } else if (this.q) {
            this.h.c();
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.k || this.j == null) {
            return false;
        }
        b(true);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.c;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }
}
