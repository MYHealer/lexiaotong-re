package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h extends View {
    long A;
    HandlerThread B;
    WindowManager C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f8823a;
    private List<b> b;
    private Random c;
    private long d;
    private int e;
    private int f;
    private SoftReference<Bitmap> g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Matrix m;
    boolean n;
    private long o;
    boolean p;
    final ArrayList<Integer> q;
    private int r;
    int s;
    int t;
    private long u;
    private c v;
    private int w;
    private Handler x;
    boolean y;
    boolean z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            if (hVar.p || hVar.g == null || h.this.g.get() == null || h.this.h == 0) {
                return;
            }
            h.this.postInvalidate();
            if (h.this.j == 0) {
                h hVar2 = h.this;
                hVar2.j = hVar2.getMeasuredWidth();
                h hVar3 = h.this;
                hVar3.k = hVar3.getMeasuredHeight();
                h hVar4 = h.this;
                hVar4.l = Math.min(hVar4.j, h.this.k);
            }
            int i = 0;
            if (h.this.j != 0) {
                int i2 = 0;
                while (i < h.this.b.size()) {
                    b bVar = (b) h.this.b.get(i);
                    if (bVar.c() > h.this.k) {
                        if (h.this.c()) {
                            bVar.f = true;
                        } else {
                            h hVar5 = h.this;
                            if (!hVar5.z) {
                                hVar5.b(bVar);
                            }
                        }
                    }
                    if (!h.this.z) {
                        bVar.b(bVar.c() + bVar.c);
                    }
                    if (bVar.f) {
                        i2++;
                    }
                    i++;
                }
                h hVar6 = h.this;
                if (!hVar6.z && !hVar6.c()) {
                    h.this.a();
                }
                i = i2;
            }
            if (h.this.b.size() != 0 && i == h.this.b.size()) {
                return;
            }
            h.this.x.postDelayed(this, h.this.w);
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8825a;
        private int b;
        private int c;
        private float d;
        private boolean e;
        private boolean f = false;
        private int g;

        public b(int i) {
            this.d = 4.0f;
            this.e = false;
            this.g = i;
            float f = (float) ((((double) ((h.this.l * 1.0f) / h.this.r)) * 0.8d) / ((double) h.this.h));
            this.d = f;
            this.d = (float) (((double) f) - ((((double) h.this.c.nextInt(3)) * 0.1d) - 0.1d));
            this.e = true;
        }

        public int a() {
            return (int) (h.this.h * this.d);
        }

        public void a(int i) {
            this.g = i;
        }

        public int b() {
            return this.g;
        }

        public void b(int i) {
            this.b = i;
        }

        public int c() {
            return this.b;
        }
    }

    public interface c {
        void a();
    }

    public h(Context context) {
        super(context);
        this.c = new Random();
        this.d = 0L;
        this.e = 0;
        this.f = 12;
        this.m = new Matrix();
        this.q = new ArrayList<>();
        this.r = 3;
        this.t = -1;
        this.w = 16;
        this.y = false;
        this.z = false;
        this.A = 0L;
        this.B = new HandlerThread("JoyfulDraw");
        this.C = null;
        this.C = (WindowManager) getContext().getSystemService("window");
        setWillNotDraw(true);
        this.b = new ArrayList();
        this.f8823a = new Paint(1);
        this.u = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (System.currentTimeMillis() - this.o >= 350 && this.b.size() < this.f) {
            this.o = System.currentTimeMillis();
            int randomStage = getRandomStage();
            if (this.t == randomStage) {
                randomStage = getRandomStage();
            }
            b bVar = new b(randomStage);
            a(bVar);
            this.b.add(bVar);
            this.t = randomStage;
        }
    }

    private void a(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            int i = this.j / this.r;
            int iB = (bVar.b() * i) + this.c.nextInt(i);
            if (iB < 0) {
                iB = 0;
            }
            int iA = bVar.a() + iB;
            int i2 = this.j;
            if (iA > i2) {
                iB = i2 - bVar.a();
            }
            if (bVar.a() + iB > (bVar.b() + 1) * i) {
                iB = ((bVar.b() + 1) * i) - bVar.a();
            }
            bVar.f8825a = iB;
            bVar.b = bVar.a() * (-1);
            bVar.c = Math.max(this.c.nextInt(16), 13);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(int i, int i2) {
        if (!this.n) {
            return false;
        }
        int size = this.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.b.get(i3);
            if (new Rect(bVar.f8825a, bVar.b, bVar.f8825a + bVar.a(), bVar.b + bVar.a()).contains(i, i2)) {
                c cVar = this.v;
                if (cVar == null) {
                    return true;
                }
                cVar.a();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        if (System.currentTimeMillis() - this.o >= 350 && this.b.size() >= this.f) {
            this.o = System.currentTimeMillis();
            int randomStage = bVar.g;
            if (this.t == randomStage) {
                randomStage = getRandomStage();
            }
            bVar.a(randomStage);
            a(bVar);
            this.t = randomStage;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (!this.y && (this.d <= 0 || System.currentTimeMillis() - this.u <= this.d)) {
            return false;
        }
        this.y = true;
        return true;
    }

    private void d() {
        int iMin;
        try {
            if (this.C == null) {
                this.C = (WindowManager) getContext().getSystemService("window");
            }
            int orientation = this.C.getDefaultDisplay().getOrientation();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                if (viewGroup.getWidth() != 0) {
                    measuredWidth = viewGroup.getWidth();
                }
                if (viewGroup.getHeight() != 0) {
                    measuredHeight = viewGroup.getHeight();
                }
            }
            if (orientation == 1 || orientation == 3) {
                this.j = Math.max(measuredWidth, measuredHeight);
                iMin = Math.min(measuredWidth, measuredHeight);
            } else {
                this.j = Math.min(measuredWidth, measuredHeight);
                iMin = Math.max(measuredWidth, measuredHeight);
            }
            this.k = iMin;
            this.l = Math.min(this.j, iMin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getRandomStage() {
        if (this.t == -1) {
            Collections.shuffle(this.q);
        }
        if (this.s >= this.r) {
            this.s = 0;
            Collections.shuffle(this.q);
        }
        ArrayList<Integer> arrayList = this.q;
        int i = this.s;
        this.s = i + 1;
        return arrayList.get(i).intValue();
    }

    public void b() {
        this.p = true;
        try {
            HandlerThread handlerThread = this.B;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.B = null;
            }
            this.x = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void e() {
        setWillNotDraw(false);
        this.u = System.currentTimeMillis();
        a aVar = new a();
        this.B.start();
        Handler handler = new Handler(this.B.getLooper());
        this.x = handler;
        handler.postDelayed(aVar, this.w);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.b.size(); i++) {
            try {
                b bVar = this.b.get(i);
                if (!bVar.f && this.g.get() != null && !this.g.get().isRecycled()) {
                    this.m.setScale(bVar.d, bVar.d);
                    this.m.postTranslate(bVar.f8825a, bVar.b);
                    canvas.drawBitmap(this.g.get(), this.m, this.f8823a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
        int i3 = this.j;
        int i4 = this.k;
        if (i3 * i4 != 0) {
            setMeasuredDimension(i3, i4);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.n) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            return a((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            this.z = true;
            this.A = System.currentTimeMillis();
            return;
        }
        this.z = false;
        if (0 != this.A) {
            this.u += System.currentTimeMillis() - this.A;
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.n = z;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            return;
        }
        this.d = ((long) i) * 1000;
    }

    public void setItemClickListener(c cVar) {
        this.v = cVar;
    }

    public void setMaxStage(int i) {
        this.r = i;
        this.q.clear();
        for (int i2 = 0; i2 < i; i2++) {
            this.q.add(Integer.valueOf(i2));
        }
    }

    public void setResource(int i) {
        SoftReference<Bitmap> softReference;
        if (i != 2) {
            softReference = i != 3 ? new SoftReference<>(q.a(getContext(), "ubix/joy_default.webp")) : new SoftReference<>(q.a(getContext(), "ubix/joy_double_eleven.webp"));
        } else {
            softReference = new SoftReference<>(q.a(getContext(), "ubix/joy_six_one_eight.webp"));
        }
        this.g = softReference;
        if (this.g.get() != null) {
            this.h = this.g.get().getWidth();
            this.i = this.g.get().getHeight();
        }
    }

    public void setResource(String str) {
        try {
            com.ubix.ssp.ad.e.v.e.b().c(str);
            SoftReference<Bitmap> softReference = new SoftReference<>(com.ubix.ssp.ad.e.v.e.b().b(str));
            this.g = softReference;
            if (softReference.get() != null) {
                this.h = this.g.get().getWidth();
                this.i = this.g.get().getHeight();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
